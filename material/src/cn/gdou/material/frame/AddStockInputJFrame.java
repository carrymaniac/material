package cn.gdou.material.frame;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import cn.gdou.material.entity.Appointment;
import cn.gdou.material.entity.Good;
import cn.gdou.material.entity.User;
import cn.gdou.material.factory.ServiceFactory;
import cn.gdou.material.util.Item;
import cn.gdou.material.util.MyFont;

@SuppressWarnings("serial")
public class AddStockInputJFrame extends JFrame implements MouseListener, ActionListener{
		JPanel backgroundPanel, labelPanel, contentPanel, buttonPanel;
		// ������
		JTable table;
		int selectedRow;
		StockInputManagerJPanel parentPanel;
		JLabel label_good, label_operator,label_company,label_number;
		JComboBox<Item> select_name ;
		JTextField  operator,company,number;
		JButton button_add;
		
		
		// �����Ļ�Ĵ�С
		final static int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		final static int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		
		// �û�����
		User user;

		public AddStockInputJFrame(User user, StockInputManagerJPanel parentPanel) {
			this.user = user;
			this.parentPanel = parentPanel;

			initBackgroundPanel();

			this.add(backgroundPanel);
			
			this.setTitle("�����ⵥ");
			this.setSize(480, 270);
			this.setVisible(true);
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			this.setResizable(false);
		}

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

			JLabel title = new JLabel("�����Ϣ");
			title.setFont(MyFont.Static);

			labelPanel.add(title);
		}
		
		// ��ʼ����Ʒ��Ϣ���
		public void initContentPanel() {
			List<Good> list_goods = null;
			contentPanel = new JPanel(new GridLayout(4, 2));
			label_good = new JLabel("��Ʒ����", JLabel.CENTER);
			label_operator = new JLabel("������Ա", JLabel.CENTER);
			label_company = new JLabel("��ع�˾", JLabel.CENTER);
			label_number = new JLabel("����", JLabel.CENTER);

			// ��Ʒ����������
			select_name = new JComboBox<Item>();
			try {
				 list_goods = ServiceFactory.getGoodServiceInstance().list();
			}catch (Exception e) {
				e.printStackTrace();
			}
			select_name.addItem(new Item("��ѡ��","��ѡ��"));
			
			//����ȡ������Ʒ���ݱ������б���
			if (!list_goods.isEmpty()) {
				for (Good object : list_goods) {
					select_name.addItem(new Item((int) object.getGoodId(),object));
				}
			}
			select_name.addActionListener(this);

			operator = new JTextField("");
			company = new JTextField("");
			number = new JTextField("");
			contentPanel.add(label_good);
			contentPanel.add(select_name);
			contentPanel.add(label_operator);
			contentPanel.add(operator);
			contentPanel.add(label_company);
			contentPanel.add(company);
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
		
		/**
		 * ���������
		 */
		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getSource() == button_add) {

				String number_String = number.getText().trim();
				String operator_String = operator.getText().trim();
				String company_String = company.getText().trim();
				Item it =(Item) select_name.getSelectedItem();
				
				
				if ("��ѡ��".equals(it.getValue())) {
					JOptionPane.showMessageDialog(null, "��ѡ�������Ʒ");
				}else if(number_String.isEmpty()) {
					JOptionPane.showMessageDialog(null, "����������");
				}else if(operator_String.isEmpty()) {
					JOptionPane.showMessageDialog(null, "�����������Ա");
				}else if(company_String.isEmpty()) {
					JOptionPane.showMessageDialog(null, "��������ع�˾");
				}else{
					Boolean result = null ;
					Good gd = (Good)it.getValue();
					Integer number_int = Integer.valueOf(number_String);
					Appointment vo = new Appointment();
					vo.setAppointTime(new Date());
					vo.setGood(gd);
					vo.setCompany(company_String);
					vo.setOperator(operator_String);
					vo.setNumber(number_int);
					vo.setState(1);
					try {
						result = ServiceFactory.getAppointmentServiceInstance().insert(vo);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					if (result) {
						JOptionPane.showMessageDialog(null, "��ⵥ��ӳɹ�");
						this.setVisible(false);
						parentPanel.refreshTablePanel();
					}else {
						JOptionPane.showMessageDialog(null, "�����ⵥʧ�ܣ�������Ϣ�Ƿ�����");
						this.setVisible(false);
						parentPanel.refreshTablePanel();
					}
					
				}
			}
		}	
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
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
