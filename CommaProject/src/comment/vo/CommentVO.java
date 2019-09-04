package comment.vo;

import java.util.Date;

public class CommentVO {
	
	private int commentNo;
	private int borderNo;
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

	public int getBorderNo() {
		return borderNo;
	}

	public void setBorderNo(int borderNo) {
		this.borderNo = borderNo;
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

	public Date getCommentRdate() {
		return commentRdate;
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

	public CommentVO(int commentNo, int borderNo, String commentText, String commentWriter, Date commentRdate,
			Date commentUdate) {
		super();
		this.commentNo = commentNo;
		this.borderNo = borderNo;
		this.commentText = commentText;
		this.commentWriter = commentWriter;
		this.commentRdate = commentRdate;
		this.commentUdate = commentUdate;
	}

	@Override
	public String toString() {
		return "CommentVO [commentNo=" + commentNo + ", borderNo=" + borderNo + ", commentText=" + commentText
				+ ", commentWriter=" + commentWriter + ", commentRdate=" + commentRdate + ", commentUdate="
				+ commentUdate + "]";
	}
	
	
	
	
	
}
