package cn.fjnu.officeSystem.entity;

public class Item {
	private String itemId;//物品编号
	private String itemName;//物品名
	private String itemTypeId;//物品类型名
	private String spec;//规格
	private String measureUnitId;//单位
	private Integer maxInventory;//库存上限
	private Integer minInventory;//库存下限
	private String supplierId;//供应商id
	private String remark;//备注
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", itemTypeId=" + itemTypeId + ", spec=" + spec
				+ ", measureUnitId=" + measureUnitId + ", maxInventory=" + maxInventory + ", minInventory="
				+ minInventory + ", supplierId=" + supplierId + ", remark=" + remark + "]";
	}
	public Item(String itemId, String itemName, String itemTypeId, String spec, String measureUnitId,
			Integer maxInventory, Integer minInventory, String supplierId, String remark) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemTypeId = itemTypeId;
		this.spec = spec;
		this.measureUnitId = measureUnitId;
		this.maxInventory = maxInventory;
		this.minInventory = minInventory;
		this.supplierId = supplierId;
		this.remark = remark;
	}
	public Item() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getSpec() {
		return spec;
	}
	public void setSpec(String spec) {
		this.spec = spec;
	}
	public String getMeasureUnitId() {
		return measureUnitId;
	}
	public void setMeasureUnitId(String measureUnitId) {
		this.measureUnitId = measureUnitId;
	}
	public Integer getMaxInventory() {
		return maxInventory;
	}
	public void setMaxInventory(Integer maxInventory) {
		this.maxInventory = maxInventory;
	}
	public Integer getMinInventory() {
		return minInventory;
	}
	public void setMinInventory(Integer minInventory) {
		this.minInventory = minInventory;
	}
	public String getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	

}
