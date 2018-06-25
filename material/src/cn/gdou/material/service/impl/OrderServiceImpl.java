package cn.gdou.material.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.gdou.material.dbc.DatabaseConnection;
import cn.gdou.material.entity.Appointment;
import cn.gdou.material.entity.Order;
import cn.gdou.material.factory.DAOFactory;
import cn.gdou.material.factory.ServiceFactory;
import cn.gdou.material.service.OrderService;

public class OrderServiceImpl implements OrderService{
	private DatabaseConnection dbc = new DatabaseConnection();
	
	
	
	@Override
	public boolean insert(Order vo) throws Exception {		
		try {			
			return DAOFactory.getOrderDaoInstance(this.dbc.getConnection()).doCreate(vo);
		}
		catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.dbc.close();
		}
		return false;		
	}

	@Override
	public boolean update(Order vo) throws Exception {
		try {
			return DAOFactory.getOrderDaoInstance(dbc.getConnection()).doUpdate(vo);
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			this.dbc.close();
		}
		return false;
	}

	@Override
	public boolean delete(Set<Integer> ids) throws Exception {
		try {
			return DAOFactory.getOrderDaoInstance(dbc.getConnection()).doRemove(ids);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.dbc.close();			
		}
		return false;
	}

	@Override
	public Order get(Integer id) throws Exception {
		try {
			return DAOFactory.getOrderDaoInstance(dbc.getConnection()).findById(id);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.dbc.close();			
		}
		return null ;
	}

	@Override
	public List<Order> list() throws Exception {
		try {
			return DAOFactory.getOrderDaoInstance(dbc.getConnection()).findAll();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.dbc.close();			
		}
		return null ;
	}

	@Override
	public List<Order> listInPutByColumns(Map<String, String> map) throws Exception {
		try {
			return DAOFactory.getOrderDaoInstance(dbc.getConnection()).findByColumns(map);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.dbc.close();			
		}
		return null ;
	}

	@Override
	public boolean comfirm(Integer id) throws Exception {
		Order od = null ;
		Appointment ap = new Appointment();
		try {
			od = DAOFactory.getOrderDaoInstance(dbc.getConnection()).findById(id);
			if(od != null) {
				ap.setAppointTime(new Date());
				ap.setCompany(od.getCompany());
				ap.setOperator(od.getOperator());
				ap.setGood(od.getGood());
				ap.setNumber(od.getNumber());
				ap.setState(od.getState());
			}
			System.out.println(ap);
			if(ServiceFactory.getAppointmentServiceInstance().insert(ap)) {
				return DAOFactory.getOrderDaoInstance(dbc.getConnection()).changeSignById(id, 1);
				
			};
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.dbc.close();	
		}
		return false ;
	}

	@Override
	public boolean refute(Integer id) throws Exception {
		try {
			return DAOFactory.getOrderDaoInstance(dbc.getConnection()).changeSignById(id, -1);
			 
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.dbc.close();	
		}
		return false ;
	}

}
