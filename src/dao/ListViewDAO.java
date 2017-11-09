package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

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
	public BoardDTO BoardDetailView(int num) {

		String sql = "select * from SB_Board where num=?";

		BoardDTO bDTO = new BoardDTO();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();

			if (rs.next()) {

				bDTO.setNUM(rs.getInt("num"));
				bDTO.setISNOTICE(rs.getString("isNotice"));
				bDTO.setISBLOCK(rs.getString("isBlock"));
				bDTO.setTITLE(rs.getString("title"));
				bDTO.setWRITER(rs.getString("writer"));
				// list.setPWD(rs.getString("pwd"));
				bDTO.setCONTENTS(rs.getString("contents"));
				bDTO.setIMGNAME(rs.getString("imgName"));
				bDTO.setCOUNT(rs.getInt("count"));
				bDTO.setREGTIME(rs.getDate("regTime"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return bDTO;
	} // SelectOneMovieByCode(String code) - End

} // class ListViewDAO -End
