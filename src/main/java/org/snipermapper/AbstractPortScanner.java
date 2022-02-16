package org.snipermapper;

import me.sniper10754.simplelogger4j.Logger;
import me.sniper10754.simplelogger4j.LoggerFactory;
import me.sniper10754.simplelogger4j.listeners.ConsoleListener;
import org.snipermapper.concurrent.ThreadPoolFactory;
import org.snipermapper.logging.CustomFormatter;

/**
 * The type Abstract port scanner.
 */
public abstract class AbstractPortScanner extends ThreadPoolPortScanner {
    /**
     * The Logger.
     */
    protected Logger logger = LoggerFactory.getLogger(getClass());
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
        
        logger.setFormatter(new CustomFormatter());
        logger.addListener(new ConsoleListener());
    }
    
    @Override
    public boolean scan(int port) {
        return scan(port, 250);
    }
    
    @Override
    public abstract boolean scan(int port, int delay);
}
