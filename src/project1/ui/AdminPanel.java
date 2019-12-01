package project1.ui;

import java.awt.Font;
import java.awt.SystemColor;
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

import project1.admin.Admin;
import project1.admin.AdminService;

public class AdminPanel extends JPanel {
	private JTextField findIdTF;
	private JTable adminTable;
	private JTextField adminnoTF;
	private JTextField adminnameTF;
	private JTextField idTF;
	private PcposJFrameMain mainFrame;
	
	AdminService adminService;
	//테이블에 각 양식에 맞는 머리말 붙여주려고 선언한거같음.......vector 타입 columnNames메소드
	private Vector columnNames;
	//출력된 배열들을 테이블 기본값 DefaultTableModel 선언함
	private DefaultTableModel tableModel;
	
	public void setMainFrame(PcposJFrameMain mainFrame) {
		this.mainFrame = mainFrame;
	}

	/**
	 * Create the panel.
	 */
	public AdminPanel() {
		//아까 들은 설명으론 직원관리 접속했을시 항상 직원의 목록을 접속시 테이블에 노출하도록 하는 명령.......
		try {
	         adminService=new AdminService();					
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
	            	adminListTable();
	            } catch (Exception e1) {
	               // TODO Auto-generated catch block
	               e1.printStackTrace();
	            }
	         }
	      });  
		
		setBackground(SystemColor.info);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(12, 10, 844, 516);
		add(scrollPane);
		
		adminTable = new JTable();
		//adminTable에 불려진 각 데이터행에 마우스 클릭시 상세정보 보려고 만든 이벤트
		//솔직히 마우스이벤트 여기 아예 하나도 모르겠음
		adminTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow=adminTable.getSelectedRow();
				int selectedColumn=adminTable.getSelectedColumn();
				int selectedNo=(Integer)adminTable.getValueAt(selectedRow, 0);
				System.out.println("selected No: "+selectedNo);
				
				Admin admin;
				
				try {
					admin=adminService.findByNo(selectedNo);
					
					adminnoTF.setText(admin.getNo()+"");
					adminnameTF.setText(admin.getName());
					idTF.setText(admin.getId());
					
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		
		
		//직원리스트 테이블에 양식머리말붙여주려고 선언해줌, 데이터 대입하려고 빈객체생성후 add함수 이용하여 데이터대입
		columnNames=new Vector();
		columnNames.add("번호");
		columnNames.add("이름");
		columnNames.add("ID");
		columnNames.add("PW");
		columnNames.add("전화번호");
		columnNames.add("직급");
		tableModel=new DefaultTableModel(columnNames, 0);
		adminTable.setModel(tableModel);
		
		
		scrollPane.setViewportView(adminTable);
		
		
		//검색 버튼 구간
		findIdTF = new JTextField();
		findIdTF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		findIdTF.setColumns(10);
		findIdTF.setBounds(12, 560, 230, 59);
		add(findIdTF);
		
		
		JButton findByNameB = new JButton("\uAC80\uC0C9");
		findByNameB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Admin> adminList;
				try {
					adminList=adminService.findByName(findIdTF.getText());
					
					//for문으로 가져온 항목들을 하나로 합친 데이터들을 저장하기 위해 Vector타입의 data 변수 선언 = new Vector(); 빈객체생성
					Vector data=new Vector();
					
					//상품리스트에 각 항목의 데이터들이 저장될 Vector타입의 rowVector변수 선언 = new Vector(); 빈객체생성
					for(Admin admin:adminList) {
						Vector rowVector=new Vector();
						rowVector.add(admin.getNo());				//직원번호
						rowVector.add(admin.getName());				//직원이름
						rowVector.add(admin.getId());				//직원아이디
						rowVector.add(admin.getPassword());			//직원비밀번호
						rowVector.add(admin.getPhoneNo());			//직원전화번호
						rowVector.add(admin.getPosition());			//직원직급
						//for문으로 생성된 위 데이터들이 Vector 타입의 data변수에 대입
						data.add(rowVector);					
						
					if (findIdTF.getText()==null) {
						init();
					}
					}
						
					tableModel=new DefaultTableModel(data, columnNames);
					adminTable.setModel(tableModel);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		findByNameB.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 15));
		findByNameB.setBounds(241, 560, 97, 59);
		add(findByNameB);
		
		JButton adminCreateB = new JButton("직원등록");
		adminCreateB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminCreateDialog adminCreateDialog;
				try {
					adminCreateDialog = new AdminCreateDialog();
					adminCreateDialog.adminPanel=AdminPanel.this;
					adminCreateDialog.setModal(true);
					adminCreateDialog.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
		
		adminCreateB.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 15));
		adminCreateB.setBounds(429, 560, 157, 59);
		add(adminCreateB);
		
		JButton adminUpdateB = new JButton("직원수정");
		adminUpdateB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AdminUpdateDialog adminUpdateDialog = new AdminUpdateDialog();
					int selectedRow = adminTable.getSelectedRow();
					Admin updateAdmin;
					updateAdmin = adminService.findByNo((Integer)adminTable.getValueAt(selectedRow,0));
					adminUpdateDialog.setUpdateAdmin(updateAdmin); 
					adminUpdateDialog.adminPanel=AdminPanel.this;
					adminUpdateDialog.setModal(true);
					adminUpdateDialog.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
			}
		});
		adminUpdateB.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 15));
		adminUpdateB.setBounds(652, 560, 157, 59);
		add(adminUpdateB);
		
		//삭제
		JButton adminDeleteB = new JButton("직원삭제");
		adminDeleteB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String findnameStr=adminnameTF.getText();
				if (findnameStr.equals("")) {
					return;
				}
				try {
					adminService.deleteAdmin(findnameStr);
					adminnoTF.setText("");
					adminnameTF.setText("");
					idTF.setText("");
					adminListTable();
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		
		
		adminDeleteB.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 15));
		adminDeleteB.setBounds(1039, 467, 157, 59);
		add(adminDeleteB);
		
		JButton backB = new JButton("\u2190");
		backB.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 15));
		backB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PcposJFrameMain.getInstance().changePanel("adminMP");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		backB.setBounds(1119, 569, 77, 41);
		add(backB);
		
		adminnoTF = new JTextField();
		adminnoTF.setFont(new Font("나눔고딕코딩", Font.BOLD, 20));
		adminnoTF.setBounds(891, 74, 305, 53);
		add(adminnoTF);
		adminnoTF.setColumns(10);
		
		adminnameTF = new JTextField();
		adminnameTF.setFont(new Font("나눔고딕코딩", Font.BOLD, 20));
		adminnameTF.setColumns(10);
		adminnameTF.setBounds(891, 180, 305, 53);
		add(adminnameTF);
		
		idTF = new JTextField();
		idTF.setFont(new Font("나눔고딕코딩", Font.BOLD, 20));
		idTF.setColumns(10);
		idTF.setBounds(891, 284, 305, 53);
		add(idTF);
	}
	
	
	
	//불러올 admin의 데이터들을 불러올때마다 테이블에 저장하기 위해서는 공간이 필요하기때문에 init 메소드 선언
	public void init() {
		tableModel=new DefaultTableModel(columnNames, 0);
		adminTable.setModel(tableModel);
	}
	
	
	//상품테이블에 데이터 추가할 메소드
	//예외 발생시 해당 메소드에서 해결하라고 예외처리
	public void adminListTable() throws Exception {
		ArrayList<Admin> adminList=adminService.findAllAdmin();
		
		//for문으로 가져온 항목들을 하나로 합친 데이터들을 저장하기 위해 Vector타입의 data 변수 선언 = new Vector(); 빈객체생성
		Vector data=new Vector();
		
		for (Admin admin:adminList) {
			//상품리스트에 각 항목의 데이터들이 저장될 Vector타입의 rowVector변수 선언 = new Vector(); 빈객체생성
			Vector rowVector=new Vector();
			rowVector.add(admin.getNo());				//직원번호
			rowVector.add(admin.getName());				//직원이름
			rowVector.add(admin.getId());				//직원아이디
			rowVector.add(admin.getPassword());			//직원비밀번호
			rowVector.add(admin.getPhoneNo());			//직원전화번호
			rowVector.add(admin.getPosition());			//직원직급
			//for문으로 생성된 위 데이터들이 Vector 타입의 data변수에 대입
			data.add(rowVector);
		}
		
		//위 for문으로 얻은 데이터들을 인자값과 테이블에 넣어주기위해 data와 columnNames를 인자로 대입
		//인자를 받고 주소값이 생기는 데이터들은 tableModel에 대입된다
		tableModel=new DefaultTableModel(data, columnNames);
		adminTable.setModel(tableModel);
	}
}






