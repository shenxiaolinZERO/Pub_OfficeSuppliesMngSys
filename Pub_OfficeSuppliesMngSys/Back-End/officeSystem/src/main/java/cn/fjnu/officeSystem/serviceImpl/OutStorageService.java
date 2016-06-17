package cn.fjnu.officeSystem.serviceImpl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.fjnu.officeSystem.Enum.TableEnum;
import cn.fjnu.officeSystem.dao.BorrowApplyDao;
import cn.fjnu.officeSystem.dao.DepartmentRecipientSummaryDao;
import cn.fjnu.officeSystem.dao.ItemClassificationSummaryDao;
import cn.fjnu.officeSystem.dao.ItemDao;
import cn.fjnu.officeSystem.dao.OutStorageCheckInDao;
import cn.fjnu.officeSystem.dao.OutStorageTypeDao;
import cn.fjnu.officeSystem.dao.RecipientApplyDao;
import cn.fjnu.officeSystem.dao.StaffRecipientSummaryDao;
import cn.fjnu.officeSystem.entity.BorrowApply;
import cn.fjnu.officeSystem.entity.DepartmentRecipientSummary;
import cn.fjnu.officeSystem.entity.Item;
import cn.fjnu.officeSystem.entity.ItemClassificationSummary;
import cn.fjnu.officeSystem.entity.ItemProcurement;
import cn.fjnu.officeSystem.entity.OutStorageCheckIn;
import cn.fjnu.officeSystem.entity.OutStorageType;
import cn.fjnu.officeSystem.entity.RecipientApply;
import cn.fjnu.officeSystem.entity.StaffRecipientSummary;
import cn.fjnu.officeSystem.extend.BrrowApplyExtend;
import cn.fjnu.officeSystem.extend.ItemProcurementExtend;
import cn.fjnu.officeSystem.extend.RecipientApplyExtend;
import cn.fjnu.officeSystem.utils.DateJsonValueProcessor;
import cn.fjnu.officeSystem.utils.PageUtil;
import cn.fjnu.officeSystem.utils.SystemUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
 * 出库登记界面
 * 
 * @author zsy
 *
 */
@Service
public class OutStorageService {

	@Resource
	BorrowApplyDao borrowApplyDao;
	@Resource
	OutStorageTypeDao outStorageTypeDao;
	@Resource
	RecipientApplyDao recipientApplyDao;
	@Resource
	ItemClassificationSummaryDao itemClassificationSummaryDao;
	@Resource
	SystemUtil systemUtil;
	@Resource
	OutStorageCheckInDao outStorageCheckInDao;
	@Resource
	DepartmentRecipientSummaryDao departmentRecipientSummaryDao;
	@Resource
	StaffRecipientSummaryDao staffRecipientSummaryDao;
	@Resource
	ItemDao itemDao;

	// 选择出库类型(1.借用，2.领用，3.赠予)
	public String getOutstorageType() {
		// 获取数据库中所有出库类型
		List<OutStorageType> outStorageTypes = outStorageTypeDao.selectAllOutStorageTypes();
		if (outStorageTypes.size() == 0) {// 数据库中没有数据
			return "{\"message\":\"nothing\"}";
		} else {
			// 由list-->JSONArray-->String
			String result = JSONArray.fromObject(outStorageTypes).toString();
			return result;
		}
	}

	// 根据选择的出库类型跳转到对应的界面并显示数据
	public String getOutstorageHome(String json) {
		// json字符串转json对象
		JSONObject jsonObject = JSONObject.fromObject(json);
		// 解析json中的数据为相应的类型
		String outStorageTypeId = jsonObject.optString("outStorageTypeId");
		int pageIndex = jsonObject.optInt("pageIndex");
		int pageCount = jsonObject.optInt("pageCount");
		int count = 0;// 统计总条数
		String result = null;// 返回json字符串给前端
		Map<String, Object> resultMap = new HashMap<>();
		if (outStorageTypeId.equals("1")) {// 借用类型
			count = borrowApplyDao.selectBorrowApplyAuditAndPassCount();
			if (count > 0) {
				PageUtil<BrrowApplyExtend> page = new PageUtil<>(pageIndex, count, pageCount);
				List<BrrowApplyExtend> resultList = borrowApplyDao.selectBorrowApplyAuditAndPass(page.getDataStart(),
						page.getDataEnd());
				resultMap.put("resultList", resultList);// 数据
				resultMap.put("pageSize", page.getPageSize());// 总页数
				System.out.println("map:" + resultMap);
			}
		} else if (outStorageTypeId.equals("2")) {// 领用类型
			count = recipientApplyDao.selectRecipientApplyAuditAndPassCount();
			if (count > 0) {
				PageUtil<RecipientApplyExtend> page = new PageUtil<>(pageIndex, count, pageCount);
				List<RecipientApplyExtend> resultList = recipientApplyDao
						.selectRecipientApplyAuditAndPass(page.getDataStart(), page.getDataEnd());
				resultMap.put("resultList", resultList);
				resultMap.put("pageSize", page.getPageSize());
			}
		} else if (outStorageTypeId.equals("3")) {// 赠予类型
			count = itemClassificationSummaryDao.selectAllItemClassificationSummaryCount();
			if (count > 0) {
				PageUtil<ItemClassificationSummary> page = new PageUtil<>(pageIndex, count, pageCount);
				List<ItemClassificationSummary> resultList = itemClassificationSummaryDao
						.selectAllItemClassificationSummaries();
				resultMap.put("resultList", resultList);
				resultMap.put("pageSize", page.getPageSize());
			}
		} else {
			return "{\"message\":\"当前还未实现此功能的出库登记\"}";
		}
		if (count > 0) {
			JsonConfig config = new JsonConfig();
			// 转换时记得要导入util.date
			config.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd hh:mm:ss"));
			resultMap.put("pageIndex", pageIndex);

			result = JSONObject.fromObject(resultMap, config).toString();
			return result;

		} else {
			return "{\"message\":\"该类型下无记录\"}";
		}
		// result=JSONObject.fromObject(resultMap).toString();
		// return result;

	}

	// 单条出库操作
	@Transactional
	public String operateOutStorageCheckIn(String json) {
		// 插入出库登记表，部门领用汇总表，人员领用汇总表
		JSONObject jsonObject = JSONObject.fromObject(json);
		JSONObject outStorageCheckInObject = jsonObject.optJSONObject("outStorageCheckIn");
		String outStorageTypeId = jsonObject.optString("outStorageTypeId");
		OutStorageCheckIn outStorageCheckIn = (OutStorageCheckIn) outStorageCheckInObject
				.toBean(outStorageCheckInObject, OutStorageCheckIn.class);
		// 生成出库登记表主键
		String key = systemUtil.gerneratorKey(TableEnum.outStorageCheckIn);
		outStorageCheckIn.setId(key);
		// 出库类型（根据选择的页面判断），领用人id，领用部门id,制单人（管理员），数量，金额
		// 插入出库登记表
		int succ = outStorageCheckInDao.insertOutStorageCheckIn(outStorageCheckIn);
		if (succ == 1) {
			if (outStorageTypeId.equals("1")) {// 借用类型
				JSONObject borrowApplyObject = jsonObject.optJSONObject("borrowApply");
				BorrowApply borrowApply = (BorrowApply) borrowApplyObject.toBean(borrowApplyObject, BorrowApply.class);
				DepartmentRecipientSummary departmentRecipientSummary = new DepartmentRecipientSummary();
				// 完善部门领用汇总表
				departmentRecipientSummary.setDepartmentId(outStorageCheckIn.getDepartmentId());
				departmentRecipientSummary.setOutStorageCheckInId(key);
				departmentRecipientSummary.setItemId(borrowApply.getItemId());//
				departmentRecipientSummary.setItemName(borrowApply.getItemName());//
				departmentRecipientSummary.setSpec(borrowApply.getSpec());//
				departmentRecipientSummary.setItemTypeId(borrowApply.getItemTypeId());//
				departmentRecipientSummary
						.setMeasureUnitId(itemDao.selectItemById(borrowApply.getItemId()).getMeasureUnitId());// 通过itemId查到item
				departmentRecipientSummary.setPrice(borrowApply.getPrice());//
				departmentRecipientSummary.setNumber(outStorageCheckIn.getTotalNumber());//
				departmentRecipientSummary.setMonney(outStorageCheckIn.getTotalMonney());//
				departmentRecipientSummary.setOutStorageId(outStorageCheckIn.getOutStorageTypeId());//
				succ = departmentRecipientSummaryDao.insertDepartmentRecipientSummary(departmentRecipientSummary);
				if (succ == 1) {
					StaffRecipientSummary staffRecipientSummary = new StaffRecipientSummary();
					// 完善人员领用汇总表
					staffRecipientSummary.setStaffId(borrowApply.getBorrower().toString());////
					staffRecipientSummary.setOutStorageCheckInId(key);
					staffRecipientSummary.setItemId(borrowApply.getItemId());
					staffRecipientSummary.setItemName(borrowApply.getItemName());
					staffRecipientSummary.setItemTypeId(borrowApply.getItemTypeId());
					staffRecipientSummary.setSpec(borrowApply.getSpec());
					staffRecipientSummary
							.setMeasureUnitId(itemDao.selectItemById(borrowApply.getItemId()).getMeasureUnitId());
					staffRecipientSummary.setPrice(borrowApply.getPrice());
					staffRecipientSummary.setNumber(outStorageCheckIn.getTotalNumber());
					staffRecipientSummary.setMonney(outStorageCheckIn.getTotalMonney());
					succ = staffRecipientSummaryDao.insertStaffRecipientSummary(staffRecipientSummary);
					if (succ == 1) {
						return "{\"message\":\"此借用申请出库成功！\"}";

					} else {
						return "{\"message\":\"人员领用表插入失败！\"}";

					}

				} else {
					return "{\"message\":\"部门领用表插入失败！\"}";
				}
			} else if (outStorageTypeId.equals("2")) {// 领用类型
				JSONObject recipientApplyObject = jsonObject.optJSONObject("recipientApply");
				RecipientApply recipientApply = (RecipientApply) recipientApplyObject.toBean(recipientApplyObject,
						RecipientApply.class);
				// 完善部门领用汇总表
				DepartmentRecipientSummary departmentRecipientSummary = new DepartmentRecipientSummary();
				departmentRecipientSummary.setDepartmentId(outStorageCheckIn.getDepartmentId());
				departmentRecipientSummary.setOutStorageCheckInId(key);
				departmentRecipientSummary.setItemId(recipientApply.getItemId());//
				departmentRecipientSummary.setItemName(recipientApply.getItemName());//
				departmentRecipientSummary.setSpec(recipientApply.getSpec());//
				departmentRecipientSummary.setItemTypeId(recipientApply.getItemTypeId());//
				departmentRecipientSummary
						.setMeasureUnitId(itemDao.selectItemById(recipientApply.getItemId()).getMeasureUnitId());
				departmentRecipientSummary.setPrice(recipientApply.getPrice());//
				departmentRecipientSummary.setNumber(outStorageCheckIn.getTotalNumber());//
				departmentRecipientSummary.setMonney(outStorageCheckIn.getTotalMonney());//
				departmentRecipientSummary.setOutStorageId(outStorageCheckIn.getOutStorageTypeId());//
				succ = departmentRecipientSummaryDao.insertDepartmentRecipientSummary(departmentRecipientSummary);
				if (succ == 1) {
					StaffRecipientSummary staffRecipientSummary = new StaffRecipientSummary();
					// 完善人员领用汇总表
					staffRecipientSummary.setStaffId(recipientApply.getRecipienter().toString());////
					staffRecipientSummary.setOutStorageCheckInId(key);
					staffRecipientSummary.setItemId(recipientApply.getItemId());
					staffRecipientSummary.setItemName(recipientApply.getItemName());
					staffRecipientSummary.setItemTypeId(recipientApply.getItemTypeId());
					staffRecipientSummary.setSpec(recipientApply.getSpec());
					staffRecipientSummary
							.setMeasureUnitId(itemDao.selectItemById(recipientApply.getItemId()).getMeasureUnitId());
					staffRecipientSummary.setPrice(recipientApply.getPrice());
					staffRecipientSummary.setNumber(outStorageCheckIn.getTotalNumber());
					staffRecipientSummary.setMonney(outStorageCheckIn.getTotalMonney());
					succ = staffRecipientSummaryDao.insertStaffRecipientSummary(staffRecipientSummary);
					if (succ == 1) {
						return "{\"message\":\"此领用申请出库成功！\"}";

					} else {
						return "{\"message\":\"人员领用表插入失败！\"}";

					}

				} else {
					return "{\"message\":\"部门领用表插入失败！\"}";
				}
			} else if (outStorageTypeId.equals("3")) {// 赠予类型
				return "{\"message\":\"此赠予记录出库成功！\"}";
			} else {
				return "{\"message\":\"传入的出库类型有误！\"}";
			}

		} else {
			return "{\"message\":\"出库登记表插入失败！\"}";
		}
	}

	// 批量出库操作
	@Transactional
	public String OperateOutStorageCheckInPL(String json) {

		return json;

	}

	// 出库统计
	public String getOutstorageSummary(String json) {
		JSONObject jsonObject = JSONObject.fromObject(json);
		int outStorageTypeId = jsonObject.optInt("outStorageTypeId");
		int pageIndex = jsonObject.optInt("pageIndex");
		int pageCount = jsonObject.optInt("pageCount");
		// String outStorageDate=jsonObject.optString("outStorageDate");
		// //date转string
		// String recipienter=jsonObject.optString("recipienter");
		// String departmentId=jsonObject.optString("departmentId");
		// String applyId=jsonObject.optString("applyId");
		// String operaterId=jsonObject.optString("operaterId");

		int count = 0;
		count = outStorageCheckInDao.selectOutStorageCheckInByMapCount(null, (short) outStorageTypeId, null, null, null,
				null);
		Map<String, Object> resultMap = new HashMap<>();
		String result = null;
		if (count > 0) {
			PageUtil<ItemProcurementExtend> page = new PageUtil<>(pageIndex, count, pageCount);
			List<OutStorageCheckIn> resultList = outStorageCheckInDao.selectOutStorageCheckInByMap(null,
					(short) outStorageTypeId, null, null, null, null, page.getDataStart(), page.getDataEnd());
			resultMap.put("resultList", resultList);

			resultMap.put("pageSize", page.getPageSize());
			 JsonConfig config = new JsonConfig();
			 config.registerJsonValueProcessor(Date.class, new
			 DateJsonValueProcessor("yyyy-MM-dd hh:mm:ss"));
			 resultMap.put("pageIndex", pageIndex);
			
			 result=jsonObject.fromObject(resultMap, config).toString();
			 return result;
//			result = JSONObject.fromObject(resultMap).toString();
//			return result;
			//java.util.Date date = new Date(emp.getHiredate().getTime());  
			//emp.setHiredate(date);  

		} else {
			return "{\"message\":\"nothing\"}";
		}
	}

}
