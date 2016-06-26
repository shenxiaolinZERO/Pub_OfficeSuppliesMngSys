package cn.fjnu.officeSystem.service;

public interface InStorageCheckInService {
	public String getInstorageType();

	// 根据选择的入库类型传回相应的首页
	public String getInstorageHome(String json);

	// 受赠时如果如果该系统中没有该物品分类则新增物品分类
	public String addItemType(String json);
	// 受赠入库:物品编号不要，物品上下限保留，单条入库

	public String sendInStorage(String json);

	// 采购入库
	public String procurementInStorage(String json);

	// 归还入库
	public String returnInStorage(String json);

	// 采购入库查询
	public String getItemProcurementByMap(String itemName,String itemTypeId,String staffId);

	// 借还入库查询
	public String getBorrowApplyByMap(String itemName,String itemTypeId,String staffId);

	// 入库统计
	public String getInstorageSumary(String json);

}
