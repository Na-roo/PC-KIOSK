package project1.nonmember;

import java.util.ArrayList;

public class NonMemberService {

	public NonMemberService() throws Exception{
		nonmemberDao = new NonmemberDao();
	}

	NonmemberDao  nonmemberDao;
	
	//번호 중복 확인
	
	/*
	public boolean nonJoin(Nonmember nonmember) throws Exception {
	      boolean isJoin = false;
	      Nonmember getNo =nonmemberDao.readByNo(nonmember.getNo());
	      if (getNo == null) {
	         int setNo = (int) (Math.random() * 30);
	         if (nonmemberDao.readByNo(setNo) == null) {
	            nonmember.setNo(setNo);
	         } else {
	            setNo = (int) (Math.random() * 30);
	            nonmember.setNo(setNo);
	         }
	         nonmemberDao.create();
	         
	         isJoin = true;
	      }
	     
	      return isJoin;
	      
	   }
	*/
	/***************************************************************************/
	
	
	public int nonjoin(Nonmember addNonmember) throws Exception{
		int nonNo = 0;
		boolean isSuccess=true;
		
		/*
		 * no중복체크
		 */
		int nonmemberNo = (int) (Math.random() * 9999+1);
		ArrayList<Nonmember> nonmemberList = nonmemberDao.readAll();
		addNonmember.setNo(nonmemberNo);
		for (Nonmember nonmember : nonmemberList) {
			if(nonmember.getNo()==addNonmember.getNo()) {
				isSuccess=false;
				break;
			}
		}
		if(isSuccess) {
			nonmemberDao.create(addNonmember);
			nonNo = nonmemberNo;
		}
		return nonNo;
	}
	
	
	
	
	
    //비회원 번호 리턴
	//public int nonmemberReturn(Nonmember nonmember) {
		
	//	return nonmember.getNo();
	//}
	
	/*
	 * 비회원 요금 충전
	 */
	/*
	 public int charge(int no, int fee) throws Exception {
	      int tempfee =0;
	      tempfee = tempfee +fee;
	      nonmemberDao.update(null);
	      return tempfee;
	   }
*/
	 /*
	    * 요금충전 1.비회원 번호 , 충전 시간 입력 - Dao에서 해당 번호 read - 잔여시간 0에서 정보 update (입력한 시간을
	    * 더해줌) 2. 충전 후 update된 정보 출력
	    */
	/*  
	public int charge(int no, int fee) throws Exception {
	      int setfee =0;
	      setfee= setfee +fee;
	      nonmemberDao.update(no, setfee);
	      return setfee;
	   }   
*/
	//충전 서비스
	public Nonmember charge(int no ,int fee) throws Exception{
		Nonmember chargeNon = nonmemberDao.readOne(no);
		switch (fee) {
		case(1000):
			chargeNon.setRestTime(chargeNon.getRestTime()+1);
			break;
		case(2000):
			chargeNon.setRestTime(chargeNon.getRestTime()+2);
		break;
		case(3000):
			chargeNon.setRestTime(chargeNon.getRestTime()+3);
		break;
		case(5000):
			chargeNon.setRestTime(chargeNon.getRestTime()+5);
		break;
		case(10000):
			chargeNon.setRestTime(chargeNon.getRestTime()+10);
		break;

		default:
			break;
		}
		
		
		return chargeNon;
	}
		
	
	
	
	  /*
	   * 비회원 번호로 한명 찾아서 반환
	   */
	   public Nonmember findByno(int no) throws Exception{
			return nonmemberDao.readOne(no);
		}
	   
	   
	   /*
	    * 비회원 모두 찾기
	    */
	public ArrayList<Nonmember> findByall() throws Exception{
		return nonmemberDao.readAll();
	}
	
	
	/*
	 * 비회원 사용 여부 확인
	 */
	/*
	public boolean findues(int restTime){
		ArrayList<Nonmember> nonmemberList = nonmemberDao.readAll();
		for (Nonmember nonmember : nonmemberList) {
			if(nonmember.getRestTime()>0) {
				findues true;
			}
		}
		return false;
	}
	*/
	/*
	 *관리자가 비회원 번호로 한명 찾아서 회원 정보 수정
	 */

	public Nonmember findoneup(int no) throws Exception {
		
		if (findoneup(no)==nonmemberDao.readOne(no)) {
			findoneup(no).setRestTime(findoneup(no).getRestTime());
		}
		
		
		return findoneup(no);
	}
	
	
	
	
}
