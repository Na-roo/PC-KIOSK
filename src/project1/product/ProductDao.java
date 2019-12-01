package project1.product;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


/*
Dao(Data Access Object)
 - ��ǰ���� �����͸� �����ϰ��ִ� ����(���̺�)��
   CRUD(Create, Read, Update, Delete) �۾��� �Ҽ��ִ�
   �����޽�带 �������ִ� Ŭ����

 - ProductService��ü�� ��û(�޽��ȣ��)�� �޾Ƽ� 
   Data Access(File, DB)�� ���õ� �������(CRUD)��
   �����ϴ� ��ü
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
	 * Read One (��ǰ ��ȣ��)
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
	 * Read One (��ǰ������)
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
	 * Delete (��ȣ��)
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
	 * Delete (��ǰ������)
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
			//System.out.println("------���ϻ���[product_list.ser]-----");
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(productFile));
			oos.writeObject(new ArrayList<Product>());
			
		} else {
			//System.out.println("------��������[product_list.ser]-----");
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
