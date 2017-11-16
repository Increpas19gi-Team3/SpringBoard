package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.ListViewDAO;
import dao.WriteDAO;
import dto.BoardDTO;



@Service
public class ViewService {

	@Autowired
	ListViewDAO vDao;

	public BoardDTO BoardDetail(int writeNum){
		return vDao.BoardDetailView(writeNum);		
	}
}
