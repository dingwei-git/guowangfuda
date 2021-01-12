package com.wisdom.module.order.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {

    //id 的生成方式
    @TableId(type = IdType.UUID)
    private String userId;
    private String  userName;
    private String  email;
    private Date create_time;
    private Date update_time;

}
