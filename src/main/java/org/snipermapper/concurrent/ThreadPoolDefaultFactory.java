package org.snipermapper.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDefaultFactory
        implements ThreadPoolFactory {

    @Override
    public ExecutorService provide() {
        return Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    }
}
