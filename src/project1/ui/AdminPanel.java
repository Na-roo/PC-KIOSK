package project1.ui;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import project1.admin.Admin;
import project1.admin.AdminService;

public class AdminPanel extends JPanel {
	private JTextField findIdTF;
	private JTable adminTable;
	private JTextField adminnoTF;
	private JTextField adminnameTF;
	private JTextField idTF;
	private PcposJFrameMain mainFrame;
	
	AdminService adminService;
	//���̺� �� ��Ŀ� �´� �Ӹ��� �ٿ��ַ��� �����ѰŰ���.......vector Ÿ�� columnNames�޼ҵ�
	private Vector columnNames;
	//��µ� �迭���� ���̺� �⺻�� DefaultTableModel ������
	private DefaultTableModel tableModel;
	
	public void setMainFrame(PcposJFrameMain mainFrame) {
		this.mainFrame = mainFrame;
	}

	/**
	 * Create the panel.
	 */
	public AdminPanel() {
		//�Ʊ� ���� �������� �������� ���������� �׻� ������ ����� ���ӽ� ���̺� �����ϵ��� �ϴ� ���.......
		try {
	         adminService=new AdminService();					
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
	            	adminListTable();
	            } catch (Exception e1) {
	               // TODO Auto-generated catch block
	               e1.printStackTrace();
	            }
	         }
	      });  
		
		setBackground(SystemColor.info);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(12, 10, 844, 516);
		add(scrollPane);
		
		adminTable = new JTable();
		//adminTable�� �ҷ��� �� �������࿡ ���콺 Ŭ���� ������ ������ ���� �̺�Ʈ
		//������ ���콺�̺�Ʈ ���� �ƿ� �ϳ��� �𸣰���
		adminTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow=adminTable.getSelectedRow();
				int selectedColumn=adminTable.getSelectedColumn();
				int selectedNo=(Integer)adminTable.getValueAt(selectedRow, 0);
				System.out.println("selected No: "+selectedNo);
				
				Admin admin;
				
				try {
					admin=adminService.findByNo(selectedNo);
					
					adminnoTF.setText(admin.getNo()+"");
					adminnameTF.setText(admin.getName());
					idTF.setText(admin.getId());
					
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		
		
		//��������Ʈ ���̺� ��ĸӸ����ٿ��ַ��� ��������, ������ �����Ϸ��� ��ü������ add�Լ� �̿��Ͽ� �����ʹ���
		columnNames=new Vector();
		columnNames.add("��ȣ");
		columnNames.add("�̸�");
		columnNames.add("ID");
		columnNames.add("PW");
		columnNames.add("��ȭ��ȣ");
		columnNames.add("����");
		tableModel=new DefaultTableModel(columnNames, 0);
		adminTable.setModel(tableModel);
		
		
		scrollPane.setViewportView(adminTable);
		
		
		//�˻� ��ư ����
		findIdTF = new JTextField();
		findIdTF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		findIdTF.setColumns(10);
		findIdTF.setBounds(12, 560, 230, 59);
		add(findIdTF);
		
		
		JButton findByNameB = new JButton("\uAC80\uC0C9");
		findByNameB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Admin> adminList;
				try {
					adminList=adminService.findByName(findIdTF.getText());
					
					//for������ ������ �׸���� �ϳ��� ��ģ �����͵��� �����ϱ� ���� VectorŸ���� data ���� ���� = new Vector(); ��ü����
					Vector data=new Vector();
					
					//��ǰ����Ʈ�� �� �׸��� �����͵��� ����� VectorŸ���� rowVector���� ���� = new Vector(); ��ü����
					for(Admin admin:adminList) {
						Vector rowVector=new Vector();
						rowVector.add(admin.getNo());				//������ȣ
						rowVector.add(admin.getName());				//�����̸�
						rowVector.add(admin.getId());				//�������̵�
						rowVector.add(admin.getPassword());			//������й�ȣ
						rowVector.add(admin.getPhoneNo());			//������ȭ��ȣ
						rowVector.add(admin.getPosition());			//��������
						//for������ ������ �� �����͵��� Vector Ÿ���� data������ ����
						data.add(rowVector);					
						
					if (findIdTF.getText()==null) {
						init();
					}
					}
						
					tableModel=new DefaultTableModel(data, columnNames);
					adminTable.setModel(tableModel);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		findByNameB.setFont(new Font("������������� ExtraBold", Font.PLAIN, 15));
		findByNameB.setBounds(241, 560, 97, 59);
		add(findByNameB);
		
		JButton adminCreateB = new JButton("�������");
		adminCreateB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminCreateDialog adminCreateDialog;
				try {
					adminCreateDialog = new AdminCreateDialog();
					adminCreateDialog.adminPanel=AdminPanel.this;
					adminCreateDialog.setModal(true);
					adminCreateDialog.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
		
		adminCreateB.setFont(new Font("������������� ExtraBold", Font.PLAIN, 15));
		adminCreateB.setBounds(429, 560, 157, 59);
		add(adminCreateB);
		
		JButton adminUpdateB = new JButton("��������");
		adminUpdateB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AdminUpdateDialog adminUpdateDialog = new AdminUpdateDialog();
					int selectedRow = adminTable.getSelectedRow();
					Admin updateAdmin;
					updateAdmin = adminService.findByNo((Integer)adminTable.getValueAt(selectedRow,0));
					adminUpdateDialog.setUpdateAdmin(updateAdmin); 
					adminUpdateDialog.adminPanel=AdminPanel.this;
					adminUpdateDialog.setModal(true);
					adminUpdateDialog.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
			}
		});
		adminUpdateB.setFont(new Font("������������� ExtraBold", Font.PLAIN, 15));
		adminUpdateB.setBounds(652, 560, 157, 59);
		add(adminUpdateB);
		
		//����
		JButton adminDeleteB = new JButton("��������");
		adminDeleteB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String findnameStr=adminnameTF.getText();
				if (findnameStr.equals("")) {
					return;
				}
				try {
					adminService.deleteAdmin(findnameStr);
					adminnoTF.setText("");
					adminnameTF.setText("");
					idTF.setText("");
					adminListTable();
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		
		
		adminDeleteB.setFont(new Font("������������� ExtraBold", Font.PLAIN, 15));
		adminDeleteB.setBounds(1039, 467, 157, 59);
		add(adminDeleteB);
		
		JButton backB = new JButton("\u2190");
		backB.setFont(new Font("������������� ExtraBold", Font.PLAIN, 15));
		backB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PcposJFrameMain.getInstance().changePanel("adminMP");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		backB.setBounds(1119, 569, 77, 41);
		add(backB);
		
		adminnoTF = new JTextField();
		adminnoTF.setFont(new Font("��������ڵ�", Font.BOLD, 20));
		adminnoTF.setBounds(891, 74, 305, 53);
		add(adminnoTF);
		adminnoTF.setColumns(10);
		
		adminnameTF = new JTextField();
		adminnameTF.setFont(new Font("��������ڵ�", Font.BOLD, 20));
		adminnameTF.setColumns(10);
		adminnameTF.setBounds(891, 180, 305, 53);
		add(adminnameTF);
		
		idTF = new JTextField();
		idTF.setFont(new Font("��������ڵ�", Font.BOLD, 20));
		idTF.setColumns(10);
		idTF.setBounds(891, 284, 305, 53);
		add(idTF);
	}
	
	
	
	//�ҷ��� admin�� �����͵��� �ҷ��ö����� ���̺� �����ϱ� ���ؼ��� ������ �ʿ��ϱ⶧���� init �޼ҵ� ����
	public void init() {
		tableModel=new DefaultTableModel(columnNames, 0);
		adminTable.setModel(tableModel);
	}
	
	
	//��ǰ���̺� ������ �߰��� �޼ҵ�
	//���� �߻��� �ش� �޼ҵ忡�� �ذ��϶�� ����ó��
	public void adminListTable() throws Exception {
		ArrayList<Admin> adminList=adminService.findAllAdmin();
		
		//for������ ������ �׸���� �ϳ��� ��ģ �����͵��� �����ϱ� ���� VectorŸ���� data ���� ���� = new Vector(); ��ü����
		Vector data=new Vector();
		
		for (Admin admin:adminList) {
			//��ǰ����Ʈ�� �� �׸��� �����͵��� ����� VectorŸ���� rowVector���� ���� = new Vector(); ��ü����
			Vector rowVector=new Vector();
			rowVector.add(admin.getNo());				//������ȣ
			rowVector.add(admin.getName());				//�����̸�
			rowVector.add(admin.getId());				//�������̵�
			rowVector.add(admin.getPassword());			//������й�ȣ
			rowVector.add(admin.getPhoneNo());			//������ȭ��ȣ
			rowVector.add(admin.getPosition());			//��������
			//for������ ������ �� �����͵��� Vector Ÿ���� data������ ����
			data.add(rowVector);
		}
		
		//�� for������ ���� �����͵��� ���ڰ��� ���̺� �־��ֱ����� data�� columnNames�� ���ڷ� ����
		//���ڸ� �ް� �ּҰ��� ����� �����͵��� tableModel�� ���Եȴ�
		tableModel=new DefaultTableModel(data, columnNames);
		adminTable.setModel(tableModel);
	}
}






