package project1.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.omg.CosNaming.NamingContextPackage.NotFound;

import project1.product.Product;
import project1.product.ProductService;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class ProductPanel extends JPanel {
	
	public static ProductPanel _instance;
	
	public static ProductPanel getInstance() {
		if (_instance==null) {
			_instance  = new ProductPanel();
		}
		return _instance;
	}
	
	private JTextField findTF;
	private JTable productTable;
	private JTextField productNoTF;
	private JTextField productNameTF;
	private JTextField productCountTF;
    private PcposJFrameMain mainFrame;
    
    ProductService productService;
    private Vector columnNames;
   
    
    private DefaultTableModel tableModel;
	
    
	public void setMainFrame(PcposJFrameMain mainFrame) {
		this.mainFrame = mainFrame;
	}
	/**
	 * Create the panel.
	 */
	public ProductPanel() {
		try {
			productService=new ProductService();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentHidden(ComponentEvent e) {
				init();
			}
			public void componentShown(ComponentEvent e) {
				try {
					productListJTable();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		setBackground(new Color(255, 239, 213));
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(12, 10, 844, 516);
		add(scrollPane);
		
		productTable = new JTable();
		productTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = productTable.getSelectedRow();
				int selectedColumn = productTable.getSelectedColumn();
				int selectedNo =(Integer)productTable.getValueAt(selectedRow,0);
				System.out.println("selected No:"+selectedNo);
				Product product;
				try {
					product = productService.findByNo(selectedNo);

					productNoTF.setText(product.getNo()+"");
					productNameTF.setText(product.getName());
					productCountTF.setText("Àç°í : "+ product.getCount());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				

			}
		});
		
		columnNames=new Vector();
		columnNames.add("¹øÈ£");
		columnNames.add("Á¾·ù");
		columnNames.add("»óÇ°¸í");
		columnNames.add("°¡°Ý");
		columnNames.add("³²Àº¼ö·®");
		tableModel=new DefaultTableModel(columnNames,0);
		productTable.setModel(tableModel);
		
		scrollPane.setViewportView(productTable);
		
		findTF = new JTextField();
		findTF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		findTF.setColumns(10);
		findTF.setBounds(12, 557, 230, 59);
		add(findTF);
		
		JButton findByNameB = new JButton("\uAC80\uC0C9");
		findByNameB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Product> productList;
				try {
					init();
					
					productList = productService.findByName(findTF.getText());
					Vector data=new Vector();
					for(Product product:productList) {
						Vector rowVector=new Vector();
						rowVector.add(product.getNo());
						rowVector.add(product.getType());
						rowVector.add(product.getName());
						rowVector.add(product.getPrice());
						rowVector.add(product.getCount());
						data.add(rowVector);
					}
					tableModel=
							new DefaultTableModel(data, columnNames);
					productTable.setModel(tableModel);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}				
		});
		findByNameB.setFont(new Font("³ª´®½ºÄù¾î¶ó¿îµå ExtraBold", Font.PLAIN, 15));
		findByNameB.setBounds(241, 557, 97, 59);
		add(findByNameB);
		
		JButton productCreateB = new JButton("\uC0C1\uD488\uB4F1\uB85D");
		productCreateB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ProductCreateDialog productCreateDialog = new ProductCreateDialog();
					productCreateDialog.productPanel=ProductPanel.this;
					productCreateDialog.setModal(true);
					productCreateDialog.setVisible(true);
				} catch (Exception e1) {

					e1.printStackTrace();
				}
			}
		});
		productCreateB.setFont(new Font("³ª´®½ºÄù¾î¶ó¿îµå ExtraBold", Font.PLAIN, 15));
		productCreateB.setBounds(361, 556, 157, 59);
		add(productCreateB);
		
		JButton productCheckB = new JButton("\uC0C1\uD488\uBCF4\uAE30");
		productCheckB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ProductViewDialog productViewDialog = new ProductViewDialog();
					int selectedRow = productTable.getSelectedRow();
					ProductViewDialog.tranceNo =(Integer)productTable.getValueAt(selectedRow,0);
					Product viewProduct=productService.findByNo((Integer)productTable.getValueAt(selectedRow,0));
					productViewDialog.setViewProduct(viewProduct); 
					productViewDialog.setModal(true);
					productViewDialog.setVisible(true);
					
				} catch (Exception e1) {

					e1.printStackTrace();
				}
			}
		});
		productCheckB.setFont(new Font("³ª´®½ºÄù¾î¶ó¿îµå ExtraBold", Font.PLAIN, 15));
		productCheckB.setBounds(699, 556, 157, 59);
		add(productCheckB);
		
		JButton productUpdateB = new JButton("\uC0C1\uD488\uC218\uC815");
		productUpdateB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ProductUpdateDialog productUpdateDialog = new ProductUpdateDialog();
					int selectedRow = productTable.getSelectedRow();
					ProductViewDialog.tranceNo =(Integer)productTable.getValueAt(selectedRow,0);
					Product updateProduct=productService.findByNo((Integer)productTable.getValueAt(selectedRow,0));
					productUpdateDialog.setUpdateProduct(updateProduct); 
					productUpdateDialog.productPanel=ProductPanel.this;
					productUpdateDialog.setModal(true);
					productUpdateDialog.setVisible(true);
					
				} catch (Exception e1) {

					e1.printStackTrace();
				}
			}
		});
		productUpdateB.setFont(new Font("³ª´®½ºÄù¾î¶ó¿îµå ExtraBold", Font.PLAIN, 15));
		productUpdateB.setBounds(530, 556, 157, 59);
		add(productUpdateB);
		
		JButton productDeleteB = new JButton("\uC0C1\uD488\uC0AD\uC81C");
		productDeleteB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int productNo = (Integer.parseInt(productNoTF.getText()));
				if (productNo==0) {
					return;
				}
				try {
					productService.productDelete(productNo);
					productNoTF.setText("");
					productNameTF.setText("");
					productCountTF.setText("");
					productListJTable();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		productDeleteB.setFont(new Font("³ª´®½ºÄù¾î¶ó¿îµå ExtraBold", Font.PLAIN, 15));
		productDeleteB.setBounds(1043, 467, 157, 59);
		add(productDeleteB);
		
		productNoTF = new JTextField();
		productNoTF.setFont(new Font("³ª´®°íµñÄÚµù", Font.PLAIN, 20));
		productNoTF.setHorizontalAlignment(SwingConstants.CENTER);
		productNoTF.setBounds(895, 92, 305, 53);
		add(productNoTF);
		productNoTF.setColumns(10);
		
		productNameTF = new JTextField();
		productNameTF.setFont(new Font("³ª´®°íµñÄÚµù", Font.PLAIN, 20));
		productNameTF.setHorizontalAlignment(SwingConstants.CENTER);
		productNameTF.setColumns(10);
		productNameTF.setBounds(895, 181, 305, 53);
		add(productNameTF);
		
		productCountTF = new JTextField();
		productCountTF.setFont(new Font("³ª´®°íµñÄÚµù", Font.PLAIN, 20));
		productCountTF.setHorizontalAlignment(SwingConstants.CENTER);
		productCountTF.setColumns(10);
		productCountTF.setBounds(895, 267, 305, 53);
		add(productCountTF);
		
		JButton button = new JButton("\u2190");
		button.setFont(new Font("³ª´®½ºÄù¾î¶ó¿îµå ExtraBold", Font.PLAIN, 15));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PcposJFrameMain.getInstance().changePanel("adminMP");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(1123, 575, 77, 41);
		add(button);
	    }
		
		/********************************************/
		public void init() {
			tableModel=new DefaultTableModel(columnNames, 0);
			productTable.setModel(tableModel);
		}
		
		//»óÇ° Å×ÀÌºí 
		
	
		
		public void productListJTable() throws Exception{
			ArrayList<Product> productList = productService.findProductAll();
			Vector data=new Vector();
			for(Product product:productList) {
				Vector rowVector=new Vector();
				rowVector.add(product.getNo());
				rowVector.add(product.getType());
				rowVector.add(product.getName());
				rowVector.add(product.getPrice());
				rowVector.add(product.getCount());
				data.add(rowVector);
			}
			tableModel=
					new DefaultTableModel(data, columnNames);
			productTable.setModel(tableModel);
		}
		
		

	}


