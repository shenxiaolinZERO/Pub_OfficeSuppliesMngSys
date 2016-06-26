package cn.fjnu.officeSystem.controller;

import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONObject;

@Controller

public class test {
	
	@RequestMapping("/test")
	public @ResponseBody String modifyType(HttpServletResponse response){
		response.addHeader("Access-Control-Allow-Origin","*");
		
		System.out.println("测试");
		return "{\"message\":\"success\"}";
		
	}
		

}
