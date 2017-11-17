package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import dao.ListViewDAO;
import dao.WriteDAO;
import dto.BoardDTO;

@Service
public class ViewService {

	@Autowired
	ListViewDAO vDao;

	// BoardDetailViewController.java : 'num'으로 보내서 'writeNum'으로 받음
	/* 조회수 증가 후, 목록보기에서 변경내용이 실시간 적용이 안됨 → 트랜잭션 설정 변경함
	 SERIALIZABLE (level 3)
		완벽한 읽기 일관성 모드를 제공
		데이터의 일관성 및 동시성을 위해 MVCC(Multi Version Concurrency Control)을 사용하지 않음(MVCC는 다중 사용자 데이터베이스 성능을 위한 기술로 데이터 조회 시 LOCK을 사용하지 않고 데이터의 버전을 관리해 데이터의 일관성 및 동시성을 높이는 기술)
		트랜잭션이 완료될 때까지 SELECT 문장이 사용하는 모든 데이터에 shared lock이 걸리므로 다른 사용자는 그 영역에 해당되는 데이터에 대한 수정 및 입력이 불가능하다
	 - https://taetaetae.github.io/2016/10/08/20161008/
	 - https://taetaetae.github.io/2017/01/08/transactional-setting-and-property/
	 */
	@Transactional(isolation = Isolation.SERIALIZABLE, timeout = 10)// 트랜잭션시간적용 - 시간내 못하면 롤백됨
	public BoardDTO BoardDetail(int writeNum) {
		vDao.updateHitCount(writeNum); // 글 조회수 증가
		return vDao.BoardDetailView(writeNum);
	}
}
