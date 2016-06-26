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
	 * 按以下条件查出相应的入库统计界面
	 * @param startTime
	 * @param endTime
	 * @param itemTypeId
	 * @param itemName
	 * @param inStorageTypeId
	 * @param start
	 * @param end
	 * @return
	 */
	public List<InStorageCheckInExtend> selectInStorageCheckInsByMap(@Param("startTime")String startTime,
			@Param("endTime")String endTime,@Param("itemTypeId")String itemTypeId,
			@Param("itemName")String itemName,@Param("inStorageTypeId")String inStorageTypeId,@Param("start") int start,
			@Param("end")int end);
	/**
	 * 按以下条件统计总条数
	 * @param startTime
	 * @param endTime
	 * @param itemTypeId
	 * @param itemName
	 * @param inStorageTypeId
	 * @return
	 */
	public int selectInStorageCheckInsByMapCount(@Param("startTime")String startTime,
			@Param("endTime")String endTime,@Param("itemTypeId")String itemTypeId,
			@Param("itemName")String itemName,@Param("inStorageTypeId")String inStorageTypeId);
	

	
	
	
	
	

}
