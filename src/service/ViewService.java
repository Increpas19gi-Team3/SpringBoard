package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import dao.ListViewDAO;
import dao.WriteDAO;
import dto.BoardDTO;

@Service
public class ViewService {

	@Autowired
	ListViewDAO vDao;

	// BoardDetailViewController.java : 'num'으로 보내서 'writeNum'으로 받음
	@Transactional
	public BoardDTO BoardDetail(int writeNum) {
		vDao.updateHitCount(writeNum); // 글 조회수 증가
		return vDao.BoardDetailView(writeNum);
	}
}
