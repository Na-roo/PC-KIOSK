package project1.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import project1.member.MemberService;
import project1.product.Product;
import project1.member.Member;

public class MemberFee extends JPanel {
	private JTextField payTF;
	private JTextField timeTF;
	private JTextField afterTF;
	private PcposJFrameMain mainFrame;
	public MemberService memberService;
	public static MemberSearch memberSearch;
	

	public void setMainFrame(PcposJFrameMain mainFrame) {
		this.mainFrame = mainFrame;
	}

	/**
	 * Create the panel.
	 */

	
	public MemberFee() throws Exception{
		memberService = new MemberService(); 
		
		
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {		//여기에 텍스트 보여지는 곳

				showData();		
				chargeTime();	
				rTime();
			}
		});
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 153, 204));
		panel.setBounds(187, 85, 900, 510);
		add(panel);
		panel.setLayout(null);
		
		payTF = new JTextField();
		payTF.setEditable(false);
		payTF.setHorizontalAlignment(SwingConstants.CENTER);
		payTF.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 12));
		payTF.setBounds(194, 86, 300, 55);
		panel.add(payTF);
		payTF.setColumns(10);
		
		
		timeTF = new JTextField();
		timeTF.setEditable(false);
		timeTF.setHorizontalAlignment(SwingConstants.CENTER);
		timeTF.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 12));
		timeTF.setColumns(10);
		timeTF.setBounds(194, 227, 300, 55);
		panel.add(timeTF);
		
		afterTF = new JTextField();
		afterTF.setEditable(false);
		afterTF.setHorizontalAlignment(SwingConstants.CENTER);
		afterTF.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 12));
		afterTF.setColumns(10);
		afterTF.setBounds(194, 368, 300, 55);
		panel.add(afterTF);
		
		JButton btnNewButton = new JButton("\uD604\uAE08");
		btnNewButton.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		//현금버튼
				JOptionPane.showMessageDialog(null, "결제가 완료 되었습니다.","안내" , JOptionPane.INFORMATION_MESSAGE);
				afterTF.setText("");
				timeTF.setText("");
				payTF.setText("");
				memberSearch.init();
				
				try {
					MemberService.getInstance().chargedByFee(MemberSearch.no1, PcposJFrameMain.money);
//					Member temp = memberService.searchByNo(MemberSearch.no1);
//					memberService.updateMember(temp);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				mainFrame.changePanel("main");					
			}
		});
		btnNewButton.setBounds(618, 100, 154, 104);
		panel.add(btnNewButton);
		
		JButton button_1 = new JButton("\uCE74\uB4DC");
		button_1.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 12));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		//카드버튼
				JOptionPane.showMessageDialog(null, "결제가 완료 되었습니다.","안내" , JOptionPane.INFORMATION_MESSAGE);
				afterTF.setText("");
				timeTF.setText("");
				payTF.setText("");
				memberSearch.init();
				try {
					MemberService.getInstance().chargedByFee(MemberSearch.no1, PcposJFrameMain.money);
//					Member temp = memberService.searchByNo(MemberSearch.no1);
//					memberService.updateMember(temp);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				mainFrame.changePanel("main");					
			}
		});
		button_1.setBounds(618, 304, 154, 104);
		panel.add(button_1);
		
		JLabel lblC = new JLabel("\uCDA9\uC804\uD560 \uC694\uAE08");
		lblC.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblC.setBounds(74, 105, 80, 15);
		panel.add(lblC);
		
		JLabel label_2 = new JLabel("\uB0A8\uC740 \uC2DC\uAC04");
		label_2.setFont(new Font("Dialog", Font.PLAIN, 14));
		label_2.setBounds(74, 246, 80, 15);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("\uCDA9\uC804\uD6C4 \uC2DC\uAC04");
		label_3.setFont(new Font("Dialog", Font.PLAIN, 14));
		label_3.setBounds(74, 387, 80, 15);
		panel.add(label_3);
		
		JLabel label = new JLabel("\uD68C\uC6D0");
		label.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 15));
		label.setBackground(Color.WHITE);
		label.setBounds(12, 10, 55, 23);
		add(label);
		
		JLabel label_1 = new JLabel("\uC694\uAE08\uC744 \uCDA9\uC804\uD560 \uBC29\uC2DD\uC744 \uC120\uD0DD\uD558\uC138\uC694");
		label_1.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 15));
		label_1.setBackground(Color.WHITE);
		label_1.setBounds(60, 10, 327, 23);
		add(label_1);
		
		JButton button = new JButton("<<\uC774\uC804");
		button.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 12));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		//이전버튼
				mainFrame.changePanel("mP");					
			}
		});
		button.setBounds(12, 608, 97, 42);
		add(button);

	}
	
	
	public void showData() {			//충전금액
		payTF.setText(PcposJFrameMain.money + "원");
	}
	public void chargeTime() {			//충전시간
		timeTF.setText(PcposJFrameMain.chargeTime + "");
	}
	
	public void rTime() {			//충전후 시간
		try {
			afterTF.setText((project1.member.MemberService.getInstance().returnRTime(MemberSearch.no1)) + (PcposJFrameMain.chargeTime) + "");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}



