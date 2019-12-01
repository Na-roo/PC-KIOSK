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

public class MemberCreateDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField noTF;
	private JTextField nameTF;
	private JTextField idTF;
	private JTextField passTF;
	private JTextField birthTF;
	private JTextField callTF;
	
	MemberService memberService;
	MemberPanel memberPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws Exception {
		try {
			MemberCreateDialog dialog = new MemberCreateDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MemberCreateDialog() throws Exception {
		
		memberService = new MemberService();
		
		setBounds(100, 100, 450, 515);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uD68C\uC6D0\uB4F1\uB85D");
		lblNewLabel.setFont(new Font("나눔고딕코딩", Font.PLAIN, 36));
		lblNewLabel.setBounds(144, 29, 153, 42);
		contentPanel.add(lblNewLabel);
		
		JLabel label_5 = new JLabel("\uBC88    \uD638");
		label_5.setFont(new Font("나눔고딕코딩", Font.PLAIN, 16));
		label_5.setBounds(59, 104, 72, 24);
		contentPanel.add(label_5);
		
		JLabel label = new JLabel("\uC774    \uB984");
		label.setFont(new Font("나눔고딕코딩", Font.PLAIN, 16));
		label.setBounds(59, 145, 72, 24);
		contentPanel.add(label);
	
		JLabel label_1 = new JLabel("\uC544 \uC774 \uB514");
		label_1.setFont(new Font("나눔고딕코딩", Font.PLAIN, 16));
		label_1.setBounds(59, 183, 72, 24);
		contentPanel.add(label_1);
	
		JLabel label_2 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		label_2.setFont(new Font("나눔고딕코딩", Font.PLAIN, 16));
		label_2.setBounds(59, 221, 72, 24);
		contentPanel.add(label_2);
			
		JLabel label_3 = new JLabel("\uC0DD\uB144\uC6D4\uC77C");
		label_3.setFont(new Font("나눔고딕코딩", Font.PLAIN, 16));
		label_3.setBounds(59, 259, 72, 24);
		contentPanel.add(label_3);
	
		noTF = new JTextField();
		noTF.setColumns(10);
		noTF.setBounds(144, 104, 154, 28);
		contentPanel.add(noTF);
		
		nameTF = new JTextField();
		nameTF.setColumns(10);
		nameTF.setBounds(144, 142, 154, 28);
		contentPanel.add(nameTF);
		
		idTF = new JTextField();
		idTF.setColumns(10);
		idTF.setBounds(144, 180, 154, 28);
		contentPanel.add(idTF);
		
		passTF = new JTextField();
		passTF.setColumns(10);
		passTF.setBounds(144, 218, 154, 28);
		contentPanel.add(passTF);
		
		birthTF = new JTextField();
		birthTF.setColumns(10);
		birthTF.setBounds(144, 256, 154, 28);
		contentPanel.add(birthTF);
		
		JLabel label_4 = new JLabel("\uC804\uD654\uBC88\uD638");
		label_4.setFont(new Font("나눔고딕코딩", Font.PLAIN, 16));
		label_4.setBounds(59, 298, 72, 24);
		contentPanel.add(label_4);
		
		callTF = new JTextField();
		callTF.setColumns(10);
		callTF.setBounds(144, 294, 154, 28);
		contentPanel.add(callTF);
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
							
							
							memberService.registerMember(new Member((Integer.parseInt(noStr)), idStr, passStr, nameStr, birthStr, callStr, 0, 0));
							memberPanel.memberListTable();
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

