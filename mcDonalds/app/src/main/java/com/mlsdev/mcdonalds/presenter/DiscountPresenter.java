package com.mlsdev.mcdonalds.presenter;

/**
 * Created by roma on 29.05.15.
 */
public interface DiscountPresenter {

    void onDiscountTimerStart();

    void onDiscountTimerClose();

    void updateTimerTextView(String time);

    void initProgressAnimation(long millisInFuture);
}
