package cn.fjnu.officeSystem.entity;

import java.util.Date;

public class BorrowApply {
	
	private String id;
	
	private String itemId;//物品编号（系统已有）
	
	private String itemName;//物品名称（如果领用的物品是系统中没有的，则只有该字段和物品分类）
	
	private String itemTypeId;//物品分类
	
	private String  spec;//规格型号
	
	private Long borrowNum;//借用数量（填写）
	
	private Double price;//单价（系统已有）
	
	private Double monney;//金额（系统已有）
	
	private Date borrowTime;//借用时间
	
	private Date applyTime;//申请时间
	
	private Integer borrowDepartmentId;//借用部门
	
	private String borrower;//借用人
	
	private Date auditTime;//审核时间
	
	private String auditor;//审核人
	
	private Short state;//状态（1待审核，2审核通过，3，审核不通过）
	
	private Short isReturn;//是否归还
	
	private Date returnTime;//归还时间
	
	private Short isDisplay;//是否显示
	
	private Short isValid;//是否有效（超过一定时间就置为0无效）
	
	private String reason;
	
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

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemTypeId() {
		return itemTypeId;
	}

	public void setItemTypeId(String itemTypeId) {
		this.itemTypeId = itemTypeId;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public Long getBorrowNum() {
		return borrowNum;
	}

	public void setBorrowNum(Long borrowNum) {
		this.borrowNum = borrowNum;
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

	public Date getBorrowTime() {
		return borrowTime;
	}

	public void setBorrowTime(Date borrowTime) {
		this.borrowTime = borrowTime;
	}

	public Integer getBorrowDepartmentId() {
		return borrowDepartmentId;
	}

	public void setBorrowDepartmentId(Integer borrowDepartmentId) {
		this.borrowDepartmentId = borrowDepartmentId;
	}

	public String getBorrower() {
		return borrower;
	}

	public void setBorrower(String  borrower) {
		this.borrower = borrower;
	}

	public Date getAuditTime() {
		return auditTime;
	}

	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}

	public String  getAuditor() {
		return auditor;
	}

	public void setAuditor(String auditor) {
		this.auditor = auditor;
	}

	public Short getState() {
		return state;
	}

	public void setState(Short state) {
		this.state = state;
	}

	public Short getIsReturn() {
		return isReturn;
	}

	public void setIsReturn(Short isReturn) {
		this.isReturn = isReturn;
	}

	public Date getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(Date returnTime) {
		this.returnTime = returnTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Short getIsDisplay() {
		return isDisplay;
	}

	public void setIsDisplay(Short isDisplay) {
		this.isDisplay = isDisplay;
	}

	

	public Date getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Short getIsValid() {
		return isValid;
	}

	public void setIsValid(Short isValid) {
		this.isValid = isValid;
	}

	@Override
	public String toString() {
		return "BorrowApply [id=" + id + ", itemId=" + itemId + ", itemName=" + itemName + ", itemTypeId=" + itemTypeId
				+ ", spec=" + spec + ", borrowNum=" + borrowNum + ", price=" + price + ", monney=" + monney
				+ ", borrowTime=" + borrowTime + ", applyTime=" + applyTime + ", borrowDepartmentId="
				+ borrowDepartmentId + ", borrower=" + borrower + ", auditTime=" + auditTime + ", auditor=" + auditor
				+ ", state=" + state + ", isReturn=" + isReturn + ", returnTime=" + returnTime + ", isDisplay="
				+ isDisplay + ", isValid=" + isValid + ", reason=" + reason + ", remark=" + remark + "]";
	}

	public BorrowApply(String id, String itemId, String itemName, String itemTypeId, String spec, Long borrowNum,
			Double price, Double monney, Date borrowTime, Date applyTime, Integer borrowDepartmentId,String borrower,
			Date auditTime, String auditor, Short state, Short isReturn, Date returnTime, Short isDisplay, Short isValid,
			String reason, String remark) {
		super();
		this.id = id;
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemTypeId = itemTypeId;
		this.spec = spec;
		this.borrowNum = borrowNum;
		this.price = price;
		this.monney = monney;
		this.borrowTime = borrowTime;
		this.applyTime = applyTime;
		this.borrowDepartmentId = borrowDepartmentId;
		this.borrower = borrower;
		this.auditTime = auditTime;
		this.auditor = auditor;
		this.state = state;
		this.isReturn = isReturn;
		this.returnTime = returnTime;
		this.isDisplay = isDisplay;
		this.isValid = isValid;
		this.reason = reason;
		this.remark = remark;
	}

	public BorrowApply() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	

}
