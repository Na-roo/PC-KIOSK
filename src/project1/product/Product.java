package project1.product;

import java.io.Serializable;

/*
 * VO(Value Object)객체,DTO(Data Transfer Object)객체
 *   - 상품 1명의 데이타를 가지고있는 객체
 *   - 파일 1개 레코드,DB 테이블 한개 row
 */
public class Product implements Serializable{
	/*
	 * 멤버필드
	 */
	private int No; //상품번호
	/*
	 * - 중복되지 않아야하는 필드(상품 객체를 유일하게 구분할수있는 필드)
	 * - int 타입을사용(권장)
	 * - 자동으로 중복되지않게생성
	 */
	private String Type; //상품종류
	private String Name; //상품명
	private int Cost; //원가
	private int Price; //판매가
	private int Count; //상품개수
	/*
	 * 생성자	
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
