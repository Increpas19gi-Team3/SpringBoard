package dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * List 용 조회 제어 변수들 설정 클래스
 * @author 손가연
 *
 */

@Repository
public class ListDTOListModel {
	
	private List<BoardDTO> boardDTOList;	// 게시글의 목록
	
	private String whereColumn;	// 검색 컬럼명
	private String word;		// 검색어
	private String sortColumn;	// 정렬 컬럼
	private String orderby;		// 정렬방식 ASC, DESC
	private String isBlock;		// 전체글 검색, 블록글 검색
	

	private int pageCutCount;// 게시글 보기 수
	
	private int requestPage;			// 요청 페이지 번호
	private int totalPageCount;			// 전체 페이지 수
	private int startRow;				// 요청(클릭) 페이지 시작 글번호
	private int endRow;					// 요청(클릭) 페이지 마지막 글번호
	
	

	/*// 페이징 처리용 변수 수정 가능
	String totalCount;	// 전체
	String startPage;	// 시작 페이지
	String endPage;		// 끝 페이지
*/	

	// DB의 저장된 전체글의 개수가 0일때 리턴할 게시글 모델
	public ListDTOListModel() {
		this(new ArrayList<BoardDTO>(), "", "", "", "", "", 10, 0, 0, 0, 0);
	}
	
	public ListDTOListModel(List<BoardDTO> boardDTOList, String whereColumn, String word, String sortColumn,
			String orderby, String isBlock, int pageCutCount, int requestPage, int totalPageCount, int startRow,
			int endRow) {
		super();
		this.boardDTOList = boardDTOList;
		this.whereColumn = whereColumn;
		this.word = word;
		this.sortColumn = sortColumn;
		this.orderby = orderby;
		this.isBlock = isBlock;
		this.pageCutCount = pageCutCount;
		this.requestPage = requestPage;
		this.totalPageCount = totalPageCount;
		this.startRow = startRow;
		this.endRow = endRow;
	}

		
	public List<BoardDTO> getBoardVOList() {
		return boardDTOList;
	}
		
	//사용자 정의 메소드도 가능 : 일부<Smart Bean> 이라 부르기도 함
	//리스트 Empty 상태 : boolean 일때 get이 아닌 is로 메소드명 정의
	public boolean isHasBoardVO() {
		return ! boardDTOList.isEmpty();
	}
	
	
	
	
	public List<BoardDTO> getBoardDTOList() {
		return boardDTOList;
	}
	public void setBoardDTOList(List<BoardDTO> boardDTOList) {
		this.boardDTOList = boardDTOList;
	}
	public String getWhereColumn() {
		return whereColumn;
	}
	public void setWhereColumn(String whereColumn) {
		this.whereColumn = whereColumn;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getSortColumn() {
		return sortColumn;
	}
	public void setSortColumn(String sortColumn) {
		this.sortColumn = sortColumn;
	}
	public String getOrderby() {
		return orderby;
	}
	public void setOrderby(String orderby) {
		this.orderby = orderby;
	}
	public String getIsBlock() {
		return isBlock;
	}
	public void setIsBlock(String isBlock) {
		this.isBlock = isBlock;
	}
	public int getPageCutCount() {
		return pageCutCount;
	}
	public void setPageCutCount(int pageCutCount) {
		this.pageCutCount = pageCutCount;
	}
	public int getRequestPage() {
		return requestPage;
	}
	public void setRequestPage(int requestPage) {
		this.requestPage = requestPage;
	}
	public int getTotalPageCount() {
		return totalPageCount;
	}
	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getEndRow() {
		return endRow;
	}
	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	@Override
	public String toString() {
		return "ListDTOListModel [boardDTOList=" + boardDTOList + ", whereColumn=" + whereColumn + ", word=" + word
				+ ", sortColumn=" + sortColumn + ", orderby=" + orderby + ", isBlock=" + isBlock + ", pageCutCount="
				+ pageCutCount + ", requestPage=" + requestPage + ", totalPageCount=" + totalPageCount + ", startRow="
				+ startRow + ", endRow=" + endRow + "]";
	}
	
	
}
