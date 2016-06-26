package cn.fjnu.officeSystem.entity;

public class MerchantsAvailabilitySummary {//商家供货汇总表
	   private String id;
		
		private String supplierId;//供应商id
		
		private String inStrorageCheckInId;//登记编号
		
		private String itemId;//物品编号
		
		private String itemName;//物品名称
		
		private String spec;//规格型号
		
		private String itemTypeId;//物品分类id
		
		private String measureUnitId;//单位
		
		private Double price;//单价
		
		private Integer num;//数量
		
		private Double monney;//金额
	
		
		private String remark;//备注


		public String getId() {
			return id;
		}


		public void setId(String id) {
			this.id = id;
		}



		public String getInStrorageCheckInId() {
			return inStrorageCheckInId;
		}


		public void setInStrorageCheckInId(String inStrorageCheckInId) {
			this.inStrorageCheckInId = inStrorageCheckInId;
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


		public String getSpec() {
			return spec;
		}


		public void setSpec(String spec) {
			this.spec = spec;
		}


		public String getItemTypeId() {
			return itemTypeId;
		}


		public void setItemTypeId(String itemTypeId) {
			this.itemTypeId = itemTypeId;
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


		public Integer getNum() {
			return num;
		}


		public void setNum(Integer num) {
			this.num = num;
		}


		public Double getMonney() {
			return monney;
		}


		public void setMonney(Double monney) {
			this.monney = monney;
		}


		public String getRemark() {
			return remark;
		}


		public void setRemark(String remark) {
			this.remark = remark;
		}


	

		public String getSupplierId() {
			return supplierId;
		}


		public void setSupplierId(String supplierId) {
			this.supplierId = supplierId;
		}


		public MerchantsAvailabilitySummary(String id, String supplierId, String inStrorageCheckInId, String itemId,
				String itemName, String spec, String itemTypeId, String measureUnitId, Double price, Integer num,
				Double monney, String remark) {
			super();
			this.id = id;
			this.supplierId = supplierId;
			this.inStrorageCheckInId = inStrorageCheckInId;
			this.itemId = itemId;
			this.itemName = itemName;
			this.spec = spec;
			this.itemTypeId = itemTypeId;
			this.measureUnitId = measureUnitId;
			this.price = price;
			this.num = num;
			this.monney = monney;
			this.remark = remark;
		}


		public MerchantsAvailabilitySummary() {
			super();
			// TODO Auto-generated constructor stub
		}


		@Override
		public String toString() {
			return "MerchantsAvailabilitySummary [id=" + id + ", supplierId=" + supplierId + ", inStrorageCheckInId="
					+ inStrorageCheckInId + ", itemId=" + itemId + ", itemName=" + itemName + ", spec=" + spec
					+ ", itemTypeId=" + itemTypeId + ", measureUnitId=" + measureUnitId + ", price=" + price + ", num="
					+ num + ", monney=" + monney + ", remark=" + remark + "]";
		}


		


}
