package com.wisdom.utils;

import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 遍历对象，返回json
 */
public class TraverseObjectUtil {

    public static JSONObject traverseCameraBriefInfoExes(Object obj){
        Field[] fields=obj.getClass().getDeclaredFields();
        String[] fieldNames=new String[fields.length];
        JSONObject json = new JSONObject();
        for(int i=0;i<fields.length;i++){
            String name = fields[i].getName();
            String code = name.substring(0,1).toUpperCase()+name.substring(1); //将属性的首字符大写，方便构造get，set方法
            fieldNames[i]=fields[i].getName();
            Object value = getFieldValueByName(code,obj);
            json.put(name,value);
        }
        return json;
    }
    /* 根据属性名获取属性值
     * */
    public static Object getFieldValueByName(String fieldName, Object model) {
        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = model.getClass().getMethod(getter, new Class[] {});
            Object value = method.invoke(model, new Object[] {});
            return value;
        } catch (Exception e) {
            return null;
        }
    }
}
