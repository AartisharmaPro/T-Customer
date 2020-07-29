package com.aarti.onboard_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
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

public class Bus extends AppCompatActivity {
    ImageView scanner;
    private int CAMERA_PERMISSION_CODE=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus);
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
                        startActivity(new Intent(getApplicationContext(),Routes.class));
                        overridePendingTransition(0, 0);
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
                if(ContextCompat.checkSelfPermission(Bus.this, Manifest.permission.CAMERA)== PackageManager.PERMISSION_GRANTED)
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
    }

    private void Request()
    {
        if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.CAMERA))
        {
            new AlertDialog.Builder(this).setTitle("Camera Permission Needed").setMessage("You need to allow Trango to access your camera")
                    .setPositiveButton("Allow", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which)

                        {
                            ActivityCompat.requestPermissions(Bus.this,new String[]{Manifest.permission.CAMERA},CAMERA_PERMISSION_CODE);
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
                Toast.makeText(Bus.this,"Permission Granted",Toast.LENGTH_SHORT).show();

            }
            else
            {
                Toast.makeText(Bus.this,"Permission Denied",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
