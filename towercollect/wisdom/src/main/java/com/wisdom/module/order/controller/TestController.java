package com.wisdom.module.order.controller;

import com.wisdom.module.order.service.TestService;
import com.wisdom.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    TestService testService;

    @RequestMapping(value = "/getUserApi",method = RequestMethod.GET)
    public ResponseData getUser(){
        return testService.getUser();
    }

    @RequestMapping(value = "/insertUserApi",method = RequestMethod.POST)
    public ResponseData insertUser(){
        return testService.insertUser();
    }

    @RequestMapping(value = "/updateUserApi",method = RequestMethod.PUT)
    public ResponseData updateUser(){
        return testService.updateUser();
    }

    @RequestMapping(value = "/deleteUserApi",method = RequestMethod.DELETE)
    public ResponseData deleteUser(){
        return testService.deleteUser();
    }

    @RequestMapping(value = "/getUsersApi",method = RequestMethod.GET)
    public ResponseData getUsers(){
        return testService.getUsers();
    }

}
