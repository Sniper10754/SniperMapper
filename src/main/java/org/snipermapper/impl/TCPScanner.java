package org.snipermapper.impl;

import me.sniper10754.simplelogger4j.Logger;
import me.sniper10754.simplelogger4j.impl.logger.EventLogger;
import me.sniper10754.simplelogger4j.impl.logger.SimpleLogger;
import org.snipermapper.AbstractPortScanner;
import org.snipermapper.concurrent.ThreadPoolFactory;
import org.snipermapper.concurrent.ThreadPoolDefaultFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class TCPScanner extends AbstractPortScanner {

    public TCPScanner(String address) {
        this(address, new ThreadPoolDefaultFactory());
    }

    public TCPScanner(String address, ThreadPoolFactory factory) {
        super(address, factory);
    }

    @Override
    public boolean scan(int port, int delay) {
        try {
            Socket s = new Socket();

            s.connect(new InetSocketAddress(address, port), delay);
            s.close();

            return true;
        } catch (IOException e) {
            return false;
        }
        

    }


}