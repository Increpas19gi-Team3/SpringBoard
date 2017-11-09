package controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import dao.WriteDAO;
import dto.BoardDTO;
import dto.UploadFileDTO;
import service.ListService;
import org.springframework.validation.Errors;

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
	
	@RequestMapping(value="/reg.do",method=RequestMethod.POST)
	public String reg(@Valid @ModelAttribute("icmd") BoardDTO bdto,Errors errors, Model model) {
		
		System.out.println("여기 들어오니?");
		//// MultipartFile 파일 객체
		MultipartFile file = bdto.getUpfile();
		String path="C:/images/";
		
		String originalFilename = file.getOriginalFilename();
		String systemFilename = bdto.getWRITER()+"_"+UUID.randomUUID()+"_"+originalFilename;
		
		if (!file.isEmpty()) {
			// 업로드파일객체를 지정한 파일에 복사
			try {
				file.transferTo(new File(path,systemFilename));
				System.out.println(systemFilename + " 업로드완료.");
				UploadFileDTO fileDTO = new UploadFileDTO();
				fileDTO.setOriginalFilename(originalFilename);
				fileDTO.setSystemFilename(systemFilename);
				fileDTO.setFileSize(file.getSize());
				//모델에 fileDTO 추가
				bdto.setIMGNAME(systemFilename);
				model.addAttribute("fileDTO", fileDTO);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(errors.hasErrors()){
			return "boardReg";
		}
		
		WriteDAO wDao = WriteDAO.getInstance();
		wDao.insertWrite(bdto);
						
		return "redirect:index.jsp";
	}

		
	@RequestMapping(value="/pwdCheck.do",method=RequestMethod.POST)
	public String passChk(HttpServletRequest request, Model model) {
		int writeNum = Integer.parseInt(request.getParameter("NUMBER"));
		String pass = request.getParameter("pass");
		
		WriteDAO wDao = WriteDAO.getInstance();
		BoardDTO uptDTO = wDao.selectWrite(writeNum);
		
		if(!pass.equals(uptDTO.getPWD())){
			return "notOK";
		}
		
		model.addAttribute("uptDTO", uptDTO);
		model.addAttribute("number",writeNum);
		
		return "boardUpt";
	}

	
	@RequestMapping(value="/update.do",method=RequestMethod.POST)
	public String upt(@Valid @ModelAttribute("icmd") BoardDTO bdto,Errors errors, Model model) {
		
		WriteDAO wDao = WriteDAO.getInstance();
		BoardDTO preDTO = wDao.selectWrite(bdto.getNUM());
		
		// MultipartFile 파일 객체
		MultipartFile file = bdto.getUpfile();
		String path="C:/images/";
		
		if(bdto.getCONTENTS().isEmpty()){
			bdto.setCONTENTS(preDTO.getCONTENTS());
		}
		
		if(bdto.getPWD().isEmpty()){
			bdto.setCONTENTS(preDTO.getPWD());
		}
		
		if(bdto.getTITLE().isEmpty()){
			bdto.setCONTENTS(preDTO.getTITLE());
		}
		
		if(bdto.getWRITER().isEmpty()){
			bdto.setCONTENTS(preDTO.getWRITER());
		}

		if (!file.isEmpty()) {
			// 업로드파일객체를 지정한 파일에 복사
			try {
				String originalFilename = file.getOriginalFilename();
				String systemFilename = bdto.getWRITER()+"_"+UUID.randomUUID()+"_"+originalFilename;
				
				file.transferTo(new File(path,systemFilename));
				System.out.println(systemFilename + " 업로드완료.");
				UploadFileDTO fileDTO = new UploadFileDTO();
				fileDTO.setOriginalFilename(originalFilename);
				fileDTO.setSystemFilename(systemFilename);
				fileDTO.setFileSize(file.getSize());
				//모델에 fileDTO 추가
				bdto.setIMGNAME(systemFilename);
				model.addAttribute("fileDTO", fileDTO);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			bdto.setIMGNAME(preDTO.getIMGNAME());
		}
		
		if(errors.hasErrors()){
			return "boardReg";
		}
	/*	System.out.println("bdto.getWRITER() >>> "+bdto.getWRITER());
		System.out.println("bdto.getCONTENTS() >>> "+bdto.getCONTENTS());
		System.out.println("bdto.getPWD() >>> "+bdto.getPWD());
		System.out.println("bdto.getTITLE() >>> "+bdto.getTITLE());
		System.out.println("bdto.getNUM() >>> "+bdto.getNUM());
		System.out.println("bdto.getIMGNAME() >>> "+bdto.getIMGNAME());*/
		
		WriteDAO Dao = WriteDAO.getInstance();
		Dao.updateWrite(bdto);
						
		return "redirect:index.jsp";
	}
	
	
	@RequestMapping(value="/delete.do",method=RequestMethod.GET)
	public String reg(HttpServletRequest request, Model model) {
		int writeNum = Integer.parseInt(request.getParameter("NUM"));
		
		WriteDAO wDao = WriteDAO.getInstance();
		wDao.deleteWrite(writeNum);
						
		return "redirect:index.jsp";
	}
}
