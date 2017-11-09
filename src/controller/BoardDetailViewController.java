package controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import dao.WriteDAO;
import dto.BoardDTO;
import dto.UploadFileDTO;

/**
 * 게시판 컨트롤러
 * @author 김지현
 *
 */

@Controller
public class BoardDetailViewController {

	@RequestMapping(value="/listView.do",method=RequestMethod.GET)
	public String GET_BoardDetailView() {
	
		return "listView";
	}
	
	@RequestMapping(value="/listView.do",method=RequestMethod.POST)
	public String POST_BoardDetailView(Model model) {
				
		System.out.println("상세 페이지로 들어왔니?");
		
		BoardDTO bDTO = new
		
		
		
		return "listView";		
	}
}
