package cn.fjnu.officeSystem.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.fjnu.officeSystem.serviceImpl.RecipientApplyService;
@Controller
@RequestMapping("/RecipientApply")
public class RecipientApplyController {

	@Resource
	RecipientApplyService recipientApplyService;
	
	// 获取所有已审核的借用申请记录
		@RequestMapping(value="/getAuditRecipientApplies",produces="application/json;charset=utf-8")
		public @ResponseBody String getAuditRecipientApplies(@RequestBody String json,HttpServletResponse response){
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
			return recipientApplyService.getAuditRecipientApplies(json);
		}
		
		// 删除已审核的借用记录
		@RequestMapping(value="/deleteAuditRecipientApply",produces="application/json;charset=utf-8")
		public void deleteAuditRecipientApply(@RequestBody String json,HttpServletResponse response){
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
			recipientApplyService.deleteAuditRecipientApply(json);
		}
		
		// 获取所有未审核的借用申请记录
		@RequestMapping(value="/getUnAuditRecipientApplies",produces="application/json;charset=utf-8")
		public @ResponseBody String getUnAuditRecipientApplies(@RequestBody String json,HttpServletResponse response){
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
			return recipientApplyService.getUnAuditRecipientApplies(json);
		}
		
		// 管理员进行审核操作，其结果可能是审核通过，有可能是不通过
		// 前端传入operate 其中0表示不通过，1表示通过
		@RequestMapping(value="/operateRecipientAudit",produces="application/json;charset=utf-8")
		public void operateRecipientAudit(@RequestBody String json,HttpServletResponse response){
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
			recipientApplyService.operateRecipientAudit(json);
		}
		
		// 用户查询当前借用物品的信息
		@RequestMapping(value="/userCurrentRecipientApply",produces="application/json;charset=utf-8")
		public @ResponseBody String userCurrentRecipientApply(@RequestBody String json,HttpServletResponse response){
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
			return recipientApplyService.userCurrentRecipientApply(json);
		}
		
		//用户提交领用申请的操作
		@RequestMapping(value="/submitRecipientApply",produces="application/json;charset=utf-8")
		public @ResponseBody String submitRecipientApply(@RequestBody String json,HttpServletResponse response){
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
			return recipientApplyService.submitRecipientApply(json);
		}
		
		// 用户查询历史借用申请的信息
		@RequestMapping(value="/userHistoryRecipientApply",produces="application/json;charset=utf-8")
		public @ResponseBody String userHistoryRecipientApply(@RequestBody String json,HttpServletResponse response){
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
			return recipientApplyService.userHistoryRecipientApply(json);
		}
		
}
