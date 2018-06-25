package cn.gdou.material.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.gdou.material.dao.OrderDao;
import cn.gdou.material.entity.Good;
import cn.gdou.material.entity.Order;

public class OrderDaoImpl implements OrderDao {
	private Connection conn;
	private PreparedStatement pstmt;
	
	public OrderDaoImpl(Connection conn) {
		this.conn = conn;
	}
	@Override
	public boolean doCreate(Order vo) throws Exception {
		String sql ="INSERT INTO orders (orderId,ordertime,goodid,operator,company,number,state,sign) VALUES (?,?,?,?,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, vo.getOrderId());
		this.pstmt.setTimestamp(2, new Timestamp (vo.getOrderTime().getTime()));
		if(vo.getGood() != null) {//说明有产品信息
			this.pstmt.setInt(3,vo.getGood().getGoodId() );
		}else {
			this.pstmt.setNull(3, Types.NULL);
		}
		this.pstmt.setString(4, vo.getOperator());
		this.pstmt.setString(5,vo.getCompany());
		this.pstmt.setInt(6,(int)vo.getNumber());
		this.pstmt.setInt(7,vo.getState());
		this.pstmt.setInt(8, vo.getSign());
		
		return this.pstmt.executeUpdate() > 0 ;
	}

	@Override
	public boolean doUpdate(Order vo) throws Exception {
		String sql ="UPDATE orders set orderId=?,ordertime=?,goodid=?,operator=?,company=?,number=?,state=?,sign=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, vo.getOrderId());
		this.pstmt.setTimestamp(2, new Timestamp (vo.getOrderTime().getTime()));
		if(vo.getGood() != null) {//说明有产品信息
			this.pstmt.setInt(3,vo.getGood().getGoodId() );
		}else {
			this.pstmt.setNull(3, Types.NULL);
		}
		this.pstmt.setString(4, vo.getOperator());
		this.pstmt.setString(5,vo.getCompany());
		this.pstmt.setInt(6,(int)vo.getNumber());
		this.pstmt.setInt(7,vo.getState());
		
		return this.pstmt.executeUpdate() > 0;
	}

	@Override
	public boolean doRemove(Set<Integer> ids) throws Exception {
		StringBuffer buf = new StringBuffer();
		buf.append("DELETE FROM orders WHERE orderId IN (");
		Iterator<Integer> iter = ids.iterator();
		while (iter.hasNext()) {
			buf.append(iter.next()).append(",");
		}
		buf.delete(buf.length() - 1, buf.length()).append(")");
		this.pstmt = this.conn.prepareStatement(buf.toString());
		return this.pstmt.executeUpdate() == ids.size();
	}

	@Override
	public Order findById(Integer id) throws Exception {
		Order vo = null ;
		Good gd = null ;
		String sql = "SELECT orderId,ordertime,goodid,operator,company,number,state,sign FROM orders WHERE orderId=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, id);
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			vo = new Order();
			gd = new Good(); 
			vo.setOrderId(rs.getInt(1));
			vo.setOrderTime(new Date(rs.getTimestamp(2).getTime()));
			gd.setGoodId(rs.getInt(3));
			vo.setGood(gd);
			vo.setOperator(rs.getString(4));
			vo.setCompany(rs.getString(5));
			vo.setNumber(rs.getInt(6));
			vo.setState(rs.getInt(7));
			vo.setSign(rs.getInt(8));
		}
		
		return vo;
	}

	@Override
	public List<Order> findAll() throws Exception {
		List<Order> all = new ArrayList<Order>();
		String sql = "SELECT orderId,ordertime,goodid,operator,company,number,state,sign FROM orders ";
		this.pstmt = this.conn.prepareStatement(sql);
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			Order vo = new Order();
			Good gd = new Good(); 
			vo.setOrderId(rs.getInt(1));
			vo.setOrderTime(new Date(rs.getTimestamp(2).getTime()));
			gd.setGoodId(rs.getInt(3));
			vo.setGood(gd);
			vo.setOperator(rs.getString(4));
			vo.setCompany(rs.getString(5));
			vo.setNumber(rs.getInt(6));
			vo.setState(rs.getInt(7));
			vo.setSign(rs.getInt(8));
			all.add(vo);
		}
		return all;
	}
	
	@Override
	public List<Order> findByColumns(Map<String, String> map) throws Exception {
		List<Order> all = new ArrayList<Order>();
		String KeyWord2 = map.get("ordertime").trim();
		String KeyWord3 = map.get("goodid").trim();	
		String KeyWord4 = map.get("company").trim();
		String KeyWord5 = map.get("operator").trim();
		String KeyWord6 = map.get("number").trim();
		String KeyWord7 = map.get("state").trim();
		String KeyWord8 = map.get("sign").trim();
		
		StringBuilder sql =  new StringBuilder("SELECT orderId,ordertime,goodid,operator,company,number,state,sign FROM orders "
				+ "WHERE orderId like '%%' ");	
		if (!KeyWord2.isEmpty()) {
			sql.append(" and ordertime like '%" + KeyWord2 + "%' ");
		}
		if (!KeyWord3.isEmpty()) {
			sql.append(" and goodid like '%" + KeyWord3 + "%' ");
		}
		if (!KeyWord4.isEmpty()) {
			sql.append(" and company like '%" + KeyWord4 + "%' ");
		}
		if (!KeyWord5.isEmpty()) {
			sql.append(" and operator like '%" + KeyWord5 + "%' ");
		}
		if (!KeyWord6.isEmpty()) {
			sql.append(" and number like '%" + KeyWord6 + "%' ");
		}
		if (!KeyWord7.isEmpty()) {
			sql.append(" and state like '%" + KeyWord7 + "%' ");
		}
		if (!KeyWord8.isEmpty()) {
			sql.append(" and sign like '%" + KeyWord8 + "%' ");
		}
		this.pstmt = this.conn.prepareStatement(sql.toString());
		ResultSet rs = this.pstmt.executeQuery();
		
		while (rs.next()) {
			Order vo = new Order();
			Good gd = new Good(); 
			vo.setOrderId(rs.getInt(1));
			vo.setOrderTime(new Date(rs.getTimestamp(2).getTime()));
			gd.setGoodId(rs.getInt(3));
			vo.setGood(gd);
			vo.setOperator(rs.getString(4));
			vo.setCompany(rs.getString(5));
			vo.setNumber(rs.getInt(6));
			vo.setState(rs.getInt(7));
			vo.setSign(rs.getInt(8));
			all.add(vo);
		}
		return all;
	}
	
	
	
	@Override
	public List<Order> findAllSplit(String column, String keyWord, Integer currentPage, Integer lineSize)
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
	public Boolean changeSignById(int id, int sign) throws Exception {
		String sql ="UPDATE orders set sign=? WHERE orderId = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, sign);
		this.pstmt.setInt(2, id);
		return this.pstmt.executeUpdate() > 0;
	}


}
