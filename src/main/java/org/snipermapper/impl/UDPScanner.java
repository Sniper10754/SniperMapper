package org.snipermapper.impl;

import org.snipermapper.AbstractPortScanner;
import org.snipermapper.concurrent.ThreadPoolFactory;
import org.snipermapper.concurrent.ThreadPoolDefaultFactory;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPScanner extends AbstractPortScanner {

    public UDPScanner(String address) {
        this(address, new ThreadPoolDefaultFactory());
    }

    public UDPScanner(String address, ThreadPoolFactory factory) {
        super(address, factory);
    }

    @Override
    public boolean scan(int port, int delay) {
        try {
            byte[] bytes = new byte[128];

            DatagramSocket ds = new DatagramSocket();
            DatagramPacket dp = new DatagramPacket(bytes, bytes.length, InetAddress.getByName(address), port);

            ds.setSoTimeout(delay);
            ds.send(dp);

            dp = new DatagramPacket(bytes, bytes.length);
            ds.receive(dp);

            ds.close();
        } catch (IOException e) {
            return false;
        }

        return true;
    }
}
