package cn.gdou.material.frame;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import cn.gdou.material.entity.Good;
import cn.gdou.material.factory.ServiceFactory;
import cn.gdou.material.util.MyFont;
/**
 * �޸���Ʒģ��
 * @author Lusty
 *
 */
@SuppressWarnings("serial")
public class ModifyGoodsJFrame extends JFrame implements MouseListener{
	// ����ȫ�����
	JPanel backgroundPanel, labelPanel, contentPanel, buttonPanel;
	JLabel label_good_id, label_name, label_factory, label_specifications, label_number;
	JTextField good_id, name, factory, specifications, number;
	
	JButton button_modify;
	
	// �����Ļ�Ĵ�С
	final static int width = Toolkit.getDefaultToolkit().getScreenSize().width;
	final static int height = Toolkit.getDefaultToolkit().getScreenSize().height;

	// ������
	JTable table;
	int selectedRow;
	GoodManagerJPanel goodManagerJPanel;
	
	public ModifyGoodsJFrame(GoodManagerJPanel goodManagerJPanel, JTable table, int selectedRow) {
		this.table = table;
		this.selectedRow = selectedRow;
		this.goodManagerJPanel = goodManagerJPanel;
		
		initBackgroundPanel();

		this.add(backgroundPanel);

		this.setTitle("�޸���Ʒ");
		this.setSize(640, 360);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
	// ��ʼ���������
		public void initBackgroundPanel() {
			backgroundPanel = new JPanel(new BorderLayout());

			initLabelPanel();
			initContentPanel();
			initButtonPanel();

			backgroundPanel.add(labelPanel, "North");
			backgroundPanel.add(contentPanel, "Center");
			backgroundPanel.add(buttonPanel, "South");
		}
		
		// ��ʼ����Ʒ��Ϣ���
		public void initContentPanel() {
			contentPanel = new JPanel(new GridLayout(6, 2));
			label_good_id = new JLabel("��ƷID", JLabel.CENTER);
			label_name = new JLabel("��Ʒ����", JLabel.CENTER);
			label_factory = new JLabel("��Ʒ����", JLabel.CENTER);
			label_specifications = new JLabel("��Ʒ���", JLabel.CENTER);
			label_number = new JLabel("��Ʒ����", JLabel.CENTER);

			int good_id_int = (int)table.getValueAt(selectedRow, 2);
			String good_id_String = String.valueOf(good_id_int);
			int number_int = (int)table.getValueAt(selectedRow, 4);
			String number_String = String.valueOf(number_int);
			
			good_id = new JTextField(good_id_String);
			name = new JTextField((String)table.getValueAt(selectedRow, 0));
			factory = new JTextField((String)table.getValueAt(selectedRow, 1));
			specifications = new JTextField((String)table.getValueAt(selectedRow, 3));
			number = new JTextField(number_String);
			
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
		
		// ��ʼ��label���
		public void initLabelPanel() {
			labelPanel = new JPanel();
			JLabel title = new JLabel("��Ʒ��Ϣ");
			title.setFont(MyFont.Static);
			labelPanel.add(title);
		}
		
		// ��ʼ����ť���
		public void initButtonPanel() {
			buttonPanel = new JPanel();
			button_modify = new JButton("�����޸�");
			button_modify.setFont(MyFont.Static);
			button_modify.addMouseListener(this);
			buttonPanel.add(button_modify);
		}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == button_modify) {

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
					if (ServiceFactory.getGoodServiceInstance().update(vo)) {
						JOptionPane.showMessageDialog(null, "�޸���Ʒ�ɹ�");
						this.setVisible(false);
						goodManagerJPanel.refreshTablePanel();
					}else {
						JOptionPane.showMessageDialog(null, "�޸���Ʒʧ�ܣ���鿴��Ϣ�Ƿ����");
						this.setVisible(false);
						goodManagerJPanel.refreshTablePanel();
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
