package project1.nonmember;

import java.util.ArrayList;

public class NonMemberService {

	public NonMemberService() throws Exception{
		nonmemberDao = new NonmemberDao();
	}

	NonmemberDao  nonmemberDao;
	
	//��ȣ �ߺ� Ȯ��
	
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
		 * no�ߺ�üũ
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
	
	
	
	
	
    //��ȸ�� ��ȣ ����
	//public int nonmemberReturn(Nonmember nonmember) {
		
	//	return nonmember.getNo();
	//}
	
	/*
	 * ��ȸ�� ��� ����
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
	    * ������� 1.��ȸ�� ��ȣ , ���� �ð� �Է� - Dao���� �ش� ��ȣ read - �ܿ��ð� 0���� ���� update (�Է��� �ð���
	    * ������) 2. ���� �� update�� ���� ���
	    */
	/*  
	public int charge(int no, int fee) throws Exception {
	      int setfee =0;
	      setfee= setfee +fee;
	      nonmemberDao.update(no, setfee);
	      return setfee;
	   }   
*/
	//���� ����
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
	   * ��ȸ�� ��ȣ�� �Ѹ� ã�Ƽ� ��ȯ
	   */
	   public Nonmember findByno(int no) throws Exception{
			return nonmemberDao.readOne(no);
		}
	   
	   
	   /*
	    * ��ȸ�� ��� ã��
	    */
	public ArrayList<Nonmember> findByall() throws Exception{
		return nonmemberDao.readAll();
	}
	
	
	/*
	 * ��ȸ�� ��� ���� Ȯ��
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
	 *�����ڰ� ��ȸ�� ��ȣ�� �Ѹ� ã�Ƽ� ȸ�� ���� ����
	 */

	public Nonmember findoneup(int no) throws Exception {
		
		if (findoneup(no)==nonmemberDao.readOne(no)) {
			findoneup(no).setRestTime(findoneup(no).getRestTime());
		}
		
		
		return findoneup(no);
	}
	
	
	
	
}
