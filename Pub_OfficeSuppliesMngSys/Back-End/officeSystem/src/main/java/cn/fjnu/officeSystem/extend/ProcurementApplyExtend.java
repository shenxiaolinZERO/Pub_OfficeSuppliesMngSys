package cn.fjnu.officeSystem.extend;

import cn.fjnu.officeSystem.entity.ProcurementApply;

public class ProcurementApplyExtend extends ProcurementApply{
	private String itemTypeName;//物品分类名称
	
	private String staffName;//员工姓名
	
	private String auditStaffName;//审核员工姓名

	public String getItemTypeName() {
		return itemTypeName;
	}

	public void setItemTypeName(String itemTypeName) {
		this.itemTypeName = itemTypeName;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getAuditStaffName() {
		return auditStaffName;
	}

	public void setAuditStaffName(String auditStaffName) {
		this.auditStaffName = auditStaffName;
	}
	
	

}
