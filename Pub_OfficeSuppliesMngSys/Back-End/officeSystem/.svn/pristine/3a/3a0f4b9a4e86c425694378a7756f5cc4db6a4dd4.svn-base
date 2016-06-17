package cn.fjnu.officeSystem.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.fjnu.officeSystem.dao.BorrowApplyDao;
import cn.fjnu.officeSystem.dao.IStaffDao;
import cn.fjnu.officeSystem.dao.ItemClassificationSummaryDao;
import cn.fjnu.officeSystem.dao.ItemDao;
import cn.fjnu.officeSystem.entity.BorrowApply;
import cn.fjnu.officeSystem.entity.ItemClassificationSummary;
import cn.fjnu.officeSystem.entity.OutStorageCheckIn;
import cn.fjnu.officeSystem.entity.Staff;
import cn.fjnu.officeSystem.extend.BorrowApplyExpireExtend;
import cn.fjnu.officeSystem.extend.BorrowApplyReturnExtend;
import cn.fjnu.officeSystem.extend.BrrowApplyExtend;
import cn.fjnu.officeSystem.utils.CompareDate;
import cn.fjnu.officeSystem.utils.DateJsonValueProcessor;
import cn.fjnu.officeSystem.utils.PageUtil;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

@Service
public class BorrowApplyService {

	@Resource
	BorrowApplyDao borrowApplyDao;
	@Resource
	CompareDate compareDate;
	@Resource
	ItemClassificationSummaryDao itemClassificationSummaryDao;
	@Resource
	IStaffDao staffDao;


	// 获取所有已审核的借用申请记录
	public String getAuditBorrowApplies(String json) {
		// json字符串转json对象
		JSONObject jsonObject = JSONObject.fromObject(json);
		// 解析json中的数据
		int pageIndex = jsonObject.optInt("pageIndex");
		int pageCount = jsonObject.optInt("pageCount");
		int count = 0;
		String result = null;
		String borrowState = null;
		String validateState = null;
		Map<String, Object> resultMap = new HashMap<>();
		count = borrowApplyDao.selectBorrowApplyAuditCount();
		if (count > 0) {
			PageUtil<BorrowApplyExpireExtend> page = new PageUtil<>(pageIndex, count, pageCount);
			List<BorrowApplyExpireExtend> resultList = borrowApplyDao.selectBorrowApplyAudit(page.getDataStart(),
					page.getDataEnd());
			for (BorrowApplyExpireExtend borrowApplyExpireExtend : resultList) {
				Date borrowTime = borrowApplyExpireExtend.getBorrowTime();
				Date returnTime = borrowApplyExpireExtend.getReturnTime();
				if (borrowTime == null) {
					borrowState = "未借出";
				} else if (returnTime == null) {
					borrowState = "已借出";
				} else {
					borrowState = "已归还";
				}
				Date maxBorrowTime = borrowApplyExpireExtend.getMaxBorrowTime();
				int i = compareDate.compare_date(new Date(), maxBorrowTime);
				if (i == 1) {// 未超期
					validateState = "有效";
				} else if (i == -1) {// 已超期
					validateState = "无效";
				} else {
					System.out.println("error!");
				}
			}
			resultMap.put("borrowState", borrowState);
			resultMap.put("validateState", validateState);
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
			return "{\"message\":\"当前没有审核通过的借用申请记录！\"}";
		}
	}

	// 删除已审核的借用记录
	public void deleteAuditBorrowApply(String json) {
		JSONObject jsonObject = JSONObject.fromObject(json);
		String id = jsonObject.optString("id");
		borrowApplyDao.deleteBorrowApplyById(id);
	}

	// 获取所有未审核的借用申请记录
	public String getUnAuditBorrowApplies(String json) {
		// json字符串转json对象
		JSONObject jsonObject = JSONObject.fromObject(json);
		// 解析json中的数据
		int pageIndex = jsonObject.optInt("pageIndex");
		int pageCount = jsonObject.optInt("pageCount");
		int count = 0;
		String result = null;
		Map<String, Object> resultMap = new HashMap<>();
		count = borrowApplyDao.selectBorrowApplyUnAuditCount();
		if (count > 0) {
			PageUtil<BrrowApplyExtend> page = new PageUtil<>(pageIndex, count, pageCount);
			List<BrrowApplyExtend> resultList = borrowApplyDao.selectBorrowApplyUnAudit(page.getDataStart(),
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
	public void OperateBorrowAudit(String json) {
		// json字符串转json对象
		JSONObject jsonObject = JSONObject.fromObject(json);
		// 解析json中的数据
		int operate = jsonObject.optInt("operate");
		String id = jsonObject.optString("id");
		String auditId = jsonObject.optString("auditId");
		if (operate == 0) {
			BorrowApply borrowApply = borrowApplyDao.selectBorrowApplyById(id);
			borrowApply.setState((short) 3);
			SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			java.sql.Timestamp st = new java.sql.Timestamp(new java.util.Date().getTime());
			borrowApply.setAuditTime(st);
			borrowApply.setAuditor(auditId);
			borrowApplyDao.updateBorrowApply(borrowApply);
			System.out.println("0更新成功！");
		} else if (operate == 1) {
			BorrowApply borrowApply = borrowApplyDao.selectBorrowApplyById(id);
			borrowApply.setState((short) 2);
			SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			java.sql.Timestamp st = new java.sql.Timestamp(new java.util.Date().getTime());
			borrowApply.setAuditTime(st);
			borrowApply.setAuditor(auditId);
			borrowApplyDao.updateBorrowApply(borrowApply);
			System.out.println("1更新成功！");

		}
	}

	// 用户查询当前借用物品的信息
	public String userCurrentBorrowApply(String json) {
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
	public String submitBorrowApply(String json){
		//json字符串转json对象
		JSONObject jsonObject=JSONObject.fromObject(json);
		//解析json中的数据
		Long borrowNum=jsonObject.optLong("BorrowNum");
		String borrower=jsonObject.optString("borrower");
		String result=null;
		Map<String, Object> resultMap = new HashMap<>();
		JSONObject itemClassificationSummaryObject=jsonObject.optJSONObject("itemClassificationSummary");
		ItemClassificationSummary itemClassificationSummary=(ItemClassificationSummary) itemClassificationSummaryObject.toBean(itemClassificationSummaryObject, ItemClassificationSummary.class);
		if(borrowNum<itemClassificationSummary.getInventory()){
			BorrowApply borrowApply=new BorrowApply();
			String itemId=itemClassificationSummary.getItemId();
			double price=itemClassificationSummaryDao.selectItemPriceByItemId(itemId);
			borrowApply.setItemId(itemId);
			borrowApply.setItemName(itemClassificationSummary.getItemName());
			borrowApply.setItemTypeId(itemClassificationSummary.getItemTypeId());
			borrowApply.setSpec(itemClassificationSummary.getSpec());
			borrowApply.setBorrowNum(borrowNum);
			borrowApply.setBorrower(borrower);
			borrowApply.setBorrowDepartmentId(staffDao.getDepartmentIdByStaffId(borrower));
			borrowApply.setPrice(price);
			borrowApply.setMonney(price*borrowNum);
			borrowApply.setState((short)1);
			borrowApply.setIsDisplay((short)1);
			borrowApply.setIsValid((short)1);
			borrowApplyDao.insertBorrowApply(borrowApply);
			System.out.println("借用申请成功！");
			resultMap.put("state", "申请成功");
		}else{
			resultMap.put("state", "申请失败");
		}
		result = JSONObject.fromObject(resultMap).toString();
		return result;
	}
	
	
	// 用户查询历史借用申请的信息
	public String userHistoryBorrowApply(String json){
		 // json字符串转json对象
		JSONObject jsonObject = JSONObject.fromObject(json);
		int pageIndex = jsonObject.optInt("pageIndex");
		int pageCount = jsonObject.optInt("pageCount");
		String borrower=jsonObject.optString("borrower");
		int count = 0;
		String result = null;
		Map<String, Object> resultMap = new HashMap<>();
		//查询借用申请表
		count=borrowApplyDao.selectBorrowAppliesByStaffIdCount(borrower);
		if (count > 0) {
			PageUtil<BorrowApplyReturnExtend> page = new PageUtil<>(pageIndex, count, pageCount);
			List<BorrowApplyReturnExtend> resultList = borrowApplyDao.selectBorrowAppliesByStaffId(page.getDataStart(), page.getDataEnd(), borrower);
			resultMap.put("resultList", resultList);// 数据
			resultMap.put("pageSize", page.getPageSize());// 总页数
			System.out.println("map:" + resultMap);
			result = JSONObject.fromObject(resultMap).toString();
			return result;
		}else{
			return "{\"message\":\"您还没有相关借用记录哦\"}";
		}
	}
	



}
