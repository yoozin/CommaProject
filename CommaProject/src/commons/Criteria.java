package commons;

public class Criteria {
		private int page;
		private int perPageNum;
		
		
		public Criteria() {
			this.page = 1;
			this.perPageNum = 10;
		}
		
		
		
		
		public int getPage() {
			return page;
		}
		
		
		public void setPage(int page) {
			if(page <= 0) {
				this.page = 1;
				return;
			}
		}
		
		
		
		public int getPerPageNum() {
			return this.perPageNum;
		}
		
		
		public void setPerPageNum(int perPageNum) {
			if(perPageNum <= 0 || perPageNum > 100) {
				this.perPageNum = 10;
				return;
			}
			this.perPageNum = perPageNum;
		}
		
		
		public int getPageStart() {
			return(this.page - 1) * perPageNum;
		}




		public Criteria(int page, int perPageNum) {
			super();
			this.page = page;
			this.perPageNum = perPageNum;
		}




		@Override
		public String toString() {
			return "Criteria [page=" + page + ", perPageNum=" + perPageNum + "]";
		}

	
		
		
		
		
}
