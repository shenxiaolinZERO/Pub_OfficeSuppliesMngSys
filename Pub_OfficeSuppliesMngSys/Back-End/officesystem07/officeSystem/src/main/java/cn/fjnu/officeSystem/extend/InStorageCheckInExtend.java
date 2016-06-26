package cn.fjnu.officeSystem.extend;

import cn.fjnu.officeSystem.entity.InStorageCheckIn;

public class InStorageCheckInExtend extends InStorageCheckIn{
	
	private String itemId;//物品编号
	private String itemName;//物品名
	private String itemTypeId;//物品类型名
	private String itemTypeName;//物品类型名字
	private String spec;//规格
    private String supplierName;//供应商简称
    private String agentName;//经办人员名字
    private String operaterName;//入库登记人的名字
    private String inStorageTypeName;//入库类型名称
    public String measureUnitName;//计量单位名称
    
    
	@Override
	public String toString() {
		return "InStorageCheckInExtend [itemId=" + itemId + ", itemName=" + itemName + ", itemTypeId=" + itemTypeId
				+ ", itemTypeName=" + itemTypeName + ", spec=" + spec + ", supplierName=" + supplierName
				+ ", agentName=" + agentName + ", operaterName=" + operaterName + ", inStorageTypeName="
				+ inStorageTypeName + ", measureUnitName=" + measureUnitName + "]";
	}
	public String getOperaterName() {
		return operaterName;
	}
	public void setOperaterName(String operaterName) {
		this.operaterName = operaterName;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemTypeId() {
		return itemTypeId;
	}
	public void setItemTypeId(String itemTypeId) {
		this.itemTypeId = itemTypeId;
	}
	public String getItemTypeName() {
		return itemTypeName;
	}
	public void setItemTypeName(String itemTypeName) {
		this.itemTypeName = itemTypeName;
	}
	public String getSpec() {
		return spec;
	}
	public void setSpec(String spec) {
		this.spec = spec;
	}
	
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getAgentName() {
		return agentName;
	}
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	public String getInStorageTypeName() {
		return inStorageTypeName;
	}
	public void setInStorageTypeName(String inStorageTypeName) {
		this.inStorageTypeName = inStorageTypeName;
	}
	public String getMeasureUnitName() {
		return measureUnitName;
	}
	public void setMeasureUnitName(String measureUnitName) {
		this.measureUnitName = measureUnitName;
	}
    
    

}
