package com.kaola.thread.lesson1;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author ZhaoJl
 * @Description
 * @Date 2019/7/12
 **/
@Slf4j
public class ThreadDemo extends Thread {
    private Thread t;
    private String threadName;

    ThreadDemo(String name) {
        threadName = name;
        log.info("Creating " + threadName);
    }

    public void run() {
        log.info("Running " + threadName);
        try {
            for (int i = 4; i > 0; i--) {
                log.info("Thread: " + threadName + ", " + i);
                // 让线程睡眠一会
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            log.info("Thread " + threadName + " interrupted.");
        }
        log.info("Thread " + threadName + " exiting.");
    }

    public void start() {
        log.info("Starting " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
}
