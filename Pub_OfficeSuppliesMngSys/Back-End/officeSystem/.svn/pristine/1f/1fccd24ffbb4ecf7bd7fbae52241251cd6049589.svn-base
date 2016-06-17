package cn.fjnu.officeSystem.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.fjnu.officeSystem.entity.ItemType;
@Repository
public interface ItemTypeDao {
	
	/**
	 * 添加物品类型
	 * @param itemType
	 * @return
	 */
	public int insertItemType(ItemType itemType);
	/**
	 * 查看所有的物品类型
	 * @return
	 */
	public List<ItemType> selectAllItemType();
	/**
	 * 通过id查询出物品分类信息
	 * @param id
	 * @return
	 */
	public ItemType selectItemTypeById(String id);
	/**
	 * 动态更改物品类型
	 * @param itemType
	 * @return
	 */
	public int updateItemType(ItemType itemType);

}
