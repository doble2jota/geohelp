package com.example.javier.geohelp.Activities.Components;

/**
 * Created by javier on 31/01/2016.
 */


import android.content.Context;
import android.support.design.widget.TextInputLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;

/**
 * Created by javier on 23/01/2016.
 */
public class PasswordEditText extends TextInputLayout {


    EditText editText;
    private String errorMessage;
    private boolean validationResult = true;
    private boolean required = false;

    private Boolean valid;


    public void init(){
        editText= getEditText();
        editText.setOnFocusChangeListener(new OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (editText.getText().toString().trim().length()>=6){
                    setErrorEnabled(false);
                }else {
                    setError("La longitud mínima es de 6 caracteres");
                    setErrorEnabled(true);
                }
            }
        });
    }

    public PasswordEditText(Context context) {
        super(context);
    }

    public PasswordEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

}

