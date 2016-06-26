package cn.fjnu.officeSystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.stereotype.Repository;

import cn.fjnu.officeSystem.entity.StaffRole;

@Repository
public interface IStaffRoleDao {
	    /**
	     * 
	     * @param staffRole
	     * @return
	     */
	    public int inserStaffRole(StaffRole staffRole);
	    
		/**
		 * 通过id删除员工角色表的信息
		 * @param id
		 * @return
		 */
		public int deleteStaffRoleById(String id);
		
		/**
		 * 更改员工角色表的信息
		 * @param staffRole
		 * @return
		 */
		public int updateStaffRole(StaffRole staffRole);
		
		/**
		 * 通过id查询出员工角色表的信息
		 * @param id
		 * @return
		 */
		public StaffRole selectStaffRoleById(String id);
		
		/**
		 * 通过角色id查询出权限清单
		 * @param id
		 * @return
		 */
		public String selectPermissionsById(String id);
		
		

	

}
