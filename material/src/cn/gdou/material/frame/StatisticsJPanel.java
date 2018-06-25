package cn.gdou.material.frame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import cn.gdou.material.entity.User;

public class StatisticsJPanel implements ActionListener, MouseListener, DocumentListener {
	JPanel backgroundPanel, topPanel, toolPanel,centerPanel;
	JLabel label_date,label_name;
	JTextField input_date,input_name;
	
	// 用户对象
	User user;
	
	public StatisticsJPanel(User user) {
		this.user = user;
		backgroundPanel = new JPanel(new BorderLayout());
		initTopPanel();
		initCenterPanel();
	}
	
	
	public void initCenterPanel() {
		
	}
	
	public void initTopPanel() {
		toolPanel = new JPanel();
		
		// 商品模糊名称输入框
		input_name = new JTextField(10);
		input_name.getDocument().addDocumentListener(this);
		
		input_date = new JTextField(10);
		input_date.getDocument().addDocumentListener(this);
		// 标签
		label_name = new JLabel("商品ID");
		label_date = new JLabel("操作时间");
		
		toolPanel.add(label_name);
		toolPanel.add(input_name);
		
		toolPanel.add(label_date);
		toolPanel.add(input_date);
		
		
		topPanel.add(toolPanel, "East");
		
		
	}


	@Override
	public void changedUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void insertUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void removeUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseClicked(MouseEvent arg0) {
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


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
