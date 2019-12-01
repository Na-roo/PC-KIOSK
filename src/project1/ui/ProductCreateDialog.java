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
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProductCreateDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField noTF;
	private JTextField typeTF;
	private JTextField nameTF;
	private JTextField costTF;
	private JTextField priceTF;
	private JTextField countTF;
	
	
	ProductService productService;
	ProductPanel productPanel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ProductCreateDialog dialog = new ProductCreateDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ProductCreateDialog() throws Exception{
		productService = new ProductService();
		setBounds(100, 100, 450, 515);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel label = new JLabel("\uC0C1\uD488\uBC88\uD638");
		label.setFont(new Font("나눔고딕코딩", Font.PLAIN, 16));
		label.setBounds(59, 66, 72, 24);
		contentPanel.add(label);
		
		JLabel lblNewLabel = new JLabel("\uC0C1\uD488\uB4F1\uB85D");
		lblNewLabel.setFont(new Font("나눔고딕코딩", Font.PLAIN, 36));
		lblNewLabel.setBounds(144, 10, 153, 42);
		contentPanel.add(lblNewLabel);
		
		noTF = new JTextField();
		noTF.setBounds(143, 62, 154, 28);
		contentPanel.add(noTF);
		noTF.setColumns(10);
		
		JLabel label_1 = new JLabel("\uC885    \uB958");
		label_1.setFont(new Font("나눔고딕코딩", Font.PLAIN, 16));
		label_1.setBounds(59, 104, 72, 24);
		contentPanel.add(label_1);
		
		typeTF = new JTextField();
		typeTF.setColumns(10);
		typeTF.setBounds(143, 100, 154, 28);
		contentPanel.add(typeTF);
		
		JLabel label_2 = new JLabel("\uC0C1 \uD488 \uBA85");
		label_2.setFont(new Font("나눔고딕코딩", Font.PLAIN, 16));
		label_2.setBounds(59, 142, 72, 24);
		contentPanel.add(label_2);
		
		nameTF = new JTextField();
		nameTF.setColumns(10);
		nameTF.setBounds(143, 138, 154, 28);
		contentPanel.add(nameTF);
		
		JLabel label_3 = new JLabel("\uC6D0    \uAC00");
		label_3.setFont(new Font("나눔고딕코딩", Font.PLAIN, 16));
		label_3.setBounds(59, 180, 72, 24);
		contentPanel.add(label_3);
		
		costTF = new JTextField();
		costTF.setColumns(10);
		costTF.setBounds(143, 176, 154, 28);
		contentPanel.add(costTF);
		
		JLabel label_4 = new JLabel("\uD310 \uB9E4 \uAC00");
		label_4.setFont(new Font("나눔고딕코딩", Font.PLAIN, 16));
		label_4.setBounds(59, 218, 72, 24);
		contentPanel.add(label_4);
		
		priceTF = new JTextField();
		priceTF.setColumns(10);
		priceTF.setBounds(143, 214, 154, 28);
		contentPanel.add(priceTF);
		
		JLabel label_5 = new JLabel("\uB4F1\uB85D\uAC1C\uC218");
		label_5.setFont(new Font("나눔고딕코딩", Font.PLAIN, 16));
		label_5.setBounds(59, 256, 72, 24);
		contentPanel.add(label_5);
		
		countTF = new JTextField();
		countTF.setColumns(10);
		countTF.setBounds(143, 252, 154, 28);
		contentPanel.add(countTF);
		
		JLabel lblAsfd = new JLabel("");
		lblAsfd.setHorizontalAlignment(SwingConstants.CENTER);
		lblAsfd.setIcon(new ImageIcon("C:\\Users\\ITWILL\\Desktop\\\uC0C1\uD488\uB4F1\uB85D\uB9AC\uC2A4\uD2B87\uAC1C\uBAA9\uB85D\\4.png"));
		lblAsfd.setBackground(Color.DARK_GRAY);
		lblAsfd.setBounds(82, 285, 265, 159);
		contentPanel.add(lblAsfd);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton createButton = new JButton("\uB4F1\uB85D");
				createButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							
							noTF.getText();
							costTF.getText();
							priceTF.getText();
							countTF.getText();
							String productType = typeTF.getText();
							String productName = nameTF.getText();
							
							
							if (noTF.getText().trim().equals("")) {
								JOptionPane.showMessageDialog(null, "상품 번호를 입력하세요");
								noTF.requestFocus();
								return;
							} else if (productType.trim().equals("")) {
								JOptionPane.showMessageDialog(null, "상품 종류를 입력하세요");
								typeTF.requestFocus();
								return;
							} else if (productName.trim().equals("")) {
								JOptionPane.showMessageDialog(null, "상품명을 입력하세요");
								typeTF.requestFocus();
								return;
							} else if (costTF.getText().trim().equals("")) {
								JOptionPane.showMessageDialog(null, "원가를 입력하세요");
								typeTF.requestFocus();
								return;
							}else if (priceTF.getText().trim().equals("")) {
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
							productService.productCreate
								(new Product(productNo, productType, productName, productCost, productPrice, productCount));
							productPanel.productListJTable();
							dispose();
							
						} catch (NumberFormatException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				createButton.setActionCommand("OK");
				buttonPane.add(createButton);
				getRootPane().setDefaultButton(createButton);
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
