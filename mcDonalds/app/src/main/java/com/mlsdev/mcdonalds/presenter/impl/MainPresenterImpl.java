package com.mlsdev.mcdonalds.presenter.impl;

import com.mlsdev.mcdonalds.cache.provider.impl.TimerCacheImpl;
import com.mlsdev.mcdonalds.presenter.MainPresenter;
import com.mlsdev.mcdonalds.ui.activity.MainActivity;

/**
 * Created by roma on 02.06.15.
 */
public class MainPresenterImpl implements MainPresenter {

    private MainActivity view;
    private TimerCacheImpl timerCache;

    public MainPresenterImpl(MainActivity view) {
        this.view = view;
        timerCache = new TimerCacheImpl(view);
    }

    public void isTimerPresent() {
        if (timerCache.isCached()) {
            view.showDiscountActivity();
        } else {
            view.showInstructionActivity();
        }
    }
}
