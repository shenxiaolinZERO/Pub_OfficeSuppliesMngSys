package cn.fjnu.officeSystem.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.fjnu.officeSystem.entity.BorrowApply;
import cn.fjnu.officeSystem.extend.BorrowApplyExpireExtend;
import cn.fjnu.officeSystem.extend.BorrowApplyReturnExtend;
import cn.fjnu.officeSystem.extend.BrrowApplyExtend;
import cn.fjnu.officeSystem.extend.BrrowApplyXXExtend;

@Repository
public interface BorrowApplyDao {
	
	/**
	 * 添加物品借用申请表记录
	 * @param borrowApply
	 * @return
	 */
	public int insertBorrowApply(BorrowApply borrowApply);
	
	/**
	 * 根据id删除物品借用申请表记录
	 * @param id
	 * @return
	 */
	public int deleteBorrowApplyById(String id);
	
	/**
	 * 动态更新物品借用申请表
	 * @param borrowApply
	 * @return
	 */
	public int updateBorrowApply(BorrowApply borrowApply);
	
	/**
	 * 根据id查询物品借用表
	 * @param id
	 * @return
	 */
	public List<BorrowApply> selectAllBorrowApplies();
	/**
	 * 通过id查询出借用申请
	 * @param id
	 * @return
	 */
	public BorrowApply selectBorrowApplyById(String id);

	/**

	 * 通过id集合查出所有的信息
	 * @param idList
	 * @return
	 */
	public List<BorrowApply> selectBorrowApplyByIdList(List<String> idList);
	/**
	 * 根据物品id查询物品借用申请表
	 * @param itemId

	 * 查询出所有审核通过，并且还没有出库登记的借用申请表记录
	 * @param start
	 * @param end

	 * @return
	 */
	public List<BrrowApplyExtend> selectBorrowApplyAuditAndPass(@Param("start") int start,@Param("end") int end);
	

	/**
	 * 查询出所有审核通过，并且还没有出库登记的借用申请表的总记录数
	 * @return
	 */
	public int selectBorrowApplyAuditAndPassCount();
	
	/**
	 * 查询出所有已审核的借用申请表记录（其状态可能是审核不通过，已借出，未借出,已超期和已归还等）
	 * @param start
	 * @param end
	 * @return
	 */
	public List<BorrowApplyExpireExtend> selectBorrowApplyAudit(@Param("start") int start,@Param("end") int end);
	
	/**
	 * 查询出所有已审核的借用申请表总记录数（其状态可能是审核不通过，已借出，已超期，未借出和已归还等）
	 * @return
	 */
	
	public int selectBorrowApplyAuditCount();
	
	/**
	 * 查询出所有未审核的借用申请表记录
	 * @param start
	 * @param end
	 * @return
	 */
	public List<BrrowApplyExtend> selectBorrowApplyUnAudit(@Param("start") int start,@Param("end") int end);
	
	/**
	 * 查询出所有未审核的借用申请表总记录数
	 * @return
	 */
	public int selectBorrowApplyUnAuditCount();
	
	/**
	 * 借还入库查询条件
	 * @param itemName
	 * @param itemTypeId
	 * @param staffId
	 * @return
	 */
	public List<BrrowApplyExtend>selectBorrowApplyByMap(@Param("itemName")String itemName,
			@Param("itemTypeId")String itemTypeId,@Param("staffId")String staffId);
	
	/**
	 * 查询出所有需要入库登记的借用申请（已借出但未归还的状态）
	 * @param start
	 * @param end
	 * @return
	 */
	public List<BrrowApplyExtend> selectInStorageBorrowApplies(@Param("start") int start,@Param("end") int end);
	
	/**
	 * 查询出所有需要入库登记的借用申请（已借出但未归还的状态）总记录数
	 * @return
	 */
	public int selectInStorageBorrowApplieCount();
	
	/**
	 * 查询出所有已借出但未归还且库存低于下限的的的借用申请单
	 * @param start
	 * @param end
	 * @return
	 */
	public List<BrrowApplyXXExtend> selectBorrowedXXApplies(@Param("start") int start,@Param("end") int end);
	/**
	 * 查询出所有已借出但未归还且库存低于下限的的借用申请单总记录数
	 * @return
	 */
	public int selectBorrowedXXAppliesCount();
	
	/**
	 * 查询出所有已借出但未归还且库存低于下限且已超期的借用申请单
	 * @param start
	 * @param end
	 * @return
	 */
	public List<BrrowApplyXXExtend> selectBorrowedXXPassApplies(@Param("start") int start,@Param("end") int end);
	/**
	 * 查询出所有已借出但未归还且库存低于下限的的借用申请单总记录数
	 * @return
	 */
	public int selectBorrowedXXPassAppliesCount();
	/**
	 * 通过物品id查询出已借出但未归还且库存低于下限且已超期的借用申请单
	 * @param itemId
	 * @return
	 */
	public List<BrrowApplyXXExtend> selectBorrowedXXPassAppliesByItemId(String itemId);
	/**
	 * 通过物品id查询出已借出但未归还且库存低于下限的借用申请单
	 * @param itemId
	 * @return
	 */
	public List<BrrowApplyXXExtend> selectBorrowedXXAppliesByItemId(String itemId);
	
	/**
	 * 通过员工id查询其所有的借用申请记录（默认按商品id升序排列）
	 * @param start
	 * @param end
	 * @param borrower
	 * @return
	 */
	public List<BorrowApplyReturnExtend> selectBorrowAppliesByStaffId(@Param("start")int start,@Param("end")int end,@Param("borrower")String borrower);
	
	/**
	 * 通过员工id查询其所有的借用申请总记录数
	 * @return
	 */
	public int selectBorrowAppliesByStaffIdCount(String borrower);


}
