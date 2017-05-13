package com.dupang.quartz;

import com.dupang.service.HelloService;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by Administrator on 2016/11/9.
 */
public class SpringQtz2 {
    private static int counter = 0;
    @Resource
    HelloService helloService;
    protected void execute() {
        helloService.sayHello("dupang");
    }
}