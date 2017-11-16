package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.WriteDAO;
import dto.BoardDTO;



@Service
public class WriteService {

	@Autowired
	WriteDAO wDao;
	
	@Transactional
	public void insertWrt(BoardDTO bdto){
		wDao.insert(bdto);
		
	}
/*	
	public BoardDTO selectWrt(int writeNum){
		
		return wDao.selectWrite(writeNum);
	}
	
	public void updateWrt(BoardDTO bdto){
		
		wDao.updateWrite(bdto);
	}

	public void deleteWrt(int writeNum){
		
		wDao.deleteWrite(writeNum);
	}*/
}
