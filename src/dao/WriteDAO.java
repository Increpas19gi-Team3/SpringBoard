package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dto.BoardDTO;
import secure.XSSFilterUtil;
import util.DBManager;

public class WriteDAO {
		private WriteDAO() {
		}

		private static WriteDAO instance = new WriteDAO();

		public static WriteDAO getInstance() {
			return instance;
		}

		public void insertWrite(BoardDTO bdto) {
			String sql = "INSERT INTO SB_BOARD VALUES(SB_BOARD_SEQ.NEXTVAL, ?, '0', ?,?,?,?,?, 0, sysdate)";
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, bdto.getISNOTICE());
				pstmt.setString(2, XSSFilterUtil.doFilter(bdto.getTITLE()));
				pstmt.setString(3, XSSFilterUtil.doFilter(bdto.getWRITER()));
				pstmt.setString(4, XSSFilterUtil.doFilter(bdto.getPWD()));
				pstmt.setString(5, XSSFilterUtil.doFilter(bdto.getCONTENTS()));
				pstmt.setString(6, bdto.getIMGNAME());
				
				rs = pstmt.executeQuery();

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		
		public BoardDTO selectWrite(int writeNum) {
			String sql = "select * from SB_BOARD where num=?";
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			BoardDTO bdto = new BoardDTO();
			
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, writeNum);

				rs = pstmt.executeQuery();
				while (rs.next()) {
					bdto.setCONTENTS(rs.getString("CONTENTS"));
					bdto.setCOUNT(rs.getInt("COUNT"));
					bdto.setIMGNAME(rs.getString("IMGNAME"));
					bdto.setISBLOCK(rs.getString("ISBLOCK"));
					bdto.setISNOTICE(rs.getString("ISNOTICE"));
					bdto.setNUM(writeNum);
					bdto.setPWD(rs.getString("PWD"));
					bdto.setREGTIME(rs.getDate("REGTIME"));
					bdto.setTITLE(rs.getString("TITLE"));
					bdto.setWRITER(rs.getString("WRITER"));
				}
				

			} catch (SQLException e) {
				e.printStackTrace();
			}

			return bdto;
		}

		public String selectPW(int writeNum) {
			String sql = "select PWD from SB_BOARD where num=?";
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String pwd=null;
			
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, writeNum);

				rs = pstmt.executeQuery();
				while (rs.next()) {
					pwd = rs.getString("PWD");
				}
				

			} catch (SQLException e) {
				e.printStackTrace();
			}

			return pwd;
		}

		public void updateWrite(BoardDTO bdto) {
			String sql = "update SB_BOARD set TITLE=?,WRITER=?, PWD=?, CONTENTS=?, IMGNAME=? where num=?";
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, XSSFilterUtil.doFilter(bdto.getTITLE()));
				pstmt.setString(2, XSSFilterUtil.doFilter(bdto.getWRITER()));
				pstmt.setString(3, XSSFilterUtil.doFilter(bdto.getPWD()));
				pstmt.setString(4, XSSFilterUtil.doFilter(bdto.getCONTENTS()));
				pstmt.setString(5, bdto.getIMGNAME());
				pstmt.setInt(6, bdto.getNUM());
				
				rs = pstmt.executeQuery();

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		
		public void deleteWrite(int writeNum) {
			String sql = "delete from SB_BOARD where num=?";
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String pwd=null;
			
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, writeNum);

				rs = pstmt.executeQuery();

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
}
