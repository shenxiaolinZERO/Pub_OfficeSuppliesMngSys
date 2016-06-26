package cn.fjnu.officeSystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.stereotype.Repository;

import cn.fjnu.officeSystem.entity.Staff;



@Repository
public interface IStaffDao {

	/**
	 * 添加员工信息
	 * @param staff
	 * @return
	 */
	public int insertStaff(Staff staff);

	/**
	 * 更改员工信息
	 * @param staff
	 * @return
	 */
	public int updateStaff(Staff staff);

	/**
	 * 通过id查询出员工信息
	 * @param id
	 * @return
	 */
	public Staff selectStaffById(String id);
	/**
	 * 将某些部门的员工都设为某一角色
	 * @param departmentIds
	 * @param role
	 * @return
	 */
	public int updateStaffRoleBydepartment(@Param("departmentIds")List<String> departmentIds,@Param("role") String role);
	
	/**
	 * 通过员工的id查询其部门id
	 * @param staffId
	 * @return
	 */
	public int getDepartmentIdByStaffId(String id);


}
