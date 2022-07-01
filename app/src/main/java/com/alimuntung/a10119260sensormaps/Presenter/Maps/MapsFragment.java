package com.alimuntung.a10119260sensormaps.Presenter.Maps;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.app.AlertDialog;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alimuntung.a10119260sensormaps.Model.RestaurantMarker;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.alimuntung.a10119260sensormaps.R;

import java.util.ArrayList;
import java.util.List;

public class MapsFragment extends Fragment {
    private List<RestaurantMarker> restaurantMarkerList= new ArrayList<RestaurantMarker>();

    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        @Override
        public void onMapReady(GoogleMap googleMap) {
            restaurantMarkerList.add(new RestaurantMarker(-6.931916789683658, 107.62516272779035,"Baso Akung"));
            restaurantMarkerList.add(new RestaurantMarker(-6.931765021303783, 107.62469063320991,"Bandung Cheesecuit Lodaya"));
            restaurantMarkerList.add(new RestaurantMarker(-6.934462231054307, 107.62553287262733,"Gokana Ramen"));
            restaurantMarkerList.add(new RestaurantMarker(-6.93392438790206, 107.6237089705169,"Nasi Tim Ayam Sizi"));
            restaurantMarkerList.add(new RestaurantMarker(-6.9350373497852615, 107.62436879392745,"Rumah Makan Mergosari"));
            LatLng bandung = new LatLng(-6.9301087,107.617305);
            //loop marker

            for (int i=0; i<restaurantMarkerList.size();i++){
                googleMap.addMarker(new MarkerOptions().position(
                        new LatLng(
                                restaurantMarkerList.get(i).getLat(),
                                restaurantMarkerList.get(i).getLng()
                        )).title(restaurantMarkerList.get(i).getTitle()));
            }
          //  googleMap.addMarker(new MarkerOptions().position(bandung).title("Marker in Bandung"));
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(bandung,15f));
            //googleMap.moveCamera(CameraUpdateFactory.);
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }


}