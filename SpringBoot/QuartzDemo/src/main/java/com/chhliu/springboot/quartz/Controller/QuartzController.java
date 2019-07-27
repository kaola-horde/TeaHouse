package com.chhliu.springboot.quartz.Controller;

import javax.annotation.Resource;

/**
 * @Author ZhaoJl
 * @Description
 * @Date 2019/7/19
 **/
public class QuartzController {
    //这个bean在spring中配置，可以直接注入
    @Resource
    private QuartzManager quartzManager;

    //@RequestMapping(value = "startQuartz", method = {RequestMethod.GET})
    //@ResponseBody
    public String testQuartz(String quartzTime) throws Exception {
        //logger.info("===========开始执行调度=========时间为 " + quartzTime);
        String cronStr = quartzManager.transCron(quartzTime);
        //logger.info("======cron表达式========" + cronStr);
        quartzManager.addJob("test", "test", "test", "test", MyJob.class, cronStr);
        //quartzManager.modifyJobTime("test", "test", "test", "test", "0 50 10 * * ?");
        //quartzManager.removeJob("test", "test", "test", "test");
        //quartzManager.shutdownJobs();
        return "success";
    }

    //@RequestMapping(value = "stopQuartz", method = {RequestMethod.GET})
    //@ResponseBody
    public String shutDownQuartz() throws Exception {
        //logger.info("===========关闭调度test==================");
        quartzManager.removeJob("test", "test", "test", "test");
        return "关闭成功";
    }
}
