package com.mlsdev.mcdonalds.util;

import android.os.CountDownTimer;

import com.mlsdev.mcdonalds.model.TimerConst;

/**
 * Created by roma on 02.06.15.
 */
public class TimerUtilImpl implements TimerUtil {

    private TimerListener timerListener;
    private CountDownTimer countDownTimer;

    @Override
    public void onTimerStart(long millisInFuture) {
        countDownTimer = new CountDownTimer(millisInFuture, TimerConst.DEFAULT_DISCOUNT_TICK) {
            @Override
            public void onTick(long millisUntilFinished) {
                timerListener.onTimerTick(millisUntilFinished);
            }

            @Override
            public void onFinish() {
                timerListener.onLastTick();
                timerListener.onTimerFinished();
            }
        };
        countDownTimer.start();
    }

    public void cancel(){
        countDownTimer.cancel();
    }

    public void setTimerListener(TimerListener timerListener) {
        this.timerListener = timerListener;
    }

}
