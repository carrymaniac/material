package cn.gdou.material.frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import cn.gdou.material.entity.User;
import cn.gdou.material.util.ImagePanel;
import cn.gdou.material.util.MyFont;

@SuppressWarnings("serial")
public class IndexJFrame extends JFrame implements MouseListener, ActionListener{
	// �����û�����
	private User user;
	
	
	// ���帨������
	int sign_home = 0;
	int sign_GoodData = 0;
	int sign_AppointmentDate = 0;
	int sign_userManager = 0;
	
	
	
	// �����Ļ�Ĵ�С
	final static int width = Toolkit.getDefaultToolkit().getScreenSize().width;
	final static int height = Toolkit.getDefaultToolkit().getScreenSize().height;
	
	JPanel backgroundPanel, topPanel, topMenu, topPrompt, centerPanel, subPanel, subMenu;
	JTabbedPane jTabbedPane;

	JLabel home, GoodData, AppointmentDate, userManager;
	public IndexJFrame(User user) {
		this.user = user;
		
		// ����tab�������
		
		
		initBackgroundPanel();
		
		try {
			Image imgae = ImageIO.read(new File("image/logo.png"));
			this.setIconImage(imgae);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.setTitle("���ʹ���ϵͳ");
		this.setSize((int) (width * 0.8f), (int) (height * 0.8f));
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}
	
	// ��ʼ���������
	public void initBackgroundPanel() {

		backgroundPanel = new JPanel(new BorderLayout());
		initTop();
		initCenterPanel();

		backgroundPanel.add(topPanel, "North");
		backgroundPanel.add(centerPanel, "Center");

		this.add(backgroundPanel);
	}
	
	// ��ʼ���������
	public void initCenterPanel() {
		centerPanel = new JPanel(new BorderLayout());
		home.setText("<html><font color='#336699' style='font-weight:bold'>" + "��ҳ" + "</font>&nbsp;</html>");
		creatHome();
		centerPanel.setOpaque(false);
	}
	// ������ҳ���
	public void creatHome() {
		centerPanel.removeAll();//�����������
		try {
			Image bgimg = ImageIO.read(new File("image/indexbackground.jpg"));
			ImagePanel centerBackground = new ImagePanel(bgimg);
			centerPanel.add(centerBackground, "Center");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	// ��ʼ����������
	public void initSign() {
		sign_home = 0;
		sign_GoodData = 0;
		sign_AppointmentDate = 0;
		sign_userManager = 0;
	}
	// ��ʼ�������������
	public void initTop() {
		initTopMenu();
		initTopPrompt();

		topPanel = new JPanel(new BorderLayout());
		topPanel.setPreferredSize(new Dimension(width, 40));

		topPanel.add(topMenu, "West");
		topPanel.add(topPrompt, "East");
		
	}
	// ��ʼ�������˵�
	public void initTopMenu() {
		topMenu = new JPanel();
		topMenu = new JPanel();
		topMenu.setPreferredSize(new Dimension(500, 40));
		topMenu.setOpaque(false);
		String[] nameStrings = { "��ҳ", "��Ʒ����", "���������", "�û�����" };
		home = CreateMenuLabel(home, nameStrings[0], "home", topMenu);
		home.setName("home");
		GoodData = CreateMenuLabel(GoodData, nameStrings[1], "GoodData", topMenu);
		GoodData.setName("GoodData");
		AppointmentDate= CreateMenuLabel(AppointmentDate, nameStrings[2], "AppointmentDate", topMenu);
		AppointmentDate.setName("AppointmentDate");
		userManager = CreateMenuLabel(userManager, nameStrings[3], "userManager", topMenu);
		userManager.setName("userManager");
	
	
	}
	// ���������˵�Label
		public JLabel CreateMenuLabel(JLabel jlb, String text, String name, JPanel who) {
			JLabel line = new JLabel("<html>&nbsp;<font color='#D2D2D2'>|</font>&nbsp;</html>");
			Icon icon = new ImageIcon("image/" + name + ".png");
			jlb = new JLabel(icon);
			jlb.setText("<html><font color='black'>" + text + "</font>&nbsp;</html>");
			jlb.addMouseListener(this);
			jlb.setFont(MyFont.Static);
			who.add(jlb);
			if (!"userManager".equals(name)) {
				who.add(line);
			}
			return jlb;
		}
	// ��ʼ��������ӭ���
		public void initTopPrompt() {

			Icon icon = new ImageIcon("image/male.png");
			JLabel label = new JLabel(icon);
			if (user != null) {
				label.setText("<html><font color='black'>��ӭ����</font><font color='#336699'><b>" + this.user.getName()
						+ "</b></font></html>");
			} else {
				label.setText("<html><font color='black'>��ӭ����</font><font color='#336699'><b></b></font></html>");
			}
			label.setFont(MyFont.Static);
			topPrompt = new JPanel();
			topPrompt.setPreferredSize(new Dimension(180, 40));
			topPrompt.setOpaque(false);
			topPrompt.add(label);

		}
	
		//������Ʒ�������
		public void creatGoodDataTab() {

			centerPanel.removeAll();
			// ����tab����λ��
			jTabbedPane = new JTabbedPane(JTabbedPane.TOP);
			// ����tab����
			jTabbedPane.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);
			jTabbedPane.setFont(MyFont.Static);

			jTabbedPane.addTab("��Ʒ����", new GoodManagerJPanel().backgroundPanel);
			centerPanel.add(jTabbedPane, "Center");
		}
		
		public void creatUserManagerTab() {
			
			centerPanel.removeAll();
			// ����tab����λ��
			jTabbedPane = new JTabbedPane(JTabbedPane.TOP);
			// ����tab����
			jTabbedPane.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);
			jTabbedPane.setFont(MyFont.Static);

			jTabbedPane.addTab("�û�����", new UserManagerJPanel(user, this).backgroundPanel);
			centerPanel.add(jTabbedPane, "Center");
			
		}
		public void creatstatisticsTab() {
			centerPanel.removeAll();
			
			// ����tab����λ��
			jTabbedPane = new JTabbedPane(JTabbedPane.TOP);
			
			//����Tab����
			jTabbedPane.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);
			jTabbedPane.setFont(MyFont.Static);
			
			jTabbedPane.addTab("����ͳ��", new GoodManagerJPanel().backgroundPanel);
			
			centerPanel.add(jTabbedPane, "Center");
			
		}

		public void creatAppointmentDateTab() {
			centerPanel.removeAll();
			// ����tab����λ��
			jTabbedPane = new JTabbedPane(JTabbedPane.TOP);
			// ����tab����
			jTabbedPane.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);
			jTabbedPane.setFont(MyFont.Static);
			jTabbedPane.addTab("��������",new OrderManagerJPanel(user).backgroundPanel);
			jTabbedPane.addTab("��ⵥ", new StockInputManagerJPanel(user).backgroundPanel);
			jTabbedPane.addTab("���ⵥ", new StockOutputManagerJPanel(user).backgroundPanel);
			
			centerPanel.add(jTabbedPane, "Center");
		}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	//������¼�
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == home) {
			initSign();
			sign_home = 1;
			creatHome();
			home.setText("<html><font color='#336699' style='font-weight:bold'>" + "��ҳ" + "</font>&nbsp;</html>");
			GoodData.setText("<html><font color='black'>" + "��Ʒ����" + "</font>&nbsp;</html>");
			AppointmentDate.setText("<html><font color='black'>" + "���������" + "</font>&nbsp;</html>");
			userManager.setText("<html><font color='black'>" + "�û�����" + "</font>&nbsp;</html>");
		} else if(e.getSource() == GoodData) {
			initSign();
			sign_GoodData = 1;
			creatGoodDataTab();
			GoodData.setText("<html><font color='#336699' style='font-weight:bold'>" + "��Ʒ����" + "</font>&nbsp;</html>");
			home.setText("<html><font color='black'>" + "��ҳ" + "</font>&nbsp;</html>");
			AppointmentDate.setText("<html><font color='black'>" + "���������" + "</font>&nbsp;</html>");
			userManager.setText("<html><font color='black'>" + "�û�����" + "</font>&nbsp;</html>");
		}else if(e.getSource() == AppointmentDate) {
			initSign();
			sign_AppointmentDate = 1;
			creatAppointmentDateTab();
			AppointmentDate.setText("<html><font color='#336699' style='font-weight:bold'>" + "���������" + "</font>&nbsp;</html>");
			home.setText("<html><font color='black'>" + "��ҳ" + "</font>&nbsp;</html>");
			GoodData.setText("<html><font color='black'>" + "��Ʒ����" + "</font>&nbsp;</html>");
			userManager.setText("<html><font color='black'>" + "�û�����" + "</font>&nbsp;</html>");
		}else if (e.getSource() == userManager) {
			initSign();
			sign_userManager = 1;
			creatUserManagerTab();
			userManager
					.setText("<html><font color='#336699' style='font-weight:bold'>" + "�û�����" + "</font>&nbsp;</html>");
			home.setText("<html><font color='black'>" + "��ҳ" + "</font>&nbsp;</html>");
			GoodData.setText("<html><font color='black'>" + "��Ʒ����" + "</font>&nbsp;</html>");
			AppointmentDate.setText("<html><font color='black'>" + "���������" + "</font>&nbsp;</html>");
		}else {
			System.out.println("ok");
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
