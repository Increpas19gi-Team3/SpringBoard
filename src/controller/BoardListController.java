package controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dto.BoardDTO;
import dto.ListDTOListModel;
import service.ListService;
import util.NullToBlank;

/**
 * 게시판 리스트 컨트롤러
 * @author 손가연
 *
 */

@Controller
public class BoardListController {
	
	@Autowired	//객체 주입
	ListService listService;
	
	@RequestMapping(value="/list.do")
	public String getList(Model model, HttpServletRequest req, HttpServletResponse resp){
		
		//검색, 정렬, 페이징 정보도 받아와야 함.
		System.out.println("▶▶▶ list.do");
		
		
		//정렬
		String sortColumn = NullToBlank.doChange(req.getParameter("sortColumn"));
		String orderby = NullToBlank.doChange(req.getParameter("orderby"));
		System.out.println("sortColumn="+sortColumn+", orderby="+orderby);
		model.addAttribute("sortColumn", sortColumn);
		model.addAttribute("orderby", orderby);
		
		//검색
		String whereColumn = NullToBlank.doChange(req.getParameter("whereColumn")); 
		String word = NullToBlank.doChange(req.getParameter("word"));
		System.out.println("whereColumn="+whereColumn+", word="+word);
		model.addAttribute("whereColumn", whereColumn);
		model.addAttribute("word", word);
		
		//글보기 설정
		String isBlock = NullToBlank.doChange(req.getParameter("isBlock"));
		System.out.println("isBlock="+isBlock);
		model.addAttribute("isBlock", isBlock);
		
		
		//페이징  처리
		String cutCount = NullToBlank.doChange(req.getParameter("pageCutCount"));
		int pageCutCount =  cutCount.equals("") ? 0 : Integer.parseInt(cutCount);//표시할 게시글 갯수
		System.out.println("pageCutCount="+pageCutCount);		
		
		String pn = NullToBlank.doChange(req.getParameter("pn"));
		// 최종 모델 : BoardVOListModel, 페이지의 시작과 마지막 번호 // FC 에게 리턴
		int requestPageNumber = pn.equals("") ? 0 : Integer.parseInt(pn);
		System.out.println("pn="+requestPageNumber);
		
		model.addAttribute("pageCutCount", pageCutCount);
		model.addAttribute("pn", requestPageNumber);
		
		
		
		System.out.println("▶▶▶▶▶ getSetList ");
		
		
		List<BoardDTO> list = listService.getSetList(whereColumn, word, sortColumn, orderby, isBlock);
		/*for(int i=0; i<list.size(); i++){
			System.out.println(i+": "+ list.get(i).toString());
		}*/
		
		//ListDTOListModel list = listService.getBoardVOList(pageCutCount, requestPageNumber, whereColumn, word, sortColumn, orderby, isBlock);
		
		
		
						
		model.addAttribute("list", list);
		
		// 페이지 네비게이션바 설정
		/* 
		if (list.getTotalPageCount() > 0) {
			
			// 리스트 화면의 페이지의 시작번호 
			int beginPageNumber = (list.getRequestPage() - 1) / 10 * 10 + 1;
			// 리스트 화면의 페이지의 마지막번호
			int endPageNumber = beginPageNumber + 9;
			if (endPageNumber > list.getTotalPageCount()) {
				endPageNumber = list.getTotalPageCount();
			}
			
			model.addAttribute("beginPage", beginPageNumber);//글 시작페이지
			model.addAttribute("endPage", endPageNumber);
		}
		*/	
		
		return "/boardList";
	}
	
	
}
