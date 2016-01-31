package com.example.javier.geohelp.Activities.Components;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

import com.example.javier.geohelp.R;

/**
 * Created by raquel on 31/01/2016.
 */
public class MenuTextView extends TextView {
    public  MenuTextView(Context context) {
        this(context, null);
    }

    public MenuTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MenuTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        if (isInEditMode())
            return;

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.FontText);

        if (ta != null) {
            String fontAsset = ta.getString(R.styleable.FontText_typefaceAsset);

            if (fontAsset != null && !fontAsset.isEmpty()) {
                Typeface tf = Typeface.createFromAsset(getResources().getAssets(), fontAsset);
                int style = Typeface.NORMAL;
                float size = getTextSize();

                if (getTypeface() != null)
                    style = getTypeface().getStyle();

                if (tf != null) {
                    setTypeface(tf, style);
                    int flags = getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG
                            | Paint.ANTI_ALIAS_FLAG;
                    setPaintFlags(flags);
                }
                else
                    Log.d("FontText", String.format("Could not create a font from asset: %s", fontAsset));
            }
        }
    }
}