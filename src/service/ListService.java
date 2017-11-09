package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ListDAO;
import dto.BoardDTO;



@Service	// 보통 서비스 클래스는 component 보다 service를 많이 붙인다
public class ListService {
	
	@Autowired
	ListDAO listDAO;

	/**
	 * 전체 게시글 목록 가져오기 DAO 활용
	 * @return
	 */
	public List<BoardDTO> getListAll(){
		return listDAO.selectList();		
	}
	
	
	
	public List<BoardDTO> getSetList(String whereColumn, String word, 
			String sortColumn, String orderby, 
			String isBlock){
		return listDAO.selectSetList(whereColumn, word, sortColumn, orderby, isBlock);
	}
}
