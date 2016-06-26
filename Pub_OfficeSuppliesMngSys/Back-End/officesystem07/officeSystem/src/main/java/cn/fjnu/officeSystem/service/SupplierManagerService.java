package cn.fjnu.officeSystem.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.fjnu.officeSystem.entity.Supplier;
import cn.fjnu.officeSystem.extend.MerchantsAvailabilityDetail;
import cn.fjnu.officeSystem.extend.SupplierExtend;

public interface SupplierManagerService {
	
	/**
	 * 新增供应商
	 * @param supplier
	 * @return
	 */
	public int addSupplier(Supplier supplier);
	
	/**
	 * 动态更改供应商信息
	 * @param supplier
	 * @return
	 */
	public int modifySupplier(Supplier supplier);
	/**
	 * 查询出系统中所有的供应商
	 * @return
	 */
	public String getAllSupplier(int pageIndex, int pageCount);
	/**
	 * 查询出系统中有效的供应商信息
	 * 
	 * @return
	 */
	public String getValidSupplier(int pageIndex, int pageCount);
	/**
	 * 查询出系统中无效的供应商信息
	 * 
	 * @return
	 */
	public String getUnValidSupplier(int pageIndex, int pageCount);
	/**
	 * 按以下条件查询出供应商基本信息
	 * @param isValid 是否有效
	 * @param supplierTypeId 供应商类型id
	 * @return
	 */
	public String getSupplierByTypeAndState(int isValid,
			 String supplierTypeId,int pageIndex, int pageCount);
	
	/**
	 * 根据供应商id查看该供应商的详情，包括供货情况
	 * @param supplierId
	 * @return
	 */
	public MerchantsAvailabilityDetail getMerchantsAvailabilityDetailBySupplierId(String supplierId);
	

}
