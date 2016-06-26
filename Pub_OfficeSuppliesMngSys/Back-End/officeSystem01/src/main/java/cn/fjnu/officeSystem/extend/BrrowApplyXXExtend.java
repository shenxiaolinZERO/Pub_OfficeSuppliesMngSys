package cn.fjnu.officeSystem.extend;

import java.util.Date;

public class BrrowApplyXXExtend extends BrrowApplyExtend{//已经借出但未归还且物品正处于低下限的借用申请单
	private Long inventory;//现存库存
	private Date preReturnTime;//应还时间
	private String telephone;//借用人联系电话
	public Long getInventory() {
		return inventory;
	}
	public void setInventory(Long inventory) {
		this.inventory = inventory;
	}
	public Date getPreReturnTime() {
		return preReturnTime;
	}
	public void setPreReturnTime(Date preReturnTime) {
		this.preReturnTime = preReturnTime;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	

}
