package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.ListViewDAO;
import dto.BoardDTO;

/**
 * 상세보기
 * 
 * @author 손대성
 *
 */

@Controller
public class BoardDetailViewController {

	@Autowired
	ListViewDAO listViewDAO;

	@RequestMapping(value = "/listView.do", method = RequestMethod.GET)
	public String GET_BoardDetailView(Model model, HttpServletRequest req, HttpServletResponse resp) {

		System.out.println("상세 페이지(GET)로 들어왔니?");

		int num = Integer.parseInt(req.getParameter("no"));
		BoardDTO bDTO = listViewDAO.BoardDetailView(num);

		model.addAttribute("bDTO", bDTO);

		return "listView";
	}
}
