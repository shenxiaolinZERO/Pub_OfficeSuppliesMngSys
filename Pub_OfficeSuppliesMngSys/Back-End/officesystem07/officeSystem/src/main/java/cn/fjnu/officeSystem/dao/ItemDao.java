package cn.fjnu.officeSystem.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.fjnu.officeSystem.entity.Item;

@Repository
public interface ItemDao {
	/**
	 * 添加物品表的数据
	 * @param item
	 * @return
	 */
	public int insertItem(Item item);
	
	/**
	 * 根据id删除物品
	 * @param id
	 * @return
	 */
	public int deleteItemById(String id);
	/**
	 * 动态更改物品的信息
	 * @param item
	 * @return
	 */
	
	public int updateItem(Item item);
	
	/**
	 * 根据物品id查询物品
	 * @param id
	 * @return
	 */
	public Item selectItemById(String id);
	/**
	 * 通过以下条件查找物品id
	 * @param itemName
	 * @param itemTypeId
	 * @param spec
	 * @param measureUnitId
	 * @param supplierId
	 * @return
	 */
	public String selectIdByMap(@Param("itemName")String itemName,@Param("itemTypeId")String itemTypeId,
			@Param("spec")String spec,@Param("measureUnitId")String measureUnitId,@Param("supplierId")String supplierId);
	
	
	
	 
	

}
