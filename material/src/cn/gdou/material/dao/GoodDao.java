package cn.gdou.material.dao;

import java.util.List;

import cn.gdou.material.entity.Good;

public interface GoodDao extends IDao<Integer,Good>{
	/**
	 * 进行模糊查询，
	 * @param column 查询字段
	 * @param keyWord 查询的关键词
	 * @return	List<Good> 的集合 ，包含了符合查询条件的所有结果
	 * @throws Exception
	 */
	public List<Good> findByColumn(String column, String keyWord) throws Exception ;
	public List<Good> findAllDetails() throws Exception ;
}
