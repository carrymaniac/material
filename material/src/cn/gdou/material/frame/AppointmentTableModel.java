package cn.gdou.material.frame;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import cn.gdou.material.entity.Appointment;


@SuppressWarnings("serial")
public class AppointmentTableModel extends AbstractTableModel {
	String[] columnNames = new String[] { "订单ID", "订单时间", "商品ID", "操作人","相关单位","数量"};
	
	public List<Appointment> Appointments  ;
	
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public AppointmentTableModel(List<Appointment> Appointments) {
		this.Appointments = Appointments ;
	}	
	//返回行一共有多少行
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}
	
	//返回一共有多少行
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return Appointments.size();
	}
	
    // 获取每一列的名称
    public String getColumnName(int columnIndex) {
        // TODO Auto-generated method stub
        return columnNames[columnIndex];
    }
	
    // 单元格是否可以修改
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
	
	//每个单元格里面的值
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Appointment a = Appointments.get(rowIndex);
		if (0 == columnIndex)
            return a.getAppointmentId();
        if (1 == columnIndex)
            return df.format(a.getAppointTime());
        if (2 == columnIndex)
            return a.getGood().getGoodId();
        if (3 == columnIndex)
            return a.getOperator();
        if (4 == columnIndex)
            return a.getCompany();
        if (5 ==columnIndex)
        	return a.getNumber();
        return null;
	}

}
