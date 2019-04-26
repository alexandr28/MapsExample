package com.acampdev.maps;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        assert mapFragment != null;
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-8.103552749231703, -79.00718650346364);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney")
                //.icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_4))
                //.icon(bitmapDescriptorFromVector(this,R.drawable.ic_upman))
                .icon(bitmapDescriptorFromVector(this,R.drawable.ic_placeholder))
        );
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
    private BitmapDescriptor bitmapDescriptorFromVector(Context context, int vectorResourceId){
        Drawable vectorDrawable = ContextCompat.getDrawable(context,vectorResourceId);
        assert vectorDrawable != null;
        vectorDrawable.setBounds(0,0,vectorDrawable.getIntrinsicWidth(),vectorDrawable.getIntrinsicHeight());
        Bitmap bitmap= Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(),vectorDrawable.getIntrinsicHeight(),Bitmap.Config.ARGB_8888);
        Canvas canvas= new Canvas(bitmap);
        vectorDrawable.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }
    /*
    private BitmapDescriptor bitmapDescriptorFromVector(Context context, @DrawableRes int vectorDrawableResourceId){
        Drawable background = ContextCompat.getDrawable(context,R.drawable.alert_yellow);
        assert background != null;
        background.setBounds(0,0,
                background.getIntrinsicWidth(),
                background.getIntrinsicHeight()
        );
        Drawable vectorDrawable = ContextCompat.getDrawable(context,vectorDrawableResourceId);
        assert vectorDrawable != null;
        vectorDrawable.setBounds(40,20,
                vectorDrawable.getIntrinsicWidth()+40,
                vectorDrawable.getIntrinsicHeight()+20
        );
        Bitmap bitmap = Bitmap.createBitmap(
                background.getIntrinsicWidth(),
                background.getIntrinsicHeight(),
                Bitmap.Config.ARGB_8888
        );
        Canvas canvas= new Canvas(bitmap);
        background.draw(canvas);
        vectorDrawable.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }
    */


}
