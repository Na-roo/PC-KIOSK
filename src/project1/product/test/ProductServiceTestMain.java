package project1.product.test;

import project1.product.Product;
import project1.product.ProductService;

public class ProductServiceTestMain {

	public static void main(String[] args) throws Exception{
		
		ProductService productService = new ProductService();
		
		
		System.out.println("---------productCreate(Product newProduct)---------");
		productService.productCreate(new Product(4, "�ֵ���", "ĥ���ֵ���", 1000, 2000, 5));
		productService.productCreate(new Product(2, "����", "�����", 1000, 1500, 10));
		productService.productCreate(new Product(6, "����", "�ſ�����", 1200, 2000, 7));
		productService.productCreate(new Product(10, "�����", "����ݶ�", 800, 1500, 10));
		productService.productCreate(new Product(11, "�����", "���", 800, 1500, 10));
		
		
		System.out.println("---------findMemberByAll()---------");
		System.out.println(productService.findProductAll());
		
		System.out.println("---------findByNo(int no)---------");
		System.out.println(productService.findByNo(3));
		System.out.println(productService.findByNo(1));
		
		System.out.println("---------findOneByName(String name)---------");
		System.out.println(productService.findOneByName("ĥ���ֵ���"));
		System.out.println(productService.findOneByName("�����"));
		
		
		System.out.println("---------findByName(String name)---------");
		System.out.println(productService.findByName("�����"));
		
		
		System.out.println("---------productUpdate(Product updateProduct)---------");
		productService.productUpdate(new Product(1, "���", "�������", 1000, 2000, 10));
		productService.productUpdate(new Product(1, "�Ŷ��", "�������", 1000, 2000, 20));
		
		
		System.out.println("---------productDelete(int no)---------");
		productService.productDelete(11);
		
		
		System.out.println("---------productDelete(String name)---------");
		productService.productDelete("����ݶ�");
		
		
		System.out.println("---------findMemberByAll()---------");
		System.out.println(productService.findProductAll());
		
	}

}
