package cn.gdou.material.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import cn.gdou.material.entity.Good;
import cn.gdou.material.factory.ServiceFactory;
import junit.framework.TestCase;

public class GoodServiceTest {
	
	@Test
	public void testInsert() {
		Good vo = new Good();
		vo.setGoodId(4);
		vo.setName("小米手机6");
		vo.setNumber(100000);
		vo.setFactory("小米");
		vo.setSpecifications("8g内存");
		try {
			TestCase.assertTrue(ServiceFactory.getGoodServiceInstance().insert(vo));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testDelete() {
		Set<Integer> set = new HashSet<Integer>();
		set.add(4);
		try {
			TestCase.assertTrue(ServiceFactory.getGoodServiceInstance().delete(set));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testSearch() {
		try {
			List<Good> Good = ServiceFactory.getGoodServiceInstance().listByColumn("name", "手机");
			for(Good vo : Good) {
				System.out.println(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
