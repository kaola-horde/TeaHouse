package com.chhliu.springboot.quartz.Controller;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * @Author ZhaoJl
 * @Description
 * @Date 2019/7/19
 **/
public class MyJob implements Job {

    private Logger logger = LoggerFactory.getLogger(MyJob.class);

    //直接注入
    @Resource
    private QuartzManager quartzManager;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        try {
            test();
            downloadYZfile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void test() throws Exception {
        logger.info("【test】动态定时调度测试");
    }

    /**
     * 同步光宽转化率月清单
     *
     * @throws Exception
     */
    public void downloadYZfile() throws Exception {
        //自己的业务逻辑在这里实现
    }

}
