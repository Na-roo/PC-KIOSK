package project1.ui;

import javax.swing.JPanel;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class NonMemberJPanel_3 extends JPanel {
	private JTextField noTF;		//���⿡ ���� ����??
	public JTextField getFeeTF() {
		return noTF;
	}

	public void setFeeTF(JTextField feeTF) {
		this.noTF = feeTF;
	}

	public JTextField getChargeTF() {
		return chargeTF;
	}

	public void setChargeTF(JTextField chargeTF) {
		this.chargeTF = chargeTF;
	}

	public JTextField getTimeTF() {
		return timeTF;
	}

	public void setTimeTF(JTextField timeTF) {
		this.timeTF = timeTF;
	}

	private JTextField chargeTF;
	private JTextField timeTF;
	private PcposJFrameMain mainFrame;
	private JTextField textField_3;
	
	public void setMainFrame(PcposJFrameMain mainFrame) {
		this.mainFrame = mainFrame;
	}
	
	/**
	 * Create the panel.
	 */
	public NonMemberJPanel_3() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				showData();
				showNo();
				showtime();
			}
		});
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JButton cardBT = new JButton("\uCE74\uB4DC");
		cardBT.setFont(new Font("������������� ExtraBold", Font.PLAIN, 15));
		cardBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "������ �Ϸ� �Ǿ����ϴ�.","�ȳ�" , JOptionPane.INFORMATION_MESSAGE);
				mainFrame.changePanel("m4");
			}
		});
		cardBT.setBounds(833, 426, 200, 160);
		add(cardBT);
		
		JButton cashBT = new JButton("\uD604\uAE08");
		cashBT.setFont(new Font("������������� ExtraBold", Font.PLAIN, 15));
		cashBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "������ �Ϸ� �Ǿ����ϴ�.","�ȳ�" , JOptionPane.INFORMATION_MESSAGE);
				mainFrame.changePanel("m4");
			}
		});
		cashBT.setBounds(833, 133, 200, 160);
		add(cashBT);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(153, 204, 255));
		panel_1.setBounds(205, 89, 350, 540);
		add(panel_1);
		panel_1.setLayout(null);
		
		noTF = new JTextField();
		noTF.setHorizontalAlignment(SwingConstants.CENTER);
		noTF.setFont(new Font("������������� ExtraBold", Font.PLAIN, 12));
		noTF.setText("������ ���");		//���⿡ �ؽ�Ʈ �����°ǰ�??
		noTF.setBounds(51, 80, 233, 73);
		panel_1.add(noTF);		//��� �ؽ�Ʈ�ʵ�
		noTF.setColumns(10);
		
		
		
		chargeTF = new JTextField();
		chargeTF.setHorizontalAlignment(SwingConstants.CENTER);
		chargeTF.setFont(new Font("������������� ExtraBold", Font.PLAIN, 12));
		chargeTF.setText("���⿡ ����� ���;���");
		chargeTF.setColumns(10);
		chargeTF.setBounds(51, 233, 233, 73);
		panel_1.add(chargeTF);
		
		timeTF = new JTextField();
		timeTF.setHorizontalAlignment(SwingConstants.CENTER);
		timeTF.setFont(new Font("������������� ExtraBold", Font.PLAIN, 12));
		timeTF.setText("\uCDA9\uC804 \uC2DC\uAC04");
		timeTF.setColumns(10);
		timeTF.setBounds(51, 386, 233, 73);
		panel_1.add(timeTF);
		
		textField_3 = new JTextField();
		textField_3.setBackground(Color.WHITE);
		textField_3.setFont(new Font("������������� ExtraBold", Font.PLAIN, 15));
		textField_3.setText("\uBE44\uD68C\uC6D0");
		textField_3.setBounds(12, 10, 116, 21);
		add(textField_3);
		textField_3.setColumns(10);

		
		
		
		
	}
	
	public void showData() {
		chargeTF.setText(PcposJFrameMain.money + "��");
	}
	public void showNo() {
		noTF.setText(NonMemberJPanel_1.no + "��");
	}
	public void showtime() {
		timeTF.setText(PcposJFrameMain.time+"");
	}
}
