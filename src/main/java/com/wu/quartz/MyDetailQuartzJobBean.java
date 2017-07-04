package com.wu.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.lang.reflect.Method;

/**
 * MyDetailQuartzJobBean解决MethodInvokingJobDetailFactoryBean把 Quartz 的 Task 实例化进入数据库时的Serializable 的错误问题
 * Created by MJN on 2017/7/4.
 */
public class MyDetailQuartzJobBean extends QuartzJobBean {
    private String targetObject;
    private String targetMethod;
    private ApplicationContext ctx;


    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        try {
            Object otargetObject = ctx.getBean(targetObject);
            Method m = null;
            try {
                //方法中的参数是JobExecutionContext类型
                m = otargetObject.getClass().getMethod(targetMethod, new Class[] {JobExecutionContext.class});
                m.invoke(otargetObject, new Object[] {context});
            } catch (SecurityException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            throw new JobExecutionException(e);
        }
    }


    public void setApplicationContext(ApplicationContext applicationContext){
        this.ctx=applicationContext;
    }

    public void setTargetObject(String targetObject) {
        this.targetObject = targetObject;
    }

    public void setTargetMethod(String targetMethod) {
        this.targetMethod = targetMethod;
    }
}
