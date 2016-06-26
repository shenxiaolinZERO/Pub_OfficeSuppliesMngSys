package cn.fjnu.officeSystem.dao;

import cn.fjnu.officeSystem.entity.SysTableKey;

public interface ISysTableKeyDao {
	
	 int deleteByPrimaryKey(String tableName);

	    int insert(SysTableKey record);

	    int insertSelective(SysTableKey record);

	    SysTableKey selectByPrimaryKey(String tableName);

	    int updateByPrimaryKeySelective(SysTableKey record);

	    int updateByPrimaryKey(SysTableKey record);
	    
	    String selectTableKeyByTableName(String tableName);
}
