package project1.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.omg.CosNaming.NamingContextPackage.NotFound;

import project1.product.Product;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminViewDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField noTF;
	private JTextField typeTF;
	private JTextField nameTF;
	private JTextField priceTF;
	private JTextField countTF;
	public static int tranceNo;
	ProductPanel productPanel;
	Product viewProduct;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AdminViewDialog dialog = new AdminViewDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AdminViewDialog() {
		productPanel = new ProductPanel();
		setBounds(100, 100, 450, 520);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel label = new JLabel("\uC0C1\uD488\uC815\uBCF4");
		label.setFont(new Font("³ª´®°íµñÄÚµù", Font.PLAIN, 36));
		label.setBounds(156, 10, 153, 42);
		contentPanel.add(label);
		
		JLabel label_1 = new JLabel("\uC0C1\uD488\uBC88\uD638");
		label_1.setFont(new Font("³ª´®°íµñÄÚµù", Font.PLAIN, 16));
		label_1.setBounds(71, 76, 72, 24);
		contentPanel.add(label_1);
		
		noTF = new JTextField();
		noTF.setHorizontalAlignment(SwingConstants.CENTER);
		noTF.setEditable(false);
		noTF.setColumns(10);
		noTF.setBounds(155, 72, 154, 28);
		contentPanel.add(noTF);
		
		JLabel label_2 = new JLabel("\uC885    \uB958");
		label_2.setFont(new Font("³ª´®°íµñÄÚµù", Font.PLAIN, 16));
		label_2.setBounds(71, 120, 72, 24);
		contentPanel.add(label_2);
		
		typeTF = new JTextField();
		typeTF.setHorizontalAlignment(SwingConstants.CENTER);
		typeTF.setEditable(false);
		typeTF.setColumns(10);
		typeTF.setBounds(155, 116, 154, 28);
		contentPanel.add(typeTF);
		
		JLabel label_3 = new JLabel("\uC0C1 \uD488 \uBA85");
		label_3.setFont(new Font("³ª´®°íµñÄÚµù", Font.PLAIN, 16));
		label_3.setBounds(71, 171, 72, 24);
		contentPanel.add(label_3);
		
		nameTF = new JTextField();
		nameTF.setHorizontalAlignment(SwingConstants.CENTER);
		nameTF.setEditable(false);
		nameTF.setColumns(10);
		nameTF.setBounds(155, 167, 154, 28);
		contentPanel.add(nameTF);
		
		JLabel label_4 = new JLabel("\uD310 \uB9E4 \uAC00");
		label_4.setFont(new Font("³ª´®°íµñÄÚµù", Font.PLAIN, 16));
		label_4.setBounds(71, 221, 72, 24);
		contentPanel.add(label_4);
		
		priceTF = new JTextField();
		priceTF.setHorizontalAlignment(SwingConstants.CENTER);
		priceTF.setEditable(false);
		priceTF.setColumns(10);
		priceTF.setBounds(155, 217, 154, 28);
		contentPanel.add(priceTF);
		
		JLabel label_5 = new JLabel("\uC7AC    \uACE0");
		label_5.setFont(new Font("³ª´®°íµñÄÚµù", Font.PLAIN, 16));
		label_5.setBounds(71, 267, 72, 24);
		contentPanel.add(label_5);
		
		countTF = new JTextField();
		countTF.setHorizontalAlignment(SwingConstants.CENTER);
		countTF.setEditable(false);
		countTF.setColumns(10);
		countTF.setBounds(155, 263, 154, 28);
		contentPanel.add(countTF);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("\uD655\uC778");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("\uB2EB\uAE30");
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

	

	public void setViewProduct(Product viewProduct) {
		this.viewProduct=viewProduct;
		noTF.setText(viewProduct.getNo()+"");
		typeTF.setText(viewProduct.getType());
		nameTF.setText(viewProduct.getName());
		priceTF.setText(viewProduct.getPrice()+"");
		countTF.setText(viewProduct.getCount()+"");
		
	}
}
