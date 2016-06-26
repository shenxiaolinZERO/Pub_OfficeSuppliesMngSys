package cn.fjnu.officeSystem.service;

public interface IOutStorageService {

	// 选择出库类型(1.借用，2.领用，3.赠予)
	public String getOutstorageType();
	
	// 根据选择的出库类型跳转到对应的界面并显示数据
	public String getOutstorageHome(String json);
	
	// 单条出库操作
	public String operateOutStorageCheckIn(String json);
	
	//批量出库操作
	public String operateOutStorageCheckInPL(String json);
	
	// 出库统计
	public String getOutstorageSummary(String json);
}
