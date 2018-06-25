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
			 * ���������������⣬��ִ�����沽��
			 * 1��ִ�м�� ������ڸ���Ʒ ����update����������ڣ������insert��
			 * 2��ִ��ԭ��ҵ��
			 * 
			 */
			if (vo.getState() == 1) {
				Good good = DAOFactory.getGoodDaoInstance(dbc.getConnection()).findById(vo.getGood().getGoodId()); 
				if( good  == null) {
					//ִ�в�������Ʒ����					
					DAOFactory.getGoodDaoInstance(dbc.getConnection()).doCreate(vo.getGood());
					return DAOFactory.getAppointmentDaoInstance(dbc.getConnection()).doCreate(vo);
				}else {					
					int nb1 = good.getNumber();
					int nb2 = vo.getNumber();
					good.setNumber(nb1+nb2);
					//ִ�и��²���
					 DAOFactory.getGoodDaoInstance(dbc.getConnection()).doUpdate(good);	
					 return DAOFactory.getAppointmentDaoInstance(dbc.getConnection()).doCreate(vo);
				}
				
			}else if (vo.getState() == 0){
				/*
				 * ������������ڳ��⣬��ִ�����沽��
				 * 1��ִ�м�� ������ڸ���Ʒ�������㹻������update������ö�������������������򱨴�
				 * 2����������ڣ��򱨴�
				 */
				Good good = DAOFactory.getGoodDaoInstance(dbc.getConnection()).findById(vo.getGood().getGoodId());
				if( good  == null) {
					//������ ����
					return false;
				}else {
					//����Ƿ������㹻
					int nb1 = vo.getNumber();
					int nb2 = good.getNumber();
					if(nb1 <= nb2) {
						//�����㹻 ִ��update����
						good.setNumber(nb2 - nb1);
						DAOFactory.getGoodDaoInstance(dbc.getConnection()).doUpdate(good);					
						//ִ�ж����������
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
	 * ִ�ж����޸Ĳ��� ��ԭ�ж��������޸�  
	 * ������Ҫ�Լ�����Ʒ������ݽ����޸�
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
	 * ִ�ж����޸Ĳ��� ��ԭ�ж��������޸�  
	 * ������Ҫ�Լ�����Ʒ������ݽ����޸�
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
