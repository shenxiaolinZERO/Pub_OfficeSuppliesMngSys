package cn.fjnu.officeSystem.entity;

import java.sql.Date;

public class Staff {
	private String id;
	
	private String staffName;//姓名
	
	private String departmentId;//部门编号
	
	private String cellPhoneNumber;//手机号码
	
	private String phone;//联系电话
	
	private String Email;//Email
	
	private String sex;//性别
	
	private String nativePlace;//籍贯
	
	private String address;//家庭地址
	
	private Date birthday;//出生年月
	
	private String graduateSchool;//毕业院校
	
	private String highestRecord;//最高学历
	
	private String role;//角色
	
	private Short isWorking;//在职状态

	private String remark;
	
	private String salt;//盐
	
	private String password;//密码

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getCellPhoneNumber() {
		return cellPhoneNumber;
	}

	public void setCellPhoneNumber(String cellPhoneNumber) {
		this.cellPhoneNumber = cellPhoneNumber;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getNativePlace() {
		return nativePlace;
	}

	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGraduateSchool() {
		return graduateSchool;
	}

	public void setGraduateSchool(String graduateSchool) {
		this.graduateSchool = graduateSchool;
	}

	public String getHighestRecord() {
		return highestRecord;
	}

	public void setHighestRecord(String highestRecord) {
		this.highestRecord = highestRecord;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Short getIsWorking() {
		return isWorking;
	}

	public void setIsWorking(Short isWorking) {
		this.isWorking = isWorking;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	
	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Staff() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Staff [id=" + id + ", staffName=" + staffName + ", departmentId=" + departmentId + ", cellPhoneNumber="
				+ cellPhoneNumber + ", phone=" + phone + ", Email=" + Email + ", sex=" + sex + ", nativePlace="
				+ nativePlace + ", address=" + address + ", birthday=" + birthday + ", graduateSchool=" + graduateSchool
				+ ", highestRecord=" + highestRecord + ", role=" + role + ", isWorking=" + isWorking + ", remark="
				+ remark + ", salt=" + salt + "]";
	}

	public Staff(String id, String staffName, String departmentId, String cellPhoneNumber, String phone, String email,
			String sex, String nativePlace, String address, Date birthday, String graduateSchool, String highestRecord,
			String role, Short isWorking, String remark, String salt) {
		super();
		this.id = id;
		this.staffName = staffName;
		this.departmentId = departmentId;
		this.cellPhoneNumber = cellPhoneNumber;
		this.phone = phone;
		Email = email;
		this.sex = sex;
		this.nativePlace = nativePlace;
		this.address = address;
		this.birthday = birthday;
		this.graduateSchool = graduateSchool;
		this.highestRecord = highestRecord;
		this.role = role;
		this.isWorking = isWorking;
		this.remark = remark;
		this.salt = salt;
	}
	
	
}
