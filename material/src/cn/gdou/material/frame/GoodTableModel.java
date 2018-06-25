package cn.gdou.material.frame;

import java.util.List;

import javax.swing.table.AbstractTableModel;
import cn.gdou.material.entity.Good;

@SuppressWarnings("serial")
public class GoodTableModel extends AbstractTableModel {
	String[] columnNames = new String[] { "��Ʒ��", "��Ʒ��������", "��ƷID", "��Ʒ���","��Ʒ�������" };
	
	public List<Good> Goods  ;
	public GoodTableModel(List<Good> Goods) {
		this.Goods = Goods ;
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
		return Goods.size();
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
		Good g = Goods.get(rowIndex);
		if (0 == columnIndex)
            return g.getName();
        if (1 == columnIndex)
            return g.getFactory();
        if (2 == columnIndex)
            return g.getGoodId();
        if (3 == columnIndex)
            return g.getSpecifications();
        if (4 == columnIndex)
            return g.getNumber();
        return null;
	}

}
