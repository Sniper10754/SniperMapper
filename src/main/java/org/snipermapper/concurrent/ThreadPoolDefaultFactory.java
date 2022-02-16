package org.snipermapper.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * The type Thread pool default factory.
 */
public class ThreadPoolDefaultFactory
        implements ThreadPoolFactory {

    @Override
    public ExecutorService provide() {
        return Executors.newWorkStealingPool(Runtime.getRuntime().availableProcessors() * 2);
    }
}
