package project1.admin;

import java.io.Serializable;

//다른클래스파일에서 자유롭게 상속받기 위해 직렬화작업
public class Admin implements Serializable{
	
	private int No;				//직원번호
	private String Name; 		//직원이름
	private String Id;			//직원아이디
	private String Password;	//직원비밀번호
	private String PhoneNo;		//직원전화번호
	private String Position;	//직원의직급
	
	//private String employeeFindByName; 이건 service에 넣어야할거같음..
	
	//생성자 초기화작업
	public Admin() {
		
	}
	//생설할 여러개의 객체에 데이터 넣기위한 생성자작업
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
	
	
	//타클래스에서 set과 get으로 데이터접근용이하게 하기 위한 setter,getter처리
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