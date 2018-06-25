package cn.gdou.material.dao;

import java.util.List;
import java.util.Map;

import cn.gdou.material.entity.Appointment;

public interface AppointmentDao extends IDao<Integer,Appointment>{
	/**
	 * �����������Ķ���
	 * @return
	 * @throws Exception
	 */
	public List<Appointment> findAllInPut() throws Exception ;
	
	/**
	 * �������г���Ķ���
	 * @return
	 * @throws Exception
	 */
	public List<Appointment> findAllOutPut() throws Exception ;
	/**
	 * �����еĽ��ⵥ����ģ����ѯ��
	 * @param column ��ѯ�ֶ�
	 * @param keyWord ��ѯ�Ĺؼ���
	 * @return	List<Appointment> �ļ��� �������˷��ϲ�ѯ���������н��
	 * @throws Exception
	 */
	public List<Appointment> findOutPutByColumn(String column, String keyWord) throws Exception ;
	/**
	 * �����е���ⵥ���е�����ģ����ѯ��
	 * @param column ��ѯ�ֶ�
	 * @param keyWord ��ѯ�Ĺؼ���
	 * @return	List<Appointment> �ļ��� �������˷��ϲ�ѯ���������н��
	 * @throws Exception
	 */
	public List<Appointment> findInPutByColumn(String column, String keyWord) throws Exception ;
	/**
	 * �����е���ⵥ���ж���ģ����ѯ��
	 * @param map ��������Ҫ��ѯ���ֶκͶ�Ӧ�Ĺؼ��� ���� �ֶ���key ��Ӧ�Ĺؼ�����value
	 * @return List<Appointment> �ļ��� �������˷��ϲ�ѯ���������н��
	 * @throws Exception
	 */
	public List<Appointment> findInPutByColumns(Map<String,String> map )throws Exception ;
}
