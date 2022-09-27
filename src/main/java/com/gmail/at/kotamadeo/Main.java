package com.gmail.at.kotamadeo;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<Future<String>> futureTask;
        futureTask = IntStream
                .rangeClosed(1, 4)
                .mapToObj(i -> executorService.submit(new MyThread("Задача - " + i, 5)))
                .toList();
        TimeUnit.SECONDS.sleep(15);
        executorService.shutdownNow();
        for (Future<String> future : futureTask) {
            System.out.println(future.get());
        }
    }
}