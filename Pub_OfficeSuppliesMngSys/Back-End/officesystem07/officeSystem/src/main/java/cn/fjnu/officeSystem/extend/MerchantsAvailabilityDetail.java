package cn.fjnu.officeSystem.extend;

import java.util.List;

import cn.fjnu.officeSystem.entity.MerchantsAvailabilitySummary;
import cn.fjnu.officeSystem.entity.Supplier;

public class MerchantsAvailabilityDetail extends Supplier{//商家供货情况详情表
	List<MerchantsAvailabilitySummary> merchantsAvailabilitySummaries;

	public List<MerchantsAvailabilitySummary> getMerchantsAvailabilitySummaries() {
		return merchantsAvailabilitySummaries;
	}

	public void setMerchantsAvailabilitySummaries(List<MerchantsAvailabilitySummary> merchantsAvailabilitySummaries) {
		this.merchantsAvailabilitySummaries = merchantsAvailabilitySummaries;
	}

	@Override
	public String toString() {
		return "MerchantsAvailabilityDetail [merchantsAvailabilitySummaries=" + merchantsAvailabilitySummaries
				+ ", getMerchantsAvailabilitySummaries()=" + getMerchantsAvailabilitySummaries() + ", getId()="
				+ getId() + ", getFullName()=" + getFullName() + ", getShortName()=" + getShortName()
				+ ", getSupplierTypeId()=" + getSupplierTypeId() + ", getLinkman()=" + getLinkman()
				+ ", getCellPhoneNumber()=" + getCellPhoneNumber() + ", getPhone()=" + getPhone() + ", getFax()="
				+ getFax() + ", getPostcode()=" + getPostcode() + ", getAddress()=" + getAddress() + ", getIsValid()="
				+ getIsValid() + ", getRemark()=" + getRemark() + ", toString()=" + super.toString() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + "]";
	}

	public MerchantsAvailabilityDetail(String id, String fullName, String shortName, String supplierTypeId,
			String linkman, String cellPhoneNumber, String phone, String fax, String postcode, String address,
			Short isValid, String remark, List<MerchantsAvailabilitySummary> merchantsAvailabilitySummaries) {
		super(id, fullName, shortName, supplierTypeId, linkman, cellPhoneNumber, phone, fax, postcode, address, isValid,
				remark);
		this.merchantsAvailabilitySummaries = merchantsAvailabilitySummaries;
	}

	public MerchantsAvailabilityDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MerchantsAvailabilityDetail(String id, String fullName, String shortName, String supplierTypeId,
			String linkman, String cellPhoneNumber, String phone, String fax, String postcode, String address,
			Short isValid, String remark) {
		super(id, fullName, shortName, supplierTypeId, linkman, cellPhoneNumber, phone, fax, postcode, address, isValid,
				remark);
		// TODO Auto-generated constructor stub
	}
	

}
