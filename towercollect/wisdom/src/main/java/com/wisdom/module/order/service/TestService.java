package com.wisdom.module.order.service;

import com.wisdom.response.ResponseData;

public interface TestService {

    ResponseData getUser();

    ResponseData insertUser();

    ResponseData updateUser();

    ResponseData deleteUser();

    ResponseData getUsers();
}
