package project1.ui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminMainPanel extends JPanel {

	public static AdminMainPanel adminMainPanel;
	
	public static AdminMainPanel getInstance() {
		if (adminMainPanel==null) {
			adminMainPanel = new AdminMainPanel();
		}
		return adminMainPanel;
	}
	
	PcposJFrameMain mainFrame;
	

	public void setMainFrame(PcposJFrameMain mainFrame) {
		this.mainFrame = mainFrame;
	}
	/**
	 * Create the panel.
	 */
	public AdminMainPanel() {
		setBackground(new Color(153, 204, 255));
		setLayout(null);
		
		JButton button = new JButton("\uC9C1\uC6D0\uAD00\uB9AC");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		//직원관리
				mainFrame.changePanel("adminP");
				
			}
		});
		button.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 20));
		button.setBounds(109, 219, 300, 150);
		add(button);
		
		JButton button_1 = new JButton("\uD68C\uC6D0\uAD00\uB9AC");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		//회원관리
				mainFrame.changePanel("adminM");			
			}
		});
		button_1.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 20));
		button_1.setBounds(476, 219, 300, 150);
		add(button_1);
		
		JButton button_2 = new JButton("\uC0C1\uD488\uAD00\uB9AC");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		//상품관리
				mainFrame.changePanel("adminPd");
			}
		});
		button_2.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 20));
		button_2.setBounds(845, 219, 300, 150);
		add(button_2);
		
		JButton button_4 = new JButton("\uB85C\uADF8\uC544\uC6C3");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		// 로그아웃
				mainFrame.changePanel("main");  			//로그아웃& 메인화면으로
			}
		});
		button_4.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 20));
		button_4.setBounds(506, 463, 240, 77);
		add(button_4);

	}

}
