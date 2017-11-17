package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dto.BoardDTO;
import util.DBManager;

@Repository
public class ListViewDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	// 조회수 증가
	public void updateHitCount(int num) {
		sqlSessionTemplate.update("sb_view_ns.updateHitCount", num);
	}

	public BoardDTO BoardDetailView(int num) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("writeNum", num);// 글번호 맵에 저장
		return sqlSessionTemplate.selectOne("sb_view_ns.selectDetail", map);
	} // SelectOneMovieByCode(String code) - End

} // class ListViewDAO -End
