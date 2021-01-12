package com.wisdom.module.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wisdom.dataSource.DataSourceEnum;
import com.wisdom.dataSource.DataSourceSelect;
import com.wisdom.module.order.bean.User;

@DataSourceSelect(DataSourceEnum.eipsupplier)
public interface UserMapper extends BaseMapper<User> {

}
