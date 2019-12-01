package project1.product;

import java.util.ArrayList;

/*
��ǰ���������� �����Ұ�ü(Service, Manager)
	- ��ǰ�������� ���ఴü
	- ��ǰ�������� ����� Data Access�����õ��۾���
	  MemberDao�� ȣ���� CRUD�� �����Ѵ�. 
*/
public class ProductService {
	private ProductDao productDao;
		
	public ProductService() throws Exception {
		productDao = new ProductDao();
	}
	/*
	 * ��ǰ���
	 */
	public boolean productCreate(Product newProduct) throws Exception{
		boolean isSuccess=true;
		
	/*
	 * ��ǰ ��ȣ, �̸� �ߺ�üũ
	 */
	ArrayList<Product> productList = productDao.readAll();
	for (Product product : productList) {
		if (product.getNo()==newProduct.getNo() || product.getName().equals(newProduct.getName())) {
			isSuccess=false; //��ȣ�� �̸��� �ߺ��Ǹ� ���������� ����.
			break;
		}
	}
		if (isSuccess) {
			productDao.create(newProduct);
		}
		return isSuccess;
	}
	

	/*
	 * ��ǰ ����Ʈ ��ü �ҷ�����
	 */
	public ArrayList<Product> findProductAll() throws Exception{
		return productDao.readAll();
	}
		
	/*
	 * ��ǰã�� (��ǰ��ȣ�� ã��)
	 */
	public Product findByNo(int no) throws Exception {
		return productDao.readOne(no);
	}
		
	/*
	 * ��ǰã�� (��ǰ������ ã��)
	 */
	public Product findOneByName(String name) throws Exception {
		return productDao.readOne(name);
	}
	/*
	 * ��ǰ����Ʈ(��ǰ ������ �̸�����ã��)
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
	 * ��ǰ ����
	 */
	public void productUpdate(Product updateProduct) throws Exception {
		productDao.update(updateProduct);
	}
		
	/*
	 * ��ǰ ����
	 */
	public void productDelete(int no) throws Exception {
		productDao.delete(no);
	}
	public void productDelete(String name) throws Exception{
		productDao.delete(name);
			
	}
		
		
		
		
		
		
		
}
	
