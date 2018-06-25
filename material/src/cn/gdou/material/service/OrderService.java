package cn.gdou.material.service;

import java.util.List;
import java.util.Map;
import java.util.Set;


import cn.gdou.material.entity.Order;

public interface OrderService {
	public boolean insert(Order vo) throws Exception ;
	public boolean update(Order vo) throws Exception ;
	public boolean delete(Set<Integer> ids) throws Exception ;
	public Order get(Integer id) throws Exception ;
	public List<Order> list() throws Exception ; 		
	public List<Order> listInPutByColumns(Map<String, String> map)throws Exception ;
	public boolean comfirm(Integer id)throws Exception ;
	public boolean refute(Integer id)throws Exception ;
}
