package com.aarti.onboard_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Html;

import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;


public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private ViewPager mSlideViewPager;

    private LinearLayout mDotLayout;

    private TextView[] mDots;
    private DrawerLayout drawerLayout;
    private int CAMERA_PERMISSION_CODE=1;


    private FeaturesAdapter featuresAdapter;


    private int mCurrentPage;
    private ActionBarDrawerToggle mToggle;
    ImageView navigation;
    NavigationView navigationView;
    ImageView scanner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.side_nav_view);
        drawerLayout=findViewById(R.id.drawer);
        mToggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.Open,R.string.Close);
        drawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigation=findViewById(R.id.navigation);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_home:

                        return true;
                    case R.id.nav_routes:
                        startActivity(new Intent(getApplicationContext(), Routes.class));
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
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener((NavigationView.OnNavigationItemSelectedListener) Home.this);

        Button routes=findViewById(R.id.get_routes);
        routes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Home.this,GetRoutes.class);
                startActivity(i);
            }
        });


        mSlideViewPager=(ViewPager) findViewById(R.id.v_p);
        mDotLayout=(LinearLayout) findViewById(R.id.dots);


        featuresAdapter=new FeaturesAdapter(this);


        mSlideViewPager.setAdapter(featuresAdapter);


        addDotsIndicator(0);

        mSlideViewPager.addOnPageChangeListener(viewListener);



   navigation.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           drawerLayout.openDrawer(GravityCompat.START);
       }
   });

scanner=findViewById(R.id.scanner);
scanner.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

     /* Intent i=new Intent();

      i.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
      startActivity(i);*/
     if(ContextCompat.checkSelfPermission(Home.this,Manifest.permission.CAMERA)==PackageManager.PERMISSION_GRANTED)
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
ActivityCompat.requestPermissions(Home.this,new String[]{Manifest.permission.CAMERA},CAMERA_PERMISSION_CODE);
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
                        Toast.makeText(Home.this,"Permission Granted",Toast.LENGTH_SHORT).show();

           }
           else
           {
               Toast.makeText(Home.this,"Permission Denied",Toast.LENGTH_SHORT).show();
           }
       }
    }

    public void addDotsIndicator(int position)
    {
        mDots = new TextView[5];
        mDotLayout.removeAllViews();

        for (int i=0;i<mDots.length;i++){
            mDots[i]=new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorAccent));

            mDotLayout.addView(mDots[i]);

        }

        if (mDots.length>0){
            mDots[position].setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i ){
            addDotsIndicator(i);

            mCurrentPage=i;

            if(i==0)
            {

            }
            else if(i==mDots.length-1)
            {

            }
            else {

            }
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(mToggle.onOptionsItemSelected(item))
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        //to prevent current item select over and over
        if (item.isChecked()){
            drawerLayout.closeDrawer(GravityCompat.START);
            return false;
        }

        if (id == R.id.side_home)
        {

            startActivity(new Intent(getApplicationContext(), Home.class));
        } else if (id == R.id.side_notification) {
            startActivity(new Intent(getApplicationContext(), Home.class));
        } else if (id == R.id.side_wallet) {
            startActivity(new Intent(getApplicationContext(),Statements.class));
        } else if (id == R.id.side_logout) {
            startActivity(new Intent(getApplicationContext(), Login.class));
        } else if (id == R.id.side_sos) {
            startActivity(new Intent(getApplicationContext(), SOS.class));
        } else if (id == R.id.side_profile) {
            startActivity(new Intent(getApplicationContext(), Profile.class));
        }else if (id == R.id.side_routes) {
            startActivity(new Intent(getApplicationContext(), tripCount.class));
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}

