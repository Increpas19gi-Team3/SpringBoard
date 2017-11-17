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
import dto.ListDTO;



@Service	// 보통 서비스 클래스는 component 보다 service를 많이 붙인다
public class ListService {
	
	@Autowired
	ListDAO listDAO;
	
	@Autowired
	ListDTO listDTO;

	/**
	 * 전체 게시글 목록 가져오기 DAO 활용
	 * @return
	 */
	public List<BoardDTO> getListAll(){
		
		System.err.println("▶▶▶▶ ListService : getListAll >> 들어옴");
		
		
		return listDAO.selectList();		
	}
	
	
	
	public List<BoardDTO> getSetList(String whereColumn, String word, 
			String sortColumn, String orderby, 
			String isBlock){
		
		System.err.println("▶▶▶▶ ListService : getSetList >> 들어옴");
		
		listDTO.setWhereColumn(whereColumn);
		listDTO.setWord(word);
		listDTO.setSortColumn(sortColumn);
		listDTO.setOrderby(orderby);
		listDTO.setIsBlock(isBlock);
		
		return listDAO.selectSetList(listDTO);
	}
}
