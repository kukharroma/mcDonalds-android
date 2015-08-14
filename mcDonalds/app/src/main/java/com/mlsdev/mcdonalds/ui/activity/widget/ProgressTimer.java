package com.mlsdev.mcdonalds.ui.activity.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;

import com.mlsdev.mcdonalds.R;

/**
 * Created by roma on 04.06.15.
 */
public class ProgressTimer extends View {

    private Paint paint;
    private ProgressAnimation progressAnimation;

    private RectF mOval;
    private Rect mTmpOval;

    private float currentAngle = 270.0f;
    private int strokeWidth;
    private int strokeColor;

    public ProgressTimer(Context context) {
        this(context, null);
    }

    public ProgressTimer(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ProgressTimer(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mOval = new RectF();
        mTmpOval = new Rect();
        strokeWidth = getResources().getDimensionPixelSize(R.dimen.progress_timer_stroke_width);
        strokeColor = getResources().getColor(R.color.red);
        progressAnimation = new ProgressAnimation();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.getClipBounds(mTmpOval);

        mTmpOval.left = mTmpOval.left + strokeWidth / 2;
        mTmpOval.top = mTmpOval.top + strokeWidth / 2;
        mTmpOval.right = mTmpOval.right - strokeWidth / 2;
        mTmpOval.bottom = mTmpOval.bottom - strokeWidth / 2;

        mOval.set(mTmpOval);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(strokeWidth);
        paint.setColor(strokeColor);
        canvas.drawArc(mOval, 270, currentAngle, false, paint);
    }

    public void setProgress(float startAngle, float stopAngle) {
        progressAnimation.setProgress(startAngle, stopAngle);
        progressAnimation.setIsProgressSet(true);
    }

    public void setProgress(float startAngle){
        progressAnimation.setProgress(startAngle, 0);
        progressAnimation.setIsProgressSet(true);
    }

    public void setDuration(long duration) {
        progressAnimation.setDuration(duration);
        progressAnimation.setIsDurationSet(true);
    }

    public void setCircleColor(int color) {
        strokeColor = color;
        progressAnimation.setIsColorSet(true);
    }

    public void startAnimation() {
        if (!progressAnimation.isColorSet())
            throw new RuntimeException(ProgressAnimationError.SPECIFY_COLOR_ERROR);
        if (!progressAnimation.isProgressSet())
            throw new RuntimeException(ProgressAnimationError.SPECIFY_PROGRESS_ERROR);
        if (!progressAnimation.isDurationSet())
            throw new RuntimeException(ProgressAnimationError.SPECIFY_DURATION_ERROR);
        startAnimation(progressAnimation);
    }

    private class ProgressAnimation extends Animation {

        private float startAngle = 360f;
        private float stopAngle = 0f;
        private boolean isDurationSet = false;
        private boolean isColorSet = false;
        private boolean isProgressSet = false;

        public ProgressAnimation() {
            setInterpolator(new LinearInterpolator());
        }

        public void setProgress(float startAngle, float stopAngle) {
            this.startAngle = startAngle;
            this.stopAngle = stopAngle;
        }

        @Override
        protected void applyTransformation(float interpolatedTime, Transformation t) {
            float currAngle = startAngle + ((stopAngle - startAngle) * interpolatedTime);
            ProgressTimer.this.currentAngle = -currAngle;
            invalidate();
        }

        public boolean isDurationSet() {
            return isDurationSet;
        }

        public void setIsDurationSet(boolean isDurationSet) {
            this.isDurationSet = isDurationSet;
        }

        public boolean isColorSet() {
            return isColorSet;
        }

        public void setIsColorSet(boolean isColorSet) {
            this.isColorSet = isColorSet;
        }

        public boolean isProgressSet() {
            return isProgressSet;
        }

        public void setIsProgressSet(boolean isProgressSet) {
            this.isProgressSet = isProgressSet;
        }

    }

    interface ProgressAnimationError {
        String SPECIFY_COLOR_ERROR = "you need specify color";
        String SPECIFY_DURATION_ERROR = "you need specify duration";
        String SPECIFY_PROGRESS_ERROR = "you need specify progress";
    }
}
