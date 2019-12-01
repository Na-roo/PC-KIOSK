package project1.member;

import java.io.Serializable;

/*
1. 화면정의서에있는 화면 입출력 정보를 분류한후에
2. VO(Value Object),DTO(Data Transfer Object) 클래스작성
3. VO 클래스의 멤버필드를 정의한다.
4. VO 클래스의 멤버필드중에 한개의 객체(레코드)를 구분할수있는 
   유일한멤버필드를 선정(존재하지않으면 int로 번호필드생성)
3. 생성자,getter,setter 메쏘드작성 ,toString
*/

public class Member implements Serializable{
	
	private int no; //회원번호
	private String id; // 회원 아이디
	private String password; //회원 비밀번호
	private String name; // 회원 이름
	private String birth;// 회원 생년월일 ex)19960730
	private String telNum;//회원 전화번호
	private int rTime; // 잔여시간
	private int cTime; // 충전 후 시간
	
	
	
	
	
	public Member() {
	}


	public Member(int no, String id, String password, String name, String birth, String telNum, int rTime,
			int cTime) {
		this.no = no;
		this.id = id;
		this.password = password;
		this.name = name;
		this.birth = birth;
		this.telNum = telNum;
		this.rTime = rTime;
		this.cTime = cTime;
	}
	


	




	

	//setters, getters

	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getBirth() {
		return birth;
	}


	public void setBirth(String birth) {
		this.birth = birth;
	}


	public String getTelNum() {
		return telNum;
	}


	public void setTelNum(String telNum) {
		this.telNum = telNum;
	}


	public int getrTime() {
		return rTime;
	}


	public void setrTime(int rTime) {
		this.rTime = rTime;
	}


	public int getcTime() {
		return cTime;
	}


	public void setcTime(int cTime) {
		this.cTime = cTime;
	}
	
	@Override
	public String toString() {
		return "Member [no=" + no + ", id=" + id + ", password=" + password + ", name=" + name + ", birth=" + birth
				+ ", telNum=" + telNum + ", rTime=" + rTime + ", cTime=" + cTime + "]";
	}
	
	
	
}	