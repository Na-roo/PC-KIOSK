package project1.admin;

import java.util.ArrayList;

/*
 * Admin ��ü ��ü�� ���õ� ������ ������ Ŭ����
 */
public class AdminService {
	private AdminDao adminDao;
	
	public AdminService() throws Exception {
		adminDao = new AdminDao();
	}

	
	
	//-----------------------------------------------------------\
	/*
	 * ������ü ���
	 */
	//���� �߰��� ���� boolean Ÿ���� adminRegister �޼ҵ弱��,���ڴ� Admin addAdmin
	public boolean adminRegister(Admin addAdmin) throws Exception {
		boolean isSuccess=true;
		
		/*
		 * ����� ������ id�ߺ�üũ
		 */
		
		//dao������ �ҷ��ͼ� admin�� ���� �ִ� Arraylist�� adminList�� ����
		ArrayList<Admin> adminList=adminDao.readAll();
		//adminList�� ���� �ִ� �迭�� AdminŸ���� admin(������)�� ����
		for (Admin admin : adminList) {
			//���࿡ �߰��� id(stringŸ��) �ּҰ��� ������ �迭�߿��� ��ġ�ϴ°� �ִٸ� 
			if (admin.getId().equals(addAdmin.getId()) || admin.getNo()==addAdmin.getNo()) {
				//����� �����̸�, ���ǹ� ���� 
				isSuccess=false;
				break;
				
			}
		}
		// �ڷ��� ������ ó���� true��� �������־����Ƿ� ���������� �ϳ� ���
		if (isSuccess) {
			adminDao.create(addAdmin);
		}
		// �� �ݺ������� ã�� �����Ͱ� ��ȯ�ǵ��� ���
		return isSuccess;
	}
	
	
	
	//-----------------------------------------------------------
	/*
	 * ������ �α���
	 */
	//�α����� ���� int Ÿ���� login �޼ҵ弱��, ���� ���ڴ� String id,String password
	public int login(String id,String password) throws Exception {
		/*
		 * 1.ȸ�����翩��
		 */
		// ��ȯ�� �����͸� ���� ��ȯŸ�Ժ����� ������ ���� ����
		int result=-9999;
		/*
		 * 0:����
		 * 1:���̵��������
		 * 2:�о��������ġ
		 */
		//���ڰ� id�� ���� dao�����͸� �����ͼ� Admin Ÿ���� findAdmin �������
		Admin findAdmin=adminDao.readOne(id);
		// ������ �ּҰ��� null�� �ƴҶ�
		if (findAdmin!=null) {
			// �Է��� password�� �ּҰ��� dao�� �ִ� password�� �ּҰ��� ������ ����
			if (findAdmin.getPassword().equals(password)) {
				result=0;
			}else {
				//�ƴ϶�� ����� 2 �н����� ����ġ
				result=2;
			}
		}else {
			//�̰͵� �ƴ϶�� ����� 1 ���̵��������
			result=1;
		}
		// �����ǽĿ� �ش��� result ������� Admin findAdmin�� ��ȯ
		return result;
	}
	
	
	
	//-----------------------------------------------------------
	/*
	 * ���� ��ü�˻�
	 */
	//�迭 ��ü�� �ҷ��;��ϴ°Ŵϱ� �̰Ŵ� List �� �����ϴ°� ����
	public ArrayList<Admin> findAllAdmin() throws Exception {
		ArrayList<Admin> adminList = adminDao.readAll();
		return adminList;
	}
	
	
	
	//-----------------------------------------------------------
	/*
	 * ���� �̸����� �˻�
	 */
	//Admin�� ���� �ִ� �迭�� AdminŸ���� findByName�� ���� ����, ���ڰ��� String name
	public ArrayList<Admin> findByName(String name) throws Exception {
		// ���ǽĿ��� ã�� ��ü�� ���� ������ �ʿ��ϹǷ� null�� ���� 
		ArrayList<Admin> findList= new ArrayList<Admin>();
		//dao������ �ҷ��ͼ� admin�� ���� �ִ� Arraylist�� adminList�� ����
		ArrayList<Admin> adminList = adminDao.readAll();
		//�ҷ��� dao adminList�� ���� �ִ� �迭�� AdminŸ���� admin(������)�� ����
		for (Admin admin : adminList) {
			//contains�� �ܾ� �ϳ��� �����ص� �� �������� ��ɾ�
			if (admin.getName().contains(name)) {
				//�� ���ǿ� ������ findList�� �߰��ض�
				findList.add(admin);
			}
		}
		return findList;
	}
	
	
	
	//-----------------------------------------------------------
	/*
	 * ���� ��ȣ�� �˻�
	 */
	public Admin findByNo(int no) throws Exception {
		Admin findAdmin=null;
		ArrayList<Admin> adminList = adminDao.readAll();
		for (Admin admin : adminList) {
			if (admin.getNo()==no) {
				//�� if���ǽĿ��� ������ no�� admin.getNo�� �����϶�� �����ؼ�
				//�ؿ� �����ؾ��� ���� �Ȱ��� admin
				findAdmin=admin;
			}
		}
		return findAdmin;
	}
	
	
	//-----------------------------------------------------------
	/*
	 * ���� ����
	 */
	// AdminŸ���� updateAdmin���ڸ� �޾Ƽ� ������ updateAdmin �޼ҵ弱��
	public void updateAdmin(Admin updateAdmin) throws Exception {
		// adminDao�� �ִ� �����͸� �ҷ��ͼ� ���ڿ� ������ ��ü�� ������Ʈ ����
		adminDao.update(updateAdmin);
	}
	
	
	//-----------------------------------------------------------
	/*
	 * ���� ����
	 */
	// AdminŸ���� updateAdmin���ڸ� �޾Ƽ� ������ updateAdmin �޼ҵ弱��
	//������ȣ�� �˻� �� ����
	public void deleteAdmin(int no) throws Exception {
		// adminDao�� �ִ� �����͸� �ҷ��ͼ� ���ڿ� ������ ��ü�� ���� ����
		adminDao.delete(no);
	}
	//�������̵�� �˻� �� ����
	public void deleteAdmin(String name) throws Exception {
		// adminDao�� �ִ� �����͸� �ҷ��ͼ� ���ڿ� ������ ��ü�� ���� ����
		adminDao.delete(name);
	}

}
