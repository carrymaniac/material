package cn.gdou.material.dao;


import java.sql.SQLException;
import java.util.Date;

import cn.gdou.material.entity.User;

public interface UserDao extends IDao<String,User>{
	/**
	 * 管理员的登录操作，登录成功之后要求取出管理员中的全部数据内容
	 * @param vo 主查包含了登录用户名与密码的信息
	 * @return 登录成功返回VO对象，如果失败返回null
	 * @throws SQLException 数据库操作异常
	 */
	public User findLogin(User vo) throws SQLException;
	
	/**
	 * 更新管理员的最后一次登录日期
	 * @param aid 管理员ID
	 * @param date 当前日期
	 * @return 更新成功返回true，否则返回false
	 * @throws SQLException
	 */
	public boolean doUpdateLastDate(String aid, Date date) throws SQLException;
	
	/**
	 * 表示的是更新密码的操作
	 * @param aid 要更改的管理员编号
	 * @param password 新密码
	 * @return 修改成功返回true，否则返回false
	 * @throws SQLException
	 */
	public boolean doUpdatePassword(String aid, String password) throws SQLException;
	

}
