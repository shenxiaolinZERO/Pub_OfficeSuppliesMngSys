package cn.fjnu.officeSystem.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.fjnu.officeSystem.dao.IStaffDao;
import cn.fjnu.officeSystem.dao.ItemClassificationSummaryDao;
import cn.fjnu.officeSystem.dao.RecipientApplyDao;
import cn.fjnu.officeSystem.entity.BorrowApply;
import cn.fjnu.officeSystem.entity.ItemClassificationSummary;
import cn.fjnu.officeSystem.entity.RecipientApply;
import cn.fjnu.officeSystem.extend.BorrowApplyReturnExtend;
import cn.fjnu.officeSystem.extend.RecipientApplyExpireExtend;
import cn.fjnu.officeSystem.extend.RecipientApplyExtend;
import cn.fjnu.officeSystem.extend.RecipientApplyReturnExtend;
import cn.fjnu.officeSystem.utils.CompareDate;
import cn.fjnu.officeSystem.utils.DateJsonValueProcessor;
import cn.fjnu.officeSystem.utils.PageUtil;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

@Service
public class RecipientApplyService {

	@Resource
	RecipientApplyDao recipientApplyDao;
	@Resource
	CompareDate compareDate;
	@Resource
	ItemClassificationSummaryDao itemClassificationSummaryDao;
	@Resource
	IStaffDao staffDao;

	// 获取所有已审核的领用申请记录
	// 审核状态通过读取state字段判断（1.待审核，2.审核通过，3.审核不通过）
	public String getAuditRecipientApplies(String json) {
		// json字符串转json对象
		JSONObject jsonObject = JSONObject.fromObject(json);
		// 解析json中的数据
		int pageIndex = jsonObject.optInt("pageIndex");
		int pageCount = jsonObject.optInt("pageCount");
		int count = 0;
		String result = null;
		String recipientState = null;
		String validateState = null;
		Map<String, Object> resultMap = new HashMap<>();
		count = recipientApplyDao.selectRecipientApplyAuditCount();
		if (count > 0) {
			PageUtil<RecipientApplyExpireExtend> page = new PageUtil<>(pageIndex, count, pageCount);
			List<RecipientApplyExpireExtend> resultList = recipientApplyDao
					.selectRecipientApplyAudit(page.getDataStart(), page.getDataEnd());
			for (RecipientApplyExpireExtend recipientApplyExpireExtend : resultList) {
				Date recipientTime = recipientApplyExpireExtend.getRecipientTime();
				if (recipientTime == null) {
					recipientState = "未领用";
				} else {
					recipientState = "已领用";
				}
				Date maxRecipientTime = recipientApplyExpireExtend.getMaxRecipientTime();
				int i = compareDate.compare_date(new Date(), maxRecipientTime);
				if (i == 1) {// 未超期
					validateState = "有效";
				} else if (i == -1) {// 已超期
					validateState = "无效";
				} else {
					System.out.println("error!");
				}
			}
			resultMap.put("recipientState", recipientState);
			resultMap.put("validateState", validateState);
			resultMap.put("resultList", resultList);// 数据
			resultMap.put("pageSize", page.getPageSize());// 总页数
			System.out.println("map:" + resultMap);
			JsonConfig config = new JsonConfig();
			config.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd hh:mm:ss"));
			resultMap.put("pageIndex", pageIndex);

			result = JSONObject.fromObject(resultMap, config).toString();
			return result;
		} else {
			return "{\"message\":\"当前没有审核通过的领用申请记录！\"}";
		}
	}

	// 删除已审核的领用记录
	public void deleteAuditRecipientApply(String json) {
		JSONObject jsonObject = JSONObject.fromObject(json);
		String id = jsonObject.optString("id");
		recipientApplyDao.deleteRecipientApplyById(id);
	}

	// 获取所有未审核的领用申请记录
	public String getUnAuditRecipientApplies(String json) {
		// json字符串转json对象
		JSONObject jsonObject = JSONObject.fromObject(json);
		// 解析json中的数据
		int pageIndex = jsonObject.optInt("pageIndex");
		int pageCount = jsonObject.optInt("pageCount");
		int count = 0;
		String result = null;
		Map<String, Object> resultMap = new HashMap<>();
		count = recipientApplyDao.selectRecipientApplyUnAuditCount();
		if (count > 0) {
			PageUtil<RecipientApplyExtend> page = new PageUtil<>(pageIndex, count, pageCount);
			List<RecipientApplyExtend> resultList = recipientApplyDao.selectRecipientApplyUnAudit(page.getDataStart(),
					page.getDataEnd());
			resultMap.put("resultList", resultList);// 数据
			resultMap.put("pageSize", page.getPageSize());// 总页数
			System.out.println("map:" + resultMap);
			JsonConfig config = new JsonConfig();
			// 转换时记得要导入util.date
			config.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd hh:mm:ss"));
			resultMap.put("pageIndex", pageIndex);

			result = JSONObject.fromObject(resultMap, config).toString();
			return result;
		} else {
			return "{\"message\":\"当前待审核的借用申请记录！\"}";
		}
	}

	// 管理员进行审核操作，其结果可能是审核通过，有可能是不通过
	// 前端传入operate 其中0表示不通过，1表示通过
	public void OperateRecipientAudit(String json) {
		// json字符串转json对象
		JSONObject jsonObject = JSONObject.fromObject(json);
		// 解析json中的数据
		int operate = jsonObject.optInt("operate");
		String id = jsonObject.optString("id");
		String auditId = jsonObject.optString("auditId");
		RecipientApply recipientApply=recipientApplyDao.selectRecipientApplyById(id);
		if (operate == 0) {
			recipientApply.setState((short) 3);
			SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			java.sql.Timestamp st = new java.sql.Timestamp(new java.util.Date().getTime());
			recipientApply.setAuditTime(st);
			recipientApply.setAuditor(auditId);
			recipientApplyDao.updateRecipientApply(recipientApply);
			System.out.println("0更新成功！");
		} else if (operate == 1) {
			recipientApply.setState((short) 2);
			SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			java.sql.Timestamp st = new java.sql.Timestamp(new java.util.Date().getTime());
			recipientApply.setAuditTime(st);
			recipientApply.setAuditor(auditId);
			recipientApplyDao.updateRecipientApply(recipientApply);
			System.out.println("1更新成功！");

		}
	}
	
	// 用户查询当前领用物品的信息
	public String userCurrentRecipientApply(String json) {
		// json字符串转json对象
		JSONObject jsonObject = JSONObject.fromObject(json);
		// 解析json中的数据
		int pageIndex = jsonObject.optInt("pageIndex");
		int pageCount = jsonObject.optInt("pageCount");
		String itemId=jsonObject.optString("itemId");
		String itemName=jsonObject.optString("itemName");
		String itemTypeId=jsonObject.optString("itemTypeId");
		int count = 0;
		String result = null;
		Map<String, Object> resultMap = new HashMap<>();
		//查询物品分类汇总表
		count = itemClassificationSummaryDao.selectItemClassificationSummaryByMapCount();
		if (count > 0) {
			PageUtil<ItemClassificationSummary> page = new PageUtil<>(pageIndex, count, pageCount);
			List<ItemClassificationSummary> resultList = itemClassificationSummaryDao.selectItemClassificationSummaryByMap(itemId, itemTypeId, itemName, page.getDataStart(), page.getDataEnd());
			resultMap.put("resultList", resultList);// 数据
			resultMap.put("pageSize", page.getPageSize());// 总页数
			System.out.println("map:" + resultMap);
			result = JSONObject.fromObject(resultMap).toString();
			return result;
		} else {
			return "{\"message\":\"啊哦，没有相应的记录哦！\"}";
		}
	}
	
	//用户提交领用申请的操作
	public String submitRecipientApply(String json){
		//json字符串转json对象
		JSONObject jsonObject=JSONObject.fromObject(json);
		//解析json中的数据
		int recipientNum=jsonObject.optInt("recipientNum");
		String recipienter=jsonObject.optString("recipienter");
		String result=null;
		Map<String, Object> resultMap = new HashMap<>();
		JSONObject itemClassificationSummaryObject=jsonObject.optJSONObject("itemClassificationSummary");
		ItemClassificationSummary itemClassificationSummary=(ItemClassificationSummary) itemClassificationSummaryObject.toBean(itemClassificationSummaryObject, ItemClassificationSummary.class);
		if(recipientNum < itemClassificationSummary.getInventory()){
			RecipientApply recipientApply=new RecipientApply();
			String itemId=itemClassificationSummary.getItemId();
			double price=itemClassificationSummaryDao.selectItemPriceByItemId(itemId);
			recipientApply.setItemId(itemId);
			recipientApply.setItemName(itemClassificationSummary.getItemName());
			recipientApply.setItemTypeId(itemClassificationSummary.getItemTypeId());
			recipientApply.setSpec(itemClassificationSummary.getSpec());
			recipientApply.setRecipientNum(recipientNum);;
			recipientApply.setRecipienter(recipienter);
			recipientApply.setRecipientDepartmentId(staffDao.getDepartmentIdByStaffId(recipienter));
			recipientApply.setPrice(price);
			recipientApply.setMonney(price*recipientNum);
			recipientApply.setState((short)1);
			recipientApply.setIsDisplay((short)1);
			recipientApply.setIsValid((short)1);
			recipientApplyDao.insertRecipientApply(recipientApply);
			System.out.println("借用申请成功！");
			resultMap.put("state", "申请成功");
		}else{
			resultMap.put("state", "申请失败");
		}
		result = JSONObject.fromObject(resultMap).toString();
		return result;
	}
	
	
	// 用户查询历史借用申请的信息
	public String userHistoryRecipientApply(String json){
		 // json字符串转json对象
		JSONObject jsonObject = JSONObject.fromObject(json);
		int pageIndex = jsonObject.optInt("pageIndex");
		int pageCount = jsonObject.optInt("pageCount");
		String recipienter=jsonObject.optString("recipienter");
		int count = 0;
		String result = null;
		Map<String, Object> resultMap = new HashMap<>();
		//查询借用申请表
		count=recipientApplyDao.selectRecipientAppliesByStaffIdCount(recipienter);
		if (count > 0) {
			PageUtil<RecipientApplyReturnExtend> page = new PageUtil<>(pageIndex, count, pageCount);
			List<RecipientApplyReturnExtend> resultList = recipientApplyDao.selectRecipientAppliesByStaffId(page.getDataStart(), page.getDataEnd(), recipienter);
			resultMap.put("resultList", resultList);// 数据
			resultMap.put("pageSize", page.getPageSize());// 总页数
			System.out.println("map:" + resultMap);
			result = JSONObject.fromObject(resultMap).toString();
			return result;
		}else{
			return "{\"message\":\"您还没有相关领用记录哦\"}";
		}
	}

}
