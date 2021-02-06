package com.cs463.lhrexplorer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Scanner;

public class Description extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        String tag = getIntent().getStringExtra("location_name");

        FragmentDescription descFrag = (FragmentDescription) getSupportFragmentManager().findFragmentById(R.id.fragDescription);

        descFrag.updateGUI(tag);



    }

}
