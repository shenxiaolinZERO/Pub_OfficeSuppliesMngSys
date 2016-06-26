package cn.fjnu.officeSystem.extend;

import cn.fjnu.officeSystem.entity.RecipientApply;

public class RecipientApplyExtend extends RecipientApply{
	
	 public String itemTypeName;
     public String recipienterName;
     public String departmentName;
     public String auditorName;
	public String getItemTypeName() {
		return itemTypeName;
	}
	public void setItemTypeName(String itemTypeName) {
		this.itemTypeName = itemTypeName;
	}
	public String getRecipienterName() {
		return recipienterName;
	}
	public void setRecipienterName(String recipienterName) {
		this.recipienterName = recipienterName;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getAuditorName() {
		return auditorName;
	}
	public void setAuditorName(String auditorName) {
		this.auditorName = auditorName;
	}
     

}
