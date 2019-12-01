package project1.admin.test;

import project1.admin.Admin;
import project1.admin.AdminService;

public class AdminServiceTestMain {

	public static void main(String[] args) throws Exception{
		//AdminService타입의 adminService변수(생성하는 객체들을 저장할 공간) = new AdminService();(인스턴스 생성)
		AdminService adminService=new AdminService();
	
		//1. 직원객체등록 확인
		System.out.println("----------------1. 직원객체 등록-------------");
		System.out.println("  직원객체생성시 직원의id나 직원의no가 중복되면 생성안됨");
		System.out.println("-----------------------------------------");
		
		//adminRegister 생성하는 메소드
		//new Admin(No, Name, Id, Password, PhoneNo, Position)
		adminService.adminRegister(new Admin(1, "이재연", "jaeyeon", "159357", "01098726889", "사장"));
		adminService.adminRegister(new Admin(2, "손동영", "dongyeong", "789456", "01022248677", "직원"));
		adminService.adminRegister(new Admin(3, "최진욱", "jinook", "456123", "01083137181", "직원"));
		adminService.adminRegister(new Admin(4, "김도영", "doyeong", "357159", "01098726889", "매니저"));
		adminService.adminRegister(new Admin(5, "설예린", "yerin", "147369", "01023851201", "직원"));
		adminService.adminRegister(new Admin(6, "김경호", "cuteKH-_-v", "1234", "01054844731", "매니저"));
	
		
		System.out.println("----------------1-1. no중복 경우------------");
//		adminService.adminRegister(new Admin(1, "바", "FF", "fff", "01066666666", 1));
//		adminService.adminRegister(new Admin(3, "사", "GG", "ggg", "01077777777", 1));
//		
		System.out.println("----------------1-2. id중복 경우------------");
//		adminService.adminRegister(new Admin(6, "아", "BB", "bbb", "01023456789", 1));
//		adminService.adminRegister(new Admin(7, "자", "DD", "ddd", "01098765432", 1));
//		
//		boolean a1 = adminService.adminRegister(new Admin(1, "바", "FF", "fff", "01066666666", 1));
//		System.out.println("1-1.직원객체등록 성공유무: "+a1);
//		boolean a2 = adminService.adminRegister(new Admin(3, "사", "GG", "ggg", "01077777777", 1));
//		System.out.println("1-1.직원객체등록 성공유무: "+a2);
//		
//		boolean b1 = adminService.adminRegister(new Admin(6, "아", "BB", "bbb", "01023456789", 1));
//		System.out.println("1-2.직원객체등록 성공유무: "+b1);
//		boolean b2 = adminService.adminRegister(new Admin(7, "자", "DD", "ddd", "01098765432", 1));
//		System.out.println("1-2.직원객체등록 성공유무: "+b2);
//
//		System.out.println("1. 등록된직원전체보기"+adminService.findAllAdmin());
//		System.out.println();
		
		//----------------------------------------------------------------------------------------------
		
		//2. 직원로그인 확인
		System.out.println("----------------2. 직원로그인-------------");
		System.out.println("  로그인성공:0, 아이디존재안함:1, 패스워드불일치:2");
		System.out.println("-----------------------------------------");
		
		//login 로그인하는 메소드
		//login(id, password)
		//성공유무(result)를 int 타입으로 반환함
		
		//정상로그인
		adminService.login("AA", "aaa");
		int aa1 = adminService.login("AA", "aaa");
		System.out.println("2. 직원로그인 성공유무: "+aa1);
		
		//아이디존재안할시
		adminService.login("ZZ", "aaa");
		int aa2 = adminService.login("ZZ", "aaa");
		System.out.println("2. 직원로그인 성공유무: "+aa2);
		
		//패스워드불일치
		adminService.login("BB", "ccc");
		int aa3 = adminService.login("BB", "ccc");
		System.out.println("2. 직원로그인 성공유무: "+aa3);
		
		//----------------------------------------------------------------------------------------------
		
		//3. 직원 전체 불러오기
		System.out.println("----------------3. 직원전체출력-------------");
		System.out.println(adminService.findAllAdmin());
		
		//----------------------------------------------------------------------------------------------
		
		//4-1. 직원 이름으로 검색
		System.out.println("----------------4-1. 직원 이름으로 검색-------------");
		adminService.findByName("다");
		System.out.println(adminService.findByName("다"));
		
		//4-2. 직원 번호로 검색
		System.out.println("----------------4-2. 직원 번호로 검색-------------");
		adminService.findByNo(2);
		System.out.println(adminService.findByNo(2));
		
		
		//----------------------------------------------------------------------------------------------
		
		//5. 직원 수정하기
		System.out.println("----------------5. 직원 수정하기-------------");
	
		
		
		//----------------------------------------------------------------------------------------------
		
		//6. 직원 삭제하기
		System.out.println("----------------6. 직원 삭제하기-------------");
		
		
		//----------------------------------------------------------------------------------------------
		
	}

}
