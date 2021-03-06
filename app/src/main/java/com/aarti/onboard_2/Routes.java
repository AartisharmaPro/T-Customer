package com.aarti.onboard_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Routes extends AppCompatActivity {
    CardView train,bus,metro,taxi;
    ImageView scanner;
    private int CAMERA_PERMISSION_CODE=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routes);

        train=findViewById(R.id.train);
        bus=findViewById(R.id.bus);
        metro=findViewById(R.id.metro);
        taxi=findViewById(R.id.taxi);

        train.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Routes.this,Trains.class);
                startActivity(i);
            }
        });
        bus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Routes.this,Bus.class);
                startActivity(i);
            }
        });
        metro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Routes.this,Metro.class);
                startActivity(i);
            }
        });
        taxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Routes.this,Cabs.class);
                startActivity(i);
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        startActivity(new Intent(getApplicationContext(), Home.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.nav_routes:

                        return true;

                    case R.id.nav_wallet:
                        startActivity(new Intent(getApplicationContext(), Wallet.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.nav_profile:
                        startActivity(new Intent(getApplicationContext(), Profile.class));
                        overridePendingTransition(0, 0);
                        return true;

                }
                return false;
            }
        });
        scanner=findViewById(R.id.scanner);
        scanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

     /* Intent i=new Intent();

      i.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
      startActivity(i);*/
                if(ContextCompat.checkSelfPermission(Routes.this, Manifest.permission.CAMERA)== PackageManager.PERMISSION_GRANTED)
                {
                    // Toast.makeText(Home.this,"Permission already granted",Toast.LENGTH_SHORT).show();
                    Intent i=new Intent();
                    i.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivity(i);
                }
                else
                {
                    Request();
                }
            }
        });
    } private void Request()
    {
        if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.CAMERA))
        {
            new AlertDialog.Builder(this).setTitle("Camera Permission Needed").setMessage("You need to allow Trango to access your camera")
                    .setPositiveButton("Allow", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which)

                        {
                            ActivityCompat.requestPermissions(Routes.this,new String[]{Manifest.permission.CAMERA},CAMERA_PERMISSION_CODE);
                        }
                    }).setNegativeButton("Deny", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            }).create().show();

        }
        else
        {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CAMERA},CAMERA_PERMISSION_CODE);
        }



    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        if(requestCode==CAMERA_PERMISSION_CODE)
        {
            if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED)
            {
                Toast.makeText(Routes.this,"Permission Granted",Toast.LENGTH_SHORT).show();

            }
            else
            {
                Toast.makeText(Routes.this,"Permission Denied",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
