package cn.gdou.material.frame;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import cn.gdou.material.entity.Order;


@SuppressWarnings("serial")
public class OrderTableModel extends AbstractTableModel {
	String[] columnNames = new String[] { "����ID", "����ʱ��", "��ƷID", "������","��ص�λ","����","��������","״̬"};
	
	public List<Order> Order  ;
	
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public OrderTableModel(List<Order> Order) {
		this.Order = Order ;
	}	
	//������һ���ж�����
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}
	
	//����һ���ж�����
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return Order.size();
	}
	
    // ��ȡÿһ�е�����
    public String getColumnName(int columnIndex) {
        // TODO Auto-generated method stub
        return columnNames[columnIndex];
    }
	
    // ��Ԫ���Ƿ�����޸�
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
	
	//ÿ����Ԫ�������ֵ
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Order a = Order.get(rowIndex);
		if (0 == columnIndex)
            return a.getOrderId();
        if (1 == columnIndex)
            return df.format(a.getOrderTime());
        if (2 == columnIndex)
            return a.getGood().getGoodId();
        if (3 == columnIndex)
            return a.getOperator();
        if (4 == columnIndex)
            return a.getCompany();
        if (5 ==columnIndex)
        	return a.getNumber();
        if (6 ==columnIndex) {
        	if(a.getState() == 0) {
        		return "����" ;
        	}else{
        		return "���" ;
        	}
        } if (7 ==columnIndex) {
        	if(a.getSign() == 0) {
        		return "δ���" ;
        	}else if(a.getSign() == 1){
        		return "��ͨ�����" ;
        	}else {
        		return "δͨ�����" ;
        	}
        }
        	
        return null;
	}

}
