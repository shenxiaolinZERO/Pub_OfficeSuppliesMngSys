package cn.fjnu.officeSystem.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.fjnu.officeSystem.entity.Staff;
import cn.fjnu.officeSystem.serviceImpl.BorrowApplyService;
import cn.fjnu.officeSystem.serviceImpl.StaffService;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/Staff")
public class StaffContorller {
	
	@Resource
     StaffService staffService;
	
	// 获取所有已审核的借用申请记录
	@RequestMapping(value="/modifyStaff",produces="application/json;charset=utf-8")
	public @ResponseBody String modifyStaff(@RequestBody String json,HttpServletResponse response){
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
		Staff staff=(Staff) JSONObject.toBean(JSONObject.fromObject(json).optJSONObject("staff"), Staff.class);
		return staffService.modifyStaff(staff);
	}
	
	@RequestMapping(value="/addStaff",produces="application/json;charset=utf-8")
	public @ResponseBody String addStaff(@RequestBody String json,HttpServletResponse response){
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
		Staff staff=(Staff) JSONObject.toBean(JSONObject.fromObject(json).optJSONObject("staff"), Staff.class);
		return staffService.addStaff(staff);
	}
	
	@RequestMapping(value="/login",produces="application/json;charset=utf-8")
	public @ResponseBody String login(@RequestBody String json,HttpServletResponse response){
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
		Staff staff=(Staff) JSONObject.toBean(JSONObject.fromObject(json).optJSONObject("staff"), Staff.class);
		return staffService.login(staff);
	}
	


	
		
	

}
