package org.snipermapper.event;

/**
 * The interface Scan listener.
 */
public interface ScanListener {
    /**
     * On progress.
     *
     * @param event the event
     */
    void onProgress(ScanProgressEvent event);
}
