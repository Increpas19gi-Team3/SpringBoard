package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dto.BoardDTO;
import dto.ListDTOListModel;
import util.DBManager;
import util.LoggableStatement;

@Repository
public class ListDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	

	/**
	 * 전체 글 검색
	 * @return - List<BoardDTO>
	 */
	@Transactional
	public List<BoardDTO> selectList(){
		return sqlSessionTemplate.selectList("sb_list_ns.selectList");
		
		
		/* 
		
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		
		Connection con = null;
		PreparedStatement prepStmt = null;
		ResultSet rs = null;
		BoardDTO bDTO = null;


		try {
			
			StringBuffer query = new StringBuffer();
	        query.append("SELECT * FROM SB_BOARD ");
	        query.append("ORDER BY ISNOTICE DESC, NUM DESC");	
	        
			
			con = DBManager.getConnection();
			prepStmt = con.prepareStatement(query.toString());
			rs = prepStmt.executeQuery();
			
			while (rs.next()) {
				bDTO = new BoardDTO();
				
				bDTO.setNUM(rs.getInt("NUM"));
				bDTO.setISNOTICE(rs.getString("ISNOTICE"));
				bDTO.setISBLOCK(rs.getString("ISBLOCK"));
				bDTO.setTITLE(rs.getString("TITLE"));
				bDTO.setWRITER(rs.getString("WRITER"));
				bDTO.setPWD(rs.getString("PWD"));
				bDTO.setCONTENTS(rs.getString("CONTENTS"));
				bDTO.setIMGNAME(rs.getString("IMGNAME"));
				bDTO.setCOUNT(rs.getInt("COUNT"));
				bDTO.setREGTIME(rs.getDate("REGTIME"));
				
				list.add(bDTO);
				
				//System.out.println("selectList DTO: "+ bDTO.toString());
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			DBManager.close(con, prepStmt, rs);
		}
		
		return list;
		
		*/
	}
	

	/**
	 * 조건 검색
	 * @param whereColumn : 검색 컬럼명
	 * @param word	: 검색어
	 * @param sortColumn : 정렬 컬럼
	 * @param orderby : 정렬방식 ASC, DESC
	 * @param isBlock : 전체글 검색, 블록글 검색
	 * @return - List<BoardDTO>
	 */
	public List<BoardDTO> selectSetList(ListDTOListModel listDTOListModel){
		
		System.out.println("▶▶▶▶ listDTO="+listDTOListModel.toString());
		
		
		return sqlSessionTemplate.selectList("sb_list_ns.selectSetList", listDTOListModel);
		
		/*
		List<BoardDTO> list = null;			
		int parameterIndex = 1;
		
		
		StringBuffer query = new StringBuffer();
        query.append("SELECT * FROM SB_BOARD ");
        
        
        //글보기 설정 - isBlock
        if(isBlock.length() > 0){
        	if(!isBlock.equals("ALL")){//전체글 보기가 아닐때
        		query.append("WHERE ISBLOCK = ?");
        	}
        }
        
        //검색 조건 - search
        if(whereColumn.length() > 0){
        	if(!whereColumn.equals("ALL")){//전체글 검색이 아닐때
        		if(query.toString().contains("WHERE")){//이미 where 조건이 되어 있다면
            		query.append(" AND "+whereColumn+" LIKE ? ");
            	}else{
            		query.append("WHERE "+whereColumn+" LIKE ? ");
            	}
        	}
        }
        
        //정렬 조건
        if(sortColumn.length() > 0 && orderby.length() > 0){
        	query.append(" ORDER BY ISNOTICE DESC, "+ sortColumn+" "+orderby);
        }else{
        	query.append(" ORDER BY ISNOTICE DESC, NUM DESC");
        }
        
//      System.out.println("selectSetList SQL:" + query.toString());
//      System.out.println("whereColumn:"+whereColumn);
//		System.out.println("word:"+word);
		
		Connection con = null;
		PreparedStatement prepStmt = null;
		ResultSet rs = null;
		
		try {
			con = DBManager.getConnection();
			//prepStmt = con.prepareStatement(query.toString()); //기존방식 - 상용
			prepStmt = new LoggableStatement(con, query.toString()); //PreparedStatement 쿼리 확인용 처리방식 - 개발용
			
			
			//글보기 설정 - isBlock
			if(isBlock.length() > 0){
	        	if(!isBlock.equals("ALL")){//전체글 보기가 아닐때
	        		prepStmt.setString(parameterIndex++, isBlock);
	        	}
	        }
			
			
			//검색 조건 - search
	        if(whereColumn.length() > 0){//전체검색시 검색어 입력 X
	        	if(!whereColumn.equals("ALL")){//전체글 검색이 아닐때
		        	prepStmt.setString(parameterIndex++, "%" + word + "%");
	        	}
	        }
			
	        
			System.out.println("▶▶▶▶▶▶ ListDAO selectSetList SQL:"+((LoggableStatement)prepStmt).getQueryString());//상용 시, 주석처리
			
			rs = prepStmt.executeQuery();
			list = new ArrayList<BoardDTO>();
			
			while (rs.next()) {
				BoardDTO bDTO = new BoardDTO();
				
				bDTO.setNUM(rs.getInt("NUM"));
				bDTO.setISNOTICE(rs.getString("ISNOTICE"));
				bDTO.setISBLOCK(rs.getString("ISBLOCK"));
				bDTO.setTITLE(rs.getString("TITLE"));
				bDTO.setWRITER(rs.getString("WRITER"));
				bDTO.setPWD(rs.getString("PWD"));
				bDTO.setCONTENTS(rs.getString("CONTENTS"));
				bDTO.setIMGNAME(rs.getString("IMGNAME"));
				bDTO.setCOUNT(rs.getInt("COUNT"));
				bDTO.setREGTIME(rs.getDate("REGTIME"));
				
				list.add(bDTO);
				
				System.out.println("selectSetList DTO: "+ bDTO.toString());
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			DBManager.close(con, prepStmt, rs);
		}
		
		//
		for (BoardDTO boardDTO : list) {
			System.out.println("▷▷▷▷▷"+boardDTO.toString());
		}
		//
		
		return list;
		*/
	}
	
	
	/**
	 * 전체 글 갯수 리턴
	 * @return
	 */
	public int  selectCount(ListDTOListModel listDTOListModel) {		
		System.out.println("▶▶▶▶ listDTO : selectCount");
		return sqlSessionTemplate.selectOne("sb_list_ns.selectCount", listDTOListModel);
	}
	
	
}
