package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.ListDAO;
import dto.BoardDTO;
import dto.ListDTOListModel;



@Service	// 보통 서비스 클래스는 component 보다 service를 많이 붙인다
public class ListService {
	
	@Autowired
	ListDAO listDAO;
	
	@Autowired
	ListDTOListModel listDTOListModel;

	/**
	 * 전체 게시글 목록 가져오기 DAO 활용
	 * @return
	 */

	public List<BoardDTO> getListAll(){		
		System.err.println("▶▶▶▶▶▶▶ ListService : getListAll >> 전체 검색 들어옴");		

		return listDAO.selectList();		
	}
	
	
	public List<BoardDTO> getSetList(String whereColumn, String word, 
			String sortColumn, String orderby, 
			String isBlock){
		
		System.err.println("▶▶▶▶ ListService : getSetList >> 조건 검색 들어옴");
		
		listDTOListModel.setWhereColumn(whereColumn);
		listDTOListModel.setWord(word);
		listDTOListModel.setSortColumn(sortColumn);
		listDTOListModel.setOrderby(orderby);
		listDTOListModel.setIsBlock(isBlock);
		
		return listDAO.selectSetList(listDTOListModel);
	}
}
