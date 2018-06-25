package cn.gdou.material.dao;
import java.util.List;
import java.util.Set;
 
/**
 * 定义数据表的数据层操作标准
 * @author Lusty
 * @param <K> 要操作数据表的主键数据类型
 * @param <V> 要操作的VO类型
 */
public interface IDao<K,V> {
	/**
	 * 数据的增加操作，执行的是INSERT语句
	 * @param vo 包含了要增加的数据信息
	 * @return 如果数据增加成功返回true，否则返回false
	 * @throws Exception 如果数据库没有连接，则出现NullPointerException，如果SQL语句错误抛出SQLException
	 */
	public boolean doCreate(V vo) throws Exception ;
	/**
	 * 数据的修改操作，执行的是UPDATE语句，本次的修改会根据ID将所有数据进行变更
	 * @param vo 包含了要修改数据的信息
	 * @return 数据修改成功返回true，否则返回false
	 * @throws Exception 如果数据库没有连接，则出现NullPointerException，如果SQL语句错误抛出SQLException
	 */
	public boolean doUpdate(V vo) throws Exception ;
	/**
	 * 数据的删除操作，需要在执行前根据删除的编号，拼凑出SQL语句
	 * @param ids 所有要删除的编号数据
	 * @return 删除成功返回true，否则返回false
	 * @throws Exception 如果数据库没有连接，则出现NullPointerException，如果SQL语句错误抛出SQLException
	 */
	public boolean doRemove(Set<K> ids) throws Exception ;
	/**
	 * 根据编号查询出表一行的完整信息，并且将返回结果填充到VO类对象之中
	 * @param id 要查询的数据编号
	 * @return 如果查询到则将内容以VO对象的形式返回，如果没有数据则返回null
	 * @throws Exception 如果数据库没有连接，则出现NullPointerException，如果SQL语句错误抛出SQLException
	 */
	public V findById(K id) throws Exception ;
	/**
	 * 查询数据表中的全部数据，每行数据通过VO类包装，而后通过List保存多个返回结果
	 * @return 全部的查询数据行，如果没有数据返回则集合的长度为0（size()==0）
	 * @throws Exception 如果数据库没有连接，则出现NullPointerException，如果SQL语句错误抛出SQLException
	 */
	public List<V> findAll() throws Exception ;
	/**
	 * 分页进行数据表的模糊查询操作，每行数据通过VO类包装，而后通过List保存多个返回结果
	 * @param column 要模糊查询的数据列
	 * @param keyWord 要进行查询的关键字
	 * @param currentPage 当前所在页
	 * @param lineSize 每页显示的数据行数
	 * @return 全部的查询数据行，如果没有数据返回则集合的长度为0（size()==0）
	 * @throws Exception 如果数据库没有连接，则出现NullPointerException，如果SQL语句错误抛出SQLException
	 */
	public List<V> findAllSplit(String column,String keyWord,Integer currentPage,Integer lineSize) throws Exception ;
	/**
	 * 使用COUNT()函数统计数据表中符合查询要求的数据量
	 * @param column 要模糊查询的数据列
	 * @param keyWord 要进行查询的关键字
	 * @return 返回COUNT()的统计结果，如果没有数据满足，则返回的内容为0
	 * @throws Excetpion 如果数据库没有连接，则出现NullPointerException，如果SQL语句错误抛出SQLException
	 */
	public Integer getAllCount(String column,String keyWord) throws Exception ; 
}
