package com.mlsdev.mcdonalds.presenter.impl;

import com.mlsdev.mcdonalds.presenter.InstructionPresenter;
import com.mlsdev.mcdonalds.ui.activity.InstructionActivity;

/**
 * Created by roma on 29.05.15.
 */
public class InstructionPresenterImpl implements InstructionPresenter {

    private InstructionActivity view;

    public InstructionPresenterImpl(InstructionActivity view) {
        this.view = view;
    }

    @Override
    public void showQrScannerActivity() {
        view.showQrScannerActivity();
    }
}
