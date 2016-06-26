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
@ContextConfiguration(locations={"classpath*:springmvc.xml","classpath*:applicationContext.xml"})
@ActiveProfiles("production")
public class OverTimeBorrowApplyServiceTest {
	@Resource
	OverTimeBorrowApplyService overtimeborrowApplyService;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testgetBorrowApplyWarningHome() {
		String json="{\"pageIndex\": 1,\"pageCount\": 1}";
		System.out.println(overtimeborrowApplyService.getBorrowApplyWarningHome(json));
		
	}
	@Test
	public void testgetBorrowApplyWarningPassHome(){
		String json="{\"pageIndex\": 1,\"pageCount\": 1}";
		System.out.println(overtimeborrowApplyService.getBorrowApplyWarningPassHome(json));
	}
	@Test
	public void testgetBorrowedXXPassAppliesByItemId(){
		System.out.println(overtimeborrowApplyService.getBorrowedXXPassAppliesByItemId("1"));
	}
	@Test
	public void testgetBorrowedXXAppliesByItemId(){
		System.out.println(overtimeborrowApplyService.getBorrowedXXAppliesByItemId("it001605150000"));
	}

}
