package org.snipermapper;

import org.snipermapper.concurrent.ThreadPoolFactory;

public abstract class AbstractPortScanner extends ThreadPoolPortScanner {
    protected String address;
    
    public AbstractPortScanner(String address, ThreadPoolFactory factory) {
        super(factory);
        this.address = address;
    }
    
    @Override
    public boolean scan(int port) {
        return scan(port, 250);
    }
    
    @Override
    public abstract boolean scan(int port, int delay);
    
    
}
