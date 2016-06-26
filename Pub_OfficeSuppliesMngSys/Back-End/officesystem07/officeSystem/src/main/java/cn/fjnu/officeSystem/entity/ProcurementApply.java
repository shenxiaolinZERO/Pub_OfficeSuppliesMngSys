package cn.fjnu.officeSystem.entity;

import java.util.Date;

public class ProcurementApply {
	   private String id;
		
		private String staffId;//员工编号
		
		private String itemName;//物品名称
		
		private String itemTypeId;//物品分类
		
		private String itemId;
		
		private String  spec;//规格型号
		
		private Long num;//数量（填写）
			
		private Date applyTime;//申请时间
		
		
		
		private Date auditTime;//审核时间
		
		private Short isProcurement;//是否采购
		
		private String reason;//拒绝理由
		
		private String remark;
		
		private String auditStaffId;//审核员工id
		
		private Short isDisplay;//是否显示
		
		private String measureUnitId;//计量单位id

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getStaffId() {
			return staffId;
		}

		public void setStaffId(String staffId) {
			this.staffId = staffId;
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

		public String getItemId() {
			return itemId;
		}

		public void setItemId(String itemId) {
			this.itemId = itemId;
		}

		public String getSpec() {
			return spec;
		}

		public void setSpec(String spec) {
			this.spec = spec;
		}

		public Long getNum() {
			return num;
		}

		public void setNum(Long num) {
			this.num = num;
		}

		public Date getApplyTime() {
			return applyTime;
		}

		public void setApplyTime(Date applyTime) {
			this.applyTime = applyTime;
		}

		public Date getAuditTime() {
			return auditTime;
		}

		public void setAuditTime(Date auditTime) {
			this.auditTime = auditTime;
		}

		public Short getIsProcurement() {
			return isProcurement;
		}

		public void setIsProcurement(Short isProcurement) {
			this.isProcurement = isProcurement;
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

		
		public ProcurementApply() {
			super();
			// TODO Auto-generated constructor stub
		}

		

		public String getReason() {
			return reason;
		}

		public void setReason(String reason) {
			this.reason = reason;
		}

		public String getAuditStaffId() {
			return auditStaffId;
		}

		public void setAuditStaffId(String auditStaffId) {
			this.auditStaffId = auditStaffId;
		}

		public String getMeasureUnitId() {
			return measureUnitId;
		}

		public void setMeasureUnitId(String measureUnitId) {
			this.measureUnitId = measureUnitId;
		}

		
		
		
		
	

}
