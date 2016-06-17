package cn.fjnu.officeSystem.entity;

public class StaffRecipientSummary {//人员领用汇总表
	 private String id;
		
		private String staffId;//领用人id
		
		private String outStorageCheckInId;//登记编号(出库)
		
		private String itemId;//物品编号
		
		private String itemName;//物品名称
		
		private String itemTypeId;//物品分类
		
		private String spec;//规格型号
		
		private String measureUnitId;//单位
		
		private Double price;//单价
		
		private Long number;//数量
		
		private Double monney;//金额
		
		private String outStorageId;//出库类型
		
		private String remark;//备注

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

		public String getOutStorageCheckInId() {
			return outStorageCheckInId;
		}

		public void setOutStorageCheckInId(String outStorageCheckInId) {
			this.outStorageCheckInId = outStorageCheckInId;
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

		public String getMeasureUnitId() {
			return measureUnitId;
		}

		public void setMeasureUnitId(String measureUnitId) {
			this.measureUnitId = measureUnitId;
		}

		public Double getPrice() {
			return price;
		}

		public void setPrice(Double price) {
			this.price = price;
		}

		public Long getNumber() {
			return number;
		}

		public void setNumber(Long number) {
			this.number = number;
		}

		public Double getMonney() {
			return monney;
		}

		public void setMonney(Double monney) {
			this.monney = monney;
		}

		public String getOutStorageId() {
			return outStorageId;
		}

		public void setOutStorageId(String outStorageId) {
			this.outStorageId = outStorageId;
		}

		public String getRemark() {
			return remark;
		}

		public void setRemark(String remark) {
			this.remark = remark;
		}

		@Override
		public String toString() {
			return "StaffRecipientSummary [id=" + id + ", staffId=" + staffId + ", outStorageCheckInId="
					+ outStorageCheckInId + ", itemId=" + itemId + ", itemName=" + itemName + ", itemTypeId="
					+ itemTypeId + ", spec=" + spec + ", measureUnitId=" + measureUnitId + ", price=" + price
					+ ", number=" + number + ", monney=" + monney + ", outStorageId=" + outStorageId + ", remark="
					+ remark + "]";
		}

		public StaffRecipientSummary(String id, String staffId, String outStorageCheckInId, String itemId,
				String itemName, String itemTypeId, String spec, String measureUnitId, Double price, Long number,
				Double monney, String outStorageId, String remark) {
			super();
			this.id = id;
			this.staffId = staffId;
			this.outStorageCheckInId = outStorageCheckInId;
			this.itemId = itemId;
			this.itemName = itemName;
			this.itemTypeId = itemTypeId;
			this.spec = spec;
			this.measureUnitId = measureUnitId;
			this.price = price;
			this.number = number;
			this.monney = monney;
			this.outStorageId = outStorageId;
			this.remark = remark;
		}

		public StaffRecipientSummary() {
			super();
			// TODO Auto-generated constructor stub
		}

		

}
