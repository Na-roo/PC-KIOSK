package project1.nonmember;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import project1.member.Member;





public class NonmemberDao {
private File nonmemberFile;
	
	public NonmemberDao() throws Exception{
		nonmemberFile = new File("nonmembers.ser");
		if(!nonmemberFile.exists()) {
			//처음실행
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nonmemberFile));
			oos.writeObject(new ArrayList<Nonmember>());
			oos.close();
			System.out.println("---------------파일 생성-----------------");
		}
		else {
		System.out.println("---------------파일 존재-----------------");
		}
	}
	//파일읽기(members.ser --> ArrayList<Member>)
	public ArrayList<Nonmember> readFile() throws Exception{
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nonmemberFile));	//파일 읽기
				
		ArrayList<Nonmember> nonmemberList = (ArrayList<Nonmember>)ois.readObject();				//데이터 읽기
		ois.close();
		return nonmemberList;
	}
	
	//파일저장(ArrayList<Member> --> members.ser)
	public void writeFile(ArrayList<Nonmember> nonmemberList) throws Exception{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nonmemberFile));
		oos.writeObject(nonmemberList);
		oos.close();
	}
	
	/*
	 * Create
	 */
	public void create(Nonmember nonmember) throws Exception {
		
		
		ArrayList<Nonmember> nonmemberList = readFile();
		nonmemberList.add(nonmember);
		writeFile(nonmemberList);
	}
	
	//번호 찾기
	public Nonmember readByNo(int no) throws Exception {
		Nonmember nonmember = null;
		ArrayList<Nonmember> nonmemberList = readFile();
		for (int i = 0; i <nonmemberList.size(); i++) {
			Nonmember tempNonMember = nonmemberList.get(i);
			if (tempNonMember.getNo() == no) {
				nonmember = tempNonMember;
			}
		}
		return nonmember;
	}
	
	//UPDATE
	
		/*
	public void update(Nonmember updateNonmember) throws Exception {
		ArrayList<Nonmember> nonmemberList = this.readFile();

		for (int i = 0; i < nonmemberList.size(); i++) {
			Nonmember tempNonmember = nonmemberList.get(i);
			if (tempNonmember.getNo() == updateNonmember.getNo()) {
				nonmemberList.set(i, updateNonmember);
				break;
			}
		}

		this.writeFile(nonmemberList);

	}
	*/
	public boolean update(int no, int time) throws Exception{
		ArrayList<Nonmember>  nonmemberList =readFile();
		  boolean charge = false;
	      for (int i = 0; i < nonmemberList.size(); i++) {
	         Nonmember tempNonmember = nonmemberList.get(i);
	         if (tempNonmember.getNo()==no) {
	          
	            tempNonmember.setRestTime(time);
	            nonmemberList.set(i, tempNonmember);
	            charge = true;
	         }
	      }
	      this.writeFile(nonmemberList);
	      return charge;
	}
	
	
	
	/*
	 * Read
	 */
	public ArrayList<Nonmember> readAll() throws Exception {
		return readFile();
	}
	/*
	 * Read
	 */
	public Nonmember readOne(int no) throws Exception {
		Nonmember findNonmember = null;
		ArrayList<Nonmember> NonmemberList = readFile();
		for (Nonmember nonmember : NonmemberList) {
			if (nonmember.getNo() == no) {
				findNonmember = nonmember;
				break;
			}
		}
		return findNonmember;
	}
	
	
	/*
	 *Delete
	 */
	public void delete(int no) throws Exception{
		ArrayList<Nonmember> nonmemberList = this.readFile();
		for (int i = 0; i <nonmemberList.size(); i++) {
			Nonmember tempNonmember = nonmemberList.get(i);
			if (tempNonmember.getNo() == no) {
				nonmemberList.remove(i);
				break;
			}
		}
		this.writeFile(nonmemberList);
	}
	
	
	
	
	
	
	
	
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	


