package org.snipermapper.event;

public class ScanProgressEvent extends ScanEvent {
    private int progress;
    
    public int getProgress() {
        return progress;
    }
    
    protected void setProgress(int progress) {
        this.progress = progress;
    }
}
