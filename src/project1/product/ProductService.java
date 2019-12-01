package project1.product;

import java.util.ArrayList;

/*
상품관리업무를 수행할객체(Service, Manager)
	- 상품관리업무 수행객체
	- 상품관리업무 수행시 Data Access에관련된작업을
	  MemberDao를 호출해 CRUD를 수행한다. 
*/
public class ProductService {
	private ProductDao productDao;
		
	public ProductService() throws Exception {
		productDao = new ProductDao();
	}
	/*
	 * 상품등록
	 */
	public boolean productCreate(Product newProduct) throws Exception{
		boolean isSuccess=true;
		
	/*
	 * 상품 번호, 이름 중복체크
	 */
	ArrayList<Product> productList = productDao.readAll();
	for (Product product : productList) {
		if (product.getNo()==newProduct.getNo() || product.getName().equals(newProduct.getName())) {
			isSuccess=false; //번호나 이름이 중복되면 생성해주지 않음.
			break;
		}
	}
		if (isSuccess) {
			productDao.create(newProduct);
		}
		return isSuccess;
	}
	

	/*
	 * 상품 리스트 전체 불러오기
	 */
	public ArrayList<Product> findProductAll() throws Exception{
		return productDao.readAll();
	}
		
	/*
	 * 상품찾기 (상품번호로 찾기)
	 */
	public Product findByNo(int no) throws Exception {
		return productDao.readOne(no);
	}
		
	/*
	 * 상품찾기 (상품명으로 찾기)
	 */
	public Product findOneByName(String name) throws Exception {
		return productDao.readOne(name);
	}
	/*
	 * 상품리스트(상품 여러개 이름으로찾기)
	 */
	public ArrayList<Product> findByName(String name) throws Exception {
		ArrayList<Product> findList = new ArrayList<Product>();
		ArrayList<Product> productList = productDao.readAll(); 
		for (int i = 0; i < productList.size(); i++) {
			Product tempPro = productList.get(i);
			if (tempPro.getName().contains(name)) {
				findList.add(tempPro);
			}
		}
			return findList;
	}

		
	/*
	 * 상품 수정
	 */
	public void productUpdate(Product updateProduct) throws Exception {
		productDao.update(updateProduct);
	}
		
	/*
	 * 상품 삭제
	 */
	public void productDelete(int no) throws Exception {
		productDao.delete(no);
	}
	public void productDelete(String name) throws Exception{
		productDao.delete(name);
			
	}
		
		
		
		
		
		
		
}
	
