package org.snipermapper;

import java.util.Collection;

public interface ThreadPoolScanner {
    int[] scanPorts(Collection<Integer> ports);
    int[] scanPorts(int start, int finish);
}
