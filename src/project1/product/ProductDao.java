package project1.product;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


/*
Dao(Data Access Object)
 - 상품들의 데이터를 저장하고있는 파일(테이블)에
   CRUD(Create, Read, Update, Delete) 작업을 할수있는
   단위메쏘드를 가지고있는 클래스

 - ProductService객체의 요청(메쏘드호출)을 받아서 
   Data Access(File, DB)에 관련된 단위기능(CRUD)을
   수행하는 객체
 */
public class ProductDao {
	
	/*
	 * Create
	 */
	public void create(Product product) throws Exception {
		ArrayList<Product> productList = readFile();
		productList.add(product);
		writeFile(productList);
	}
	/*
	 * Read All
	 */
	public ArrayList<Product> readAll() throws Exception {
		return readFile();
	}
	/*
	 * Read One (상품 번호로)
	 */
	public Product readOne(int no) throws Exception {
		Product findProduct = null;
		ArrayList<Product> productList = readFile();
		for (Product product : productList) {
			if (product.getNo() == no) {
				findProduct = product;
				break;
			}
		}
		return findProduct;
	}
	/*
	 * Read One (상품명으로)
	 */
	public Product readOne(String name) throws Exception {
		Product findProduct = null;
		ArrayList<Product> productList = readFile();
		for (Product product : productList) {
			if (product.getName().equals(name)) {
				findProduct = product;
				break;
			}
		}
		return findProduct;
	}
	/*
	 *Update
	 */
	public void update(Product updateProduct) throws Exception {
		ArrayList<Product> productList = this.readFile();

		for (int i = 0; i < productList.size(); i++) {
			Product tempProduct = productList.get(i);
			if (tempProduct.getNo()==updateProduct.getNo()) {
				productList.set(i, updateProduct);
				break;
			}
		}

		this.writeFile(productList);

	}
	/*
	 * Delete (번호로)
	 */
	public void delete(int no) throws Exception{
		ArrayList<Product> productList = this.readFile();
		for (int i = 0; i < productList.size(); i++) {
			Product tempProduct = productList.get(i);
			if (tempProduct.getNo()==no) {
				productList.remove(i);
				break;
			}
		}
		this.writeFile(productList);
	}
	/*
	 * Delete (상품명으로)
	 */
	public void delete(String name) throws Exception {
		ArrayList<Product> productList = this.readFile();
		for (int i = 0; i < productList.size(); i++) {
			Product tempProduct = productList.get(i);
			if (tempProduct.getName().equals(name)) {
				productList.remove(i);
				break;
			}
		}
		this.writeFile(productList);
	}

	
	
	
	
	/**********************************************/
	private File productFile;

	public ProductDao() throws Exception {
		init();
	}

	private void init() throws Exception {
		productFile = new File("product_list.ser");
		if (!productFile.exists()) {
			//System.out.println("------파일생성[product_list.ser]-----");
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(productFile));
			oos.writeObject(new ArrayList<Product>());
			
		} else {
			//System.out.println("------파일존재[product_list.ser]-----");
		}
	}

	/*
	 * file --> ArrayList<Product>
	 */
	private ArrayList<Product> readFile() throws Exception {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(productFile));
		ArrayList<Product> productList = (ArrayList<Product>) ois.readObject();
		ois.close();
		return productList;
	}

	/*
	 * ArrayList<Product>--> file
	 */
	private void writeFile(ArrayList<Product> productList) throws Exception {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(productFile));
		oos.writeObject(productList);
		oos.close();

	}
	
	
	
	
}
