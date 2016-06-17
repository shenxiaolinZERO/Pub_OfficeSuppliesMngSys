package cn.fjnu.officeSystem.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.fjnu.officeSystem.service.itemInventoryWarningService;

@RequestMapping("/ItemInventoryWarning")
public class itemInventoryWarningController {
	@Resource itemInventoryWarningService itemInventoryWarningService;
	
	// 该页的查询条件有状态、物品分类Id、物品名称、获取超过上限的物品、获取低于下限的物品
	@RequestMapping(value="/getWarningInfo",produces="application/json;charset=utf-8")
		public @ResponseBody String getWarningInfo(@RequestBody String json,HttpServletResponse response){
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
		return itemInventoryWarningService.getWarningInfo(json);
			
		}

		// 对于低于下限的物品--写入预采购单
	@RequestMapping(value="/addPreItemProcurement",produces="application/json;charset=utf-8")
		public @ResponseBody String addPreItemProcurement(@RequestBody String json,HttpServletResponse response){
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
		return itemInventoryWarningService.addPreItemProcurement(json);
			
		}
	

}
