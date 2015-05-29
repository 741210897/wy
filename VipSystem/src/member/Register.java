package member;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.demo.dao.MeInfoDAO;
import com.demo.factory.HibernateSessionFactory;
import com.demo.model.MeInfo;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Register() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 328);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u6CE8\u518C\u65B0\u4F1A\u5458");
		label.setBounds(10, 10, 84, 15);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("\u8BC1\u4EF6\u53F7\u7801\uFF1A");
		lblNewLabel.setBounds(73, 48, 75, 15);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(134, 45, 155, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		JLabel label_1 = new JLabel("\u767B\u9646\u5BC6\u7801\uFF1A");
		label_1.setBounds(73, 77, 75, 15);
		contentPane.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(134, 74, 155, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		
		JLabel label_2 = new JLabel("\u4F1A\u5458\u59D3\u540D\uFF1A");
		label_2.setBounds(73, 105, 75, 15);
		contentPane.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(134, 102, 155, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_3 = new JLabel("\u624B\u673A\u53F7\u7801\uFF1A");
		label_3.setBounds(73, 136, 75, 15);
		contentPane.add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(134, 133, 155, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label_4 = new JLabel("\u4F1A\u5458\u53F7\u7801\uFF1A");
		label_4.setBounds(73, 167, 65, 15);
		contentPane.add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(134, 164, 155, 21);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton button = new JButton("\u786E\u8BA4\u6CE8\u518C");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MeInfo regi=new MeInfo();
				String a_0=textField.getText();
				regi.setMemberNumber(a_0);
				String a_1=textField_1.getText();
				regi.setMemberPassword(a_1);
				String a_2=textField_2.getText();
				regi.setMemberName(a_2);
				String a_3=textField_3.getText();
				regi.setMemberPhoneNumber(a_3);
				String a_4=textField_4.getText();
				regi.setVipNum(a_4);
				regi.setMemberCost(0);
//				//MeInfo meinfo=medao.findById(memberNumber);
//				MeInfo temp = new MeInfo();
//				temp.setMemberNumber(a_0);
//				temp.setMemberName(meinfo.getMemberPhoneNumber());
//				temp.setMemberCost(meinfo.getMemberCost());
//				temp.setMemberPassword(textField_3.getText());
//				temp.setMemberPhoneNumber(meinfo.getMemberPhoneNumber());
//				temp.setVipNum(meinfo.getVipNum());
				Session session=HibernateSessionFactory.getSession();
				Transaction transaction = session.beginTransaction();
				MeInfoDAO meInfoDAO = new MeInfoDAO();
				meInfoDAO.save(regi);
				transaction.commit();
				session.flush();	
				JOptionPane.showMessageDialog(null, "注册成功！现已加入月饼军团！", "注册成功", JOptionPane.ERROR_MESSAGE);
				Login a=new Login();
				setVisible(false);
				a.setVisible(true);
			}
		});
		button.setBounds(140, 223, 93, 23);
		contentPane.add(button);
	}
}
