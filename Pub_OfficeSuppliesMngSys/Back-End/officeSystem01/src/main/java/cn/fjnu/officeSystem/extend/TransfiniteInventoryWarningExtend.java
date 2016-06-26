package cn.fjnu.officeSystem.extend;

import cn.fjnu.officeSystem.entity.TransfiniteInventoryWarning;

public class TransfiniteInventoryWarningExtend extends TransfiniteInventoryWarning{
	
	private int state;//状态（1,超于上限；2，低于下限）
	
	private String supplierName;//供应商名称
	
	private String itemTypeName;//物品类型名称
	
	public String measureUnitName;//计量单位名称

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

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
	
	
	
	

}
