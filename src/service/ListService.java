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
	
	/**
	 * 조건 별로 게시글 목록 가져오기
	 * @param whereColumn
	 * @param word
	 * @param sortColumn
	 * @param orderby
	 * @param isBlock
	 * @return
	 */
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
	
	
	/*
	public ListDTOListModel getBoardVOList(int pageCutCount, int requestPageNumber, 
			String whereColumn, String word, 
			String sortColumn, String orderby, 
			String isBlock){
		
		System.err.println("▶▶▶▶ ListService : getBoardVOList >> 조건 검색 들어옴");
		
		// 페이징 처리
		if (requestPageNumber < 0) {
			throw new IllegalArgumentException("page number < 0 : "
					+ requestPageNumber);
		}
		
		// DAO에게 DB의 전체 글 개수조회 요청
		int totalBoardVOCount = listDAO.selectCount();
		
		
		if (totalBoardVOCount == 0) {//글의 개수가 0이면
			//모델 : BoardVOListModel : 게시글 목록화면 VO 
			return new ListDTOListModel(); // AC에게 되돌려줄 모델(게시글 목록 화면) 리턴
		}
		
		// 전체 페이지 계산(게시글 보기 설정값으로 계산)
		int totalPageCount = calculateTotalPageCount(pageCutCount, totalBoardVOCount);
		
		
		// 예) (1-1) * 10 + 1 = 1 
		int firstRow = (requestPageNumber - 1) * pageCutCount + 1;
		// 예) 1 + 10 - 1 = 10
		int endRow = firstRow + pageCutCount - 1;

		// 예) 10 > 2
		if (endRow > totalBoardVOCount) {
			
			// 예) 전체글번호 = 2
			endRow = totalBoardVOCount;
		}
				
		
		// DAO에게 DB Select 요청
		List<BoardDTO> boardVOList = listDAO.select(firstRow, endRow);

		
		//BoardVOListModel 결과 모델을 생성
		ListDTOListModel boardVOListView = new ListDTOListModel(boardDTOList, 
				whereColumn, word, sortColumn, orderby, isBlock, pageCutCount,
				requestPage, totalPageCount, startRow, endRow)
				
				//boardVOList,requestPageNumber, totalPageCount, firstRow, endRow);
		
		return boardVOListView;
		
	}
	*/
	
	private int calculateTotalPageCount(int pageCutCount, int totalBoardVOCount) {
		if (totalBoardVOCount == 0) {
			return 0;
		}
		
		// 글 갯수 ÷ 페이지당 글 갯수 : 예) 2/10 = 0
		int pageCount = totalBoardVOCount / pageCutCount;
		
		//나머지가 있으면 페이지수를 +1 증가
		if (totalBoardVOCount % pageCutCount > 0) {
			pageCount++;
		}
		
		return pageCount;
	}
	
}
