package com.feng.springbootredis;

import com.feng.springbootredis.utils.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.annotation.ElementType;

@SpringBootTest
class SpringbootRedisApplicationTests {

    /**
     * 注入RedisUtil
     */
    @Autowired
    RedisUtil redisUtil;
    @Test
    void contextLoads() {
    }


    @Test
    public void test1(){
        boolean fag = redisUtil.set("test", "bbb");
        if (fag){
            System.out.println("插入成功");
        }else {
            System.out.println("插入失败");
        }


    }

}
