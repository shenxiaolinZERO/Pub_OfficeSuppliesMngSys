package cn.fjnu.officeSystem.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.fjnu.officeSystem.entity.Log;
@Repository
public interface LogDao {
    /**
     * 插入数据到日志表
     * @param log
     * @return
     */
	public int insertLog(Log log);
    /**
     * 按以下条件进行查询
     * @param departmentId 部门id
     * @param staffId 员工id
     * @param staffName 员工姓名
     * @param computerIp 电脑ip号
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return
     */
	public List<Log> selectLogsByMap(@Param("departmentId") String departmentId, @Param("staffId") String staffId,
			@Param("staffName") String staffName, @Param("computerIp") String computerIp,
			@Param("startTime") Date startTime, @Param("endTime") String endTime);

}
