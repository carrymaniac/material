package cn.gdou.material.frame;


import java.awt.Font;
import java.awt.Image;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

import cn.gdou.material.entity.User;
import cn.gdou.material.factory.ServiceFactory;
import cn.gdou.material.util.MD5Code;
import cn.gdou.material.util.MyFont;

@SuppressWarnings("serial")
public class LoginJFrame extends JFrame implements MouseListener, FocusListener{
	

	
	// ����ȫ�����
	JTextField id = new JTextField(20);
	JPasswordField password = new JPasswordField(20);
	JPanel  backgroundPanel = null;
	JButton button_minimize, button_close, button_login, button_reset;
	
	public LoginJFrame() {
		try {
			Image imgae = ImageIO.read(new File("image/logo.png"));
			this.setIconImage(imgae);
		} catch (IOException e) {
			e.printStackTrace();
		}
		backgroundPanel = new JPanel();
		backgroundPanel.setBackground(UIManager.getColor("Button.background"));
		backgroundPanel.setLayout(null);

		id.setBounds(62, 102, 195, 42);
		id.setFont(MyFont.Static);
		id.setText("�˺�");
		id.addFocusListener(this);


		password.setBounds(62, 154, 195, 42);
		password.setFont(MyFont.Static);
		password.addFocusListener(this);
		password.setText("����");
		password.setEchoChar('\0');


		

		button_login = new JButton("��¼");
		button_login.setBounds(62, 222, 70, 27);
		button_login.setFont(MyFont.Static);
		button_login.addMouseListener(this);

		button_reset = new JButton("����");
		button_reset.setBounds(187, 222, 70, 27);
		button_reset.addMouseListener(this);
		button_reset.setFont(MyFont.Static);

		backgroundPanel.add(id);
		backgroundPanel.add(password);
		backgroundPanel.add(button_login);
		backgroundPanel.add(button_reset);

		getContentPane().add(backgroundPanel);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u767B\u9646");
		lblNewLabel.setFont(new Font("΢���ź�", Font.BOLD, 24));
		lblNewLabel.setBounds(101, 50, 96, 42);
		backgroundPanel.add(lblNewLabel);
		this.setTitle("���ʹ���ϵͳ");
		this.setSize(310, 380);
		this.setVisible(true);
		this.requestFocus();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		}
	
		
	@Override
	public void mouseClicked(MouseEvent e) {
		Map<String, Object> map;
		if (e.getSource() == button_login) {
			if ("�˺�".equals(id.getText())) {
				JOptionPane.showMessageDialog(null, "�˺Ų���Ϊ��");
			} else if ("����".equals(new String(password.getPassword()))) {
				JOptionPane.showMessageDialog(null, "���벻��Ϊ��");
			} else {
				String un =id.getText();
				String pw =new MD5Code().getMD5ofStr(new String(password.getPassword()));
				User user = new User();
				user.setId(un);
				user.setPassword(pw);
				
				try {
					map = ServiceFactory.getUserServiceInstance().login(user);
					boolean flag = (Boolean) map.get("flag");
					if (flag) { // �˺�������ȷ����ʾ��¼�ɹ�
						User vo = (User)map.get("user");
						this.setVisible(false);
						new IndexJFrame(vo);
					}else { // ��¼ʧ��
						JOptionPane.showMessageDialog(null, "�˺���������");
					}
				} catch (Exception e2) {
					
					e2.printStackTrace();
				}
				
			}
		} else if (e.getSource() == button_reset) {
			id.setText("�˺�");
			password.setText("����");
			password.setEchoChar('\0');
		}

	}
	
	//�۽��¼�
	@Override
	public void focusGained(FocusEvent e) {
		if (e.getSource() == id) {
			if (id.getText().equals("�˺�")) {
				id.setText("");
			}
		} else if (e.getSource() == password) {
			if (new String(password.getPassword()).equals("����")) {
				password.setText("");
				password.setEchoChar('*');
			}
		}
	}
	
	
	// ʧ���¼�
	@Override
	public void focusLost(FocusEvent e) {
		if (e.getSource() == id) {
			if (id.getText().equals("")) {
				id.setText("�˺�");
			}
		} else if (e.getSource() == password) {
			if (new String(password.getPassword()).equals("")) {
				password.setText("����");
				password.setEchoChar('\0');
			}
		}
	}

	

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
