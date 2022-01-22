package org.snipermapper.concurrent;

import java.util.concurrent.ExecutorService;

public interface ThreadPoolFactory {
    ExecutorService provide();
}
