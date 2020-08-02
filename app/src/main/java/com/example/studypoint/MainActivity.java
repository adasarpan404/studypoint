package com.example.studypoint;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.Toolbar;
import static android.Manifest.permission.INTERNET;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {
    public static final int RequestPermissionCode=1;
    public static int splash_time_out=4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        try {
            ImageView imageView=(ImageView)findViewById(R.id.imageView);
        }
        catch(ClassCastException e)
        {
            e.printStackTrace();
        }
    }

    public void tutorial_point(View v){
        if(CheckPermission()) {
            Intent intent = new Intent(this, TutorialPoint.class);
            startActivity(intent);
        }
    }
    public void web_dev(View v){
        if(CheckPermission()) {
            Intent intent = new Intent(this, w3school.class);
            startActivity(intent);
        }
    }
    public void geeks(View v){
        if(CheckPermission()) {
            Intent intent = new Intent(this, GeeksforGeeks.class);
            startActivity(intent);
        }
    }
    public void WEBed(View v){
        if(CheckPermission()) {
            Intent intent = new Intent(this, webeditor.class);
            startActivity(intent);
        }
    }public void python(View v){
        if(CheckPermission()) {
            Intent intent = new Intent(this, pythonInterpreter.class);
            startActivity(intent);
        }
    }public void compilers(View v){
        if(CheckPermission()) {
            Intent intent = new Intent(this, compilers.class);
            startActivity(intent);
        }
    }
    public void develop(View v){
        Intent intent= new Intent(this, developer.class);
        startActivity(intent);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case RequestPermissionCode:
                if(grantResults.length>0){
                    boolean internetpermission=grantResults[0]== PackageManager.PERMISSION_GRANTED;
                    if(internetpermission)
                    {
                        Toast.makeText(this,"Permission is granted",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(this,"Permission is granted",Toast.LENGTH_SHORT).show();
                    }

                }
        }
    }
    public boolean CheckPermission(){
        int result= ContextCompat.checkSelfPermission(getApplicationContext(), INTERNET);
        return result==PackageManager.PERMISSION_GRANTED;
    }

}
