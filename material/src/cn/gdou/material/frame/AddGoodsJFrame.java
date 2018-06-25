package cn.gdou.material.frame;

import javax.swing.JPanel;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;

import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextField;

import cn.gdou.material.entity.Good;
import cn.gdou.material.factory.ServiceFactory;
import cn.gdou.material.util.MyFont;

/**
 * 添加新的商品界面
 * 
 * @author Lusty
 *
 */
@SuppressWarnings("serial")
public class AddGoodsJFrame extends JFrame implements MouseListener {
	JPanel backgroundPanel, labelPanel, contentPanel, buttonPanel;
	JLabel label_good_id, label_name, label_factory, label_specifications, label_number;
	JTextField good_id, name, factory, specifications, number;

	JButton button_add;

	// 获得屏幕的大小
	final static int width = Toolkit.getDefaultToolkit().getScreenSize().width;
	final static int height = Toolkit.getDefaultToolkit().getScreenSize().height;

	// 父面板对象
	GoodManagerJPanel parentPanel;

	public AddGoodsJFrame(GoodManagerJPanel parentPanel) {
		this.parentPanel = parentPanel;

		initBackgroundPanel();

		this.add(backgroundPanel);

		this.setTitle("添加商品");
		this.setSize(640, 360);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}

	// 初始化背景面板
	public void initBackgroundPanel() {
		backgroundPanel = new JPanel(new BorderLayout());

		initContentPanel();
		initButtonPanel();
		initLabelPanel();

		backgroundPanel.add(labelPanel, "North");
		backgroundPanel.add(contentPanel, "Center");
		backgroundPanel.add(buttonPanel, "South");
	}

	// 初始化label面板
	public void initLabelPanel() {

		labelPanel = new JPanel();

		JLabel title = new JLabel("商品信息");
		title.setFont(MyFont.Static);

		labelPanel.add(title);
	}

	// 初始化商品信息面板
	public void initContentPanel() {
		contentPanel = new JPanel(new GridLayout(6, 2));

		label_good_id = new JLabel("商品ID", JLabel.CENTER);
		label_name = new JLabel("商品名称", JLabel.CENTER);
		label_factory = new JLabel("商品厂家", JLabel.CENTER);
		label_specifications = new JLabel("商品规格", JLabel.CENTER);
		label_number = new JLabel("商品数量", JLabel.CENTER);

		good_id = new JTextField("");
		name = new JTextField("");
		factory = new JTextField("");
		specifications = new JTextField("");
		number = new JTextField("");

		contentPanel.add(label_good_id);
		contentPanel.add(good_id);

		contentPanel.add(label_name);
		contentPanel.add(name);

		contentPanel.add(label_factory);
		contentPanel.add(factory);

		contentPanel.add(label_specifications);
		contentPanel.add(specifications);

		contentPanel.add(label_number);
		contentPanel.add(number);

	}

	// 初始化按钮面板
	public void initButtonPanel() {
		buttonPanel = new JPanel();
		button_add = new JButton("保存");
		button_add.setFont(MyFont.Static);
		button_add.addMouseListener(this);
		buttonPanel.add(button_add);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == button_add) {
			String good_id_String = good_id.getText().trim();

			String name_String = name.getText().trim();

			String factory_String = factory.getText().trim();

			String specifications_String = specifications.getText().trim();

			String number_String = number.getText().trim();

			if (good_id_String.isEmpty()) {
				JOptionPane.showMessageDialog(null, "请输入商品ID");
			} else if (name_String.isEmpty()) {
				JOptionPane.showMessageDialog(null, "请输入商品名称");
			} else if (factory_String.isEmpty()) {
				JOptionPane.showMessageDialog(null, "请输入商品生产工厂");
			} else if (specifications_String.isEmpty()) {
				JOptionPane.showMessageDialog(null, "请输入商品规格");
			} else if (number_String.isEmpty()) {
				JOptionPane.showMessageDialog(null, "请输入商品数量");
			} else {

				Integer good_id_int = Integer.valueOf(good_id_String);
				Integer number_int = Integer.valueOf(number_String);
				Good vo = new Good();
				vo.setGoodId(good_id_int);
				vo.setName(name_String);
				vo.setFactory(factory_String);
				vo.setSpecifications(specifications_String);
				vo.setNumber(number_int);
				try {
					if (ServiceFactory.getGoodServiceInstance().insert(vo)) {
						JOptionPane.showMessageDialog(null, "添加商品成功");
						this.setVisible(false);
						parentPanel.refreshTablePanel();
					} else {
						JOptionPane.showMessageDialog(null, "添加商品失败，请查看id是否重复");
						this.setVisible(false);
						parentPanel.refreshTablePanel();
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}

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
