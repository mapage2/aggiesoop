package com.example.amasio.testapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
    //add email EditText
    EditText gpaText;
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
        gpaText = (EditText) findViewById(R.id.gpa);
        majorSpinner = (Spinner) findViewById(R.id.major);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.college_majors, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        majorSpinner.setAdapter(adapter);
    }

    public void onRegisterClicked(View v){

        int banner = Integer.parseInt(bannerIdText.getText().toString());
        double gpa = Double.parseDouble(gpaText.getText().toString());
        String majorValue = majorSpinner.getSelectedItem().toString();

        studentDb = new DatabaseController(this);
        boolean inserted = studentDb.insertStudent(banner, firstNameText.getText().toString(),
                lastNameText.getText().toString(), gpa, majorValue);

        if(inserted){
            Toast.makeText(SignupActivity.this, "Data Inserted", Toast.LENGTH_LONG ).show();
        }else {
            Toast.makeText(SignupActivity.this, "Data not Inserted", Toast.LENGTH_LONG).show();
        }
    }

}
