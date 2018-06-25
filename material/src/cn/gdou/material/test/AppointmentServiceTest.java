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
		vo.setCompany("��������6");
		vo.setOperator("��������5");
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
			List<Appointment> Appointments = ServiceFactory.getAppointmentServiceInstance().listInPutByColumn("operator", "��������");
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
		map.put("company", "��������3");
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
			List<Appointment> Appointments = ServiceFactory.getAppointmentServiceInstance().listOutPutByColumn("operator", "��������");
			for(Appointment vo : Appointments) {
				System.out.println(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
