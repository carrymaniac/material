package cn.gdou.material.service;

import java.util.Map;

import cn.gdou.material.entity.User;

public interface UserService {
	
	/**
	 * ʵ�ֵ�¼�������˲���Ҫִ�����¹��ܣ�<br>
	 * 	<li>����UserDAO.findLogin()����ȷ���û����������Ƿ���ȷ</li>
	 * @param vo ֻ�����˹���Աid�������VO����
	 * @return �������µļ������ݣ�<br>
	 * 	<li>key = flag; value = �ж�IAdminDAO.findLogin()�Ƿ�Ϊnull</li>
	 * 	<li>key = user; value = ����IAdminDAO.findLogin()���ؽ��</li>
	 * @throws Exception
	 */
	public Map<String, Object> login(User vo) throws Exception;
	
	
	
	/**
	 * ��������ĸ��²��������������֮ǰӦ�����Ƚ�������ļ�飬ִ�����²�����<br>
	 * 	<li>��UserDAO�ӿ������ṩ��һ��findById()�������ж��Ƿ���ָ�����û�</li>
	 * 	<li>�ж���findById()�������淵�ص�password�Ƿ��������password</li>
	 * 	<li>�������ƥ�䣬��ִ�и��²�����UserDAO.doUpdatePassword()��</li>
	 * @param ID Ҫ�޸�������û�ID
	 * @param oldpass ������
	 * @param newpass ������
	 * @return ���³ɹ�����true�����򷵻�false
	 * @throws Exception
	 */
	public boolean updatePassword(String id, String oldpass, String newpass) throws Exception;
	
	public boolean updateById(User vo) throws Exception;
}
