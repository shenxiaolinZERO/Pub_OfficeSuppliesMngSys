package cn.fjnu.officeSystem.entity;

public class Permission {//权限表
    private String id;

    private String name;//权限名称

    private String description;//权限描述

    private String remark;//备注

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
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

	@Override
	public String toString() {
		return "Permission [id=" + id + ", name=" + name + ", description=" + description + ", remark=" + remark + "]";
	}

	public Permission( String name, String description, String remark) {
		super();
		
		this.name = name;
		this.description = description;
		this.remark = remark;
	}

	public Permission() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}