package cn.fjnu.officeSystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import org.springframework.stereotype.Repository;

import cn.fjnu.officeSystem.entity.BorrowApply;
import cn.fjnu.officeSystem.entity.ItemClassificationSummary;
import cn.fjnu.officeSystem.extend.ItemClassificationSummaryExtend;
@Repository
public interface ItemClassificationSummaryDao {

	/**
	 * 添加物品分类汇总表记录
	 * @param itemClassificationSummary
	 * @return
	 */
	public int insertItemClassificationSummary(ItemClassificationSummary itemClassificationSummary);
	
	/**
	 * 动态更新物品分类汇总表
	 * @param itemClassificationSummary
	 * @return
	 */
	
	public int updateItemClassificationSummary(ItemClassificationSummary itemClassificationSummary);
	/**
	 *入库 更改分类物品的库存
	 * @param itemId
	 * @param addNum
	 * @return
	 */
	public int updateAddItemClassificationSummaryByItemIdAndPrice(@Param("itemId") String itemId,@Param("price") double price,@Param("addNum")Long addNum );
	
	/**
	 * 出库 改库存
	 * @param itemId
	 * @param price
	 * @param addNum
	 * @return
	 */
	public int updateSubItemClassificationSummaryByItemIdAndPrice(@Param("itemId") String itemId,@Param("price") double price,@Param("addNum")Long addNum );
	
	/**
	 * 动态地按以下的map查找出相应的物品分类（默认按库存数量降序排列）
	 * @param itemId
	 * @param itemTypeName
	 * @param itemTypeId
	 * @return
	 */
	
	public List<ItemClassificationSummaryExtend> selectItemClassificationSummaryByMap(@Param("itemId")String itemId,
			@Param("itemTypeId") String itemTypeId,@Param("itemName")String itemName,
			@Param("start") int start,@Param("end")int end);
	
	/**
	 * 根据物品id查询
	 * @param itemId
	 * @return
	 */
	public double selectItemPriceByItemId(String itemId);
	
	/**
	 * 按map查找出相应的物品分类的总数量
	 * @return
	 */
	public int selectItemClassificationSummaryByMapCount();
	
	/**
	 * 查询所有物品分类汇总
	 * @return
	 */
	public List<ItemClassificationSummary> selectAllItemClassificationSummaries();
	
	/**
	 * 查询所有物品分类汇总总条数
	 * @return
	 */
	public int selectAllItemClassificationSummaryCount();
	
	/**
	 * 通过商品id查询物品分类
	 * @param itemId
	 * @return
	 */
	public ItemClassificationSummary selectItemClassificationSummaryByItemId(String itemId);
	
	/**
	 * 通过id查询物品分类
	 * @param id
	 * @return
	 */
	public ItemClassificationSummary selectItemClassificationSummaryById(String id);
	
	/**

	 * 通过id集合查出所有的信息
	 * @param idList
	 * @return
	 */
	public List<ItemClassificationSummary> selectItemClassificationSummaryByIdList(List<String> idList);
}
