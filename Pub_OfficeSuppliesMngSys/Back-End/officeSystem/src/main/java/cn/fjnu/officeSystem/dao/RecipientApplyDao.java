package cn.fjnu.officeSystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.fjnu.officeSystem.entity.RecipientApply;
import cn.fjnu.officeSystem.extend.RecipientApplyExpireExtend;
import cn.fjnu.officeSystem.extend.RecipientApplyExtend;
import cn.fjnu.officeSystem.extend.RecipientApplyReturnExtend;

public interface RecipientApplyDao {

	/**
	 * 添加物品领用申请表记录
	 * @param recipientApply
	 * @return
	 */
	public int insertRecipientApply(RecipientApply recipientApply);
	
	/**
	 * 删除物品领用申请表记录
	 * @param id
	 * @return
	 */
	public int deleteRecipientApplyById(String id);
	
	/**
	 * 动态更新物品领用申请表
	 * @param recipientApply
	 * @return
	 */
	public int updateRecipientApply(RecipientApply recipientApply);
	
	/**
	 * 通过id查询领用申请表
	 * @param id
	 * @return
	 */
	public RecipientApply selectRecipientApplyById(String id);
    /**
     * 查询出所有审核通过，并且还没有出库登记的领用申请表记录
     * @param start
     * @param end
     * @return
     */
	public List<RecipientApplyExtend> selectRecipientApplyAuditAndPass(@Param("start") int start,@Param("end") int end);
	
	/**
	 * 查询出所有审核通过，并且还没有出库登记的领用申请表的总记录数
	 * @return
	 */
	public int selectRecipientApplyAuditAndPassCount();
	
	/**
	 * 查询出所有已审核的借用申请表记录（其状态可能是审核不通过，已领用，未领用等）
	 * @param start
	 * @param end
	 * @return
	 */
	public List<RecipientApplyExpireExtend> selectRecipientApplyAudit(@Param("start") int start,@Param("end") int end);
	
	/**
	 * 查询出所有已审核的借用申请表总记录数（其状态可能是审核不通过，已领用，未领用等）
	 * @return
	 */
	
	public int selectRecipientApplyAuditCount();
	
	/**
	 * 查询出所有未审核的借用申请表记录
	 * @param start
	 * @param end
	 * @return
	 */
	public List<RecipientApplyExtend> selectRecipientApplyUnAudit(@Param("start") int start,@Param("end") int end);
	
	/**
	 * 查询出所有未审核的领用申请表总记录数
	 * @return
	 */
	public int selectRecipientApplyUnAuditCount();
	
	/**
	 * 通过员工id查询其所有的领用申请记录（默认按商品id升序排列）
	 * @param start
	 * @param end
	 * @param recipiter
	 * @return
	 */
	public List<RecipientApplyReturnExtend> selectRecipientAppliesByStaffId(@Param("start")int start,@Param("end")int end,@Param("recipienter")String recipienter);
	
	/**
	 * 通过员工id查询其所有的领用申请总记录数
	 * @param recipiter
	 * @return
	 */
	public int selectRecipientAppliesByStaffIdCount(String recipiter);
	
	/**
	 * 查询所有有效（未过期）或所有无效（过期）的领用记录
	 * @param isValidate
	 * @return
	 */
	
	public List<RecipientApply> selectRecipientApplyByValidateState(int isValidate);
}
