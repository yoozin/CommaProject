package comment.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommentVO {
	
	private int commentNo;
	private int boardId;
	private String commentText;
	private String commentWriter;
	private Date commentRdate;
	private Date commentUdate;
	
	public CommentVO() {}

	public int getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int borderNo) {
		this.boardId = borderNo;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	public String getCommentWriter() {
		return commentWriter;
	}

	public void setCommentWriter(String commentWriter) {
		this.commentWriter = commentWriter;
	}

	public String getCommentRdate() {
		SimpleDateFormat sdf;
		sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String printdate;
		printdate = sdf.format(commentRdate);
		return printdate;
	}

	public void setCommentRdate(Date commentRdate) {
		this.commentRdate = commentRdate;
	}

	public Date getCommentUdate() {
		return commentUdate;
	}

	public void setCommentUdate(Date commentUdate) {
		this.commentUdate = commentUdate;
	}

	public CommentVO(int commentNo, int boardId, String commentText, String commentWriter, Date commentRdate,
			Date commentUdate) {
		super();
		this.commentNo = commentNo;
		this.boardId = boardId;
		this.commentText = commentText;
		this.commentWriter = commentWriter;
		this.commentRdate = commentRdate;
		this.commentUdate = commentUdate;
	}

	@Override
	public String toString() {
		return "CommentVO [commentNo=" + commentNo + ", boardId=" + boardId + ", commentText=" + commentText
				+ ", commentWriter=" + commentWriter + ", commentRdate=" + commentRdate + ", commentUdate="
				+ commentUdate + "]";
	}
	
	
	
	
	
}
