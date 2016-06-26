package cn.fjnu.officeSystem.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.fjnu.officeSystem.serviceImpl.BorrowApplyService;
@Controller
@RequestMapping("/BorrowApply")
public class BorrowApplyController {

	@Resource
	BorrowApplyService borrowApplyService;
	
	// 获取所有已审核的借用申请记录
	@RequestMapping(value="/getAuditBorrowApplies",produces="application/json;charset=utf-8")
	public @ResponseBody String getAuditBorrowApplies(@RequestBody String json,HttpServletResponse response){
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
		return borrowApplyService.getAuditBorrowApplies(json);
	}
	
	// 删除已审核的借用记录
	@RequestMapping(value="/deleteAuditBorrowApply",produces="application/json;charset=utf-8")
	public void deleteAuditBorrowApply(@RequestBody String json,HttpServletResponse response){
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
		borrowApplyService.deleteAuditBorrowApply(json);
	}
	
	// 获取所有未审核的借用申请记录
	@RequestMapping(value="/getUnAuditBorrowApplies",produces="application/json;charset=utf-8")
	public @ResponseBody String getUnAuditBorrowApplies(@RequestBody String json,HttpServletResponse response){
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
		return borrowApplyService.getUnAuditBorrowApplies(json);
	}
	
	// 管理员进行审核操作，其结果可能是审核通过，有可能是不通过
	// 前端传入operate 其中0表示不通过，1表示通过
	@RequestMapping(value="/operateBorrowAudit",produces="application/json;charset=utf-8")
	public void operateBorrowAudit(@RequestBody String json,HttpServletResponse response){
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
		borrowApplyService.operateBorrowAudit(json);
	}
	
	// 用户查询当前借用物品的信息
	@RequestMapping(value="/userCurrentBorrowApply",produces="application/json;charset=utf-8")
	public @ResponseBody String userCurrentBorrowApply(@RequestBody String json,HttpServletResponse response){
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
		return borrowApplyService.userCurrentBorrowApply(json);
	}
	
	//用户提交领用申请的操作
	@RequestMapping(value="/submitBorrowApply",produces="application/json;charset=utf-8")
	public @ResponseBody String submitBorrowApply(@RequestBody String json,HttpServletResponse response){
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
		return borrowApplyService.submitBorrowApply(json);
	}
	
	// 用户查询历史借用申请的信息
	@RequestMapping(value="/userHistoryBorrowApply",produces="application/json;charset=utf-8")
	public @ResponseBody String userHistoryBorrowApply(@RequestBody String json,HttpServletResponse response){
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
		return borrowApplyService.userHistoryBorrowApply(json);
	}
	
	
}
