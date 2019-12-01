package project1.product;

import java.io.Serializable;

/*
 * VO(Value Object)��ü,DTO(Data Transfer Object)��ü
 *   - ��ǰ 1���� ����Ÿ�� �������ִ� ��ü
 *   - ���� 1�� ���ڵ�,DB ���̺� �Ѱ� row
 */
public class Product implements Serializable{
	/*
	 * ����ʵ�
	 */
	private int No; //��ǰ��ȣ
	/*
	 * - �ߺ����� �ʾƾ��ϴ� �ʵ�(��ǰ ��ü�� �����ϰ� �����Ҽ��ִ� �ʵ�)
	 * - int Ÿ�������(����)
	 * - �ڵ����� �ߺ������ʰԻ���
	 */
	private String Type; //��ǰ����
	private String Name; //��ǰ��
	private int Cost; //����
	private int Price; //�ǸŰ�
	private int Count; //��ǰ����
	/*
	 * ������	
	 */
	public Product() {
		
	}
	public Product(int no, String type, String name, int cost, int price, int count) {
		super();
		No = no;
		Type = type;
		Name = name;
		Cost = cost;
		Price = price;
		Count = count;
	}
	
	/*
	 * setter, getter
	 */
	
	public int getNo() {
		return No;
	}
	public void setNo(int no) {
		No = no;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getCost() {
		return Cost;
	}
	public void setCost(int cost) {
		Cost = cost;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	public int getCount() {
		return Count;
	}
	public void setCount(int count) {
		Count = count;
	}
	
	@Override
	public String toString() {
		return "Product [No=" + No + ", Type=" + Type + ", Name=" + Name + ", Cost=" + Cost + ", Price=" + Price
				+ ", Count=" + Count + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
