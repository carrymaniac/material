package cn.gdou.material.dao;

import java.util.List;
import java.util.Map;

import cn.gdou.material.entity.Appointment;

public interface AppointmentDao extends IDao<Integer,Appointment>{
	/**
	 * 查找所有入库的订单
	 * @return
	 * @throws Exception
	 */
	public List<Appointment> findAllInPut() throws Exception ;
	
	/**
	 * 查找所有出库的订单
	 * @return
	 * @throws Exception
	 */
	public List<Appointment> findAllOutPut() throws Exception ;
	/**
	 * 对所有的进库单进行模糊查询，
	 * @param column 查询字段
	 * @param keyWord 查询的关键词
	 * @return	List<Appointment> 的集合 ，包含了符合查询条件的所有结果
	 * @throws Exception
	 */
	public List<Appointment> findOutPutByColumn(String column, String keyWord) throws Exception ;
	/**
	 * 对所有的入库单进行单条件模糊查询，
	 * @param column 查询字段
	 * @param keyWord 查询的关键词
	 * @return	List<Appointment> 的集合 ，包含了符合查询条件的所有结果
	 * @throws Exception
	 */
	public List<Appointment> findInPutByColumn(String column, String keyWord) throws Exception ;
	/**
	 * 对所有的入库单进行多重模糊查询，
	 * @param map 包含了需要查询的字段和对应的关键词 其中 字段是key 对应的关键词是value
	 * @return List<Appointment> 的集合 ，包含了符合查询条件的所有结果
	 * @throws Exception
	 */
	public List<Appointment> findInPutByColumns(Map<String,String> map )throws Exception ;
}
