package member;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.demo.dao.MeInfoDAO;
import com.demo.factory.HibernateSessionFactory;
import com.demo.model.MeInfo;

public class Fenster extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	protected static String memberNumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fenster frame = new Fenster(memberNumber);
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
	public Fenster(final String memberNumber) {
		final MeInfoDAO medao=new MeInfoDAO();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 709, 479);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 0, 673, 440);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 0, 653, 430);
		panel.add(tabbedPane);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("修改会员信息", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel label = new JLabel("\u8BC1\u4EF6\u53F7\u7801\uFF1A");
		label.setBounds(164, 74, 76, 15);
		panel_2.add(label);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(244, 74, 159, 15);
		panel_2.add(lblNewLabel);
		lblNewLabel.setText(memberNumber);
		
		JLabel label_1 = new JLabel("\u7C89\u4E1D\u59D3\u540D\uFF1A");
		label_1.setBounds(164, 115, 76, 15);
		panel_2.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(244, 112, 84, 21);
		panel_2.add(textField);
		textField.setColumns(10);
		
		
		JLabel label_2 = new JLabel("\u8054\u7CFB\u65B9\u5F0F\uFF1A");
		label_2.setBounds(164, 161, 76, 15);
		panel_2.add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(244, 158, 131, 21);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		
		JLabel label_3 = new JLabel("\u5F53\u524D\u79EF\u5206\uFF1A");
		label_3.setBounds(164, 208, 76, 15);
		panel_2.add(label_3);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(244, 208, 84, 15);
		panel_2.add(lblNewLabel_1);
		int memco=medao.findById(memberNumber).getMemberCost();
		String memcost=String.valueOf(memco);
		lblNewLabel_1.setText(memcost);
		
		JButton button = new JButton("\u786E\u8BA4\u4FEE\u6539");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MeInfo meinfo=medao.findById(memberNumber);
				MeInfo temp = new MeInfo();
				temp.setMemberNumber(memberNumber);
				temp.setMemberName(textField.getText());
				temp.setMemberCost(meinfo.getMemberCost());
				temp.setMemberPassword(meinfo.getMemberPassword());
				temp.setMemberPhoneNumber(textField_1.getText());
				temp.setVipNum(meinfo.getVipNum());
				Session session=HibernateSessionFactory.getSession();
				Transaction transaction = session.beginTransaction();
				MeInfoDAO meInfoDAO = new MeInfoDAO();
				meInfoDAO.delete(meinfo);
				meInfoDAO.save(temp);
				transaction.commit();
				session.flush();				
				JOptionPane.showMessageDialog(null, "修改成功", "修改成功", JOptionPane.ERROR_MESSAGE);
				
			}
		});
		button.setBounds(212, 266, 93, 23);
		panel_2.add(button);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("修改登录密码", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel label_4 = new JLabel("\u539F\u5BC6\u7801\uFF1A");
		label_4.setBounds(170, 98, 54, 15);
		panel_3.add(label_4);
		
		textField_2 = new JTextField();
		textField_2.setBounds(223, 95, 154, 21);
		panel_3.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_5 = new JLabel("\u65B0\u5BC6\u7801\uFF1A");
		label_5.setBounds(170, 139, 54, 15);
		panel_3.add(label_5);
		
		textField_3 = new JTextField();
		textField_3.setBounds(223, 136, 154, 21);
		panel_3.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label_6 = new JLabel("\u786E\u8BA4\u65B0\u5BC6\u7801\uFF1A");
		label_6.setBounds(146, 179, 81, 15);
		panel_3.add(label_6);
		
		textField_4 = new JTextField();
		textField_4.setBounds(223, 176, 154, 21);
		panel_3.add(textField_4);
		textField_4.setColumns(10);
		
		JButton button_1 = new JButton("\u786E\u8BA4\u4FEE\u6539");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String oldpass=textField_2.getText();
				String newpass=textField_3.getText();
				String renewpass=textField_4.getText();
				String op=medao.findById(memberNumber).getMemberPassword();
				if(op.equals(oldpass))
				{
					if(newpass.equals(renewpass)){
						MeInfo meinfo=medao.findById(memberNumber);
						MeInfo temp = new MeInfo();
						temp.setMemberNumber(memberNumber);
						temp.setMemberName(meinfo.getMemberPhoneNumber());
						temp.setMemberCost(meinfo.getMemberCost());
						temp.setMemberPassword(textField_3.getText());
						temp.setMemberPhoneNumber(meinfo.getMemberPhoneNumber());
						temp.setVipNum(meinfo.getVipNum());
						Session session=HibernateSessionFactory.getSession();
						Transaction transaction = session.beginTransaction();
						MeInfoDAO meInfoDAO = new MeInfoDAO();
						meInfoDAO.delete(meinfo);
						meInfoDAO.save(temp);
						transaction.commit();
						session.flush();
						JOptionPane.showMessageDialog(null, "修改成功", "", JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "两次新密码输入的不同", "", JOptionPane.ERROR_MESSAGE);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "原密码输入错误", "", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		button_1.setBounds(223, 251, 93, 23);
		panel_3.add(button_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setToolTipText("");
		tabbedPane.addTab("粉丝消费", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel label_7 = new JLabel("\u8D2D\u4E70\u4E13\u8F91\u6570\uFF1A");
		label_7.setBounds(164, 107, 84, 15);
		panel_1.add(label_7);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(258, 104, 84, 21);
		panel_1.add(comboBox);
		comboBox.addItem("1");
		comboBox.addItem("2");
		comboBox.addItem("3");
		comboBox.addItem("4");
		comboBox.addItem("5");
		
		
		JLabel label_8 = new JLabel("\u8D2D\u4E70\u5199\u771F\u96C6\u6570\uFF1A");
		label_8.setBounds(152, 161, 84, 15);
		panel_1.add(label_8);
		
		final JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(258, 158, 84, 21);
		panel_1.add(comboBox_1);
		comboBox_1.addItem("1");
		comboBox_1.addItem("2");
		comboBox_1.addItem("3");
		comboBox_1.addItem("4");
		comboBox_1.addItem("5");
		
		JButton button_4 = new JButton("\u663E\u793A\u53EF\u7D2F\u8BA1\u79EF\u5206");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ac=Integer.parseInt(comboBox.getSelectedItem().toString())*100;
				int bc=Integer.parseInt(comboBox_1.getSelectedItem().toString())*10;
				int cc=ac+bc;
				String dc=String.valueOf(cc);
				textField_5.setText(dc);
			}
		});
		button_4.setBounds(99, 222, 134, 23);
		panel_1.add(button_4);
		
		JButton button_3 = new JButton("\u786E\u8BA4\u6D88\u8D39");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ac=Integer.parseInt(comboBox.getSelectedItem().toString())*100;
				int bc=Integer.parseInt(comboBox_1.getSelectedItem().toString())*10;
				int cc=ac+bc;
				MeInfo meinfo=medao.findById(memberNumber);
				int nowcost=meinfo.getMemberCost();
				nowcost=nowcost+cc;
				meinfo.setMemberCost(nowcost);
				Session session=HibernateSessionFactory.getSession();
				Transaction transaction = session.beginTransaction();
				transaction.commit();
				session.flush();
				JOptionPane.showMessageDialog(null, "积分成功！离男神又近了一步！", "", JOptionPane.ERROR_MESSAGE);
			}
		});
		button_3.setBounds(196, 291, 93, 23);
		panel_1.add(button_3);
		
		textField_5 = new JTextField();
		textField_5.setBounds(258, 223, 84, 21);
		panel_1.add(textField_5);
		textField_5.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("退出粉丝部落", null, panel_4, null);
		panel_4.setLayout(null);
		
		JButton button_2 = new JButton("\u9000\u51FA\u7537\u795E\u7C89\u4E1D\u90E8\u843D");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MeInfo meinfo=medao.findById(memberNumber);
				Session session=HibernateSessionFactory.getSession();
				Transaction transaction = session.beginTransaction();
				MeInfoDAO meInfoDAO = new MeInfoDAO();
				meInfoDAO.delete(meinfo);
				transaction.commit();
				session.flush();
				System.exit(0);
			}
		});
		button_2.setBounds(358, 119, 197, 126);
		panel_4.add(button_2);
		
		JButton btnNewButton = new JButton("\u9000\u51FA\u7CFB\u7EDF");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton.setBounds(91, 119, 197, 126);
		panel_4.add(btnNewButton);
	}
}
