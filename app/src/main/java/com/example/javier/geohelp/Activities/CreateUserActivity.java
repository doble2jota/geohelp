package com.example.javier.geohelp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.javier.geohelp.Activities.Components.EmailEditText;
import com.example.javier.geohelp.Activities.Components.PasswordEditText;
import com.example.javier.geohelp.Activities.Entities.UserEntity;
import com.example.javier.geohelp.Activities.Presenters.CreaterUserPresenter;
import com.example.javier.geohelp.Activities.Presenters.CreaterUserPresenterImpl;
import com.example.javier.geohelp.R;

/**
 * Created by javier on 31/01/2016.
 */
public class CreateUserActivity extends AbstractActivity<CreaterUserPresenter> implements LoginView,View.OnClickListener{

    private EmailEditText emailEditText;
    private PasswordEditText passwordEditText;
    private PasswordEditText confirmPasswordEditText;
    private EditText email;
    private EditText firstname;
    private EditText lastname;
    private EditText password;
    private EditText confirmPassword;
    private CreaterUserPresenterImpl createrUserPresenter;
    private Button confirmButton;
    UserEntity userEntity= new UserEntity();

    @Override
    protected CreaterUserPresenterImpl createPresenter() {
        this.createrUserPresenter = new CreaterUserPresenterImpl(this);
        return this.createrUserPresenter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_user_layout);

        email=(EditText)findViewById(R.id.email);
        firstname=(EditText)findViewById(R.id.firstname_create);
        lastname=(EditText)findViewById(R.id.lastname_create);
        password=(EditText)findViewById(R.id.pass_create);
        confirmPassword=(EditText)findViewById(R.id.confirm_pass_create);

        confirmButton= (Button) findViewById(R.id.confirm_data);
        confirmButton.setOnClickListener(this);

        confirmPasswordEditText= (PasswordEditText)findViewById(R.id.confirm_pass_textview);
        passwordEditText= (PasswordEditText)findViewById(R.id.pass_textview);
        emailEditText = (EmailEditText) findViewById(R.id.correo_parent_create);

        confirmPasswordEditText.init();
        passwordEditText.init();
        emailEditText.init();
    }

    @Override
    public void startActivy() {
        Intent intent = new Intent(this,HomeActivity.class);
        startActivity(intent);
    }

    @Override
    public void finishActivy() {
        finish();
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.confirm_data){
            if(validateEmpty()) {
                fillEntity();
                createrUserPresenter.createUser(userEntity);
            }

        }
    }

    private void fillEntity(){
        userEntity.setFirstName(firstname.getText().toString());
        userEntity.setLastName(lastname.getText().toString());
        userEntity.setPass(password.getText().toString());
        userEntity.setEmailUser(email.getText().toString());
        userEntity.setFirstName(firstname.getText().toString());
    }

    private boolean validateEmpty(){
        if (email.getText().toString().trim().isEmpty()||firstname.getText().toString().trim().isEmpty()||
                lastname.getText().toString().trim().isEmpty()||password.getText().toString().trim().isEmpty()||
                confirmPassword.getText().toString().trim().isEmpty()){
            Toast.makeText(getApplicationContext(),"Alguno de sus campos esta vacion",Toast.LENGTH_LONG).show();
            return false;
        }
        if(!confirmPassword.getText().toString().equals(password.getText().toString())&&
                confirmPassword.getText().toString().trim().length()>=6){
            Toast.makeText(getApplicationContext(),"Las contraseñas no coinciden",Toast.LENGTH_LONG).show();

            return false;
        }
        return true;
    }
}
