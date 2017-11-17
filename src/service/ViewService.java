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

	@Transactional
	public BoardDTO findBySeqBoard(int writeNum) {
		vDao.updateHitCount(writeNum); // 글 조회수 증가
		return vDao.BoardDetailView(writeNum);
	}

	// BoardDetailViewController.java : 'num'으로 보내서 'writeNum'으로 받음
	public BoardDTO BoardDetail(int writeNum) {
		return vDao.BoardDetailView(writeNum);
	}

}
