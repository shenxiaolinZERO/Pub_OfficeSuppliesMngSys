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

import cn.fjnu.officeSystem.entity.Supplier;
import cn.fjnu.officeSystem.extend.MerchantsAvailabilityDetail;
import cn.fjnu.officeSystem.service.SupplierManagerService;
import net.sf.json.JSONObject;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath*:springmvc.xml", "classpath*:applicationContext.xml" })
@ActiveProfiles("production")
public class SupplierManagerServiceTest {
	@Resource
	SupplierManagerService supplierManagerService;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddSupplier() {
		String json = "{\"supplier\":{\"fullName\":\"供应商全称\",\"shortName\":\"供应商简称\","
				+ "\"supplierTypeId\":\"供应商类型\",\"linkman\":\"联系人\",\"cellPhoneNumber\":"
				+ "\"手机号码\",\"phone\":\"联系电话\",\"fax\":\"传真\","
				+ "\"postcode\":\"邮编\",\"address\":\"地址\",\"remark\":\"备注\"}}";
		Supplier supplier=(Supplier)JSONObject.toBean(JSONObject.fromObject(json).optJSONObject("supplier"),Supplier.class);
		System.out.println(supplierManagerService.addSupplier(supplier));
	}

	@Test
	public void testModifySupplier() {
		String json = "{\"supplier\":{\"id\":\"4\",\"fullName\":\"供应商全称\",\"shortName\":\"供应商简称\","
				+ "\"supplierTypeId\":\"供应商类型\",\"linkman\":\"联系人\",\"cellPhoneNumber\":"
				+ "\"1111111111\",\"phone\":\"111111111\",\"fax\":\"传真\","
				+ "\"postcode\":\"邮编\",\"address\":\"地址\",\"remark\":\"备注\"}}";
		Supplier supplier=(Supplier)JSONObject.toBean(JSONObject.fromObject(json).optJSONObject("supplier"),Supplier.class);
		System.out.println(supplierManagerService.modifySupplier(supplier));
	}

	@Test
	public void testGetAllSupplier() {
		String json="{\"pageIndex\":1,\"pageCount\":1}";
		JSONObject jsonObject = JSONObject.fromObject(json);
		int pageIndex = jsonObject.optInt("pageIndex");
		int pageCount = jsonObject.optInt("pageCount");
		System.out.println(supplierManagerService.getAllSupplier(pageIndex, pageCount));
	}

	@Test
	public void testGetValidSupplier() {
		String json="{\"pageIndex\":1,\"pageCount\":1}";
		JSONObject jsonObject = JSONObject.fromObject(json);
		int pageIndex = jsonObject.optInt("pageIndex");
		int pageCount = jsonObject.optInt("pageCount");
		System.out.println(supplierManagerService.getValidSupplier(pageIndex, pageCount));
	}

	@Test
	public void testGetUnValidSupplier() {
		String json="{\"pageIndex\":1,\"pageCount\":1}";
		JSONObject jsonObject = JSONObject.fromObject(json);
		int pageIndex = jsonObject.optInt("pageIndex");
		int pageCount = jsonObject.optInt("pageCount");
		System.out.println(supplierManagerService.getUnValidSupplier(pageIndex, pageCount));
	}

	@Test
	public void testGetSupplierByTypeAndState() {
		String json="{\"pageIndex\":1,\"pageCount\":1,\"isValid\":1,\"supplierTypeId\":\"1\"}";
		JSONObject jsonObject = JSONObject.fromObject(json);
		int pageIndex = jsonObject.optInt("pageIndex");
		int pageCount = jsonObject.optInt("pageCount");
		int isValid=jsonObject.optInt("isValid");
		String supplierTypeId=jsonObject.optString("supplierTypeId");
		System.out.println(supplierManagerService.getSupplierByTypeAndState(isValid, supplierTypeId, pageIndex, pageCount));
	
	
	}

	@Test
	public void testGetMerchantsAvailabilityDetailBySupplierId() {
		String json="{\"supplierId\":\"1\"}";
		JSONObject jsonObject = JSONObject.fromObject(json);
		String supplierId=jsonObject.optString("supplierId");
		MerchantsAvailabilityDetail merchantDetail=supplierManagerService.getMerchantsAvailabilityDetailBySupplierId(supplierId);
		System.out.println(JSONObject.fromObject(merchantDetail).toString());
	}

}
