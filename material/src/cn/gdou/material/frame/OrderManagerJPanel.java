package cn.gdou.material.frame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;

import cn.gdou.material.entity.Order;
import cn.gdou.material.entity.User;
import cn.gdou.material.factory.ServiceFactory;

public class OrderManagerJPanel implements ActionListener, MouseListener, DocumentListener {
	
	
	JPanel backgroundPanel, topPanel, toolPanel, searchByGoodPanel, seacrchPanel,tablePanel;
	JTable table;
	JScrollPane jScrollPane;
	JLabel tool_add, tool_modify, tool_delete,label_name,label_date,tool_confirm,tool_refute;
	JTextField input_name,input_date;
	
	
	
	// �û�����
	User user;
	
	
	
	public OrderManagerJPanel(User user) {
		this.user = user;
		backgroundPanel = new JPanel(new BorderLayout());
		initTopPanel();
		initTablePanel();
	}
	
	
	// ��ʼ���������
		public void initTopPanel() {
			topPanel = new JPanel(new BorderLayout());

			initToolPanel();
			initSearchPanel();

			backgroundPanel.add(topPanel, "North");
		}
	// ��ʼ���������
		public void initToolPanel() {
			toolPanel = new JPanel();
			// ����ͼ��
			Icon icon_add = new ImageIcon("image/add.png");
			tool_add = new JLabel(icon_add);
			tool_add.setToolTipText("�½�����");
			tool_add.addMouseListener(this);

			Icon icon_modify = new ImageIcon("image/modify.png");
			tool_modify = new JLabel(icon_modify);
			tool_modify.setToolTipText("�޸Ķ���");
			tool_modify.addMouseListener(this);

			Icon icon_delete = new ImageIcon("image/delete.png");
			tool_delete = new JLabel(icon_delete);
			tool_delete.setToolTipText("ɾ������");
			tool_delete.addMouseListener(this);
			
			Icon icon_confirm = new ImageIcon("image/confirm.png");
			tool_confirm = new JLabel(icon_confirm);
			tool_confirm.setToolTipText("��׼����");
			tool_confirm.addMouseListener(this);
			
			Icon icon_refute = new ImageIcon("image/refute.png");
			tool_refute = new JLabel(icon_refute);
			tool_refute.setToolTipText("�ܽӶ���");
			tool_refute.addMouseListener(this);
			
		
			
			toolPanel.add(tool_add);
			
			toolPanel.add(tool_modify);
			
			toolPanel.add(tool_delete);
		
			if( "1" .equals(user.getIdentity())) {
				
				toolPanel.add(tool_confirm);
				
				toolPanel.add(tool_refute);	
			}

			topPanel.add(toolPanel, "West");
		
		}
		// ��ʼ�������������
		public void initSearchPanel() {
			searchByGoodPanel = new JPanel();
			
			// ��Ʒģ�����������
			input_name = new JTextField(10);
			input_name.getDocument().addDocumentListener(this);
			
			input_date = new JTextField(10);
			input_date.getDocument().addDocumentListener(this);
			// ��ǩ
			label_name = new JLabel("��ƷID");
			label_date = new JLabel("����ʱ��");
			
			searchByGoodPanel.add(label_name);
			searchByGoodPanel.add(input_name);
			
			searchByGoodPanel.add(label_date);
			searchByGoodPanel.add(input_date);
			
			
			topPanel.add(searchByGoodPanel, "East");
						
		}

		// ��ʼ�����ݱ�����
		public void initTablePanel() {
			List<Order> Order = null ;
			
			try {
				Order = ServiceFactory.getOrderServiceInstance().list();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			OrderTableModel otm = new OrderTableModel(Order);
			 table = new JTable(otm);
			 
			//���������
		        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();//��Ԫ����Ⱦ�� 
				tcr.setHorizontalAlignment(JLabel.CENTER);//������ʾ  
		        table.setDefaultRenderer(Object.class, tcr);//������Ⱦ��  
		        
		        // ����ѡ��ģʽΪ����ѡ��
		        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		        // ѡ�е�һ�� ������0��
		        //table.getSelectionModel().setSelectionInterval(0, 0);
		        table.setRowHeight(80); 
				jScrollPane = new JScrollPane(table);
			

				tablePanel = new JPanel(new BorderLayout());
				tablePanel.setOpaque(false);

				tablePanel.add(jScrollPane);

			backgroundPanel.add(tablePanel, "Center");
			
			
		}
		
		
		// �������ݱ��
		public void refreshTablePanel() {
			backgroundPanel.remove(tablePanel);
			String name = input_name.getText();
			String date = input_date.getText();
			List<Order> Order = null ;
			
			Map<String,String> map = new HashMap<String,String>() ;
			map.put("orderId", "");
			map.put("ordertime", date);
			map.put("goodid", name);
			map.put("company", "");
			map.put("number", "");
			map.put("operator", "");
			map.put("state", "");
			map.put("sign", "");
			
			try {
				Order = ServiceFactory.getOrderServiceInstance().listInPutByColumns(map);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			OrderTableModel otm = new OrderTableModel(Order);
			 table = new JTable(otm);
			 
			//���������
		        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();//��Ԫ����Ⱦ�� 
				tcr.setHorizontalAlignment(JLabel.CENTER);//������ʾ  
		        table.setDefaultRenderer(Object.class, tcr);//������Ⱦ��  
		        
		        // ����ѡ��ģʽΪ����ѡ��
		        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		        // ѡ�е�һ�� ������0��
		        //table.getSelectionModel().setSelectionInterval(0, 0);
		        table.setRowHeight(80); 
				jScrollPane = new JScrollPane(table);
			

				tablePanel = new JPanel(new BorderLayout());
				tablePanel.setOpaque(false);

				tablePanel.add(jScrollPane);

			backgroundPanel.add(tablePanel, "Center");
			
		}
		

		@Override
		public void mouseClicked(MouseEvent e) {
			
			int selectedRow= table.getSelectedRow();
			if (e.getSource() == tool_add) {
				new AddOrderJFrame(user, this);				
			}
			if (e.getSource() == tool_modify) {
				
			}
			if (e.getSource() == tool_delete) {
			
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(null, "��ѡ�񶩵�");
				} else {
					int id = (int)table.getValueAt(selectedRow, 0);
					Set<Integer> ids = new HashSet<Integer>();
					ids.add(id);
					int result = JOptionPane.showConfirmDialog(null, "�Ƿ�ȷ��ɾ����", "�û���ʾ", JOptionPane.YES_NO_OPTION);
					if (result == 0) {
						try {
							if (ServiceFactory.getOrderServiceInstance().delete(ids)) {
								JOptionPane.showMessageDialog(null, "����ɾ���ɹ���");
								refreshTablePanel();
							}else {
								JOptionPane.showMessageDialog(null, "����ɾ��ʧ�ܣ�");
								refreshTablePanel();
							}
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				}
			}
			if (e.getSource() == tool_confirm) {
				
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(null, "��ѡ�񶩵�");
				} else {
					int result = JOptionPane.showConfirmDialog(null, "ȷ��ͨ����ˣ�", "�û���ʾ", JOptionPane.YES_NO_OPTION);
					if (result == 0) {
						int id = (int)table.getValueAt(selectedRow, 0);
						String sign = (String)table.getValueAt(selectedRow, 7);
						if("δ���".equals(sign)) {
							try {
								if(ServiceFactory.getOrderServiceInstance().comfirm(id)) {
									JOptionPane.showMessageDialog(null, "�����ɹ���");
									refreshTablePanel();
								}else {
									JOptionPane.showMessageDialog(null, "����ʧ�ܣ������Ƿ���������⣡");
									refreshTablePanel();
								}
							}catch (Exception e1) {
								e1.printStackTrace();
							}
						}else {
							JOptionPane.showMessageDialog(null, "��ѡ����ȷ�Ķ�����");
							refreshTablePanel();
						}
					
					}
				}	
			}
			if (e.getSource() == tool_refute) {
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(null, "��ѡ�񶩵�");
				} else {
					int result = JOptionPane.showConfirmDialog(null, "ȷ���ܽӸö�����", "�û���ʾ", JOptionPane.YES_NO_OPTION);
					if (result == 0) {
						int id = (int)table.getValueAt(selectedRow, 0);
						String sign = (String)table.getValueAt(selectedRow, 7);
						if("δ���".equals(sign)) {
							try {
								if(ServiceFactory.getOrderServiceInstance().refute(id)) {
									JOptionPane.showMessageDialog(null, "�����ɹ���");
									refreshTablePanel();
								}else {
									JOptionPane.showMessageDialog(null, "����ʧ�ܣ�");
									refreshTablePanel();
								}
							}catch (Exception e1) {
								e1.printStackTrace();
							}
						}else {
							JOptionPane.showMessageDialog(null, "��ѡ����ȷ�Ķ�����");
							refreshTablePanel();
						}
					}
				}	
			}
		}
		
		@Override
		public void changedUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void insertUpdate(DocumentEvent arg0) {
			refreshTablePanel();
			
		}


		@Override
		public void removeUpdate(DocumentEvent arg0) {
			refreshTablePanel();
			
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


		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		
}
