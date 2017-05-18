package com.realmucho.prokatproject.Fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.realmucho.prokatproject.R;


public class FeedBackFragment extends Fragment implements View.OnClickListener {

    private BottomSheetBehavior bottomSheetBehavior;
    private Button submit;
    private ImageButton mapwatch;
    private MapView mMapView;
    private GoogleMap googleMap;
    private TextView link;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.feedback_fragment, container, false);
        View bottomsheet = view.findViewById(R.id.bottom_sheet);
        bottomSheetBehavior = BottomSheetBehavior.from(bottomsheet);
        mMapView = (MapView) view.findViewById(R.id.map_view);
        mMapView.onCreate(savedInstanceState);
        mMapView.onResume();
        mapwatch = (ImageButton) view.findViewById(R.id.map_watch);
        submit = (Button) view.findViewById(R.id.submitbutton);
        link = (TextView) view.findViewById(R.id.link);
        link.setOnClickListener(this);
        mapwatch.setOnClickListener(this);
        submit.setOnClickListener(this);
        bottominit();
        mapinit();


        return view;
    }


    @Override
    public void onClick(View v) {

        int id = v.getId();

        switch (id) {
            case R.id.map_watch:

                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                break;
            case R.id.submitbutton:

                break;
            case R.id.link:
                String email = "mailto:"+getActivity().getResources().getString(R.string.info_prokat_am);
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse(email));
                startActivity(intent);


        }


    }

    private void mapinit() {


        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }
        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mMap) {
                googleMap = mMap;

                googleMap.setMyLocationEnabled(true);

                LatLng location = new LatLng(40.18659663201023, 44.5089211251659);

                googleMap.addMarker(new MarkerOptions().position(location));

                CameraPosition cameraPosition = new CameraPosition.Builder().target(location).zoom(17).build();
                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

            }
        });
    }

    private void bottominit() {
        bottomSheetBehavior.setPeekHeight(0);


        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if (newState == BottomSheetBehavior.STATE_COLLAPSED) {
                    bottomSheetBehavior.setPeekHeight(0);
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }


}
