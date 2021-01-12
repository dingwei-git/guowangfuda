package com.wisdom.module.order.service.impl;

import com.wisdom.module.order.bean.User;
import com.wisdom.module.order.mapper.UserMapper;
import com.wisdom.module.order.mapper.UserMappers;
import com.wisdom.module.order.service.TestService;
import com.wisdom.redis.RedisUtil;
import com.wisdom.response.ResponseData;
import com.wisdom.response.SuccessResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TestServiceImpl implements TestService {

    private static final Logger log = LoggerFactory.getLogger(TestServiceImpl.class);

    @Autowired
    UserMapper userMapper;
    @Autowired
    UserMappers userMappers;
    @Autowired
    RedisUtil redis;

    @Override
    @Transactional
    public ResponseData getUser() {
        log.info("1234567894567894561234567489456123456789");
        log.warn("1234567894567894561234567489456123456789");
        log.error("1234567894567894561234567489456123456789");
        String ss = redis.getString("aaa");
        List<User> list = userMapper.selectList(null);
        SuccessResponseData successResponseData = ResponseData.success(list);
        return successResponseData;
    }

    @Override
    @Transactional
    public ResponseData insertUser() {
        User user = new User();
        user.setUserName("zhangsan");
        user.setCreate_time(new Date());
        user.setEmail("1589574809@qq.com");
        userMapper.insert(user);
//        int i = 1/0;
        return null;
    }

    @Override
    public ResponseData updateUser() {
        User user = new User();
        user.setUserId("11111");
        user.setUserName("tom");
        user.setUpdate_time(new Date());
        userMapper.updateById(user);
        return null;
    }

    @Override
    public ResponseData deleteUser() {
        Map<String, Object> map = new HashMap<>();
        map.put("username", "tom");
        userMapper.deleteByMap(map);
        return null;
    }

    @Override
    public ResponseData getUsers() {
        List<User> list = userMappers.getUser();
        SuccessResponseData successResponseData = ResponseData.success(list);
        return successResponseData;
    }
}
