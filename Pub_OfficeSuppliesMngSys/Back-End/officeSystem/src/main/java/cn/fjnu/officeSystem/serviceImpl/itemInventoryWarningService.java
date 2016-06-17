package cn.fjnu.officeSystem.serviceImpl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.fjnu.officeSystem.dao.ItemDao;
import cn.fjnu.officeSystem.dao.PreItemProcurementDao;
import cn.fjnu.officeSystem.dao.TransfiniteInventoryWarningDao;
import cn.fjnu.officeSystem.entity.Item;
import cn.fjnu.officeSystem.entity.PreItemProcurement;
import cn.fjnu.officeSystem.extend.BrrowApplyXXExtend;
import cn.fjnu.officeSystem.extend.TransfiniteInventoryWarningExtend;
import cn.fjnu.officeSystem.utils.DateJsonValueProcessor;
import cn.fjnu.officeSystem.utils.PageUtil;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

@Service
public class itemInventoryWarningService implements cn.fjnu.officeSystem.service.itemInventoryWarningService{//库存预警--紧急通知
	@Resource
	TransfiniteInventoryWarningDao transfiniteInventoryWarningDao;
	@Resource
	ItemDao itemDao;

	@Resource
	PreItemProcurementDao preItemProcurementDao;
	//该页的查询条件有状态、物品分类Id、物品名称、获取超过上限的物品、获取低于下限的物品
	@Override
	public String getWarningInfo(String json){
		JSONObject jsonObject = JSONObject.fromObject(json);
		int pageIndex = jsonObject.optInt("pageIndex");
		int pageCount = jsonObject.optInt("pageCount");
		String itemTypeId=jsonObject.optString("itemTypeId");
		int state=jsonObject.optInt("state");
		String itemName=jsonObject.optString("itemName");
		System.out.println(state);
		int count = 0;// 统计总记录条数
		String result = null;
		Map<String, Object> resultMap = new HashMap<>();
		count = transfiniteInventoryWarningDao.selectAllWarningByMapCount(itemTypeId, state, itemName);
		if (count > 0) {
			PageUtil<TransfiniteInventoryWarningExtend> page = new PageUtil<>(pageIndex, count, pageCount);
			List<TransfiniteInventoryWarningExtend> resultList = transfiniteInventoryWarningDao.selectAllWarningByMap(itemTypeId, state, itemName, page.getDataStart(),page.getDataEnd());
			resultMap.put("resultList", resultList);
			resultMap.put("pageSize", page.getPageSize());
	

		}
		if (count > 0) {
			JsonConfig config = new JsonConfig();
			config.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd hh:mm:ss"));
			resultMap.put("pageIndex", pageIndex);

			result = jsonObject.fromObject(resultMap, config).toString();
			return result;

		} else {
			return "{\"message\":\"当前还没有库存预警的借用申请单\"}";
		}
		
		
	}

	
	//对于低于下限的物品--写入预采购单
	@Override
	public String addPreItemProcurement(String json){
		JSONObject jsonObject = JSONObject.fromObject(json);
		String itemId=jsonObject.optString("itemId");//物品id
		String staffId=jsonObject.optString("staffId");//制单人
		Long num=jsonObject.optLong("num");//采购数量
		String remark=jsonObject.optString("remark");
		//通过物品id得到物品信息
		Item item=itemDao.selectItemById(itemId);
		//完善预采购单信息
		PreItemProcurement preItemProcurement=new PreItemProcurement();
		preItemProcurement.setItemId(itemId);
		preItemProcurement.setItemName(item.getItemName());
		preItemProcurement.setItemTypeId(item.getItemTypeId());
		System.out.println(item.getItemTypeId());
		preItemProcurement.setNum(num);
		preItemProcurement.setRemark(remark);
		preItemProcurement.setStaffId(staffId);
		preItemProcurement.setMeasureUnitId(item.getMeasureUnitId());
		//插入预采购单信息
		int result=preItemProcurementDao.insertPreItemProcurement(preItemProcurement);
		if (result==1) {
			return "{\"message\":\"success\"}";
		}else{
			return "{\"message\":\"error\"}";
		}
	}
	
	//对于超过上限的物品--清理出库(跳到出库登记的界面、顺便再把物品信息带过去，由用户填写下出库数量即可)
	
}
