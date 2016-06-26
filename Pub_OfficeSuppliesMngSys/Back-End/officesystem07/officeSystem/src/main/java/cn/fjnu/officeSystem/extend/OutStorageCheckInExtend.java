package cn.fjnu.officeSystem.extend;

import cn.fjnu.officeSystem.entity.OutStorageCheckIn;

public class OutStorageCheckInExtend extends OutStorageCheckIn{

	private String itemId;//物品编号
	private String itemName;//物品名
	private String itemTypeId;//物品类型名
	private String itemTypeName;//物品类型名字
	private String spec;//规格
    private String recipienterName;//领用者名字
    private String auditorName;//经办人员名字(审核人员)
    private String operaterName;//出库登记人的名字
    private String outStorageTypeName;//出库类型名称
	
	
    @Override
	public String toString() {
		return "OutStorageCheckInExtend [itemId=" + itemId + ", itemName=" + itemName + ", itemTypeId=" + itemTypeId
				+ ", itemTypeName=" + itemTypeName + ", spec=" + spec + ", recipienterName=" + recipienterName
				+ ", auditorName=" + auditorName + ", operaterName=" + operaterName + ", outStorageTypeName="
				+ outStorageTypeName + "]";
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
	public String getRecipienterName() {
		return recipienterName;
	}
	public void setRecipienterName(String recipienterName) {
		this.recipienterName = recipienterName;
	}
	public String getAuditorName() {
		return auditorName;
	}
	public void setAuditorName(String auditorName) {
		this.auditorName = auditorName;
	}
	public String getOperaterName() {
		return operaterName;
	}
	public void setOperaterName(String operaterName) {
		this.operaterName = operaterName;
	}
	public String getOutStorageTypeName() {
		return outStorageTypeName;
	}
	public void setOutStorageTypeName(String outStorageTypeName) {
		this.outStorageTypeName = outStorageTypeName;
	}
	
}
