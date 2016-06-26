package cn.fjnu.officeSystem.serviceImpl;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"classpath*:springmvc.xml","classpath*:applicationContext.xml"})
@ActiveProfiles("production")
public class InStorageServiceTest {
	@Resource
	InStorageCheckInService inStorageService;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetInstorageType() {
		System.out.println(inStorageService.getInstorageType());
		
	}

	@Test
	public void testGetInstorageHome() {
		String json="{\"inStorageTypeId\":\"1\",\"pageIndex\": 1,\"pageCount\": 1}";
		System.out.println(inStorageService.getInstorageHome(json));
	}
	@Test 
	public void testAdditemType(){
		
		
	}
	@Test
	public void testsendInStorage(){
	   String json="{\"item\": {\"maxInventory\":50,\"minInventory\": 10,"
	   		+ "\"itemName\":\"物品名称\",\"spec\":\"规格型号\",\"itemTypeId\": 1,\"measureUnitId\": 1,"
	   				+ "\"remark\":\"备注\"},\"InStorageCheckIn\": {\"totalNumber\": 10,"
	   				+ "\"operaterId\": 1,"
	   				+ "\"remark\": \"备注\" }}";
	   System.out.println(inStorageService.sendInStorage(json));
	}
	@Test
	public void testprocurementInStorage(){
		String json="{\"idList\": [{\"id\":\"1\"}],\"operaterId\":\"1\"}";
		System.out.println(inStorageService.procurementInStorage(json));
	}
	@Test
	public void testreturnInStorage(){
		String json="{\"idList\": [{\"id\":\"1\"}],\"operaterId\":\"1\"}";
		System.out.println(inStorageService.returnInStorage(json));
	}
	@Test
	public void testgetItemProcurementByMap(){
		System.out.println(inStorageService.getItemProcurementByMap("1", "1", "1"));
	}
	@Test
	public void testgetBorrowApplyByMap(){
		System.out.println(inStorageService.getBorrowApplyByMap("1", "1", "1"));
	}
	@Test
	public void testgetInstorageSumary(){
		String json="{\"pageIndex\":1,\"pageCount\":1,"
				+ "\"supplierId\": \"1\",\"agentId\":\"1\","
				+ "\"operaterId\": \"1\",\"itemProcurementId\":\"1\"}";
		System.out.println(inStorageService.getInstorageSumary(json));
	}

}
