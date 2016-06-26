package cn.fjnu.officeSystem.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.fjnu.officeSystem.dao.SupplierDao;
import cn.fjnu.officeSystem.entity.Supplier;
import cn.fjnu.officeSystem.extend.MerchantsAvailabilityDetail;
import cn.fjnu.officeSystem.extend.ProcurementApplyExtend;
import cn.fjnu.officeSystem.extend.SupplierExtend;
import cn.fjnu.officeSystem.utils.PageUtil;
import net.sf.json.JSONObject;
@Service
public class SupplierManagerService implements cn.fjnu.officeSystem.service.SupplierManagerService {
	@Resource
	SupplierDao supplierDao;
	/**
	 * 新增供应商
	 * @param supplier
	 * @return
	 */
	@Override
	public int addSupplier(Supplier supplier){
		return supplierDao.insertSupplier(supplier);
		
	}
	
	/**
	 * 动态更改供应商信息
	 * @param supplier
	 * @return
	 */
	@Override
	public int modifySupplier(Supplier supplier){
		
		return supplierDao.updateSupplier(supplier);
		
	}

	/**
	 * 查询出系统中所有的供应商
	 * @return
	 */
	@Override
	public String getAllSupplier(int pageIndex, int pageCount) {
		int count=supplierDao.selectAllSupplierCount();
		Map<String, Object> resultMap = new HashMap<>();
		if (count>0) {
			
			PageUtil<SupplierExtend> page = new PageUtil<>(pageIndex, count, pageCount);
			List<SupplierExtend> resultList=supplierDao.selectAllSupplier(page.getDataStart(),page.getDataEnd());
			resultMap.put("resultList", resultList);
			resultMap.put("pageSize", page.getPageSize());
			resultMap.put("pageIndex", pageIndex);
			return JSONObject.fromObject(resultMap).toString();
		}else {
			return "{\"message\":\"nothing\"}";
		}

	
	}

	/**
	 * 查询出系统中有效的供应商信息
	 * 
	 * @return
	 */
	@Override
	public String getValidSupplier(int pageIndex, int pageCount) {
		int count=supplierDao.selectValidSupplierCount();
		Map<String, Object> resultMap = new HashMap<>();
		if (count>0) {
			
			PageUtil<SupplierExtend> page = new PageUtil<>(pageIndex, count, pageCount);
			List<SupplierExtend> resultList=supplierDao.selectValidSupplier(page.getDataStart(),page.getDataEnd());
			resultMap.put("resultList", resultList);
			resultMap.put("pageSize", page.getPageSize());
			resultMap.put("pageIndex", pageIndex);
			return JSONObject.fromObject(resultMap).toString();
		}else {
			return "{\"message\":\"nothing\"}";
		}
		
		
	}

	/**
	 * 查询出系统中无效的供应商信息
	 * 
	 * @return
	 */
	@Override
	public String getUnValidSupplier(int pageIndex, int pageCount) {
		int count=supplierDao.selectUnValidSupplierCount();
		Map<String, Object> resultMap = new HashMap<>();
		if (count>0) {
			
			PageUtil<SupplierExtend> page = new PageUtil<>(pageIndex, count, pageCount);
			List<SupplierExtend> resultList=supplierDao.selectUnValidSupplier(page.getDataStart(),page.getDataEnd());
			resultMap.put("resultList", resultList);
			resultMap.put("pageSize", page.getPageSize());
			resultMap.put("pageIndex", pageIndex);
			return JSONObject.fromObject(resultMap).toString();
		}else {
			return "{\"message\":\"nothing\"}";
		}

	}
	/**
	 * 按以下条件查询出供应商基本信息
	 * @param isValid 是否有效
	 * @param supplierTypeId 供应商类型id
	 * @return
	 */
	@Override
	public String getSupplierByTypeAndState(int isValid, String supplierTypeId, int pageIndex, int pageCount) {
		int count=supplierDao.selectSupplierByTypeAndStateCount(isValid, supplierTypeId);
		Map<String, Object> resultMap = new HashMap<>();
		if (count>0) {
			
			PageUtil<SupplierExtend> page = new PageUtil<>(pageIndex, count, pageCount);
			List<SupplierExtend> resultList=supplierDao.selectSupplierByTypeAndState(isValid, supplierTypeId,page.getDataStart(), page.getDataEnd());
			resultMap.put("resultList", resultList);
			resultMap.put("pageSize", page.getPageSize());
			resultMap.put("pageIndex", pageIndex);
			return JSONObject.fromObject(resultMap).toString();
		}else {
			return "{\"message\":\"nothing\"}";
		}

		
	}
	/**
	 * 根据供应商id查看该供应商的详情，包括供货情况
	 * @param supplierId
	 * @return
	 */

	@Override
	public MerchantsAvailabilityDetail getMerchantsAvailabilityDetailBySupplierId(String supplierId) {
		
		return supplierDao.selectMerchantsAvailabilityDetailBySupplierId(supplierId);
	}

}
