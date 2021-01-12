package com.wisdom.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckUtils {

    /**
     * 校验必传参数
     * @param map
     * @param str
     * @return Map
     */
    public static Map<String,String> checkEmpty(Map<String,String> map, String... str){
        if(map==null){
            Map<String,String> maps = new HashMap<>();
            maps = new HashMap<>();
            maps.put("checkResult","false");
            maps.put("msg","报文为空");
            return maps;
        }
        for(String checkStr:str){
            if(StringUtils.isEmpty(map.get(checkStr))){
                map.put("checkResult","false");
                map.put("msg",checkStr+"字段为空");
            }
        }
        return map;
    }

    /**
     * 校验必传参数
     * @param jsonObject
     * @param str
     * @return Map
     */
    public static Map<String,String> checkEmpty(JSONObject jsonObject,String... str){
        Map<String,String> map = new HashMap<>();
        if(jsonObject!=null){
            map = JSONObject.parseObject(jsonObject.toString(),Map.class);
        }else {
            map.put("checkResult","false");
            map.put("msg","报文为空");
            return map;
        }
        for(String checkStr:str){
            if(StringUtils.isEmpty(map.get(checkStr))){
                map.put("checkResult","false");
                map.put("msg",checkStr+"字段为空");
                return map;
            }
        }
        return map;
    }

    /**
     * 校验必传参数
     * @param obj
     * @param str
     * @return Map
     */
    public static Map<String,String> checkEmpty(Object obj,String... str){
        Map<String,String> map = new HashMap<>();
        for(String checkStr:str){
            String code = checkStr.substring(0,1).toUpperCase()+checkStr.substring(1); //将属性的首字符大写，方便构造get，set方法
            Object value = getFieldValueByName(code,obj);
            if(value==null||"".equals(value)){
                map.put("checkResult","false");
                map.put("msg",checkStr+"字段为空");
                return map;
            }
        }
        return map;
    }

    /**
     * 遍历对象，返回json
     * @param obj
     * @return
     */
    private static Map<String,String> traverseCameraBriefInfoExes(Object obj){
        Map<String,String> map = null;
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
        return map;
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

    /**
     * 转化空字符串为其他
     * @param obj
     * @param change
     * @return
     */
    public static String newTrim(Object obj,String change) {
        if(obj==null || "".equals(obj)){
            return change;
        }
        return String.valueOf(obj);
    }

    /**
     * 将null转为""
     * @param obj
     * @return
     */
    public static String trim(Object obj) {
        if(obj==null || "".equals(obj)){
            return "";
        }
        return String.valueOf(obj);
    }

    public static List<String> checkOther(List<String> list, String str){
        List<String> resuleList = new ArrayList<String>();
        list.forEach(k->{
            if(str.equals(k)){
                k = "-";
            }
            resuleList.add(k);
        });
        return resuleList;
    }

}
