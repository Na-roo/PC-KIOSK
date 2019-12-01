package project1.ui;

import javax.swing.JPanel;
import javax.swing.JTextField;

import project1.nonmember.NonMemberService;
import project1.nonmember.Nonmember;
import sun.misc.Contended;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.SwingConstants;

public class NonMemberJPanel_1 extends JPanel {
	private JTextField randomNo;
	NonMemberJPanel_2 nonMemberJPanel_2;
	//프레임 참조변수 선언
	PcposJFrameMain mainFrame;
	NonMemberService nonMemberService;
	
	public void setMainFrame(PcposJFrameMain mainFrame) {
		this.mainFrame = mainFrame;
	}

	/**
	 * Create the panel.
	 */
	static int no;
	public NonMemberJPanel_1() {				// 랜덤 번호 반환
		nonMemberJPanel_2 = new NonMemberJPanel_2();
		try {
			nonMemberService = new NonMemberService();
		} catch (Exception e1) {
			e1.printStackTrace();
		} 
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				try {
					 no = nonMemberService.nonjoin(new Nonmember());
					randomNo.setText(no + "");
					PcposJFrameMain.nonmember = nonMemberService.findByno(no);
					System.out.println(no);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		randomNo = new JTextField();
		randomNo.setHorizontalAlignment(SwingConstants.CENTER);
		randomNo.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 12));
		randomNo.setBounds(408, 219, 455, 82);
		
		add(randomNo);
		randomNo.setColumns(10);
		
		JButton btnNewButton = new JButton("\uBE44\uD68C\uC6D0 \uB85C\uADF8\uC778");
		btnNewButton.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.changePanel("m2");
			}
		});
		btnNewButton.setBounds(408, 418, 455, 82);
		add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("\uBE44\uD68C\uC6D0");
		lblNewLabel.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 15));
		lblNewLabel.setBounds(12, 10, 57, 15);
		add(lblNewLabel);
		
		
		

	}


}
