package cn.gdou.material.dao;
import java.util.List;
import java.util.Set;
 
/**
 * �������ݱ�����ݲ������׼
 * @author Lusty
 * @param <K> Ҫ�������ݱ��������������
 * @param <V> Ҫ������VO����
 */
public interface IDao<K,V> {
	/**
	 * ���ݵ����Ӳ�����ִ�е���INSERT���
	 * @param vo ������Ҫ���ӵ�������Ϣ
	 * @return ����������ӳɹ�����true�����򷵻�false
	 * @throws Exception ������ݿ�û�����ӣ������NullPointerException�����SQL�������׳�SQLException
	 */
	public boolean doCreate(V vo) throws Exception ;
	/**
	 * ���ݵ��޸Ĳ�����ִ�е���UPDATE��䣬���ε��޸Ļ����ID���������ݽ��б��
	 * @param vo ������Ҫ�޸����ݵ���Ϣ
	 * @return �����޸ĳɹ�����true�����򷵻�false
	 * @throws Exception ������ݿ�û�����ӣ������NullPointerException�����SQL�������׳�SQLException
	 */
	public boolean doUpdate(V vo) throws Exception ;
	/**
	 * ���ݵ�ɾ����������Ҫ��ִ��ǰ����ɾ���ı�ţ�ƴ�ճ�SQL���
	 * @param ids ����Ҫɾ���ı������
	 * @return ɾ���ɹ�����true�����򷵻�false
	 * @throws Exception ������ݿ�û�����ӣ������NullPointerException�����SQL�������׳�SQLException
	 */
	public boolean doRemove(Set<K> ids) throws Exception ;
	/**
	 * ���ݱ�Ų�ѯ����һ�е�������Ϣ�����ҽ����ؽ����䵽VO�����֮��
	 * @param id Ҫ��ѯ�����ݱ��
	 * @return �����ѯ����������VO�������ʽ���أ����û�������򷵻�null
	 * @throws Exception ������ݿ�û�����ӣ������NullPointerException�����SQL�������׳�SQLException
	 */
	public V findById(K id) throws Exception ;
	/**
	 * ��ѯ���ݱ��е�ȫ�����ݣ�ÿ������ͨ��VO���װ������ͨ��List���������ؽ��
	 * @return ȫ���Ĳ�ѯ�����У����û�����ݷ����򼯺ϵĳ���Ϊ0��size()==0��
	 * @throws Exception ������ݿ�û�����ӣ������NullPointerException�����SQL�������׳�SQLException
	 */
	public List<V> findAll() throws Exception ;
	/**
	 * ��ҳ�������ݱ��ģ����ѯ������ÿ������ͨ��VO���װ������ͨ��List���������ؽ��
	 * @param column Ҫģ����ѯ��������
	 * @param keyWord Ҫ���в�ѯ�Ĺؼ���
	 * @param currentPage ��ǰ����ҳ
	 * @param lineSize ÿҳ��ʾ����������
	 * @return ȫ���Ĳ�ѯ�����У����û�����ݷ����򼯺ϵĳ���Ϊ0��size()==0��
	 * @throws Exception ������ݿ�û�����ӣ������NullPointerException�����SQL�������׳�SQLException
	 */
	public List<V> findAllSplit(String column,String keyWord,Integer currentPage,Integer lineSize) throws Exception ;
	/**
	 * ʹ��COUNT()����ͳ�����ݱ��з��ϲ�ѯҪ���������
	 * @param column Ҫģ����ѯ��������
	 * @param keyWord Ҫ���в�ѯ�Ĺؼ���
	 * @return ����COUNT()��ͳ�ƽ�������û���������㣬�򷵻ص�����Ϊ0
	 * @throws Excetpion ������ݿ�û�����ӣ������NullPointerException�����SQL�������׳�SQLException
	 */
	public Integer getAllCount(String column,String keyWord) throws Exception ; 
}
