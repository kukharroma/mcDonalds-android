package com.mlsdev.mcdonalds.presenter.impl;

import com.mlsdev.mcdonalds.presenter.DiscountExpiredPresenter;
import com.mlsdev.mcdonalds.ui.activity.DiscountExpiredActivity;

/**
 * Created by roma on 29.05.15.
 */
public class DiscountExpiredPresenterImpl implements DiscountExpiredPresenter {

    private DiscountExpiredActivity view;

    public DiscountExpiredPresenterImpl(DiscountExpiredActivity view) {
        this.view = view;
    }

    public void showQrScannerActivity(){
        view.showQrScannerActivity();
    }
}
