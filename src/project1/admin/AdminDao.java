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
	 * admin_list.ser ���Ͽ� ��ü���� �����ϱ� ���� �޼ҵ�
	 */ 
	public void create(Admin admin) throws Exception {
		
		//readFile �޼ҵ� ȣ��� adminList �ҷ��� ��ɾ� ����
		ArrayList<Admin> adminList=readFile();
		
		//adminList�� ��ü�߰��Ҷ� �� ��ɾ� .add(admin)
		adminList.add(admin);
		writeFile(adminList);
	}
	
	
	//-----------------------------------------------------------
	
	
	/*
	 * Read
	 * ������ admin_list.ser ���Ͽ� ��ü���� �ҷ����� ���� �޼ҵ�
	 */
	
	public ArrayList<Admin> readAll() throws Exception {
		//�ҷ��� ArrayList�� readFile�� ��ȯ�Ѵ�
		return readFile();
	}
	
	//�����̸����� �˻��ؼ� �ҷ�����
	public Admin readOne(String name) throws Exception {
		// �����������ڿ� ��ġ�� �������� ��ü�ּҰ��� �����ϱ� ���� ������ Ȯ���ϱ� ���� �ʱ�ȭ
		Admin findAdmin=null;
		
		//readFile�� ȣ���ϸ� adminList�� �����Ͱ� �ҷ�������
		ArrayList<Admin> adminList=readFile();
		for (Admin admin : adminList) {
			//�������� ���ڿ� ������ �����͸� ã�ƶ�
			if (admin.getName().equals(name)) {
				//���ڷ� �������� �����͸� ã���� findAdmin�� ���Ե�
				findAdmin=admin;
				//���ǽ��� �����ϸ� �ݺ����� ��������
				break;					
			}
		}
		// �� �ݺ������� ã�� �����Ͱ� ��ȯ�ǵ��� ���
		return findAdmin;
	}
	
	//������ȣ�� �˻��ؼ� �ҷ�����
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
	 * ������ admin_list.ser ���Ͽ� ��ü���� �����ϱ� ���� �޼ҵ�
	 */
	
	//������ �޼ҵ带 ���� �޼ҵ�� update, ���� ���ڰ��� Admin updateAdmin�� ����
	public void update(Admin updateAdmin) throws Exception {
		
		//readFile�� ȣ���ϸ� adminList�� �����Ͱ� �ҷ�������
		ArrayList<Admin> adminList=this.readFile();
		for (int i = 0; i < adminList.size(); i++) {
			
			//�������ڰ��� ������ �����Ͱ�ü�� �����ϱ� ���� ������ tempAdmin ��������
			Admin tempAdmin=adminList.get(i);
			
			// updateAdmin.getNo() ��ü�� ������ ������ ��ü�� ���⿡ ����
			// tempAdmin.getNo() ������ ��ü�� �ӽ÷� ������ ���� tempAdmin�� ����
			if (tempAdmin.getNo()==updateAdmin.getNo()) {
				adminList.set(i, updateAdmin);
				break; 							//���ǹ��� �������Ͷ�
			}
		}
		this.writeFile(adminList);
	}
	
	
	
	//-----------------------------------------------------------
	
	
	/*
	 * Delete
	 * ������ admin_list.ser ���Ͽ� ��ü���� �����ϱ� ���� �޼ҵ�
	 */
	
	//������ �̸����� �˻��ؼ� ����
	public void delete(String name) throws Exception {
		//readFile�� ���������������ְ� �̰� ȣ���ҽ� adminList�� �ҷ������� ����
		ArrayList<Admin> adminList=this.readFile();
		for (int i = 0; i < adminList.size(); i++) {
			
			//���ڷ� �������� ��ü�� �����ϱ� ���� tempAdmin ��������
			Admin tempAdmin=adminList.get(i);
			//���ڷ� �������� �����Ϳ� ������ �����͸� ���� ��ü�� ã����� �ش� ��ü��
			// �����϶�� ���
			if (tempAdmin.getName().equals(name)) {
				adminList.remove(i);
				// ���ǹ��� �������Ͷ�
				break;
			}
		}
		//�� �ݺ����� ���ǽ��� adminList���Ͽ� write �Ƕ�� ���������־���
		this.writeFile(adminList);
	}
	
	//�����ڹ�ȣ�� �˻��ؼ� ����
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
	
	// ���ϻ����� ���� ����Ÿ���� adminFile�̶�� �̸��� ������ ����
	private File adminFile;
	
	// ���� �߻��ҽ� AdminDaoŬ�������� ����ó�� ���� �ͼ��� ó��
	// ��ӹ������� ��ü���� �����ϱ� ���ؼ� ������ �ʿ��ϱ� ������ ���� �ʱ�ȭ �۾��� init����
	public AdminDao() throws Exception {
		init();
	}
	
	private void init() throws Exception {
		// ������ ��� ������ ���� �� ������ϱ� ���� ���ϻ��� �۾�
		adminFile = new File("admin_list.ser");
		if (!adminFile.exists()) {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(adminFile));
			oos.writeObject(new ArrayList<Admin>());
		}
	}
	
	//admin_list.ser ������ �ҷ��ͼ� ������ �����ڵ��� ���(arraylist)�� �Է� �� �о���� �޼ҵ�
	private ArrayList<Admin> readFile() throws Exception {
		//ObjectInputStream Ÿ���� ois ���� = ObjectInputStream ��ü���� �� ��ü�� ���� (adminFile�� ȣ���ϱ�����)
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(adminFile));

		//����ȭ�� ois ������ accountList ��ü���� �������� ���
		ArrayList<Admin> accountList = (ArrayList<Admin>) ois.readObject();
		
		//ois ��Ʈ���� �ݴ´�
		ois.close();
		return accountList;
	}
	
	//�����Ͱ� ����� admin_list.ser�� ���Ͼ��� �����͵��� ��½�ų �޼ҵ� 
	private void writeFile(ArrayList<Admin> accountList) throws Exception {
		//ObjectOutputStream Ÿ���� oos ���� = ObjectOutputStream ��ü���� �� ��ü�� ���� (adminFile�� ȣ���ϱ�����)
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(adminFile));
		//����ȭ�� oos ������ accountList ��ü���� �������� ��
		oos.writeObject(accountList);
		
		//oos ��Ʈ���� �ݴ´�
		oos.close();
	}
	
	

	
	
}
