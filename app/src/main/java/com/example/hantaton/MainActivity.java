package com.example.hantaton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageView imageButton;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Recycler view + ArrayList
        RecyclerView schemasRV = findViewById(R.id.idRVCourse);
        ArrayList<warn_schemas> warnSchemasArrayList = new ArrayList<warn_schemas>();
        warnSchemasArrayList.add(new warn_schemas("КУСТ-102 ЗСМ", "ВЫКЛЮЧАТЕЛИ В-35 Т1 И В-35 Т3 ЗАПИТАНЫ ОТ \n" +
                "ЛР-35 К-5-1", R.drawable.cust1));
        warnSchemasArrayList.add(new warn_schemas("КУСТ-9 ЗСМ", "ПС35/0,4кВ №109", R.drawable.kust91));



        rv_adapter rv_adapter = new rv_adapter(warnSchemasArrayList, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        schemasRV.setAdapter(rv_adapter);
        schemasRV.setLayoutManager(linearLayoutManager);

        imageButton = findViewById(R.id.infoButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendmail();
            }


        });
        button=findViewById(R.id.buttoncamera);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator intentIntegrator = new IntentIntegrator(
                        MainActivity.this
                );
                intentIntegrator.setBeepEnabled(false);
                intentIntegrator.setOrientationLocked(true);
                intentIntegrator.setCaptureActivity(Capture.class);
                intentIntegrator.initiateScan();
            }
        });


    }

    private void sendmail() {
        String num = "84959999999";
        Intent call = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+num));
        startActivity(call);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult intentResult=IntentIntegrator.parseActivityResult(
                requestCode,resultCode,data
        );
        if (intentResult.getContents()!=  null){
            Integer a=new Integer(intentResult.getContents());
            if (a==0){
                Intent intent =  new Intent(this, MapActivity.class);
                intent.putExtra("Номер карты", a);
                startActivity(intent);
                finish();
            } else if (a==1){
                Intent intent =  new Intent(this, MapActivity.class);
                intent.putExtra("Номер карты", a);
                startActivity(intent);
                finish();
            }

        }else {
            Toast.makeText(getApplicationContext(), "Ошибка входа",Toast.LENGTH_LONG).show();
        }

    }
}