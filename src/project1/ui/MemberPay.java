package project1.ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;

import javafx.collections.ListChangeListener.Change;
import project1.member.MemberService;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class MemberPay extends JPanel {
	private JTextField idTF;
	private JTextField nameTF;
	private JTextField timeTF;
	private PcposJFrameMain mainFrame;
	public static MemberSearch memberSearch;
	
	public void setMainFrame(PcposJFrameMain mainFrame) {
		this.mainFrame = mainFrame;
	}

	/**
	 * Create the panel.
	 */
	public MemberPay() {

		addComponentListener(new ComponentAdapter() {		
			@Override
			public void componentShown(ComponentEvent e) {
				showid();											//¿©±â°¡ ÅØ½ºÆ® º¸¿©Áö´Â°÷
				showName();
				rTime();
			}
		});
		setBackground(new Color(255, 255, 255));
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 204, 255));
		panel.setBounds(72, 85, 488, 510);
		add(panel);
		panel.setLayout(null);

		JButton btnNewButton = new JButton("1000\uC6D0                      1\uC2DC\uAC04");
		btnNewButton.setFont(new Font("³ª´®½ºÄù¾î¶ó¿îµå ExtraBold", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PcposJFrameMain.money = 1000;
					PcposJFrameMain.chargeTime = 1;
				} catch (Exception e2) {
					// TODO: handle exception
				}
				mainFrame.changePanel("mF");
			}
		});
		btnNewButton.setBounds(12, 90, 211, 49);
		panel.add(btnNewButton);

		JButton button = new JButton("2000\uC6D0                      2\uC2DC\uAC04");
		button.setFont(new Font("³ª´®½ºÄù¾î¶ó¿îµå ExtraBold", Font.PLAIN, 12));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PcposJFrameMain.money = 2000;
					PcposJFrameMain.chargeTime = 2;
				} catch (Exception e2) {
					// TODO: handle exception
				}
				mainFrame.changePanel("mF");
			}
		});
		button.setBounds(12, 229, 211, 49);
		panel.add(button);

		JButton button_1 = new JButton("3000\uC6D0                      3\uC2DC\uAC04");
		button_1.setFont(new Font("³ª´®½ºÄù¾î¶ó¿îµå ExtraBold", Font.PLAIN, 12));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PcposJFrameMain.money = 3000;
					PcposJFrameMain.chargeTime = 3;
				} catch (Exception e2) {
					// TODO: handle exception
				}
				mainFrame.changePanel("mF");
			}
		});
		button_1.setBounds(12, 368, 211, 49);
		panel.add(button_1);

		JButton button_2 = new JButton("4000\uC6D0                      4\uC2DC\uAC04");
		button_2.setFont(new Font("³ª´®½ºÄù¾î¶ó¿îµå ExtraBold", Font.PLAIN, 12));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		//¿ä±Ý¹öÆ°
				try {
					PcposJFrameMain.money = 4000;
					PcposJFrameMain.chargeTime = 4;
				} catch (Exception e2) {
					// TODO: handle exception
				}
				mainFrame.changePanel("mF");					//ÀüÈ¯ °¡´É
			}
		});
		button_2.setBounds(265, 90, 211, 49);
		panel.add(button_2);

		JButton button_3 = new JButton("5000\uC6D0                      5\uC2DC\uAC04");
		button_3.setFont(new Font("³ª´®½ºÄù¾î¶ó¿îµå ExtraBold", Font.PLAIN, 12));
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PcposJFrameMain.money = 5000;
					PcposJFrameMain.chargeTime = 5;
				} catch (Exception e2) {
					// TODO: handle exception
				}
				mainFrame.changePanel("mF");
			}
		});
		button_3.setBounds(265, 229, 211, 49);
		panel.add(button_3);

		JButton button_4 = new JButton("10000\uC6D0                      10\uC2DC\uAC04");
		button_4.setFont(new Font("³ª´®½ºÄù¾î¶ó¿îµå ExtraBold", Font.PLAIN, 12));
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PcposJFrameMain.money = 10000;
					PcposJFrameMain.chargeTime = 10;
				} catch (Exception e2) {
					// TODO: handle exception
				}
				mainFrame.changePanel("mF");
			}
		});
		button_4.setBounds(265, 368, 211, 49);
		panel.add(button_4);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(102, 153, 204));
		panel_1.setBounds(707, 85, 488, 510);
		add(panel_1);
		panel_1.setLayout(null);

		idTF = new JTextField();
		idTF.setHorizontalAlignment(SwingConstants.CENTER);
		idTF.setEditable(false);
		idTF.setFont(new Font("³ª´®½ºÄù¾î¶ó¿îµå ExtraBold", Font.PLAIN, 12));
		idTF.setBounds(175, 89, 220, 45);
		panel_1.add(idTF);
		idTF.setColumns(10);

		nameTF = new JTextField();
		nameTF.setHorizontalAlignment(SwingConstants.CENTER);
		nameTF.setEditable(false);
		nameTF.setFont(new Font("³ª´®½ºÄù¾î¶ó¿îµå ExtraBold", Font.PLAIN, 12));
		nameTF.setColumns(10);
		nameTF.setBounds(175, 227, 220, 45);
		panel_1.add(nameTF);

		timeTF = new JTextField();
		timeTF.setHorizontalAlignment(SwingConstants.CENTER);
		timeTF.setEditable(false);
		timeTF.setFont(new Font("³ª´®½ºÄù¾î¶ó¿îµå ExtraBold", Font.PLAIN, 12));
		timeTF.setColumns(10);
		timeTF.setBounds(175, 365, 220, 45);
		panel_1.add(timeTF);
		
		JLabel lblNewLabel_2 = new JLabel("\uC544\uC774\uB514");
		lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(88, 103, 57, 15);
		panel_1.add(lblNewLabel_2);
		
		JLabel label = new JLabel("\uC774\uB984");
		label.setFont(new Font("Dialog", Font.PLAIN, 14));
		label.setBounds(88, 241, 57, 15);
		panel_1.add(label);
		
		JLabel label_2 = new JLabel("\uB0A8\uC740\uC2DC\uAC04");
		label_2.setFont(new Font("Dialog", Font.PLAIN, 14));
		label_2.setBounds(88, 379, 57, 15);
		panel_1.add(label_2);

		JLabel label_1 = new JLabel(
				"\uC548\uB155\uD558\uC138\uC694. \uCDA9\uC804\uD558\uC2E4 \uC694\uAE08\uC744 \uC120\uD0DD\uD558\uC138\uC694.");
		label_1.setFont(new Font("³ª´®½ºÄù¾î¶ó¿îµå ExtraBold", Font.PLAIN, 15));
		label_1.setBackground(Color.WHITE);
		label_1.setBounds(60, 10, 299, 23);
		add(label_1);

		JLabel lblNewLabel = new JLabel("\uD68C\uC6D0\uC815\uBCF4");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("³ª´®½ºÄù¾î¶ó¿îµå ExtraBold", Font.PLAIN, 15));
		lblNewLabel.setBounds(907, 47, 89, 28);
		add(lblNewLabel);

		JButton button_5 = new JButton("<<\uC774\uC804");
		button_5.setFont(new Font("³ª´®½ºÄù¾î¶ó¿îµå ExtraBold", Font.PLAIN, 12));
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		//ÀÌÀü¹öÆ°
				memberSearch.init();
				mainFrame.changePanel("mS");					//¹öÆ° °¡´É
			}
		});
		button_5.setBounds(12, 608, 97, 42);
		add(button_5);
		
		JLabel lblNewLabel_1 = new JLabel("\uD68C\uC6D0");
		lblNewLabel_1.setFont(new Font("³ª´®½ºÄù¾î¶ó¿îµå ExtraBold", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(12, 14, 57, 15);
		add(lblNewLabel_1);

	}
	
	public void showid() {
		try {
			//idTF.setText(MemberSearch.member.getId());
			idTF.setText(MemberService.getInstance().returnID(MemberSearch.no1) + "");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void showName() {
		try {
			nameTF.setText(MemberService.getInstance().returnName(MemberSearch.no1) + "");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void rTime() {
		try {
			timeTF.setText(MemberService.getInstance().returnRTime(MemberSearch.no1) + "");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
