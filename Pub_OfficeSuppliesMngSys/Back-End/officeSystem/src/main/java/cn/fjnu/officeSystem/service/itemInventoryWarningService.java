package cn.fjnu.officeSystem.service;



public interface itemInventoryWarningService {

	// 该页的查询条件有状态、物品分类Id、物品名称、获取超过上限的物品、获取低于下限的物品
	public String getWarningInfo(String json);

	// 对于低于下限的物品--写入预采购单
	public String addPreItemProcurement(String json);
}
