package com.kaola.thread.lesson2;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author ZhaoJl
 * @Description
 * @Date 2019/7/13
 **/
@Slf4j
public class SaleTicket implements Runnable {
    public int total;
    public int count;

    public SaleTicket() {
        total = 1000000;
        count = 0;
    }

    public void run() {
        while (total > 0) {
            synchronized (this) {
                if (total > 0) {
                    try {
                        Thread.sleep(100);
                        //Thread.sleep(new Random().nextInt(1000));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    count++;
                    total--;
                    //System.out.println(Thread.currentThread().getName() + "\t当前票号：" + count);
                    log.info(Thread.currentThread().getName() + "\t当前票号：" + count);
                }
            }
        }
    }

    public static void main(String[] args) {
        SaleTicket st = new SaleTicket();
        for (int i = 1; i <= 5; i++) {
            new Thread(st, "售票点" + i).start();
        }
    }

}