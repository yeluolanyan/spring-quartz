package com.wu.task;

import com.wu.service.QuartzDemoService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

/**
 * Created by MJN on 2017/6/22.
 */
@Component
public class TimeTaskJobs extends QuartzJobBean {

    //这里就是因为有上文中的AutowiringSpringBeanJobFactory才可以使用@Autowired注解，否则只能在配置文件中设置这属性的值
    @Autowired
    private QuartzDemoService quartzDemoService;


    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException{
        quartzDemoService.printUserInfo();
    }
}
