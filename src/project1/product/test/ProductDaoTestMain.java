package project1.product.test;

import java.util.ArrayList;

import project1.product.Product;
import project1.product.ProductDao;



public class ProductDaoTestMain {

	public static void main(String[] args) throws Exception{
		ProductDao productDao = new ProductDao();
		
		System.out.println("-----------------create-----------------");
		//productDao.create(new Product(1, "���", "�������", 800, 2000, 3));
		productDao.create(new Product(2, "����", "�����", 600, 1500, 5));
		//productDao.create(new Product(3, "�����", "��ī�ݶ�", 500, 1500, 10));
		System.out.println("-----------------readOne------------");
		System.out.println(productDao.readOne(1));
		System.out.println(productDao.readOne(2));
		//String proName = productDao.readOne(2).getName();
		//System.out.println(proName);
		System.out.println(productDao.readOne("��ī�ݶ�"));
		System.out.println("-----------------update------------");
		//productDao.update(new Product(1, "���", "�������", 800, 2000, 3));
		productDao.update(new Product(1, "���", "�Ŷ��", 700, 1800, 5));
		System.out.println("-----------------delete------------");
		//productDao.delete(1);
		productDao.delete("�����");
		//productDao.delete("��ī�ݶ�");
		System.out.println("-----------------readAll------------");
		ArrayList<Product> productList = productDao.readAll();
		System.out.println(productList);
		/*


		memberDao.delete(3);
	
	    memberList=memberDao.readAll();
		System.out.println(memberList);
		*/
		
	}
}


