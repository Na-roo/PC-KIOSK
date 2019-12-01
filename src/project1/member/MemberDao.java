package project1.member;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class MemberDao {
	private File memberfile;

	public MemberDao() throws Exception {
		memberfile = new File("member.dat");
		if (!memberfile.exists()) {
			memberfile.createNewFile();
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(memberfile));
			oos.writeObject(new ArrayList<Member>());
			oos.close();
		}

	}

	// member file �б�(����)
	private ArrayList<Member> readFile() throws Exception {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(memberfile));
		ArrayList<Member> memberlist = (ArrayList<Member>) ois.readObject();
		return memberlist;

	}

	// member file ����(����)
	private void writeFile(ArrayList<Member> memberlist) throws Exception {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(memberfile));
		oos.writeObject(memberlist);
		oos.flush();
		oos.close();
	}

	/************************** CRUD ********************************/

	/*
	 * insert(create)
	 */
	public void create(Member addMember) throws Exception {

		ArrayList<Member> memberList = this.readFile();
		memberList.add(addMember);
		writeFile(memberList);
	}

	/*
	 * read : ȸ����ȣ�� ��� 1�� ��ȯ
	 */
	public Member readOne(int no) throws Exception {
		Member findMember = null;
		ArrayList<Member> memberList = this.readFile();
		for (Member memberVO : memberList) {
			if (memberVO.getNo() == no) {
				findMember = memberVO;
				break;
			}
		}
		return findMember;
	}

	// ȸ�����̵�� ��� 1�� ��ȯ
	public Member readOneById(String id) throws Exception {
		Member findMember = null;
		ArrayList<Member> memberList = this.readFile();
		for (Member memberVO : memberList) {
			if (memberVO.getId().contains(id)) {
				findMember = memberVO;
				break;
			}
		}
		return findMember;
	}

	// ȸ�� �̸����� ��� 1�� ��ȯ
	public Member readOne(String name) throws Exception {
		Member findMember = null;
		ArrayList<Member> memberList = this.readFile();
		for (Member memberVO : memberList) {
			if (memberVO.getName().equals(name)) {
				findMember = memberVO;
				break;
			}
		}
		return findMember;
	}
	
	
	
	
	
	

	/*
	 * read 
	 */
	
	public ArrayList<Member> readAll() throws Exception {
		ArrayList<Member> memberList = this.readFile();
		return memberList;
	}

	/*
	 * update
	 */
	public void update(Member updateM) throws Exception {
		ArrayList<Member> memberList = this.readFile();
		for (Member member : memberList) {
			if (member.getNo() == updateM.getNo()) {
				member.setNo(member.getNo());
				member.setId(updateM.getId());
				member.setName(updateM.getName());
				member.setPassword(updateM.getPassword());
				member.setBirth(updateM.getBirth());
				member.setTelNum(updateM.getTelNum());
				member.setrTime(updateM.getrTime());
				member.setcTime(updateM.getcTime());
				break;
			}
		}
		this.writeFile(memberList);

	}

	
	
	/*
	 * delete
	 */
	
	
	
	//ȸ����ȣ�� ����
	public void delete(int no) throws Exception{
		ArrayList<Member> memberList=this.readFile();
		for (Member member : memberList) {
			if(member.getNo()==no) {
				memberList.remove(member);
				break;
			}
		}
		this.writeFile(memberList);
	}
	
	//ȸ�����̵�� ����
	public void delete(String id) throws Exception {
		ArrayList<Member> memberList = this.readFile();
		for (Member member : memberList) {
			if (member.getId().equals(id)) {
				memberList.remove(member);
				break;
			}
		}
		this.writeFile(memberList);
	}

}
