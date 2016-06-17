package cn.fjnu.officeSystem.entity;

public class InStorageType {
	
	private String id;
	
	private String name;
	
	private String remark;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "InStorageType [id=" + id + ", name=" + name + ", remark=" + remark + "]";
	}

	public InStorageType(String id, String name, String remark) {
		super();
		this.id = id;
		this.name = name;
		this.remark = remark;
	}

	public InStorageType() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
