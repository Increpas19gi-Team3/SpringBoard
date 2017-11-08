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
		System.out.println("검색 / 정렬 / 페이징 처리 예정");
		

		List<BoardDTO> list = listService.getList();
		model.addAttribute("list", list);
		
		//System.out.println("ip getRemoteAddr:" + req.getRemoteAddr());
		//System.out.println("ip getRemoteHost:" + req.getRemoteHost());

		
		return "/boardList";
	}
}
