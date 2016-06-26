package cn.fjnu.officeSystem.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.fjnu.officeSystem.serviceImpl.OutStorageService;
@Controller
@RequestMapping("/OutstorageCheckIn")
public class OutstorageCheckInController {

	@Resource
	OutStorageService outStorageService;

	@RequestMapping(value = "/getOutstorageType", produces = "application/json;charset=utf-8")
	public @ResponseBody String getOutstorageType(HttpServletResponse response) {
//		try {
//			json = URLDecoder.decode(json, "utf-8");
//			if (json.endsWith("=")) {
//				json = json.substring(0, json.length() - 1);
//			}
//		} catch (UnsupportedEncodingException e1) {
//			e1.printStackTrace();
//
//		}
		// 跨域
		response.addHeader("Access-Control-Allow-Origin", "*");
		return outStorageService.getOutstorageType();

	}

	// 根据选择的出库类型传回相应的首页
	@RequestMapping(value = "/getOutstorageHome", produces = "application/json;charset=utf-8")
	public @ResponseBody String getOutstorageHome(@RequestBody String json, HttpServletResponse response) {
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
		System.out.println( outStorageService.getOutstorageHome(json));
		return outStorageService.getOutstorageHome(json);
	}
	
	//单条出库操作
	@RequestMapping(value = "/operateOutStorageCheckIn", produces = "application/json;charset=utf-8")
	public @ResponseBody String operateOutStorageCheckIn(@RequestBody String json, HttpServletResponse response) {
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
		return outStorageService.operateOutStorageCheckIn(json);
	}
	
	//出库统计
	@RequestMapping(value = "/getOutstorageSummary", produces = "application/json;charset=utf-8")
	public @ResponseBody String getOutstorageSummary(@RequestBody String json, HttpServletResponse response) {
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
		return outStorageService.getOutstorageSummary(json);
	}
	

}
