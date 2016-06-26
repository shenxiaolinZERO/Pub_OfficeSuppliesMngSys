package cn.fjnu.officeSystem.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.fjnu.officeSystem.entity.SupplierType;
@Repository
public interface SupplierTypeDao {
	/**
	 * 添加供应商类型
	 * @param supplierType
	 * @return
	 */
	public int insertSupplierType(SupplierType supplierType);
	/**
	 * 查询出所有的供应商信息
	 * @return
	 */
	public List<SupplierType> selectAllSupplierType();
	/**
	 * 动态更新供应商类型
	 * @param supplierType
	 * @return
	 */
	public int updateSupplierType(SupplierType supplierType);

}
