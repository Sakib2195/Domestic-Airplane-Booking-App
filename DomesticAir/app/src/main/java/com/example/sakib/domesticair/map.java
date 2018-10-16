package com.example.sakib.domesticair;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import static android.graphics.Color.rgb;

public class map extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    public void changeType(View view) {


        if (mMap.getMapType() == GoogleMap.MAP_TYPE_NORMAL) {

            mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

        } else
            mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(23.850374, 90.402256), 6.00f));

        // Add a marker in Sydney and move the camera
        LatLng DAC = new LatLng(23.850374, 90.402256);
        mMap.addMarker(new MarkerOptions().position(DAC).title("Hazrat Shahjalal International Airport (DAC)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(DAC));

        LatLng BZL = new LatLng(22.803944, 90.300856);
        mMap.addMarker(new MarkerOptions().position(BZL).title("Barisal Airport (BZL)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(BZL));

        LatLng JSR = new LatLng(23.188516, 89.161487);
        mMap.addMarker(new MarkerOptions().position(JSR).title("Jessore Airport (JSR)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(JSR));


        LatLng SPD = new LatLng(25.767399, 88.907787);
        mMap.addMarker(new MarkerOptions().position(SPD).title("Saidpur Airport (SPD)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(SPD));


        LatLng RJH = new LatLng(24.443754, 88.615973);
        mMap.addMarker(new MarkerOptions().position(RJH).title("Shah Makhdum Airport (RJH)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(RJH));

        LatLng cox = new LatLng(21.457071, 91.965409);
        mMap.addMarker(new MarkerOptions().position(cox).title("Cox's Bazar Airport"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(cox));




        LatLng ZYL = new LatLng(24.968892, 91.870016);
        mMap.addMarker(new MarkerOptions().position(ZYL).title("Osmani International Airport (ZYL)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ZYL));


        LatLng CGP = new LatLng(22.253330, 91.812803);
        mMap.addMarker(new MarkerOptions().position(CGP).title("Shah Amanat International Airport (CGP)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(CGP));






        Polyline line = mMap.addPolyline(new PolylineOptions()
                .add(DAC, BZL)
                .width(6)
                .color(Color.GREEN));

        Polyline line2 = mMap.addPolyline(new PolylineOptions()
                .add(DAC, JSR)
                .width(6)
                .color(Color.BLUE));
        Polyline line3= mMap.addPolyline(new PolylineOptions()
                .add(DAC, SPD)
                .width(6)
                .color(Color.GRAY));

        Polyline line4= mMap.addPolyline(new PolylineOptions()
                .add(DAC, RJH)
                .width(6)
                .color(Color.BLACK));

        Polyline line5= mMap.addPolyline(new PolylineOptions()
                .add(DAC, cox)
                .width(6)
                .color(rgb(8,22,18)));

        Polyline line6= mMap.addPolyline(new PolylineOptions()
                .add(DAC,ZYL)
                .width(6)
                .color(rgb(128, 0, 0)));

        Polyline line7= mMap.addPolyline(new PolylineOptions()
                .add(DAC, CGP)
                .width(6)
                .color(rgb(7,69,102)));






    }
}
