package service;

import java.util.List;

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
	/**
	 * 상세글 보기
	 * @param writeNum
	 * @return
	 */
	@Transactional
	public BoardDTO BoardDetail(int writeNum) {
		vDao.updateHitCount(writeNum); // 글 조회수 증가
		return vDao.BoardDetailView(writeNum);
	}
	
	
	/**
	 * 답글 보기
	 * @param writeNum
	 * @return
	 */
	public List<BoardDTO> BoardDetailReply(int writeNum) {
		return vDao.BoardDetailViewReply(writeNum);
	}
}
