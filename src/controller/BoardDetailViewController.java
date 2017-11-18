package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.ListViewDAO;
import dto.BoardDTO;
import service.ViewService;
import service.WriteService;

/**
 * 상세보기
 * 
 * @author 손대성
 *
 */

@Controller
public class BoardDetailViewController {

	@Autowired	//객체 주입
	ViewService viewService;

	@RequestMapping(value = "/listView.do", method = RequestMethod.GET)
	public String GET_BoardDetailView(Model model, HttpServletRequest req, HttpServletResponse resp) {

		System.out.println("'상세페이지'와 '조회수'를 증가시키는 과정입니다.");

		int num = Integer.parseInt(req.getParameter("no"));
		
		// 상세글 보기
		BoardDTO bDTO = viewService.BoardDetail(num);
		model.addAttribute("bDTO", bDTO);
		
		// 답글 보기
		List<BoardDTO> replylistBDTO = viewService.BoardDetailReply(num);
		model.addAttribute("replylistBDTO", replylistBDTO);

		return "listView";
	}
	
}
