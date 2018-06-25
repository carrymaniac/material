package cn.gdou.material.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import cn.gdou.material.dao.GoodDao;
import cn.gdou.material.entity.Good;

public class GoodDaoImpl implements GoodDao{
	private Connection conn;
	private PreparedStatement pstmt;

	public GoodDaoImpl(Connection conn) {
		this.conn = conn;
	}
	@Override
	public boolean doCreate(Good vo) throws Exception {
		String sql ="INSERT INTO good(good_id,name,factory,specifications,number) VALUES (?,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, vo.getGoodId());
		this.pstmt.setString(2, vo.getName());
		this.pstmt.setString(3, vo.getFactory());
		this.pstmt.setString(4, vo.getSpecifications());
		this.pstmt.setInt(5, vo.getNumber());
		return this.pstmt.executeUpdate() > 0;
	}

	@Override
	public boolean doUpdate(Good vo) throws Exception {
		String sql ="UPDATE  good SET name=?,factory=?,specifications=?,number=? WHERE good_id=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, vo.getName());
		this.pstmt.setString(2, vo.getFactory());
		this.pstmt.setString(3, vo.getSpecifications());
		this.pstmt.setInt(4, vo.getNumber());
		this.pstmt.setInt(5, vo.getGoodId());
		return this.pstmt.executeUpdate() > 0;
		
	}

	@Override
	public boolean doRemove(Set<Integer> ids) throws Exception {
		StringBuffer buf = new StringBuffer();
		buf.append("DELETE FROM good WHERE good_id IN (");
		Iterator<Integer> iter = ids.iterator();
		while (iter.hasNext()) {
			buf.append(iter.next()).append(",");
		}
		buf.delete(buf.length() - 1, buf.length()).append(")");
		this.pstmt = this.conn.prepareStatement(buf.toString());
		return this.pstmt.executeUpdate() == ids.size();
	}

	@Override
	public Good findById(Integer id) throws Exception {
		Good vo = null;
		String sql =" SELECT good_id,name,factory,specifications,number FROM good WHERE good_id=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, id);
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			vo = new Good();
			vo.setGoodId(rs.getInt(1));
			vo.setName(rs.getString(2));
			vo.setFactory(rs.getString(3));
			vo.setSpecifications(rs.getString(4));
			vo.setNumber(rs.getInt(5));
		}
		return vo;
	}

	@Override
	public List<Good> findAll() throws Exception {
		List<Good> all = new ArrayList<Good>();
		String sql = "SELECT good_id,name,factory,specifications,number FROM good";
		this.pstmt = this.conn.prepareStatement(sql);
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			Good vo = new Good();
			vo.setGoodId(rs.getInt(1));
			vo.setName(rs.getString(2));
			vo.setFactory(rs.getString(3));
			vo.setSpecifications(rs.getString(4));
			vo.setNumber(rs.getInt(5));
			all.add(vo);	
		}
		return all;
	}
		
	@Override
	public List<Good> findAllSplit(String column, String keyWord, Integer currentPage, Integer lineSize)
			throws Exception {
//		List<Good> all = new ArrayList<Good>();
//		String sql = "SELECT g.good_id,g.name,factory,specifications,number FROM good";
//		throw new Exception("此方法未实现！") ;
		
		
		return null; 
	}

	@Override
	public Integer getAllCount(String column, String keyWord) throws Exception {
		String sql = "SELECT COUNT(*) FROM good WHERE " + column + " LIKE ? " ;
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyWord + "%");
		ResultSet rs = this.pstmt.executeQuery() ;
		if (rs.next()) {
			return rs.getInt(1) ;
		}
		return null; 
	}
	
	
	@Override
	public List<Good> findAllDetails() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public List<Good> findByColumn(String column, String keyWord) throws Exception {
		List<Good> result = new ArrayList<Good>();
		String sql = "SELECT good_id,name,factory,specifications,number FROM good WHERE " + column + " LIKE ? " ;
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyWord + "%");
		ResultSet rs = this.pstmt.executeQuery() ;
		while (rs.next()) {
			Good vo = new Good();
			vo.setGoodId(rs.getInt(1));
			vo.setName(rs.getString(2));
			vo.setFactory(rs.getString(3));
			vo.setSpecifications(rs.getString(4));
			vo.setNumber(rs.getInt(5));
			result.add(vo);	
		}
		return result; 
	}
	
}
