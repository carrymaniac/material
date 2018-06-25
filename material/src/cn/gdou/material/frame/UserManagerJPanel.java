package cn.gdou.material.frame;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


import cn.gdou.material.entity.User;
import cn.gdou.material.factory.ServiceFactory;
import cn.gdou.material.main.Entrance;
import cn.gdou.material.util.ImagePanel;
import cn.gdou.material.util.MD5Code;
import cn.gdou.material.util.MyFont;

public class UserManagerJPanel implements MouseListener {

	// ����ȫ�����
	ImagePanel backgroundPanel;
	JPanel contentPanel, labelPanel, textPanel, buttonPanel;
	JTextField username = new JTextField(10);
	JPasswordField password = new JPasswordField(10);
	JTextField identify = new JTextField(10);
	JTextField userid = new JTextField(10);
	JButton button_modify, button_save;

	// �����С����
	int width;
	int height;

	// �����û�����
	User user = null;
	JFrame jframe = null;

	public UserManagerJPanel(User user, JFrame jframe) {
		this.user = user;
		this.jframe = jframe;

		try {
			Image bgimg = ImageIO.read(new File("image/userbackground.jpg"));
			backgroundPanel = new ImagePanel(bgimg);
			// ��ȡ��������С
			this.width = backgroundPanel.getWidth();
			this.height = backgroundPanel.getHeight();
		} catch (IOException e) {
			e.printStackTrace();
		}

		initContentPanel();
	}
	public void initContentPanel() {

		backgroundPanel.removeAll();

		contentPanel = new JPanel();
		contentPanel.setLayout(new BorderLayout(0, 30));
		contentPanel.setOpaque(false);
		labelPanel = new JPanel();
		labelPanel.setOpaque(false);
		textPanel = new JPanel(new GridLayout(3, 2, 0, 20));
		textPanel.setOpaque(false);
		buttonPanel = new JPanel();
		buttonPanel.setOpaque(false);

		JLabel label = new JLabel();
		label.setText("<html><h2 style='text-align:center;color:white'>������Ϣ</h2></html>");
		label.setFont(MyFont.Static);
		JLabel label_username = new JLabel("�û���:", JLabel.CENTER);
		label_username.setFont(MyFont.Static);
		JLabel label_password = new JLabel("����:", JLabel.CENTER);
		label_password.setFont(MyFont.Static);
		JLabel label_identify = new JLabel("���:", JLabel.CENTER);
		label_identify.setFont(MyFont.Static);

		if (user != null) {
			userid.setText(user.getId());
			username.setText(user.getName());
			password.setText(user.getPassword());		
			String identifyString = "";
			if (user.getIdentity().equals("1")) {
				identifyString = "����Ա";
			} else if (user.getIdentity().equals("0")) {
				identifyString = "��ͨԱ��";
			}
			identify.setText(identifyString);
		}
		userid.setFont(MyFont.Static);
		userid.setEditable(false);
		username.setFont(MyFont.Static);
		username.setEditable(false);
		password.setFont(MyFont.Static);
		password.setEditable(false);
		identify.setFont(MyFont.Static);
		identify.setEditable(false);

		button_modify = new JButton("�޸���Ϣ");
		button_modify.setFont(MyFont.Static);
		button_modify.addMouseListener(this);

		labelPanel.add(label);
		
		

		textPanel.add(label_username);
		textPanel.add(username);
		textPanel.add(label_password);
		textPanel.add(password);
		textPanel.add(label_identify);
		textPanel.add(identify);

		buttonPanel.add(button_modify);

		contentPanel.add(labelPanel, BorderLayout.NORTH);
		contentPanel.add(textPanel, BorderLayout.CENTER);
		contentPanel.add(buttonPanel, BorderLayout.SOUTH);
		backgroundPanel.add(contentPanel, BorderLayout.CENTER);

	}

	public void modifyUserContentPanel() {

		username.setEditable(true);
		password.setEditable(true);

		button_save = new JButton("�����޸�");
		button_save.setFont(MyFont.Static);
		button_save.addMouseListener(this);

		buttonPanel.removeAll();
		buttonPanel.add(button_save);

	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == button_modify) {
			String input_password = (String) JOptionPane.showInputDialog(null, "������ԭʼ����", "�û���֤",
					JOptionPane.PLAIN_MESSAGE);
			if (input_password.trim().isEmpty()) {
				JOptionPane.showMessageDialog(null, "ԭʼ���벻��Ϊ��");
			} else {
				String pw = new MD5Code().getMD5ofStr(input_password);
				if (user != null) {
					if (!pw.equals(user.getPassword())) {
						JOptionPane.showMessageDialog(null, "ԭʼ��������");
					} else {
						JOptionPane.showMessageDialog(null, "��֤ͨ���������޸���Ϣ");
						modifyUserContentPanel();
					}
				} else {
					JOptionPane.showMessageDialog(null, "��¼��ʱ���������µ�¼");
					jframe.setVisible(false);
					Entrance.main(null);
				}
			}
		}
		if (e.getSource() == button_save) {
			String string_username = username.getText().trim();
			String string_password = new String(password.getPassword()).trim();
			if (string_username.isEmpty()) {
				JOptionPane.showMessageDialog(null, "�û�������Ϊ��");
			}else if (string_password.isEmpty()) {
				JOptionPane.showMessageDialog(null, "�û����벻��Ϊ��");
			} else {
				String pw = new MD5Code().getMD5ofStr(string_password);
 				User vo = new User() ;
				vo.setId(user.getId());
				vo.setPassword(pw);
				vo.setName(string_username);
				vo.setIdentity(user.getIdentity());
							
				
				try {
					if (ServiceFactory.getUserServiceInstance().updateById(vo)) {
						JOptionPane.showMessageDialog(null, "�û���Ϣ�޸ĳɹ�,�������µ�½");
						jframe.setVisible(false);
						Entrance.main(null);
					}					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}

		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
