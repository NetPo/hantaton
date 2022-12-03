package com.example.hantaton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapActivity extends AppCompatActivity {

    int TAG_CODE_PERMISSION_LOCATION;

    ArrayList<Picts> pics = new ArrayList<>();

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //from intent
        Bundle arguments = getIntent().getExtras();
        String num = arguments.get("Номер карты").toString();

        if (num.equals("0")){
            pics.add(new Picts(R.drawable.cust1));
            pics.add(new Picts(R.drawable.cust2));
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);


        //RecyclerView
        recyclerView = findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);
        hor_rv_adapter hor_rv_adapter = new hor_rv_adapter(pics, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(hor_rv_adapter);


        //fragment

    }

    //map

}