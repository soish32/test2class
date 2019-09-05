package test3;

import java.util.Date;
import java.util.List;

public class HkDto {
	
	//접근제한자:public>protected>default>private
	private int seq;
	private String id;
	private String name;
	private String title;
	private String content;
	private Date 	regdate;
	
	public HkDto(int seq, String title, String content) {
		super();
		this.seq = seq;
		this.title = title;
		this.content = content;
	}

	 //생성자 오버로딩을 하게되면 default 생성자도 반드시 정의해줘야한다.-->HkDto dto=new HkDto();
	//defalut생성자는 기본적으로 생략해도 되는데 오버로딩하게 되면 생략이안됨
	 public HkDto() {
		super();
			
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
		
	 

	public HkDto(String id, String name, String title, String content) {
		super();
		this.id = id;
		this.name = name;
		this.title = title;
		this.content = content;
	}

	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	//오버라이딩:부모의  메서드를 자식 클래스에서 재정의한 메서드
	//java에서 최상위 클래스는 Objct클래스;4대메서드 구현되어있음
	//--->toString().hashCode(),getCalss(),equals()
	//Systemout.println(hkdto)--->hashcode출력--->멤버필드값이출력
	 
	 @Override
	public String toString() {
		return "HkDto [seq=" + seq + ", id=" + id + ", name=" + name + ", title=" + title + ", content=" + content
				+ ", regdate=" + regdate + "]";
	}


	public List<HkDto> getAllList() {
		// TODO Auto-generated method stub
		return null;
	}


		
}


	 

		 
