package com.aarti.onboard_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import java.util.List;


public class GetRoutes  extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap map;
    SelectRoutesAdapter adapter;
    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_routess);
        BottomSheetBehavior<View> bottomSheetBehavior = BottomSheetBehavior.from(findViewById(R.id.bottomSheet));

        bottomSheetBehavior.setFitToContents(false);
        bottomSheetBehavior.setPeekHeight(dp2px(150));
        bottomSheetBehavior.setExpandedOffset(dp2px(150));
        bottomSheetBehavior.setHalfExpandedRatio(0.5f);

        startAdapter();
        back=findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(GetRoutes.this,Home.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map=googleMap;

        SupportMapFragment mapFragment=(SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        LatLng Delhi=new LatLng(28.567858, 77.178556);
        googleMap.addMarker(new MarkerOptions().position(Delhi).title("New Delhi"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(Delhi));

    }


    private void startAdapter()
    {
        RecyclerView pl = (RecyclerView) findViewById(R.id.pl);
        pl.setLayoutManager(new LinearLayoutManager(this));
        adapter = new SelectRoutesAdapter(GetRoutes.this);
        pl.setAdapter(adapter);

    }
    private int dp2px (int dip) {

        Resources r = getResources();
        float px = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                dip,
                r.getDisplayMetrics()
        );
        return (int) px;
    }

}
