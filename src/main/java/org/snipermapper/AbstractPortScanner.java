package org.snipermapper;

import org.snipermapper.concurrent.ThreadPoolFactory;

/**
 * The type Abstract port scanner.
 */
public abstract class AbstractPortScanner extends ThreadPoolPortScanner {
    /**
     * The Address.
     */
    protected String address;
    
    /**
     * Instantiates a new Abstract port scanner.
     *
     * @param address the address
     * @param factory the factory
     */
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
