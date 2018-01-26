package com.example.android.androidtutorial2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class signup extends AppCompatActivity {

    public EditText getEmail;
    public EditText getPassword;
    public EditText getName;
    public String sname;
    public String spassword;
    public String semail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getSupportActionBar().setTitle("Sign Up");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initializeEditors();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }

    public void goToLogIn(View view) {
        Intent intent = new Intent(this, login.class);
        startActivity(intent);
    }

    public void submitSignUp(View view) {
        sname = getName.getText().toString();
        spassword = getPassword.getText().toString();
        semail = getEmail.getText().toString();
        boolean isExisted = false;
        for (User user : MainActivity.users) {
            if (user.getEmail().equals(semail)) {
                isExisted = true;
            }
        }
        if (isEmailValid(semail) && isExisted == false) {
            if (sname.length() > 3) {
                if (isValidPassword(spassword) && spassword.length() >= 7) {
                    MainActivity.users.add(new User(sname, spassword, semail, false));
                    MainActivity.user = new User(sname, spassword, semail, false);
                    MainActivity.isAuthenticated = true;
                    Intent intent = new Intent(this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "password must be at least 7 characters and alphanumeric containing at least one symbol", Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(this, "Name must be 3 Characters at least", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(this, "this Email is not Valid or Exists,try to use another one ", Toast.LENGTH_LONG).show();
        }
    }

    public boolean isEmailValid(String email) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean isValidPassword(String password) {

        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getBaseContext(), MainActivity.class);
        startActivity(intent);
    }
    private boolean initializeEditors(){
        getEmail = findViewById(R.id.signupemail);
        getPassword = findViewById(R.id.signuppassword);
        getName = findViewById(R.id.signupname);
        int true1,true2,true3;
        getEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.length()>1){

                }
            }
        });
        getPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        return true;
    }
}
