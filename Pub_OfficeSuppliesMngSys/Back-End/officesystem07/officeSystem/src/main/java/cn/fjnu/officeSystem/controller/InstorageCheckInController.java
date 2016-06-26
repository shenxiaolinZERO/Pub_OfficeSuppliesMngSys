package cn.fjnu.officeSystem.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.fjnu.officeSystem.dao.InStorageCheckInDao;
import cn.fjnu.officeSystem.service.InStorageCheckInService;
import net.sf.json.JSONObject;
@Controller
@RequestMapping("/InstorageCheckIn")
public class InstorageCheckInController {
	@Resource
	InStorageCheckInService inStorageCheckInService;
	@RequestMapping(value="/getInstorageType",produces="application/json;charset=utf-8")
	public @ResponseBody String getInstorageType(HttpServletResponse response){
		response.addHeader("Access-Control-Allow-Origin","*");
		System.out.println(inStorageCheckInService.getInstorageType());
		return inStorageCheckInService.getInstorageType();
		
	}

	// 根据选择的入库类型传回相应的首页
	@RequestMapping(value="/getInstorageHome",produces="application/json;charset=utf-8")
	public @ResponseBody String getInstorageHome(@RequestBody String json,HttpServletResponse response){
		try{
			json=URLDecoder.decode(json,"utf-8");
			if(json.endsWith("=")){
				json = json.substring(0, json.length()-1);
			}
		}catch(UnsupportedEncodingException e1){
			e1.printStackTrace();
			
		}
		//跨域
		response.addHeader("Access-Control-Allow-Origin","*");
		System.out.println(json);
		return inStorageCheckInService.getInstorageHome(json);
	}

	
	// 受赠入库:物品编号不要，物品上下限保留，单条入库
	@RequestMapping(value="/sendInStorage",produces="application/json;charset=utf-8")
	public @ResponseBody String sendInStorage(@RequestBody String json,HttpServletResponse response){
		System.out.println(json);
		try{
			json=URLDecoder.decode(json,"utf-8");
			if(json.endsWith("=")){
				json = json.substring(0, json.length()-1);
			}
		}catch(UnsupportedEncodingException e1){
			e1.printStackTrace();
			
		}
		//跨域
		response.addHeader("Access-Control-Allow-Origin","*");
		System.out.println(json);
		return inStorageCheckInService.sendInStorage(json);
		
	}

	// 采购入库
	@RequestMapping(value="/procurementInStorage",produces="application/json;charset=utf-8")
	public @ResponseBody String procurementInStorage(@RequestBody String json,HttpServletResponse response){
		
		try{
			json=URLDecoder.decode(json,"utf-8");
			if(json.endsWith("=")){
				json = json.substring(0, json.length()-1);
			}
		}catch(UnsupportedEncodingException e1){
			e1.printStackTrace();
			
		}
		System.out.println(json);
		//跨域
		response.addHeader("Access-Control-Allow-Origin","*");
		return inStorageCheckInService.procurementInStorage(json);
	}

	// 归还入库
	@RequestMapping(value="/returnInStorage",produces="application/json;charset=utf-8")
	public @ResponseBody String returnInStorage(@RequestBody String json,HttpServletResponse response){
		try{
			json=URLDecoder.decode(json,"utf-8");
			if(json.endsWith("=")){
				json = json.substring(0, json.length()-1);
			}
		}catch(UnsupportedEncodingException e1){
			e1.printStackTrace();
			
		}
		System.out.println(json);
		//跨域
		response.addHeader("Access-Control-Allow-Origin","*");
		return inStorageCheckInService.returnInStorage(json);
		
	}

	// 采购入库界面查询
	@RequestMapping(value="/getItemProcurementByMap",produces="application/json;charset=utf-8")
	public @ResponseBody String getItemProcurementByMap(@RequestBody String json,HttpServletResponse response){
		try{
			json=URLDecoder.decode(json,"utf-8");
			if(json.endsWith("=")){
				json = json.substring(0, json.length()-1);
			}
		}catch(UnsupportedEncodingException e1){
			e1.printStackTrace();
			
		}
		//跨域
		response.addHeader("Access-Control-Allow-Origin","*");
		JSONObject jsonObject=JSONObject.fromObject(json);
		String itemName=jsonObject.optString("itemName");
		String itemTypeId=jsonObject.optString("itemTypeId");
		String staffId=jsonObject.optString("staffId");
		return inStorageCheckInService.getItemProcurementByMap(itemName,itemTypeId,staffId);
	}

	// 归还入库界面查询
	@RequestMapping(value="/getBorrowApplyByMap",produces="application/json;charset=utf-8")
	public @ResponseBody String getBorrowApplyByMap(@RequestBody String json,HttpServletResponse response){
		try{
			json=URLDecoder.decode(json,"utf-8");
			if(json.endsWith("=")){
				json = json.substring(0, json.length()-1);
			}
		}catch(UnsupportedEncodingException e1){
			e1.printStackTrace();
			
		}
		//跨域
		response.addHeader("Access-Control-Allow-Origin","*");
		JSONObject jsonObject=JSONObject.fromObject(json);
		String itemName=jsonObject.optString("itemName");
		String itemTypeId=jsonObject.optString("itemTypeId");
		String staffId=jsonObject.optString("staffId");
		return inStorageCheckInService.getBorrowApplyByMap(itemName,itemTypeId,staffId);
		
	}

	// 入库统计
	@RequestMapping(value="/getInstorageSumary",produces="application/json;charset=utf-8")
	public @ResponseBody String getInstorageSumary(@RequestBody String json,HttpServletResponse response){
		try{
			json=URLDecoder.decode(json,"utf-8");
			if(json.endsWith("=")){
				json = json.substring(0, json.length()-1);
			}
		}catch(UnsupportedEncodingException e1){
			e1.printStackTrace();
			
		}
		//跨域
		response.addHeader("Access-Control-Allow-Origin","*");
		System.out.println(json);
		return inStorageCheckInService.getInstorageSumary(json);
		
	}
	

}
