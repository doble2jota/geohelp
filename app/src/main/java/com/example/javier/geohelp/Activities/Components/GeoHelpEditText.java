package com.example.javier.geohelp.Activities.Components;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.design.widget.TextInputLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.javier.geohelp.Activities.Utils.GeoHelpApplication;
import com.example.javier.geohelp.R;

import java.lang.reflect.Field;

/**
 * Created by raquel on 13/02/2016.
 */
public class GeoHelpEditText  extends  TextInputLayout{


        EditText editText;
        private String errorMessage;
        private boolean validationResult = true;
        private boolean required = false;

        private Boolean valid;

        public static void setCursorDrawableColor(EditText editText, int color) {
            try {
                Field fCursorDrawableRes = TextView.class.getDeclaredField("mCursorDrawableRes");
                fCursorDrawableRes.setAccessible(true);
                int mCursorDrawableRes = fCursorDrawableRes.getInt(editText);
                Field fEditor = TextView.class.getDeclaredField("mEditor");
                fEditor.setAccessible(true);
                Object editor = fEditor.get(editText);
                Class<?> clazz = editor.getClass();
                Field fCursorDrawable = clazz.getDeclaredField("mCursorDrawable");
                fCursorDrawable.setAccessible(true);
                Drawable[] drawables = new Drawable[2];
                if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1){
                    drawables[0] = getDrawable(editText, mCursorDrawableRes);
                    drawables[1] = getDrawable(editText, mCursorDrawableRes);
                }else{
                    drawables[0] = getDrawableDeprecated(editText, mCursorDrawableRes);
                    drawables[1] = getDrawableDeprecated(editText, mCursorDrawableRes);
                }
                drawables[0].setColorFilter(color, PorterDuff.Mode.SRC_IN);
                drawables[1].setColorFilter(color, PorterDuff.Mode.SRC_IN);
                fCursorDrawable.set(editor, drawables);
            } catch (final Throwable ignored) {
            }
        }


        @TargetApi(Build.VERSION_CODES.LOLLIPOP_MR1)
        private static Drawable getDrawable(EditText editText, int mCursorDrawableRes){
            return editText.getContext().getResources().getDrawable(mCursorDrawableRes, GeoHelpApplication.get().getTheme());
        }
        private static Drawable getDrawableDeprecated(EditText editText, int mCursorDrawableRes){
            return editText.getContext().getResources().getDrawable(mCursorDrawableRes);
        }



        public void init(){

            editText= getEditText();
            setCursorDrawableColor(editText,getResources().getColor(R.color.GeoHelp_primary_dark));
            //   editText.setHintTextColor(R.style.NormalLabelTextInputLayout);
            if(Build.VERSION.SDK_INT==Build.VERSION_CODES.LOLLIPOP ) {
                editText.setBackground(getResources().getDrawable(R.drawable.edittext_material_design));
            }

            //setBackground(getResources().getColorStateList(getResources().getColor(R.color.white),);
            setHintTextAppearance(R.style.NormalLabelTextInputLayout);
        }

        public GeoHelpEditText(Context context) {
            super(context);
        }

        public GeoHelpEditText(Context context, AttributeSet attrs) {
            super(context, attrs);
        }




}
