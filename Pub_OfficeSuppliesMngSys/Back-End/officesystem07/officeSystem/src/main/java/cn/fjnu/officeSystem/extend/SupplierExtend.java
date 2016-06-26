package cn.fjnu.officeSystem.extend;

import cn.fjnu.officeSystem.entity.Supplier;

public class SupplierExtend extends Supplier{
	private String supplierTypeName;//供应商类型名称

	public String getSupplierTypeName() {
		return supplierTypeName;
	}

	public void setSupplierTypeName(String supplierTypeName) {
		this.supplierTypeName = supplierTypeName;
	}
	

}
