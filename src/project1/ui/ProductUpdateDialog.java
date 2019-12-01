package project1.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import project1.product.Product;
import project1.product.ProductService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class ProductUpdateDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField noTF;
	private JTextField typeTF;
	private JTextField nameTF;
	private JTextField costTF;
	private JTextField priceTF;
	private JTextField countTF;
	public static int tranceNo;

	Product updateProduct;
	ProductPanel productPanel;
	ProductService productService;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ProductUpdateDialog dialog = new ProductUpdateDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */

	public void setUpdateProduct(Product updateProduct) {
		this.updateProduct=updateProduct;
		noTF.setText(updateProduct.getNo()+"");
		typeTF.setText(updateProduct.getType());
		nameTF.setText(updateProduct.getName());
		costTF.setText(updateProduct.getCost()+"");
		priceTF.setText(updateProduct.getPrice()+"");
		countTF.setText(updateProduct.getCount()+"");	
	}
	
	public ProductUpdateDialog() throws Exception{
		productService = new ProductService();
		setBounds(100, 100, 450, 520);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel label = new JLabel("\uC0C1\uD488\uC218\uC815");
			label.setFont(new Font("나눔고딕코딩", Font.PLAIN, 36));
			label.setBounds(159, 23, 153, 42);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("\uC0C1\uD488\uBC88\uD638");
			label.setFont(new Font("나눔고딕코딩", Font.PLAIN, 16));
			label.setBounds(75, 90, 72, 24);
			contentPanel.add(label);
		}
		{
			noTF = new JTextField();
			noTF.setEditable(false);
			noTF.setHorizontalAlignment(SwingConstants.CENTER);
			noTF.setColumns(10);
			noTF.setBounds(159, 86, 154, 28);
			contentPanel.add(noTF);
		}
		{
			JLabel label = new JLabel("\uC885    \uB958");
			label.setFont(new Font("나눔고딕코딩", Font.PLAIN, 16));
			label.setBounds(75, 128, 72, 24);
			contentPanel.add(label);
		}
		{
			typeTF = new JTextField();
			typeTF.setHorizontalAlignment(SwingConstants.CENTER);
			typeTF.setColumns(10);
			typeTF.setBounds(159, 124, 154, 28);
			contentPanel.add(typeTF);
		}
		{
			JLabel label = new JLabel("\uC0C1 \uD488 \uBA85");
			label.setFont(new Font("나눔고딕코딩", Font.PLAIN, 16));
			label.setBounds(75, 166, 72, 24);
			contentPanel.add(label);
		}
		{
			nameTF = new JTextField();
			nameTF.setHorizontalAlignment(SwingConstants.CENTER);
			nameTF.setColumns(10);
			nameTF.setBounds(159, 162, 154, 28);
			contentPanel.add(nameTF);
		}
		{
			JLabel label = new JLabel("\uC6D0    \uAC00");
			label.setFont(new Font("나눔고딕코딩", Font.PLAIN, 16));
			label.setBounds(75, 204, 72, 24);
			contentPanel.add(label);
		}
		{
			costTF = new JTextField();
			costTF.setEditable(false);
			costTF.setHorizontalAlignment(SwingConstants.CENTER);
			costTF.setColumns(10);
			costTF.setBounds(159, 200, 154, 28);
			contentPanel.add(costTF);
		}
		{
			JLabel label = new JLabel("\uD310 \uB9E4 \uAC00");
			label.setFont(new Font("나눔고딕코딩", Font.PLAIN, 16));
			label.setBounds(75, 242, 72, 24);
			contentPanel.add(label);
		}
		{
			priceTF = new JTextField();
			priceTF.setHorizontalAlignment(SwingConstants.CENTER);
			priceTF.setColumns(10);
			priceTF.setBounds(159, 238, 154, 28);
			contentPanel.add(priceTF);
		}
		{
			JLabel label = new JLabel("\uB4F1\uB85D\uAC1C\uC218");
			label.setFont(new Font("나눔고딕코딩", Font.PLAIN, 16));
			label.setBounds(75, 280, 72, 24);
			contentPanel.add(label);
		}
		{
			countTF = new JTextField();
			countTF.setHorizontalAlignment(SwingConstants.CENTER);
			countTF.setColumns(10);
			countTF.setBounds(159, 276, 154, 28);
			contentPanel.add(countTF);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("\uC218\uC815");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							noTF.getText();
							String productType = typeTF.getText();
							String productName = nameTF.getText();
							costTF.getText();
							priceTF.getText();
							countTF.getText();
							
							if (productType.trim().equals("")) {
								JOptionPane.showMessageDialog(null, "상품 종류를 입력하세요");
								typeTF.requestFocus();
								return;
							} else if (productName.trim().equals("")) {
								JOptionPane.showMessageDialog(null, "상품명을 입력하세요");
								typeTF.requestFocus();
								return;
							} else if (priceTF.getText().trim().equals("")) {
								JOptionPane.showMessageDialog(null, "판매가를 입력하세요");
								typeTF.requestFocus();
								return;
							} else if (countTF.getText().trim().equals("")) {
								JOptionPane.showMessageDialog(null, "등록 개수를 입력하세요");
								typeTF.requestFocus();
								return;
							}
							
							int productNo = Integer.parseInt(noTF.getText());
							int productCost = Integer.parseInt(costTF.getText());
							int productPrice = Integer.parseInt(priceTF.getText());
							int productCount = Integer.parseInt(countTF.getText());
							
							productService.productUpdate(new Product(productNo, productType, productName, productCost, productPrice, productCount));
							productPanel.productListJTable();
							
							dispose();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("\uCDE8\uC18C");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	


}
