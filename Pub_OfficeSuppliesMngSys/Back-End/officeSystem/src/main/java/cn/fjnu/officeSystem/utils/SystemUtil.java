package cn.fjnu.officeSystem.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.fjnu.officeSystem.Enum.TableEnum;
import cn.fjnu.officeSystem.dao.ISysTableKeyDao;
import cn.fjnu.officeSystem.entity.SysTableKey;




/**
 * 主键生成器
 * @author fwwer 2015-11-23
 */
@Component
public class SystemUtil {

	/**
	 * 系统主键dao
	 */
	@Autowired
	private ISysTableKeyDao sysTableKeyDao;

	
	/**
	 *主键：  SO    00    151123   0000
	 *    表标识     进位     创建时间    流水号（流水号0~9999，满10000进位加一）
	 *    
	 * 根据表名生成最新主键 TODO 事务控制
	 * @param table 需要主键的数据库表
	 * @return 所生成的主键
	 */
	public synchronized String gerneratorKey(TableEnum table){
		
		//去数据库中去当前最大值
		String key = sysTableKeyDao.selectTableKeyByTableName(table.toString());
		
		//取到当前key中的时间和当前时间
		String date = key.substring(4, 10);
		String today = new SimpleDateFormat("yyMMdd").format(new Date());
		
		//判断取到的两个时间是否为同一天
		if(today.equals(date)) {
			//主键加一
			key = increaseKey(key);
		} else {
			//重置主键为当天的第一个主键
			key = StringUtils.overlay(key, "00", 2, 4);
			key = StringUtils.overlay(key, today, 4, 10);
			key = StringUtils.overlay(key, "0000", 10, 14);
		}
		
		//key写回数据库.......
		SysTableKey sysTableKey = new SysTableKey();
		sysTableKey.setTableName(table.toString());
		sysTableKey.setTableKey(key);
		sysTableKeyDao.updateByPrimaryKeySelective(sysTableKey);
		
		return key;
	}

	/**
	 * 主键加一
	 * @param key 当前主键值
	 * @return 加一后的主键值
	 */
	private String increaseKey(String key) {
		//取得流水号
		int num = Integer.parseInt(key.substring(10, 14));
		//流水号+1，若＜10000，则将更新主键的流水号为新流水号，否则，主键进位加一，主键流水号更新为0000
		if(++num < 10000){
			String strnum = Integer.toString(num);
			for(int i = strnum.length(); i < 4; i++){
				strnum = "0" + strnum;
			}
			key = StringUtils.overlay(key, strnum, 10, 14);
		} else {
			num = Integer.parseInt(key.substring(2, 4));
			++num;
			String strnum = Integer.toString(num);
			for(int i = strnum.length(); i < 2; i++){
				strnum = "0" + strnum;
			}
			key = StringUtils.overlay(key, strnum, 2, 4);
			key = StringUtils.overlay(key, "0000", 10, 14);
		}
		return key;
	}
	
	

}
