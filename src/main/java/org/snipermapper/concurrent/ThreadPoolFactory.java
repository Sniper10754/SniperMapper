package org.snipermapper.concurrent;

import java.util.concurrent.ExecutorService;

/**
 * The interface Thread pool factory.
 */
public interface ThreadPoolFactory {
    /**
     * Provide an executor service.
     *
     * @return the executor service
     */
    ExecutorService provide();
}
