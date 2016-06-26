package cn.fjnu.officeSystem.serviceImpl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.stereotype.Service;

import cn.fjnu.officeSystem.dao.BorrowApplyDao;
import cn.fjnu.officeSystem.extend.BrrowApplyExtend;
import cn.fjnu.officeSystem.extend.BrrowApplyXXExtend;
import cn.fjnu.officeSystem.extend.ItemProcurementExtend;
import cn.fjnu.officeSystem.utils.DateJsonValueProcessor;
import cn.fjnu.officeSystem.utils.PageUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

@Service
public class OverTimeBorrowApplyService implements cn.fjnu.officeSystem.service.OverTimeBorrowApplyService{// 主要针对已借出的且库存紧张的、已超期物品
	@Resource
	BorrowApplyDao borrowApplyDao;

	// 获取借用物品处于库存预警的界面
	@Override
	public String getBorrowApplyWarningHome(String json) {
		JSONObject jsonObject = JSONObject.fromObject(json);
		int pageIndex = jsonObject.optInt("pageIndex");
		int pageCount = jsonObject.optInt("pageCount");
		int count = 0;// 统计总记录条数
		String result = null;
		Map<String, Object> resultMap = new HashMap<>();
		count = borrowApplyDao.selectBorrowedXXAppliesCount();
		if (count > 0) {
			PageUtil<BrrowApplyXXExtend> page = new PageUtil<>(pageIndex, count, pageCount);
			List<BrrowApplyXXExtend> resultList = borrowApplyDao.selectBorrowedXXApplies(page.getDataStart(),
					page.getDataEnd());
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
	//已超期且库存紧张的
	@Override
	public String getBorrowApplyWarningPassHome(String json) {
		JSONObject jsonObject = JSONObject.fromObject(json);
		int pageIndex = jsonObject.optInt("pageIndex");
		int pageCount = jsonObject.optInt("pageCount");
		int count = 0;// 统计总记录条数
		String result = null;
		Map<String, Object> resultMap = new HashMap<>();
		count = borrowApplyDao.selectBorrowedXXPassAppliesCount();
		if (count > 0) {
			PageUtil<BrrowApplyXXExtend> page = new PageUtil<>(pageIndex, count, pageCount);
			List<BrrowApplyXXExtend> resultList = borrowApplyDao.selectBorrowedXXPassApplies(page.getDataStart(),
					page.getDataEnd());
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
			return "{\"message\":\"当前还没有已超期的库存预警的借用申请单\"}";
		}
		
		

	}
	//根据物品编号查询相应状态
	@Override
	public String getBorrowedXXPassAppliesByItemId(String itemId){
		List<BrrowApplyXXExtend> resultList=borrowApplyDao.selectBorrowedXXPassAppliesByItemId(itemId);
		JsonConfig config = new JsonConfig();
		config.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd hh:mm:ss"));
		JSONArray jsonArray=JSONArray.fromObject(resultList,config);
		return jsonArray.toString();
		
	}
	@Override
	public String getBorrowedXXAppliesByItemId(String itemId){
		List<BrrowApplyXXExtend> resultList=borrowApplyDao.selectBorrowedXXAppliesByItemId(itemId);
		JsonConfig config = new JsonConfig();
		config.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd hh:mm:ss"));
		JSONArray jsonArray=JSONArray.fromObject(resultList,config);
		return jsonArray.toString();
		
	}
	
	
	

}
