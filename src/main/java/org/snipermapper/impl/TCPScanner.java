package org.snipermapper.impl;

import org.snipermapper.AbstractPortScanner;
import org.snipermapper.concurrent.ThreadPoolDefaultFactory;
import org.snipermapper.concurrent.ThreadPoolFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * The type Tcp scanner.
 */
public class TCPScanner extends AbstractPortScanner {
    
    /**
     * Instantiates a new Tcp scanner.
     *
     * @param address the address
     */
    public TCPScanner(String address) {
        this(address, new ThreadPoolDefaultFactory());
    }
    
    /**
     * Instantiates a new Tcp scanner.
     *
     * @param address the address
     * @param factory the factory
     */
    public TCPScanner(String address, ThreadPoolFactory factory) {
        super(address, factory);
    }

    @Override
    public boolean scan(int port, int delay) {
        try {
            Socket s = new Socket();
    
            s.connect(new InetSocketAddress(address, port), delay);
            s.close();
    
            logger.fine("Port " + port + " Open");
            return true;
        } catch (IOException e) {
            logger.fine("Port " + port + " Closed");
            
            return false;
        }
    }
}
