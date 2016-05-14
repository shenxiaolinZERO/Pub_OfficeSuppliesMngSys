package cn.fjnu.officeSystem.entity;

public class PreItemProcurement {//物品预采购清单
	
	private String id;
	
	private String itemId;//物品编号
	
	private String itemTypeName;
	
	private String itemName;
	
	private Long num;
	
	private String referToApplierIds;//参考供应商ids
	
	private String staffId;//制单人
	
	private Short isAudit;
	
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

	public String getItemTypeName() {
		return itemTypeName;
	}

	public void setItemTypeName(String itemTypeName) {
		this.itemTypeName = itemTypeName;
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

	public String getReferToApplierIds() {
		return referToApplierIds;
	}

	public void setReferToApplierIds(String referToApplierIds) {
		this.referToApplierIds = referToApplierIds;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public Short getIsAudit() {
		return isAudit;
	}

	public void setIsAudit(Short isAudit) {
		this.isAudit = isAudit;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "PreItemProcurement [id=" + id + ", itemId=" + itemId + ", itemTypeName=" + itemTypeName + ", itemName="
				+ itemName + ", num=" + num + ", referToApplierIds=" + referToApplierIds + ", staffId=" + staffId
				+ ", isAudit=" + isAudit + ", remark=" + remark + "]";
	}

	public PreItemProcurement(String id, String itemId, String itemTypeName, String itemName, Long num,
			String referToApplierIds, String staffId, Short isAudit, String remark) {
		super();
		this.id = id;
		this.itemId = itemId;
		this.itemTypeName = itemTypeName;
		this.itemName = itemName;
		this.num = num;
		this.referToApplierIds = referToApplierIds;
		this.staffId = staffId;
		this.isAudit = isAudit;
		this.remark = remark;
	}

	public PreItemProcurement() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
