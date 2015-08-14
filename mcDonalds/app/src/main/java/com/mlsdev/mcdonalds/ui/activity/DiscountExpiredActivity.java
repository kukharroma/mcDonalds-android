package com.mlsdev.mcdonalds.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.mlsdev.mcdonalds.R;
import com.mlsdev.mcdonalds.presenter.DiscountExpiredPresenter;
import com.mlsdev.mcdonalds.presenter.impl.DiscountExpiredPresenterImpl;

/**
 * Created by roma on 27.05.15.
 */
public class DiscountExpiredActivity extends BaseActivity implements View.OnClickListener {

    private DiscountExpiredPresenter presenter;
    private LinearLayout rlScanNewQrCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new DiscountExpiredPresenterImpl(this);
        rlScanNewQrCode = (LinearLayout) findViewById(R.id.rl_new_qr_code);
        rlScanNewQrCode.setOnClickListener(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_discount_expired;
    }

    public void showQrScannerActivity() {
        startActivity(new Intent(getApplicationContext(), QrScannerActivity.class));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_new_qr_code:
                presenter.showQrScannerActivity();
        }
    }
}
