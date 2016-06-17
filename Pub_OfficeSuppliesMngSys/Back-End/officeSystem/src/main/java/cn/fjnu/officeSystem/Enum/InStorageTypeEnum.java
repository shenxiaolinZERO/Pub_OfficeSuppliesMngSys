package cn.fjnu.officeSystem.Enum;

public enum InStorageTypeEnum {
	PROCUREMENT(1),//采购
	RETURN(2),//归还
	SEND(3);//受赠
	 private int intValue;     
	    //构造函数必须为private的,防止意外调用  
	 private InStorageTypeEnum(int intValue){  
	        this.intValue = intValue;  
	    }  
	 public int getIntValue() {  
	       return intValue;  
	   }


}
