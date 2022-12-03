package com.example.hantaton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

public class Map extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        SubsamplingScaleImageView scaleImageView=findViewById(R.id.zoompic);
        scaleImageView.setImage(ImageSource.resource(R.drawable.logo));
        int x=9;
    }
}