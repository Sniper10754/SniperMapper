package org.snipermapper.event;

/**
 * The type Scan progress event.
 */
public class ScanProgressEvent extends ScanEvent {
    private int progress;
    
    /**
     * Gets progress.
     *
     * @return the progress
     */
    public int getProgress() {
        return progress;
    }
    
    /**
     * Sets progress.
     *
     * @param progress the progress
     */
    protected void setProgress(int progress) {
        this.progress = progress;
    }
}
