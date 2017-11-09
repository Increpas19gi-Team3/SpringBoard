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
			BoardDTO bDTO = null;
			
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


}
