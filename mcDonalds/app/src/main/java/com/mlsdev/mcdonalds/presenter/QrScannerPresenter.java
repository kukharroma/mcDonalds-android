package com.mlsdev.mcdonalds.presenter;

import com.google.zxing.Result;
import com.mlsdev.mcdonalds.ui.activity.QrScannerActivity;

/**
 * Created by roma on 29.05.15.
 */
public interface QrScannerPresenter {

    void onSuccess(Result result);

}
