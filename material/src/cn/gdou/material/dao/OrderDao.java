package cn.gdou.material.dao;

import java.util.List;
import java.util.Map;


import cn.gdou.material.entity.Order;


public interface OrderDao extends IDao<Integer,Order>{
	/**
	 * 对所有的订单进行多重模糊查询，
	 * @param map 包含了需要查询的字段和对应的关键词 其中 字段是key 对应的关键词是value
	 * @return List<Order> 的集合 ，包含了符合查询条件的所有结果
	 * @throws Exception
	 */
	public List<Order> findByColumns(Map<String,String> map )throws Exception ;
	/**
	 * 通过订单ID对订单进行审批
	 * @return
	 * @throws Exception
	 */
	public Boolean changeSignById(int id , int sign) throws Exception ;
}
