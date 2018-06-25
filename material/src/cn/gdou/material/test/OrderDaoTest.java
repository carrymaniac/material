package cn.gdou.material.test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import cn.gdou.material.dbc.DatabaseConnection;
import cn.gdou.material.entity.Good;
import cn.gdou.material.entity.Order;
import cn.gdou.material.factory.DAOFactory;

public class OrderDaoTest {
	private DatabaseConnection dbc = new DatabaseConnection();
	@Test
	public void testInsert() {
		Order od = new Order();
		Good good = new Good();
		good.setGoodId(1);
		od.setGood(good);
		od.setCompany("º£´ó");
		od.setNumber(1000);
		od.setOrderTime(new Date());
		od.setState(0);
		od.setSign(0);
		
		try {
			System.out.println(DAOFactory.getOrderDaoInstance(this.dbc.getConnection()).doCreate(od));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testFind() {
		String name = "1";
		Map<String,String> map = new HashMap<String,String>() ;
		map.put("orderId", "");
		map.put("ordertime", "");
		map.put("goodid", name);
		map.put("company", "");
		map.put("number", "");
		map.put("operator", "");
		map.put("state", "");
		map.put("sign", "");
		try {
			System.out.println(DAOFactory.getOrderDaoInstance(this.dbc.getConnection()).findByColumns(map));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Test
	public void TestChange() {
		int i = 1 ;
		int s = 1 ;
		try {
			System.out.println(DAOFactory.getOrderDaoInstance(this.dbc.getConnection()).changeSignById(i, s));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
