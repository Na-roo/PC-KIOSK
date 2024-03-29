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
	 * 회원가입
	 */

	// 아이디 유효성 체크
	public boolean idIsValid(String newid) throws Exception {
		boolean isValid = false;
		//String pattern = "^[ㄱ-ㅎ가-힣a-zA-Z0-9]*$";
		ArrayList<Member> memberList = memberDao.readAll(); // 중복체크
		for (Member member : memberList) {
			if (member.getId().equals(newid)) {
				isValid = true;
				break;
//			} else if (Pattern.matches(pattern, newid)) { // 특수문자,공백 체크
//				isValid = true;
//				break;
			}

		}
		return isValid;
	}

	// 비밀번호 공백 확인
	public boolean passwordspace(String newpassword) {
		for (int i = 0; i < newpassword.length(); i++) {
			if (newpassword.charAt(i) == ' ') {
				return false;
			}
		}
		// newpassword=newpassword.replaceAll("\\p{Space}", "");
		return true;
	}

	// 비밀번호 일치 여부 확인
	public boolean passwordIsValid(String newpassword, String matchpassword) throws Exception {

		boolean isMatch = true;
		if (newpassword != matchpassword) {
			isMatch = false;
		}
		return isMatch;
	}

	// 회원가입(회원등록)
	public void registerMember(Member newmember) throws Exception {
		memberDao.create(newmember);

	}

	// 회원 전체 리스트 반환
	public ArrayList<Member> findAllMember() throws Exception {
		return memberDao.readAll();
	}

	// 회원수정

	public void updateMember(Member updateMember) throws Exception {
		memberDao.update(updateMember);
	}

	// 회원 번호로 회원삭제

	public void deleteMember(int no) throws Exception {
		memberDao.delete(no);
	}

	// 회원 아이디로 회원삭제
	public void deleteMember(String id) throws Exception {
		memberDao.delete(id);

	}

	// 문자열을 검색하면 해당 문자열이 포함된 회원들 반환
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

	// 회원 아이디로 검색

	public Member searchByID(String id) throws Exception {
		return memberDao.readOneById(id);
	}

	// 회원 이름으로 검색

	public Member searchByNAME(String name) throws Exception {
		return memberDao.readOne(name);
	}
	
	// 회원 번호로 검색

		public Member searchByNo(int no) throws Exception {
			return memberDao.readOne(no);
		}
		
	
	// 회원 번호로 아이디 반환
	public String returnID(int no) throws Exception {
		return memberDao.readOne(no).getId();
	}

	// 회원 번호로 이름 반환
	public String returnName(int no) throws Exception {
		return memberDao.readOne(no).getName();
	}

	// 회원 번호로 남은시간 반환
	public int returnRTime(int no) throws Exception {
		return memberDao.readOne(no).getrTime();
	}

	// 회원번호와 요금을 입력받아 충전 후 시간과 잔여시간을 수정
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

	// 충전할 요금을 선택하면 해당 요금을 반환
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
