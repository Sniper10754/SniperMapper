package org.snipermapper;

/**
 * The interface Port scanner.
 */
public interface PortScanner {
    /**
     * The constant PORT_MAX_VALUE.
     */
    int PORT_MAX_VALUE = 65536;
    
    /**
     * Scan boolean.
     *
     * @param port the port
     * @return the boolean
     */
    boolean scan(int port);
    
    /**
     * Scan boolean.
     *
     * @param port  the port
     * @param delay the delay
     * @return the boolean
     */
    boolean scan(int port, int delay);
}
