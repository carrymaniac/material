package cn.gdou.material.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Set;

import cn.gdou.material.dao.UserDao;
import cn.gdou.material.entity.User;

public class UserDaoImpl implements UserDao {
	private Connection conn;
	private PreparedStatement pstmt;

	public UserDaoImpl(Connection conn) {
		this.conn = conn;
	}
	@Override
	public boolean doCreate(User vo) throws Exception {
		String  sql = "INSERT INTO user (id, name, password,identity) VALUES (?, ?, ?, ?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, vo.getId());
		this.pstmt.setString(2, vo.getName());
		this.pstmt.setString(3, vo.getPassword());
		this.pstmt.setString(4, vo.getIdentity());
		return this.pstmt.executeUpdate() > 0;
	}

	@Override
	public boolean doUpdate(User vo) throws Exception {
		String sql ="UPDATE  user SET name=?,password=?,identity=? WHERE id=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, vo.getName());
		this.pstmt.setString(2, vo.getPassword());
		this.pstmt.setString(3, vo.getIdentity());
		this.pstmt.setString(4, vo.getId());		
		return this.pstmt.executeUpdate() > 0;
	}

	@Override
	public boolean doRemove(Set<String> ids) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User findById(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAllSplit(String column, String keyWord, Integer currentPage, Integer lineSize)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getAllCount(String column, String keyWord) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findLogin(User vo) throws SQLException {
		User user = null;
		String sql = "SELECT id, name, password,identity FROM user WHERE id=? AND password=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, vo.getId());
		this.pstmt.setString(2, vo.getPassword());
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			user = new User();
			user.setId(rs.getString(1));
			user.setName(rs.getString(2));
			user.setPassword(rs.getString(3));
			user.setIdentity(rs.getString(4));
		}
		
		return user;
	}

	@Override
	public boolean doUpdateLastDate(String aid, Date date) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doUpdatePassword(String aid, String password) throws SQLException {
		String sql = "UPDATE user SET password=? WHERE id=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, password);
		this.pstmt.setString(2, aid);
		return this.pstmt.executeUpdate() > 0;
	}

}
