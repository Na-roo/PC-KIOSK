package project1.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import project1.admin.Admin;
import project1.admin.AdminService;

public class AdminCreateDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField adminnoTF;
	private JTextField adminnameTF;
	private JTextField adminidTF;
	private JTextField adminpassTF;
	private JTextField admincallTF;
	
	
	AdminService adminService;
	AdminPanel adminPanel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws Exception {
		try {
			AdminCreateDialog dialog = new AdminCreateDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AdminCreateDialog() throws Exception {
		
		adminService = new AdminService();
		
		setBounds(100, 100, 450, 515);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC9C1\uC6D0\uB4F1\uB85D");
		lblNewLabel.setFont(new Font("나눔고딕코딩", Font.PLAIN, 36));
		lblNewLabel.setBounds(144, 10, 153, 42);
		contentPanel.add(lblNewLabel);
		
		JLabel label_5 = new JLabel("\uBC88    \uD638");
		label_5.setFont(new Font("나눔고딕코딩", Font.PLAIN, 16));
		label_5.setBounds(59, 71, 72, 24);
		contentPanel.add(label_5);
		
		adminnoTF = new JTextField();
		adminnoTF.setColumns(10);
		adminnoTF.setBounds(143, 70, 154, 28);
		contentPanel.add(adminnoTF);
		
		JLabel label = new JLabel("\uC774    \uB984");
		label.setFont(new Font("나눔고딕코딩", Font.PLAIN, 16));
		label.setBounds(59, 112, 72, 24);
		contentPanel.add(label);
		
		adminnameTF = new JTextField();
		adminnameTF.setBounds(143, 108, 154, 28);
		contentPanel.add(adminnameTF);
		adminnameTF.setColumns(10);
		
		JLabel label_1 = new JLabel("\uC544 \uC774 \uB514");
		label_1.setFont(new Font("나눔고딕코딩", Font.PLAIN, 16));
		label_1.setBounds(59, 150, 72, 24);
		contentPanel.add(label_1);
		
		adminidTF = new JTextField();
		adminidTF.setColumns(10);
		adminidTF.setBounds(143, 146, 154, 28);
		contentPanel.add(adminidTF);
		
		JLabel label_2 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		label_2.setFont(new Font("나눔고딕코딩", Font.PLAIN, 16));
		label_2.setBounds(59, 188, 72, 24);
		contentPanel.add(label_2);
		
		adminpassTF = new JTextField();
		adminpassTF.setColumns(10);
		adminpassTF.setBounds(143, 184, 154, 28);
		contentPanel.add(adminpassTF);
		
		JLabel label_3 = new JLabel("\uC804\uD654\uBC88\uD638");
		label_3.setFont(new Font("나눔고딕코딩", Font.PLAIN, 16));
		label_3.setBounds(59, 226, 72, 24);
		contentPanel.add(label_3);
		
		admincallTF = new JTextField();
		admincallTF.setColumns(10);
		admincallTF.setBounds(143, 222, 154, 28);
		contentPanel.add(admincallTF);
		
		JLabel label_4 = new JLabel("\uC9C1    \uAE09");
		label_4.setFont(new Font("나눔고딕코딩", Font.PLAIN, 16));
		label_4.setBounds(59, 262, 72, 24);
		contentPanel.add(label_4);
		
		//직급선택
		JComboBox<String> positionCB = new JComboBox<String>();
		positionCB.setModel(new DefaultComboBoxModel<String>(new String[] {"직급 선택", "직원", "매니저", "사장"}));
		
		positionCB.setBounds(144, 260, 153, 28);
		contentPanel.add(positionCB);
		{  
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("등록");
				okButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						try {
							String noStr=adminnoTF.getText();
							String nameStr=adminnameTF.getText();
							String idStr=adminidTF.getText();
							String passStr=adminpassTF.getText();
							String callStr=admincallTF.getText();
							int selectedIndex=positionCB.getSelectedIndex();
							String position="";
							
							if (noStr.trim().equals("")) {
								JOptionPane.showMessageDialog(null, "번호를 입력하세요");
								return;
							}else if (nameStr.trim().equals("")) {
								JOptionPane.showMessageDialog(null, "이름을 입력하세요");
								return;
							}else if (idStr.trim().equals("")) {
								JOptionPane.showMessageDialog(null, "아이디를 입력하세요");
								return;
							}else if (passStr.trim().equals("")) {
								JOptionPane.showMessageDialog(null, "비밀번호를 입력하세요");
								return;
							}else if (callStr.trim().equals("")) {
								JOptionPane.showMessageDialog(null, "전화번호를 입력하세요");
								return;
							}else if (selectedIndex==0) {
								JOptionPane.showMessageDialog(null, "직급을 선택하세요");
								return;
							}
							
							if (selectedIndex==1) {
								position = "직원";
							}else if (selectedIndex==2) {
								position = "매니저";
							}else if (selectedIndex==3) {
								position = "사장";
							}
							adminService.adminRegister(new Admin(Integer.parseInt(noStr), nameStr, idStr, passStr, callStr, position));
							adminPanel.adminListTable();
							dispose();
							
							
							//이거 왜 명령하는지 모르겠음..이해 안됨, 그냥 따라썼음
							/*String positionStr=(String)positionCB.getSelectedItem();
							Integer.parseInt(positionStr);
							*/
							
						} catch (Exception e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
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

