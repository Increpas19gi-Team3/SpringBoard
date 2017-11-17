package controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import dto.BoardDTO;
import dto.UploadFileDTO;
import service.WriteService;

/**
 * 게시판 컨트롤러
 * @author 김지현, 손대성
 *
 */

@Controller
public class BoardInsertReplyActionCommandController {

	@Autowired	//객체 주입
	WriteService writeService;
	
	@RequestMapping(value="/reply.do", method=RequestMethod.GET)
	public String form() {
		System.out.println("BoardInsertReplyActionCommandController >> reply.do >> GET");
		return "boardReg";
	}
	
	// icmd = BoardDTO bdto ; 'icmd'라고 칭하겠다~!!
//	@RequestMapping(value="/reply.do", method=RequestMethod.POST)
//	public String reg(@Valid @ModelAttribute("icmd") BoardDTO bdto, Errors errors, Model model) {
//		
//		System.out.println("여기 들어오니?");
		// MultipartFile 파일 객체
//		MultipartFile file = bdto.getUpfile();
//		String path="C:/images/";
//		
//		String originalFilename = file.getOriginalFilename();
//		String systemFilename = bdto.getWRITER()+"_"+UUID.randomUUID()+"_"+originalFilename;
//		
//		if (!file.isEmpty()) {
//			// 업로드파일객체를 지정한 파일에 복사
//			try {
//				file.transferTo(new File(path,systemFilename));
//				System.out.println(systemFilename + " 업로드완료.");
//				UploadFileDTO fileDTO = new UploadFileDTO();
//				fileDTO.setOriginalFilename(originalFilename);
//				fileDTO.setSystemFilename(systemFilename);
//				fileDTO.setFileSize(file.getSize());
//				//모델에 fileDTO 추가
//				bdto.setIMGNAME(systemFilename);
//				model.addAttribute("fileDTO", fileDTO);
//			} catch (IllegalStateException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		
//		if(errors.hasErrors()){
//			return "boardReg";
//		}
//		
//		writeService.insertWrt(bdto);						
//		return "redirect:index.jsp";
//	}


//	@RequestMapping(value="/pwdCheck.do",method=RequestMethod.POST)
//	public String passChk(HttpServletRequest request, Model model) {
//		int writeNum = Integer.parseInt(request.getParameter("NUMBER"));
//		String pass = request.getParameter("pass");
//		
//		BoardDTO uptDTO = writeService.selectWrt(writeNum);
//		
//		if(!pass.equals(uptDTO.getPWD())){
//			return "notOK";
//		}
//		
//		model.addAttribute("uptDTO", uptDTO);
//		model.addAttribute("number",writeNum);
//		
//		return "boardUpt";
//	}
			
//	@RequestMapping(value="/update.do",method=RequestMethod.POST)
//	public String upt(@Valid @ModelAttribute("icmd") BoardDTO bdto,Errors errors, Model model) {
//		System.out.println("update 들어왓음");
//		BoardDTO preDTO = writeService.selectWrt(bdto.getNUM());
//		
//		// MultipartFile 파일 객체
//		MultipartFile file = bdto.getUpfile();
//		String path="C:/images/";
//		
//		if(bdto.getCONTENTS().isEmpty()){
//			bdto.setCONTENTS(preDTO.getCONTENTS());
//		}
//		
//		if(bdto.getPWD().isEmpty()){
//			bdto.setCONTENTS(preDTO.getPWD());
//		}
//		
//		if(bdto.getTITLE().isEmpty()){
//			bdto.setCONTENTS(preDTO.getTITLE());
//		}
//		
//		if(bdto.getWRITER().isEmpty()){
//			bdto.setCONTENTS(preDTO.getWRITER());
//		}
//
//		if (!file.isEmpty()) {
//			// 업로드파일객체를 지정한 파일에 복사
//			try {
//				String originalFilename = file.getOriginalFilename();
//				String systemFilename = bdto.getWRITER()+"_"+UUID.randomUUID()+"_"+originalFilename;
//				
//				file.transferTo(new File(path,systemFilename));
//				System.out.println(systemFilename + " 업로드완료.");
//				UploadFileDTO fileDTO = new UploadFileDTO();
//				fileDTO.setOriginalFilename(originalFilename);
//				fileDTO.setSystemFilename(systemFilename);
//				fileDTO.setFileSize(file.getSize());
//				//모델에 fileDTO 추가
//				bdto.setIMGNAME(systemFilename);
//				model.addAttribute("fileDTO", fileDTO);
//			} catch (IllegalStateException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}else{
//			bdto.setIMGNAME(preDTO.getIMGNAME());
//		}
//		
//		if(errors.hasErrors()){
//			return "boardReg";
//		}
//		System.out.println("bdto.getWRITER() >>> "+bdto.getWRITER());
//		System.out.println("bdto.getCONTENTS() >>> "+bdto.getCONTENTS());
//		System.out.println("bdto.getPWD() >>> "+bdto.getPWD());
//		System.out.println("bdto.getTITLE() >>> "+bdto.getTITLE());
//		System.out.println("bdto.getNUM() >>> "+bdto.getNUM());
//		System.out.println("bdto.getIMGNAME() >>> "+bdto.getIMGNAME());
//		
//		writeService.updatetWrt(bdto);
//						
//		return "redirect:index.jsp";
//	}
//	
//	@RequestMapping(value="/delete.do",method=RequestMethod.GET)
//	public String reg(HttpServletRequest request, Model model) {
//		int writeNum = Integer.parseInt(request.getParameter("NUM"));
//		
//		writeService.deletetWrt(writeNum);
//						
//		return "redirect:index.jsp";
//	}
}
