package cn.fjnu.officeSystem.controller;

import java.io.UnsupportedEncodingException;

import java.net.URLDecoder;
import java.text.ParseException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.fjnu.officeSystem.entity.Supplier;
import cn.fjnu.officeSystem.extend.MerchantsAvailabilityDetail;
import cn.fjnu.officeSystem.service.SupplierManagerService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
@Controller
@RequestMapping("/SupplierManager")
public class SupplierManagerController {
	@Resource
	SupplierManagerService supplierManagerService;
	@RequestMapping(value="/addSupplier",produces="application/json;charset=utf-8")
	public @ResponseBody String addSupplier(@RequestBody Supplier supplier, HttpServletResponse response) {
		// 跨域
		response.addHeader("Access-Control-Allow-Origin", "*");
		int result = supplierManagerService.addSupplier(supplier);
		if (result == 1) {
			return "{\"message\":\"success\"}";

		} else {
			return "{\"message\":\"error\"}";
		}

	}

	/**
	 * 动态更改供应商信息
	 * 
	 * @param supplier
	 * @return
	 */
	@RequestMapping(value="/modifySupplier",produces="application/json;charset=utf-8")
	public @ResponseBody String modifySupplier(@RequestBody Supplier supplier, HttpServletResponse response) {
		// 跨域
		response.addHeader("Access-Control-Allow-Origin", "*");
		int result = supplierManagerService.modifySupplier(supplier);
		if (result == 1) {
			return "{\"message\":\"success\"}";

		} else {
			return "{\"message\":\"error\"}";
		}
	}
	
	/**
	 * 查询出系统中所有的供应商
	 * @return
	 */
	@RequestMapping(value="/getAllSupplier",produces="application/json;charset=utf-8")
	public @ResponseBody String getAllSupplier(@RequestBody String json,HttpServletResponse response){
			try {
				json = URLDecoder.decode(json, "utf-8");
				if (json.endsWith("=")) {
					json = json.substring(0, json.length() - 1);
				}
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();

			}
			// 跨域
			response.addHeader("Access-Control-Allow-Origin", "*");
			JSONObject jsonObject = JSONObject.fromObject(json);
			int pageIndex = jsonObject.optInt("pageIndex");
			int pageCount = jsonObject.optInt("pageCount");
			return supplierManagerService.getAllSupplier(pageIndex, pageCount);
		
		
	}
	/**
	 * 查询出系统中有效的供应商信息
	 * 
	 * @return
	 */
	@RequestMapping(value="/getValidSupplier",produces="application/json;charset=utf-8")
	public @ResponseBody String getValidSupplier(@RequestBody String json,HttpServletResponse response){
			try {
				json = URLDecoder.decode(json, "utf-8");
				if (json.endsWith("=")) {
					json = json.substring(0, json.length() - 1);
				}
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();

			}
			// 跨域
			response.addHeader("Access-Control-Allow-Origin", "*");
			JSONObject jsonObject = JSONObject.fromObject(json);
			int pageIndex = jsonObject.optInt("pageIndex");
			int pageCount = jsonObject.optInt("pageCount");
			return supplierManagerService.getValidSupplier(pageIndex, pageCount);
			
	}
	/**
	 * 查询出系统中无效的供应商信息
	 * 
	 * @return
	 */
	@RequestMapping(value="/getUnValidSupplier",produces="application/json;charset=utf-8")
	public @ResponseBody String getUnValidSupplier(@RequestBody String json,HttpServletResponse response){
		try {
			json = URLDecoder.decode(json, "utf-8");
			if (json.endsWith("=")) {
				json = json.substring(0, json.length() - 1);
			}
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();

		}
		// 跨域
		response.addHeader("Access-Control-Allow-Origin", "*");
		JSONObject jsonObject = JSONObject.fromObject(json);
		int pageIndex = jsonObject.optInt("pageIndex");
		int pageCount = jsonObject.optInt("pageCount");
		return supplierManagerService.getUnValidSupplier(pageIndex, pageCount);
		
	}
	/**
	 * 按以下条件查询出供应商基本信息
	 * @param isValid 是否有效
	 * @param supplierTypeId 供应商类型id
	 * @return
	 */
	@RequestMapping(value="/getSupplierByTypeAndState",produces="application/json;charset=utf-8")
	public @ResponseBody String getSupplierByTypeAndState(@RequestBody String json,HttpServletResponse response){
		
		 try {
				json = URLDecoder.decode(json, "utf-8");
				if (json.endsWith("=")) {
					json = json.substring(0, json.length() - 1);
				}
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();

			}
			// 跨域
			response.addHeader("Access-Control-Allow-Origin", "*");
			JSONObject jsonObject = JSONObject.fromObject(json);
			int pageIndex = jsonObject.optInt("pageIndex");
			int pageCount = jsonObject.optInt("pageCount");
			int isValid=jsonObject.optInt("isValid");
			String supplierTypeId=jsonObject.optString("supplierTypeId");
			return supplierManagerService.getSupplierByTypeAndState(isValid, supplierTypeId, pageIndex, pageCount);
		
	}
	
	/**
	 * 根据供应商id查看该供应商的详情，包括供货情况
	 * @param supplierId
	 * @return
	 */
	@RequestMapping(value="/getMerchantsAvailabilityDetailBySupplierId",produces="application/json;charset=utf-8")
	public @ResponseBody MerchantsAvailabilityDetail getMerchantsAvailabilityDetailBySupplierId(@RequestBody String json,HttpServletResponse response){
		 try {
				json = URLDecoder.decode(json, "utf-8");
				if (json.endsWith("=")) {
					json = json.substring(0, json.length() - 1);
				}
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();

			}
			// 跨域
			response.addHeader("Access-Control-Allow-Origin", "*");
			JSONObject jsonObject = JSONObject.fromObject(json);
			String supplierId=jsonObject.optString("supplierId");
			return supplierManagerService.getMerchantsAvailabilityDetailBySupplierId(supplierId);
		
	}
	
	

}
