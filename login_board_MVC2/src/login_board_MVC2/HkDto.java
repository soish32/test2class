package login_board_MVC2;

import java.util.Date;

public class HkDto {

	public HkDto(int seq, String id, String name, String content, Date regdate) {
		super();
		this.seq = seq;
		this.id = id;
		this.name = name;
		this.content = content;
		this.regdate = regdate;
	}
	public HkDto(int seq, String id, String name, String title, String content, Date regdate) {
		super();
		this.seq = seq;
		this.id = id;
		this.name = name;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
	}


	public HkDto(int seq, String id, String content) {
		super();
		this.seq = seq;
		this.id = id;
		this.content = content;
	}
	public HkDto(String id, String name, String title, String content) {
		super();
		this.id = id;
		this.name = name;
		this.title = title;
		this.content = content;
	}


	//접근제한자:public>protected>default>private
	private int seq;
	private String id;
	private String name;
	private String title;
	private String content;
	private Date   regdate;


	public HkDto() {
		super();
	}


	/**
	 * @return the seq
	 */
	public int getSeq() {
		return seq;
	}
	/**
	 * @param seq the seq to set
	 */
	public void setSeq(int seq) {
		this.seq = seq;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @return the regdate
	 */
	public Date getRegdate() {
		return regdate;
	}
	/**
	 * @param regdate the regdate to set
	 */
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

//오버라이딩 :부모의 메서드 를 자식클래스에 재정의한 메서드
//java 에서 최상위 클래스는 Object 클래스 4대 메서드 구현
//---> toString() ,hashCode(),getClass(),equals()
//system.out.println (hkdto) ---> hashcode 출력 ---> 멤버필드값이출력

@Override
public String toString() {
	return "HkDto [seq=" + seq + ", id=" + id + ", name=" + name + ", title=" + title + ", content=" + content
			+ ", regdate=" + regdate + "]";
}
}


