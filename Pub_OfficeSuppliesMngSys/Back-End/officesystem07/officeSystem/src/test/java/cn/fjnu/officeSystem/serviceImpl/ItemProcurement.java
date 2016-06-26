package cn.fjnu.officeSystem.serviceImpl;

import static org.junit.Assert.*;

import java.text.ParseException;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import cn.fjnu.officeSystem.service.ItemProcurementService;
import net.sf.json.JSONObject;
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"classpath*:springmvc.xml","classpath*:applicationContext.xml"})
@ActiveProfiles("production")
public class ItemProcurement {
	@Resource 
	ItemProcurementService itemProcurementService;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	// 采购申请首页
		public void testgGetItemProcurementApplyHome(){
			String json="{\"pageIndex\":\"1\",\"pageCount\":\"1\","
					+ "\"supplierId\":\"1\",\"agentId\":\"1\",\"operaterId\":\"1\","
					+ "\"itemProcurementId\":\"1\"}";
			
			
			
		}

	@Test
		// 不通过--填写预采购理由
		public void testNotPassItemProcurementApply(){
			
		}

	@Test
		// 确定预采购--将采购申请写入预采购清单
		public 	void testcConfirmPreItemProcurement(){
			
		}

	@Test
		// 历史预采购清单
		public void testGetPreItemProcurementHome() throws ParseException{
			String json="{\"pageIndex\":\"1\",\"pageCount\":\"1\",\"itemTypeId\":\"1\",\"itemName\":\"物品名称\","
					+ "\"itemId\":\"1\",\"staffId\":\"1\",\"preStartTime\":\"2016-5-3\",\"preEndTime\":\"2016-5-30\",\"preTimeSort\":\"1\"}";
			JSONObject jsonObject=JSONObject.fromObject(json);
			int pageIndex=jsonObject.optInt("pageIndex");//当前页
			int pageCount=jsonObject.optInt("pageCount");//页大小
			String itemId=jsonObject.optString("itemId");
			String itemTypeId=jsonObject.optString("itemTypeId");
			String itemName=jsonObject.optString("itemName");
			String preStartTime=jsonObject.optString("preStartTime");
			String preEndTime=jsonObject.optString("preEndTime");
			String staffId=jsonObject.optString("staffId");
			String preTimeSort=jsonObject.optString("preTimeSort");
			System.out.println(itemProcurementService.getPreItemProcurementHome(pageIndex, pageCount, staffId, itemTypeId, itemName, itemId, preTimeSort, preStartTime, preEndTime));
		}

	@Test
		// 点击采购、
		public void testPurchase(){
			
		}

	@Test
		// 待采购清单（物品采购表中未入库登记）
		public void testgGetUnInStorageItemProcurement(){
			
		}
	@Test

		// 已采购清单（物品采购表中已入库登记）
		public void  testGetInStorageItemProcurement(){
			
		}

}
