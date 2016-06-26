package cn.fjnu.officeSystem.extend;

import java.util.Date;

import cn.fjnu.officeSystem.entity.BorrowApply;

public class BorrowApplyReturnExtend extends BorrowApply{

	private Date preReturnTime;//应借期限
	private String telephone;//借用人联系电话
	private String auditorName;
	private String itemTypeName;
	private Date maxBorrowTime;
	private int borrowState;
	

	public int getBorrowState() {
		return borrowState;
	}
	public void setBorrowState(int borrowState) {
		this.borrowState = borrowState;
	}
	public Date getPreReturnTime() {
		return preReturnTime;
	}
	public void setPreReturnTime(Date preReturnTime) {
		this.preReturnTime = preReturnTime;
	}
	public Date getMaxBorrowTime() {
		return maxBorrowTime;
	}
	public void setMaxBorrowTime(Date maxBorrowTime) {
		this.maxBorrowTime = maxBorrowTime;
	}
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
