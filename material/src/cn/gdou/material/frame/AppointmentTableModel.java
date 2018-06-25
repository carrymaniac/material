package cn.gdou.material.frame;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import cn.gdou.material.entity.Appointment;


@SuppressWarnings("serial")
public class AppointmentTableModel extends AbstractTableModel {
	String[] columnNames = new String[] { "����ID", "����ʱ��", "��ƷID", "������","��ص�λ","����"};
	
	public List<Appointment> Appointments  ;
	
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public AppointmentTableModel(List<Appointment> Appointments) {
		this.Appointments = Appointments ;
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
		return Appointments.size();
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
