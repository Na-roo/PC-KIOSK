package project1.ui;

import project1.product.Product;
import project1.product.ProductService;

public class ProductServiceTestMain {

	public static void main(String[] args) throws Exception{
		
		ProductService productService = new ProductService();
		
		
		System.out.println("---------productCreate(Product newProduct)---------");
		productService.productCreate(new Product(1, "���", "�Ŷ��", 500, 2000, 21));
		productService.productCreate(new Product(2, "���", "�����", 600, 2000, 28));
		productService.productCreate(new Product(3, "���", "�����", 600, 2000, 27));
		productService.productCreate(new Product(4, "���", "¥�İ�Ƽ", 600, 2000, 24));
		productService.productCreate(new Product(5, "���", "�Ҵߺ�����", 900, 2500, 26));
		productService.productCreate(new Product(21, "�Ŷ��", "������� ��", 700, 2000, 17));
		productService.productCreate(new Product(22, "�Ŷ��", "�ع����� ��", 800, 2000, 19));
		productService.productCreate(new Product(23, "�Ŷ��", "�ȵ������ ��", 800, 2000, 19));
		productService.productCreate(new Product(24, "�Ŷ��", "������ ��", 800, 2000, 21));
		productService.productCreate(new Product(25, "�Ŷ��", "�ʱ��� ��", 800, 2000, 15));
		productService.productCreate(new Product(41, "����", "�����", 7000, 1500, 10));
		productService.productCreate(new Product(42, "����", "�ſ�����", 700, 1500, 12));
		productService.productCreate(new Product(43, "����", "��īĨ", 1200, 2500, 15));
		productService.productCreate(new Product(44, "����", "����Ĩ", 1200, 2500, 14));
		productService.productCreate(new Product(45, "����", "Ȩ����", 700, 2000, 13));
		productService.productCreate(new Product(61, "�ֵ���", "ĥ���ֵ���", 1000, 3000, 15));
		productService.productCreate(new Product(62, "�ֵ���", "ġ���ֵ���", 1200, 3500, 13));
		productService.productCreate(new Product(63, "�ֵ���", "ġ��Ұ���ֵ���", 1800, 4000, 20));
		productService.productCreate(new Product(64, "�ֵ���", "�������ֵ���", 1200, 3000, 17));
		productService.productCreate(new Product(65, "�ֵ���", "��Ͼ��ֵ���", 1200, 3000, 16));
		productService.productCreate(new Product(81, "�ܹ���", "�������", 1800, 4500, 14));
		productService.productCreate(new Product(82, "�ܹ���", "�������", 1800, 4000, 17));
		productService.productCreate(new Product(83, "�ܹ���", "��ũ�����ǹ���", 1400, 3500, 10));
		productService.productCreate(new Product(84, "�ܹ���", "��Ʈ�� ġ����� ����", 1200, 4000, 13));
		productService.productCreate(new Product(85, "�ܹ���", "�ν��ú�������", 1100, 4500, 8));
		productService.productCreate(new Product(101, "�����", "��ī�ݶ�", 800, 1500, 21));
		productService.productCreate(new Product(102, "�����", "����ݶ�", 600, 1500, 35));
		productService.productCreate(new Product(103, "�����", "����ƾ��", 700, 1500, 50));
		productService.productCreate(new Product(104, "�����", "��ġ��", 1000, 2000, 41));
		productService.productCreate(new Product(105, "�����", "�ֽĽ�", 1000, 2000, 35));
		productService.productCreate(new Product(106, "�����", "������", 400, 1200, 31));
		productService.productCreate(new Product(107, "�����", "���̴�", 600, 1500, 26));
		productService.productCreate(new Product(108, "�����", "ȯŸ", 600, 1500, 20));
		productService.productCreate(new Product(109, "�����", "��������", 800, 2000, 27));
		productService.productCreate(new Product(110, "�����", "��Ű��", 700, 1500, 28));

		

		
		
		
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
