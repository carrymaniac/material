package cn.gdou.material.dao;

import java.util.List;

import cn.gdou.material.entity.Good;

public interface GoodDao extends IDao<Integer,Good>{
	/**
	 * ����ģ����ѯ��
	 * @param column ��ѯ�ֶ�
	 * @param keyWord ��ѯ�Ĺؼ���
	 * @return	List<Good> �ļ��� �������˷��ϲ�ѯ���������н��
	 * @throws Exception
	 */
	public List<Good> findByColumn(String column, String keyWord) throws Exception ;
	public List<Good> findAllDetails() throws Exception ;
}
