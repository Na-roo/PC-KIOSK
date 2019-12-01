package project1.admin.test;

import project1.admin.Admin;
import project1.admin.AdminService;

public class AdminServiceTestMain {

	public static void main(String[] args) throws Exception{
		//AdminServiceŸ���� adminService����(�����ϴ� ��ü���� ������ ����) = new AdminService();(�ν��Ͻ� ����)
		AdminService adminService=new AdminService();
	
		//1. ������ü��� Ȯ��
		System.out.println("----------------1. ������ü ���-------------");
		System.out.println("  ������ü������ ������id�� ������no�� �ߺ��Ǹ� �����ȵ�");
		System.out.println("-----------------------------------------");
		
		//adminRegister �����ϴ� �޼ҵ�
		//new Admin(No, Name, Id, Password, PhoneNo, Position)
		adminService.adminRegister(new Admin(1, "���翬", "jaeyeon", "159357", "01098726889", "����"));
		adminService.adminRegister(new Admin(2, "�յ���", "dongyeong", "789456", "01022248677", "����"));
		adminService.adminRegister(new Admin(3, "������", "jinook", "456123", "01083137181", "����"));
		adminService.adminRegister(new Admin(4, "�赵��", "doyeong", "357159", "01098726889", "�Ŵ���"));
		adminService.adminRegister(new Admin(5, "������", "yerin", "147369", "01023851201", "����"));
		adminService.adminRegister(new Admin(6, "���ȣ", "cuteKH-_-v", "1234", "01054844731", "�Ŵ���"));
	
		
		System.out.println("----------------1-1. no�ߺ� ���------------");
//		adminService.adminRegister(new Admin(1, "��", "FF", "fff", "01066666666", 1));
//		adminService.adminRegister(new Admin(3, "��", "GG", "ggg", "01077777777", 1));
//		
		System.out.println("----------------1-2. id�ߺ� ���------------");
//		adminService.adminRegister(new Admin(6, "��", "BB", "bbb", "01023456789", 1));
//		adminService.adminRegister(new Admin(7, "��", "DD", "ddd", "01098765432", 1));
//		
//		boolean a1 = adminService.adminRegister(new Admin(1, "��", "FF", "fff", "01066666666", 1));
//		System.out.println("1-1.������ü��� ��������: "+a1);
//		boolean a2 = adminService.adminRegister(new Admin(3, "��", "GG", "ggg", "01077777777", 1));
//		System.out.println("1-1.������ü��� ��������: "+a2);
//		
//		boolean b1 = adminService.adminRegister(new Admin(6, "��", "BB", "bbb", "01023456789", 1));
//		System.out.println("1-2.������ü��� ��������: "+b1);
//		boolean b2 = adminService.adminRegister(new Admin(7, "��", "DD", "ddd", "01098765432", 1));
//		System.out.println("1-2.������ü��� ��������: "+b2);
//
//		System.out.println("1. ��ϵ�������ü����"+adminService.findAllAdmin());
//		System.out.println();
		
		//----------------------------------------------------------------------------------------------
		
		//2. �����α��� Ȯ��
		System.out.println("----------------2. �����α���-------------");
		System.out.println("  �α��μ���:0, ���̵��������:1, �н��������ġ:2");
		System.out.println("-----------------------------------------");
		
		//login �α����ϴ� �޼ҵ�
		//login(id, password)
		//��������(result)�� int Ÿ������ ��ȯ��
		
		//����α���
		adminService.login("AA", "aaa");
		int aa1 = adminService.login("AA", "aaa");
		System.out.println("2. �����α��� ��������: "+aa1);
		
		//���̵�������ҽ�
		adminService.login("ZZ", "aaa");
		int aa2 = adminService.login("ZZ", "aaa");
		System.out.println("2. �����α��� ��������: "+aa2);
		
		//�н��������ġ
		adminService.login("BB", "ccc");
		int aa3 = adminService.login("BB", "ccc");
		System.out.println("2. �����α��� ��������: "+aa3);
		
		//----------------------------------------------------------------------------------------------
		
		//3. ���� ��ü �ҷ�����
		System.out.println("----------------3. ������ü���-------------");
		System.out.println(adminService.findAllAdmin());
		
		//----------------------------------------------------------------------------------------------
		
		//4-1. ���� �̸����� �˻�
		System.out.println("----------------4-1. ���� �̸����� �˻�-------------");
		adminService.findByName("��");
		System.out.println(adminService.findByName("��"));
		
		//4-2. ���� ��ȣ�� �˻�
		System.out.println("----------------4-2. ���� ��ȣ�� �˻�-------------");
		adminService.findByNo(2);
		System.out.println(adminService.findByNo(2));
		
		
		//----------------------------------------------------------------------------------------------
		
		//5. ���� �����ϱ�
		System.out.println("----------------5. ���� �����ϱ�-------------");
	
		
		
		//----------------------------------------------------------------------------------------------
		
		//6. ���� �����ϱ�
		System.out.println("----------------6. ���� �����ϱ�-------------");
		
		
		//----------------------------------------------------------------------------------------------
		
	}

}
