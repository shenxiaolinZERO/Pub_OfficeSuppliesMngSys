package cn.fjnu.officeSystem.entity;

public class Department {
	
	private String id;//部门编号
	
	private String name;//部门名
	
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
		return "Department [id=" + id + ", name=" + name + ", remark=" + remark + "]";
	}



	public Department(String id, String name, String remark) {
		super();
		this.id = id;
		this.name = name;
		this.remark = remark;
	}



	public Department() {
		// TODO Auto-generated constructor stub
	}

}
