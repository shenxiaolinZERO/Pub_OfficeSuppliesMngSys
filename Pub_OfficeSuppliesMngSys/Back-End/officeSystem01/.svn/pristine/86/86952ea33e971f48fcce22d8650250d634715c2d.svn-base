package cn.fjnu.officeSystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.fjnu.officeSystem.entity.StaffRecipientSummary;

public interface StaffRecipientSummaryDao {

	/**
	 * 添加人员领用汇总表记录
	 * @param staffRecipientSummary
	 * @return
	 */
	public int insertStaffRecipientSummary(StaffRecipientSummary staffRecipientSummary);
	
	/**
	 * 动态更新人员领用汇总表
	 * @param staffRecipientSummary
	 * @return
	 */
	public int updateStaffRecipientSummary(StaffRecipientSummary staffRecipientSummary);
	
	/**
	 * 动态地按以下的map查找出相应的人员领用汇总记录（默认按领用员工id和物品id升序排列）
	 * @param itemId
	 * @param itemName
	 * @param outStorageId
	 * @param itemTypeId
	 * @param outStorageCheckInId
	 * @param staffId
	 * @param start
	 * @param end
	 * @return
	 */
	public List<StaffRecipientSummary> selectStaffRecipientSummaryByMap(@Param("itemId") String itemId,
			@Param("itemName") String itemName, @Param("outStorageId") String outStorageId,
			@Param("itemTypeId") String itemTypeId, @Param("outStorageCheckInId") String outStorageCheckInId,
			@Param("staffId") String staffId,@Param("start") int start,@Param("end")int end);
	
}
