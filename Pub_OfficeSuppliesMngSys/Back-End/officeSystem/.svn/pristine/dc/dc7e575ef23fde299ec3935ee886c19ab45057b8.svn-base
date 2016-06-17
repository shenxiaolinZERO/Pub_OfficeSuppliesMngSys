package cn.fjnu.officeSystem.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.fjnu.officeSystem.entity.PreItemProcurement;
import cn.fjnu.officeSystem.extend.PreItemProcurementExtend;
@Repository
public interface PreItemProcurementDao {// 预采购清单
	/**
	 * 添加数据到与采购清单中
	 * 
	 * @param preItemProcurement
	 * @return
	 */
	public int insertPreItemProcurement(PreItemProcurement preItemProcurement);

	/**
	 * 通过id查找删除该预采购清单
	 * 
	 * @param id
	 * @return
	 */
	public int deletePreItemProcurementById(String id);

	/**
	 * 动态更新预采购清单的信息
	 * 
	 * @param preItemProcurement
	 * @return
	 */
	public int updatePreItemProcurement(PreItemProcurement preItemProcurement);

	/**
	 * 动态地按以下的map查找出相应的已审核预采购单（默认按采购数量降序排列）
	 * 
	 * @param staffId
	 * @param itemTypeId
	 * @param itemName
	 * @param itemId
	 * @param preStartTime
	 * @param preEndTime
	 * @param auditStartTime
	 * @param auditEndTime
	 * @param auditTimeSort是否按采购单审核时间排列
	 * @param preTimeSort是否按预采购单生成时间排列
	 * @return
	 */
	public List<PreItemProcurement> selectAuditPreItemProcurementByMap(@Param("staffId") String staffId,
			@Param("itemTypeId") String itemTypeId, @Param("itemName") String itemName, @Param("itemId") String itemId,
			@Param("preStartTime") Date preStartTime, @Param("preEndTime") Date preEndTime,
			@Param("auditStartTime") Date auditStartTime, @Param("auditEndTime") Date auditEndTime,
			@Param("auditTimeSort") String auditTimeSort, @Param("preTimeSort") String preTimeSort);

	/**
	 *  动态地按以下的map查找出相应的未审核预采购单（默认按采购数量降序排列）
	 * @param staffId
	 * @param itemTypeId
	 * @param itemName
	 * @param itemId
	 * @param preStartTime
	 * @param preEndTime
	 * @param preTimeSort 是否按预采购时间升序排列
	 * @param start
	 * @param end
	 * @return
	 */
	public List<PreItemProcurementExtend> selectUnAuditPreItemProcurementByMap(@Param("staffId") String staffId,
			@Param("itemTypeId") String itemTypeId, @Param("itemName") String itemName, @Param("itemId") String itemId,
			@Param("preStartTime") Date preStartTime, @Param("preEndTime") Date preEndTime,
			@Param("preTimeSort") String preTimeSort,@Param("start") int start,@Param("end") int end);
	/**
	 * 动态地按以下的map查找出相应的未审核预采购单总数
	 * @param staffId
	 * @param itemTypeId
	 * @param itemName
	 * @param itemId
	 * @param preStartTime
	 * @param preEndTime
	 * @return
	 */
	public int selectUnAuditPreItemProcurementCountByMap(@Param("staffId") String staffId,
			@Param("itemTypeId") String itemTypeId, @Param("itemName") String itemName, @Param("itemId") String itemId,
			@Param("preStartTime") Date preStartTime, @Param("preEndTime") Date preEndTime);
/**
 * 通过以下条更新已被申请且已经进入预采购单数量
 * @param itemTypeId 物品分类id
 * @param itemName 物品名字
 * @param measureUnitId 计量单位id
 * @return
 */
 public int updateIsApplyByMap(@Param("itemTypeId")String itemTypeId,@Param("itemName")String itemName,@Param("measureUnitId")String measureUnitId,@Param("num") Long num);


}
