package com.example.javier.geohelp.Activities.Components;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by javier on 24/01/2016.
 */
public class GeoHelpTextView  extends TextView {

    private boolean removeTopSpace;
    private boolean removeBottomSpace;

    public GeoHelpTextView(Context context) {
        super(context);
        applyAttributes(context, null);
    }

    public GeoHelpTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        applyAttributes(context, attrs);
    }

    public GeoHelpTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        applyAttributes(context, attrs);
    }

    private void applyAttributes(Context context, AttributeSet attrs) {
    }

    public void onResolveMixedFonts(){}


    @Override
    protected void onDraw(Canvas canvas) {
        if (removeTopSpace){
            float offset = getTextSize() - getLineHeight();
            canvas.translate(0, +offset);
//            int yOffset = getHeight() - getBaseline();
//            canvas.translate(0, -yOffset);
        }else if (removeBottomSpace){
            float offset = getTextSize() - getLineHeight();
            canvas.translate(0, -offset);
//            int yOffset = getHeight() - getBaseline() - getPaddingBottom();
//            canvas.translate(0, yOffset);
        }
        super.onDraw(canvas);
    }


}
