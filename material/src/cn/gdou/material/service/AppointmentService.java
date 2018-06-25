package cn.gdou.material.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.gdou.material.entity.Appointment;



public interface AppointmentService {

	public boolean insert(Appointment vo) throws Exception ;
	public boolean update(Appointment vo) throws Exception ;
	public boolean delete(Set<Integer> ids) throws Exception ;
	public Appointment get(Integer id) throws Exception ;
	public List<Appointment> list() throws Exception ; 
	public List<Appointment> InPutlist() throws Exception ; 
	public List<Appointment> OutPutlist() throws Exception ; 
	/**
	 * ���ⵥ����ģ����ѯ
	 * @param column ��ѯ���ֶ�
	 * @param keyWord ��ѯ�Ĺؼ���
	 * @return ��������ƥ��Ľ���ļ���
	 * @throws Exception
	 */
	public List<Appointment> listOutPutByColumn(String column, String keyWord)throws Exception ;
	/**
	 * ���ⵥ����ģ����ѯ
	 * @param column ��ѯ���ֶ�
	 * @param keyWord ��ѯ�Ĺؼ���
	 * @return ��������ƥ��Ľ���ļ���
	 * @throws Exception
	 */
	public List<Appointment> listInPutByColumn(String column, String keyWord)throws Exception ;
	
	public List<Appointment> listInPutByColumns(Map<String, String> map)throws Exception ;
}
