package cn.gdou.material.factory;

import java.sql.Connection;

import cn.gdou.material.dao.AppointmentDao;
import cn.gdou.material.dao.GoodDao;
import cn.gdou.material.dao.OrderDao;
import cn.gdou.material.dao.UserDao;
import cn.gdou.material.dao.impl.AppointmentDaoImpl;
import cn.gdou.material.dao.impl.GoodDaoImpl;
import cn.gdou.material.dao.impl.OrderDaoImpl;
import cn.gdou.material.dao.impl.UserDaoImpl;




public class DAOFactory {
	public static GoodDao getGoodDaoInstance(Connection conn) {
		return new GoodDaoImpl(conn);
	};
	public static AppointmentDao getAppointmentDaoInstance(Connection conn) {
		return new AppointmentDaoImpl(conn);
	};
	public static UserDao getUserDaoInstance(Connection conn) {
		return new UserDaoImpl(conn);
	}
	public static OrderDao getOrderDaoInstance(Connection conn) {
		return new OrderDaoImpl(conn);
	}
}
