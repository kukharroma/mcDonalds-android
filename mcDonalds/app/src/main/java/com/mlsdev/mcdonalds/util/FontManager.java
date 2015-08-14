package com.mlsdev.mcdonalds.util;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by roma on 03.06.15.
 */
public class FontManager {

    private static Typeface typeface;

    public static Typeface getTypeface(Context ctx, String fontName) {
        if (typeface == null) {
            typeface = Typeface.createFromAsset(ctx.getAssets(), fontName);
        }
        return typeface;
    }
}
