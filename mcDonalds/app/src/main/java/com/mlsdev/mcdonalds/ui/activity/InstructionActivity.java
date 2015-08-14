package com.mlsdev.mcdonalds.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.mlsdev.mcdonalds.R;
import com.mlsdev.mcdonalds.presenter.InstructionPresenter;
import com.mlsdev.mcdonalds.presenter.impl.InstructionPresenterImpl;

/**
 * Created by roma on 27.05.15.
 */
public class InstructionActivity extends BaseActivity implements View.OnClickListener {

    private InstructionPresenter presenter;
    private RelativeLayout rlScanQrCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new InstructionPresenterImpl(this);
        rlScanQrCode = (RelativeLayout) findViewById(R.id.rl_scan_qr_code);
        rlScanQrCode.setOnClickListener(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_instruction;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_scan_qr_code:
                presenter.showQrScannerActivity();
                break;
        }
    }

    public void showQrScannerActivity() {
        startActivity(new Intent(getApplicationContext(), QrScannerActivity.class));
    }

}
