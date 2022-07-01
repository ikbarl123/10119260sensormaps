package com.alimuntung.a10119260sensormaps.Presenter.Maps;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alimuntung.a10119260sensormaps.Model.RestaurantMarker;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.alimuntung.a10119260sensormaps.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;
import java.util.List;

public class MapsFragment extends Fragment {
    private FusedLocationProviderClient mFusedclient;
    private SupportMapFragment mapFragment;
    Location lokasi;
    private List<RestaurantMarker> restaurantMarkerList= new ArrayList<RestaurantMarker>();

    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        @Override
        public void onMapReady(GoogleMap googleMap) {
            restaurantMarkerList.add(new RestaurantMarker(-6.931916789683658, 107.62516272779035,"Baso Akung"));
            restaurantMarkerList.add(new RestaurantMarker(-6.931765021303783, 107.62469063320991,"Bandung Cheesecuit Lodaya"));
            restaurantMarkerList.add(new RestaurantMarker(-6.934462231054307, 107.62553287262733,"Gokana Ramen"));
            restaurantMarkerList.add(new RestaurantMarker(-6.93392438790206, 107.6237089705169,"Nasi Tim Ayam Sizi"));
            restaurantMarkerList.add(new RestaurantMarker(-6.9350373497852615, 107.62436879392745,"Rumah Makan Mergosari"));
            //LatLng bandung = new LatLng(-6.9301087,107.617305);
            //loop marker
            LatLng curcloc = new LatLng(lokasi.getLatitude(),lokasi.getLongitude());

            for (int i=0; i<restaurantMarkerList.size();i++){
                googleMap.addMarker(new MarkerOptions().position(
                        new LatLng(
                                restaurantMarkerList.get(i).getLat(),
                                restaurantMarkerList.get(i).getLng()
                        )).title(restaurantMarkerList.get(i).getTitle()));
            }
           googleMap.addMarker(new MarkerOptions().position(curcloc).title("Lokasi Anda Sekarang"));
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(curcloc,15f));

        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
      View rootView = inflater.inflate(R.layout.fragment_maps, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mFusedclient = LocationServices.getFusedLocationProviderClient(getActivity());
        mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            getLocation();
//            mapFragment.getMapAsync(callback);
        }


    }
// Ikbar Laudza Alviansyah
// IF-7
// 10119260

    private void getLocation() {
        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);
        }
            Task<Location> task = mFusedclient.getLastLocation();
            task.addOnSuccessListener(new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location locationnow) {
                    if(locationnow != null){
                        lokasi = locationnow;
                        mapFragment.getMapAsync(callback);
                    }
                }
            });

    }
}

