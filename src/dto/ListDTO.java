package dto;

import org.springframework.stereotype.Repository;

/**
 * List 용 조회 제어 변수들 설정 클래스
 * @author 손가연
 *
 */

@Repository
public class ListDTO {
	
	String whereColumn;	// 검색 컬럼명
	String word;		// 검색어
	String sortColumn;	// 정렬 컬럼
	String orderby;		// 정렬방식 ASC, DESC
	String isBlock;		// 전체글 검색, 블록글 검색
	
	
	// 페이징 처리용 변수 수정 가능
	String totalCount;	// 전체
	String startPage;	// 시작 페이지
	String endPage;		// 끝 페이지
	String pageCutCount;// 게시글 보기 수
	
	
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
	public String getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}
	public String getStartPage() {
		return startPage;
	}
	public void setStartPage(String startPage) {
		this.startPage = startPage;
	}
	public String getEndPage() {
		return endPage;
	}
	public void setEndPage(String endPage) {
		this.endPage = endPage;
	}
	public String getPageCutCount() {
		return pageCutCount;
	}
	public void setPageCutCount(String pageCutCount) {
		this.pageCutCount = pageCutCount;
	}
	
	
	@Override
	public String toString() {
		return "ListDTO [whereColumn=" + whereColumn + ", word=" + word + ", sortColumn=" + sortColumn + ", orderby="
				+ orderby + ", isBlock=" + isBlock + ", totalCount=" + totalCount + ", startPage=" + startPage
				+ ", endPage=" + endPage + ", pageCutCount=" + pageCutCount + "]";
	}
	
}
