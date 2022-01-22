package org.snipermapper.event;

public abstract class ScanEvent {
    private int error;
    
    public int getError() {
        return error;
    }
    
    protected void setError(int error) {
        this.error = error;
    }
}
