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
 * 게시판 컨트롤러
 * @author 김지현
 *
 */

@Controller
public class BoardViewController {

	@RequestMapping(value="/reg.do",method=RequestMethod.GET)
	public String form() {
	
		return "boardReg";
	}
}
