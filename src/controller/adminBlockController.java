package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.BlockDAO;
import dto.BoardDTO;

@Controller
public class adminBlockController {

	@Autowired
	BlockDAO adminBlock;

//	@RequestMapping(value = "/block.do", method = RequestMethod.GET)
//	public String getBlock() {
//		System.out.println("get-방식 로그인");
//		return "listView";
//	}
//
//	@RequestMapping(value = "/unblock.do", method = RequestMethod.GET)
//	public String postBlock() {
//		System.out.println("post-방식 로그인");
//		return "listView";
//	}

	@RequestMapping(value = "/block.do", method = RequestMethod.GET)
	public String Block(HttpServletRequest req, HttpServletResponse resp, Model model) {

		System.out.println("▶▶▶▶▶ block 테스트 :"+req.getParameter("NUM"));
		int num = Integer.parseInt(req.getParameter("NUM"));
		
		adminBlock.Block(num);		
		System.out.println("Block 저장");
		//return "redirect:/list.do"; // "boardList";
		return "redirect:/listView.do?no="+num;
	}

	@RequestMapping(value = "/unblock.do", method = RequestMethod.GET)
	public String unBlock(HttpServletRequest req, HttpServletResponse resp, Model model) {

		System.out.println("▶▶▶▶▶ unblock 테스트 :"+req.getParameter("NUM"));
		int num = Integer.parseInt(req.getParameter("NUM"));
		
		adminBlock.unBlock(num);		
		System.out.println("unBlock 저장");
		//return "redirect:/list.do";
		return "redirect:/listView.do?no="+num;
	}
}
