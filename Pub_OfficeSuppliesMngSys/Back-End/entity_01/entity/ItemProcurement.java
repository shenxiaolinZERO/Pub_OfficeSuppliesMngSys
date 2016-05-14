package cn.fjnu.officeSystem.entity;

public class ItemProcurement {//物品采购清单
	private String id;
	
	private String itemId;//物品编号（系统已有）
	
	private String applierId;//供应商id（选一下或添加一下）
	
	private String staffId;//采购人员
	
	private long num;//采购数量
	
	private String itemTypeName;//物品分类
	
	private String itemName;//物品名称
	
	private String spec;//规格型号
	
	private Double price;//单价（不管有没有都让它填）
	
	private Double monney;//金额
	
	private String remark;

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

	public String getApplierId() {
		return applierId;
	}

	public void setApplierId(String applierId) {
		this.applierId = applierId;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public long getNum() {
		return num;
	}

	public void setNum(long num) {
		this.num = num;
	}

	public String getItemTypeName() {
		return itemTypeName;
	}

	public void setItemTypeName(String itemTypeName) {
		this.itemTypeName = itemTypeName;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "ItemProcurement [id=" + id + ", itemId=" + itemId + ", applierId=" + applierId + ", staffId=" + staffId
				+ ", num=" + num + ", itemTypeName=" + itemTypeName + ", itemName=" + itemName + ", spec=" + spec
				+ ", price=" + price + ", monney=" + monney + ", remark=" + remark + "]";
	}

	public ItemProcurement(String id, String itemId, String applierId, String staffId, long num, String itemTypeName,
			String itemName, String spec, Double price, Double monney, String remark) {
		super();
		this.id = id;
		this.itemId = itemId;
		this.applierId = applierId;
		this.staffId = staffId;
		this.num = num;
		this.itemTypeName = itemTypeName;
		this.itemName = itemName;
		this.spec = spec;
		this.price = price;
		this.monney = monney;
		this.remark = remark;
	}

	public ItemProcurement() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
