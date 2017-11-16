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
	
	
	@RequestMapping(value="/list.do", method=RequestMethod.GET)
	public String getList(Model model, HttpServletRequest req, HttpServletResponse resp){
		
		//검색, 정렬, 페이징 정보도 받아와야 함.
		System.out.println("▶▶▶ list.do : GET");
		// 블록글 여부
		
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
		String isBlock = NullToBlank.doChange(req.getParameter("listGubun"));
		System.out.println("listGubun="+isBlock);
		model.addAttribute("listGubun", isBlock);
		
		
		//페이징  처리
		
		
		
		
		List<BoardDTO> list = listService.getSetList(whereColumn, word, sortColumn, orderby, isBlock);				
		model.addAttribute("list", list);
		
		//System.out.println("ip getRemoteAddr:" + req.getRemoteAddr());
		//System.out.println("ip getRemoteHost:" + req.getRemoteHost());

		
		
		return "/boardList";
	}
	
	@RequestMapping(value="/search.do", method=RequestMethod.POST)
	public String search(Model model, HttpServletRequest req, HttpServletResponse resp){
		
		//검색, 정렬, 페이징 정보도 받아와야 함.
		System.out.println("▶▶▶ search.do : POST");
		// 블록글 여부
		
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
		String isBlock = NullToBlank.doChange(req.getParameter("listGubun"));
		System.out.println("listGubun="+isBlock);
		model.addAttribute("listGubun", isBlock);
		
		
		//페이징  처리
		
		
		
		List<BoardDTO> list = listService.getSetList(whereColumn, word, sortColumn, orderby, isBlock);				
		model.addAttribute("list", list);
		
		return "/boardList";
	}
	
	
}
