package cn.fjnu.officeSystem.extend;

import java.util.Date;

public class RecipientApplyExpireExtend extends RecipientApplyExtend {

	private Date maxRecipientTime;//应领期限
	private String telephone;//借用人联系电话
	private int recipientState;
	public int getRecipientState() {
		return recipientState;
	}
	public void setRecipientState(int recipientState) {
		this.recipientState = recipientState;
	}
	public Date getMaxRecipientTime() {
		return maxRecipientTime;
	}
	public void setMaxRecipientTime(Date maxRecipientTime) {
		this.maxRecipientTime = maxRecipientTime;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	
}
