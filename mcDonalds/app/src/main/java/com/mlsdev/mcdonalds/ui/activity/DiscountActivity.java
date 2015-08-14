package com.mlsdev.mcdonalds.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.mlsdev.mcdonalds.R;
import com.mlsdev.mcdonalds.presenter.DiscountPresenter;
import com.mlsdev.mcdonalds.presenter.impl.DiscountPresenterImpl;
import com.mlsdev.mcdonalds.ui.activity.widget.ProgressTimer;

/**
 * Created by roma on 27.05.15.
 */
public class DiscountActivity extends BaseActivity {

    private DiscountPresenter presenter;

    private TextView tvTimer;
    private ProgressTimer progressTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initComponents();
        presenter = new DiscountPresenterImpl(this);

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_discount;
    }

    public void initComponents() {
        tvTimer = (TextView) findViewById(R.id.tv_timer);
        progressTimer = (ProgressTimer) findViewById(R.id.progressTimer);
        progressTimer.setCircleColor(getResources().getColor(R.color.red));
    }

    public void updateTimer(String time) {
        tvTimer.setText(time);
    }

    public void initProgressAnimation(long durationInMillis, float startAngle) {
        progressTimer.setProgress(startAngle);
        progressTimer.setDuration(durationInMillis);
        progressTimer.startAnimation();
    }

    public void showDiscountExpired() {
        startActivity(new Intent(getApplicationContext(), DiscountExpiredActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onDiscountTimerStart();
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.onDiscountTimerClose();
    }
}
