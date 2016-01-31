package com.example.javier.geohelp.Activities.Components;

import android.content.Context;
import android.support.design.widget.TextInputLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by javier on 23/01/2016.
 */
public class EmailEditText extends TextInputLayout{

    private static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";


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
                if (validateEmail(editText.getText().toString().trim())||editText.getText().toString().trim().equals("")){
                    setErrorEnabled(false);
                }else {
                    setError("El email es incorrecto");
                    setErrorEnabled(true);
                }
            }
        });
    }

    public EmailEditText(Context context) {
        super(context);
    }

    public EmailEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    public static boolean validateEmail(String email) {

        Pattern pattern = Pattern.compile(PATTERN_EMAIL);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
