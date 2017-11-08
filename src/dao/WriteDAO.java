package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dto.BoardDTO;
import util.DBManager;

public class WriteDAO {
		private WriteDAO() {
		}

		private static WriteDAO instance = new WriteDAO();

		public static WriteDAO getInstance() {
			return instance;
		}

		public void insertWrite(BoardDTO bdto) {
			String sql = "select * from board where pass=? and num=?";
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			BoardDTO bDTO = null;
			
			System.out.println(bdto.getCONTENTS());
			System.out.println(bdto.getIMGNAME());
			System.out.println(bdto.getISNOTICE());
			System.out.println(bdto.getPWD());
			System.out.println(bdto.getTITLE());
			System.out.println(bdto.getWRITER());
			
			/*try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, pass);
				pstmt.setString(2, num);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					bDTO = new BoardVO();
					bDTO.setNum(rs.getInt("num"));

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}*/
			//return bDTO;
		}


}
