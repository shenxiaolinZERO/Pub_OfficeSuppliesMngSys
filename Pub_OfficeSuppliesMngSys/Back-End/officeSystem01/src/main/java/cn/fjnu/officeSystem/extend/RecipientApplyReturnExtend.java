package cn.fjnu.officeSystem.extend;

import cn.fjnu.officeSystem.entity.RecipientApply;

public class RecipientApplyReturnExtend extends RecipientApply{

	private String telephone;//借用人联系电话
	private String auditorName;
	private String itemTypeName;
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAuditorName() {
		return auditorName;
	}
	public void setAuditorName(String auditorName) {
		this.auditorName = auditorName;
	}
	public String getItemTypeName() {
		return itemTypeName;
	}
	public void setItemTypeName(String itemTypeName) {
		this.itemTypeName = itemTypeName;
	}
	
}
