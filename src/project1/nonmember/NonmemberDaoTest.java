package project1.nonmember;

import java.util.ArrayList;


public class NonmemberDaoTest {

	public static void main(String[] args) throws Exception{
		
		NonmemberDao nonmemberDao=new NonmemberDao();
		System.out.println("-----------------create------------");
		
		//nonmemberDao.create();
		//nonmemberDao.create();
		
		
		System.out.println(nonmemberDao.readAll());
		System.out.println(nonmemberDao.readOne(1));

		//System.out.println(nonmemberDao.update(1, 60));
		System.out.println("----------------------------------------");
		nonmemberDao.delete(6);
		System.out.println(nonmemberDao.readAll());
		
		System.out.println(nonmemberDao.update(20, 60));
	
		
	}
	
	
	
	
	
	
	
	
	
}