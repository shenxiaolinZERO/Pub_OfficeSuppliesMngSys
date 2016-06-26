package cn.fjnu.officeSystem.service;



import java.text.ParseException;

import cn.fjnu.officeSystem.entity.Item;
import cn.fjnu.officeSystem.entity.ItemProcurement;



public interface ItemProcurementService {
	// 采购申请首页
	public String getItemProcurementApplyHome(int pageIndex, int pageCount, String staffId, String itemTypeId,
			String itemName, String itemId, String preStartTimeStr, String preEndTimeStr, String applyTimeSort)throws ParseException;

	// 不通过--填写预采购理由
	public String notPassItemProcurementApply(String applyId, String staffId, String reason);

	// 确定预采购--将采购申请写入预采购清单
	public String confirmPreItemProcurement(String applyId, String staffId);

	// 历史预采购清单
	public String getPreItemProcurementHome(int pageIndex, int pageCount, String staffId, String itemTypeId,
			String itemName, String itemId, String preTimeSort, String preStartTimestr, String preEndTimestr)throws ParseException;

	// 点击采购、
	public String purchase(Item item, ItemProcurement itemProcurement);

	// 待采购清单（物品采购表中未入库登记）
	public String getUnInStorageItemProcurement(ItemProcurement itemProcurement, int timeSort, int pageCount,
			int pageIndex);

	// 已采购清单（物品采购表中已入库登记）
	public String getInStorageItemProcurement(ItemProcurement itemProcurement, int endTimeSort, int pageCount,
			int pageIndex);

}
