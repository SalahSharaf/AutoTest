package com.example.android.androidtutorial2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class login extends AppCompatActivity {

    public EditText email;
    public EditText password;
    public String emailString, passwordString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setTitle("Log In");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
        return true;
    }

    public void goToSignUp(View view) {
        Intent intent = new Intent(this, signup.class);
        startActivity(intent);
    }

    public void submitLogIn(View view) {
        email = findViewById(R.id.loginemail);
        password = findViewById(R.id.loginpassword);
        emailString = email.getText().toString();
        passwordString = password.getText().toString();
        for (User user : MainActivity.users) {
            if (user.getEmail().equals(emailString) && user.getPassowrd().equals(passwordString)) {
                MainActivity.isAuthenticated = true;
                MainActivity.user = user;
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            }
        }
    }

    @Override
    public void onBackPressed() {

    }
}