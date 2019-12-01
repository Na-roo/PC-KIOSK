package project1.member;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class MemberService {

	private static MemberService _instance;

	private MemberDao memberDao;

	public MemberService() throws Exception {
		memberDao = new MemberDao();
	}

	public static MemberService getInstance() throws Exception {
		if (_instance == null) {
			_instance = new MemberService();
		}
		return _instance;
	}

	/*
	 * ȸ������
	 */

	// ���̵� ��ȿ�� üũ
	public boolean idIsValid(String newid) throws Exception {
		boolean isValid = false;
		//String pattern = "^[��-����-�Ra-zA-Z0-9]*$";
		ArrayList<Member> memberList = memberDao.readAll(); // �ߺ�üũ
		for (Member member : memberList) {
			if (member.getId().equals(newid)) {
				isValid = true;
				break;
//			} else if (Pattern.matches(pattern, newid)) { // Ư������,���� üũ
//				isValid = true;
//				break;
			}

		}
		return isValid;
	}

	// ��й�ȣ ���� Ȯ��
	public boolean passwordspace(String newpassword) {
		for (int i = 0; i < newpassword.length(); i++) {
			if (newpassword.charAt(i) == ' ') {
				return false;
			}
		}
		// newpassword=newpassword.replaceAll("\\p{Space}", "");
		return true;
	}

	// ��й�ȣ ��ġ ���� Ȯ��
	public boolean passwordIsValid(String newpassword, String matchpassword) throws Exception {

		boolean isMatch = true;
		if (newpassword != matchpassword) {
			isMatch = false;
		}
		return isMatch;
	}

	// ȸ������(ȸ�����)
	public void registerMember(Member newmember) throws Exception {
		memberDao.create(newmember);

	}

	// ȸ�� ��ü ����Ʈ ��ȯ
	public ArrayList<Member> findAllMember() throws Exception {
		return memberDao.readAll();
	}

	// ȸ������

	public void updateMember(Member updateMember) throws Exception {
		memberDao.update(updateMember);
	}

	// ȸ�� ��ȣ�� ȸ������

	public void deleteMember(int no) throws Exception {
		memberDao.delete(no);
	}

	// ȸ�� ���̵�� ȸ������
	public void deleteMember(String id) throws Exception {
		memberDao.delete(id);

	}

	// ���ڿ��� �˻��ϸ� �ش� ���ڿ��� ���Ե� ȸ���� ��ȯ
	public ArrayList<Member> searchByString(String str) throws Exception {
		ArrayList<Member> memberList = memberDao.readAll();
		ArrayList<Member> returnMemberList = new ArrayList<Member>();
		for (Member member : memberList) {
			if (member.getId().contains(str) || member.getName().contains(str)) {
				returnMemberList.add(member);
			}
		}
		return returnMemberList;
	}

	// ȸ�� ���̵�� �˻�

	public Member searchByID(String id) throws Exception {
		return memberDao.readOneById(id);
	}

	// ȸ�� �̸����� �˻�

	public Member searchByNAME(String name) throws Exception {
		return memberDao.readOne(name);
	}
	
	// ȸ�� ��ȣ�� �˻�

		public Member searchByNo(int no) throws Exception {
			return memberDao.readOne(no);
		}
		
	
	// ȸ�� ��ȣ�� ���̵� ��ȯ
	public String returnID(int no) throws Exception {
		return memberDao.readOne(no).getId();
	}

	// ȸ�� ��ȣ�� �̸� ��ȯ
	public String returnName(int no) throws Exception {
		return memberDao.readOne(no).getName();
	}

	// ȸ�� ��ȣ�� �����ð� ��ȯ
	public int returnRTime(int no) throws Exception {
		return memberDao.readOne(no).getrTime();
	}

	// ȸ����ȣ�� ����� �Է¹޾� ���� �� �ð��� �ܿ��ð��� ����
	public Member chargedByFee(int no, int fee) throws Exception {
		Member updateM = memberDao.readOne(no);

		switch (fee) {
		case (1000):
			updateM.setcTime(1);
			updateM.setrTime(updateM.getrTime() + updateM.getcTime());
			memberDao.update(updateM);
			
			break;
		case (2000):
			updateM.setcTime(2);
			updateM.setrTime(updateM.getrTime() + updateM.getcTime());
			memberDao.update(updateM);
			break;
		case (3000):
			updateM.setcTime(3);
			updateM.setrTime(updateM.getrTime() + updateM.getcTime());
			memberDao.update(updateM);
			break;
		case (4000):
			updateM.setcTime(4);
			updateM.setrTime(updateM.getrTime() + updateM.getcTime());
			memberDao.update(updateM);

			break;
		case (5000):
			updateM.setcTime(5);
			updateM.setrTime(updateM.getrTime() + updateM.getcTime());
			memberDao.update(updateM);

			break;
		case (10000):
			updateM.setcTime(10);
			updateM.setrTime(updateM.getrTime() + updateM.getcTime());
			memberDao.update(updateM);

			break;

		default:

		}
		return updateM;

	}

	// ������ ����� �����ϸ� �ش� ����� ��ȯ
	public int returnFee(int fee) {
		switch (fee) {
		case (1000):
			break;
		case (2000):
			break;
		case (3000):
			break;
		case (4000):
			break;
		case (5000):
			break;
		case (10000):
			break;
		default:
		}
		return fee;
	}

}
