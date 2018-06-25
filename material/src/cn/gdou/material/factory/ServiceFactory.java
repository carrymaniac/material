package cn.gdou.material.factory;

import cn.gdou.material.service.AppointmentService;
import cn.gdou.material.service.GoodService;
import cn.gdou.material.service.OrderService;
import cn.gdou.material.service.UserService;
import cn.gdou.material.service.impl.AppointmentServiceImpl;
import cn.gdou.material.service.impl.GoodServiceImpl;
import cn.gdou.material.service.impl.OrderServiceImpl;
import cn.gdou.material.service.impl.UserServiceImpl;

public class ServiceFactory {
	public static GoodService getGoodServiceInstance() {
		return new GoodServiceImpl(); 
	}
	public static AppointmentService getAppointmentServiceInstance() {
		return new AppointmentServiceImpl() ;
	}
	public static UserService getUserServiceInstance() {
		return new UserServiceImpl() ;
	}
	public static OrderService getOrderServiceInstance() {
		return new OrderServiceImpl() ;
	}
}
