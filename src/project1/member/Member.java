package project1.member;

import java.io.Serializable;

/*
1. ȭ�����Ǽ����ִ� ȭ�� ����� ������ �з����Ŀ�
2. VO(Value Object),DTO(Data Transfer Object) Ŭ�����ۼ�
3. VO Ŭ������ ����ʵ带 �����Ѵ�.
4. VO Ŭ������ ����ʵ��߿� �Ѱ��� ��ü(���ڵ�)�� �����Ҽ��ִ� 
   �����Ѹ���ʵ带 ����(�������������� int�� ��ȣ�ʵ����)
3. ������,getter,setter �޽���ۼ� ,toString
*/

public class Member implements Serializable{
	
	private int no; //ȸ����ȣ
	private String id; // ȸ�� ���̵�
	private String password; //ȸ�� ��й�ȣ
	private String name; // ȸ�� �̸�
	private String birth;// ȸ�� ������� ex)19960730
	private String telNum;//ȸ�� ��ȭ��ȣ
	private int rTime; // �ܿ��ð�
	private int cTime; // ���� �� �ð�
	
	
	
	
	
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