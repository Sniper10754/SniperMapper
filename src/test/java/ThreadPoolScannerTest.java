import me.sniper10754.simplelogger4j.Logger;
import me.sniper10754.simplelogger4j.LoggerFactory;
import org.junit.jupiter.api.Test;
import org.snipermapper.PortScanner;
import org.snipermapper.ThreadPoolScanner;
import org.snipermapper.impl.TCPScanner;
import org.snipermapper.impl.UDPScanner;

import java.util.stream.IntStream;

public class ThreadPoolScannerTest {
    public final String target = "scanme.nmap.org";
    private int finish = PortScanner.PORT_MAX_VALUE;
    private Logger logger = LoggerFactory.getLogger(getClass());
    
    @Test
    public void tcpScan() {
        ThreadPoolScanner poolScanner = new TCPScanner(target);
        PortScanner portScanner = (PortScanner) poolScanner;
        
        IntStream.of(poolScanner.scanPorts(0, finish))
                .forEach(i -> logger.info("Port Open: " + i));
    }
    
    @Test
    public void udpScan() {
        ThreadPoolScanner poolScanner = new UDPScanner(target);
        PortScanner portScanner = (PortScanner) poolScanner;
        
        IntStream.of(poolScanner.scanPorts(0, finish))
                .forEach(i -> logger.info("Port Open: " + i));
    }
}
