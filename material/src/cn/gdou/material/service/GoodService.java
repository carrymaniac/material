package cn.gdou.material.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.gdou.material.entity.Good;

public interface GoodService {
	/**ʵ����Ʒ���ݵ����Ӳ������ڱ�����֮����Ҫʹ��GoodDAO�ӿ��е����·�����
	 * ���Ӳ�����Ҫ��������GoodDAO.findById()�жϣ�����ʹ��IDeptDAO.doCreate()����
	 * @param vo
	 * @return �������ӳɹ�����true�����򷵻�false
	 * @throws Exception
	 */
	public boolean insert(Good vo) throws Exception ;
	/**
	 * ʵ�����ݵ��޸Ĳ��������õ���GoodDAO.doUpdate()�������˲�������ȫ���޸�
	 * @param vo ����Ҫ�޸ĵ�������Ϣ
	 * @return �޸ĳɹ�����true�����򷵻�false
	 * @throws Exception GoodDAO�ӿ��е��׳��쳣
	 */
	public boolean update(Good vo) throws Exception ;
	/**
	 * ʵ�����ݵ�����ɾ���������ڱ���������Ҫִ�����µ��ã�<br>
	 * <li>��Ҫ�ж�Ҫɾ�����ݴ���ļ��������Ƿ�Ϊ�գ��ж�null�Լ�size()��</li>
	 * <li>���ȷ����ɾ�������ݣ������GoodDAO.doRemove()����ɾ��</li>
	 * @param ids ������Ҫɾ�����ݵ�����ID����
	 * @return ɾ���ɹ�����true�����򷵻�false
	 * @throws Exception GoodDAO�ӿ��е��׳��쳣
	 */
	public boolean delete(Set<Integer> ids) throws Exception ;
	/**
	 * ������Ʒ��Ų�ѯ��һ����Ʒ��������Ϣ�����õ���GoodDAO.findById()������ѯ
	 * @param id Ҫ��ѯ����Ʒ�����Ϣ
	 * @return ������Բ�ѯ����Ʒ����VO����ʽ���أ������ѯ�����򷵻�null
	 * @throws Exception GoodDAO�ӿ��е��׳��쳣
	 */
	public Good get(Integer id) throws Exception ;
	/**
	 * ��ѯ��Ա��ȫ�����ݣ����õ���GoodDAO.findAll()������ѯ
	 * @return ���еĲ�ѯ��¼��List���Ϸ���
	 * @throws Exception GoodDAO�ӿ��е��׳��쳣
	 */
	public List<Good> list() throws Exception ; 
	
	/**
	 * ����ģ����ѯ
	 * @param column ��ѯ���ֶ�
	 * @param keyWord ��ѯ�Ĺؼ���
	 * @return ��������ƥ��Ľ���ļ���
	 * @throws Exception
	 */
	public List<Good> listByColumn(String column, String keyWord)throws Exception ;
	
	
	public List<Good> listDetails() throws Exception ;
	/**
	 * ʵ�����ݵ�ģ����ѯ������ͬʱ�᷵�ط��ϲ�ѯҪ������������ڱ��˲�����Ҫ�������µĹ��ܣ�<br>
	 * <li>����IEmpDAO.findAllSplit()��������ҳ��ѯҪ��ʾ�����ݣ�</li>
	 * <li>����IEmpDAO.getAllCount()������ͳ�����ݵĸ���</li>
	 * @param column ģ����ѯ���ֶ�
	 * @param keyWord ģ����ѯ�ؼ���
	 * @param currentPage ��ǰ����ҳ 
	 * @param lineSize ÿҳ����ʾ����
	 * @return ������Ҫ�����������ݣ�����ʹ��Map���Ϸ��أ����ֵ��������£�<br>
	 * <li>key = allEmps��value = IEmpDAO.findAllSplit()�����ص���List&lt;Emp&gt;</li>
	 * <li>key = empCount��value = IEmpDAO.getAllCount()�����ص���Integer</li>
	 * @throws Exception IEmpDAO�ӿ��е��׳��쳣
	 */
	public Map<String,Object> listSplit(String column,String keyWord,int currentPage,int lineSize) throws Exception ;
}
