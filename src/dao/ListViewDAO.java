package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import dto.AdminDTO;
import dto.BoardDTO;
import util.DBManager;



@Service
public class ListViewDAO {
		
	/**
	 * @param num
	 * 
	 * 
	 * @return
	 */
	public BoardDTO SelectOneMovieByCode(int Mcode) {

		String sql = "select * from Movie where Mcode=?";
		
		BoardDTO list =  new BoardDTO();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Mcode);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				
				list.setNUM(rs.getInt("num"));
				list.setISNOTICE(rs.getString("isNotice"));
				list.setISBLOCK(rs.getString("isBlock"));
				list.setTITLE(rs.getString("title"));
				list.setWRITER(rs.getString("writer"));
				// list.setPWD(rs.getString("pwd"));				
				list.setCONTENTS(rs.getString("contents"));
				list.setIMGNAME(rs.getString("imgName"));
				list.setCOUNT(rs.getInt("count"));
				list.setREGTIME(rs.getDate("regTime"));			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return list;
	} // SelectOneMovieByCode(String code) - End

	
} // class ListViewDAO -End
