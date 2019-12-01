package project1.admin.test;

import java.util.ArrayList;

import project1.admin.Admin;
import project1.admin.AdminDao;

public class AdminDaoTestMain {

	public static void main(String[] args) throws Exception{
		
		AdminDao adminDao=new AdminDao();

		//---------------create 추가------------------
		/*adminDao.create(new Admin(
				1,
				"ㄱㄱㄱ",
				"aa", 
				"aa", 
				"01011111111", 
				"직원"));
				
		adminDao.create(new Admin(
				2,
				"ㄴㄴㄴ",
				"bb", 
				"bb", 
				"01022222222", 
				"직원"));
				*/
		
		
		
		
		//----------readOne(한개씩)불러오기--------------
		//직원이름으로 출력
		System.out.println(adminDao.readOne("ㄱㄱㄱ"));
		
		//직원번호로 출력
		System.out.println(adminDao.readOne(2));
		
		
		//---------------update------------------
		System.out.println("수정");
		adminDao.update(new Admin(2, "ㄷㄷㄷ", "cc", "ccc", "01023452431", "매니저"));
		
		
		//----------------readAll--------------------
		System.out.println("모두 불러오기");
		ArrayList<Admin> adminList=adminDao.readAll();
		System.out.println(adminList);
		
		
		//----------------delete--------------------
		System.out.println("삭제");
		//직원번호 2번을 검색해서 삭제
		adminDao.delete(2);
		
		
		//----------------readAll--------------------
		System.out.println("모두 불러오기");
		System.out.println(adminDao.readAll());
		

	}

}