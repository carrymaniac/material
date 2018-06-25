package cn.gdou.material.test;

import org.junit.Test;

import cn.gdou.material.dbc.DatabaseConnection;
import cn.gdou.material.entity.User;
import cn.gdou.material.factory.DAOFactory;
import cn.gdou.material.util.MD5Code;


public class UserDaoTest {
	private DatabaseConnection dbc = new DatabaseConnection();
	@Test
	public void testInsert() {
		User user = new User(); 
		user.setId("digua");
		user.setPassword(new MD5Code().getMD5ofStr("123456"));
		user.setIdentity("0");
		user.setName("Ð¡µØ¹Ï");
		try {
			
			System.out.println(DAOFactory.getUserDaoInstance(this.dbc.getConnection()).doCreate(user));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
