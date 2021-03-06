package cn.fjnu.officeSystem.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.fjnu.officeSystem.entity.MeasureUnit;
@Repository
public interface MeasureUnitDao {
	/**
	 * 添加物品单位
	 * @param measureUnit
	 * @return
	 */
	public  int insertMeasureUnit(MeasureUnit measureUnit);
	/**
	 * 动态更新物品单位
	 * @param measureUnit
	 * @return
	 */
	public int updateMeasureUnit(MeasureUnit measureUnit);
	/**
	 * 查询出所有的单位
	 * @return
	 */
	public List<MeasureUnit> selectAllMeasureUnit();
	/**
	 * 通过id查询出单位信息
	 * @param id
	 * @return
	 */
	public MeasureUnit selectMeasureUnitById(String id);
}
