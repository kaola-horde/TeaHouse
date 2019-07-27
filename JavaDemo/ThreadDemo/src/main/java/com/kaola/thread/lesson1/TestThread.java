package com.kaola.thread.lesson1;

/**
 * @Author ZhaoJl
 * @Description
 * @Date 2019/7/12
 **/
public class TestThread {
    public static void mainThread() {
        ThreadDemo T1 = new ThreadDemo("Thread-1");
        T1.start();

        ThreadDemo T2 = new ThreadDemo("Thread-2");
        T2.start();
    }

    public static void mainRunnable() {
        RunnableDemo R1 = new RunnableDemo("Thread-1");
        R1.start();

        RunnableDemo R2 = new RunnableDemo("Thread-2");
        R2.start();
    }

    public static void main(String[] args) throws InterruptedException {
        TestThread.mainRunnable();
        //TestThread.mainThread();
    }
}
