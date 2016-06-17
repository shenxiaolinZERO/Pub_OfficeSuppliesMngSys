package cn.fjnu.officeSystem.entity;

import java.util.Date;

public class ItemProcurement {// 物品采购清单
	private String id;

	private String itemId;// 物品编号（系统已有）

	private String supplierId;// 供应商id（选一下或添加一下）

	private String staffId;// 采购人员

	private long num;// 采购数量

	private String itemTypeId;// 物品分类

	private String itemName;// 物品名称
	
	private String measureUnitId;//计量单位

	private String spec;// 规格型号

	private Double price;// 单价（不管有没有都让它填）

	private Double monney;// 金额

	private Date time;// 采购时间
	
	private Date endTime;//采购完成时间
	
	private Short isInStorage;//是否已被登记入库

	private String remark;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public long getNum() {
		return num;
	}

	public void setNum(long num) {
		this.num = num;
	}

	public String getItemTypeId() {
		return itemTypeId;
	}

	public void setItemTypeId(String itemTypeId) {
		this.itemTypeId = itemTypeId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getMonney() {
		return monney;
	}

	public void setMonney(Double monney) {
		this.monney = monney;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
		
	}

	public Short getIsInStorage() {
		return isInStorage;
	}

	public void setIsInStorage(Short isInStorage) {
		this.isInStorage = isInStorage;
	}


	

	
	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getMeasureUnitId() {
		return measureUnitId;
	}

	public void setMeasureUnitId(String measureUnitId) {
		this.measureUnitId = measureUnitId;
	}
	


	@Override
	public String toString() {
		return "ItemProcurement [id=" + id + ", itemId=" + itemId + ", supplierId=" + supplierId + ", staffId="
				+ staffId + ", num=" + num + ", itemTypeId=" + itemTypeId + ", itemName=" + itemName
				+ ", measureUnitId=" + measureUnitId + ", spec=" + spec + ", price=" + price + ", monney=" + monney
				+ ", time=" + time + ", endTime=" + endTime + ", isInStorage=" + isInStorage + ", remark=" + remark
				+ "]";
	}
	
	

	public ItemProcurement(String id, String itemId, String supplierId, String staffId, long num, String itemTypeId,
			String itemName, String measureUnitId, String spec, Double price, Double monney, Date time, Date endTime,
			Short isInStorage, String remark) {
		super();
		this.id = id;
		this.itemId = itemId;
		this.supplierId = supplierId;
		this.staffId = staffId;
		this.num = num;
		this.itemTypeId = itemTypeId;
		this.itemName = itemName;
		this.measureUnitId = measureUnitId;
		this.spec = spec;
		this.price = price;
		this.monney = monney;
		this.time = time;
		this.endTime = endTime;
		this.isInStorage = isInStorage;
		this.remark = remark;
	}

	public ItemProcurement() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
