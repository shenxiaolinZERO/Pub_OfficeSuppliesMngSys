package cn.fjnu.officeSystem.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.fjnu.officeSystem.service.OverTimeBorrowApplyService;
import net.sf.json.JSONObject;
@Controller
@RequestMapping("/OverTimeBorrowApply")
public class OverTimeBorrowApplyController {
	@Resource
	OverTimeBorrowApplyService overTimeBorrowApplyService;

	// 获取借用物品处于库存预警的界面
	@RequestMapping(value="/getBorrowApplyWarningHome",produces="application/json;charset=utf-8")
	public @ResponseBody String getBorrowApplyWarningHome(@RequestBody String json,HttpServletResponse response){
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
		System.out.println(overTimeBorrowApplyService.getBorrowApplyWarningHome(json));
		return overTimeBorrowApplyService.getBorrowApplyWarningHome(json);
		
	}

	// 已超期且库存紧张的
	@RequestMapping(value="/getBorrowApplyWarningPassHome",produces="application/json;charset=utf-8")
	public @ResponseBody String getBorrowApplyWarningPassHome(@RequestBody String json,HttpServletResponse response){
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
		System.out.println(overTimeBorrowApplyService.getBorrowApplyWarningPassHome(json));
		return overTimeBorrowApplyService.getBorrowApplyWarningPassHome(json);
		
	}

	// 根据物品编号查询相应状态
	@RequestMapping(value="/getBorrowedXXPassAppliesByItemId",produces="application/json;charset=utf-8")
	public @ResponseBody String getBorrowedXXPassAppliesByItemId(@RequestBody String json,HttpServletResponse response){
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
	String itemId=JSONObject.fromObject(json).optString("itemId");
	System.out.println(itemId);
	System.out.println(overTimeBorrowApplyService.getBorrowedXXPassAppliesByItemId(itemId));
	return overTimeBorrowApplyService.getBorrowedXXPassAppliesByItemId(itemId);
		
	}
	@RequestMapping(value="/getBorrowedXXAppliesByItemId",produces="application/json;charset=utf-8")
	public @ResponseBody String getBorrowedXXAppliesByItemId(@RequestBody String json,HttpServletResponse response){
		
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
		String itemId=JSONObject.fromObject(json).optString("itemId");
		System.out.println(itemId);
		System.out.println(overTimeBorrowApplyService.getBorrowedXXAppliesByItemId(itemId));
		return overTimeBorrowApplyService.getBorrowedXXAppliesByItemId(itemId);
		
	}

}
