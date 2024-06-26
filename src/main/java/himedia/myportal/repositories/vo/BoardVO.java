package himedia.myportal.repositories.vo;

import java.util.Date;

public class BoardVO {
	private Long no;
	private String title;
	private String content;
	private Long hit;
	private Date regDate;
	private Long userNo; // user.no 참조
	private String userName; // user.name 참조

	public BoardVO() {

	}

	public BoardVO(String title, String content, Long userNo) {
		this.title = title;
		this.content = content;
		this.userNo = userNo;
	}

	public BoardVO(Long no, String title, String content, Long hit, Date regDate, Long userNo, String userName) {
		this.no = no;
		this.title = title;
		this.content = content;
		this.hit = hit;
		this.regDate = regDate;
		this.userNo = userNo;
		this.userName = userName;
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content.replace("\n", "<br>");
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getHit() {
		return hit;
	}

	public void setHit(Long hit) {
		this.hit = hit;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Long getUserNo() {
		return userNo;
	}

	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "BoardVO [번호=" + no + ", 제목=" + title + ", 내용=" + content + ", 조회수=" + hit + ", 등록일="
				+ regDate + ", 사용자번호=" + userNo + ", 사용자이름=" + userName + "]";
	}
	
	
}
