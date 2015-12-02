package com.example.amasio.testapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class JobActivity extends AppCompatActivity {

    Job job;
    TextView jobTitle;
    TextView description;
    TextView preReq;
    TextView contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        job = (Job) intent.getSerializableExtra("Job");

        jobTitle = (TextView)findViewById(R.id.jobTitle);
        jobTitle.setText(job.getTitle());
        description = (TextView)findViewById(R.id.description);
        description.setText(job.getDescription());
        preReq = (TextView)findViewById(R.id.preReq);
        preReq.setText(job.getPrerequisites());
        contact = (TextView)findViewById(R.id.contact);
        contact.setText(job.getContact());


    }

    public void onApplyClicked(View v){

        Toast.makeText(JobActivity.this, "Email Sent", Toast.LENGTH_LONG).show();
    }

}
