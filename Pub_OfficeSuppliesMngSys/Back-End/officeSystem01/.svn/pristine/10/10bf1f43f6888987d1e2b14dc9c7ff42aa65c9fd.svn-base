package cn.fjnu.officeSystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.fjnu.officeSystem.entity.InStorageCheckIn;
import cn.fjnu.officeSystem.extend.InStorageCheckInExtend;

@Repository
public interface InStorageCheckInDao {
	/**
	 * 单条入库登记
	 * @param inStorageCheckIn
	 * @return
	 */
	public int insertInStorageCheckIn(InStorageCheckIn inStorageCheckIn);
	/**
	 * 批量入库登记
	 * @param inStorageCheckIns
	 * @return
	 */
	
	public int insertInStorageCheckInPl(List<InStorageCheckIn> inStorageCheckIns);
	
	/**
	 * 根据供应商Id、经办人id、操作人员id、采购清单id查询入库登记
	 * @param supplierId 供应商Id
	 * @param agentId 经办人id
	 * @param operaterId 操作人员id
	 * @param itemProcurementId 采购清单id
	 * @return
	 */
	public List<InStorageCheckInExtend> selectInStorageCheckInsByMap(@Param("supplierId")String supplierId,
			@Param("agentId")String agentId,@Param("operaterId")String operaterId,
			@Param("itemProcurementId")String itemProcurementId,@Param("start") int start,
			@Param("end")int end);
	/**
	 * 按以下条件统计总条数
	 * @param supplierId
	 * @param agentId
	 * @param operaterId
	 * @param itemProcurementId
	 * @return
	 */
	public int selectInStorageCheckInsByMapCount(@Param("supplierId")String supplierId,
			@Param("agentId")String agentId,@Param("operaterId")String operaterId,
			@Param("itemProcurementId")String itemProcurementId);
	

	
	
	
	
	

}
