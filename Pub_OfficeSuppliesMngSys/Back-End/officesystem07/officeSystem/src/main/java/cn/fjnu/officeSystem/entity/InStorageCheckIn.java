package cn.fjnu.officeSystem.entity;

import java.util.Date;

public class InStorageCheckIn {
	private String id;
	
	private Date inStorageDate;//入库日期
	
	private short inStorageTypeId;//入库类型
	
	private String supplierId;//供应商id
	
	private String agentId;//经办人(员工id)
	
	private String operaterId;//制单人（操作员）
	
	private String itemListId;//物品清单--采购清单（可以批量入库）用'-'拼接
	
	private Long totalNumber;//合计数量
	
	private Double totalMonney;//合计金额
	
	private String remark;//备注

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getInStorageDate() {
		return inStorageDate;
	}

	public void setInStorageDate(Date inStorageDate) {
		this.inStorageDate = inStorageDate;
	}

	public short getInStorageTypeId() {
		return inStorageTypeId;
	}

	public void setInStorageTypeId(short inStorageTypeId) {
		this.inStorageTypeId = inStorageTypeId;
	}

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public String getAgentId() {
		return agentId;
	}

	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}

	public String getOperaterId() {
		return operaterId;
	}

	public void setOperaterId(String operaterId) {
		this.operaterId = operaterId;
	}



	public Long getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(Long totalNumber) {
		this.totalNumber = totalNumber;
	}

	public Double getTotalMonney() {
		return totalMonney;
	}

	public void setTotalMonney(Double totalMonney) {
		this.totalMonney = totalMonney;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}


	public String getItemListId() {
		return itemListId;
	}

	public void setItemListId(String itemListId) {
		this.itemListId = itemListId;
	}

	@Override
	public String toString() {
		return "InStorageCheckIn [id=" + id + ", inStorageDate=" + inStorageDate + ", inStorageTypeId="
				+ inStorageTypeId + ", supplierId=" + supplierId + ", agentId=" + agentId + ", operaterId=" + operaterId
				+ ", itemListId=" + itemListId + ", totalNumber=" + totalNumber + ", totalMonney="
				+ totalMonney + ", remark=" + remark + "]";
	}

	public InStorageCheckIn(String id, Date inStorageDate, short inStorageTypeId, String supplierId, String agentId,
			String operaterId, String itemListId, Long totalNumber, Double totalMonney, String remark) {
		super();
		this.id = id;
		this.inStorageDate = inStorageDate;
		this.inStorageTypeId = inStorageTypeId;
		this.supplierId = supplierId;
		this.agentId = agentId;
		this.operaterId = operaterId;
		this.itemListId = itemListId;
		this.totalNumber = totalNumber;
		this.totalMonney = totalMonney;
		this.remark = remark;
	}

	public InStorageCheckIn() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
