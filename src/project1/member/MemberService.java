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
	 * È¸¿ø°¡ÀÔ
	 */

	// ¾ÆÀÌµð À¯È¿¼º Ã¼Å©
	public boolean idIsValid(String newid) throws Exception {
		boolean isValid = false;
		//String pattern = "^[¤¡-¤¾°¡-ÆRa-zA-Z0-9]*$";
		ArrayList<Member> memberList = memberDao.readAll(); // Áßº¹Ã¼Å©
		for (Member member : memberList) {
			if (member.getId().equals(newid)) {
				isValid = true;
				break;
//			} else if (Pattern.matches(pattern, newid)) { // Æ¯¼ö¹®ÀÚ,°ø¹é Ã¼Å©
//				isValid = true;
//				break;
			}

		}
		return isValid;
	}

	// ºñ¹Ð¹øÈ£ °ø¹é È®ÀÎ
	public boolean passwordspace(String newpassword) {
		for (int i = 0; i < newpassword.length(); i++) {
			if (newpassword.charAt(i) == ' ') {
				return false;
			}
		}
		// newpassword=newpassword.replaceAll("\\p{Space}", "");
		return true;
	}

	// ºñ¹Ð¹øÈ£ ÀÏÄ¡ ¿©ºÎ È®ÀÎ
	public boolean passwordIsValid(String newpassword, String matchpassword) throws Exception {

		boolean isMatch = true;
		if (newpassword != matchpassword) {
			isMatch = false;
		}
		return isMatch;
	}

	// È¸¿ø°¡ÀÔ(È¸¿øµî·Ï)
	public void registerMember(Member newmember) throws Exception {
		memberDao.create(newmember);

	}

	// È¸¿ø ÀüÃ¼ ¸®½ºÆ® ¹ÝÈ¯
	public ArrayList<Member> findAllMember() throws Exception {
		return memberDao.readAll();
	}

	// È¸¿ø¼öÁ¤

	public void updateMember(Member updateMember) throws Exception {
		memberDao.update(updateMember);
	}

	// È¸¿ø ¹øÈ£·Î È¸¿ø»èÁ¦

	public void deleteMember(int no) throws Exception {
		memberDao.delete(no);
	}

	// È¸¿ø ¾ÆÀÌµð·Î È¸¿ø»èÁ¦
	public void deleteMember(String id) throws Exception {
		memberDao.delete(id);

	}

	// ¹®ÀÚ¿­À» °Ë»öÇÏ¸é ÇØ´ç ¹®ÀÚ¿­ÀÌ Æ÷ÇÔµÈ È¸¿øµé ¹ÝÈ¯
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

	// È¸¿ø ¾ÆÀÌµð·Î °Ë»ö

	public Member searchByID(String id) throws Exception {
		return memberDao.readOneById(id);
	}

	// È¸¿ø ÀÌ¸§À¸·Î °Ë»ö

	public Member searchByNAME(String name) throws Exception {
		return memberDao.readOne(name);
	}
	
	// È¸¿ø ¹øÈ£·Î °Ë»ö

		public Member searchByNo(int no) throws Exception {
			return memberDao.readOne(no);
		}
		
	
	// È¸¿ø ¹øÈ£·Î ¾ÆÀÌµð ¹ÝÈ¯
	public String returnID(int no) throws Exception {
		return memberDao.readOne(no).getId();
	}

	// È¸¿ø ¹øÈ£·Î ÀÌ¸§ ¹ÝÈ¯
	public String returnName(int no) throws Exception {
		return memberDao.readOne(no).getName();
	}

	// È¸¿ø ¹øÈ£·Î ³²Àº½Ã°£ ¹ÝÈ¯
	public int returnRTime(int no) throws Exception {
		return memberDao.readOne(no).getrTime();
	}

	// È¸¿ø¹øÈ£¿Í ¿ä±ÝÀ» ÀÔ·Â¹Þ¾Æ ÃæÀü ÈÄ ½Ã°£°ú ÀÜ¿©½Ã°£À» ¼öÁ¤
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

	// ÃæÀüÇÒ ¿ä±ÝÀ» ¼±ÅÃÇÏ¸é ÇØ´ç ¿ä±ÝÀ» ¹ÝÈ¯
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
