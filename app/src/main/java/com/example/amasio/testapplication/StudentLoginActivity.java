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

public class StudentLoginActivity extends AppCompatActivity {

    DatabaseController studentDb;
    EditText email;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setTitle("Student Login");

        studentDb = new DatabaseController(this);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
    }

    public void onLoginClicked(View V){

        String emailVal = email.getText().toString();
        String passwordVal = password.getText().toString();

        Cursor res = studentDb.login(emailVal, passwordVal);
        if(res.getCount() == 0){
            showMessage("ERROR", "NOTHING FOUND!");
            return;
        }

        String emailDb = res.getString(0);
        String passwordDb = res.getString(1);

        if(passwordVal == passwordDb){
            Intent intent = new Intent();
            startActivity(intent);
        }

//            buffer.append("ID: "+res.getString(0)+ "\n");
//            buffer.append("BANNER ID: "+res.getString(1)+ "\n");
//            buffer.append("NAME: "+res.getString(2)+" "+ res.getString(3)+"\n");
//            buffer.append("E-MAIL: "+res.getString(4)+ "\n");
//            buffer.append("GPA: "+res.getString(6)+ "\n");
//            buffer.append("CLASSIFICATION: "+res.getString(7)+ "\n");
//            buffer.append("MAJOR: "+res.getString(8)+ "\n\n");
        }
        //showMessage("Data", buffer.toString());


    public void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

}
