package cn.fjnu.officeSystem.entity;

import java.util.Date;

public class PreItemProcurement {//物品预采购清单
	
	private String id;
	
	private String itemId;//物品编号
	
	private String itemTypeId;
	
	private String itemName;
	
	private Long num;
		
	private String staffId;//制单人
    
	private String measureUnitId;//计量单位id
	
	private Date preTime;//预采购时间
	
	private Date auditTime;//审核时间
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
	public Long getNum() {
		return num;
	}
	public void setNum(Long num) {
		this.num = num;
	}
	public String getStaffId() {
		return staffId;
	}
	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	public Date getPreTime() {
		return preTime;
	}
	public void setPreTime(Date preTime) {
		this.preTime = preTime;
	}
	public Date getAuditTime() {
		return auditTime;
	}
	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public PreItemProcurement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMeasureUnitId() {
		return measureUnitId;
	}
	public void setMeasureUnitId(String measureUnitId) {
		this.measureUnitId = measureUnitId;
	}
	@Override
	public String toString() {
		return "PreItemProcurement [id=" + id + ", itemId=" + itemId + ", itemTypeId=" + itemTypeId + ", itemName="
				+ itemName + ", num=" + num + ", staffId=" + staffId + ", measureUnitId=" + measureUnitId + ", preTime="
				+ preTime + ", auditTime=" + auditTime + ", remark=" + remark + "]";
	}
	public PreItemProcurement(String id, String itemId, String itemTypeId, String itemName, Long num, String staffId,
			String measureUnitId, Date preTime, Date auditTime, String remark) {
		super();
		this.id = id;
		this.itemId = itemId;
		this.itemTypeId = itemTypeId;
		this.itemName = itemName;
		this.num = num;
		this.staffId = staffId;
		this.measureUnitId = measureUnitId;
		this.preTime = preTime;
		this.auditTime = auditTime;
		this.remark = remark;
	}
	

	
}
