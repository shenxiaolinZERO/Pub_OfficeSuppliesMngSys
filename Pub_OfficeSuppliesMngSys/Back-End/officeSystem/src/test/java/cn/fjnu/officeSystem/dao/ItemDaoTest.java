package cn.fjnu.officeSystem.dao;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import cn.fjnu.officeSystem.entity.Item;
import net.sf.json.JSONArray;
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"classpath*:springmvc.xml","classpath*:applicationContext.xml"})
@ActiveProfiles("production")
public class ItemDaoTest {
	@Resource
	ItemDao itemDao;
	@Resource
	SupplierDao supplierDao;
	@Resource
	BorrowApplyDao borrowApply;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInsertItem() {
		Item item=new Item();
		item.setItemTypeId("typeId");
		item.setMaxInventory(50);
		item.setMinInventory(10);
		item.setItemName("商品名");
		item.setSpec("spec");
		item.setSupplierId("111");
		item.setMeasureUnitId("measureUnitId");
		itemDao.insertItem(item);
		
		
	}
	@Test
	public void testselectMerchantsAvailabilityDetailBysupplierId(){
		System.out.println(supplierDao.selectMerchantsAvailabilityDetailBySupplierId("1"));
		
	}
	@Test
	public void testselectInStorageBorrowApplies(){
		
		
	}

}
