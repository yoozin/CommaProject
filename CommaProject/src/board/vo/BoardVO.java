package board.vo;

import java.util.Arrays;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class BoardVO {
	
	private int boardId;
	private String title;
	private String writer;
	private String content;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date travelDate;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private String uDate;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date wDate;
	private int viewCount;
	private int replyCount;
	private int startIndex;
	private int cntPerPage;


	public BoardVO() {};
	


	public BoardVO(int boardId, String title, String writer, String content, Date travelDate, String uDate, Date wDate,
			int viewCount, int replyCount, int startIndex, int cntPerPage) {
		super();
		this.boardId = boardId;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.travelDate = travelDate;
		this.uDate = uDate;
		this.wDate = wDate;
		this.viewCount = viewCount;
		this.replyCount = replyCount;
		this.startIndex = startIndex;
		this.cntPerPage = cntPerPage;
	}



	public Date getTravelDate() {
		return travelDate;
	}
	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}
	
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public int getReplyCount() {
		return replyCount;
	}
	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}
	public String getuDate() {
		return uDate;
	}

	public void setuDate(String uDate) {
		this.uDate = uDate;
	}

	public Date getwDate() {
		return wDate;
	}

	public void setwDate(Date wDate) {
		this.wDate = wDate;
	}
	

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	@Override
	public String toString() {
		return "BoardVO [boardId=" + boardId + ", title=" + title + ", writer=" + writer + ", content=" + content
				+ ", travelDate=" + travelDate + ", uDate=" + uDate + ", wDate=" + wDate + ", viewCount=" + viewCount
				+ ", replyCount=" + replyCount + "]";
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}



	public int getCntPerPage() {
		return cntPerPage;
	}



	public void setCntPerPage(int cntPerPage) {
		this.cntPerPage = cntPerPage;
	}



	




	
	
	
	
}
