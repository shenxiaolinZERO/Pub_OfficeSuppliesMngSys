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
public class RecipientApplyServiceTest {
	
	@Resource
	RecipientApplyService recipientApplyService;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetAuditRecipientApplies() {
		String json = "{\"pageIndex\": 1,\"pageCount\": 3}";
		System.out.println("test" + recipientApplyService.getAuditRecipientApplies(json));
	}

	@Test
	public void testDeleteAuditRecipientApply() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUnAuditRecipientApplies() {
		String json = "{\"pageIndex\": 1,\"pageCount\": 2}";
		System.out.println("test" + recipientApplyService.getUnAuditRecipientApplies(json));
	}

	@Test
	public void testOperateRecipientAudit() {
		String json = "{\"operate\": 1,\"id\": \"1\",\"auditId\": \"1\"}";
		recipientApplyService.operateRecipientAudit(json);
	}

	@Test
	public void testUserCurrentRecipientApply() {
		String json = "{\"pageIndex\": 1,\"pageCount\": 5,\"itemId\":\"it001605150000\",\"itemName\":\"物品名称\",\"itemTypeId\":\"1\"}";
		System.out.println("test" + recipientApplyService.userCurrentRecipientApply(json));
	}

	@Test
	public void testSubmitRecipientApply() {
		String json = "{\"recipientNum\": 1,\"recipienter\": 2,\"id\": \"1\"}";
		System.out.println("test" + recipientApplyService.submitRecipientApply(json));
	}

	@Test
	public void testUserHistoryRecipientApply() {
		String json = "{\"pageIndex\": 1,\"pageCount\": 3,\"recipienter\":\"1\"}";
		System.out.println("test" + recipientApplyService.userHistoryRecipientApply(json));
	}

}
