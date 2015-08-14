package com.mlsdev.mcdonalds.util;

/**
 * Created by roma on 02.06.15.
 */
public interface TimerUtil {

    void onTimerStart(long millisInFuture);

    void cancel();

    interface TimerListener {

        void onTimerTick(long millisUntilFinished);

        void onTimerFinished();

        void onLastTick();

    }
}
