package org.snipermapper;

import java.util.Collection;

/**
 * The interface Thread pool scanner.
 */
public interface ThreadPoolScanner {
    /**
     * Scan ports int [ ].
     *
     * @param ports the ports
     * @return the int [ ]
     */
    int[] scanPorts(Collection<Integer> ports);
    
    /**
     * Scan ports int [ ].
     *
     * @param start  the start
     * @param finish the finish
     * @return the int [ ]
     */
    int[] scanPorts(int start, int finish);
}
