package com.mlsdev.mcdonalds.ui.activity.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;

import com.mlsdev.mcdonalds.R;
import com.mlsdev.mcdonalds.util.FontManager;

/**
 * Created by roma on 03.06.15.
 */
public class McDTextView extends TextView {

    public McDTextView(Context context) {
        this(context, null);
    }

    public McDTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public McDTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initFont(context, attrs);
    }

    private void initFont(Context ctx, AttributeSet attrs) {
        TypedArray typedArray = ctx.obtainStyledAttributes(attrs, R.styleable.Font);
        String fontName = typedArray.getString(R.styleable.Font_font_name);
        setTypeface(FontManager.getTypeface(ctx, fontName));
    }
}
