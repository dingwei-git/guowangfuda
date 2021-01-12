package com.wisdom.module.order.mapper;

import com.wisdom.dataSource.DataSourceEnum;
import com.wisdom.dataSource.DataSourceSelect;
import com.wisdom.module.order.bean.User;

import java.util.List;

@DataSourceSelect(DataSourceEnum.eipsupplier)
public interface UserMappers {

    List<User> getUser();

}
