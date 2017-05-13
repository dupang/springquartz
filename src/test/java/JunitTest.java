import com.dupang.quartz.SpringQtz1;
import org.junit.Before;
import org.junit.Test;
import org.quartz.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import java.io.InputStream;
import java.util.Calendar;
import java.util.Scanner;

/**
 * Created by dupang on 2016/11/15.
 */
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class JunitTest extends AbstractJUnit4SpringContextTests {

    @Before
    public void before(){
        System.out.println("============启动前============");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    }
    @Test
    public void helloTest(){
        System.out.println("dupang");
        System.out.println("请输入信息：");
        Scanner input = new Scanner(System.in);
        int x= input.nextInt();
        System.out.println(x);
    }

    @Test
    public void schedulerTest() throws SchedulerException {
        SchedulerFactory schedFact = new org.quartz.impl.StdSchedulerFactory();
        Scheduler sched = schedFact.getScheduler();
        sched.start();

        JobDetail jobDetail = new JobDetail("myJob",Scheduler.DEFAULT_GROUP,SpringQtz1.class);

        SimpleTrigger trigger = new SimpleTrigger("testTrigger", Scheduler.DEFAULT_GROUP);
        trigger.setRepeatCount(10);
        trigger.setRepeatInterval(500);
        trigger.setStartTime(Calendar.getInstance().getTime());

        sched.scheduleJob(jobDetail, trigger);
        System.out.println("请输入信息：");
        Scanner input = new Scanner(System.in);
        int x= input.nextInt();
        System.out.println(x);
    }
}
