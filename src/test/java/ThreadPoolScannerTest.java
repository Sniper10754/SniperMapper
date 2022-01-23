import org.junit.jupiter.api.Test;
import org.snipermapper.AbstractPortScanner;
import org.snipermapper.impl.TCPScanner;
import org.snipermapper.impl.UDPScanner;

import java.util.Arrays;

public class ThreadPoolScannerTest {
    public final String target = "localhost";
    
    @Test
    public void tcpScan() {
        AbstractPortScanner scanner = new TCPScanner(target);
    
        System.out.println(Arrays.toString(scanner.scanPorts(0, 80)));
    }
    
    @Test
    public void udpScan() {
        AbstractPortScanner scanner = new UDPScanner(target);
    
        System.out.println(Arrays.toString(scanner.scanPorts(0, 80)));
    }
}
