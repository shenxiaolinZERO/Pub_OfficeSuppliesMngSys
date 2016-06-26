package cn.fjnu.officeSystem.serviceImpl;

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
public class BorrowApplyServiceTest {

	@Resource
	BorrowApplyService borrowApplyService;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetAuditBorrowApplies() {
		String json = "{\"pageIndex\": 1,\"pageCount\": 5}";
		System.out.println("test" + borrowApplyService.getAuditBorrowApplies(json));
	}

	@Test
	public void testDeleteAuditBorrowApply() {
	}

	@Test
	public void testGetUnAuditBorrowApplies() {
		String json = "{\"pageIndex\": 1,\"pageCount\": 2}";
		System.out.println("test" + borrowApplyService.getUnAuditBorrowApplies(json));
	}

	@Test
	public void testOperateAudit() {
		String json = "{\"operate\": 1,\"id\": \"11\",\"auditId\": \"1\"}";
		borrowApplyService.operateBorrowAudit(json);
	}
	
	@Test
	public void testUserCurrentBorrowApply(){
		String json = "{\"pageIndex\": 1,\"pageCount\": 5,\"itemId\":\"it001605150000\",\"itemName\":\"物品名称\",\"itemTypeId\":\"1\"}";
		System.out.println("test" + borrowApplyService.userCurrentBorrowApply(json));
	}
	
	@Test
	public void testSubmitBorrowApply(){
		String json = "{\"BorrowNum\": 1,\"borrower\": 2,\"id\": \"1\"}";
		System.out.println("test" + borrowApplyService.submitBorrowApply(json));
	}
	
	@Test
	public void testUserHistoryBorrowApply(){
		String json = "{\"pageIndex\": 1,\"pageCount\": 5,\"borrower\":\"1\"}";
		System.out.println("test" + borrowApplyService.userHistoryBorrowApply(json));
	}

}
