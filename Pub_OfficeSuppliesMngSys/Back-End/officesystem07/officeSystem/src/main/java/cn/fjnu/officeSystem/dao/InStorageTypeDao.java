package cn.fjnu.officeSystem.dao;

import java.util.List;

import org.apache.ibatis.mapping.VendorDatabaseIdProvider;
import org.springframework.stereotype.Repository;

import cn.fjnu.officeSystem.entity.InStorageType;
@Repository
public interface InStorageTypeDao {
	/**
	 * 添加入库类型
	 * @param inStorageType
	 * @return
	 */
	public int insertInStorageType(InStorageType inStorageType);
	/**
	 * 查询所有的入库类型
	 * @return
	 */
	public List<InStorageType> selectAllInStrorageTypes();
	
	

	/**
	 * 动态更新入库类型
	 * @param inStorageType
	 * @return
	 */
	public int updateInStorageType(InStorageType inStorageType);
	
	

}
