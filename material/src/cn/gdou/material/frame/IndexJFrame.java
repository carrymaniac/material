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
	// 定义用户对象
	private User user;
	
	
	// 定义辅助变量
	int sign_home = 0;
	int sign_GoodData = 0;
	int sign_AppointmentDate = 0;
	int sign_userManager = 0;
	
	
	
	// 获得屏幕的大小
	final static int width = Toolkit.getDefaultToolkit().getScreenSize().width;
	final static int height = Toolkit.getDefaultToolkit().getScreenSize().height;
	
	JPanel backgroundPanel, topPanel, topMenu, topPrompt, centerPanel, subPanel, subMenu;
	JTabbedPane jTabbedPane;

	JLabel home, GoodData, AppointmentDate, userManager;
	public IndexJFrame(User user) {
		this.user = user;
		
		// 设置tab面板缩进
		
		
		initBackgroundPanel();
		
		try {
			Image imgae = ImageIO.read(new File("image/logo.png"));
			this.setIconImage(imgae);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.setTitle("物资管理系统");
		this.setSize((int) (width * 0.8f), (int) (height * 0.8f));
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}
	
	// 初始化背景面板
	public void initBackgroundPanel() {

		backgroundPanel = new JPanel(new BorderLayout());
		initTop();
		initCenterPanel();

		backgroundPanel.add(topPanel, "North");
		backgroundPanel.add(centerPanel, "Center");

		this.add(backgroundPanel);
	}
	
	// 初始化中心面板
	public void initCenterPanel() {
		centerPanel = new JPanel(new BorderLayout());
		home.setText("<html><font color='#336699' style='font-weight:bold'>" + "首页" + "</font>&nbsp;</html>");
		creatHome();
		centerPanel.setOpaque(false);
	}
	// 创建首页面板
	public void creatHome() {
		centerPanel.removeAll();//清除已有内容
		try {
			Image bgimg = ImageIO.read(new File("image/indexbackground.jpg"));
			ImagePanel centerBackground = new ImagePanel(bgimg);
			centerPanel.add(centerBackground, "Center");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	// 初始化辅助变量
	public void initSign() {
		sign_home = 0;
		sign_GoodData = 0;
		sign_AppointmentDate = 0;
		sign_userManager = 0;
	}
	// 初始化顶部顶部面板
	public void initTop() {
		initTopMenu();
		initTopPrompt();

		topPanel = new JPanel(new BorderLayout());
		topPanel.setPreferredSize(new Dimension(width, 40));

		topPanel.add(topMenu, "West");
		topPanel.add(topPrompt, "East");
		
	}
	// 初始化顶部菜单
	public void initTopMenu() {
		topMenu = new JPanel();
		topMenu = new JPanel();
		topMenu.setPreferredSize(new Dimension(500, 40));
		topMenu.setOpaque(false);
		String[] nameStrings = { "首页", "商品数据", "进销存管理", "用户管理" };
		home = CreateMenuLabel(home, nameStrings[0], "home", topMenu);
		home.setName("home");
		GoodData = CreateMenuLabel(GoodData, nameStrings[1], "GoodData", topMenu);
		GoodData.setName("GoodData");
		AppointmentDate= CreateMenuLabel(AppointmentDate, nameStrings[2], "AppointmentDate", topMenu);
		AppointmentDate.setName("AppointmentDate");
		userManager = CreateMenuLabel(userManager, nameStrings[3], "userManager", topMenu);
		userManager.setName("userManager");
	
	
	}
	// 创建顶部菜单Label
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
	// 初始化顶部欢迎面板
		public void initTopPrompt() {

			Icon icon = new ImageIcon("image/male.png");
			JLabel label = new JLabel(icon);
			if (user != null) {
				label.setText("<html><font color='black'>欢迎您，</font><font color='#336699'><b>" + this.user.getName()
						+ "</b></font></html>");
			} else {
				label.setText("<html><font color='black'>欢迎您，</font><font color='#336699'><b></b></font></html>");
			}
			label.setFont(MyFont.Static);
			topPrompt = new JPanel();
			topPrompt.setPreferredSize(new Dimension(180, 40));
			topPrompt.setOpaque(false);
			topPrompt.add(label);

		}
	
		//创建商品数据面板
		public void creatGoodDataTab() {

			centerPanel.removeAll();
			// 设置tab标题位置
			jTabbedPane = new JTabbedPane(JTabbedPane.TOP);
			// 设置tab布局
			jTabbedPane.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);
			jTabbedPane.setFont(MyFont.Static);

			jTabbedPane.addTab("商品管理", new GoodManagerJPanel().backgroundPanel);
			centerPanel.add(jTabbedPane, "Center");
		}
		
		public void creatUserManagerTab() {
			
			centerPanel.removeAll();
			// 设置tab标题位置
			jTabbedPane = new JTabbedPane(JTabbedPane.TOP);
			// 设置tab布局
			jTabbedPane.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);
			jTabbedPane.setFont(MyFont.Static);

			jTabbedPane.addTab("用户管理", new UserManagerJPanel(user, this).backgroundPanel);
			centerPanel.add(jTabbedPane, "Center");
			
		}
		public void creatstatisticsTab() {
			centerPanel.removeAll();
			
			// 设置tab标题位置
			jTabbedPane = new JTabbedPane(JTabbedPane.TOP);
			
			//设置Tab布局
			jTabbedPane.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);
			jTabbedPane.setFont(MyFont.Static);
			
			jTabbedPane.addTab("数据统计", new GoodManagerJPanel().backgroundPanel);
			
			centerPanel.add(jTabbedPane, "Center");
			
		}

		public void creatAppointmentDateTab() {
			centerPanel.removeAll();
			// 设置tab标题位置
			jTabbedPane = new JTabbedPane(JTabbedPane.TOP);
			// 设置tab布局
			jTabbedPane.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);
			jTabbedPane.setFont(MyFont.Static);
			jTabbedPane.addTab("订单管理",new OrderManagerJPanel(user).backgroundPanel);
			jTabbedPane.addTab("入库单", new StockInputManagerJPanel(user).backgroundPanel);
			jTabbedPane.addTab("出库单", new StockOutputManagerJPanel(user).backgroundPanel);
			
			centerPanel.add(jTabbedPane, "Center");
		}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	//鼠标点击事件
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == home) {
			initSign();
			sign_home = 1;
			creatHome();
			home.setText("<html><font color='#336699' style='font-weight:bold'>" + "首页" + "</font>&nbsp;</html>");
			GoodData.setText("<html><font color='black'>" + "商品数据" + "</font>&nbsp;</html>");
			AppointmentDate.setText("<html><font color='black'>" + "进销存管理" + "</font>&nbsp;</html>");
			userManager.setText("<html><font color='black'>" + "用户管理" + "</font>&nbsp;</html>");
		} else if(e.getSource() == GoodData) {
			initSign();
			sign_GoodData = 1;
			creatGoodDataTab();
			GoodData.setText("<html><font color='#336699' style='font-weight:bold'>" + "商品数据" + "</font>&nbsp;</html>");
			home.setText("<html><font color='black'>" + "首页" + "</font>&nbsp;</html>");
			AppointmentDate.setText("<html><font color='black'>" + "进销存管理" + "</font>&nbsp;</html>");
			userManager.setText("<html><font color='black'>" + "用户管理" + "</font>&nbsp;</html>");
		}else if(e.getSource() == AppointmentDate) {
			initSign();
			sign_AppointmentDate = 1;
			creatAppointmentDateTab();
			AppointmentDate.setText("<html><font color='#336699' style='font-weight:bold'>" + "进销存管理" + "</font>&nbsp;</html>");
			home.setText("<html><font color='black'>" + "首页" + "</font>&nbsp;</html>");
			GoodData.setText("<html><font color='black'>" + "商品数据" + "</font>&nbsp;</html>");
			userManager.setText("<html><font color='black'>" + "用户管理" + "</font>&nbsp;</html>");
		}else if (e.getSource() == userManager) {
			initSign();
			sign_userManager = 1;
			creatUserManagerTab();
			userManager
					.setText("<html><font color='#336699' style='font-weight:bold'>" + "用户管理" + "</font>&nbsp;</html>");
			home.setText("<html><font color='black'>" + "首页" + "</font>&nbsp;</html>");
			GoodData.setText("<html><font color='black'>" + "商品数据" + "</font>&nbsp;</html>");
			AppointmentDate.setText("<html><font color='black'>" + "进销存管理" + "</font>&nbsp;</html>");
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
