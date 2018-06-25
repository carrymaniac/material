package cn.gdou.material.dao;

import java.util.List;
import java.util.Map;


import cn.gdou.material.entity.Order;


public interface OrderDao extends IDao<Integer,Order>{
	/**
	 * �����еĶ������ж���ģ����ѯ��
	 * @param map ��������Ҫ��ѯ���ֶκͶ�Ӧ�Ĺؼ��� ���� �ֶ���key ��Ӧ�Ĺؼ�����value
	 * @return List<Order> �ļ��� �������˷��ϲ�ѯ���������н��
	 * @throws Exception
	 */
	public List<Order> findByColumns(Map<String,String> map )throws Exception ;
	/**
	 * ͨ������ID�Զ�����������
	 * @return
	 * @throws Exception
	 */
	public Boolean changeSignById(int id , int sign) throws Exception ;
}
