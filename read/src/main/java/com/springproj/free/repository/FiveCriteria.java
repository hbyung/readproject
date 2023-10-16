package com.springproj.free.repository;

public class FiveCriteria {
		
		private int page;
		private int perPageNum;
		private int rowStart;
		private int rowEnd;
		private int seq;
		private int cuseq;
		private String searchCondition; // 검색 기능 추가
		private String searchKeyword; // 검색 기능 추가
		
		public FiveCriteria() {
			this.page = 1;
			this.perPageNum = 5;
		}
		
		public void setPage(int page) {
			if (page <= 0) {
				this.page = 1;
				return;
			}
			this.page = page;
		}
		
		public void setPerPageNum(int perPageNum) {
			if (perPageNum <= 0 || perPageNum > 100) {
				this.perPageNum = 5;
				return;
			}
			this.perPageNum = perPageNum;
		}
		
		public int getPage() {
			return page;
		}
		
		public int getPageStart() {
			return (this.page - 1) * perPageNum;
		}
		
		public int getPerPageNum() {
			return this.perPageNum;
		}
		
		public int getRowStart() {
			rowStart = ((page - 1) * perPageNum) + 1;
			return rowStart;
		}
		
		public int getRowEnd() {
			rowEnd = rowStart + perPageNum - 1;
			return rowEnd;
		}
		
		public String getSearchCondition() {
			return searchCondition;
		}

		public void setSearchCondition(String searchCondition) {
			this.searchCondition = searchCondition;
		}

		public String getSearchKeyword() {
			return searchKeyword;
		}

		public void setSearchKeyword(String searchKeyword) {
			this.searchKeyword = searchKeyword;
		}
		

		public int getSeq() {
			return seq;
		}

		public void setSeq(int seq) {
			this.seq = seq;
		}

		public int getCuseq() {
			return cuseq;
		}

		public void setCuseq(int cuseq) {
			this.cuseq = cuseq;
		}

		@Override
		public String toString() {
			return "Criteria [page=" + page + ", perPageNum=" + perPageNum + ", rowStart=" + rowStart + ", rowEnd=" + rowEnd
					+ "]";
		}
}
