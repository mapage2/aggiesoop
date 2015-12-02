package com.example.amasio.testapplication;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainPageActivity extends AppCompatActivity {

    Job[] jobs = new Job[15];
    DatabaseController studentDb;
    Student student;
    RecyclerView rView;
    LinearLayoutManager layoutManager;
    CardAdapter adapter;
    Job j;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);


        studentDb = new DatabaseController(this);

        Intent intent = getIntent();
        student = (Student) intent.getSerializableExtra("Student");

        toolbar.setTitle("Welcome, " + student.getFirstName());
        setSupportActionBar(toolbar);
        createJobs();

        rView = (RecyclerView) findViewById(R.id.cardList);
        rView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rView.setLayoutManager(layoutManager);


        //ArrayList<Job> jobList =
        adapter = new CardAdapter(studentDb.getRelatedJobs(student.getMajor()));
        rView.setAdapter(adapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.mainpage_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            Toast.makeText(MainPageActivity.this, "Logout Successful", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(MainPageActivity.this, MainActivity.class);
            startActivity(intent);
        }
        if(id == R.id.action_profile){
//            Intent intent = new Intent("com.example.amasio.testapplication.ProfileActivity");
//            startActivity(intent);
            Intent intent = new Intent(MainPageActivity.this, ProfileActivity.class);
            intent.putExtra("Student", student);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    public void onViewClicked(View v){
        Cursor res = studentDb.getAllData();
        if(res.getCount() == 0){
            showMessage("ERROR", "NOTHING FOUND!");
            return;
        }
        StringBuffer buffer = new StringBuffer();
        while(res.moveToNext()){
            buffer.append("ID: "+res.getString(0)+ "\n");
            buffer.append("BANNER ID: "+res.getString(1)+ "\n");
            buffer.append("NAME: "+res.getString(2)+" "+ res.getString(3)+"\n");
            buffer.append("E-MAIL: "+res.getString(4)+ "\n");
            buffer.append("GPA: "+res.getString(6)+ "\n");
            buffer.append("CLASSIFICATION: "+res.getString(7)+ "\n");
            buffer.append("MAJOR: "+res.getString(8)+ "\n\n");
        }
        showMessage("Data", buffer.toString());
    }

//    public void onJobClicked(View v){
//        Cursor res = studentDb.getAllJobs();
//        if(res.getCount() == 0){
//            showMessage("ERROR", "NOTHING FOUND!");
//            return;
//        }
//        StringBuffer buffer = new StringBuffer();
//        while(res.moveToNext()){
//            buffer.append("TITLE: "+res.getString(1)+ "\n");
//            buffer.append("DESCRIPTION: "+res.getString(2)+ "\n");
//            buffer.append("PREREQUISITES: "+res.getString(3)+"\n");
//            buffer.append("MAJOR: "+res.getString(4)+ "\n");
//            buffer.append("LOCATION: "+res.getString(5)+ "\n");
//            buffer.append("CONTACT: "+res.getString(6)+ "\n\n");
//
//        }
//        showMessage("Data", buffer.toString());
//    }

    public void createJobs() {

        jobs[0] = new Job("Undergrad Research Assistant", "Here you will be researching how to analyze malware. You will need to put your critical thinking skills to the test.",
                "Comp 510", "Computer Science", "FIRC", "Khausik Roy kroy@ncat.edu");
        jobs[1] = new Job("Teacher Assistant", "This job entitles grading papers, being available for office hours/tutoring and helping out with labs when needed.",
                "GEEN 165", "Computer Science", " Graham 210 & Lab", "Kenneth Williams");
        jobs[2] = new Job("App Developer", "We are looking for an proficient developer in the Java/C#/Swift coding languages. Extensive apps for promotions" +
                "and marketing for our upcoming business is needed.", "Java/C# or Swift", "Computer Science", "Off Campus at the Forge", "Paul Hammond, President/CEO New Age Productions");
        jobs[3] = new Job("IT Manager", " This person will manage/monitor the IT of the individual networks within the school under professional supervision.",
                "Must have proficient understanding in network security/infrastructure.(COMP 476) Must understand IDS", "Computer Science", "McNair 207", "Professor Effort");
        jobs[4] = new Job("Website Developer", "We are looking for a student who is proficient in HTML/JavaScript/JQuery to help innovate and maintain the A&T Website" +
                "You may also be assigned the task of adding pages to the website/major specific site with upcoming news and announcements",
                "COMP 322/HTML/JQuery Experience", "Computer Science", "McNair 525", "Esterline");
        jobs[5] = new Job("Undergrad Research Assistant", "This research is funded by the Department of Defense to research the next wave of circuitry to increase computing speed",
                "Circuits 1&2/Critical Thinking and Analytical Skills", "Computer Engineering", "FIRC", "Dr. John Kelly jck@ncat.edu");
        jobs[6] = new Job("Teacher Assistant", "This job entitles grading papers, being available for office hours/tutoring and helping out with labs when needed.",
                "GEEN 165", "Computer Engineering", " Graham 210 & Lab", "Kenneth Williams");
        jobs[7] = new Job("Circuit Tutor", "Help tutor/teach other students circuits for many students need help with that subject.", "Circuits I&II w/ A- or Higher", "Computer Engineering",
                "McNair Hall TBD", "jck@ncat.edu");
        jobs[8] = new Job("Robotics Researcher", "Participate in research funded by the CIA to create the next wave of robots in Artificial Intelligence"
                , "Circuits/Python/C++/Java Knowledge", "Computer Engineering", "McNair Hall 5th Floor & FIRC Lab", "jck@ncat.edu |" + "gvdozier@ncat.edu");
        jobs[9] = new Job("A&T Campus ReDesign", "This is an innovation proposal to redesign the network infrastructure of A&T's internet/intranet access to improve wifi use and computing speed",
                "Network Security/Design Knowledge[7 layers]", "Computer Engineering", "McNair Hall", "Engineers Without Borders (ewb@ncat.edu)");
        jobs[10] = new Job("Power Save Innovation", "Analyze current circuit of either campus/community and propose solutions to save power/energy usage", "Circuit Knowledge/Powerplant Knowledge/Research Skills",
                "Electrical Engineering", "McNair Headquarters", "Engineers Without Borders (ewb@ncat.edu)");
        jobs[11] = new Job("Network/Power Maintenance", "Be on call for if something goes wrong with the power on campus or in a building. Help analyze the problem" +
                "and come up with a solution.", "Power/Circuit Knowledge", "Electrical Engineering", "McNair/Smith/Graham", "ewb@ncat.edu");
        jobs[12] = new Job("Robotics Researcher", "Participate in research funded by the CIA to create the next wave of robots in Artificial Intelligence", "Circuits/Python/C++/Java Knowledge", "Electrical Engineering",
                "McNair Hall 5th Floor & FIRC Lab", "jck@ncat.edu | gvdozier@ncat.edu");
        jobs[13] = new Job("Undergrad Research Assistant", "This research is funded by the Department of Defense to research the next wave of circuitry to increase computing speed",
                "Circuits 1&2/Critical Thinking and Analytical Skills", "Electrical Engineering", "FIRC", "Dr. John Kelly jck@ncat.edu");
        jobs[14] = new Job("Circuit Tutor", "Help tutor/teach other students circuits for many students need help with that subject.", "Circuits I&II w/ A- or Higher", "Electrical Engineering",
                "McNair Hall TBD", "jck@ncat.edu");

        for (int i = 0; i < jobs.length - 1; i++) {
//            boolean inserted = studentDb.insertJob(jobs[i]);
            studentDb.insertJob(jobs[i]);

//            if(inserted){
//                Toast.makeText(MainPageActivity.this, "Jobs Display", Toast.LENGTH_LONG ).show();
//
//            }else {
//                Toast.makeText(MainPageActivity.this, "Query Error", Toast.LENGTH_LONG).show();
//            }
        }
    }

    public void onJobCardClicked(View v){

        j = adapter.getJob();
        Intent intent = new Intent(MainPageActivity.this, JobActivity.class);
        intent.putExtra("Job",j);
        startActivity(intent);
//        Intent intent = new Intent(MainPageActivity.this, JobActivity.class);
//        v.getContext().startActivity(intent);
    }

    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

}
