package com.kaola.thread.lesson4;

/**
 * @Author ZhaoJl
 * https://www.cnblogs.com/lojun/articles/9346915.html
 * @Description
 * @Date 2019/7/13
 **/
public class SynchronizedObjectDemo {
    //静态的全局变量，类变量(可以是自定义对象)
    private static Object staticObject = new Object();
    //非静态变量，成员变量(可以是自定义对象)
    private Object o = new Object();

    /**
     * 功能描述: <br>
     * 类变量的方法上锁
     */
    public void printStaticObject() {
        synchronized (staticObject) {  //staticObject是静态变量，即类变量上锁
            try {
                //调用线程休眠5秒,锁竞争效果更加明显
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                //输出表示被调用
                System.out.println(System.currentTimeMillis() + " printByStaticObj is called");
            }
        }
    }

    /**
     * 功能描述: <br>
     * 在成员变量上锁的方法
     */
    public void printObj() {
        synchronized (o) { //o是成员变量
            try {
                //调用线程休眠5秒,锁竞争效果更加明显
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                //输出表示被调用
                System.out.println(System.currentTimeMillis() + " printByObj is called");
            }
        }
    }

    public static void main(String[] args) {
        //定义一个线程组
        ThreadGroup tgroups = new ThreadGroup(Thread.currentThread().getThreadGroup(), "SynchronizedObjectDemo");
        //循环，每次启动一个线程
        for (int i = 0; i < 5; i++) {
            //每一个线程，重新构造对象
            final SynchronizedObjectDemo syncObj = new SynchronizedObjectDemo();
            //构造新线程的时候把它加入到定义的线程组
            Thread obj = new Thread(tgroups, new Runnable() {
                @Override
                public void run() {
                    syncObj.printObj();
                }
            });
            obj.start();
        }
        for (int i = 0; i < 5; i++) {
            final SynchronizedObjectDemo syncObj = new SynchronizedObjectDemo();
            //构造新线程的时候把它加入到定义的线程组
            Thread obj = new Thread(tgroups, new Runnable() {
                @Override
                public void run() {
                    syncObj.printStaticObject();
                }
            });
            obj.start();
        }
    }
}
