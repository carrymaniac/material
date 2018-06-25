package cn.gdou.material.test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import cn.gdou.material.entity.Appointment;
import cn.gdou.material.entity.Good;
import cn.gdou.material.factory.ServiceFactory;
import junit.framework.TestCase;

public class AppointmentServiceTest {
	@Test
	public void TestInsert() {
		Good gd = new Good();
		gd.setGoodId(1);
		Appointment vo = new Appointment();
		vo.setAppointTime(new Date());
		vo.setGood(gd);
		vo.setCompany("测试数据6");
		vo.setOperator("测试数据5");
		vo.setNumber(100);
		vo.setState(1);
		try {
			TestCase.assertTrue(ServiceFactory.getAppointmentServiceInstance().insert(vo));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void TestList() {
		try {
			TestCase.assertTrue(ServiceFactory.getAppointmentServiceInstance().list().size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testInPutSearch() {
		try {
			List<Appointment> Appointments = ServiceFactory.getAppointmentServiceInstance().listInPutByColumn("operator", "测试数据");
			for(Appointment vo : Appointments) {
				System.out.println(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testInPutSearchs() {
		Map<String,String> map = new HashMap<String,String>() ;
		map.put("appointmentId", "");
		map.put("appointtime", "24");
		map.put("goodid", "");
		map.put("company", "测试数据3");
		map.put("number", "");
		
		try {
			List<Appointment> Appointments = ServiceFactory.getAppointmentServiceInstance().listInPutByColumns(map);
			for(Appointment vo : Appointments) {
				System.out.println(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testOutPutSearch() {
		try {
			List<Appointment> Appointments = ServiceFactory.getAppointmentServiceInstance().listOutPutByColumn("operator", "测试数据");
			for(Appointment vo : Appointments) {
				System.out.println(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
