package cn.fjnu.officeSystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.fjnu.officeSystem.entity.MerchantsAvailabilitySummary;
import cn.fjnu.officeSystem.extend.MerchantsAvailabilityDetail;

@Repository
public interface MerchantsAvailabilitySummaryDao {
  /**
   * 批量添加供应商供货表信息
   * @param merchantsAvailabilitySummarys
   * @return
   */
	public int insertMerchantsAvailabilitySummaryPl(List<MerchantsAvailabilitySummary> merchantsAvailabilitySummarys);
    /**
     * 动态更新供应商供货表
     * @param merchantsAvailabilitySummary
     * @return
     */
	public int updateMerchantsAvailabilitySummary(MerchantsAvailabilitySummary merchantsAvailabilitySummary);
    /**
     * 按以下条件查询出供应商供货
     * @param supplierId
     * @param itemId
     * @param itemTypeId
     * @param column  num 按数量从高到低排序， price 按价格从低到高排序
     * @return
     */
	public List<MerchantsAvailabilitySummary> selectMerchantsAvailabilitySummaryByMap(
			@Param("supplierId") String supplierId, @Param("itemId") String itemId,
			@Param("itemTypeId") String itemTypeId, @Param("column") String column);
	/**
	 * 根据供应商id查看其供货情况（默认按价格从低到高且购货数量从高到低排序）
	 * @param supplierId
	 * @return
	 */
	public List<MerchantsAvailabilitySummary> selectMerchantsAvailabilityBysupplierId(String supplierId);

}
