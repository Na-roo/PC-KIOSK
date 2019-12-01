package project1.ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

import project1.nonmember.NonMemberService;
import project1.nonmember.Nonmember;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class NonMemberJPanel_2 extends JPanel {
	private JTextField ranNoTF;
	private PcposJFrameMain mainFrame;
	private NonMemberJPanel_1 nonMemberJPanel_1;
	private NonMemberService nonMemberService;
	public static NonMemberJPanel_2 _instance;
	NonMemberJPanel_3 nonMember3;
	
	public void setNonMember3(NonMemberJPanel_3 nonMember3) {
		this.nonMember3 = nonMember3;
	}

	public static NonMemberJPanel_2 getInstance() {
		if (_instance==null) {
			_instance = new NonMemberJPanel_2();
		}
		return _instance;
	}
	
	public void setMainFrame(PcposJFrameMain mainFrame) {
		this.mainFrame = mainFrame;
	}
	
	
	/**
	 * Create the panel.
	 * 
	 */
	
	public NonMemberJPanel_2() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				try {
					ranNoTF.setText(NonMemberJPanel_1.no + "");
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
			}
		});
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(102, 153, 204));
		panel_1.setBounds(770, 89, 350, 540);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\uBE44\uD68C\uC6D0 \uBC88\uD638");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("³ª´®½ºÄù¾î¶ó¿îµå ExtraBold", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(106, 52, 136, 33);
		panel_1.add(lblNewLabel_1);
		
		
		ranNoTF = new JTextField();
		ranNoTF.setHorizontalAlignment(SwingConstants.CENTER);
		ranNoTF.setFont(new Font("³ª´®½ºÄù¾î¶ó¿îµå ExtraBold", Font.PLAIN, 12));
		ranNoTF.setBounds(79, 200, 190, 60);
		panel_1.add(ranNoTF);
		ranNoTF.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(153, 204, 255));
		panel_2.setBounds(205, 89, 350, 540);
		add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label = new JLabel("\uCDA9\uC804 \uAE08\uC561");
		label.setForeground(new Color(0, 0, 102));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("³ª´®½ºÄù¾î¶ó¿îµå ExtraBold", Font.PLAIN, 16));
		label.setBounds(118, 52, 117, 15);
		panel_2.add(label);
		
		JButton BT1 = new JButton("1,000\uC6D0");
		BT1.setFont(new Font("³ª´®½ºÄù¾î¶ó¿îµå ExtraBold", Font.PLAIN, 12));
		BT1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						//1000¿ø
				try {
					PcposJFrameMain.money=1000;
					PcposJFrameMain.time ="1½Ã°£";
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
				mainFrame.changePanel("m3");
			}
		});
		
		BT1.setBounds(104, 88, 144, 50);
		panel_2.add(BT1);
		
		JButton BT2 = new JButton("2,000\uC6D0");
		BT2.setFont(new Font("³ª´®½ºÄù¾î¶ó¿îµå ExtraBold", Font.PLAIN, 12));
		BT2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PcposJFrameMain.money=2000;
					PcposJFrameMain.time ="2½Ã°£";
				} catch (Exception e2) {
					// TODO: handle exception
				}
				mainFrame.changePanel("m3");	
				
			}
		});
		BT2.setBounds(104, 172, 144, 50);
		panel_2.add(BT2);
		
		JButton BT3 = new JButton("3,000\uC6D0");
		BT3.setFont(new Font("³ª´®½ºÄù¾î¶ó¿îµå ExtraBold", Font.PLAIN, 12));
		BT3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PcposJFrameMain.money=3000;
					PcposJFrameMain.time ="3½Ã°£";
				} catch (Exception e2) {
					// TODO: handle exception
				}
				mainFrame.changePanel("m3");		
				
			}
		});
		BT3.setBounds(104, 257, 144, 50);
		panel_2.add(BT3);
		
		JButton BT4 = new JButton("5,000\uC6D0");
		BT4.setFont(new Font("³ª´®½ºÄù¾î¶ó¿îµå ExtraBold", Font.PLAIN, 12));
		BT4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PcposJFrameMain.money=5000;
					PcposJFrameMain.time ="6½Ã°£";
				} catch (Exception e2) {
					// TODO: handle exception
				}
				mainFrame.changePanel("m3");		
				
			}
		});
		BT4.setBounds(104, 342, 144, 50);
		panel_2.add(BT4);
		
		JButton BT5 = new JButton("10,000\uC6D0");
		BT5.setFont(new Font("³ª´®½ºÄù¾î¶ó¿îµå ExtraBold", Font.PLAIN, 12));
		BT5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PcposJFrameMain.money=10000;
					PcposJFrameMain.time ="12½Ã°£";
				} catch (Exception e2) {
					// TODO: handle exception
				}
				mainFrame.changePanel("m3");		
				
			}
		});
		BT5.setBounds(104, 429, 144, 50);
		panel_2.add(BT5);
		
		JLabel lblNewLabel = new JLabel("\uBE44\uD68C\uC6D0");
		lblNewLabel.setFont(new Font("³ª´®½ºÄù¾î¶ó¿îµå ExtraBold", Font.PLAIN, 15));
		lblNewLabel.setBounds(12, 10, 57, 15);
		add(lblNewLabel);

	}

}
