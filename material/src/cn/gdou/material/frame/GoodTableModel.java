package cn.gdou.material.frame;

import java.util.List;

import javax.swing.table.AbstractTableModel;
import cn.gdou.material.entity.Good;

@SuppressWarnings("serial")
public class GoodTableModel extends AbstractTableModel {
	String[] columnNames = new String[] { "商品名", "商品生产厂家", "商品ID", "商品规格","商品库存数量" };
	
	public List<Good> Goods  ;
	public GoodTableModel(List<Good> Goods) {
		this.Goods = Goods ;
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
		return Goods.size();
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
