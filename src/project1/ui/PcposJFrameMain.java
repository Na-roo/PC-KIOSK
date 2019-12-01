package project1.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import project1.nonmember.NonMemberService;
import project1.nonmember.Nonmember;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.JTabbedPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class PcposJFrameMain extends JFrame {
	
	public static  Nonmember nonmember;
	public static  int money;		//충전금액
	public static String time;		//충전시간
	public static String memberList;	
	public static String no1;		//회원아이디
	public static int chargeTime;		//충전후시간
	
	public static PcposJFrameMain mainFrame ;
	//참조변수 선언
	JPanel contentPane;
	PcposJFrameMain reset = null;
	
	private NonMemberJPanelMain nonMemberMain;
	private NonMemberJPanel_1 nonMember_1;
	private NonMemberJPanel_2 nonMember_2;
	private NonMemberJPanel_3 nonMember_3;
	private NonMemberJPanel_4 nonMember_4;
	private MemberPay memberPay;
	private MemberSearch memberSearch;
	private MemberFee memberFee;
	private JPanel mainPanel;
	private AdminMainPanel adminMainPanel;
	private AdminPanel adminPanel;
	private MemberPanel memberPanel;
	private NonMemberJPanel_3 nonMP3;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PcposJFrameMain frame = new PcposJFrameMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public static PcposJFrameMain getInstance() throws Exception{
		if (mainFrame==null) {
			mainFrame = new PcposJFrameMain();
		}
		return mainFrame;
	}
	
	
	public PcposJFrameMain() throws Exception {
		setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 12));
		PcposJFrameMain.mainFrame = this;
		setTitle("4\uC870 \uD504\uB85C\uC81D\uD2B8");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		mainPanel = new JPanel();
		mainPanel.setBackground(new Color(255, 255, 255));
		contentPane.add(mainPanel, "main");	
		mainPanel.setLayout(null);
		
		JButton nonMemberB = new JButton("\uBE44\uD68C\uC6D0");
		nonMemberB.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 16));
		nonMemberB.setBounds(336, 176, 160, 130);
		mainPanel.add(nonMemberB);
		
		JButton joinB = new JButton("\uD68C\uC6D0\uAC00\uC785");
		joinB.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 16));
		joinB.setBounds(770, 176, 160, 130);
		mainPanel.add(joinB);
		
		JButton adminB = new JButton("\uAD00\uB9AC\uC790");
		adminB.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 16));
		adminB.setBounds(566, 470, 130, 40);
		mainPanel.add(adminB);
		
		JButton memberB = new JButton("\uD68C\uC6D0");
		memberB.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 16));
		memberB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changePanel("mS");
			}
		});
		memberB.setBounds(554, 176, 160, 130);
		mainPanel.add(memberB);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(PcposJFrameMain.class.getResource("/project1/ui/20161226105805_0f052.jpg")));
		lblNewLabel.setBounds(0, 0, 1254, 671);
		mainPanel.add(lblNewLabel);
		adminB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			changePanel("adminMP");
			}
		});
		joinB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MemberLoginDilog memberLoginDialog = 
							new MemberLoginDilog();
					memberLoginDialog.setMainFrame(PcposJFrameMain.this);
					memberLoginDialog.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		
		nonMemberB.addActionListener(new ActionListener(){		//비회원 버튼
			public void actionPerformed(ActionEvent e) {
				changePanel("m1");
				try {
					
				} catch (Exception e2) {
					
				}
			}
		});
		
		NonMemberJPanel_1 nonMP1 = new NonMemberJPanel_1();
		nonMP1.setMainFrame(PcposJFrameMain.this);			//호출 할 수 있게 전달
		contentPane.add(nonMP1, "m1");
		
		JButton preBT = new JButton("<<\uC774\uC804");
		preBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl=(CardLayout)contentPane.getLayout();
				 cl.previous(contentPane);
			}
		});
		preBT.setBounds(12, 608, 97, 42);
		nonMP1.add(preBT);
		
		NonMemberJPanel_2 nonMP2 = new NonMemberJPanel_2();
		nonMP2.setNonMember3(nonMP3);
		nonMP2.setMainFrame(PcposJFrameMain.this);
		contentPane.add(nonMP2, "m2");
		
		JButton preBT1 = new JButton("<<\uC774\uC804");
		preBT1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl=(CardLayout)contentPane.getLayout();
				 cl.previous(contentPane);
			}
		});
		preBT1.setBounds(12, 608, 97, 42);
		nonMP2.add(preBT1);
		
		
		 nonMP3 = new NonMemberJPanel_3();
		nonMP3.setMainFrame(PcposJFrameMain.this);
		contentPane.add(nonMP3, "m3");
		
		JButton preBT2 = new JButton("<<\uC774\uC804");
		preBT2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c1 = (CardLayout)contentPane.getLayout();
				c1.previous(contentPane);
			}
		});
		preBT2.setBounds(12, 608, 97, 42);
		nonMP3.add(preBT2);
		
		NonMemberJPanel_4 nonMp4 = new NonMemberJPanel_4();
		nonMp4.setMainFrame(PcposJFrameMain.this);
		contentPane.add(nonMp4, "m4");
		
		JButton btnNewButton = new JButton("<<\uC774\uC804");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c1 = (CardLayout)contentPane.getLayout();
				c1.previous(contentPane);
			}
		});
		btnNewButton.setBounds(12, 608, 97, 42);
		nonMp4.add(btnNewButton);
		
		MemberSearch member1 = new MemberSearch();
		member1.setMainFrame(PcposJFrameMain.this);
		contentPane.add(member1, "mS");
		
		MemberPay member2 = new MemberPay();
		member2.setMainFrame(PcposJFrameMain.this);
		contentPane.add(member2, "mP");
		
		MemberFee member3 = new MemberFee();
		member3.setMainFrame(PcposJFrameMain.this);
		contentPane.add(member3, "mF");
		
		AdminMainPanel adminMainPanel = new AdminMainPanel();
		adminMainPanel.setMainFrame(PcposJFrameMain.this);
		contentPane.add(adminMainPanel, "adminMP");
		
		AdminPanel adminPanel = new AdminPanel();
		adminPanel.setMainFrame(PcposJFrameMain.this);
		contentPane.add(adminPanel, "adminP");
		
		MemberPanel memberPanel = new MemberPanel();
		memberPanel.setMainFrame(PcposJFrameMain.this);
		contentPane.add(memberPanel, "adminM");
		
		NonmemberPanel nonmemberPanel = new NonmemberPanel();
		nonmemberPanel.setMainFrame(PcposJFrameMain.this);
		contentPane.add(nonmemberPanel, "adminNM");
		
		ProductPanel productPanel = new ProductPanel();
		productPanel.setMainFrame(PcposJFrameMain.this);
		contentPane.add(productPanel, "adminPd");
		changePanel("main");
	}
	
	public void changePanel(String panelName) {
		CardLayout cl=(CardLayout)contentPane.getLayout();
		cl.show(contentPane, panelName);
	}
}
	