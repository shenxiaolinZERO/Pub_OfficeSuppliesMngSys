package cn.fjnu.officeSystem.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

import cn.fjnu.officeSystem.entity.Department;
@Repository
public interface DepartmentDao {
	/**
	 * 添加部门信息
	 * @param department
	 * @return
	 */
	public int insertDepartment(Department department);
	/**
	 * 更新部门信息
	 * @param department
	 * @return
	 */
	public int updateDepartment(Department department);
	/**
	 * 查询出所有的部门信息
	 * @return
	 */
	public List<Department> selectAllDepartment();
	/**
	 * 根据id查出部门名称
	 * @param id
	 * @return
	 */
	public Department selectDepartMentById(String id);

}
