package cn.gdou.material.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.gdou.material.dbc.DatabaseConnection;
import cn.gdou.material.entity.Appointment;
import cn.gdou.material.entity.Good;
import cn.gdou.material.factory.DAOFactory;
import cn.gdou.material.service.AppointmentService;

public class AppointmentServiceImpl implements AppointmentService{
	private DatabaseConnection dbc = new DatabaseConnection();
	@Override
	public boolean insert(Appointment vo) throws Exception {
		try {
			
		if(vo != null ) {		
			/*
			 * 如果订单是属于入库，则执行下面步骤
			 * 1。执行检查 如果存在该商品 进行update，如果不存在，则进行insert。
			 * 2。执行原本业务。
			 * 
			 */
			if (vo.getState() == 1) {
				Good good = DAOFactory.getGoodDaoInstance(dbc.getConnection()).findById(vo.getGood().getGoodId()); 
				if( good  == null) {
					//执行插入新商品操作					
					DAOFactory.getGoodDaoInstance(dbc.getConnection()).doCreate(vo.getGood());
					return DAOFactory.getAppointmentDaoInstance(dbc.getConnection()).doCreate(vo);
				}else {					
					int nb1 = good.getNumber();
					int nb2 = vo.getNumber();
					good.setNumber(nb1+nb2);
					//执行更新操作
					 DAOFactory.getGoodDaoInstance(dbc.getConnection()).doUpdate(good);	
					 return DAOFactory.getAppointmentDaoInstance(dbc.getConnection()).doCreate(vo);
				}
				
			}else if (vo.getState() == 0){
				/*
				 * 如果订单是属于出库，则执行下面步骤
				 * 1。执行检查 如果存在该商品且数量足够，进行update并加入该订单。如果数量不够，则报错。
				 * 2。如果不存在，则报错。
				 */
				Good good = DAOFactory.getGoodDaoInstance(dbc.getConnection()).findById(vo.getGood().getGoodId());
				if( good  == null) {
					//不存在 报错
					return false;
				}else {
					//检查是否数量足够
					int nb1 = vo.getNumber();
					int nb2 = good.getNumber();
					if(nb1 <= nb2) {
						//数量足够 执行update操作
						good.setNumber(nb2 - nb1);
						DAOFactory.getGoodDaoInstance(dbc.getConnection()).doUpdate(good);					
						//执行订单出库操作
						return DAOFactory.getAppointmentDaoInstance(dbc.getConnection()).doCreate(vo);
					}else {
						return false ;
					}
					
				}
			}
		}
		}catch (Exception e) {
			throw e ;
		}finally {
			this.dbc.close();
		}
		return false;
	}
	
	/**
	 * 执行订单修改操作 对原有订单进行修改  
	 * 但是需要自己对商品库存数据进行修改
	 */
	@Override
	public boolean update(Appointment vo) throws Exception {
		try {
			return DAOFactory.getAppointmentDaoInstance(dbc.getConnection()).doUpdate(vo);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
	}
	/**
	 * 执行订单修改操作 对原有订单进行修改  
	 * 但是需要自己对商品库存数据进行修改
	 */
	@Override
	public boolean delete(Set<Integer> ids) throws Exception {
		try {
			return DAOFactory.getAppointmentDaoInstance(dbc.getConnection()).doRemove(ids);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
	}

	@Override
	public Appointment get(Integer id) throws Exception {
		try {
			return DAOFactory.getAppointmentDaoInstance(dbc.getConnection()).findById(id);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
	}

	@Override
	public List<Appointment> list() throws Exception {
		try {
			return DAOFactory.getAppointmentDaoInstance(dbc.getConnection()).findAll();
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
	}

	@Override
	public List<Appointment> InPutlist() throws Exception {
		try {
			return DAOFactory.getAppointmentDaoInstance(dbc.getConnection()).findAllInPut();
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
	}

	@Override
	public List<Appointment> OutPutlist() throws Exception {
		try {
			return DAOFactory.getAppointmentDaoInstance(dbc.getConnection()).findAllOutPut();
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
	}

	@Override
	public List<Appointment> listOutPutByColumn(String column, String keyWord) throws Exception {
		try {
			return DAOFactory.getAppointmentDaoInstance(dbc.getConnection()).findOutPutByColumn(column, keyWord);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
	}

	@Override
	public List<Appointment> listInPutByColumn(String column, String keyWord) throws Exception {
		try {
			return DAOFactory.getAppointmentDaoInstance(dbc.getConnection()).findInPutByColumn(column, keyWord);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
	}

	@Override
	public List<Appointment> listInPutByColumns(Map<String, String> map) throws Exception {
		try {
			return DAOFactory.getAppointmentDaoInstance(dbc.getConnection()).findInPutByColumns(map);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
	}

	
	

}
