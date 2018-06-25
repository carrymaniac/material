package cn.gdou.material.frame;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.Font;
import javax.swing.UIManager;

import cn.gdou.material.util.MyFont;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Test extends JFrame {

	JTextField username = new JTextField(20);
	JPasswordField password = new JPasswordField(20);
	JPanel backgroundPanel = null;
	JButton button_minimize, button_close, button_login, button_reset;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test frame = new Test();
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
	public Test() {

		backgroundPanel = new JPanel();
		backgroundPanel.setBackground(UIManager.getColor("Button.background"));
		backgroundPanel.setLayout(null);

		username.setBounds(62, 102, 195, 42);
		username.setFont(MyFont.Static);

		username.setText("账号");

		password.setBounds(62, 154, 195, 42);
		password.setFont(MyFont.Static);

		password.setText("密码");
		password.setEchoChar('\0');

		button_login = new JButton("登录");
		button_login.setBounds(62, 222, 70, 27);
		button_login.setFont(MyFont.Static);

		button_reset = new JButton("重置");
		button_reset.setBounds(187, 222, 70, 27);

		button_reset.setFont(MyFont.Static);

		backgroundPanel.add(username);
		backgroundPanel.add(password);
		backgroundPanel.add(button_login);
		backgroundPanel.add(button_reset);

		getContentPane().add(backgroundPanel);

		JLabel lblNewLabel = new JLabel("\u7528\u6237\u767B\u9646");
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 24));
		lblNewLabel.setBounds(101, 50, 96, 42);
		backgroundPanel.add(lblNewLabel);
		this.setTitle("物资管理系统");
		this.setSize(310, 380);
		this.setVisible(true);
		this.requestFocus();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}
}
