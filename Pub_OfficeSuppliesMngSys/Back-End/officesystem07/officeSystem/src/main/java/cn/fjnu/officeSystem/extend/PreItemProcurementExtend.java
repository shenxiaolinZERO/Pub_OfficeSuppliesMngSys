package cn.fjnu.officeSystem.extend;



import java.util.Date;

import cn.fjnu.officeSystem.entity.PreItemProcurement;

public class PreItemProcurementExtend extends PreItemProcurement {
	private String itemTypeName;//物品分类名称
	
	private String measureUnitName;//计量单位名称
	
	private String staffName;//制单人名称

	public String getItemTypeName() {
		return itemTypeName;
	}

	public void setItemTypeName(String itemTypeName) {
		this.itemTypeName = itemTypeName;
	}

	public String getMeasureUnitName() {
		return measureUnitName;
	}

	public void setMeasureUnitName(String measureUnitName) {
		this.measureUnitName = measureUnitName;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public PreItemProcurementExtend(String itemTypeName, String measureUnitName, String staffName) {
		super();
		this.itemTypeName = itemTypeName;
		this.measureUnitName = measureUnitName;
		this.staffName = staffName;
	}

	public PreItemProcurementExtend() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PreItemProcurementExtend(String id, String itemId, String itemTypeId, String itemName, Long num,
			String staffId, String measureUnitId, Date preTime, Date auditTime, String remark) {
		super(id, itemId, itemTypeId, itemName, num, staffId, measureUnitId, preTime, auditTime, remark);
		// TODO Auto-generated constructor stub
	}
	
	
	

}
