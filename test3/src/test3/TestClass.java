package test3;

public class TestClass extends Object{

	//생성자의 개념
	/*
	 * new로 객체를 생성하면 생성자가 실행된다.
	 * 생성자는 객체를 생성할때 맴버필드의 값을 초기화할때 사용된다.
	 * default 생성자는 생략이 가능하다. 단, 생성자 오버로딩을 했을 경우 생략 불가
	 * super(): 부모의 생성자를 호출
	 * this(): 자기클래스의 생성자를 호출
	 * super: 부모 클래스를 가르킴
	 * this:자기클래스를 가르킴
	 */
	
	TestClass tc=new TestClass(5,7);
	TestClass tc2=new TestClass();
	public int a;//맴버필드
	public int b;
	
	public TestClass() { //(int a) 메서드의 파라미터 선언
		super();
	}
	
	public TestClass(int a) { //(int a) 메서드의 파라미터 선언
		this.a=a;
		
	}
	
	public TestClass(int a,int b) { //(int a) 메서드의 파라미터 선언
		this.a=a;
		this.b=b;
	}
	
	
	
}
