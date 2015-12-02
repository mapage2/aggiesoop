package com.example.amasio.testapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

    DatabaseController studentDb;
    Student s;
    EditText bannerIdText;
    EditText firstNameText;
    EditText lastNameText;
    EditText emailText;
    EditText passwordText;
    EditText gpaText;
    Spinner classificationSpinner;
    Spinner majorSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Sign Up");
        setSupportActionBar(toolbar);

        bannerIdText = (EditText) findViewById(R.id.bannerId);
        firstNameText = (EditText) findViewById(R.id.firstName);
        lastNameText = (EditText) findViewById(R.id.lastName);
        emailText = (EditText) findViewById(R.id.email);
        passwordText = (EditText) findViewById(R.id.password);
        gpaText = (EditText) findViewById(R.id.gpa);
        classificationSpinner = (Spinner) findViewById(R.id.classification);
        majorSpinner = (Spinner) findViewById(R.id.major);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> majorAdapter = ArrayAdapter.createFromResource(this,
                R.array.college_majors, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        majorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        majorSpinner.setAdapter(majorAdapter);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> classAdapter = ArrayAdapter.createFromResource(this,
                R.array.classification, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        classAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        classificationSpinner.setAdapter(classAdapter);
    }

    public void onRegisterClicked(View v){

        int banner = Integer.parseInt(bannerIdText.getText().toString());
        String firstName = firstNameText.getText().toString();
        String lastName = lastNameText.getText().toString();
        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();
        double gpa = Double.parseDouble(gpaText.getText().toString());
        String majorValue = majorSpinner.getSelectedItem().toString();
        String classValue = classificationSpinner.getSelectedItem().toString();


        s = new Student(banner, firstName, lastName, email, password, gpa, majorValue, classValue);

        studentDb = new DatabaseController(this);
        boolean inserted = studentDb.insertStudent(s);

        if(inserted){
            Toast.makeText(SignupActivity.this, "Data Inserted", Toast.LENGTH_LONG ).show();
            Intent intent  = new Intent("com.example.amasio.testapplication.MainPageActivity");
            startActivity(intent);
        }else {
            Toast.makeText(SignupActivity.this, "Data not Inserted", Toast.LENGTH_LONG).show();
        }
    }

}
/** FIND A WAY TO INCREMENT */