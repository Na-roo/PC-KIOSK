package project1.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import project1.member.Member;
import project1.member.MemberService;

public class MemberUpdateDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	
	Member updateMember;
	MemberService memberService;
	MemberPanel memberPanel;
	private JTextField noTF;
	private JTextField nameTF;
	private JTextField idTF;
	private JTextField passTF;
	private JTextField birthTF;
	private JTextField callTF;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws Exception {
		try {
			MemberUpdateDialog dialog = new MemberUpdateDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * Create the dialog.
	 */

	public void setUpdateMember(Member updateMember) {
		this.updateMember=updateMember;
		noTF.setText(updateMember.getNo()+"");
		nameTF.setText(updateMember.getName());
		idTF.setText(updateMember.getId());
		passTF.setText(updateMember.getPassword());
		birthTF.setText(updateMember.getBirth());
		callTF.setText(updateMember.getTelNum());	
	}
	
	
	public MemberUpdateDialog() throws Exception{
		memberService = new MemberService();
		setBounds(100, 100, 450, 515);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uD68C\uC6D0\uC218\uC815");
		lblNewLabel.setFont(new Font("나눔고딕코딩", Font.PLAIN, 36));
		lblNewLabel.setBounds(142, 38, 153, 42);
		contentPanel.add(lblNewLabel);
		
		JLabel label = new JLabel("\uBC88    \uD638");
		label.setFont(new Font("나눔고딕코딩", Font.PLAIN, 16));
		label.setBounds(56, 105, 72, 24);
		contentPanel.add(label);
		
		noTF = new JTextField();
		noTF.setEditable(false);
		noTF.setColumns(10);
		noTF.setBounds(141, 105, 154, 28);
		contentPanel.add(noTF);
		
		JLabel label_1 = new JLabel("\uC774    \uB984");
		label_1.setFont(new Font("나눔고딕코딩", Font.PLAIN, 16));
		label_1.setBounds(56, 146, 72, 24);
		contentPanel.add(label_1);
		
		nameTF = new JTextField();
		nameTF.setColumns(10);
		nameTF.setBounds(141, 143, 154, 28);
		contentPanel.add(nameTF);
		
		JLabel label_2 = new JLabel("\uC544 \uC774 \uB514");
		label_2.setFont(new Font("나눔고딕코딩", Font.PLAIN, 16));
		label_2.setBounds(56, 184, 72, 24);
		contentPanel.add(label_2);
		
		idTF = new JTextField();
		idTF.setEditable(false);
		idTF.setColumns(10);
		idTF.setBounds(141, 181, 154, 28);
		contentPanel.add(idTF);
		
		JLabel label_3 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		label_3.setFont(new Font("나눔고딕코딩", Font.PLAIN, 16));
		label_3.setBounds(56, 222, 72, 24);
		contentPanel.add(label_3);
		
		passTF = new JTextField();
		passTF.setColumns(10);
		passTF.setBounds(141, 219, 154, 28);
		contentPanel.add(passTF);
		
		JLabel label_4 = new JLabel("\uC0DD\uB144\uC6D4\uC77C");
		label_4.setFont(new Font("나눔고딕코딩", Font.PLAIN, 16));
		label_4.setBounds(56, 260, 72, 24);
		contentPanel.add(label_4);
		
		birthTF = new JTextField();
		birthTF.setColumns(10);
		birthTF.setBounds(141, 257, 154, 28);
		contentPanel.add(birthTF);
		
		JLabel label_5 = new JLabel("\uC804\uD654\uBC88\uD638");
		label_5.setFont(new Font("나눔고딕코딩", Font.PLAIN, 16));
		label_5.setBounds(56, 299, 72, 24);
		contentPanel.add(label_5);
		
		callTF = new JTextField();
		callTF.setColumns(10);
		callTF.setBounds(141, 295, 154, 28);
		contentPanel.add(callTF);
		
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("\uC218\uC815");
				okButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						try {
							String noStr=noTF.getText();
							String nameStr=nameTF.getText();
							String idStr=idTF.getText();
							String passStr=passTF.getText();
							String birthStr=birthTF.getText();
							String callStr=callTF.getText();
							
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
							}else if (birthStr.trim().equals("")) {
								JOptionPane.showMessageDialog(null, "생년월일을 입력하세요");
								return;
							}else if (callStr.trim().equals("")) {
								JOptionPane.showMessageDialog(null, "전화번호를 입력하세요");
								return;
							}
													
							memberService.updateMember((new Member((Integer.parseInt(noStr)), idStr, passStr, nameStr, birthStr, callStr, 0, 0)));
							memberPanel.memberListTable();
							dispose();
							
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
