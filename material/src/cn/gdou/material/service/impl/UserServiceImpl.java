package cn.gdou.material.service.impl;

import java.util.HashMap;
import java.util.Map;

import cn.gdou.material.dbc.DatabaseConnection;
import cn.gdou.material.entity.User;
import cn.gdou.material.factory.DAOFactory;
import cn.gdou.material.service.UserService;

public class UserServiceImpl implements UserService{
	private DatabaseConnection dbc = new DatabaseConnection();
	@Override
	public Map<String, Object> login(User vo) throws Exception {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			// �����û��ĵ�¼��֤
			User result = DAOFactory.getUserDaoInstance(this.dbc.getConnection()).findLogin(vo);	
			//��Ž��
			map.put("user", result);
			map.put("flag", result != null);
			return map;
		}catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
	}

	@Override
	public boolean updatePassword(String id, String oldpass, String newpass) throws Exception {
		try {
			// 1�����ȸ��ݹ���ԱID��ѯ������Ա��ԭʼ��Ϣ
			User user = DAOFactory.getUserDaoInstance(this.dbc.getConnection()).findById(id);
			if (user != null) { // �Ѿ����ҵ���ָ���Ĺ���Ա����
				if (oldpass.equals(user.getPassword())) { // ���ԭʼ��������������ƥ��
					// ִ������ĸ��²���
					return DAOFactory.getUserDaoInstance(this.dbc.getConnection()).doUpdatePassword(id, newpass);
				}
			}
			return false;
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
	}

	@Override
	public boolean updateById(User vo) throws Exception {
		try {
			DAOFactory.getUserDaoInstance(this.dbc.getConnection()).doUpdate(vo);
		}catch (Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
		return false;
	}

}
