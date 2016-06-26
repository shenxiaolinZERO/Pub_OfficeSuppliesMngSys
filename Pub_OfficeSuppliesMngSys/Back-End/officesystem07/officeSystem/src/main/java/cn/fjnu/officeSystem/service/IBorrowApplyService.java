package cn.fjnu.officeSystem.service;

public interface IBorrowApplyService {

	// 获取所有已审核的借用申请记录
	public String getAuditBorrowApplies(String json);

	// 删除已审核的借用记录
	public void deleteAuditBorrowApply(String json);

	// 获取所有未审核的借用申请记录
	public String getUnAuditBorrowApplies(String json);

	// 管理员进行审核操作，其结果可能是审核通过，有可能是不通过
	// 前端传入operate 其中0表示不通过，1表示通过
	public void operateBorrowAudit(String json);

	// 用户查询当前借用物品的信息
	public String userCurrentBorrowApply(String json);

	// 用户提交领用申请的操作
	public String submitBorrowApply(String json);

	// 用户查询历史借用申请的信息
	public String userHistoryBorrowApply(String json);

}
