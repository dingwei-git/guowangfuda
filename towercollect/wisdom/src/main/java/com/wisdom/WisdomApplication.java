package com.wisdom;

import com.wisdom.anantation.EnableMultiDataSource;
import com.wisdom.anantation.EnableRedis;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableMultiDataSource
@EnableRedis
@MapperScan({"com.wisdom.module.order.mapper"})
public class WisdomApplication {

    public static void main(String[] args) {
        SpringApplication.run(WisdomApplication.class,args);
    }

}
