package com.chhliu.springboot.quartz.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "quartz.config")
public class QuartzConfigProperties {
    private String targetObject;

    private String targetMethod;

    private boolean concurrent;

    private String cronExpression;

    private String applicationContextSchedulerContextKey;

    private boolean waitForJobsToCompleteOnShutdown;

    /**
     * @return the targetObject
     */
    public String getTargetObject() {
        return targetObject;
    }

    /**
     * @param targetObject the targetObject to set
     */
    public void setTargetObject(String targetObject) {
        this.targetObject = targetObject;
    }

    /**
     * @return the targetMethod
     */
    public String getTargetMethod() {
        return targetMethod;
    }

    /**
     * @param targetMethod the targetMethod to set
     */
    public void setTargetMethod(String targetMethod) {
        this.targetMethod = targetMethod;
    }

    /**
     * @return the concurrent
     */
    public boolean isConcurrent() {
        return concurrent;
    }

    /**
     * @param concurrent the concurrent to set
     */
    public void setConcurrent(boolean concurrent) {
        this.concurrent = concurrent;
    }

    /**
     * @return the cronExpression
     */
    public String getCronExpression() {
        return cronExpression;
    }

    /**
     * @param cronExpression the cronExpression to set
     */
    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    /**
     * @return the applicationContextSchedulerContextKey
     */
    public String getApplicationContextSchedulerContextKey() {
        return applicationContextSchedulerContextKey;
    }

    /**
     * @param applicationContextSchedulerContextKey the applicationContextSchedulerContextKey to set
     */
    public void setApplicationContextSchedulerContextKey(String applicationContextSchedulerContextKey) {
        this.applicationContextSchedulerContextKey = applicationContextSchedulerContextKey;
    }

    /**
     * @return the waitForJobsToCompleteOnShutdown
     */
    public boolean isWaitForJobsToCompleteOnShutdown() {
        return waitForJobsToCompleteOnShutdown;
    }

    /**
     * @param waitForJobsToCompleteOnShutdown the waitForJobsToCompleteOnShutdown to set
     */
    public void setWaitForJobsToCompleteOnShutdown(boolean waitForJobsToCompleteOnShutdown) {
        this.waitForJobsToCompleteOnShutdown = waitForJobsToCompleteOnShutdown;
    }
}
