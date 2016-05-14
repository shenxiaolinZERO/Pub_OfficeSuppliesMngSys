package cn.fjnu.officeSystem.entity;

import java.sql.Date;

public class RecipientApply {
private String id;
	
	private String itemId;//物品编号（系统已有）
	
	private String itemName;//物品名称（如果领用的物品是系统中没有的，则只有该字段和物品分类）
	
	private String itemTypeName;//物品分类
	
	private String  spec;//规格型号
	
	private Integer recipientNum;//领用数量（填写）
	
	private Double price;//单价（系统已有）
	
	private Double monney;//金额（系统已有）
	
	private Date recipientTime;//领用时间
	
	private Integer recipientDepartmentId;//领用部门
	
	private Long recipienter;//领用人
	
	private Date auditTime;//审核时间
	
	private Long auditor;//审核人
	
	private Short state;//状态（1待审核，2审核通过3，待采购，4，审核不通过）

	private String remark;//备注

	@Override
	public String toString() {
		return "RecipientApply [id=" + id + ", itemId=" + itemId + ", itemName=" + itemName + ", itemTypeName="
				+ itemTypeName + ", spec=" + spec + ", recipientNum=" + recipientNum + ", price=" + price + ", monney="
				+ monney + ", recipientTime=" + recipientTime + ", recipientDepartmentId=" + recipientDepartmentId
				+ ", recipienter=" + recipienter + ", auditTime=" + auditTime + ", auditor=" + auditor + ", state="
				+ state + ", remark=" + remark + "]";
	}

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

	public String getItemTypeName() {
		return itemTypeName;
	}

	public void setItemTypeName(String itemTypeName) {
		this.itemTypeName = itemTypeName;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public Integer getRecipientNum() {
		return recipientNum;
	}

	public void setRecipientNum(Integer recipientNum) {
		this.recipientNum = recipientNum;
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

	public Date getRecipientTime() {
		return recipientTime;
	}

	public void setRecipientTime(Date recipientTime) {
		this.recipientTime = recipientTime;
	}

	public Integer getRecipientDepartmentId() {
		return recipientDepartmentId;
	}

	public void setRecipientDepartmentId(Integer recipientDepartmentId) {
		this.recipientDepartmentId = recipientDepartmentId;
	}

	public Long getRecipienter() {
		return recipienter;
	}

	public void setRecipienter(Long recipienter) {
		this.recipienter = recipienter;
	}

	public Date getAuditTime() {
		return auditTime;
	}

	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}

	public Long getAuditor() {
		return auditor;
	}

	public void setAuditor(Long auditor) {
		this.auditor = auditor;
	}

	public Short getState() {
		return state;
	}

	public void setState(Short state) {
		this.state = state;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public RecipientApply(String id, String itemId, String itemName, String itemTypeName, String spec,
			Integer recipientNum, Double price, Double monney, Date recipientTime, Integer recipientDepartmentId,
			Long recipienter, Date auditTime, Long auditor, Short state, String remark) {
		super();
		this.id = id;
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemTypeName = itemTypeName;
		this.spec = spec;
		this.recipientNum = recipientNum;
		this.price = price;
		this.monney = monney;
		this.recipientTime = recipientTime;
		this.recipientDepartmentId = recipientDepartmentId;
		this.recipienter = recipienter;
		this.auditTime = auditTime;
		this.auditor = auditor;
		this.state = state;
		this.remark = remark;
	}

	public RecipientApply() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	

}
