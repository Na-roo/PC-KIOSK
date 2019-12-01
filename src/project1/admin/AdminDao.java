package project1.admin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class AdminDao {
	
	/*
	 * create
	 * admin_list.ser 파일에 객체들을 생성하기 위한 메소드
	 */ 
	public void create(Admin admin) throws Exception {
		
		//readFile 메소드 호출시 adminList 불러올 명령어 선언
		ArrayList<Admin> adminList=readFile();
		
		//adminList에 객체추가할때 쓸 명령어 .add(admin)
		adminList.add(admin);
		writeFile(adminList);
	}
	
	
	//-----------------------------------------------------------
	
	
	/*
	 * Read
	 * 생성한 admin_list.ser 파일에 객체들을 불러오기 위한 메소드
	 */
	
	public ArrayList<Admin> readAll() throws Exception {
		//불러온 ArrayList을 readFile에 반환한다
		return readFile();
	}
	
	//직원이름으로 검색해서 불러오기
	public Admin readOne(String name) throws Exception {
		// 제공받은인자와 일치한 데이터의 객체주소값을 저장하기 위한 공간을 확보하기 위해 초기화
		Admin findAdmin=null;
		
		//readFile을 호출하면 adminList의 데이터가 불러들어와짐
		ArrayList<Admin> adminList=readFile();
		for (Admin admin : adminList) {
			//제공받은 인자와 동일한 데이터를 찾아라
			if (admin.getName().equals(name)) {
				//인자로 제공받은 데이터를 찾으면 findAdmin에 대입됨
				findAdmin=admin;
				//조건식을 충족하면 반복문을 빠져나감
				break;					
			}
		}
		// 위 반복문으로 찾은 데이터가 반환되도록 명령
		return findAdmin;
	}
	
	//직원번호로 검색해서 불러오기
	public Admin readOne(int no) throws Exception {
		Admin findAdmin = null;
		ArrayList<Admin> adminList = readFile();
		for (Admin admin : adminList) {
			if (admin.getNo() == no) {
				findAdmin = admin;
				break;
			}
		}
		return findAdmin;
	}
	
	
	//-----------------------------------------------------------
	
	
	/*
	 * Update
	 * 생성한 admin_list.ser 파일에 객체들을 수정하기 위한 메소드
	 */
	
	//수정할 메소드를 선언 메소드명 update, 받을 인자값은 Admin updateAdmin에 대입
	public void update(Admin updateAdmin) throws Exception {
		
		//readFile을 호출하면 adminList의 데이터가 불러들어와짐
		ArrayList<Admin> adminList=this.readFile();
		for (int i = 0; i < adminList.size(); i++) {
			
			//받은인자값과 동일한 데이터객체를 저장하기 위해 임의의 tempAdmin 변수선언
			Admin tempAdmin=adminList.get(i);
			
			// updateAdmin.getNo() 객체를 받으면 수정할 객체가 여기에 대입
			// tempAdmin.getNo() 수정할 객체를 임시로 저장할 만든 tempAdmin에 저장
			if (tempAdmin.getNo()==updateAdmin.getNo()) {
				adminList.set(i, updateAdmin);
				break; 							//조건문을 빠져나와라
			}
		}
		this.writeFile(adminList);
	}
	
	
	
	//-----------------------------------------------------------
	
	
	/*
	 * Delete
	 * 생성한 admin_list.ser 파일에 객체들을 삭제하기 위한 메소드
	 */
	
	//관리자 이름으로 검색해서 삭제
	public void delete(String name) throws Exception {
		//readFile을 참조변수선언해주고 이걸 호출할시 adminList가 불러오도록 선언
		ArrayList<Admin> adminList=this.readFile();
		for (int i = 0; i < adminList.size(); i++) {
			
			//인자로 제공받은 객체를 저장하기 위해 tempAdmin 변수생성
			Admin tempAdmin=adminList.get(i);
			//인자로 제공받은 데이터와 동일한 데이터를 가진 객체를 찾을경우 해당 객체를
			// 삭제하라고 명령
			if (tempAdmin.getName().equals(name)) {
				adminList.remove(i);
				// 조건문을 빠져나와라
				break;
			}
		}
		//위 반복문과 조건식을 adminList파일에 write 되라고 참조변수넣어줌
		this.writeFile(adminList);
	}
	
	//관리자번호로 검색해서 삭제
	public void delete(int no) throws Exception{
		ArrayList<Admin> adminList = this.readFile();
		for (int i = 0; i < adminList.size(); i++) {
			Admin tempMember = adminList.get(i);
			if (tempMember.getNo() == no) {
				adminList.remove(i);
				break;
			}
		}
		this.writeFile(adminList);
	}
	
	
	
	
	/*******************************************************/
	
	// 파일생성을 위한 파일타입의 adminFile이라는 이름의 변수를 선언
	private File adminFile;
	
	// 예외 발생할시 AdminDao클래스에서 예외처리 위한 익셉션 처리
	// 상속받을때의 객체들을 저장하기 위해선 공간이 필요하기 때문에 공간 초기화 작업할 init선언
	public AdminDao() throws Exception {
		init();
	}
	
	private void init() throws Exception {
		// 관리자 목록 정보를 저장 및 입출력하기 위한 파일생성 작업
		adminFile = new File("admin_list.ser");
		if (!adminFile.exists()) {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(adminFile));
			oos.writeObject(new ArrayList<Admin>());
		}
	}
	
	//admin_list.ser 파일을 불러와서 생성될 관리자들의 목록(arraylist)을 입력 및 읽어오는 메소드
	private ArrayList<Admin> readFile() throws Exception {
		//ObjectInputStream 타입의 ois 변수 = ObjectInputStream 객체생성 및 객체명 선언 (adminFile을 호출하기위해)
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(adminFile));

		//직렬화한 ois 변수의 accountList 객체들을 쓰기위한 명령
		ArrayList<Admin> accountList = (ArrayList<Admin>) ois.readObject();
		
		//ois 스트림을 닫는다
		ois.close();
		return accountList;
	}
	
	//데이터가 저장된 admin_list.ser의 파일안의 데이터들을 출력시킬 메소드 
	private void writeFile(ArrayList<Admin> accountList) throws Exception {
		//ObjectOutputStream 타입의 oos 변수 = ObjectOutputStream 객체생성 및 객체명 선언 (adminFile을 호출하기위해)
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(adminFile));
		//직렬화한 oos 변수의 accountList 객체들을 쓰기위한 명렁
		oos.writeObject(accountList);
		
		//oos 스트림을 닫는다
		oos.close();
	}
	
	

	
	
}
