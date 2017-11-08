package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import dto.BoardDTO;
import util.DBManager;

@Component
public class ListDAO {

	/**
	 * 전체 글 검색
	 * @return - List<BoardDTO>
	 */
	public List<BoardDTO> selectList(){
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		
		String sql = "SELECT * FROM SB_BOARD "
				 	+ "ORDER BY NUM DESC";
		
		Connection con = null;
		PreparedStatement prepStmt = null;
		ResultSet rs = null;
		
		try {
			con = DBManager.getConnection();
			prepStmt = con.prepareStatement(sql);
			rs = prepStmt.executeQuery();
			
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
				
				System.out.println("selectList DTO: "+ bDTO.toString());
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			DBManager.close(con, prepStmt, rs);
		}
		
		return list;
	}
	

	/**
	 * 조건 검색
	 * @param whereColumn : 검색 컬럼명
	 * @param word	: 검색어
	 * @param sortColumn : 정렬 컬럼
	 * @param orderby : 정렬방식 ASC, DESC
	 * @return - List<BoardDTO>
	 */
	public List<BoardDTO> selectList(String whereColumn, String word, String sortColumn, String orderby){
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		
		String sql = "SELECT * FROM SB_BOARD "
					+ "WHERE ? LIKE ? "
				 	+ "ORDER BY ? ?";
		System.out.println("whereColumn:"+whereColumn);
		System.out.println("word:"+word);
		System.out.println("sortColumn:"+sortColumn);
		System.out.println("orderby:"+orderby);
		
		Connection con = null;
		PreparedStatement prepStmt = null;
		ResultSet rs = null;
		
		try {
			con = DBManager.getConnection();
			prepStmt = con.prepareStatement(sql);
			prepStmt.setString(1, whereColumn);
			prepStmt.setString(2, word);
			prepStmt.setString(3, sortColumn);
			prepStmt.setString(4, orderby);
			
			rs = prepStmt.executeQuery();
			
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
				
				System.out.println("selectList DTO: "+ bDTO.toString());
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			DBManager.close(con, prepStmt, rs);
		}
		
		return list;
	}
	
	
}
