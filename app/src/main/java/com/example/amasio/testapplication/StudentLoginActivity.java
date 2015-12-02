package com.example.amasio.testapplication;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;

public class StudentLoginActivity extends AppCompatActivity {

    DatabaseController studentDb;
    EditText email;
    EditText password;
    Student s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Student Login");
        setSupportActionBar(toolbar);

        studentDb = new DatabaseController(this);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
    }

    public void onLoginClicked(View V){

        String emailVal = email.getText().toString();
        String passwordVal = password.getText().toString();


        String dbPassVal = studentDb.login(emailVal);

        String emailPassword = emailVal+ " "+dbPassVal;


        if(passwordVal.equals(dbPassVal)){

            s = studentDb.getStudent(emailVal);

//            Intent intent = new Intent("com.example.amasio.testapplication.MainPageActivity");
//            startActivity(intent);

            Intent intent = new Intent(StudentLoginActivity.this, MainPageActivity.class);
            intent.putExtra("Student",s);
            startActivity(intent);

            Toast.makeText(StudentLoginActivity.this, "Login Succesful",
                    Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(StudentLoginActivity.this, "Incorrect E-mail or Password",
                    Toast.LENGTH_LONG).show();
        }
    }

    public void onSignupClicked(View v){
        Intent intent = new Intent("com.example.amasio.testapplication.SignupActivity");
        startActivity(intent);
    }

    public void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

}
