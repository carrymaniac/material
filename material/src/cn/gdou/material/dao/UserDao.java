package cn.gdou.material.dao;


import java.sql.SQLException;
import java.util.Date;

import cn.gdou.material.entity.User;

public interface UserDao extends IDao<String,User>{
	/**
	 * ����Ա�ĵ�¼��������¼�ɹ�֮��Ҫ��ȡ������Ա�е�ȫ����������
	 * @param vo ��������˵�¼�û������������Ϣ
	 * @return ��¼�ɹ�����VO�������ʧ�ܷ���null
	 * @throws SQLException ���ݿ�����쳣
	 */
	public User findLogin(User vo) throws SQLException;
	
	/**
	 * ���¹���Ա�����һ�ε�¼����
	 * @param aid ����ԱID
	 * @param date ��ǰ����
	 * @return ���³ɹ�����true�����򷵻�false
	 * @throws SQLException
	 */
	public boolean doUpdateLastDate(String aid, Date date) throws SQLException;
	
	/**
	 * ��ʾ���Ǹ�������Ĳ���
	 * @param aid Ҫ���ĵĹ���Ա���
	 * @param password ������
	 * @return �޸ĳɹ�����true�����򷵻�false
	 * @throws SQLException
	 */
	public boolean doUpdatePassword(String aid, String password) throws SQLException;
	

}
