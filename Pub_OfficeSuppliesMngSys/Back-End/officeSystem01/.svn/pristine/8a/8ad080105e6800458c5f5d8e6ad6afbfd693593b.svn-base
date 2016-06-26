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
		String json = "{\"pageIndex\": 1,\"pageCount\": 2}";
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
		String json = "{\"pageIndex\": 1,\"pageCount\": 2,\"operate\": 0,\"id\": \"7\",\"auditId\": \"1\"}";
		borrowApplyService.OperateBorrowAudit(json);
	}

}
