package cn.gdou.material.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.gdou.material.entity.Good;

public interface GoodService {
	/**实现商品数据的增加操作，在本操作之中需要使用GoodDAO接口中的如下方法：
	 * 增加操作需要首先利用GoodDAO.findById()判断，而后使用IDeptDAO.doCreate()保存
	 * @param vo
	 * @return 数据增加成功返回true，否则返回false
	 * @throws Exception
	 */
	public boolean insert(Good vo) throws Exception ;
	/**
	 * 实现数据的修改操作，调用的是GoodDAO.doUpdate()方法，此操作属于全部修改
	 * @param vo 包含要修改的数据信息
	 * @return 修改成功返回true，否则返回false
	 * @throws Exception GoodDAO接口中的抛出异常
	 */
	public boolean update(Good vo) throws Exception ;
	/**
	 * 实现数据的批量删除操作，在本操作中需要执行如下调用：<br>
	 * <li>需要判断要删除数据传入的集合内容是否为空（判断null以及size()）</li>
	 * <li>如果确定有删除的数据，则调用GoodDAO.doRemove()方法删除</li>
	 * @param ids 包含了要删除数据的所有ID内容
	 * @return 删除成功返回true，否则返回false
	 * @throws Exception GoodDAO接口中的抛出异常
	 */
	public boolean delete(Set<Integer> ids) throws Exception ;
	/**
	 * 根据商品编号查询出一个商品的完整信息，调用的是GoodDAO.findById()方法查询
	 * @param id 要查询的商品编号信息
	 * @return 如果可以查询到商品则以VO的形式返回，如果查询不到则返回null
	 * @throws Exception GoodDAO接口中的抛出异常
	 */
	public Good get(Integer id) throws Exception ;
	/**
	 * 查询雇员的全部数据，调用的是GoodDAO.findAll()方法查询
	 * @return 所有的查询记录以List集合返回
	 * @throws Exception GoodDAO接口中的抛出异常
	 */
	public List<Good> list() throws Exception ; 
	
	/**
	 * 进行模糊查询
	 * @param column 查询的字段
	 * @param keyWord 查询的关键词
	 * @return 包含所有匹配的结果的集合
	 * @throws Exception
	 */
	public List<Good> listByColumn(String column, String keyWord)throws Exception ;
	
	
	public List<Good> listDetails() throws Exception ;
	/**
	 * 实现数据的模糊查询操作，同时会返回符合查询要求的数据量，在本此操作中要调用以下的功能：<br>
	 * <li>调用IEmpDAO.findAllSplit()方法，分页查询要显示的数据；</li>
	 * <li>调用IEmpDAO.getAllCount()方法，统计数据的个数</li>
	 * @param column 模糊查询的字段
	 * @param keyWord 模糊查询关键字
	 * @param currentPage 当前所在页 
	 * @param lineSize 每页的显示长度
	 * @return 本方法要返回两个数据，所以使用Map集合返回，出现的内容如下：<br>
	 * <li>key = allEmps、value = IEmpDAO.findAllSplit()，返回的是List&lt;Emp&gt;</li>
	 * <li>key = empCount、value = IEmpDAO.getAllCount()，返回的是Integer</li>
	 * @throws Exception IEmpDAO接口中的抛出异常
	 */
	public Map<String,Object> listSplit(String column,String keyWord,int currentPage,int lineSize) throws Exception ;
}
