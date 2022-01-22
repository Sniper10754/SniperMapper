package org.snipermapper;

public interface PortScanner {
    int PORT_MAX_VALUE = 65536;
    
    boolean scan(int port);
    boolean scan(int port, int delay);
}
