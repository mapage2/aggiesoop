package com.example.amasio.testapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {

    Student student;
    TextView nameText;
    TextView emailText;
    TextView gpaText;
    TextView classText;
    TextView majorText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Profile");
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        student = (Student) intent.getSerializableExtra("Student");

        nameText = (TextView)findViewById(R.id.nameText);
        nameText.setText(student.getFirstName() +" "+student.getLastName());
        emailText = (TextView)findViewById(R.id.emailText);
        emailText.setText(student.getEmail());
        gpaText = (TextView)findViewById(R.id.gpaText);
        String gpaVal = String.valueOf(student.getGpa());
        gpaText.setText(gpaVal);
        classText = (TextView)findViewById(R.id.classText);
        classText.setText(student.getClassification());
        majorText = (TextView)findViewById(R.id.majorText);
        majorText.setText(student.getMajor());
    }

    public void onEditClicked(View v){
        Toast.makeText(ProfileActivity.this, "Functionality Coming Soon!", Toast.LENGTH_SHORT).show();
    }

}
