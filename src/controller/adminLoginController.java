package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import dao.AdminLoginDAO;
import dto.AdminDTO;



@Controller
public class adminLoginController {
	
	@Autowired
	AdminLoginDAO adminLogin;
	
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String getAdminLogin(){		
		System.out.println("get방식 로그인");
		return "/login";
	}	
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String postAdminLogin(HttpServletRequest request, 
			HttpServletResponse responce, Model model){
				
		System.out.println("세션 저장 테스트");
		AdminDTO user = adminLogin.adminList();				
		
		request.getSession().setAttribute("id", user.getID());
		request.getSession().setAttribute("name", user.getNAME());		
		
		return "redirect:/list.do";	// "boardList"; 
	}
	
	@RequestMapping(value="/logout.do", method=RequestMethod.GET)
	public String getAdminLogout(HttpSession session){		
		System.out.println("get 로그인 아웃");
		session.invalidate();
		return "redirect:/list.do";
	}
}
