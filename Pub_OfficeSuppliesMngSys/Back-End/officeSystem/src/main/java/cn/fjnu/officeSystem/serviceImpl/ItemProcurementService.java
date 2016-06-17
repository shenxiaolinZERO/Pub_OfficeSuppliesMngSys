package cn.fjnu.officeSystem.serviceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.fjnu.officeSystem.Enum.TableEnum;
import cn.fjnu.officeSystem.dao.ItemDao;
import cn.fjnu.officeSystem.dao.ItemProcurementDao;
import cn.fjnu.officeSystem.dao.PreItemProcurementDao;
import cn.fjnu.officeSystem.dao.ProcurementApplyDao;
import cn.fjnu.officeSystem.entity.Item;
import cn.fjnu.officeSystem.entity.ItemProcurement;
import cn.fjnu.officeSystem.entity.PreItemProcurement;
import cn.fjnu.officeSystem.entity.ProcurementApply;
import cn.fjnu.officeSystem.extend.ItemProcurementExtend;
import cn.fjnu.officeSystem.extend.PreItemProcurementExtend;
import cn.fjnu.officeSystem.extend.ProcurementApplyExtend;
import cn.fjnu.officeSystem.utils.DateJsonValueProcessor;
import cn.fjnu.officeSystem.utils.PageUtil;
import cn.fjnu.officeSystem.utils.SystemUtil;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

@Service
public class ItemProcurementService implements cn.fjnu.officeSystem.service.ItemProcurementService {
	@Resource
	ItemProcurementDao itemProcurementDao;
	@Resource
	PreItemProcurementDao preItemProcurementDao;
	@Resource
	ProcurementApplyDao procurementApplyDao;
	@Resource
	ItemDao itemDao;
	@Resource
	SystemUtil systemUtil;

	// 采购申请首页
	@Override
	public String getItemProcurementApplyHome(int pageIndex, int pageCount, String staffId, String itemTypeId,
			String itemName, String itemId, String preStartTimeStr, String preEndTimeStr, String applyTimeSort)
					throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date preStartTime = sdf.parse(preStartTimeStr);
		Date preEndTime = sdf.parse(preEndTimeStr);
		int count = 0;// 统计总记录条数
		String result = null;
		Map<String, Object> resultMap = new HashMap<>();
		count = preItemProcurementDao.selectUnAuditPreItemProcurementCountByMap(staffId, itemTypeId, itemName, itemId,
				preStartTime, preEndTime);
		if (count > 0) {
			PageUtil<ProcurementApplyExtend> page = new PageUtil<>(pageIndex, count, pageCount);
			List<ProcurementApplyExtend> resultList = procurementApplyDao.selectUnAuditProcurementApplyByMap(staffId,
					itemTypeId, itemName, itemId, preStartTime, preEndTime, applyTimeSort, page.getDataStart(),
					page.getDataEnd());
			resultMap.put("resultList", resultList);
			resultMap.put("pageSize", page.getPageSize());
			JsonConfig config = new JsonConfig();
			config.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd hh:mm:ss"));
			resultMap.put("pageIndex", pageIndex);
			JSONObject jsonObject = new JSONObject();
			result = jsonObject.fromObject(resultMap, config).toString();

		} else {
			return "{\"message\":\"nothing\"}";
		}

		return result;

	}

	// 不通过--填写预采购理由
	@Override
	public String notPassItemProcurementApply(String applyId, String staffId, String reason) {
		ProcurementApply procurementApply = procurementApplyDao.selectProcurementApplyByapplyId(applyId);
		ProcurementApply procurementApply1 = new ProcurementApply();
		procurementApply1.setAuditStaffId(staffId);
		procurementApply1.setAuditTime(new Date());
		procurementApply1.setIsProcuremnet(new Short("0"));
		procurementApply1.setReason(reason);
		int result = procurementApplyDao.updateProcurementApply(procurementApply1);// 更新采购申请表的数据
		if (result == 1) {
			return "{\"message\":\"success\"}";

		} else {
			return "{\"message\":\"error\"}";
		}
	}

	// 确定预采购--将采购申请写入预采购清单
	@Override
	public String confirmPreItemProcurement(String applyId, String staffId) {
		ProcurementApply procurementApply = procurementApplyDao.selectProcurementApplyByapplyId(applyId);
		ProcurementApply procurementApply1 = new ProcurementApply();
		procurementApply1.setAuditStaffId(staffId);
		procurementApply1.setAuditTime(new Date());
		procurementApply1.setIsProcuremnet(new Short("1"));
		procurementApplyDao.updateProcurementApply(procurementApply1);// 更新采购申请表的数据
		int isPre = preItemProcurementDao.updateIsApplyByMap(procurementApply1.getItemTypeId(),
				procurementApply1.getItemName(), procurementApply1.getMeasureUnitId(), procurementApply1.getNum());
		if (isPre == 0) {
			// 将采购申请写入预采购清单
			PreItemProcurement preItemProcurement = new PreItemProcurement();
			preItemProcurement.setItemId(procurementApply.getItemId());
			preItemProcurement.setItemName(procurementApply.getItemName());
			preItemProcurement.setItemTypeId(procurementApply.getItemTypeId());
			preItemProcurement.setMeasureUnitId(procurementApply.getMeasureUnitId());
			preItemProcurement.setNum(procurementApply.getNum());
			int result = preItemProcurementDao.insertPreItemProcurement(preItemProcurement);
			if (result == 1) {
				return "{\"message\":\"success\"}";

			} else {
				return "{\"message\":\"error\"}";
			}

		} else {
			return "{\"message\":\"success\"}";
		}

	}

	// 历史预采购清单
	@Override
	public String getPreItemProcurementHome(int pageIndex, int pageCount, String staffId, String itemTypeId,
			String itemName, String itemId, String preTimeSort, String preStartTimestr, String preEndTimestr)
					throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date preStartTime = sdf.parse(preStartTimestr);
		Date preEndTime = sdf.parse(preEndTimestr);
		int count = 0;// 统计总记录条数
		String result = null;
		Map<String, Object> resultMap = new HashMap<>();
		count = preItemProcurementDao.selectUnAuditPreItemProcurementCountByMap(staffId, itemTypeId, itemName, itemId,
				preStartTime, preEndTime);
		if (count > 0) {
			PageUtil<PreItemProcurementExtend> page = new PageUtil<>(pageIndex, count, pageCount);
			List<PreItemProcurementExtend> resultList = preItemProcurementDao.selectUnAuditPreItemProcurementByMap(
					staffId, itemTypeId, itemName, itemId, preStartTime, preEndTime, preTimeSort, page.getDataStart(),
					page.getDataEnd());
			resultMap.put("resultList", resultList);
			resultMap.put("pageSize", page.getPageSize());
			JsonConfig config = new JsonConfig();
			config.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd hh:mm:ss"));
			resultMap.put("pageIndex", pageIndex);
			JSONObject jsonObject = new JSONObject();
			result = jsonObject.fromObject(resultMap, config).toString();

		} else {
			return "{\"message\":\"nothing\"}";
		}

		return result;

	}

	// 点击采购、
	@Transactional
	@Override
	public String purchase(Item item, ItemProcurement itemProcurement) {
		/**
		 * { "item": { "itemName": "物品名称", "itemTypeId": "物品分类id", "spec":
		 * "规格名称", "measureUnitId": "计量单位id", "supplierId": "供应商id",
		 * "maxInventory": "库存上限（如果系统没有供应商，要新增供应商时，则必须得同时填写库存上下限，要新建物品）",
		 * "minInventory": "库存下限" }, "itemProcurement": { "num":
		 * "采购数量（跟过来，但还是让其选填）", "staffId": "采购人员", "price": "价格" } }
		 */
		if (item.getMaxInventory() != 0 && item.getMinInventory() != 0) {
			// 根据其它条件判断该系统是否存在该物品
			String itemId = itemDao.selectIdByMap(item.getItemName(), item.getItemTypeId(), item.getSpec(),
					item.getMeasureUnitId(), item.getSupplierId());
			if (itemId != null) {
				item.setItemId(itemId);

			} else {
				// 返回填写物品信息不全，缺少上下限
				return "{\"message\":\"datanoquan\"}";
			}

		} else {
			String key = systemUtil.gerneratorKey(TableEnum.item);
			item.setItemId(key);
			itemDao.insertItem(item);// 插入数据到物品表中
		}
		// 将数据加到物品采购清单表中
		itemProcurement.setItemId(item.getItemId());
		itemProcurement.setItemName(item.getItemName());
		itemProcurement.setItemTypeId(item.getItemTypeId());
		itemProcurement.setMeasureUnitId(item.getMeasureUnitId());
		itemProcurement.setSpec(item.getSpec());
		itemProcurement.setSupplierId(item.getSupplierId());
		int result = itemProcurementDao.insertItemProcurement(itemProcurement);
		if (result == 1) {
			return "{\"message\":\"success\"}";

		} else {
			return "{\"message\":\"error\"}";
		}

	}

	// 待采购清单（物品采购表中未入库登记）
	@Override
	public String getUnInStorageItemProcurement(ItemProcurement itemProcurement, int timeSort, int pageCount,
			int pageIndex) {

		int count = 0;// 统计总记录条数
		String result = null;
		Map<String, Object> resultMap = new HashMap<>();
		count = itemProcurementDao.selectUnInStorageItemProcurementCount(itemProcurement);
		if (count > 0) {
			PageUtil<ItemProcurementExtend> page = new PageUtil<>(pageIndex, count, pageCount);
			List<ItemProcurementExtend> resultList = itemProcurementDao.selectUnInStorageItemProcurement(
					itemProcurement.getSupplierId(), itemProcurement.getStaffId(), itemProcurement.getItemTypeId(),
					itemProcurement.getItemName(), timeSort, page.getDataStart(), page.getDataEnd());
			resultMap.put("resultList", resultList);
			resultMap.put("pageSize", page.getPageSize());
			JsonConfig config = new JsonConfig();
			config.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd hh:mm:ss"));
			resultMap.put("pageIndex", pageIndex);
			JSONObject jsonObject = new JSONObject();
			result = jsonObject.fromObject(resultMap, config).toString();

		} else {
			return "{\"message\":\"nothing\"}";
		}

		return result;

	}

	// 已采购清单（物品采购表中已入库登记）
	@Override
	public String getInStorageItemProcurement(ItemProcurement itemProcurement, int endTimeSort, int pageCount,
			int pageIndex) {
		/**
		 * { "itemProcurement": { "supplierId": "供应商id", "staffId": "员工号",
		 * "itemTypeId": "物品分类id", "itemName": "物品名称" }, "endTimeSort":
		 * "结束时间排序规则", "pageIndex": "索引开始值", "pageCount": "页长" }
		 */
		int count = 0;// 统计总记录条数
		String result = null;
		Map<String, Object> resultMap = new HashMap<>();
		count = itemProcurementDao.selectInStorageItemProcurementCount(itemProcurement);
		if (count > 0) {
			PageUtil<ItemProcurementExtend> page = new PageUtil<>(pageIndex, count, pageCount);
			List<ItemProcurementExtend> resultList = itemProcurementDao.selectInStorageItemProcurement(
					itemProcurement.getSupplierId(), itemProcurement.getStaffId(), itemProcurement.getItemTypeId(),
					itemProcurement.getItemName(), endTimeSort, page.getDataStart(), page.getDataEnd());
			resultMap.put("resultList", resultList);
			resultMap.put("pageSize", page.getPageSize());
			JsonConfig config = new JsonConfig();
			config.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd hh:mm:ss"));
			resultMap.put("pageIndex", pageIndex);
			JSONObject jsonObject = new JSONObject();
			result = jsonObject.fromObject(resultMap, config).toString();

		} else {
			return "{\"message\":\"nothing\"}";
		}

		return result;

	}

}
