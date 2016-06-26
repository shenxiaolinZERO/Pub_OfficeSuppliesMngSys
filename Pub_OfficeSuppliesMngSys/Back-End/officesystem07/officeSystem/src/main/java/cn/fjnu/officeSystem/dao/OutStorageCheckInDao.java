package cn.fjnu.officeSystem.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.fjnu.officeSystem.entity.OutStorageCheckIn;
import cn.fjnu.officeSystem.extend.InStorageCheckInExtend;

public interface OutStorageCheckInDao {

	/**
	 * 批量出库登记
	 * 
	 * @param outStorageCheckIns
	 * @return
	 */
	public int insertOutStorageCheckInPl(List<OutStorageCheckIn> outStorageCheckIns);
	
	/**
	 * 单条出库登记
	 * 
	 * @param outStorageCheckIn
	 * @return
	 */
	public int insertOutStorageCheckIn(OutStorageCheckIn outStorageCheckIn);

	/**
	 * 根据下面的条件动态的查询出库登记界面
	 * @param startTime
	 * @param endTime
	 * @param itemTypeId
	 * @param itemName
	 * @param outStorageTypeId
	 * @param start
	 * @param end
	 * @return
	 */
	public List<OutStorageCheckIn> selectOutStorageCheckInByMap(@Param("startTime") String startTime,
			@Param("endTime") String endTime, @Param("itemTypeId") String itemTypeId,
			@Param("itemName") String itemName, @Param("outStorageTypeId") String outStorageTypeId,@Param("start") int start,
			@Param("end")int end);
	

	/**
	 * 根据以下条件统计总记录数
	 * @param startTime
	 * @param endTime
	 * @param itemTypeId
	 * @param itemName
	 * @param outStorageTypeId
	 * @return
	 */
	public int selectOutStorageCheckInByMapCount(@Param("startTime")String startTime,
			@Param("endTime")String endTime,@Param("itemTypeId")String itemTypeId,
			@Param("itemName")String itemName,@Param("outStorageTypeId")String outStorageTypeId);

}
