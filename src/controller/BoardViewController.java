package controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

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
		
		
		WriteDAO wDao = WriteDAO.getInstance();
		wDao.insertWrite(bdto);
		
		if(errors.hasErrors()){
			return "boardReg";
		}
						
		return "boardReg2";
	}
}
