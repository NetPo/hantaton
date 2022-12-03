package com.example.hantaton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StorageReference storageReference;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        storageReference = FirebaseStorage.getInstance().getReference();

        //Recycler view + ArrayList
        RecyclerView schemasRV = findViewById(R.id.idRVCourse);
        ArrayList<warn_schemas> warnSchemasArrayList = new ArrayList<warn_schemas>();
        warnSchemasArrayList.add(new warn_schemas("КУСТ-102 ЗСМ", "ВЫКЛЮЧАТЕЛИ В-35 Т1 И В-35 Т3 ЗАПИТАНЫ ОТ \n" +
                "ЛР-35 К-5-1", R.drawable.cust1));



        rv_adapter rv_adapter = new rv_adapter(warnSchemasArrayList, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        schemasRV.setAdapter(rv_adapter);
        schemasRV.setLayoutManager(linearLayoutManager);
    }
}