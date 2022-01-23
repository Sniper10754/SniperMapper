package org.snipermapper.event;

/**
 * The type Scan event.
 */
public abstract class ScanEvent {
    private int error;
    
    /**
     * Gets error.
     *
     * @return the error
     */
    public int getError() {
        return error;
    }
    
    /**
     * Sets error.
     *
     * @param error the error
     */
    protected void setError(int error) {
        this.error = error;
    }
}
