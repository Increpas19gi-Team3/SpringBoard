package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import dto.AdminDTO;
import dto.BoardDTO;
import util.DBManager;

@Repository
public class BlockDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public void Block(int num) {
		System.out.println(">>>>  Block");
		sqlSessionTemplate.selectOne("admin_ns.block", num);
	}
	
	public void unBlock(int num) {
		System.out.println(">>>>  unBlock");
		sqlSessionTemplate.selectOne("admin_ns.unblock", num);
	}
	
	/**
	 * 게시글 블락처리
	 * 
	 * @return - AdminDTO
	 */
//	public void Block(int num) {
//		
//		System.out.println("SQL-Block-문 시작 num: " + num);
//		
//		BoardDTO bDTO = null;
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//
//		try {
//			conn = DBManager.getConnection();
//			pstmt = conn.prepareStatement(block);
//			pstmt.setInt(1, num);
//			rs = pstmt.executeQuery();
//
//			System.out.println("SQL-Block-문 중간");
//
//			while (rs.next()) {
//				bDTO = new BoardDTO();
//				bDTO.setISBLOCK(rs.getString("ISBLOCK"));
//			}
//
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.println("SQL-Block-문 에러");
//		} finally {
//			DBManager.close(conn, pstmt, rs);			
//		}
//		System.out.println("SQL-Block-문 끝");
//		
//	} // Block - End
//
//	// 게시글 블락취소
//	public void unBlock(int num) {
//
//		System.out.println("SQL-unBlock-문 시작 num: " + num);
//		
//		BoardDTO bDTO = null;
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//
//		try {
//			conn = DBManager.getConnection();
//			pstmt = conn.prepareStatement(unblock);
//			pstmt.setInt(1, num);
//			rs = pstmt.executeQuery();
//			
//			System.out.println("SQL-unBlock-문 중간");
//
//			while (rs.next()) {
//				bDTO = new BoardDTO();
//				bDTO.setISBLOCK(rs.getString("ISBLOCK"));
//			}
//
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.println("SQL-unBlock-문 에러");
//
//		} finally {
//			DBManager.close(conn, pstmt, rs);
//		}
//		System.out.println("SQL-unBlock-문 끝");
//		
//	} // unBlock - End

} // class BlockDAO -End
