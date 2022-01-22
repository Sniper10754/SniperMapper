package org.snipermapper;

import org.snipermapper.concurrent.ThreadPoolFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public abstract class ThreadPoolPortScanner implements ThreadPoolScanner, PortScanner {
    protected ThreadPoolExecutor threadPool;
    protected ThreadPoolFactory factory;
    
    public ThreadPoolPortScanner(ThreadPoolFactory factory) {
        this.factory = factory;
        
        renewThreadPool();
    }
    
    public synchronized void renewThreadPool() {
        this.threadPool = (ThreadPoolExecutor) this.factory.provide();
    }
    
    @Override
    public int[] scanPorts(final Collection<Integer> ports) {
        synchronized (this) {
            Collection<Integer> openPorts = new ArrayList<>();
            final Map<Integer, Future<Boolean>> map = new HashMap<>();
            
            for (Integer port : ports) {
                map.put(port, threadPool.submit(() -> this.scan(port)));
            }
            
            threadPool.shutdown();
            
            map.forEach((integer, booleanFuture) -> {
                try {
                    if (booleanFuture.get()) {
                        openPorts.add(integer);
                    }
                } catch (Throwable ignored) {}
            });
            
            int[] openPortsArray = new int[openPorts.size()];
            
            for (int i = 0; i < openPortsArray.length; i++) {
                openPortsArray[i] = (int) openPorts.toArray()[i];
            }
            
            renewThreadPool();
            
            return openPortsArray;
        }
    }
    
    @Override
    public int[] scanPorts(int start, int finish) {
        synchronized (this) {
            Collection<Integer> ports = new ArrayList<>();
            
            for (int i = start != 0 ? start : 1; i < finish; i++) {
                ports.add(i);
            }
            
            return scanPorts(ports);
        }
    }
    
    @Override
    public abstract boolean scan(int port, int delay);
    
    @Override
    public abstract boolean scan(int port);
    
    public ThreadPoolExecutor getThreadPool() {return threadPool;}
}
