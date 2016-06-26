package cn.fjnu.officeSystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.fjnu.officeSystem.entity.Supplier;
import cn.fjnu.officeSystem.extend.MerchantsAvailabilityDetail;
import cn.fjnu.officeSystem.extend.SupplierExtend;

@Repository
public interface SupplierDao {
	/**
	 * 添加数据到供应商表
	 * 
	 * @param supplier
	 * @return
	 */
	public int insertSupplier(Supplier supplier);

	/**
	 * 动态更改供应商信息
	 * 
	 * @param supplier
	 * @return
	 */
	public int updateSupplier(Supplier supplier);

	/**
	 * 查询出系统中所有的供应商
	 * 
	 * @return
	 */
	public List<SupplierExtend> selectAllSupplier(@Param("start") int start, @Param("end") int end);

	/**
	 * 查询出系统中有效的供应商信息
	 * 
	 * @return
	 */
	public List<SupplierExtend> selectValidSupplier(@Param("start") int start, @Param("end") int end);

	/**
	 * 查询出系统中无效的供应商信息
	 * 
	 * @return
	 */
	public List<SupplierExtend> selectUnValidSupplier(@Param("start") int start, @Param("end") int end);

	/**
	 * 按以下条件查询出供应商基本信息
	 * 
	 * @param isValid
	 *            是否有效
	 * @param supplierTypeId
	 *            供应商类型id
	 * @return
	 */
	public List<SupplierExtend> selectSupplierByTypeAndState(@Param("isValid") int isValid,
			@Param("supplierTypeId") String supplierTypeId, @Param("start") int start, @Param("end") int end);

	/**
	 * 查询出系统供应商总记录数
	 * 
	 * @return
	 */
	public int selectAllSupplierCount();

	/**
	 * 查询出系统中有效的供应商总记录数
	 * 
	 * @return
	 */
	public int selectValidSupplierCount();

	/**
	 * 查询出系统中无效的供应商总记录数
	 * 
	 * @return
	 */
	public int selectUnValidSupplierCount();

	/**
	 * 按以下条件查询出供应商总记录数
	 * 
	 * @param isValid
	 *            是否有效
	 * @param supplierTypeId
	 *            供应商类型id
	 * @return
	 */
	public int selectSupplierByTypeAndStateCount(@Param("isValid") int isValid,
			@Param("supplierTypeId") String supplierTypeId);

	/**
	 * 根据供应商id查看该供应商的详情，包括供货情况
	 * 
	 * @param supplierId
	 * @return
	 */
	public MerchantsAvailabilityDetail selectMerchantsAvailabilityDetailBySupplierId(String supplierId);

}
