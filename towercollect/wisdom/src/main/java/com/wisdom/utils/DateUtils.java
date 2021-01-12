package com.wisdom.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    static DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String getDate(String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date());
    }

    /**
     * 计算时差
     * @param start 开始时间(yyyy-MM-dd HH:mm:ss)
     * @param end 结束时间(yyyy-MM-dd HH:mm:ss)
     * @param type 时差类型(ms:毫秒  minutes:分  hours:小时  day:天  默认毫秒)
     * @return Long
     */
    public static Long calculateJetLag(String start,String end,String type){
        try{
            Date startDate = df.parse(start);
            Date endDate = df.parse(end);
            if(startDate.getTime()>=endDate.getTime()){
                return Long.valueOf(0);
            }
            long diff = endDate.getTime() - startDate.getTime();
            if("ms".equals(type)){
                return Long.valueOf(diff);
            }
            if("minutes".equals(type)){
                int minutes = (int) (diff / (1000 * 60));
                return Long.valueOf(minutes);
            }
            if("hours".equals(type)){
                int hours = (int) (diff / (1000 * 60 * 60));
                return Long.valueOf(hours);
            }
            if("day".equals(type)){
                int days = (int) (diff / (1000 * 60 * 60 * 24));
                return Long.valueOf(days);
            }
            return Long.valueOf(diff);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Long.valueOf(0);
    }


}
