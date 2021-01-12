package com.wisdom.dataSource;

/**
 * @ClassName : DataSourceContextHolder
 * @Description : 数据源
 * @Author : dingwei
 * @Date: 2021-01-06 16:00
 */
public class DataSourceContextHolder {

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();
    // 设置数据源名
    public static void setDB(String dbType) {
        System.out.println("切换到{"+dbType+"}数据源");
        contextHolder.set(dbType);
    }
    // 获取数据源名
    public static String getDB() {
        return (contextHolder.get());
    }
    // 清除数据源名
    public static void clearDB() {
        contextHolder.remove();
    }
}
