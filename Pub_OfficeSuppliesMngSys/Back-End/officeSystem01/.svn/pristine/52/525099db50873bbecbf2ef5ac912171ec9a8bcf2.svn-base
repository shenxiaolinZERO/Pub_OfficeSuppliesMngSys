package cn.fjnu.officeSystem.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class CompareDate {

	  public int compare_date(Date date1, Date date2) {//传入当前系统时间和从数据库中取出的时间
	        
	        
	        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	        try {
	            if (date1.getTime() > date2.getTime()) {
	                System.out.println("该物品已超过其最大允许的借用期限！");//已超期了
	                return -1;
	            } else if (date1.getTime() < date2.getTime()) {
	                System.out.println("该物品还未超过其最大允许的借用期限！请速来领取");
	                return 1;
	            } else {
	                return 0;
	            }
	        } catch (Exception exception) {
	            exception.printStackTrace();
	        }
	        return 0;
	    }

}
