package test6;

import java.util.Date;

public class testAnsDto {
	public int seq;
	public String id;
	public String title;
	public String content;
	public Date regdate;
	public int refer;
	public int step;
	public int depth;
	public int redcount;
	public String delfalag;

	//생성자 (default)
	public testAnsDto() {
		super();
	}
	
	//생성자 오버로딩(멤버필드초기화)
	public testAnsDto(int seq, String id, String title, String content, Date regdate, int refer, int step, int depth,
			int redcount, String delfalag) {
		super();
		this.seq = seq;
		this.id = id;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
		this.refer = refer;
		this.step = step;
		this.depth = depth;
		this.redcount = redcount;
		this.delfalag = delfalag;
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

	public int getRefer() {
		return refer;
	}

	
	public void setRefer(int refer) {
		this.refer = refer;
	}


	public int getStep() {
		return step;
	}

	
	public void setStep(int step) {
		this.step = step;
	}

	
	public int getDepth() {
		return depth;
	}

	
	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getRedcount() {
		return redcount;
	}

	
	public void setRedcount(int redcount) {
		this.redcount = redcount;
	}

	public String getDelfalag() {
		return delfalag;
	}
	public void setDelfalag(String delfalag) {
		this.delfalag = delfalag;
	}

}
	
	
	
	
