package cn.gdou.material.frame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;

import cn.gdou.material.entity.Appointment;
import cn.gdou.material.entity.User;
import cn.gdou.material.factory.ServiceFactory;

public class StockInputManagerJPanel implements ActionListener, MouseListener, DocumentListener {
	JPanel backgroundPanel, topPanel, toolPanel, searchByGoodPanel, seacrchPanel,tablePanel;
	
	JTable table;
	JScrollPane jScrollPane;
	JLabel tool_add, tool_modify, tool_delete,label_name,label_date;
	JTextField input_name,input_date;
	
	
	// �û�����
	User user;

	public StockInputManagerJPanel(User user) {
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
		tool_add.setToolTipText("�½���ⶩ��");
		tool_add.addMouseListener(this);

		Icon icon_modify = new ImageIcon("image/modify.png");
		tool_modify = new JLabel(icon_modify);
		tool_modify.setToolTipText("�޸���ⶩ��");
		tool_modify.addMouseListener(this);

		Icon icon_delete = new ImageIcon("image/delete.png");
		tool_delete = new JLabel(icon_delete);
		tool_delete.setToolTipText("ɾ����ⶩ��");
		tool_delete.addMouseListener(this);
		if("1" .equals(user.getIdentity())) {
			toolPanel.add(tool_add);
			
		}
		
		/*
		 *  ������ⵥ�޸Ĳ�������Ϊ�������߼����⻹δ���
		 *  �ȴ�����󿪷�������ܡ�
		 */			
		/* toolPanel.add(tool_modify); */
		
		/*toolPanel.add(tool_delete);*/

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
			List<Appointment> Appointments = null  ;
			
			try {
				Appointments = ServiceFactory.getAppointmentServiceInstance().InPutlist();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			//����һ��TableModel
			AppointmentTableModel atm = new AppointmentTableModel(Appointments);
			//���� TableModel������ Table
	        table = new JTable(atm);
	        
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
		List<Appointment> Appointments = null  ;
		
		Map<String,String> map = new HashMap<String,String>() ;
		map.put("appointmentId", "");
		map.put("appointtime", date);
		map.put("goodid", name);
		map.put("company", "");
		map.put("number", "");
		
		try {
			Appointments = ServiceFactory.getAppointmentServiceInstance().listInPutByColumns(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//����һ��TableModel
		AppointmentTableModel atm = new AppointmentTableModel(Appointments);
		//���� TableModel������ Table
        table = new JTable(atm);
        
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
	
	
	
	// ������¼�
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tool_add) {
			new AddStockInputJFrame(user, this);
			
		}
		
	}
	@Override
	public void changedUpdate(DocumentEvent e) {
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
