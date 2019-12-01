package project1.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import project1.member.Member;
import project1.member.MemberService;

public class MemberPanel extends JPanel {
	private JTextField findnameTF;
	private JTable memberTable;
	private JTextField memberIdTF;
	private JTextField memberNameTF;
	private JTextField memberTimeTF;
    private PcposJFrameMain mainFrame;
    
    MemberService memberService;
    private Vector columnNames;
    private DefaultTableModel tableModel;
	
	public void setMainFrame(PcposJFrameMain mainFrame) {
		this.mainFrame = mainFrame;
	}
	/**
	 * Create the panel.
	 */
	public MemberPanel() {
		
		try {
	         memberService=new MemberService();					
	      } catch (Exception e2) {
	         // TODO Auto-generated catch block
	         e2.printStackTrace();
	      }
	      addComponentListener(new ComponentAdapter() {
	         @Override
	         public void componentHidden(ComponentEvent e) {
	            init();
	         }
	         public void componentShown(ComponentEvent e) {
	            try {
	            	memberListTable();
	            } catch (Exception e1) {
	               // TODO Auto-generated catch block
	               e1.printStackTrace();
	            }
	         }
	      });
		
		setBackground(new Color(204, 255, 153));
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(12, 10, 844, 516);
		add(scrollPane);
		
		memberTable = new JTable();
		memberTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow=memberTable.getSelectedRow();
				int selectedColumn=memberTable.getSelectedColumn();
				int selectedNo =(Integer)memberTable.getValueAt(selectedRow,0);
				System.out.println("selected No: "+selectedNo);
				
				Member member;
				
				try {
					member=memberService.searchByNo(selectedNo);
					
					memberIdTF.setText(member.getId());
					memberNameTF.setText(member.getName());
					memberTimeTF.setText(member.getrTime()+"");
					
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		
		columnNames=new Vector();
		columnNames.add("번호");
		columnNames.add("이름");
		columnNames.add("아이디");
		columnNames.add("PW");
		columnNames.add("생년월일");
		columnNames.add("전화번호");
		tableModel=new DefaultTableModel(columnNames, 0);
		memberTable.setModel(tableModel);

		scrollPane.setViewportView(memberTable);
		
		//검색버튼 구간
		findnameTF = new JTextField();
		findnameTF.setColumns(10);
		findnameTF.setBounds(12, 558, 230, 59);
		add(findnameTF);
		
		
		JButton findByNameB = new JButton("\uAC80\uC0C9");
		findByNameB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Member> memberList;
				try {
					
					memberList=memberService.searchByString(findnameTF.getText());
					Vector data=new Vector();
					
					for(Member member:memberList) {
						Vector rowVector=new Vector();
						rowVector.add(member.getNo());
						rowVector.add(member.getName());			
						rowVector.add(member.getId());				
						rowVector.add(member.getPassword());				
						rowVector.add(member.getBirth());
						rowVector.add(member.getTelNum());
						data.add(rowVector);		
						
					tableModel=new DefaultTableModel(data, columnNames);
					memberTable.setModel(tableModel);
						
					if (findnameTF.getText()==null) {
						init();
					}
				}
					tableModel=new DefaultTableModel(data, columnNames);
					memberTable.setModel(tableModel);	
	
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		findByNameB.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 15));
		findByNameB.setBounds(241, 557, 97, 59);
		add(findByNameB);
		

		
		JButton memberCreateB = new JButton("회원등록");
		memberCreateB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberCreateDialog memberCreateDialog;
				try {
					memberCreateDialog = new MemberCreateDialog();
					memberCreateDialog.memberPanel=MemberPanel.this;
					memberCreateDialog.setModal(true);
					memberCreateDialog.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
		memberCreateB.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 15));
		memberCreateB.setBounds(422, 556, 157, 59);
		add(memberCreateB);
		
		JButton memberUpdateB = new JButton("회원수정");
		memberUpdateB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MemberUpdateDialog memberUpdateDialog = new MemberUpdateDialog();
					int selectedRow = memberTable.getSelectedRow();
					Member updateMember;
					updateMember = memberService.searchByNo((Integer)memberTable.getValueAt(selectedRow,0));
					memberUpdateDialog.setUpdateMember(updateMember); 
					memberUpdateDialog.memberPanel=MemberPanel.this;
					memberUpdateDialog.setModal(true);
					memberUpdateDialog.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		memberUpdateB.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 15));
		memberUpdateB.setBounds(695, 556, 157, 59);
		add(memberUpdateB);
		
		//삭제
		JButton memberDeleteB = new JButton("회원삭제");
		memberDeleteB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String findIdStr=memberIdTF.getText();
				if (findIdStr.equals("")) {
					return;
				}
				try {
					memberService.deleteMember(findIdStr);
					memberIdTF.setText("");
					memberNameTF.setText("");
					memberTimeTF.setText("");
					memberListTable();
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		memberDeleteB.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 15));
		memberDeleteB.setBounds(1042, 467, 157, 59);
		add(memberDeleteB);
		
		JButton button = new JButton("\u2190");
		button.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 15));
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
		button.setBounds(1122, 567, 77, 41);
		add(button);
		
		memberIdTF = new JTextField();
		memberIdTF.setColumns(10);
		memberIdTF.setBounds(894, 77, 305, 53);
		add(memberIdTF);
		
		memberNameTF = new JTextField();
		memberNameTF.setColumns(10);
		memberNameTF.setBounds(894, 183, 305, 53);
		add(memberNameTF);
		
		memberTimeTF = new JTextField();
		memberTimeTF.setColumns(10);
		memberTimeTF.setBounds(894, 287, 305, 53);
		add(memberTimeTF);
	}
	
	public void init() {
		tableModel=new DefaultTableModel(columnNames, 0);
		memberTable.setModel(tableModel);
	}
	
	
	public void memberListTable() throws Exception {
		ArrayList<Member> memberList=memberService.findAllMember();
		
		Vector data=new Vector();
		
		for (Member member:memberList) {
			Vector rowVector=new Vector();
			rowVector.add(member.getNo());
			rowVector.add(member.getName());			
			rowVector.add(member.getId());				
			rowVector.add(member.getPassword());				
			rowVector.add(member.getBirth());		
			rowVector.add(member.getTelNum());
			data.add(rowVector);
		}
	
		
		tableModel=new DefaultTableModel(data, columnNames);
		memberTable.setModel(tableModel);
	}

}
