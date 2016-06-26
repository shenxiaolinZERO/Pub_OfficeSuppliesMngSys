package cn.fjnu.officeSystem.entity;

import java.util.Date;

public class ItemSend {//赠送物品清单
	private String id;
	
	private String itemId;//物品编号
	
	private String staffId;//员工工号
	
	private Long num;//赠送数量
	
	private String itemTypeId;//物品分类id
	
	private String itemName;//物品名称
	
	private String measureUnitId;//计量单位id
	
	private String spec;//规格型号
	
	private Date time;//登记时间
	
	private int flag;//0出库，1入库
	
	private Short isInStorage;//是否已被登记入库(0,1)
	
	private String remark;//备注

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

	public String getStaffId() {
		return staffId;
	}
	

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
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

	public String getMeasureUnitId() {
		return measureUnitId;
	}

	public void setMeasureUnitId(String measureUnitId) {
		this.measureUnitId = measureUnitId;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
	
	
	
	

}
