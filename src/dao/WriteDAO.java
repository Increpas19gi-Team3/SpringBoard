package dao;


import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.apache.log4j.Logger;
import dto.BoardDTO;

@Repository
public class WriteDAO {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	
	public void insert(BoardDTO bdto) {
		sqlSessionTemplate.insert("sb_write_ns.insertWrite", bdto);
	}
	
	public BoardDTO selectWrite(int writeNum) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("writeNum", writeNum);// 글번호 맵에 저장		
		
		return sqlSessionTemplate.selectOne("sb_write_ns.selectWrtByNum", map);
	}
	
	public void updateWrite(BoardDTO bdto) {
		sqlSessionTemplate.update("sb_write_ns.updateWrite", bdto);
	}
	
//	public void deleteWrite(int writeNum) {
//		Map<String,Object> map = new HashMap<String,Object>();
//		map.put("writeNum", writeNum);// 글번호 맵에 저장		
//		sqlSessionTemplate.delete("sb_write_ns.deleteWrite", writeNum);
//	}

	public void deleteWrite(int writeNum, int BLEVEL) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("writeNum", writeNum);// 글번호 맵에 저장
		map.put("BLEVEL", BLEVEL);
		sqlSessionTemplate.delete("sb_write_ns.deleteWrite", map);
	}
	
	
	//=======================손대성====================================
	
	public void insertReply(BoardDTO bDTO) {
		sqlSessionTemplate.update("sb_write_ns.replyUpdateBoard", bDTO);
		sqlSessionTemplate.insert("sb_write_ns.insertReplyBoard", bDTO);		
	}
}
