package com.example.javier.geohelp.Activities.Components;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.util.AttributeSet;

/**
 * Created by javier on 13/02/2016.
 */
//// TODO: 13/02/2016 revisar 
public class GeoHelpTabLayout extends TabLayout {

    public GeoHelpTabLayout(Context context) {
        super(context);
    }

    public GeoHelpTabLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public GeoHelpTabLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init(){

    }


    //// TODO: 13/02/2016   
   /* private void setTextFont(Context context, AttributeSet attrs){
        if (isInEditMode())
            return;

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.FontText);
        if (ta != null) {
            String fontAsset = ta.getString(R.styleable.FontText_typefaceAsset);
            if (fontAsset != null && !fontAsset.isEmpty()) {
                Typeface tf = Typeface.createFromAsset(getResources().getAssets(), fontAsset);
                int style = Typeface.NORMAL;
                    
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
    }*/


}
