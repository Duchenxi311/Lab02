package com.qin.imagezxlingdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Report extends AppCompatActivity {

    TextView txt_rep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        txt_rep=findViewById(R.id.txt_rep);
        txt_rep.setText(Show_json.save_data+"\n"+TimeActivity.time1);
    }
}
