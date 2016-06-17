package cn.fjnu.officeSystem.Enum;

public enum WarningStateEnum {
	passInvetory(1),//超于上限
	minInvetory(2);//低于下限
	
	 private int intVlue;     
	    //构造函数必须为private的,防止意外调用  
	 private WarningStateEnum(int intVlue){  
	        this.intVlue = intVlue;  
	    }  
	 public int getIntVlue() {  
	       return intVlue;  
	   }


}
