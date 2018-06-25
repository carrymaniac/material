package cn.gdou.material.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.gdou.material.dbc.DatabaseConnection;
import cn.gdou.material.entity.Good;
import cn.gdou.material.factory.DAOFactory;
import cn.gdou.material.service.GoodService;

public class GoodServiceImpl implements GoodService{
	private DatabaseConnection dbc = new DatabaseConnection();
	@Override
	public boolean insert(Good vo) throws Exception {
		try {
			if (DAOFactory.getGoodDaoInstance(this.dbc.getConnection()).findById(vo.getGoodId()) == null) {
				return DAOFactory.getGoodDaoInstance(this.dbc.getConnection()).doCreate(vo) ;
			}
			return false;
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
	}

	@Override
	public boolean update(Good vo) throws Exception {
		try {
			return DAOFactory.getGoodDaoInstance(this.dbc.getConnection()).doUpdate(vo);
		}catch(Exception e){
			throw e;
		}finally {
			this.dbc.close();
		}
		
	}

	@Override
	public boolean delete(Set<Integer> ids) throws Exception {
		try {
			if(ids.size() == 0) {//没有要删除的数据
				return false ;
			}
			return DAOFactory.getGoodDaoInstance(this.dbc.getConnection()).doRemove(ids);
		}catch (Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
		
	}

	@Override
	public Good get(Integer id) throws Exception {
		try {
			return DAOFactory.getGoodDaoInstance(this.dbc.getConnection()).findById(id);
		}catch(Exception e){
			throw e;
		}finally {
			this.dbc.close();
		}
		
	}

	@Override
	public List<Good> list() throws Exception {
		try {
			return DAOFactory.getGoodDaoInstance(this.dbc.getConnection()).findAll();
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
	}

	@Override
	public List<Good> listDetails() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> listSplit(String column, String keyWord, int currentPage, int lineSize)
			throws Exception {
		try{Map<String,Object> map = new HashMap<String,Object>() ;
		map.put("allEmps", DAOFactory.getGoodDaoInstance(this.dbc.getConnection()).findAllSplit(column, keyWord, currentPage, lineSize)) ;
		map.put("empCount", DAOFactory.getGoodDaoInstance(this.dbc.getConnection()).getAllCount(column, keyWord)) ;
		return map ;}
		catch(Exception e){
			throw e;
		}finally {
			this.dbc.close();
		}
	}

	@Override
	public List<Good> listByColumn(String column, String keyWord) throws Exception {
		try {
			return DAOFactory.getGoodDaoInstance(this.dbc.getConnection()).findByColumn(column, keyWord);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
	}

}
