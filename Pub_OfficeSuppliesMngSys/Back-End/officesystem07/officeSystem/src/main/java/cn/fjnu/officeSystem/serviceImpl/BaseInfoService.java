package cn.fjnu.officeSystem.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.fjnu.officeSystem.dao.DepartmentDao;
import cn.fjnu.officeSystem.dao.InStorageTypeDao;
import cn.fjnu.officeSystem.dao.ItemTypeDao;
import cn.fjnu.officeSystem.dao.MeasureUnitDao;
import cn.fjnu.officeSystem.dao.OutStorageTypeDao;
import cn.fjnu.officeSystem.dao.SupplierTypeDao;
import cn.fjnu.officeSystem.entity.Department;
import cn.fjnu.officeSystem.entity.InStorageType;
import cn.fjnu.officeSystem.entity.ItemType;
import cn.fjnu.officeSystem.entity.MeasureUnit;
import cn.fjnu.officeSystem.entity.OutStorageType;
import cn.fjnu.officeSystem.entity.SupplierType;

@Service
public class BaseInfoService implements cn.fjnu.officeSystem.service.BaseInfoService {// 基本信息管理
	@Resource
	DepartmentDao departmentDao;
	@Resource
	ItemTypeDao itemTypeDao;
	@Resource
	MeasureUnitDao measureUnitDao;
	@Resource
	InStorageTypeDao inStorageTypeDao;
	@Resource
	OutStorageTypeDao outStorageTypeDao;
	@Resource
	SupplierTypeDao supplierTypeDao;

	// 部门管理
	@Override
	public List<Department> getAllDepartment() {
		List<Department> resultList = departmentDao.selectAllDepartment();
		return resultList;
	}

	// 新增部门信息
	@Override
	public int addDepartment(Department department) {
		return departmentDao.insertDepartment(department);

	}

	// 根据部门id查询出相应的部门信息
	@Override
	public Department getDepartmentById(String id) {
		return departmentDao.selectDepartMentById(id);

	}

	// 修改部门信息
	@Override
	public int modifyDepartment(Department department) {
		return departmentDao.updateDepartment(department);

	}

	// 物品分类管理
	@Override
	public List<ItemType> getAllItemType() {
		return itemTypeDao.selectAllItemType();
	}

	// 新增物品类型
	@Override
	public int addItemType(ItemType itemType) {
		return itemTypeDao.insertItemType(itemType);
	}

	// 根据物品类型id查找出相应的物品分类
	@Override
	public ItemType geItemTypeById(String id) {
		return itemTypeDao.selectItemTypeById(id);

	}

	// 修改物品类型
	@Override
	public int modifyItemType(ItemType itemType) {
		return itemTypeDao.updateItemType(itemType);

	}

	// 查找出所有的计量单位
	@Override
	public List<MeasureUnit> getAllMeasureUnit() {
		return measureUnitDao.selectAllMeasureUnit();
	}

	// 新增计量单位
	@Override
	public int addMeasureUnit(MeasureUnit measureUnit) {
		return measureUnitDao.insertMeasureUnit(measureUnit);

	}

	// 通过计量单位编号查找出相应的信息
	@Override
	public MeasureUnit getMeasureUnitById(String id) {
		return measureUnitDao.selectMeasureUnitById(id);

	}

	// 更改计量单位信息
	@Override
	public int updateMeasureUnit(MeasureUnit measureUnit) {
		return measureUnitDao.updateMeasureUnit(measureUnit);

	}

	// 得到所有的入库类型
	@Override
	public List<InStorageType> getAllInstorage() {
		return inStorageTypeDao.selectAllInStrorageTypes();
	}

	// 新增入库类型
	@Override
	public int addInStorageType(InStorageType inStorageType) {
		return inStorageTypeDao.insertInStorageType(inStorageType);

	}

	// 更改入库类型
	@Override
	public int modfyInStorageType(InStorageType inStorageType) {
		return inStorageTypeDao.updateInStorageType(inStorageType);

	}

	// 得到所有的出库类型
	@Override
	public List<OutStorageType> getAllOutstorage() {
		return outStorageTypeDao.selectAllOutStorageTypes();
	}

	// 新增出库类型
	@Override
	public int addOutStorageType(OutStorageType OutStorageType) {
		return outStorageTypeDao.insertOutStorageType(OutStorageType);

	}

	// 更改出库类型
	@Override
	public int modfyOutStorageType(OutStorageType OutStorageType) {
		return outStorageTypeDao.updateOutStorageType(OutStorageType);

	}

	// 查询出所有的供应商类型
	@Override
	public List<SupplierType> getAllSupplierType() {
		return supplierTypeDao.selectAllSupplierType();
	}

	// 新增供应商类型
	@Override
	public int addSupplierType(SupplierType supplierType) {
		return supplierTypeDao.insertSupplierType(supplierType);

	}

	// 更改供应商类型信息
	@Override
	public int modifySupplierType(SupplierType supplierType) {
		return supplierTypeDao.updateSupplierType(supplierType);

	}

}
