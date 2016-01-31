package com.example.javier.geohelp.Activities.Components;

import android.content.Context;
import android.support.design.widget.TextInputLayout;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by javier on 23/01/2016.
 */
public class EmailEditText extends TextInputLayout{
    EditText editText;
    private String errorMessage;
    private boolean validationResult = true;
    private boolean required = false;


    public void init(){
        editText= getEditText();
    }

    public EmailEditText(Context context) {
        super(context);
    }

    public EmailEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public boolean validateSilently() {

        String email = editText.getText().toString();
        if (("").equals(email) && !required){
            return true;
        }
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public boolean validateContentSilently() {

        String email = editText.getText().toString();
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
