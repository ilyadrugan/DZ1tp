package com.example.dz1tp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;


public class MainActivity extends AppCompatActivity {
    FragmentRec f;
    FragmentTransaction tr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportFragmentManager().findFragmentById(R.id.container) == null) {
            f = new FragmentRec();
            tr = getSupportFragmentManager().beginTransaction();
            tr.add(R.id.container, f).commit();
        }
       }
}


