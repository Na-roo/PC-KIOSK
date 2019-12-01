package project1.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import project1.member.Member;
import project1.member.MemberService;

public class MemberLoginDilog extends JDialog {

   private final JPanel isValidB = new JPanel();
   private JTextField idTF;
   private JTextField passTF;
   private JTextField passTF1;
   private JTextField nameTF;
   private JTextField ageTF;
   private JTextField conTF;

   // Frame 참조변수 선언
   PcposJFrameMain mainFrame;
   private MemberService memberService;

   public void setMainFrame(PcposJFrameMain mainFrame) {
      this.mainFrame = mainFrame;
   }

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      try {
         MemberLoginDilog dialog = new MemberLoginDilog();
         dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
         dialog.setVisible(true);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   /**
    * Create the dialog.
    */
   public MemberLoginDilog() throws Exception {
	   memberService=new MemberService();
      setBounds(100, 100, 700, 700);
      getContentPane().setLayout(new BorderLayout());
      isValidB.setBorder(new EmptyBorder(5, 5, 5, 5));
      getContentPane().add(isValidB, BorderLayout.CENTER);
      isValidB.setLayout(null);
      {
         JLabel label = new JLabel("\uD68C\uC6D0\uAC00\uC785");
         label.setBounds(272, 25, 57, 15);
         isValidB.add(label);
      }
      {
         JLabel idLB = new JLabel("ID");
         idLB.setBounds(133, 74, 57, 15);
         isValidB.add(idLB);
      }
      {
         JLabel lblPassword = new JLabel("PASSWORD");
         lblPassword.setBounds(133, 166, 107, 15);
         isValidB.add(lblPassword);
      }
      {
         JLabel lblPassword_1 = new JLabel("PASSWORD  \uD655\uC778");
         lblPassword_1.setBounds(133, 258, 107, 15);
         isValidB.add(lblPassword_1);
      }
      {
         JLabel label = new JLabel("\uC774\uB984");
         label.setBounds(133, 350, 57, 15);
         isValidB.add(label);
      }
      {
         JLabel label = new JLabel("\uC0DD\uB144\uC6D4\uC77C");
         label.setBounds(133, 442, 57, 15);
         isValidB.add(label);
      }
      {
         JLabel label = new JLabel("\uC5F0\uB77D\uCC98");
         label.setBounds(133, 534, 57, 15);
         isValidB.add(label);
      }
      {
         idTF = new JTextField();
         idTF.setBounds(332, 74, 116, 21);
         isValidB.add(idTF);
         idTF.setColumns(10);
      }
      {
         passTF = new JTextField();
         passTF.setColumns(10);
         passTF.setBounds(332, 163, 116, 21);
         isValidB.add(passTF);
      }
      {
         passTF1 = new JTextField();
         passTF1.setColumns(10);
         passTF1.setBounds(332, 255, 116, 21);
         isValidB.add(passTF1);

      }
      {
         nameTF = new JTextField();
         nameTF.setColumns(10);
         nameTF.setBounds(332, 347, 116, 21);
         isValidB.add(nameTF);
      }
      {
         ageTF = new JTextField();
         ageTF.setColumns(10);
         ageTF.setBounds(332, 439, 116, 21);
         isValidB.add(ageTF);
      }
      {
         conTF = new JTextField();
         conTF.setColumns(10);
         conTF.setBounds(332, 531, 116, 21);
         isValidB.add(conTF);
      }

      
      
      JButton btnNewButton = new JButton("\uC911\uBCF5\uCCB4\uD06C");
      btnNewButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	
				try {
					String idStr = idTF.getText();
					boolean isSuccess=
							memberService.idIsValid(idStr);
					if(idStr.equals("")) {
					JOptionPane.showMessageDialog(null, "아이디를 입력하세요");
					}else {
					
					if(isSuccess) {
						JOptionPane.showMessageDialog(null, "아이디가 중복되었습니다");
						
					}else {
						JOptionPane.showMessageDialog(null, "가입이 가능 합니다. ");
						idTF.requestFocus();
						idTF.setSelectionStart(0);
						idTF.setSelectionEnd(idStr.length());
						return;
					}
				}
				}catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.getMessage();
				}

         }
//            try {
//               if(MemberService.idIsValid(idTF.getText())) {
//                  JOptionPane.showConfirmDialog(null, "사용할 수 있는 아이디입니다","알림", JOptionPane.PLAIN_MESSAGE);
//               }
//                  
//            } catch (Exception e1) {
//               // TODO Auto-generated catch block
//               e1.getMessage();            }
//            JOptionPane.showConfirmDialog(null, "사용할 수 없는 아이디입니다","알림", JOptionPane.PLAIN_MESSAGE);
//         }
      });
      btnNewButton.setBounds(477, 73, 107, 23);
      isValidB.add(btnNewButton);
      {
         JPanel buttonPane = new JPanel();
         buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
         getContentPane().add(buttonPane, BorderLayout.SOUTH);
         {
            JButton okButton = new JButton("\uAC00\uC785"); // 확인
            okButton.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e) {

                  int no = 0;
                  String id = idTF.getText();
                  String password = passTF.getText();
                  String password1 = passTF1.getText();
                  String name = nameTF.getText();
                  String birth = ageTF.getText();
                  String telNum = conTF.getText();
                  int rTime = 0;
                  int cTime = 0;

                  	                  
						try {
							project1.member.MemberService.getInstance()
									.registerMember(new Member(no, id, password1, name, birth, telNum, rTime, cTime));

							mainFrame.changePanel("main");
							JOptionPane.showMessageDialog(null, "가입이 완료 되었습니다.", "안내", JOptionPane.INFORMATION_MESSAGE);
							dispose();

						} catch (Exception e2) {
							// TODO: handle exception
						}

					}
				});
            okButton.setActionCommand("OK");
            buttonPane.add(okButton);
            getRootPane().setDefaultButton(okButton);
         }
         {
            JButton cancelButton = new JButton("\uCDE8\uC18C"); // 취소
            cancelButton.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e) {
                  dispose();
               }
            });
            cancelButton.setActionCommand("Cancel");
            buttonPane.add(cancelButton);
         }
      }
   }
}