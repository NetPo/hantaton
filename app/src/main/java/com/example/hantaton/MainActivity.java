package com.example.hantaton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView schemasRV = findViewById(R.id.idRVCourse);
        ArrayList<warn_schemas> warnSchemasArrayList = new ArrayList<warn_schemas>();


        rv_adapter rv_adapter = new rv_adapter(warnSchemasArrayList, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        schemasRV.setAdapter(rv_adapter);
        schemasRV.setLayoutManager(linearLayoutManager);
    }
}