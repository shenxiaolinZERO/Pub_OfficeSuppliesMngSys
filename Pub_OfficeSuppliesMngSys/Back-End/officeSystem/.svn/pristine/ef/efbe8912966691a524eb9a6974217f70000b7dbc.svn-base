package cn.fjnu.officeSystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.fjnu.officeSystem.entity.TransfiniteInventoryWarning;
import cn.fjnu.officeSystem.extend.TransfiniteInventoryWarningExtend;
@Repository
public interface TransfiniteInventoryWarningDao {//库存预警
	/**
	 * 添加数据到库存预警表
	 * @param transfiniteInventoryWarning
	 * @return
	 */
	public int insertTransfiniteInventoryWarning(TransfiniteInventoryWarning transfiniteInventoryWarning);
	/**
	 * 动态更新库存预警表
	 * @param transfiniteInventoryWarning
	 * @return
	 */
	public int updateTransfiniteInventoryWarning(TransfiniteInventoryWarning transfiniteInventoryWarning);
   /**
    * 
    * @param itemTypeId
    * @param state 
    * @return
    */
	/**
	 * 按以下查询出超上限或低于库存下限的库存预警信息
	 * @param itemTypeId 2表示查低下限 1表示查超上限
	 * @param state
	 * @param itemName
	 * @param start
	 * @param end
	 * @return
	 */
	public List<TransfiniteInventoryWarningExtend> selectAllWarningByMap(@Param("itemTypeId") String itemTypeId,
			                     @Param("state") int state,@Param("itemName")String itemName,
			                     @Param("start") int start,@Param("end") int end);
	/**
	 *  统计以下查询出超上限或低于库存下限的库存预警信息总条数
	 * @param itemTypeId
	 * @param state
	 * @param itemName
	 * @return
	 */
	
	public int selectAllWarningByMapCount(@Param("itemTypeId") String itemTypeId,
            @Param("state") int state,@Param("itemName")String itemName);
	
}
