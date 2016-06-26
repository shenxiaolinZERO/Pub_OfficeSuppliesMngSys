package cn.fjnu.officeSystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.fjnu.officeSystem.entity.DepartmentRecipientSummary;

public interface DepartmentRecipientSummaryDao {

	/**
	 * 添加部门领用汇总表记录
	 * 
	 * @param departmentRecipientSummary
	 * @return
	 */
	public int insertDepartmentRecipientSummary(DepartmentRecipientSummary departmentRecipientSummary);

	/**
	 * 动态更新部门领用汇总表
	 * 
	 * @param departmentRecipientSummary
	 * @return
	 */
	public int updateDepartmentRecipientSummary(DepartmentRecipientSummary departmentRecipientSummary);

	/**
	 * 动态地按以下的map查找出相应的部门领用汇总记录（默认按领用部门id和物品id升序排列）
	 * 
	 * @param itemId
	 * @param itemName
	 * @param outStorageId
	 * @param itemTypeId
	 * @param outStorageCheckInId
	 * @param departmentId
	 * @return
	 */
	public List<DepartmentRecipientSummary> selectDepartmentRecipientSummaryByMap(@Param("itemId") String itemId,
			@Param("itemName") String itemName, @Param("outStorageId") String outStorageId,
			@Param("itemTypeId") String itemTypeId, @Param("outStorageCheckInId") String outStorageCheckInId,
			@Param("departmentId") String departmentId,@Param("start") int start,
			@Param("end")int end);

}
