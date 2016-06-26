package cn.fjnu.officeSystem.utils;



import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class BeanToMap {//将实体类转换为map类型
	public static Map ConvertObjToMap(Object obj){
        Map<String,Object> reMap = new HashMap<String,Object>();
        if (obj == null) 
         return null;
        Field[] fields = obj.getClass().getDeclaredFields();
        try {
         for(int i=0;i<fields.length;i++){
          try {
           Field f = obj.getClass().getDeclaredField(fields[i].getName());
           f.setAccessible(true);
                 Object o = f.get(obj);
                 reMap.put(fields[i].getName(), o);
          } catch (NoSuchFieldException e) {
           e.printStackTrace();
          } catch (IllegalArgumentException e) {
           e.printStackTrace();
          } catch (IllegalAccessException e) {
           e.printStackTrace();
          }
         }
        } catch (SecurityException e) {
         e.printStackTrace();
        } 
        return reMap;
       }
	

}
