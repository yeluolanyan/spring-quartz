package com.wu.quartz;

import java.text.ParseException;

import org.quartz.JobDetail;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;


/**
 * 持久化数据 保存数据到数据库中
 */
public class PersistableCronTriggerFactoryBean extends CronTriggerFactoryBean {

    @Override
    public void afterPropertiesSet() throws ParseException {
        super.afterPropertiesSet();
        getJobDataMap().remove(getObject().getJobKey().getName());
    }
}


