package member;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.demo.dao.CoInfoDAO;
import com.demo.dao.MeInfoDAO;
import com.demo.model.MeInfo;

import java.awt.event.ActionListener;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private MeInfo me;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u7537\u795E\u5CB3\u6BBF\u7C89\u4E1D\u7BA1\u7406\u7CFB\u7EDF");
		label.setBounds(149, 56, 145, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u8BC1\u4EF6\u53F7\u7801\uFF1A");
		label_1.setBounds(64, 109, 85, 15);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(149, 106, 145, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		JLabel label_2 = new JLabel("\u5BC6\u7801\uFF1A");
		label_2.setBounds(92, 145, 74, 15);
		contentPane.add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(149, 142, 145, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		
		JButton button = new JButton("\u6CE8\u518C");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register a=new Register();
				setVisible(false);
				a.setVisible(true);
			}
		});
		button.setBounds(92, 200, 93, 23);
		contentPane.add(button);	

		
		JButton button_1 = new JButton("\u767B\u5F55");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=textField.getText();
				String password=textField_1.getText();
				MeInfoDAO meinfodao = new MeInfoDAO();
				me=meinfodao.findById(id);
				if(me==null)
				{
					JOptionPane.showMessageDialog(null, "ÕËºÅ²»´æÔÚ£¡¸Ï¿ìµã»÷×¢²á¼ÓÈëÄÐÉñ·ÛË¿ÍÅ°É£¡", "", JOptionPane.ERROR_MESSAGE);
				}
				String pa=me.getMemberPassword();
				if(pa.equals(password))
				{
					Fenster fen=new Fenster(id);
					setVisible(false);
					fen.setVisible(true);
				}
				else if(!pa.equals(password)){
					JOptionPane.showMessageDialog(null, "ÃÜÂë´íÎó£¡", "ÃÜÂë´íÎó", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		button_1.setBounds(215, 200, 93, 23);
		contentPane.add(button_1);
	}
}
