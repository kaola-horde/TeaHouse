package com.kaola.thread.lesson3;

/**
 * @Author ZhaoJl
 * @Description
 * @Date 2019/7/13
 **/
public class SellTicket implements Runnable {
    public static void main(String[] agrs) {
        Object A = "A";//对象A的锁
        Object B = "B";//对象B的锁
        Object C = "C";

        SellTicket sA = new SellTicket(C, A);
        SellTicket sB = new SellTicket(A, B);
        SellTicket sC = new SellTicket(B, C);
        Thread tA = new Thread(sA, "A线程");
        Thread tB = new Thread(sB, "B线程");
        Thread tC = new Thread(sC, "C线程");

        tA.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tB.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tC.start();

        /*
         *以下是增加内容
         */

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (B) {
            B.notify();
        }
    }


    public static int count = 10;//全局票数
    public volatile boolean why = true;

    private Object prev;
    private Object self;

    public SellTicket(Object prev, Object self) {
        this.prev = prev;
        this.self = self;
    }


    @Override
    public void run() {
        while (print()) ;
    }

    private boolean print() {
        while (count > 0) {
            synchronized (prev) {
                synchronized (self) {
                    // System.out.println(Thread.currentThread().getName() + "卖出第：" + count-- + "张，剩余"+count+"张");
                    count--;
                    //System.out.println(Thread.currentThread().getName() + self + ".notify");
                    self.notify();
                }
                if (!(count == 0)) {
                    try {
                        //System.out.println(Thread.currentThread().getName() + prev + ".wait");
                        prev.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
            //System.out.println(Thread.currentThread().getName()+"return true");
            return true;
        }
        //System.out.println(Thread.currentThread().getName()+"return false");
        return false;
    }
}

