package com.mlsdev.mcdonalds.presenter.impl;

import com.mlsdev.mcdonalds.cache.provider.impl.TimerCacheImpl;
import com.mlsdev.mcdonalds.model.Timer;
import com.mlsdev.mcdonalds.model.TimerConst;
import com.mlsdev.mcdonalds.presenter.DiscountPresenter;
import com.mlsdev.mcdonalds.ui.activity.DiscountActivity;
import com.mlsdev.mcdonalds.util.TimerUtilImpl;

import java.util.concurrent.TimeUnit;

/**
 * Created by roma on 29.05.15.
 */
public class DiscountPresenterImpl implements DiscountPresenter, TimerUtilImpl.TimerListener {

    private DiscountActivity view;
    private TimerCacheImpl timerCache;
    private TimerUtilImpl timerUtil;
    private Timer timer;

    public DiscountPresenterImpl(DiscountActivity view) {
        this.view = view;
        timerCache = new TimerCacheImpl(view);
        timerUtil = new TimerUtilImpl();
        timerUtil.setTimerListener(this);
    }

    @Override
    public void onDiscountTimerStart() {
        if (timerCache.isCached()) {
            Timer cachedTimer = timerCache.getTimer();
            long difference = System.currentTimeMillis() - cachedTimer.getStartedInCurrentMillis();
            if (difference < TimerConst.DEFAULT_DISCOUNT_TIME) {
                timer = cachedTimer;
                timerUtil.onTimerStart(TimerConst.DEFAULT_DISCOUNT_TIME - difference);
                initProgressAnimation(TimerConst.DEFAULT_DISCOUNT_TIME - difference);
            } else {
                timerCache.clear();
                onTimerFinished();
            }
        } else {
            timer = new Timer();
            timer.setStartedInCurrentMillis(System.currentTimeMillis());
            timerUtil.onTimerStart(TimerConst.DEFAULT_DISCOUNT_TIME);
            initProgressAnimation(TimerConst.DEFAULT_DISCOUNT_TIME);
        }
    }

    @Override
    public void onDiscountTimerClose() {
        if (timer != null) {
            long timeStill = TimerConst.DEFAULT_DISCOUNT_TIME - (System.currentTimeMillis() - timer.getStartedInCurrentMillis());
            timer.setTimeStill(timeStill);
            timer.setStoppedInCurrentMillis(System.currentTimeMillis());
            timerCache.saveTimer(timer);
            timerUtil.cancel();
        }
    }

    @Override
    public void onTimerFinished() {
        timer = null;
        timerCache.clear();
        view.showDiscountExpired();
    }

    @Override
    public void onTimerTick(long millisUntilFinished) {

        long min = TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished);
        long sec = TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) -
                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished));

        String minutes = String.valueOf(min), seconds = String.valueOf(sec);
        if (sec < 10) seconds = "0" + sec;
        if (min < 10) minutes = "0" + min;
        String currentTime = minutes + ":" + seconds;

        updateTimerTextView(currentTime);
    }

    @Override
    public void onLastTick() {
        updateTimerTextView("00:00");
    }

    @Override
    public void updateTimerTextView(String time) {
        view.updateTimer(time);
    }

    @Override
    public void initProgressAnimation(long millisInFuture) {
        float startAngle = (millisInFuture * 360) / TimerConst.DEFAULT_DISCOUNT_TIME;
        view.initProgressAnimation(millisInFuture, startAngle);
    }
}
