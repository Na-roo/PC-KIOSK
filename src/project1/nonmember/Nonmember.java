package project1.nonmember;

import java.io.Serializable;

public class Nonmember implements Serializable{
	private int no;
	private int restTime;
	
	public Nonmember() {
		
	}
	
	public Nonmember(int no, int restTime) {
		super();
		this.no = no;
		this.restTime = restTime;
	}



	/*
	 * toString ¿Á¡§¿«
	 */
	
	@Override
	public String toString() {
		return "Nonmember [no=" + no + ", restTime=" + restTime + "]";
	}

	public int getNo() {
		return no;
	}



	public void setNo(int no) {
		this.no = no;
	}


	public int getRestTime() {
		return restTime;
	}


	public void setRestTime(int restTime) {
		this.restTime = restTime;
	}

	
}
	
