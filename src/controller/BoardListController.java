package controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public String getList(Model model){
		
		//검색, 정렬, 페이징 정보도 받아와야 함.
		System.out.println("검색 / 정렬 / 페이징 처리 예정");
		
		// = new ListService();
		List<BoardDTO> list = listService.selectList();
		model.addAttribute("list", list);
		
		return "/boardList";
	}
}
