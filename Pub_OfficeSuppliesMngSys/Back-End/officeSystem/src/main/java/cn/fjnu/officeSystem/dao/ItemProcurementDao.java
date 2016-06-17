package cn.fjnu.officeSystem.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.fjnu.officeSystem.entity.ItemProcurement;
import cn.fjnu.officeSystem.extend.ItemProcurementExtend;

@Repository
public interface ItemProcurementDao {

	/**
	 * 添加物品采购清单记录
	 * 
	 * @param itemProcurement
	 * @return
	 */

	public int insertItemProcurement(ItemProcurement itemProcurement);

	/**
	 * 动态更新物品采购清单记录
	 * 
	 * @param itemProcurement
	 * @return
	 */

	public int updateItemProcurement(ItemProcurement itemProcurement);

	/**
	 * 通过采购集合id查找出满足条件的采购单
	 * 
	 * @param ids
	 * @return
	 */
	public List<ItemProcurement> selectItemProcurementByIdList(List<String> ids);

	/**
	 * 采购入库查询条件
	 * @param itemName
	 * @param itemTypeId
	 * @param staffId
	 * @return
	 */
	public List<ItemProcurementExtend> selectItemProcurementByMap(@Param("itemName")String itemName,
			@Param("itemTypeId")String itemTypeId,@Param("staffId")String staffId);

	/**
	 * 根据采购员员工id查询出物品采购清单
	 * 
	 * @param staffId
	 * @return
	 */
	public List<ItemProcurement> selectItemProcurementBystaffId(String staffId);

	/**
	 * 查询出本系统未被入库的物品采购清单
	 * 
	 * @param supplierId
	 * @param staffId
	 * @param itemTypeId
	 * @param itemName
	 * @param timeSort
	 * @param start
	 * @param end
	 * @return
	 */
	public List<ItemProcurementExtend> selectUnInStorageItemProcurement(@Param("supplierId") String supplierId,
			@Param("staffId") String staffId, @Param("itemTypeId") String itemTypeId,
			@Param("itemName") String itemName, @Param("timeSort") int timeSort, @Param("start") int start,
			@Param("end") int end);

	/**
	 * 查询出本系统未被入库的物品采购清单的总条数
	 * 
	 * @param supplierId
	 * @param staffId
	 * @param itemTypeId
	 * @param itemName
	 *
	 * @return
	 */
	public int selectUnInStorageItemProcurementCount(ItemProcurement itemProcurement);

	/**
	 * 查询出本系统未被入库的物品采购清单
	 * 
	 * @param supplierId
	 * @param staffId
	 * @param itemTypeId
	 * @param itemName
	 * @param endTimeSort
	 * @param start
	 * @param end
	 * @return
	 */
	public List<ItemProcurementExtend> selectInStorageItemProcurement(
			@Param("supplierId") String supplierId,
			@Param("staffId") String staffId, @Param("itemTypeId") String itemTypeId,
			@Param("itemName") String itemName, @Param("endTimeSort") int endTimeSort,
			@Param("start") int start, @Param("end") int end);

	/**
	 * 查询出本系统未被入库的物品采购清单的总条数
	 * 
	 * @param supplierId
	 * @param staffId
	 * @param itemTypeId
	 * @param itemName
	 * 
	 * @return
	 */
	public int selectInStorageItemProcurementCount(ItemProcurement itemProcurement);

}
