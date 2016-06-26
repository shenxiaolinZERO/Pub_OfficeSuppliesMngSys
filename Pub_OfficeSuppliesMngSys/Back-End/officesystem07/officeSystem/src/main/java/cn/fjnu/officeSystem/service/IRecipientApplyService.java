package cn.fjnu.officeSystem.service;

public interface IRecipientApplyService {

	// 获取所有已审核的领用申请记录
	public String getAuditRecipientApplies(String json);

	// 删除已审核的领用记录
	public void deleteAuditRecipientApply(String json);

	// 获取所有未审核的领用申请记录
	public String getUnAuditRecipientApplies(String json);

	// 管理员进行审核操作，其结果可能是审核通过，有可能是不通过
	public void operateRecipientAudit(String json);

	// 用户查询当前领用物品的信息
	public String userCurrentRecipientApply(String json);

	// 用户提交领用申请的操作
	public String submitRecipientApply(String json);

	// 用户查询历史借用申请的信息
	public String userHistoryRecipientApply(String json);
	
}
