package cn.fjnu.officeSystem.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.fjnu.officeSystem.entity.ProcurementApply;
import cn.fjnu.officeSystem.extend.ProcurementApplyExtend;

public interface ProcurementApplyDao {//采购申请
	/**
	 * 添加数据到采购申请表
	 * @param procurementApply
	 * @return
	 */
	public int insertProcurementApply(ProcurementApply procurementApply);
	/**
	 * 动态修改采购申请表信息
	 * @param procurementApply
	 * @return
	 */
	public int updateProcurementApply(ProcurementApply procurementApply);

	/**
	 * 按采购申请的id进行查询
	 * @param applyId
	 * @return
	 */
	public ProcurementApply selectProcurementApplyByapplyId(String applyId);
	/**
	 * 根据申请的员工号查询出他所申请的所有采购申请表信息
	 * @param staffId
	 * @return
	 */
	public List<ProcurementApply> selectProcurementApplyByStaffId(String staffId);

	/**
	 *  根据审核的员工号查询出他所审核的所有采购申请表信息
	 * @param auditId
	 * @return
	 */
	public List<ProcurementApply> selectProcurementApplyByauditId(String auditId);
	/**
	 * 按以下条件查询出已审核过的采购申请
	 * @param staffId
	 * @param itemTypeId
	 * @param itemName
	 * @param itemId
	 * @param preStartTime
	 * @param preEndTime
	 * @param auditStartTime
	 * @param auditEndTime
	 * @param auditTimeSort
	 * @param applyTimeSort
	 * @return
	 */
	public List<ProcurementApply> selectAuditedProcurementApplyByMap(@Param("staffId") String staffId,
			@Param("itemTypeId") String itemTypeId, @Param("itemName") String itemName, @Param("itemId") String itemId,
			@Param("applyStartTime") Date preStartTime, @Param("applyEndTime") Date preEndTime,
			@Param("auditStartTime") Date auditStartTime, @Param("auditEndTime") Date auditEndTime,
			@Param("auditTimeSort") String auditTimeSort, @Param("applyTimeSort") String applyTimeSort);
/**
 * 
 * @param staffId
 * @param itemTypeId
 * @param itemName
 * @param itemId
 * @param preStartTime
 * @param preEndTime
 * @param applyTimeSort
 * @param start
 * @param end
 * @return
 */
	public List<ProcurementApplyExtend> selectUnAuditProcurementApplyByMap(@Param("staffId") String staffId,
			@Param("itemTypeId") String itemTypeId, @Param("itemName") String itemName, @Param("itemId") String itemId,
			@Param("applyStartTime") Date preStartTime, @Param("applyEndTime") Date preEndTime,
			 @Param("applyTimeSort") String applyTimeSort,@Param("start") int start,@Param("end") int end);
	/**
	 * 
	 * @param staffId
	 * @param itemTypeId
	 * @param itemName
	 * @param itemId
	 * @param preStartTime
	 * @param preEndTime
	 *
	 * @return
	 */
	public int selectUnAuditProcurementApplyCountByMap(@Param("staffId") String staffId,
			@Param("itemTypeId") String itemTypeId, @Param("itemName") String itemName, @Param("itemId") String itemId,
			@Param("applyStartTime") Date preStartTime, @Param("applyEndTime") Date preEndTime);
	
	
	
	

}
