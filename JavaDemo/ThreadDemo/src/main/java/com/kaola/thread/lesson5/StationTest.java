package com.kaola.thread.lesson5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Description TODO
 * @Author kaolajiaozhu
 * @Date 2019/7/27 13:22
 **/
public class StationTest {
    /**
     * @return
     * @Author kaolajiaozhu
     * @Description 获取线程运行的总时间
     * @Date 12:46 2019/7/27
     * @Param []
     **/
    public static long mainRunnable2() {
        ExecutorService exec = Executors.newCachedThreadPool();
        long startTime = System.currentTimeMillis();

        Ticket ticket = new Ticket();
        ticket.setTickets(10000);

        for (int i = 1; i <= 3; i++) {
            //exec.execute(new RunnableDemo("Station-" + i, ticket));
            //RunnableDemo runnableDemo = new RunnableDemo("Station-" + i);
            //runnableDemo.start(ticket);
        }

        exec.shutdown();
        try {
            exec.awaitTermination(1, TimeUnit.DAYS); // 或者更长时间（这行代码是关键）
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public static void mainRunnable() {
        Ticket ticket = new Ticket();
        ticket.setTickets(100);
        RunnableStation runnableStation = new RunnableStation(ticket);
        for (int i = 1; i <= 5; i++) {
            new Thread(runnableStation, "Station-" + i).start();
        }
    }

    public static void main(String[] args) {
        StationTest.mainRunnable();
    }
}
