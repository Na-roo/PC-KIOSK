package project1.admin;

import java.io.Serializable;

//�ٸ�Ŭ�������Ͽ��� �����Ӱ� ��ӹޱ� ���� ����ȭ�۾�
public class Admin implements Serializable{
	
	private int No;				//������ȣ
	private String Name; 		//�����̸�
	private String Id;			//�������̵�
	private String Password;	//������й�ȣ
	private String PhoneNo;		//������ȭ��ȣ
	private String Position;	//����������
	
	//private String employeeFindByName; �̰� service�� �־���ҰŰ���..
	
	//������ �ʱ�ȭ�۾�
	public Admin() {
		
	}
	//������ �������� ��ü�� ������ �ֱ����� �������۾�
	public Admin(
			int No,
			String Name,
			String Id,
			String Password,
			String PhoneNo,
			String Position
			) {
		
		super();
		this.No=No;
		this.Name=Name;
		this.Id=Id;
		this.Password=Password;
		this.PhoneNo=PhoneNo;
		this.Position=Position;
	}
	
	
	//ŸŬ�������� set�� get���� ���������ٿ����ϰ� �ϱ� ���� setter,getteró��
	public int getNo() {
		return No;
	}
	public void setNo(int no) {
		No = no;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getPhoneNo() {
		return PhoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		PhoneNo = phoneNo;
	}
	public String getPosition() {
		return Position;
	}
	public void setPosition(String position) {
		Position = position;
	}
	@Override
	public String toString() {
		return "Admin [No=" + No + ", Name=" + Name + ", Id=" + Id + ", Password=" + Password + ", PhoneNo=" + PhoneNo
				+ ", Position=" + Position + "]";
	}
	
}