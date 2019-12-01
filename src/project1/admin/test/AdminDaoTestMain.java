package project1.admin.test;

import java.util.ArrayList;

import project1.admin.Admin;
import project1.admin.AdminDao;

public class AdminDaoTestMain {

	public static void main(String[] args) throws Exception{
		
		AdminDao adminDao=new AdminDao();

		//---------------create �߰�------------------
		/*adminDao.create(new Admin(
				1,
				"������",
				"aa", 
				"aa", 
				"01011111111", 
				"����"));
				
		adminDao.create(new Admin(
				2,
				"������",
				"bb", 
				"bb", 
				"01022222222", 
				"����"));
				*/
		
		
		
		
		//----------readOne(�Ѱ���)�ҷ�����--------------
		//�����̸����� ���
		System.out.println(adminDao.readOne("������"));
		
		//������ȣ�� ���
		System.out.println(adminDao.readOne(2));
		
		
		//---------------update------------------
		System.out.println("����");
		adminDao.update(new Admin(2, "������", "cc", "ccc", "01023452431", "�Ŵ���"));
		
		
		//----------------readAll--------------------
		System.out.println("��� �ҷ�����");
		ArrayList<Admin> adminList=adminDao.readAll();
		System.out.println(adminList);
		
		
		//----------------delete--------------------
		System.out.println("����");
		//������ȣ 2���� �˻��ؼ� ����
		adminDao.delete(2);
		
		
		//----------------readAll--------------------
		System.out.println("��� �ҷ�����");
		System.out.println(adminDao.readAll());
		

	}

}