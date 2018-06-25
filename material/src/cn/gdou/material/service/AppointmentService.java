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
	 * 出库单进行模糊查询
	 * @param column 查询的字段
	 * @param keyWord 查询的关键词
	 * @return 包含所有匹配的结果的集合
	 * @throws Exception
	 */
	public List<Appointment> listOutPutByColumn(String column, String keyWord)throws Exception ;
	/**
	 * 进库单进行模糊查询
	 * @param column 查询的字段
	 * @param keyWord 查询的关键词
	 * @return 包含所有匹配的结果的集合
	 * @throws Exception
	 */
	public List<Appointment> listInPutByColumn(String column, String keyWord)throws Exception ;
	
	public List<Appointment> listInPutByColumns(Map<String, String> map)throws Exception ;
}
