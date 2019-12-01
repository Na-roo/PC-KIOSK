package project1.admin;

import java.util.ArrayList;

/*
 * Admin 객체 전체에 관련된 업무를 실행할 클래스
 */
public class AdminService {
	private AdminDao adminDao;
	
	public AdminService() throws Exception {
		adminDao = new AdminDao();
	}

	
	
	//-----------------------------------------------------------\
	/*
	 * 직원객체 등록
	 */
	//직원 추가를 위한 boolean 타입의 adminRegister 메소드선언,인자는 Admin addAdmin
	public boolean adminRegister(Admin addAdmin) throws Exception {
		boolean isSuccess=true;
		
		/*
		 * 등록할 직원의 id중복체크
		 */
		
		//dao파일을 불러와서 admin을 갖고 있는 Arraylist를 adminList에 저장
		ArrayList<Admin> adminList=adminDao.readAll();
		//adminList가 갖고 있는 배열을 Admin타입의 admin(변수명)에 대입
		for (Admin admin : adminList) {
			//만약에 추가할 id(string타입) 주소값이 기존의 배열중에서 일치하는게 있다면 
			if (admin.getId().equals(addAdmin.getId()) || admin.getNo()==addAdmin.getNo()) {
				//결과는 실패이며, 조건문 종료 
				isSuccess=false;
				break;
				
			}
		}
		// 자료형 변수를 처음에 true라고 선언해주었으므로 직원정보를 하나 등록
		if (isSuccess) {
			adminDao.create(addAdmin);
		}
		// 위 반복문으로 찾은 데이터가 반환되도록 명령
		return isSuccess;
	}
	
	
	
	//-----------------------------------------------------------
	/*
	 * 관리자 로그인
	 */
	//로그인을 위한 int 타입의 login 메소드선언, 받을 인자는 String id,String password
	public int login(String id,String password) throws Exception {
		/*
		 * 1.회원존재여부
		 */
		// 반환할 데이터를 위해 반환타입변수에 임의의 숫자 대입
		int result=-9999;
		/*
		 * 0:성공
		 * 1:아이디존재안함
		 * 2:패쓰워드불일치
		 */
		//인자값 id를 가진 dao데이터를 가져와서 Admin 타입의 findAdmin 변수담기
		Admin findAdmin=adminDao.readOne(id);
		// 변수의 주소값이 null이 아닐때
		if (findAdmin!=null) {
			// 입력한 password의 주소값과 dao에 있는 password의 주소값이 같으면 성공
			if (findAdmin.getPassword().equals(password)) {
				result=0;
			}else {
				//아니라면 결과는 2 패스워드 불일치
				result=2;
			}
		}else {
			//이것도 아니라면 결과는 1 아이디존재안함
			result=1;
		}
		// 위조건식에 해당한 result 결과값을 Admin findAdmin에 반환
		return result;
	}
	
	
	
	//-----------------------------------------------------------
	/*
	 * 직원 전체검색
	 */
	//배열 전체를 불러와야하는거니까 이거는 List 로 선언하는게 맞음
	public ArrayList<Admin> findAllAdmin() throws Exception {
		ArrayList<Admin> adminList = adminDao.readAll();
		return adminList;
	}
	
	
	
	//-----------------------------------------------------------
	/*
	 * 직원 이름으로 검색
	 */
	//Admin이 갖고 있는 배열을 Admin타입의 findByName의 변수 선언, 인자값은 String name
	public ArrayList<Admin> findByName(String name) throws Exception {
		// 조건식에서 찾은 객체를 담을 공간이 필요하므로 null을 선언 
		ArrayList<Admin> findList= new ArrayList<Admin>();
		//dao파일을 불러와서 admin을 갖고 있는 Arraylist를 adminList에 저장
		ArrayList<Admin> adminList = adminDao.readAll();
		//불러온 dao adminList가 갖고 있는 배열을 Admin타입의 admin(변수명)에 대입
		for (Admin admin : adminList) {
			//contains는 단어 하나만 포함해도 다 가져오는 명령어
			if (admin.getName().contains(name)) {
				//위 조건에 맞으면 findList에 추가해라
				findList.add(admin);
			}
		}
		return findList;
	}
	
	
	
	//-----------------------------------------------------------
	/*
	 * 직원 번호로 검색
	 */
	public Admin findByNo(int no) throws Exception {
		Admin findAdmin=null;
		ArrayList<Admin> adminList = adminDao.readAll();
		for (Admin admin : adminList) {
			if (admin.getNo()==no) {
				//위 if조건식에서 동일한 no를 admin.getNo에 대입하라고 선언해서
				//밑에 대입해야할 곳도 똑같이 admin
				findAdmin=admin;
			}
		}
		return findAdmin;
	}
	
	
	//-----------------------------------------------------------
	/*
	 * 직원 수정
	 */
	// Admin타입의 updateAdmin인자를 받아서 수정할 updateAdmin 메소드선언
	public void updateAdmin(Admin updateAdmin) throws Exception {
		// adminDao에 있는 데이터를 불러와서 인자와 동일한 객체를 업데이트 선언
		adminDao.update(updateAdmin);
	}
	
	
	//-----------------------------------------------------------
	/*
	 * 직원 삭제
	 */
	// Admin타입의 updateAdmin인자를 받아서 삭제할 updateAdmin 메소드선언
	//직원번호로 검색 후 삭제
	public void deleteAdmin(int no) throws Exception {
		// adminDao에 있는 데이터를 불러와서 인자와 동일한 객체를 삭제 선언
		adminDao.delete(no);
	}
	//직원아이디로 검색 후 삭제
	public void deleteAdmin(String name) throws Exception {
		// adminDao에 있는 데이터를 불러와서 인자와 동일한 객체를 삭제 선언
		adminDao.delete(name);
	}

}
