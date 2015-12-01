package com.example.amasio.testapplication;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainPageActivity extends AppCompatActivity {

    DatabaseController studentDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        studentDb = new DatabaseController(this);

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
        if (id == R.id.action_settings) {
            return true;
        }
        if(id == R.id.action_profile){
            Intent intent = new Intent("");
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

    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

}
