package project1.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import project1.member.MemberService;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ScrollPaneConstants;

public class MemberSearch extends JPanel {
   
   private JTextField idTF;
   private JTextField nameTF;
   private PcposJFrameMain mainFrame;
   
   private JTextArea txt;
   public static String id;
   public static int no1;
   
   
   public void setMainFrame(PcposJFrameMain mainFrame) {
      this.mainFrame = mainFrame;
   }
   /**
    * Create the panel.
    */
   
   
   public MemberSearch() {
      MemberFee.memberSearch=MemberSearch.this;
      MemberPay.memberSearch=MemberSearch.this;
      
      setBackground(new Color(255, 255, 255));
      setLayout(null);
      
      JPanel panel = new JPanel();
      panel.setBackground(new Color(153, 204, 255));
      panel.setBounds(72, 85, 488, 510);
      add(panel);
      panel.setLayout(null);
      
      JLabel label_1 = new JLabel("\uC544\uC774\uB514\uB85C \uCC3E\uAE30");
      label_1.setForeground(new Color(0, 0, 102));
      label_1.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 16));
      label_1.setBackground(Color.WHITE);
      label_1.setBounds(51, 133, 158, 23);
      panel.add(label_1);
      
      JLabel label_2 = new JLabel("\uC774\uB984\uC73C\uB85C \uCC3E\uAE30");
      label_2.setForeground(new Color(0, 0, 102));
      label_2.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 16));
      label_2.setBackground(Color.WHITE);
      label_2.setBounds(51, 308, 158, 23);
      panel.add(label_2);
      
      idTF = new JTextField();
      idTF.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 12));
      idTF.setBounds(51, 166, 205, 21);
      panel.add(idTF);
      idTF.setColumns(10);
      
      nameTF = new JTextField();
      nameTF.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 12));
      nameTF.setColumns(10);
      nameTF.setBounds(51, 341, 205, 21);
      panel.add(nameTF);
      txt = new JTextArea();
      txt.setEditable(false);
      txt.addMouseListener(new MouseAdapter() {
      	public void actionPerformed(ActionEvent e) {
      		 String str=idTF.getText();
             try {
                txt.setText(MemberService.getInstance().searchByID(str).getId()+
                      "("+MemberService.getInstance().searchByID(str).getName()+")"+"\n");
                //id = MemberService.getInstance().searchByID(str).getId();
                no1 = MemberService.getInstance().searchByID(str).getNo();
                
             } catch (Exception e1) {
                JOptionPane.showConfirmDialog(null, "일치하는 아이디가 없습니다","경고창", JOptionPane.ERROR_MESSAGE);
                e1.getMessage();
             }	
      		
      	}
      });
      txt.setForeground(Color.BLACK);
      txt.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 19));
      
      
      
      /***********아이디로 찾기*/////////////////
      JButton idsearchB = new JButton("\uAC80\uC0C9");
      idsearchB.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 12));
      idsearchB.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            String str=idTF.getText();
            try {
               txt.setText(MemberService.getInstance().searchByID(str).getId()+
                     "("+MemberService.getInstance().searchByID(str).getName()+")"+"\n");
               //id = MemberService.getInstance().searchByID(str).getId();
               no1 = MemberService.getInstance().searchByID(str).getNo();
               
            } catch (Exception e1) {
               JOptionPane.showConfirmDialog(null, "일치하는 아이디가 없습니다","경고창", JOptionPane.ERROR_MESSAGE);
               e1.getMessage();
            }
         }
      });
      
      
      idsearchB.setBounds(268, 165, 83, 23);
      panel.add(idsearchB);
      
      JButton button = new JButton("\uCD08\uAE30\uD654");
      button.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 12));
      button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            idTF.setText("");                               //초기화버튼
         }
      });
      button.setBounds(368, 165, 83, 23);
      panel.add(button);
      
      JButton namesearchB = new JButton("\uAC80\uC0C9");
      namesearchB.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 12));
      namesearchB.addActionListener(new ActionListener() {
      
    	  /*이름으로 찾기*/
    	  public void actionPerformed(ActionEvent e) {
            String str1=nameTF.getText();
            try {
               txt.setText(MemberService.getInstance().searchByNAME(str1).getId()+
                     "("+MemberService.getInstance().searchByNAME(str1).getName()+")"+"\n");
               
              // no1 = MemberService.getInstance().searchByID(str1).getNo();
            } catch (Exception e1) {
               JOptionPane.showConfirmDialog(null, "일치하는 이름이 없습니다","경고창", JOptionPane.WARNING_MESSAGE);
               e1.getMessage();
               
            }
            
         }
      });
      namesearchB.setBounds(268, 340, 83, 23);
      panel.add(namesearchB);
      
      JButton button_2 = new JButton("\uCD08\uAE30\uD654");
      button_2.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 12));
      button_2.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            nameTF.setText("");                            //초기화버튼
         }
      });
      button_2.setBounds(368, 340, 83, 23);
      panel.add(button_2);
      
      JButton preBT = new JButton("<<\uC774\uC804");  //메인으로 가기
      preBT.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 12));
      preBT.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {  //이전 버튼 안됨.
            try {
            	init();
				PcposJFrameMain.getInstance().changePanel("main");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
         }
      });
      preBT.setBounds(12, 608, 97, 42);
      add(preBT);
      
      JPanel panel_1 = new JPanel();
      panel_1.setBackground(new Color(102, 153, 204));
      panel_1.setBounds(707, 85, 488, 510);
      add(panel_1);
      panel_1.setLayout(null);
      
      JLabel label_3 = new JLabel("\uD68C\uC6D0\uAC80\uC0C9");
      label_3.setForeground(new Color(255, 255, 255));
      label_3.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 18));
      label_3.setHorizontalAlignment(SwingConstants.CENTER);
      label_3.setBackground(Color.WHITE);
      label_3.setBounds(164, 33, 158, 23);
      panel_1.add(label_3);
      

      JScrollPane scrollPane = new JScrollPane();
      scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
      scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
      scrollPane.setBounds(103, 86, 280, 361);
      panel_1.add(scrollPane);
      
      scrollPane.setViewportView(txt);
      txt.setColumns(30);
      
      
      
      
      JButton chargeBT = new JButton("\uC694\uAE08\uCDA9\uC804");      //요금충전 
      chargeBT.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 13));
      chargeBT.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            mainFrame.changePanel("mP");                     //전환 가능
         }
      });
      chargeBT.setBounds(195, 457, 97, 42);
      panel_1.add(chargeBT);
      
      JLabel lblNewLabel = new JLabel("\uD68C\uC6D0");
      lblNewLabel.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 15));
      lblNewLabel.setBounds(12, 10, 38, 23);
      add(lblNewLabel);
      lblNewLabel.setBackground(Color.WHITE);
      
      JLabel label = new JLabel("\uC548\uB155\uD558\uC138\uC694. \uD68C\uC6D0\uC744 \uAC80\uC0C9\uD558\uC138\uC694");
      label.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 15));
      label.setBounds(60, 10, 205, 23);
      add(label);
      label.setBackground(Color.WHITE);
   

   }
   
   public void init() {
	   idTF.setText("");
	   nameTF.setText("");
	   txt.setText("");
   }
}