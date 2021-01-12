package com.wisdom.mybatisPlus;//package com.wisdom.mybatisPlus;
//
//import com.wisdom.redis.RedisUtil;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.ibatis.cache.Cache;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.util.CollectionUtils;
//import java.util.Set;
//import java.util.concurrent.locks.ReadWriteLock;
//import java.util.concurrent.locks.ReentrantReadWriteLock;
///**
// * @author dingwei
// * @create 2021/1/11 10:08
// * @Version 0.1
// */
//@Slf4j
//public class MybatisRedisCache implements Cache {
//
//    @Autowired
//    RedisUtil redis;
//    // 读写锁
//    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock(true);
//    //这里使用了redis缓存，使用springboot自动注入
//    private String id;
//    public MybatisRedisCache(final String id) {
//        if (id == null) {
//            throw new IllegalArgumentException("Cache instances require an ID");
//        }
//        this.id = id;
//    }
//    @Override
//    public String getId() {
//        return this.id;
//    }
//    @Override
//    public void putObject(Object key, Object value) {
//
//        if (value != null) {
//            redisTemplate.opsForValue().set(key.toString(), value);
//        }
//    }
//    @Override
//    public Object getObject(Object key) {
//
//        try {
//            if (key != null) {
//                return redisTemplate.opsForValue().get(key.toString());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            log.error("缓存出错 ");
//        }
//        return null;
//    }
//    @Override
//    public Object removeObject(Object key) {
//
//        if (key != null) {
//            redisTemplate.delete(key.toString());
//        }
//        return null;
//    }
//    @Override
//    public void clear() {
//        log.debug("清空缓存");
//
//        Set<String> keys = redisTemplate.keys("*:" + this.id + "*");
//        if (!CollectionUtils.isEmpty(keys)) {
//            redisTemplate.delete(keys);
//        }
//    }
//    @Override
//    public int getSize() {
//        Long size = redisTemplate.execute((RedisCallback<Long>) RedisServerCommands::dbSize);
//        return size.intValue();
//    }
//    @Override
//    public ReadWriteLock getReadWriteLock() {
//        return this.readWriteLock;
//    }
//}