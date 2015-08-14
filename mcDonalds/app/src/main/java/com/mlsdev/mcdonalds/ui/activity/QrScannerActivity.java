package com.mlsdev.mcdonalds.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.zxing.Result;
import com.mlsdev.mcdonalds.presenter.QrScannerPresenter;
import com.mlsdev.mcdonalds.presenter.impl.QrScannerPresenterImpl;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

/**
 * Created by roma on 27.05.15.
 */
public class QrScannerActivity extends Activity implements ZXingScannerView.ResultHandler {

    private ZXingScannerView mScannerView;
    private QrScannerPresenter presenter;

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        presenter = new QrScannerPresenterImpl(this);
        mScannerView = new ZXingScannerView(this);
        setContentView(mScannerView);
    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();
    }

    @Override
    public void handleResult(Result result) {
        presenter.onSuccess(result);
    }

    public void showDiscountActivity(){
        startActivity(new Intent(getApplicationContext(), DiscountActivity.class));
    }
}
