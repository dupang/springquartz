package com.dupang.quartz;

import com.dupang.service.HelloService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by Administrator on 2016/11/9.
 */
public class SpringQtz1 extends QuartzJobBean {

    @Resource
    HelloService helloService;
    private static int counter = 0;
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        helloService.sayHello("dupang");
    }
}