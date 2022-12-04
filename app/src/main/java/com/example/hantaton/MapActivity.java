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
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {

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
        } else if (num.equals("1")){
            pics.add(new Picts(R.drawable.kust91));
            pics.add(new Picts(R.drawable.kust92));
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
        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync((OnMapReadyCallback) this);
    }

    //map
    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(new LatLng(55.752666, 37.622702))
                .zoom(10)
                .build();
        CameraUpdate cameraUpdate = CameraUpdateFactory.newCameraPosition(cameraPosition);
        googleMap.animateCamera(cameraUpdate);

        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) ==
                PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) ==
                        PackageManager.PERMISSION_GRANTED) {

            googleMap.setMyLocationEnabled(true);
            googleMap.getUiSettings().setMyLocationButtonEnabled(true);
        } else {
            ActivityCompat.requestPermissions(this, new String[] {
                            Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_COARSE_LOCATION },
                    TAG_CODE_PERMISSION_LOCATION);
        }

        googleMap.addMarker(new MarkerOptions().position(new LatLng(55.523742, 37.517838)).title("Куст-123"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(55.704943, 37.641285)).title("Куст-228"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(55.663697, 37.511188)).title("Дерево-000"));

    }



}