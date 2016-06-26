package cn.fjnu.officeSystem.Enum;

public enum TimeEnum {//按天来看
	BORROW_TIME(30);//借用时间
	 private int intVlue;     
	    //构造函数必须为private的,防止意外调用  
	 private TimeEnum(int intVlue){  
	        this.intVlue = intVlue;  
	    }  
	 public int getIntVlue() {  
	       return intVlue;  
	   }

}
