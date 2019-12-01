package project1.ui;

import project1.product.Product;
import project1.product.ProductService;

public class ProductServiceTestMain {

	public static void main(String[] args) throws Exception{
		
		ProductService productService = new ProductService();
		
		
		System.out.println("---------productCreate(Product newProduct)---------");
		productService.productCreate(new Product(1, "라면", "신라면", 500, 2000, 21));
		productService.productCreate(new Product(2, "라면", "진라면", 600, 2000, 28));
		productService.productCreate(new Product(3, "라면", "삼양라면", 600, 2000, 27));
		productService.productCreate(new Product(4, "라면", "짜파게티", 600, 2000, 24));
		productService.productCreate(new Product(5, "라면", "불닭볶음면", 900, 2500, 26));
		productService.productCreate(new Product(21, "컵라면", "참깨라면 컵", 700, 2000, 17));
		productService.productCreate(new Product(22, "컵라면", "해물왕컵 컵", 800, 2000, 19));
		productService.productCreate(new Product(23, "컵라면", "팔도비빔면 컵", 800, 2000, 19));
		productService.productCreate(new Product(24, "컵라면", "새우탕 컵", 800, 2000, 21));
		productService.productCreate(new Product(25, "컵라면", "너구리 컵", 800, 2000, 15));
		productService.productCreate(new Product(41, "과자", "새우깡", 7000, 1500, 10));
		productService.productCreate(new Product(42, "과자", "매운새우깡", 700, 1500, 12));
		productService.productCreate(new Product(43, "과자", "포카칩", 1200, 2500, 15));
		productService.productCreate(new Product(44, "과자", "스윙칩", 1200, 2500, 14));
		productService.productCreate(new Product(45, "과자", "홈런볼", 700, 2000, 13));
		productService.productCreate(new Product(61, "핫도그", "칠리핫도그", 1000, 3000, 15));
		productService.productCreate(new Product(62, "핫도그", "치즈핫도그", 1200, 3500, 13));
		productService.productCreate(new Product(63, "핫도그", "치즈불고기핫도그", 1800, 4000, 20));
		productService.productCreate(new Product(64, "핫도그", "렐리쉬핫도그", 1200, 3000, 17));
		productService.productCreate(new Product(65, "핫도그", "어니언핫도그", 1200, 3000, 16));
		productService.productCreate(new Product(81, "햄버거", "슈비버거", 1800, 4500, 14));
		productService.productCreate(new Product(82, "햄버거", "아재버거", 1800, 4000, 17));
		productService.productCreate(new Product(83, "햄버거", "핫크리스피버거", 1400, 3500, 10));
		productService.productCreate(new Product(84, "햄버거", "콰트로 치즈와퍼 버거", 1200, 4000, 13));
		productService.productCreate(new Product(85, "햄버거", "로스팅비프버거", 1100, 4500, 8));
		productService.productCreate(new Product(101, "음료수", "코카콜라", 800, 1500, 21));
		productService.productCreate(new Product(102, "음료수", "펩시콜라", 600, 1500, 35));
		productService.productCreate(new Product(103, "음료수", "마운틴듀", 700, 1500, 50));
		productService.productCreate(new Product(104, "음료수", "웰치스", 1000, 2000, 41));
		productService.productCreate(new Product(105, "음료수", "핫식스", 1000, 2000, 35));
		productService.productCreate(new Product(106, "음료수", "코코팜", 400, 1200, 31));
		productService.productCreate(new Product(107, "음료수", "사이다", 600, 1500, 26));
		productService.productCreate(new Product(108, "음료수", "환타", 600, 1500, 20));
		productService.productCreate(new Product(109, "음료수", "닥터페퍼", 800, 2000, 27));
		productService.productCreate(new Product(110, "음료수", "밀키스", 700, 1500, 28));

		

		
		
		
		System.out.println("---------findMemberByAll()---------");
		System.out.println(productService.findProductAll());
		
		System.out.println("---------findByNo(int no)---------");
		System.out.println(productService.findByNo(3));
		System.out.println(productService.findByNo(1));
		
		System.out.println("---------findOneByName(String name)---------");
		System.out.println(productService.findOneByName("칠리핫도그"));
		System.out.println(productService.findOneByName("새우깡"));
		
		
		System.out.println("---------findByName(String name)---------");
		System.out.println(productService.findByName("새우깡"));
		
		
		System.out.println("---------productUpdate(Product updateProduct)---------");
		productService.productUpdate(new Product(1, "라면", "참깨라면", 1000, 2000, 10));
		productService.productUpdate(new Product(1, "컵라면", "참깨라면", 1000, 2000, 20));
		
		
		System.out.println("---------productDelete(int no)---------");
		productService.productDelete(11);
		
		
		System.out.println("---------productDelete(String name)---------");
		productService.productDelete("펩시콜라");
		
		
		System.out.println("---------findMemberByAll()---------");
		System.out.println(productService.findProductAll());
		
	}

}
