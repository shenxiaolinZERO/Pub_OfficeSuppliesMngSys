package cn.fjnu.officeSystem.controller;

import java.io.UnsupportedEncodingException;

import java.net.URLDecoder;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.fjnu.officeSystem.Enum.BaseInfoEnum;
import cn.fjnu.officeSystem.entity.Department;
import cn.fjnu.officeSystem.entity.InStorageType;
import cn.fjnu.officeSystem.entity.ItemType;
import cn.fjnu.officeSystem.entity.MeasureUnit;
import cn.fjnu.officeSystem.entity.OutStorageType;
import cn.fjnu.officeSystem.entity.SupplierType;
import cn.fjnu.officeSystem.serviceImpl.BaseInfoService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
@Controller
@RequestMapping("/BaseInfoManager")
public class BaseInfoManagerController{
	@Resource
	cn.fjnu.officeSystem.service.BaseInfoService baseinfoService;
	@RequestMapping(value="/modifyType",produces="application/json;charset=utf-8")
	public @ResponseBody String modifyType(@RequestBody String json,HttpServletResponse response){
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
		JSONObject jsonObject=JSONObject.fromObject(json);
		int flag=jsonObject.optInt("flag");
		int result=0;
		switch (flag) {
		case 1://部门管理
			Department department=(Department) JSONObject.toBean(jsonObject.optJSONObject("object"), Department.class);
			result=baseinfoService.modifyDepartment(department);
			break;
		case 2://物品分类管理
			ItemType itemType=(ItemType) JSONObject.toBean(jsonObject.optJSONObject("object"), ItemType.class);
			result=baseinfoService.modifyItemType(itemType);
			break;
		case 3://计量单位管理
			MeasureUnit measureUnit=(MeasureUnit)JSONObject.toBean(jsonObject.optJSONObject("object"), MeasureUnit.class);
			result=baseinfoService.updateMeasureUnit(measureUnit);
			break;
		case 4://入库类型管理
			InStorageType inStorageType=(InStorageType) JSONObject.toBean(jsonObject.optJSONObject("object"), InStorageType.class);
			result=baseinfoService.modfyInStorageType(inStorageType);
			break;
		case 5://出库类型管理
			OutStorageType outStorageType=(OutStorageType)JSONObject.toBean(jsonObject.optJSONObject("object"), OutStorageType.class);
			result=baseinfoService.modfyOutStorageType(outStorageType);
			break;
		case 6://供应商类型管理
			SupplierType supplierType=(SupplierType)JSONObject.toBean(jsonObject.optJSONObject("object"), SupplierType.class);
			result=baseinfoService.modifySupplierType(supplierType);
			break;
			
		default:System.out.println("标识错误！");
			break;
		}
		if (result==1) {
			return "{\"message\":\"success\"}";
					
			
		}else{
			return "{\"message\":\"error\"}";
		}
		
		
	}
	@RequestMapping(value="/addType",produces="application/json;charset=utf-8")
	public @ResponseBody String addType(@RequestBody String json,HttpServletResponse response){
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
		int flag=jsonObject.optInt("flag");
		int result=0;
		switch (flag) {
		case 1://部门管理
			Department department=(Department) JSONObject.toBean(jsonObject.optJSONObject("object"), Department.class);
			result=baseinfoService.addDepartment(department);
			break;
		case 2://物品分类管理
			ItemType itemType=(ItemType) JSONObject.toBean(jsonObject.optJSONObject("object"), ItemType.class);
			result=baseinfoService.addItemType(itemType);
			break;
		case 3://计量单位管理
			MeasureUnit measureUnit=(MeasureUnit)JSONObject.toBean(jsonObject.optJSONObject("object"), MeasureUnit.class);
			result=baseinfoService.addMeasureUnit(measureUnit);
			break;
		case 4://入库类型管理
			InStorageType inStorageType=(InStorageType) JSONObject.toBean(jsonObject.optJSONObject("object"), InStorageType.class);
			result=baseinfoService.addInStorageType(inStorageType);
			break;
		case 5://出库类型管理
			OutStorageType outStorageType=(OutStorageType)JSONObject.toBean(jsonObject.optJSONObject("object"), OutStorageType.class);
			result=baseinfoService.addOutStorageType(outStorageType);
			break;
		case 6://供应商类型管理
			SupplierType supplierType=(SupplierType)JSONObject.toBean(jsonObject.optJSONObject("object"), SupplierType.class);
			result=baseinfoService.addSupplierType(supplierType);
			break;
			
		default:System.out.println("标识错误！");
			break;
		}
		if (result==1) {
			return "{\"message\":\"success\"}";
					
			
		}else{
			return "{\"message\":\"error\"}";
		}
		
		
	}
	@RequestMapping(value="/getAllType",produces="application/json;charset=utf-8")
	public @ResponseBody String getAllType(@RequestBody String json,HttpServletResponse response){
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
		int flag=jsonObject.optInt("flag");
		String result=null;
		switch (flag) {
		case 1://部门管理
		    List<Department> departments=baseinfoService.getAllDepartment();
		    result=JSONArray.fromObject(departments).toString();
			break;
		case 2://物品分类管理
			List<ItemType>itemTypes=baseinfoService.getAllItemType();
			result=JSONArray.fromObject(itemTypes).toString();
			break;
		case 3://计量单位管理
			List<MeasureUnit>measureUnits=baseinfoService.getAllMeasureUnit();
			result=JSONArray.fromObject(measureUnits).toString();
			break;
		case 4://入库类型管理
			List<InStorageType> inStorageTypes=baseinfoService.getAllInstorage();
			result=JSONArray.fromObject(inStorageTypes).toString();
			break;
		case 5://出库类型管理
			List<OutStorageType> outStorageTypes=baseinfoService.getAllOutstorage();
			result=JSONArray.fromObject(outStorageTypes).toString();
			break;
		case 6://供应商类型管理
			List<SupplierType> supplierTypes=baseinfoService.getAllSupplierType();
			result=JSONArray.fromObject(supplierTypes).toString();
			break;
			
		default:System.out.println("标识错误！");
			break;
		}
		return result;
	}
	
	

}
