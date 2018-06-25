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
 * ����µ���Ʒ����
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

	// �����Ļ�Ĵ�С
	final static int width = Toolkit.getDefaultToolkit().getScreenSize().width;
	final static int height = Toolkit.getDefaultToolkit().getScreenSize().height;

	// ��������
	GoodManagerJPanel parentPanel;

	public AddGoodsJFrame(GoodManagerJPanel parentPanel) {
		this.parentPanel = parentPanel;

		initBackgroundPanel();

		this.add(backgroundPanel);

		this.setTitle("�����Ʒ");
		this.setSize(640, 360);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}

	// ��ʼ���������
	public void initBackgroundPanel() {
		backgroundPanel = new JPanel(new BorderLayout());

		initContentPanel();
		initButtonPanel();
		initLabelPanel();

		backgroundPanel.add(labelPanel, "North");
		backgroundPanel.add(contentPanel, "Center");
		backgroundPanel.add(buttonPanel, "South");
	}

	// ��ʼ��label���
	public void initLabelPanel() {

		labelPanel = new JPanel();

		JLabel title = new JLabel("��Ʒ��Ϣ");
		title.setFont(MyFont.Static);

		labelPanel.add(title);
	}

	// ��ʼ����Ʒ��Ϣ���
	public void initContentPanel() {
		contentPanel = new JPanel(new GridLayout(6, 2));

		label_good_id = new JLabel("��ƷID", JLabel.CENTER);
		label_name = new JLabel("��Ʒ����", JLabel.CENTER);
		label_factory = new JLabel("��Ʒ����", JLabel.CENTER);
		label_specifications = new JLabel("��Ʒ���", JLabel.CENTER);
		label_number = new JLabel("��Ʒ����", JLabel.CENTER);

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

	// ��ʼ����ť���
	public void initButtonPanel() {
		buttonPanel = new JPanel();
		button_add = new JButton("����");
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
				JOptionPane.showMessageDialog(null, "��������ƷID");
			} else if (name_String.isEmpty()) {
				JOptionPane.showMessageDialog(null, "��������Ʒ����");
			} else if (factory_String.isEmpty()) {
				JOptionPane.showMessageDialog(null, "��������Ʒ��������");
			} else if (specifications_String.isEmpty()) {
				JOptionPane.showMessageDialog(null, "��������Ʒ���");
			} else if (number_String.isEmpty()) {
				JOptionPane.showMessageDialog(null, "��������Ʒ����");
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
						JOptionPane.showMessageDialog(null, "�����Ʒ�ɹ�");
						this.setVisible(false);
						parentPanel.refreshTablePanel();
					} else {
						JOptionPane.showMessageDialog(null, "�����Ʒʧ�ܣ���鿴id�Ƿ��ظ�");
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
