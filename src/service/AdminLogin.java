package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import dto.AdminDTO;
import util.DBManager;



@Service	// 보통 서비스 클래스는 component 보다 service를 많이 붙인다
public class AdminLogin {
		
	private final String Find_id_name = "SELECT id, name FROM SB_Admin";
	
	/**
	 * 전체 글 검색
	 * @return - List<BoardDTO>
	 */
	public List<AdminDTO> adminList(){
		
		List<AdminDTO> list = new ArrayList<AdminDTO>();		
		
		Connection con = null;
		PreparedStatement prepStmt = null;
		ResultSet rs = null;
		
		try {
			con = DBManager.getConnection();
			prepStmt = con.prepareStatement(Find_id_name);
			rs = prepStmt.executeQuery();
			
			while (rs.next()) {
				
				AdminDTO aDTO = new AdminDTO();
				
				aDTO.setID(rs.getString("id"));
				aDTO.setNAME(rs.getString("name"));				
				list.add(aDTO);
				
				System.out.println("adminList DTO: "+ aDTO.toString());
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			
		}finally {
			DBManager.close(con, prepStmt, rs);
		}		
		return list;
		
	} // List<AdminDTO> adminList() - End
	
} // class AdminLogin -End









