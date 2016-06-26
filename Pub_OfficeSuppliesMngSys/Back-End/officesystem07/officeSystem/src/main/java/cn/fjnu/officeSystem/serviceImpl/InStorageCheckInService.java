package cn.fjnu.officeSystem.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.omg.CORBA.StringHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.fjnu.officeSystem.Enum.InStorageTypeEnum;
import cn.fjnu.officeSystem.Enum.TableEnum;
import cn.fjnu.officeSystem.dao.BorrowApplyDao;
import cn.fjnu.officeSystem.dao.ISysTableKeyDao;
import cn.fjnu.officeSystem.dao.InStorageCheckInDao;
import cn.fjnu.officeSystem.dao.InStorageTypeDao;
import cn.fjnu.officeSystem.dao.ItemClassificationSummaryDao;
import cn.fjnu.officeSystem.dao.ItemDao;
import cn.fjnu.officeSystem.dao.ItemProcurementDao;
import cn.fjnu.officeSystem.dao.ItemSendDao;
import cn.fjnu.officeSystem.dao.ItemTypeDao;
import cn.fjnu.officeSystem.entity.BorrowApply;
import cn.fjnu.officeSystem.entity.InStorageCheckIn;
import cn.fjnu.officeSystem.entity.InStorageType;
import cn.fjnu.officeSystem.entity.Item;
import cn.fjnu.officeSystem.entity.ItemClassificationSummary;
import cn.fjnu.officeSystem.entity.ItemProcurement;
import cn.fjnu.officeSystem.entity.ItemSend;
import cn.fjnu.officeSystem.entity.ItemType;
import cn.fjnu.officeSystem.extend.BrrowApplyExtend;
import cn.fjnu.officeSystem.extend.InStorageCheckInExtend;
import cn.fjnu.officeSystem.extend.ItemProcurementExtend;
import cn.fjnu.officeSystem.utils.BeanToMap;
import cn.fjnu.officeSystem.utils.DateJsonValueProcessor;
import cn.fjnu.officeSystem.utils.PageUtil;
import cn.fjnu.officeSystem.utils.SystemUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
@Service
public class InStorageCheckInService implements cn.fjnu.officeSystem.service.InStorageCheckInService{
	@Resource
	InStorageTypeDao inStorageTypeDao;
	@Resource
	ItemProcurementDao itemProcurementDao;
	@Resource
	ItemTypeDao itemtypedao;
	@Resource
	BorrowApplyDao borrowApplyDao;
	@Resource
	ItemDao itemDao;
	@Resource
	SystemUtil systemUtil;
	@Resource
	InStorageCheckInDao inStorageCheckInDao;
	@Resource
	ItemClassificationSummaryDao itemClassificationSummaryDao;
	@Resource
	ItemSendDao itemSendDao;
	//请选择入库类型(1、采购，2、归还，3、受赠)
	@Override
	public String getInstorageType(){
		List<InStorageType> inStorageTypes=inStorageTypeDao.selectAllInStrorageTypes();
		if (inStorageTypes.size()==0) {//先看看是否数据库中有数据
			return "{\"message\":\"nothing\"}";
			
		}else{
			String result=JSONArray.fromObject(inStorageTypes).toString();
			return result;
		}
		
	}
	//根据选择的入库类型传回相应的首页
	@Override
	public String getInstorageHome(String json){
		JSONObject jsonObject=JSONObject.fromObject(json);
		String inStorageTypeId=jsonObject.optString("inStorageTypeId");
		int pageIndex=jsonObject.optInt("pageIndex");
		int pageCount=jsonObject.optInt("pageCount");
		int count=0;//统计总记录条数
		String result=null;
		Map<String, Object> resultMap=new HashMap<>();
		if (inStorageTypeId.equals("1")) {//采购入库
			System.out.println("************1******************");
			ItemProcurement itemProcurement=new ItemProcurement();
			itemProcurement.setSupplierId("-1");
			itemProcurement.setStaffId("-1");
			itemProcurement.setItemName("-1");
			itemProcurement.setItemTypeId("-1");
			count=itemProcurementDao.selectUnInStorageItemProcurementCount(itemProcurement);
			if (count>0) {
				PageUtil<ItemProcurementExtend> page=new PageUtil<>(pageIndex, count, pageCount);
				List<ItemProcurementExtend> resultList=itemProcurementDao.selectUnInStorageItemProcurement("-1","-1","-1","-1",0,page.getDataStart(),page.getDataEnd(),1);
				resultMap.put("resultList", resultList);
				resultMap.put("pageSize", page.getPageSize());
				
			}
			
		}else if(inStorageTypeId.equals("2")){//归还入库
			count=borrowApplyDao.selectInStorageBorrowApplieCount();
			if (count>0) {
				PageUtil<BrrowApplyExtend> page=new PageUtil<>(pageIndex, count, pageCount);
				List<BrrowApplyExtend> resultList=borrowApplyDao.selectInStorageBorrowApplies(page.getDataStart(), page.getDataEnd());
				resultMap.put("resultList", resultList);
				resultMap.put("pageSize", page.getPageSize());
			}
			
			
		}else{
			return "{\"message\":\"当前还未实现此功能的入库登记\"}";
		}
		if (count>0) {
			 JsonConfig config = new JsonConfig(); 
			 config.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd hh:mm:ss")); 
			resultMap.put("pageIndex", pageIndex);
			
			result=jsonObject.fromObject(resultMap, config).toString();
			return result;
			
		}else{
			return "{\"message\":\"该类型下无记录需登记\"}";
		}
		
		
	}
	
	//受赠入库:物品编号不要，物品上下限保留，单条入库
	@Transactional
	@Override
	public String sendInStorage(String json){
		//物品表、入库登记表、物品分类表
		JSONObject jsonObject=JSONObject.fromObject(json);
		JSONObject itemObject=jsonObject.optJSONObject("item");
		JSONObject inStorageCheckInObject=jsonObject.optJSONObject("InStorageCheckIn");
		Item item=(Item) itemObject.toBean(itemObject, Item.class);
		InStorageCheckIn inStorageCheckIn=(InStorageCheckIn) inStorageCheckInObject.toBean(inStorageCheckInObject, InStorageCheckIn.class);
		//生成物品主键
		String key=systemUtil.gerneratorKey(TableEnum.item);
		item.setItemId(key);
		item.setSupplierId("-1");
		//插入物品基本信息表
		itemDao.insertItem(item);
		ItemSend itemSend=new ItemSend();
		String itemSendKey=systemUtil.gerneratorKey(TableEnum.itemSend);
		itemSend.setId(itemSendKey);
		itemSend.setIsInStorage((short)1);
		itemSend.setItemId(key);
		itemSend.setItemName(item.getItemName());
		itemSend.setItemTypeId(item.getItemTypeId());
		itemSend.setMeasureUnitId(item.getMeasureUnitId());
		itemSend.setNum(inStorageCheckIn.getTotalNumber());
		itemSend.setSpec(item.getSpec());
		itemSend.setStaffId(inStorageCheckIn.getOperaterId());
		itemSend.setTime(new Date( ));
		itemSend.setFlag(1);
		itemSendDao.insertItemSend(itemSend);
		//完善入库信息插入入库登记表
		inStorageCheckIn.setInStorageTypeId((short)InStorageTypeEnum.SEND.getIntValue());
		inStorageCheckIn.setSupplierId("-1");
		inStorageCheckIn.setAgentId("-1");//受赠则无经办人即采购人员
		inStorageCheckIn.setItemListId(itemSendKey);
		inStorageCheckIn.setTotalMonney(0.0);//受赠的话即为无偿
		//插入入库登记信息
		int r1=inStorageCheckInDao.insertInStorageCheckIn(inStorageCheckIn);
		if (r1==1) {
			ItemClassificationSummary itemClassificationSummary=new ItemClassificationSummary();
		    //完善物品分类信息表信息
			itemClassificationSummary.setInventory(inStorageCheckIn.getTotalNumber());
		    itemClassificationSummary.setInventoryMonney(0.0);
		    itemClassificationSummary.setItemId(key);
			itemClassificationSummary.setItemName(item.getItemName());
			itemClassificationSummary.setItemTypeId(item.getItemTypeId());
			itemClassificationSummary.setMeasureUnitId(item.getMeasureUnitId());
			itemClassificationSummary.setPrice(0.0);
			itemClassificationSummary.setSpec(item.getSpec());
			//插入到物品分类信息表
			int r2=itemClassificationSummaryDao.insertItemClassificationSummary(itemClassificationSummary);
			if (r2==1) {
				return "{\"message\":\"success\"}";
				
			}else{
				return "{\"message\":\"error\"}";
				
			}
		}else{
			return "{\"message\":\"error\"}";
		}
	
	}
	//采购入库
	@Transactional
	@Override
	public String procurementInStorage(String json){
		System.out.println(json);
		JSONObject jsonObject=JSONObject.fromObject(json);
		JSONArray idArray=jsonObject.optJSONArray("idList");
		String operaterId=jsonObject.optString("operaterId");
		List<String> idList=new ArrayList<>();
		for (int i = 0; i < idArray.size(); i++) {// 将对象数组转为相应的list集合

			idList.add(idArray.optJSONObject(i).optString("id"));
			
		}
		List<ItemProcurement> itemProcurements=itemProcurementDao.selectItemProcurementByIdList(idList);
		List<InStorageCheckIn> inStorageCheckIns=new ArrayList<>();
		if (itemProcurements.size()>0) {
			//完善入库登记信息
			for(int j=0;j<itemProcurements.size();j++){
				InStorageCheckIn inStorageCheckIn=new InStorageCheckIn();
				inStorageCheckIn.setAgentId(itemProcurements.get(j).getStaffId());
				inStorageCheckIn.setInStorageTypeId((short)InStorageTypeEnum.PROCUREMENT.getIntValue());
				inStorageCheckIn.setItemListId(itemProcurements.get(j).getId());
				inStorageCheckIn.setOperaterId(operaterId);
				inStorageCheckIn.setSupplierId(itemProcurements.get(j).getSupplierId());
				inStorageCheckIn.setTotalMonney(itemProcurements.get(j).getMonney());
				inStorageCheckIn.setTotalNumber(itemProcurements.get(j).getNum());
				inStorageCheckIns.add(inStorageCheckIn);
				int upr=itemClassificationSummaryDao.updateAddItemClassificationSummaryByItemIdAndPrice(itemProcurements.get(j).getItemId(),
						itemProcurements.get(j).getPrice(),itemProcurements.get(j).getNum());
				if (upr==0) {
					
					ItemClassificationSummary itemClassificationSummary=new ItemClassificationSummary();
				    //完善物品分类信息表信息
					itemClassificationSummary.setInventory(inStorageCheckIn.getTotalNumber());
				    itemClassificationSummary.setInventoryMonney(0.0);
				    itemClassificationSummary.setItemId(itemProcurements.get(j).getItemId());
					itemClassificationSummary.setItemName(itemProcurements.get(j).getItemName());
					itemClassificationSummary.setItemTypeId(itemProcurements.get(j).getItemTypeId());
					itemClassificationSummary.setMeasureUnitId(itemProcurements.get(j).getMeasureUnitId());
					itemClassificationSummary.setPrice(itemProcurements.get(j).getPrice());
					itemClassificationSummary.setSpec(itemProcurements.get(j).getSpec());
					//插入数据到物品分类表
					itemClassificationSummaryDao.insertItemClassificationSummary(itemClassificationSummary);
					//更新物品采购表信息，是否已入库
					ItemProcurement itemProcurement=new ItemProcurement();
					itemProcurement.setEndTime(new Date());//系统当前时间
					itemProcurement.setIsInStorage(new Short("1"));
					itemProcurementDao.updateItemProcurement(itemProcurement);
					
				}
			}
			
			//批量插入入库登记表
			int result=inStorageCheckInDao.insertInStorageCheckInPl(inStorageCheckIns);
			
			//物品分类汇总表
		
			if (result==inStorageCheckIns.size()) {
				return "{\"message\":\"success\"}";
				
			}else{
				return "{\"message\":\"error\"}";
			}
			
			
			
		}else{
			System.out.println("数据库中无相应的采购申请单");
			return "{\"message\":\"error\"}";
		}
		
		
	}
	//归还入库
	@Transactional
	@Override
	public String returnInStorage(String json){
		System.out.println(json);
		JSONObject jsonObject=JSONObject.fromObject(json);
		JSONArray idArray=jsonObject.optJSONArray("idList");
		String operaterId=jsonObject.optString("operaterId");
		List<String> idList=new ArrayList<>();
		for (int i = 0; i < idArray.size(); i++) {// 将对象数组转为相应的list集合

			idList.add(idArray.optJSONObject(i).optString("id"));
			
		}
		List<BorrowApply> borrowApplies=borrowApplyDao.selectBorrowApplyByIdList(idList);
		if (borrowApplies.size()>0) {
			List<InStorageCheckIn> inStorageCheckIns=new ArrayList<>();
			//完善入库登记信息
			for(int j=0;j<borrowApplies.size();j++){
				InStorageCheckIn inStorageCheckIn=new InStorageCheckIn();
				inStorageCheckIn.setAgentId(borrowApplies.get(j).getBorrower());
				inStorageCheckIn.setInStorageTypeId((short)InStorageTypeEnum.RETURN.getIntValue());
				inStorageCheckIn.setItemListId(borrowApplies.get(j).getId());
				inStorageCheckIn.setOperaterId(operaterId);
				String z=itemDao.selectItemById(borrowApplies.get(j).getItemId()).getSupplierId();//通过物品id查询出供应商id
				inStorageCheckIn.setSupplierId(z);
				inStorageCheckIn.setTotalMonney(borrowApplies.get(j).getMonney());
				inStorageCheckIn.setTotalNumber(borrowApplies.get(j).getBorrowNum());
				inStorageCheckIns.add(inStorageCheckIn);
				int upr=itemClassificationSummaryDao.updateAddItemClassificationSummaryByItemIdAndPrice(borrowApplies.get(j).getItemId(),
						borrowApplies.get(j).getPrice(),borrowApplies.get(j).getBorrowNum());
				if (upr==0) {
					return "{\"message\":\"error\"}";
					
				}
				BorrowApply borrowApply=new BorrowApply();
				borrowApply.setBorrowTime(new Date());
				borrowApply.setIsReturn(new Short("1"));
				borrowApplyDao.updateBorrowApply(borrowApply);
			}
			//批量插入入库登记表
					int result=inStorageCheckInDao.insertInStorageCheckInPl(inStorageCheckIns);
					
					if (result==inStorageCheckIns.size()) {
						return "{\"message\":\"success\"}";
						
					}else{
						return "{\"message\":\"error\"}";
					}
			
		}else{
			System.out.println("没有相应的借用申请单");
			return "{\"message\":\"error\"}";
			
		}
		
				
		
	}
	//根据采购入库查询
	@Override
	public String getItemProcurementByMap(String itemName,String itemTypeId,String staffId){
	    List<ItemProcurementExtend> itemProcurements=itemProcurementDao.selectItemProcurementByMap(itemName,itemTypeId,staffId);
	    if (itemProcurements.size()==0) {
	    	return "{\"message\":\"nothing\"}";
			
		}else{
			JsonConfig config = new JsonConfig(); 
			 config.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd hh:mm:ss")); 
			JSONArray jsonArray=JSONArray.fromObject(itemProcurements,config);
			return jsonArray.toString();
		}
		
		
	}
	//根据借用入库查询
	@Override
	public String getBorrowApplyByMap(String itemName,String itemTypeId,String staffId){
		
		 List<BrrowApplyExtend> borrowApplies=borrowApplyDao.selectBorrowApplyByMap(itemName,itemTypeId,staffId);
		    if (borrowApplies.size()==0) {
		    	return "{\"message\":\"nothing\"}";
				
			}else{
				 JsonConfig config = new JsonConfig(); 
				 config.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd hh:mm:ss")); 
				JSONArray jsonArray=JSONArray.fromObject(borrowApplies,config);
				return jsonArray.toString();
			}
		
	}
	
	
	//入库统计
	@Override
	public String getInstorageSumary(String json){//需改动
		JSONObject jsonObject=JSONObject.fromObject(json);
		int pageIndex=jsonObject.optInt("pageIndex");
		int pageCount=jsonObject.optInt("pageCount");
		String startTime=jsonObject.optString("startTime");
		String endTime=jsonObject.optString("endTime");
		String itemTypeId=jsonObject.optString("itemTypeId");
		String inStorageTypeId=jsonObject.optString("inStorageTypeId");
		String itemName=jsonObject.optString("itemName");
		int count=0;//统计总记录条数
		count=inStorageCheckInDao.selectInStorageCheckInsByMapCount(startTime, endTime, itemTypeId, itemName,inStorageTypeId);
		Map<String, Object> resultMap=new HashMap<>();
		String result=null;
		if (count>0) {
			PageUtil<InStorageCheckInExtend> page=new PageUtil<>(pageIndex, count, pageCount);
			List<InStorageCheckInExtend> resultList=inStorageCheckInDao.selectInStorageCheckInsByMap(startTime, endTime, itemTypeId, itemName, inStorageTypeId, page.getDataStart(),page.getDataEnd());
			System.out.println(resultList);
			resultMap.put("resultList", resultList);
			
			resultMap.put("pageSize", page.getPageSize());
			 JsonConfig config = new JsonConfig(); 
			 config.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd hh:mm:ss")); 
			resultMap.put("pageIndex", pageIndex);
			System.out.println(resultMap);
			
			result=JSONObject.fromObject(resultMap, config).toString();
			return result;
			
			
		}else{
			return "{\"message\":\"nothing\"}";
		}
		
		
	}
	
	//生成报表poi
	
	
	
	
	
	
	
	
	
	
	

}
