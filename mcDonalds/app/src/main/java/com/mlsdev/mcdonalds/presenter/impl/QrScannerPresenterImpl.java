package com.mlsdev.mcdonalds.presenter.impl;

import com.google.zxing.Result;
import com.mlsdev.mcdonalds.presenter.QrScannerPresenter;
import com.mlsdev.mcdonalds.ui.activity.QrScannerActivity;

/**
 * Created by roma on 29.05.15.
 */
public class QrScannerPresenterImpl implements QrScannerPresenter {

    private QrScannerActivity view;

    public QrScannerPresenterImpl(QrScannerActivity view) {
        this.view = view;
    }

    @Override
    public void onSuccess(Result result) {
        view.showDiscountActivity();
    }
}
