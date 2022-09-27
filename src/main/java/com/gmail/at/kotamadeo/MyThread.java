package com.gmail.at.kotamadeo;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.currentThread;

public class MyThread implements Callable<String> {
    private final String title;
    private final long seconds;

    public MyThread(String title, long seconds) {
        this.title = title;
        this.seconds = seconds;
    }

    @Override
    public String call() {
        int counter = 1;
        currentThread().setName(title);
        try {
            while (!currentThread().isInterrupted()) {
                System.out.printf("Я - %s. Всем привет! Сообщение № %d%n", currentThread().getName(), counter++);
                TimeUnit.SECONDS.sleep(seconds);
            }
        } catch (InterruptedException ignored) {
        } finally {
            System.out.printf("%s завершена%n", currentThread().getName());
        }
        return String.format("%s вывела сообщений - %d раз.", currentThread().getName(), counter);
    }
}
