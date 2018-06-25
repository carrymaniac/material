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

import cn.gdou.material.dao.AppointmentDao;
import cn.gdou.material.entity.Appointment;
import cn.gdou.material.entity.Good;

public class AppointmentDaoImpl implements AppointmentDao{
	private Connection conn;
	private PreparedStatement pstmt;
	
	public AppointmentDaoImpl(Connection conn) {
		this.conn = conn;
	}
	@Override
	public boolean doCreate(Appointment vo) throws Exception {
		String sql ="INSERT INTO appointment (appointmentId,appointtime,goodid,operator,company,number,state) VALUES (?,?,?,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, vo.getAppointmentId());
		this.pstmt.setTimestamp(2, new Timestamp (vo.getAppointTime().getTime()));
		if(vo.getGood() != null) {//说明有产品信息
			this.pstmt.setInt(3,vo.getGood().getGoodId() );
		}else {
			this.pstmt.setNull(3, Types.NULL);
		}
		this.pstmt.setString(4, vo.getOperator());
		this.pstmt.setString(5,vo.getCompany());
		this.pstmt.setInt(6,(int)vo.getNumber());
		this.pstmt.setInt(7,vo.getState());
		
		return this.pstmt.executeUpdate() > 0 ;
		
	}

	@Override
	public boolean doUpdate(Appointment vo) throws Exception {
		String sql ="UPDATE appointment set appointmentId=?,appointtime=?,goodid=?,operator=?,company=?,number=?,state=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, vo.getAppointmentId());
		this.pstmt.setTimestamp(2, new Timestamp (vo.getAppointTime().getTime()));
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
		buf.append("DELETE FROM appointment WHERE appointmentId IN (");
		Iterator<Integer> iter = ids.iterator();
		while (iter.hasNext()) {
			buf.append(iter.next()).append(",");
		}
		buf.delete(buf.length() - 1, buf.length()).append(")");
		this.pstmt = this.conn.prepareStatement(buf.toString());
		return this.pstmt.executeUpdate() == ids.size();
	}

	@Override
	public Appointment findById(Integer id) throws Exception {
		Appointment vo = null ;
		Good gd = null ;
		String sql = "SELECT appointmentId,appointtime,goodid,operator,company,number,state FROM appointment WHERE appointmentId=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, id);
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			vo = new Appointment();
			gd = new Good(); 
			vo.setAppointmentId(rs.getInt(1));
			vo.setAppointTime(new Date(rs.getTimestamp(2).getTime()));
			gd.setGoodId(rs.getInt(3));
			vo.setGood(gd);
			vo.setOperator(rs.getString(4));
			vo.setCompany(rs.getString(5));
			vo.setNumber(rs.getInt(6));
			vo.setState(rs.getInt(7));
		}
		
		return vo;
	}

	@Override
	public List<Appointment> findAll() throws Exception {
		List<Appointment> all = new ArrayList<Appointment>();
		String sql = "SELECT appointmentId,appointtime,goodid,operator,company,number,state FROM appointment";
		this.pstmt = this.conn.prepareStatement(sql);
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			Appointment vo = new Appointment();
			Good gd = new Good(); 
			vo.setAppointmentId(rs.getInt(1));
			vo.setAppointTime(new Date(rs.getTimestamp(2).getTime()));
			gd.setGoodId(rs.getInt(3));
			vo.setGood(gd);
			vo.setOperator(rs.getString(4));
			vo.setCompany(rs.getString(5));
			vo.setNumber(rs.getInt(6));
			vo.setState(rs.getInt(7));
			all.add(vo) ;
		}
		return all;
	}

	@Override
	public List<Appointment> findAllSplit(String column, String keyWord, Integer currentPage, Integer lineSize)
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
	public List<Appointment> findAllInPut() throws Exception {
		List<Appointment> all = new ArrayList<Appointment>();
		String sql = "SELECT appointmentId,appointtime,goodid,operator,company,number FROM appointment WHERE state = 1";
		this.pstmt = this.conn.prepareStatement(sql);
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			Appointment vo = new Appointment();
			Good gd = new Good(); 
			vo.setAppointmentId(rs.getInt(1));
			vo.setAppointTime(new Date(rs.getTimestamp(2).getTime()));
			gd.setGoodId(rs.getInt(3));
			vo.setGood(gd);
			vo.setOperator(rs.getString(4));
			vo.setCompany(rs.getString(5));
			vo.setNumber(rs.getInt(6));
			all.add(vo) ;
		}
		return all;
	}
	@Override
	public List<Appointment> findAllOutPut() throws Exception {
		List<Appointment> all = new ArrayList<Appointment>();
		String sql = "SELECT appointmentId,appointtime,goodid,operator,company,number FROM appointment WHERE state = 0";
		this.pstmt = this.conn.prepareStatement(sql);
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			Appointment vo = new Appointment();
			Good gd = new Good(); 
			vo.setAppointmentId(rs.getInt(1));
			vo.setAppointTime(new Date(rs.getTimestamp(2).getTime()));
			gd.setGoodId(rs.getInt(3));
			vo.setGood(gd);
			vo.setOperator(rs.getString(4));
			vo.setCompany(rs.getString(5));
			vo.setNumber(rs.getInt(6));
			all.add(vo) ;
		}
		return all;
	}
	@Override
	public List<Appointment> findOutPutByColumn(String column, String keyWord) throws Exception {
		List<Appointment> all = new ArrayList<Appointment>();
		String sql = "SELECT appointmentId,appointtime,goodid,operator,company,number FROM appointment WHERE state = 0 AND  " + column + " LIKE ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyWord + "%");
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			Appointment vo = new Appointment();
			Good gd = new Good(); 
			vo.setAppointmentId(rs.getInt(1));
			vo.setAppointTime(new Date(rs.getTimestamp(2).getTime()));
			gd.setGoodId(rs.getInt(3));
			vo.setGood(gd);
			vo.setOperator(rs.getString(4));
			vo.setCompany(rs.getString(5));
			vo.setNumber(rs.getInt(6));
			all.add(vo) ;
		}
		return all;
	}
	@Override
	public List<Appointment> findInPutByColumn(String column, String keyWord) throws Exception {
		List<Appointment> all = new ArrayList<Appointment>();
		String sql = "SELECT appointmentId,appointtime,goodid,operator,company,number FROM appointment WHERE state = 1 AND  " + column + " LIKE ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyWord + "%");
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			Appointment vo = new Appointment();
			Good gd = new Good(); 
			vo.setAppointmentId(rs.getInt(1));
			vo.setAppointTime(new Date(rs.getTimestamp(2).getTime()));
			gd.setGoodId(rs.getInt(3));
			vo.setGood(gd);
			vo.setOperator(rs.getString(4));
			vo.setCompany(rs.getString(5));
			vo.setNumber(rs.getInt(6));
			all.add(vo) ;
		}
		return all;
	}
	@Override
	public List<Appointment> findInPutByColumns(Map<String, String> map) throws Exception {
		List<Appointment> all = new ArrayList<Appointment>();
		String KeyWord1 = map.get("appointmentId").trim();
		String KeyWord2 = map.get("appointtime").trim();
		String KeyWord3 = map.get("goodid").trim();
		
		String KeyWord4 = map.get("company").trim();
		String KeyWord5 = map.get("number").trim();
		
		StringBuilder sql =  new StringBuilder("SELECT appointmentId,appointtime,goodid,operator,company,number FROM appointment "
				+ "WHERE state = 1 ");
		if (!KeyWord1.isEmpty()) {
			sql.append(" and appointmentId like '%" + KeyWord1 + "%' ");
		}
		if (!KeyWord2.isEmpty()) {
			sql.append(" and appointtime like '%" + KeyWord2 + "%' ");
		}
		if (!KeyWord3.isEmpty()) {
			sql.append(" and goodid like '%" + KeyWord3 + "%' ");
		}
		if (!KeyWord4.isEmpty()) {
			sql.append(" and company like '%" + KeyWord4 + "%' ");
		}
		if (!KeyWord5.isEmpty()) {
			sql.append(" and number like '%" + KeyWord5 + "%' ");
		}		
		
		this.pstmt = this.conn.prepareStatement(sql.toString());
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			Appointment vo = new Appointment();
			Good gd = new Good(); 
			vo.setAppointmentId(rs.getInt(1));
			vo.setAppointTime(new Date(rs.getTimestamp(2).getTime()));
			gd.setGoodId(rs.getInt(3));
			vo.setGood(gd);
			vo.setOperator(rs.getString(4));
			vo.setCompany(rs.getString(5));
			vo.setNumber(rs.getInt(6));
			all.add(vo) ;
		}
		return all;
		
		
	}
	

}
