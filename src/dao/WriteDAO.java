package dao;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dto.BoardDTO;

@Repository
public class WriteDAO {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public void insert(BoardDTO bdto) {
		sqlSessionTemplate.insert("sb_write_ns.insertWrite", bdto);
	}
}
