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
			// 进行用户的登录验证
			User result = DAOFactory.getUserDaoInstance(this.dbc.getConnection()).findLogin(vo);	
			//存放结果
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
			// 1、首先根据管理员ID查询出管理员的原始信息
			User user = DAOFactory.getUserDaoInstance(this.dbc.getConnection()).findById(id);
			if (user != null) { // 已经查找到了指定的管理员对象
				if (oldpass.equals(user.getPassword())) { // 如果原始密码与输入密码匹配
					// 执行密码的更新操作
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
