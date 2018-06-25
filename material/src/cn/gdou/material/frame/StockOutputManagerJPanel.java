package cn.gdou.material.frame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;

import cn.gdou.material.entity.Appointment;
import cn.gdou.material.entity.User;
import cn.gdou.material.factory.ServiceFactory;

public class StockOutputManagerJPanel implements ActionListener, MouseListener, DocumentListener {
	
	
	JPanel backgroundPanel, topPanel, toolPanel, searchPanel, tablePanel;	
	JTable table;
	JScrollPane jScrollPane;
	JLabel tool_add, tool_modify, tool_delete;
	
	
	
	// 用户对象
	User user;
	
	public StockOutputManagerJPanel(User user) {
		this.user = user;
		backgroundPanel = new JPanel(new BorderLayout());
		initTopPanel();
		initTablePanel();
	}
	// 初始化顶部面板
		public void initTopPanel() {

			topPanel = new JPanel(new BorderLayout());

			initToolPanel();
			initSearchPanel();

			backgroundPanel.add(topPanel, "North");

		}
		// 初始化工具面板
		public void initToolPanel() {

			toolPanel = new JPanel();
			// 工具图标
			Icon icon_add = new ImageIcon("image/add.png");
			tool_add = new JLabel(icon_add);
			tool_add.setToolTipText("新建入库订单");
			tool_add.addMouseListener(this);

			Icon icon_modify = new ImageIcon("image/modify.png");
			tool_modify = new JLabel(icon_modify);
			tool_modify.setToolTipText("修改入库订单");
			tool_modify.addMouseListener(this);

			Icon icon_delete = new ImageIcon("image/delete.png");
			tool_delete = new JLabel(icon_delete);
			tool_delete.setToolTipText("删除入库订单");
			tool_delete.addMouseListener(this);

			if("1" .equals(user.getIdentity())) {
				toolPanel.add(tool_add);
				
			}
			/*
			 *  隐藏入库单修改操作，因为服务层的逻辑问题还未解决
			 *  等待解决后开放这个功能。
			 */			
			/* toolPanel.add(tool_modify); */
			
			/*toolPanel.add(tool_delete);*/

			topPanel.add(toolPanel, "West");

		}
		
		// 初始化搜素条件面板
		//等待写完服务层的模糊查询再做实现
		public void initSearchPanel() {
			
		}
		
		// 初始化数据表格面板
			public void initTablePanel() {
				List<Appointment> Appointments = null  ;
				
				try {
					Appointments = ServiceFactory.getAppointmentServiceInstance().OutPutlist();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				//创建一个TableModel
				AppointmentTableModel atm = new AppointmentTableModel(Appointments);
				//根据 TableModel来创建 Table
		        table = new JTable(atm);
		        
		        //设置其居中
		        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();//单元格渲染器 
				tcr.setHorizontalAlignment(JLabel.CENTER);//居中显示  
		        table.setDefaultRenderer(Object.class, tcr);//设置渲染器  
		        
		        // 设置选择模式为单行选择
		        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		        // 选中第一行 （基本0）
		        //table.getSelectionModel().setSelectionInterval(0, 0);
		        table.setRowHeight(80); 
				jScrollPane = new JScrollPane(table);
			

				tablePanel = new JPanel(new BorderLayout());
				tablePanel.setOpaque(false);

				tablePanel.add(jScrollPane);

				backgroundPanel.add(tablePanel, "Center");
			}
		
		// 更新数据表格
		public void refreshTablePanel() {
			backgroundPanel.remove(tablePanel);
			List<Appointment> Appointments = null  ;
			
			try {
				Appointments = ServiceFactory.getAppointmentServiceInstance().OutPutlist();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			//创建一个TableModel
			AppointmentTableModel atm = new AppointmentTableModel(Appointments);
			//根据 TableModel来创建 Table
	        table = new JTable(atm);
	        
	        //设置其居中
	        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();//单元格渲染器 
			tcr.setHorizontalAlignment(JLabel.CENTER);//居中显示  
	        table.setDefaultRenderer(Object.class, tcr);//设置渲染器  
	        table.setRowHeight(80); 
	        // 设置选择模式为单行选择
	        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	        // 选中第一行 （基本0）
	        //table.getSelectionModel().setSelectionInterval(0, 0);
	        
			jScrollPane = new JScrollPane(table);
		

			tablePanel = new JPanel(new BorderLayout());
			tablePanel.setOpaque(false);

			tablePanel.add(jScrollPane);

			backgroundPanel.add(tablePanel, "Center");
		}
		
		
		
		// 鼠标点击事件
		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getSource() == tool_add) {
				new AddStockOutputJFrame(user, this);
				
			}
			
		}
		@Override
		public void changedUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void insertUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			
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