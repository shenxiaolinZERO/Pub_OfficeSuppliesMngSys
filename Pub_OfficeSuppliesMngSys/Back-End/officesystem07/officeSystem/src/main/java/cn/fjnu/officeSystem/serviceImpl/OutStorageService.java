package cn.fjnu.officeSystem.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.fjnu.officeSystem.Enum.InStorageTypeEnum;
import cn.fjnu.officeSystem.Enum.TableEnum;
import cn.fjnu.officeSystem.dao.BorrowApplyDao;
import cn.fjnu.officeSystem.dao.DepartmentRecipientSummaryDao;
import cn.fjnu.officeSystem.dao.ItemClassificationSummaryDao;
import cn.fjnu.officeSystem.dao.ItemDao;
import cn.fjnu.officeSystem.dao.ItemSendDao;
import cn.fjnu.officeSystem.dao.OutStorageCheckInDao;
import cn.fjnu.officeSystem.dao.OutStorageTypeDao;
import cn.fjnu.officeSystem.dao.RecipientApplyDao;
import cn.fjnu.officeSystem.dao.StaffRecipientSummaryDao;
import cn.fjnu.officeSystem.dao.TransfiniteInventoryWarningDao;
import cn.fjnu.officeSystem.entity.BorrowApply;
import cn.fjnu.officeSystem.entity.DepartmentRecipientSummary;
import cn.fjnu.officeSystem.entity.InStorageCheckIn;
import cn.fjnu.officeSystem.entity.Item;
import cn.fjnu.officeSystem.entity.ItemClassificationSummary;
import cn.fjnu.officeSystem.entity.ItemProcurement;
import cn.fjnu.officeSystem.entity.ItemSend;
import cn.fjnu.officeSystem.entity.OutStorageCheckIn;
import cn.fjnu.officeSystem.entity.OutStorageType;
import cn.fjnu.officeSystem.entity.RecipientApply;
import cn.fjnu.officeSystem.entity.StaffRecipientSummary;
import cn.fjnu.officeSystem.extend.BrrowApplyExtend;
import cn.fjnu.officeSystem.extend.InStorageCheckInExtend;
import cn.fjnu.officeSystem.extend.ItemProcurementExtend;
import cn.fjnu.officeSystem.extend.RecipientApplyExtend;
import cn.fjnu.officeSystem.service.IOutStorageService;
import cn.fjnu.officeSystem.utils.DateJsonValueProcessor;
import cn.fjnu.officeSystem.utils.PageUtil;
import cn.fjnu.officeSystem.utils.SystemUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
 * 出库登记界面
 * 
 * @author zsy
 *
 */
@Service
public class OutStorageService implements IOutStorageService {

	@Resource
	BorrowApplyDao borrowApplyDao;
	@Resource
	OutStorageTypeDao outStorageTypeDao;
	@Resource
	RecipientApplyDao recipientApplyDao;
	@Resource
	ItemClassificationSummaryDao itemClassificationSummaryDao;
	@Resource
	SystemUtil systemUtil;
	@Resource
	OutStorageCheckInDao outStorageCheckInDao;
	@Resource
	DepartmentRecipientSummaryDao departmentRecipientSummaryDao;
	@Resource
	StaffRecipientSummaryDao staffRecipientSummaryDao;
	@Resource
	ItemDao itemDao;
	@Resource
	TransfiniteInventoryWarningDao transfiniteInventoryWarningDao;
	@Resource
	ItemSendDao itemSendDao;

	// 选择出库类型(1.借用，2.领用，3.赠予)
	@Override
	public String getOutstorageType() {
		// 获取数据库中所有出库类型
		List<OutStorageType> outStorageTypes = outStorageTypeDao.selectAllOutStorageTypes();
		if (outStorageTypes.size() == 0) {// 数据库中没有数据
			return "{\"message\":\"nothing\"}";
		} else {
			// 由list-->JSONArray-->String
			String result = JSONArray.fromObject(outStorageTypes).toString();
			return result;
		}
	}

	// 根据选择的出库类型跳转到对应的界面并显示数据
	@Override
	public String getOutstorageHome(String json) {
		// json字符串转json对象
		JSONObject jsonObject = JSONObject.fromObject(json);
		// 解析json中的数据为相应的类型
		String outStorageTypeId = jsonObject.optString("outStorageTypeId");
		int pageIndex = jsonObject.optInt("pageIndex");
		int pageCount = jsonObject.optInt("pageCount");
		int count = 0;// 统计总条数
		String result = null;// 返回json字符串给前端
		Map<String, Object> resultMap = new HashMap<>();
		if (outStorageTypeId.equals("1")) {// 借用类型
			count = borrowApplyDao.selectBorrowApplyAuditAndPassCount();
			if (count > 0) {
				PageUtil<BrrowApplyExtend> page = new PageUtil<>(pageIndex, count, pageCount);
				List<BrrowApplyExtend> resultList = borrowApplyDao.selectBorrowApplyAuditAndPass(page.getDataStart(),
						page.getDataEnd());
				System.out.println("**************"+resultList.size());
				resultMap.put("resultList", resultList);// 数据
				resultMap.put("pageSize", page.getPageSize());// 总页数
				System.out.println("map:" + resultMap);
			}
		} else if (outStorageTypeId.equals("2")) {// 领用类型
			count = recipientApplyDao.selectRecipientApplyAuditAndPassCount();
			if (count > 0) {
				PageUtil<RecipientApplyExtend> page = new PageUtil<>(pageIndex, count, pageCount);
				List<RecipientApplyExtend> resultList = recipientApplyDao
						.selectRecipientApplyAuditAndPass(page.getDataStart(), page.getDataEnd());
				resultMap.put("resultList", resultList);
				resultMap.put("pageSize", page.getPageSize());
			}
		} else if (outStorageTypeId.equals("3")) {// 赠予类型
			count = itemClassificationSummaryDao.selectAllItemClassificationSummaryCount();
			if (count > 0) {
				PageUtil<ItemClassificationSummary> page = new PageUtil<>(pageIndex, count, pageCount);
				List<ItemClassificationSummary> resultList = itemClassificationSummaryDao
						.selectAllItemClassificationSummaries();
				resultMap.put("resultList", resultList);
				resultMap.put("pageSize", page.getPageSize());
			}
		} else {
			return "{\"message\":\"当前还未实现此功能的出库登记\"}";
		}
		if (count > 0) {
			JsonConfig config = new JsonConfig();
			// 转换时记得要导入util.date
			config.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd hh:mm:ss"));
			resultMap.put("pageIndex", pageIndex);

			result = JSONObject.fromObject(resultMap, config).toString();
			System.out.println("----------"+result);
			return result;

		} else {
			return "{\"message\":\"该类型下无记录\"}";
		}
		// result=JSONObject.fromObject(resultMap).toString();
		// return result;

	}

	// 单条出库操作
	@Transactional
	@Override
	public String operateOutStorageCheckIn(String json) {
		// 插入出库登记表，部门领用汇总表，人员领用汇总表
		JSONObject jsonObject = JSONObject.fromObject(json);
//		JSONObject outStorageCheckInObject = jsonObject.optJSONObject("outStorageCheckIn");
		String id=jsonObject.optString("id");
		String operaterId=jsonObject.optString("operaterId");
		String outStorageTypeId = jsonObject.optString("outStorageTypeId");
//		OutStorageCheckIn outStorageCheckIn = (OutStorageCheckIn) outStorageCheckInObject
//				.toBean(outStorageCheckInObject, OutStorageCheckIn.class);
		
//		OutStorageCheckIn outStorageCheckIn=new OutStorageCheckIn();
		// 生成出库登记表主键
//		String key = systemUtil.gerneratorKey(TableEnum.outStorageCheckIn);
//		outStorageCheckIn.setId(key);
		// 出库类型（根据选择的页面判断），领用人id，领用部门id,制单人（管理员），数量，金额
		// 插入出库登记表
		// 对于赠予类型，不需要领用部门，合计金额也需要有前端传入
//		int succ = outStorageCheckInDao.insertOutStorageCheckIn(outStorageCheckIn);
//		if (succ == 1) {
			if (outStorageTypeId.equals("1")) {// 借用类型
//				JSONObject borrowApplyObject = jsonObject.optJSONObject("borrowApply");
//				BorrowApply borrowApply = (BorrowApply) borrowApplyObject.toBean(borrowApplyObject, BorrowApply.class);
				
				BorrowApply borrowApply=borrowApplyDao.selectBorrowApplyById(id);
//				List<OutStorageCheckIn> outStorageCheckIns=new ArrayList<>();
				//完善出库登记信息
					// 生成出库登记表主键
				OutStorageCheckIn outStorageCheckIn=new OutStorageCheckIn();
				String key = systemUtil.gerneratorKey(TableEnum.outStorageCheckIn);
				outStorageCheckIn.setId(key);
				outStorageCheckIn.setOutStorageTypeId(new Short(outStorageTypeId));
				outStorageCheckIn.setRecipienter(borrowApply.getBorrower());
				outStorageCheckIn.setDepartmentId(borrowApply.getBorrowDepartmentId().toString());
				outStorageCheckIn.setOperaterId(operaterId);
				outStorageCheckIn.setApplyId(borrowApply.getItemId());/////////////////////////////
				outStorageCheckIn.setTotalNumber(borrowApply.getBorrowNum());
				outStorageCheckIn.setTotalMonney(borrowApply.getMonney());
				int succ = outStorageCheckInDao.insertOutStorageCheckIn(outStorageCheckIn);
				if(succ==1){
					DepartmentRecipientSummary departmentRecipientSummary = new DepartmentRecipientSummary();
					// 完善部门领用汇总表
					departmentRecipientSummary.setDepartmentId(outStorageCheckIn.getDepartmentId());
					departmentRecipientSummary.setOutStorageCheckInId(key);
					departmentRecipientSummary.setItemId(borrowApply.getItemId());//
					departmentRecipientSummary.setItemName(borrowApply.getItemName());//
					departmentRecipientSummary.setSpec(borrowApply.getSpec());//
					departmentRecipientSummary.setItemTypeId(borrowApply.getItemTypeId());//
					departmentRecipientSummary
					.setMeasureUnitId(itemDao.selectItemById(borrowApply.getItemId()).getMeasureUnitId());// 通过itemId查到item
					departmentRecipientSummary.setPrice(borrowApply.getPrice());//
					departmentRecipientSummary.setNumber(outStorageCheckIn.getTotalNumber());//
					departmentRecipientSummary.setMonney(outStorageCheckIn.getTotalMonney());//
					departmentRecipientSummary.setOutStorageId(outStorageCheckIn.getOutStorageTypeId());//
					succ = departmentRecipientSummaryDao.insertDepartmentRecipientSummary(departmentRecipientSummary);
					if (succ == 1) {
						StaffRecipientSummary staffRecipientSummary = new StaffRecipientSummary();
						// 完善人员领用汇总表
						staffRecipientSummary.setStaffId(borrowApply.getBorrower().toString());////
						staffRecipientSummary.setOutStorageCheckInId(key);
						staffRecipientSummary.setItemId(borrowApply.getItemId());
						staffRecipientSummary.setItemName(borrowApply.getItemName());
						staffRecipientSummary.setItemTypeId(borrowApply.getItemTypeId());
						staffRecipientSummary.setSpec(borrowApply.getSpec());
						staffRecipientSummary
						.setMeasureUnitId(itemDao.selectItemById(borrowApply.getItemId()).getMeasureUnitId());
						staffRecipientSummary.setPrice(borrowApply.getPrice());
						staffRecipientSummary.setNumber(outStorageCheckIn.getTotalNumber());
						staffRecipientSummary.setMonney(outStorageCheckIn.getTotalMonney());
						succ = staffRecipientSummaryDao.insertStaffRecipientSummary(staffRecipientSummary);
						if (succ == 1) {
							itemClassificationSummaryDao.updateSubItemClassificationSummaryByItemIdAndPrice(
									borrowApply.getItemId(), borrowApply.getPrice(), borrowApply.getBorrowNum());
							succ=transfiniteInventoryWarningDao.updateSubTransfiniteInventoryByItemId(borrowApply.getItemId(),
									borrowApply.getBorrowNum());
							if(succ==1){
								//修改物品借用申请表记录
								java.util.Date date = new Date();
								borrowApply.setBorrowTime(date);;
								borrowApplyDao.updateBorrowApply(borrowApply);
							}
							return "{\"message\":\"此借用申请出库成功！\"}";
							
						} else {
							return "{\"message\":\"人员领用表插入失败！\"}";
							
						}
						
					} else {
						return "{\"message\":\"部门领用表插入失败！\"}";
					}
				}else{
					return "{\"message\":\"出库登记表插入失败！\"}";
				}
			} else if (outStorageTypeId.equals("2")) {// 领用类型
//				JSONObject recipientApplyObject = jsonObject.optJSONObject("recipientApply");
//				RecipientApply recipientApply = (RecipientApply) recipientApplyObject.toBean(recipientApplyObject,
//						RecipientApply.class);
				
				
				RecipientApply recipientApply=recipientApplyDao.selectRecipientApplyById(id);
//				List<OutStorageCheckIn> outStorageCheckIns=new ArrayList<>();
				//完善出库登记信息
					// 生成出库登记表主键
				OutStorageCheckIn outStorageCheckIn=new OutStorageCheckIn();
				String key = systemUtil.gerneratorKey(TableEnum.outStorageCheckIn);
				outStorageCheckIn.setId(key);
				outStorageCheckIn.setOutStorageTypeId(new Short(outStorageTypeId));
				outStorageCheckIn.setRecipienter(recipientApply.getRecipienter());
				outStorageCheckIn.setDepartmentId(recipientApply.getRecipientDepartmentId().toString());
				outStorageCheckIn.setOperaterId(operaterId);
				outStorageCheckIn.setApplyId(recipientApply.getItemId());/////////////////////////////
				outStorageCheckIn.setTotalNumber(recipientApply.getRecipientNum());
				outStorageCheckIn.setTotalMonney(recipientApply.getMonney());
				int succ = outStorageCheckInDao.insertOutStorageCheckIn(outStorageCheckIn);
				if(succ==1){
					// 完善部门领用汇总表
					DepartmentRecipientSummary departmentRecipientSummary = new DepartmentRecipientSummary();
					departmentRecipientSummary.setDepartmentId(outStorageCheckIn.getDepartmentId());
					departmentRecipientSummary.setOutStorageCheckInId(key);
					departmentRecipientSummary.setItemId(recipientApply.getItemId());//
					departmentRecipientSummary.setItemName(recipientApply.getItemName());//
					departmentRecipientSummary.setSpec(recipientApply.getSpec());//
					departmentRecipientSummary.setItemTypeId(recipientApply.getItemTypeId());//
					departmentRecipientSummary
					.setMeasureUnitId(itemDao.selectItemById(recipientApply.getItemId()).getMeasureUnitId());
					departmentRecipientSummary.setPrice(recipientApply.getPrice());//
					departmentRecipientSummary.setNumber(outStorageCheckIn.getTotalNumber());//
					departmentRecipientSummary.setMonney(outStorageCheckIn.getTotalMonney());//
					departmentRecipientSummary.setOutStorageId(outStorageCheckIn.getOutStorageTypeId());//
					succ = departmentRecipientSummaryDao.insertDepartmentRecipientSummary(departmentRecipientSummary);
					if (succ == 1) {
						StaffRecipientSummary staffRecipientSummary = new StaffRecipientSummary();
						// 完善人员领用汇总表
						staffRecipientSummary.setStaffId(recipientApply.getRecipienter().toString());////
						staffRecipientSummary.setOutStorageCheckInId(key);
						staffRecipientSummary.setItemId(recipientApply.getItemId());
						staffRecipientSummary.setItemName(recipientApply.getItemName());
						staffRecipientSummary.setItemTypeId(recipientApply.getItemTypeId());
						staffRecipientSummary.setSpec(recipientApply.getSpec());
						staffRecipientSummary
						.setMeasureUnitId(itemDao.selectItemById(recipientApply.getItemId()).getMeasureUnitId());
						staffRecipientSummary.setPrice(recipientApply.getPrice());
						staffRecipientSummary.setNumber(outStorageCheckIn.getTotalNumber());
						staffRecipientSummary.setMonney(outStorageCheckIn.getTotalMonney());
						succ = staffRecipientSummaryDao.insertStaffRecipientSummary(staffRecipientSummary);
						if (succ == 1) {
							itemClassificationSummaryDao.updateSubItemClassificationSummaryByItemIdAndPrice(
									recipientApply.getItemId(), recipientApply.getPrice(),
									recipientApply.getRecipientNum());
							succ=transfiniteInventoryWarningDao.updateSubTransfiniteInventoryByItemId(recipientApply.getItemId(),
									recipientApply.getRecipientNum());
							if(succ==1){
								//修改物品借用申请表记录
								java.util.Date date = new Date();
								recipientApply.setRecipientTime(date);
								recipientApplyDao.updateRecipientApply(recipientApply);
							}
							return "{\"message\":\"此领用申请出库成功！\"}";
							
						} else {
							return "{\"message\":\"人员领用表插入失败！\"}";
							
						}
						
					} else {
						return "{\"message\":\"部门领用表插入失败！\"}";
					}
				}else{
					return "{\"message\":\"出库登记表插入失败！\"}";
				}
			} else if (outStorageTypeId.equals("3")) {// 赠予类型
//				return "{\"message\":\"此赠予记录出库成功！\"}";
				ItemClassificationSummary itemClassificationSummary=itemClassificationSummaryDao.selectItemClassificationSummaryById(id);
				String recipienter=jsonObject.optString("recipienter");
				int num=jsonObject.optInt("number");
				OutStorageCheckIn outStorageCheckIn=new OutStorageCheckIn();
				String key = systemUtil.gerneratorKey(TableEnum.outStorageCheckIn);
				outStorageCheckIn.setId(key);
				outStorageCheckIn.setOutStorageTypeId(new Short(outStorageTypeId));
				outStorageCheckIn.setRecipienter(recipienter);
//				outStorageCheckIn.setDepartmentId(borrowApplies.get(i).getBorrowDepartmentId().toString());
				outStorageCheckIn.setOperaterId(operaterId);
				outStorageCheckIn.setApplyId(itemClassificationSummary.getItemId());
				outStorageCheckIn.setTotalNumber(new Long(num));
				outStorageCheckIn.setTotalMonney(num*(itemClassificationSummary.getPrice()));
				int succ = outStorageCheckInDao.insertOutStorageCheckIn(outStorageCheckIn);
				if(succ==1){
					ItemSend itemSend=new ItemSend();
					String itemSendKey=systemUtil.gerneratorKey(TableEnum.itemSend);
					itemSend.setId(itemSendKey);
					itemSend.setIsInStorage((short)3);
					itemSend.setItemId(itemClassificationSummary.getItemId());
					itemSend.setItemName(itemClassificationSummary.getItemName());
					itemSend.setItemTypeId(itemClassificationSummary.getItemTypeId());
					itemSend.setMeasureUnitId(itemClassificationSummary.getMeasureUnitId());
					itemSend.setNum(outStorageCheckIn.getTotalNumber());
					itemSend.setSpec(itemClassificationSummary.getSpec());
					itemSend.setStaffId(outStorageCheckIn.getOperaterId());
					itemSend.setTime(new Date( ));
					itemSend.setFlag(1);
					succ=itemSendDao.insertItemSend(itemSend);
					if(succ==1){
						succ=itemClassificationSummaryDao.updateSubItemClassificationSummaryByItemIdAndPrice(itemClassificationSummary.getItemId(), itemClassificationSummary.getPrice(), (long) num);
						if(succ==1){
							succ=transfiniteInventoryWarningDao.updateSubTransfiniteInventoryByItemId(itemClassificationSummary.getItemId(), (long) num);
							return "{\"message\":\"此赠予记录出库成功！\"}";
						}else{
							return "{\"message\":\"error2\"}";
							
						}
					}else{
						return "{\"message\":\"error\"}";
					}
				}else{
					return "{\"message\":\"出库登记表插入失败\"}";
				}
				
			} else {
				return "{\"message\":\"传入的出库类型有误！\"}";
			}

	}

	// 批量出库操作
	@Transactional
	public String operateOutStorageCheckInPL(String json) {

		// 插入出库登记表、部门领用汇总表、人员领用汇总表
		JSONObject jsonObject = JSONObject.fromObject(json);
		JSONArray idArray=jsonObject.optJSONArray("idList");
		String operaterId=jsonObject.optString("operaterId");
		String outStorageTypeId = jsonObject.optString("outStorageTypeId");
		List<String> idList=new ArrayList<>();
		for (int i = 0; i < idArray.size(); i++) {// 将对象数组转为相应的list集合
	
			idList.add(idArray.optJSONObject(i).optString("id"));
			
		}
		System.out.println(idList);
		if (outStorageTypeId.equals("1")) {// 借用类型
			List<BorrowApply> borrowApplies=borrowApplyDao.selectBorrowApplyByIdList(idList);
			System.out.println(borrowApplies);
			List<OutStorageCheckIn> outStorageCheckIns=new ArrayList<>();
			//完善出库登记信息
			if(borrowApplies.size()>0){
				for (int i = 0; i < borrowApplies.size(); i++) {
					//id////////////////////////////?主键需要每次都生成吗?
					// 生成出库登记表主键
					OutStorageCheckIn outStorageCheckIn=new OutStorageCheckIn();
					String key = systemUtil.gerneratorKey(TableEnum.outStorageCheckIn);
					outStorageCheckIn.setId(key);
					outStorageCheckIn.setOutStorageTypeId(new Short(outStorageTypeId));
					outStorageCheckIn.setRecipienter(borrowApplies.get(i).getBorrower());
					outStorageCheckIn.setDepartmentId(borrowApplies.get(i).getBorrowDepartmentId().toString());
					outStorageCheckIn.setOperaterId(operaterId);
					outStorageCheckIn.setApplyId(borrowApplies.get(i).getItemId());
					outStorageCheckIn.setTotalNumber(borrowApplies.get(i).getBorrowNum());
					outStorageCheckIn.setTotalMonney(borrowApplies.get(i).getMonney());
					outStorageCheckIns.add(outStorageCheckIn);
					int succ=itemClassificationSummaryDao.updateSubItemClassificationSummaryByItemIdAndPrice(borrowApplies.get(i).getItemId(), borrowApplies.get(i).getPrice(), borrowApplies.get(i).getBorrowNum());
					if(succ==1){
						succ=transfiniteInventoryWarningDao.updateSubTransfiniteInventoryByItemId(borrowApplies.get(i).getItemId(), borrowApplies.get(i).getBorrowNum());
						if(succ==1){
							//如果库存修改成功，则进一步完善部门领用汇总表和人员领用汇总表
							DepartmentRecipientSummary departmentRecipientSummary=new DepartmentRecipientSummary();
							departmentRecipientSummary.setDepartmentId(outStorageCheckIn.getDepartmentId());
							departmentRecipientSummary.setOutStorageCheckInId(key);
							departmentRecipientSummary.setItemId(borrowApplies.get(i).getItemId());
							departmentRecipientSummary.setItemName(borrowApplies.get(i).getItemName());
							departmentRecipientSummary.setSpec(borrowApplies.get(i).getSpec());
							departmentRecipientSummary.setItemTypeId(borrowApplies.get(i).getItemTypeId());
							departmentRecipientSummary.setMeasureUnitId(itemDao.selectItemById(borrowApplies.get(i).getItemId())
									.getMeasureUnitId());// 通过itemId查到item
							departmentRecipientSummary.setPrice(borrowApplies.get(i).getPrice());
							departmentRecipientSummary.setNumber(outStorageCheckIn.getTotalNumber());
							departmentRecipientSummary.setMonney(outStorageCheckIn.getTotalMonney());
							departmentRecipientSummary.setOutStorageId(outStorageCheckIn.getOutStorageTypeId());
							succ = departmentRecipientSummaryDao.insertDepartmentRecipientSummary(departmentRecipientSummary);
							if (succ == 1) {
								StaffRecipientSummary staffRecipientSummary = new StaffRecipientSummary();
								// 完善人员领用汇总表
								staffRecipientSummary.setStaffId(borrowApplies.get(i).getBorrower().toString());////
								staffRecipientSummary.setOutStorageCheckInId(key);
								staffRecipientSummary.setItemId(borrowApplies.get(i).getItemId());
								staffRecipientSummary.setItemName(borrowApplies.get(i).getItemName());
								staffRecipientSummary.setItemTypeId(borrowApplies.get(i).getItemTypeId());
								staffRecipientSummary.setSpec(borrowApplies.get(i).getSpec());
								staffRecipientSummary
								.setMeasureUnitId(itemDao.selectItemById(borrowApplies.get(i).getItemId()).getMeasureUnitId());
								staffRecipientSummary.setPrice(borrowApplies.get(i).getPrice());
								staffRecipientSummary.setNumber(outStorageCheckIn.getTotalNumber());
								staffRecipientSummary.setMonney(outStorageCheckIn.getTotalMonney());
								succ = staffRecipientSummaryDao.insertStaffRecipientSummary(staffRecipientSummary);
								if(succ==1){
									System.out.println("成功！");
								}else{
									return "{\"message\":\"人员领用表插入失败！\"}";
								}
							}else{
								return "{\"message\":\"部门领用表插入失败！\"}";
							}
						}else{
							return "{\"message\":\"库存预警表库存更改失败！\"}";
						}
					}else{
						return "{\"message\":\"物品分类汇总表库存更改失败！\"}";
					}
				}
			}else{
				return "{\"message\":\"数据库中无相应的借用申请单\"}";	
			}
			
			//修改物品借用申请表记录
			java.util.Date date = new Date();
			for (BorrowApply borrowApply : borrowApplies) {
				borrowApply.setBorrowTime(date);
				borrowApplyDao.updateBorrowApply(borrowApply);
			}
			//批量插入出库登记表
			System.out.println(outStorageCheckIns);
			int result=outStorageCheckInDao.insertOutStorageCheckInPl(outStorageCheckIns);	
			if (result==outStorageCheckIns.size()) {
				return "{\"message\":\"本组物品批量出库成功！\"}";
				
			}else{
				return "{\"message\":\"error\"}";
			}
			
		}else if(outStorageTypeId.equals("2")) {// 领用类型
//			List<BorrowApply> borrowApplies=borrowApplyDao.selectBorrowApplyByIdList(idList);
			List<RecipientApply> recipientApplies=recipientApplyDao.selectRecipientApplyByIdList(idList);
			List<OutStorageCheckIn> outStorageCheckIns=new ArrayList<>();
			if(recipientApplies.size()>0){
				//完善出库登记信息
				for (int i = 0; i < recipientApplies.size(); i++) {
					//id////////////////////////////?主键需要每次都生成吗?
					// 生成出库登记表主键
					OutStorageCheckIn outStorageCheckIn=new OutStorageCheckIn();
					String key = systemUtil.gerneratorKey(TableEnum.outStorageCheckIn);
					outStorageCheckIn.setId(key);
					outStorageCheckIn.setOutStorageTypeId(new Short(outStorageTypeId));
					outStorageCheckIn.setRecipienter(recipientApplies.get(i).getRecipienter());
					outStorageCheckIn.setDepartmentId(recipientApplies.get(i).getRecipientDepartmentId().toString());
					outStorageCheckIn.setOperaterId(operaterId);
					outStorageCheckIn.setApplyId(recipientApplies.get(i).getItemId());
					outStorageCheckIn.setTotalNumber(recipientApplies.get(i).getRecipientNum());
					outStorageCheckIn.setTotalMonney(recipientApplies.get(i).getMonney());
					outStorageCheckIns.add(outStorageCheckIn);
					int succ=itemClassificationSummaryDao.updateSubItemClassificationSummaryByItemIdAndPrice(recipientApplies.get(i).getItemId(), recipientApplies.get(i).getPrice(), recipientApplies.get(i).getRecipientNum());
					if(succ==1){
						succ=transfiniteInventoryWarningDao.updateSubTransfiniteInventoryByItemId(recipientApplies.get(i).getItemId(), recipientApplies.get(i).getRecipientNum());
						if(succ==1){
							//如果库存修改成功，则进一步完善部门领用汇总表和人员领用汇总表
							DepartmentRecipientSummary departmentRecipientSummary=new DepartmentRecipientSummary();
							departmentRecipientSummary.setDepartmentId(outStorageCheckIn.getDepartmentId());
							departmentRecipientSummary.setOutStorageCheckInId(key);
							departmentRecipientSummary.setItemId(recipientApplies.get(i).getItemId());
							departmentRecipientSummary.setItemName(recipientApplies.get(i).getItemName());
							departmentRecipientSummary.setSpec(recipientApplies.get(i).getSpec());
							departmentRecipientSummary.setItemTypeId(recipientApplies.get(i).getItemTypeId());
							departmentRecipientSummary.setMeasureUnitId(itemDao.selectItemById(recipientApplies.get(i).getItemId())
									.getMeasureUnitId());// 通过itemId查到item
							departmentRecipientSummary.setPrice(recipientApplies.get(i).getPrice());
							departmentRecipientSummary.setNumber(outStorageCheckIn.getTotalNumber());
							departmentRecipientSummary.setMonney(outStorageCheckIn.getTotalMonney());
							departmentRecipientSummary.setOutStorageId(outStorageCheckIn.getOutStorageTypeId());
							succ = departmentRecipientSummaryDao.insertDepartmentRecipientSummary(departmentRecipientSummary);
							if (succ == 1) {
								StaffRecipientSummary staffRecipientSummary = new StaffRecipientSummary();
								// 完善人员领用汇总表
								staffRecipientSummary.setStaffId(recipientApplies.get(i).getRecipienter());////
								staffRecipientSummary.setOutStorageCheckInId(key);
								staffRecipientSummary.setItemId(recipientApplies.get(i).getItemId());
								staffRecipientSummary.setItemName(recipientApplies.get(i).getItemName());
								staffRecipientSummary.setItemTypeId(recipientApplies.get(i).getItemTypeId());
								staffRecipientSummary.setSpec(recipientApplies.get(i).getSpec());
								staffRecipientSummary
								.setMeasureUnitId(itemDao.selectItemById(recipientApplies.get(i).getItemId()).getMeasureUnitId());
								staffRecipientSummary.setPrice(recipientApplies.get(i).getPrice());
								staffRecipientSummary.setNumber(outStorageCheckIn.getTotalNumber());
								staffRecipientSummary.setMonney(outStorageCheckIn.getTotalMonney());
								succ = staffRecipientSummaryDao.insertStaffRecipientSummary(staffRecipientSummary);
								if(succ==1){
									System.out.println("成功！");
								}else{
									return "{\"message\":\"人员领用表插入失败！\"}";
								}
							}else{
								return "{\"message\":\"部门领用表插入失败！\"}";
							}
						}else{
							return "{\"message\":\"库存预警表库存更改失败！\"}";
						}
					}else{
						return "{\"message\":\"物品分类汇总表库存更改失败！\"}";
					}
				}
			}else{
				return "{\"message\":\"数据库中无相应的领用申请单\"}";
			}
			//修改物品领用申请表记录
			java.util.Date date = new Date();
			for (RecipientApply recipientApply : recipientApplies) {
				recipientApply.setRecipientTime(date);
				recipientApplyDao.updateRecipientApply(recipientApply);
			}
			//批量插入出库登记表
			System.out.println(outStorageCheckIns);
			int result=outStorageCheckInDao.insertOutStorageCheckInPl(outStorageCheckIns);	
			if (result==outStorageCheckIns.size()) {
				return "{\"message\":\"本组物品批量出库成功！(领用)\"}";
				
			}else{
				return "{\"message\":\"error\"}";
			}
			
			
		}
//		else if (outStorageTypeId.equals("3")) {// 赠予类型
//			List<ItemClassificationSummary> itemClassificationSummaries=itemClassificationSummaryDao.selectItemClassificationSummaryByIdList(idList);
//			List<OutStorageCheckIn> outStorageCheckIns=new ArrayList<>();
//			//完善出库登记信息
//			for (int j = 0; j < outStorageCheckIns.size(); j++) {
//				// 生成出库登记表主键
//				String recipienter=jsonObject.optString("recipienter");
//				int num=jsonObject.optInt("number");
//				OutStorageCheckIn outStorageCheckIn=new OutStorageCheckIn();
//				String key = systemUtil.gerneratorKey(TableEnum.outStorageCheckIn);
//				outStorageCheckIn.setId(key);
//				outStorageCheckIn.setOutStorageTypeId(new Short(outStorageTypeId));
//				outStorageCheckIn.setRecipienter(recipienter);
////				outStorageCheckIn.setDepartmentId(borrowApplies.get(i).getBorrowDepartmentId().toString());
//				outStorageCheckIn.setOperaterId(operaterId);
//				outStorageCheckIn.setApplyId(itemClassificationSummaries.get(j).getItemId());
//				outStorageCheckIn.setTotalNumber(new Long(num));
//				outStorageCheckIn.setTotalMonney(num*(itemClassificationSummaries.get(j).getPrice()));
//				outStorageCheckIns.add(outStorageCheckIn);
//				int succ=itemClassificationSummaryDao.updateSubItemClassificationSummaryByItemIdAndPrice(itemClassificationSummaries.get(j).getItemId(), itemClassificationSummaries.get(j).getPrice(), (long) num);
//				if(succ==1){
//					succ=transfiniteInventoryWarningDao.updateSubTransfiniteInventoryByItemId(itemClassificationSummaries.get(j).getItemId(), (long) num);
//					if(succ==1){
//						return "{\"message\":\"此赠予记录出库成功！\"}";
//					}
//				}
//			}
//			//批量插入出库登记表
//			int result=outStorageCheckInDao.insertOutStorageCheckInPl(outStorageCheckIns);	
//			if (result==outStorageCheckIns.size()) {
//				return "{\"message\":\"success\"}";
//				
//			}else{
//				return "{\"message\":\"error\"}";
//			}
//		} 
		else {
			return "{\"message\":\"传入的出库类型有误！\"}";
		}

	
	}

	// 出库统计
	@Override
	public String getOutstorageSummary(String json) {
		JSONObject jsonObject = JSONObject.fromObject(json);
		int pageIndex=jsonObject.optInt("pageIndex");
		int pageCount=jsonObject.optInt("pageCount");
		String startTime=jsonObject.optString("startTime");
		String endTime=jsonObject.optString("endTime");
		String itemTypeId=jsonObject.optString("itemTypeId");
		String outStorageTypeId=jsonObject.optString("outStorageTypeId");
		String itemName=jsonObject.optString("itemName");
		int count = 0;
		count = outStorageCheckInDao.selectOutStorageCheckInByMapCount(startTime, endTime, itemTypeId, itemName, outStorageTypeId);
		Map<String, Object> resultMap = new HashMap<>();
		String result = null;
		if (count > 0) {
			PageUtil<OutStorageCheckIn> page = new PageUtil<>(pageIndex, count, pageCount);
			List<OutStorageCheckIn> resultList = outStorageCheckInDao.selectOutStorageCheckInByMap(startTime, endTime, itemTypeId, itemName, outStorageTypeId, page.getDataStart(), page.getDataEnd());
			resultMap.put("resultList", resultList);

			resultMap.put("pageSize", page.getPageSize());
			JsonConfig config = new JsonConfig();
			config.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd hh:mm:ss"));
			resultMap.put("pageIndex", pageIndex);

			result = jsonObject.fromObject(resultMap, config).toString();
			return result;
			// result = JSONObject.fromObject(resultMap).toString();
			// return result;
			// java.util.Date date = new Date(emp.getHiredate().getTime());
			// emp.setHiredate(date);

		} else {
			return "{\"message\":\"nothing\"}";
		}
	}
	

}
