package cn.fjnu.officeSystem.Enum;

public enum BaseInfoEnum {
	DEPARTMENT(1),//部门管理
	ITEM_TYPE(2),//物品分类管理
	MEASURE_UNIT(3),//计量单位管理
	INSTORAGE_TYPE(4),//入库类型管理
	OUTSTORAGE_TYPE(5),//出库类型管理
	SUPPLIER_TYPE(6);//供应商类型管理
	 private int intValue;     
	    //构造函数必须为private的,防止意外调用  
	 private BaseInfoEnum(int intValue){  
	        this.intValue = intValue;  
	    }  
	 public int getIntValue() {  
	       return intValue;  
	   }


}
