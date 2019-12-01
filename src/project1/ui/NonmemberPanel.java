package project1.ui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NonmemberPanel extends JPanel {
	private JTextField textField;
	private JTable nonmemberTable;
	private JTextField nonmemberNoTF;
	private JTextField nonmemberTimeTF;
	private PcposJFrameMain mainFrame;
	
	public void setMainFrame(PcposJFrameMain mainFrame) {
		this.mainFrame = mainFrame;
	}
	/**
	 * Create the panel.
	 */
	public NonmemberPanel() {
		setBackground(new Color(153, 153, 204));
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 10, 844, 516);
		add(scrollPane);
		
		nonmemberTable = new JTable();
		scrollPane.setViewportView(nonmemberTable);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textField.setColumns(10);
		textField.setBounds(12, 552, 230, 59);
		add(textField);
		
		JButton findByNoB = new JButton("\uAC80\uC0C9");
		findByNoB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		findByNoB.setFont(new Font("³ª´®½ºÄù¾î¶ó¿îµå ExtraBold", Font.PLAIN, 15));
		findByNoB.setBounds(241, 552, 97, 59);
		add(findByNoB);
		
		JButton nonmemberCreateB = new JButton("\uBE44\uD68C\uC6D0\uB4F1\uB85D");
		nonmemberCreateB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		nonmemberCreateB.setFont(new Font("³ª´®½ºÄù¾î¶ó¿îµå ExtraBold", Font.PLAIN, 15));
		nonmemberCreateB.setBounds(422, 551, 157, 59);
		add(nonmemberCreateB);
		
		JButton nonmemberUpdateB = new JButton("\uBE44\uD68C\uC6D0\uC218\uC815");
		nonmemberUpdateB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		nonmemberUpdateB.setFont(new Font("³ª´®½ºÄù¾î¶ó¿îµå ExtraBold", Font.PLAIN, 15));
		nonmemberUpdateB.setBounds(695, 551, 157, 59);
		add(nonmemberUpdateB);
		
		JButton nonmemberDeleteB = new JButton("\uBE44\uD68C\uC6D0\uC0AD\uC81C");
		nonmemberDeleteB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		nonmemberDeleteB.setFont(new Font("³ª´®½ºÄù¾î¶ó¿îµå ExtraBold", Font.PLAIN, 15));
		nonmemberDeleteB.setBounds(1034, 467, 157, 59);
		add(nonmemberDeleteB);
		
		JButton button = new JButton("\u2190");
		button.setFont(new Font("³ª´®½ºÄù¾î¶ó¿îµå ExtraBold", Font.PLAIN, 15));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PcposJFrameMain.getInstance().changePanel("adminMP");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(1114, 570, 77, 41);
		add(button);
		
		nonmemberNoTF = new JTextField();
		nonmemberNoTF.setColumns(10);
		nonmemberNoTF.setBounds(886, 122, 305, 53);
		add(nonmemberNoTF);
		
		nonmemberTimeTF = new JTextField();
		nonmemberTimeTF.setColumns(10);
		nonmemberTimeTF.setBounds(886, 228, 305, 53);
		add(nonmemberTimeTF);

	}

}
