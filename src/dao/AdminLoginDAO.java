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
import util.DBManager;


@Repository
public class AdminLoginDAO {
		
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	/**
	 * 관리자 로그인, 로그아웃 기능
	 * @return - AdminDTO
	 */
	public AdminDTO adminList(){
		System.out.println(">>>>  adminList");
		return sqlSessionTemplate.selectOne("admin_ns.adminList");		
		
		/*
		 * AdminDTO aDTO = null;
		Connection con = null;
		PreparedStatement prepStmt = null;
		ResultSet rs = null;
		
		try {
			con = DBManager.getConnection();
			prepStmt = con.prepareStatement(Find_id_name);
			rs = prepStmt.executeQuery();
			
			while (rs.next()) {
				
				aDTO = new AdminDTO();
				aDTO.setID(rs.getString("id"));
				aDTO.setNAME(rs.getString("name"));				
				
				System.out.println("adminList DTO: "+ aDTO.toString());
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			
		}finally {
			DBManager.close(con, prepStmt, rs);
		}		
		return aDTO;*/
		
	} // List<AdminDTO> adminList() - End
	
} // class AdminLogin -End
