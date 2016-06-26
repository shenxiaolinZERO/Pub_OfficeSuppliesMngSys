package cn.fjnu.officeSystem.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import cn.fjnu.officeSystem.dao.IStaffDao;
import cn.fjnu.officeSystem.entity.Staff;
import net.sf.json.JSONObject;

@Service
public class staffService {
	@Resource
	IStaffDao staffDao;
	//个人中心(或者更改员工信息)
	public String modifyStaff(Staff staff){
		int result=staffDao.updateStaff(staff);
		if (result==1) {
			return "{\"message\":\"success\"}";
			
		}else{
			return "{\"message\":\"error\"}";
		}
		
		
	}
	//增加员工信息
	public String addStaff(Staff staff){
		int result=staffDao.insertStaff(staff);
		if (result==1) {
			return "{\"message\":\"success\"}";
			
		}else{
			return "{\"message\":\"error\"}";
		}
		
		
	}
	//批量设置某部门下的角色
	public String PlModifyStaffRoles(List<String> departmentIds,String role){
		int result=staffDao.updateStaffRoleBydepartment(departmentIds, role);
		if (result==0) {
			return "{\"message\":\"error\"}";
			
		}else{
			Map<String, String> map=new HashMap<>();
			map.put("message","共成功更新了"+ result+"条");
			return JSONObject.fromObject(map).toString();
		}
		
	}
	//登录（牵扯到shiro而且还要动态刷出它的个人菜单，另登录的时候不要选择角色）
	
	

}
