package cn.fjnu.officeSystem.service;

import java.util.List;

import cn.fjnu.officeSystem.entity.Department;
import cn.fjnu.officeSystem.entity.InStorageType;
import cn.fjnu.officeSystem.entity.ItemType;
import cn.fjnu.officeSystem.entity.MeasureUnit;
import cn.fjnu.officeSystem.entity.OutStorageType;
import cn.fjnu.officeSystem.entity.SupplierType;

public interface BaseInfoService {
	public List<Department> getAllDepartment();

	// 新增部门信息
	public int addDepartment(Department department);

	// 根据部门id查询出相应的部门信息
	public Department getDepartmentById(String id);

	// 修改部门信息
	public int modifyDepartment(Department department);

	// 物品分类管理
	public List<ItemType> getAllItemType();

	// 新增物品类型
	public int addItemType(ItemType itemType);

	// 根据物品类型id查找出相应的物品分类
	public ItemType geItemTypeById(String id);

	// 修改物品类型
	public int modifyItemType(ItemType itemType);

	// 查找出所有的计量单位
	public List<MeasureUnit> getAllMeasureUnit();

	// 新增计量单位
	public int addMeasureUnit(MeasureUnit measureUnit);

	// 通过计量单位编号查找出相应的信息
	public MeasureUnit getMeasureUnitById(String id);

	// 更改计量单位信息
	public int updateMeasureUnit(MeasureUnit measureUnit);

	// 得到所有的入库类型
	public List<InStorageType> getAllInstorage();

	// 新增入库类型
	public int addInStorageType(InStorageType inStorageType);

	// 更改入库类型
	public int modfyInStorageType(InStorageType inStorageType);

	// 得到所有的出库类型
	public List<OutStorageType> getAllOutstorage();

	// 新增出库类型
	public int addOutStorageType(OutStorageType OutStorageType);

	// 更改出库类型
	public int modfyOutStorageType(OutStorageType OutStorageType);

	// 查询出所有的供应商类型
	public List<SupplierType> getAllSupplierType();

	// 新增供应商类型
	public int addSupplierType(SupplierType supplierType);

	// 更改供应商类型信息
	public int modifySupplierType(SupplierType supplierType);

}
