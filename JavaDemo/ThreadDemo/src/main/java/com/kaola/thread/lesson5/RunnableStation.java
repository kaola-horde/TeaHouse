package com.kaola.thread.lesson5;

import com.kaola.thread.lesson5.Ticket;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author ZhaoJl
 * @Description
 * @Date 2019/7/12
 **/
@Slf4j
public class RunnableStation implements Runnable {
    private Ticket ticket;

    RunnableStation(Ticket ticket) {
        this.ticket = ticket;
    }

    private void sold() throws InterruptedException {
        String threadName = Thread.currentThread().getName();
        // 让线程睡眠一会:模拟业务处理
        int seconds = Integer.parseInt(threadName.split("-")[1]) % 3 * 10;
        Thread.sleep(100);

        synchronized (ticket) {
            //Thread.sleep(100);
            if (ticket.getTickets() > 0) {
                ticket.setTickets(ticket.getTickets() - 1);
            }
            //内部做了同步
            //System.out.println("Thread: " + threadName + ", 余票：" + ticket.getTickets());
            log.info("Thread: " + threadName + ", 余票：" + ticket.getTickets());
        }
    }

    public void run() {
        String threadName = Thread.currentThread().getName();
        log.info("Running " + threadName);

        try {
            while (true) {
                if (ticket.getTickets() > 0) {
                    this.sold();
                } else {
                    log.info("Thread " + threadName + " exiting.");
                    break;
                }
            }
        } catch (Exception e) {
            log.info("Thread " + threadName + " interrupted.");
        }
    }
}
