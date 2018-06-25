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
 * 商品管理界面
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
	
	// 初始化顶部面板
	public void initTopPanel() {

		topPanel = new JPanel(new BorderLayout());
		//调用工具面板
		initToolPanel();
		initSearchPanel();
		//加入到总背景面板中去
		backgroundPanel.add(topPanel, "North");

	}
	//初始化工具面板
	public void initToolPanel() {

		toolPanel = new JPanel();
		// 工具图标
		Icon icon_add = new ImageIcon("image/add.png");
		tool_add = new JLabel(icon_add);
		tool_add.setToolTipText("新建商品");
		tool_add.addMouseListener(this);

		Icon icon_modify = new ImageIcon("image/modify.png");
		tool_modify = new JLabel(icon_modify);
		tool_modify.setToolTipText("修改商品");
		tool_modify.addMouseListener(this);

		Icon icon_delete = new ImageIcon("image/delete.png");
		tool_delete = new JLabel(icon_delete);
		tool_delete.setToolTipText("删除商品");
		tool_delete.addMouseListener(this);

		toolPanel.add(tool_add);
		toolPanel.add(tool_modify);
		toolPanel.add(tool_delete);
		//加入到顶部面板中去
		topPanel.add(toolPanel, "West");

	}
	//初始化数据表格列表
	public void initTablePanel() {
		
		
		
		List<Good> Goods = null ;		
		try {
			Goods = ServiceFactory.getGoodServiceInstance().list();
		} catch (Exception e) {
			e.printStackTrace();
		}			
		//创建一个TableModel
		GoodTableModel htm= new GoodTableModel(Goods);
		//根据 TableModel来创建 Table
        table = new JTable(htm);
        
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
	public void refreshTablePanel() {
		backgroundPanel.remove(tablePanel);
		String name = input_name.getText();
		 List<Good> Goods = null ;		
			try {
				Goods = ServiceFactory.getGoodServiceInstance().listByColumn("name", name);
			} catch (Exception e) {
				e.printStackTrace();
			}			
		//创建一个TableModel
		GoodTableModel htm= new GoodTableModel(Goods);
		 //根据 TableModel来创建 Table
        table = new JTable(htm);
        //设置其居中
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();//单元格渲染器 
		tcr.setHorizontalAlignment(JLabel.CENTER);//居中显示  
        table.setDefaultRenderer(Object.class, tcr);//设置渲染器  
        table.setRowHeight(80); 
        jScrollPane = new JScrollPane(table);
        
        tablePanel = new JPanel(new BorderLayout());
        
        tablePanel.setOpaque(false);

		tablePanel.add(jScrollPane);
		
		backgroundPanel.add(tablePanel, "Center");
	}
	// 初始化搜素条件面板
		public void initSearchPanel() {
			searchPanel = new JPanel();
			// 商品模糊名称输入框
			input_name = new JTextField(10);
			input_name.getDocument().addDocumentListener(this);
			
			// 标签
			label_name = new JLabel("商品名称");
			searchPanel.add(label_name);
			searchPanel.add(input_name);
			
			topPanel.add(searchPanel, "East");
		}
	//鼠标单击事件
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tool_add) {//添加商品
			new AddGoodsJFrame(this);
		}		
		else if(e.getSource() == tool_delete) {//删除商品
			int selectedRow= table.getSelectedRow();
			if (selectedRow == -1) {
				JOptionPane.showMessageDialog(null, "请选择商品");
			} 
			else {
			int id = (int)table.getValueAt(selectedRow, 2);
			Set<Integer> ids = new HashSet<Integer>();
			ids.add(id);
			int result = JOptionPane.showConfirmDialog(null, "是否确定删除？", "用户提示", JOptionPane.YES_NO_OPTION);
			if (result == 0) {
				try {
					if (ServiceFactory.getGoodServiceInstance().delete(ids)) {
						JOptionPane.showMessageDialog(null, "商品删除成功！");
						refreshTablePanel();
					}else {
						JOptionPane.showMessageDialog(null, "商品删除失败！");
						refreshTablePanel();
					}
				} catch (Exception e1) {
					
					e1.printStackTrace();
				
				}
			}
			}
		}		
			else if (e.getSource() == tool_modify) {//修改商品
				int selectedRow= table.getSelectedRow();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(null, "请选择商品");
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
	// 文本框插入内容事件
	@Override
	public void insertUpdate(DocumentEvent e) {
		refreshTablePanel();
	}

	// 文本框删除内容事件
	@Override
	public void removeUpdate(DocumentEvent e) {
		refreshTablePanel();
	}

}
