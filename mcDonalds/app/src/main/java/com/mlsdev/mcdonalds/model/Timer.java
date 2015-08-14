package com.mlsdev.mcdonalds.model;

/**
 * Created by roma on 29.05.15.
 */
public class Timer {

    private long timeStill;

    private long startedInCurrentMillis;

    private long stoppedInCurrentMillis;

    public long getTimeStill() {
        return timeStill;
    }

    public void setTimeStill(long timeStill) {
        this.timeStill = timeStill;
    }

    public long getStoppedInCurrentMillis() {
        return stoppedInCurrentMillis;
    }

    public void setStoppedInCurrentMillis(long stoppedInCurrentMillis) {
        this.stoppedInCurrentMillis = stoppedInCurrentMillis;
    }

    public long getStartedInCurrentMillis() {
        return startedInCurrentMillis;
    }

    public void setStartedInCurrentMillis(long startedInCurrentMillis) {
        this.startedInCurrentMillis = startedInCurrentMillis;
    }
}
