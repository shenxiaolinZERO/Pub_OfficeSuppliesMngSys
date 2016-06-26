package cn.fjnu.officeSystem.serviceImpl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import javax.annotation.Resource;

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
@ContextConfiguration(locations = { "classpath*:springmvc.xml", "classpath*:applicationContext.xml" })
@ActiveProfiles("production")
public class OutStorageServiceTest {

	@Resource
	OutStorageService outStorageService;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetOutstorageType() {
		System.out.println(outStorageService.getOutstorageType());
	}

	@Test
	public void testGetOutstorageHome() {
		String json = "{\"outStorageTypeId\":\"3\",\"pageIndex\": 1,\"pageCount\": 5}";
		System.out.println("test" + outStorageService.getOutstorageHome(json));
	}

	@Test
	public void testOperateOutStorageCheckIn() {
//		String json = "{\"outStorageCheckIn\": {\"outStorageTypeId\":1,\"recipienter\": 1,"
//				+ "\"departmentId\":1,\"operaterId\":2,\"applyId\":\"1_2_3\","
//				+ "\"totalNumber\":20,\"totalMonney\":1000,\"remark\": \"备注\"},\"borrowApply\": {\"itemId\": \"1\","
//				+ "\"itemName\": \"苹果\",\"itemTypeId\": 1,\"spec\": \"规格\",\"price\": 20,\"borrower\": 1,"
//				+ "\"remark\": \"备注\" },\"outStorageTypeId\":1}";
		String json="{\"outStorageTypeId\":\"3\",\"id\": 2,\"operaterId\": 2,\"recipienter\":\"1\",\"number\": 1}";
		System.out.println(outStorageService.operateOutStorageCheckIn(json));
	}
	/*3    4
	 * {\"idList\": [{\"id\":\"1\"}],\"operaterId\":\"1\"}
	 * { "outStorageCheckIn": { "out_storage_type_id": 1, "recipienter": 1,
	 * "department_id": 1, "operater_id": 2, "apply_id": "1_2_3",
	 * "total_number": 20, "total_monney": 1000, "remark": "备注" },
	 * "borrowApply": { "item_id": 1, "item_name": "苹果", "item_type_id": 1,
	 * "spec": "规格", "price": 20, "remark": "备注" }, "outStorageTypeId": 1 }
	 * 	
	 * 
	 */
	
	@Test
	public void testGetOutstorageSummary(){
		String json="{\"outStorageTypeId\":\"-1\",\"pageIndex\": 1,\"pageCount\": 5,\"startTime\":\"-1\",\"endTime\":\"-1\","
				+ "\"itemTypeId\":\"-1\",\"itemName\":\"-1\"}";
		System.out.println("test:" + outStorageService.getOutstorageSummary(json));
	}
	
	/* //2016-05-15 13:18:52
		//2016-06-11 15:38:31
		String json="{\"pageIndex\":1,\"pageCount\":1,\"startTime\":\"-1\",\"endTime\":\"-1\","
		+ "\"itemTypeId\":\"-1\",\"itemName\":\"-1\",\"inStorageTypeId\":\"-1\"}";
	 */
	
	@Test
	public void operateOutStorageCheckInPL(){
//		String json="{\"outStorageTypeId\":\"1\",\"idList\": [{\"id\":\"7\"},{\"id\":\"8\"},{\"id\":\"9\"}],\"operaterId\": 2,\"recipienter\":\"1\",\"number\": 1}";
		String json="{\"outStorageTypeId\":\"2\",\"idList\": [{\"id\":\"2\"},{\"id\":\"3\"}],\"operaterId\": 2}";
		System.out.println(outStorageService.operateOutStorageCheckInPL(json));
	}

}
