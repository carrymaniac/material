package cn.gdou.material.frame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.util.HashSet;
import java.util.List;
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

import cn.gdou.material.entity.Good;
import cn.gdou.material.factory.ServiceFactory;
/**
 * ��Ʒ�������
 * @author Lusty
 *
 */
public class GoodManagerJPanel implements ActionListener, MouseListener,DocumentListener{
	JPanel backgroundPanel, topPanel, toolPanel, searchPanel, tablePanel;
	JTable table;
	JScrollPane jScrollPane;
	JLabel label_category, label_warehouse, tool_add, tool_modify, tool_delete,label_name;
	JTextField input_name;
	
	public GoodManagerJPanel(){
		backgroundPanel = new JPanel(new BorderLayout());
		 initTablePanel();
		 initTopPanel();
		
	}
	
	// ��ʼ���������
	public void initTopPanel() {

		topPanel = new JPanel(new BorderLayout());
		//���ù������
		initToolPanel();
		initSearchPanel();
		//���뵽�ܱ��������ȥ
		backgroundPanel.add(topPanel, "North");

	}
	//��ʼ���������
	public void initToolPanel() {

		toolPanel = new JPanel();
		// ����ͼ��
		Icon icon_add = new ImageIcon("image/add.png");
		tool_add = new JLabel(icon_add);
		tool_add.setToolTipText("�½���Ʒ");
		tool_add.addMouseListener(this);

		Icon icon_modify = new ImageIcon("image/modify.png");
		tool_modify = new JLabel(icon_modify);
		tool_modify.setToolTipText("�޸���Ʒ");
		tool_modify.addMouseListener(this);

		Icon icon_delete = new ImageIcon("image/delete.png");
		tool_delete = new JLabel(icon_delete);
		tool_delete.setToolTipText("ɾ����Ʒ");
		tool_delete.addMouseListener(this);

		toolPanel.add(tool_add);
		toolPanel.add(tool_modify);
		toolPanel.add(tool_delete);
		//���뵽���������ȥ
		topPanel.add(toolPanel, "West");

	}
	//��ʼ�����ݱ���б�
	public void initTablePanel() {
		
		
		
		List<Good> Goods = null ;		
		try {
			Goods = ServiceFactory.getGoodServiceInstance().list();
		} catch (Exception e) {
			e.printStackTrace();
		}			
		//����һ��TableModel
		GoodTableModel htm= new GoodTableModel(Goods);
		//���� TableModel������ Table
        table = new JTable(htm);
        
        //���������
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();//��Ԫ����Ⱦ�� 
		tcr.setHorizontalAlignment(JLabel.CENTER);//������ʾ  
        table.setDefaultRenderer(Object.class, tcr);//������Ⱦ��  
        table.setRowHeight(80); 
        // ����ѡ��ģʽΪ����ѡ��
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        // ѡ�е�һ�� ������0��
        //table.getSelectionModel().setSelectionInterval(0, 0);
        
        jScrollPane = new JScrollPane(table);
        
        tablePanel = new JPanel(new BorderLayout());
        
        tablePanel.setOpaque(false);

		tablePanel.add(jScrollPane);
		
		backgroundPanel.add(tablePanel, "Center");
        
	}
	public void refreshTablePanel() {
		backgroundPanel.remove(tablePanel);
		String name = input_name.getText();
		 List<Good> Goods = null ;		
			try {
				Goods = ServiceFactory.getGoodServiceInstance().listByColumn("name", name);
			} catch (Exception e) {
				e.printStackTrace();
			}			
		//����һ��TableModel
		GoodTableModel htm= new GoodTableModel(Goods);
		 //���� TableModel������ Table
        table = new JTable(htm);
        //���������
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();//��Ԫ����Ⱦ�� 
		tcr.setHorizontalAlignment(JLabel.CENTER);//������ʾ  
        table.setDefaultRenderer(Object.class, tcr);//������Ⱦ��  
        table.setRowHeight(80); 
        jScrollPane = new JScrollPane(table);
        
        tablePanel = new JPanel(new BorderLayout());
        
        tablePanel.setOpaque(false);

		tablePanel.add(jScrollPane);
		
		backgroundPanel.add(tablePanel, "Center");
	}
	// ��ʼ�������������
		public void initSearchPanel() {
			searchPanel = new JPanel();
			// ��Ʒģ�����������
			input_name = new JTextField(10);
			input_name.getDocument().addDocumentListener(this);
			
			// ��ǩ
			label_name = new JLabel("��Ʒ����");
			searchPanel.add(label_name);
			searchPanel.add(input_name);
			
			topPanel.add(searchPanel, "East");
		}
	//��굥���¼�
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tool_add) {//�����Ʒ
			new AddGoodsJFrame(this);
		}		
		else if(e.getSource() == tool_delete) {//ɾ����Ʒ
			int selectedRow= table.getSelectedRow();
			if (selectedRow == -1) {
				JOptionPane.showMessageDialog(null, "��ѡ����Ʒ");
			} 
			else {
			int id = (int)table.getValueAt(selectedRow, 2);
			Set<Integer> ids = new HashSet<Integer>();
			ids.add(id);
			int result = JOptionPane.showConfirmDialog(null, "�Ƿ�ȷ��ɾ����", "�û���ʾ", JOptionPane.YES_NO_OPTION);
			if (result == 0) {
				try {
					if (ServiceFactory.getGoodServiceInstance().delete(ids)) {
						JOptionPane.showMessageDialog(null, "��Ʒɾ���ɹ���");
						refreshTablePanel();
					}else {
						JOptionPane.showMessageDialog(null, "��Ʒɾ��ʧ�ܣ�");
						refreshTablePanel();
					}
				} catch (Exception e1) {
					
					e1.printStackTrace();
				
				}
			}
			}
		}		
			else if (e.getSource() == tool_modify) {//�޸���Ʒ
				int selectedRow= table.getSelectedRow();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(null, "��ѡ����Ʒ");
				}  else {
					System.out.println(selectedRow);
					new ModifyGoodsJFrame(this, table, selectedRow);
					
				}
			}
		}

	@Override
	public void mouseEntered(MouseEvent arg0) {


		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {


		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {


	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		
	}

	@Override
	public void changedUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	// �ı�����������¼�
	@Override
	public void insertUpdate(DocumentEvent e) {
		refreshTablePanel();
	}

	// �ı���ɾ�������¼�
	@Override
	public void removeUpdate(DocumentEvent e) {
		refreshTablePanel();
	}

}
