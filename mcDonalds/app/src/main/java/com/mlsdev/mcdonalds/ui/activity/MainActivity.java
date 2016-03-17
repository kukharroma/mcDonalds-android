package com.mlsdev.mcdonalds.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.crashlytics.android.Crashlytics;
import com.mlsdev.mcdonalds.presenter.MainPresenter;
import com.mlsdev.mcdonalds.presenter.impl.MainPresenterImpl;
import io.fabric.sdk.android.Fabric;

/**
 * Created by roma on 02.06.15.
 */
public class MainActivity extends Activity{

    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        presenter = new MainPresenterImpl(this);
        presenter.isTimerPresent();
    }

    public void showDiscountActivity(){
        startActivity(new Intent(getApplicationContext(), DiscountActivity.class));
    }

    public void showInstructionActivity(){
        startActivity(new Intent(getApplicationContext(), InstructionActivity.class));
    }
}
