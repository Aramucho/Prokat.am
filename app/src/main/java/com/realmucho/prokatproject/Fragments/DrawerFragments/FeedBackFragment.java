package com.realmucho.prokatproject.Fragments.DrawerFragments;


import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.SlidingPaneLayout;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.realmucho.prokatproject.Activities.MainActivity;
import com.realmucho.prokatproject.R;


public class FeedBackFragment extends Fragment implements View.OnClickListener {

    private BottomSheetBehavior bottomSheetBehavior;
    private Button submit;
    private ImageButton mapwatch, fb, vk, ok, yotube, insta, skype, share;
    private MapView mMapView;
    private GoogleMap googleMap;
    private TextView link;
    private SlidingPaneLayout paneLayout;
    private RelativeLayout feedlayout;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.feedback_fragment, container, false);
        NestedScrollView bottomsheet = (NestedScrollView) view.findViewById(R.id.bottom_sheet);
        bottomSheetBehavior = BottomSheetBehavior.from(bottomsheet);
        mMapView = (MapView) view.findViewById(R.id.map_view);
        mMapView.onCreate(savedInstanceState);
        mMapView.onResume();
        paneLayout = (SlidingPaneLayout) view.findViewById(R.id.feed_sliding_pane);
        feedlayout = (RelativeLayout) view.findViewById(R.id.feed_layout);
        feedlayout.setOnClickListener(this);
        share = (ImageButton) view.findViewById(R.id.share);
        mapwatch = (ImageButton) view.findViewById(R.id.map_watch);
        fb = (ImageButton) view.findViewById(R.id.fb_icon);
        vk = (ImageButton) view.findViewById(R.id.vk_icon);
        yotube = (ImageButton) view.findViewById(R.id.youtube_icon);
        ok = (ImageButton) view.findViewById(R.id.ok_icon);
        insta = (ImageButton) view.findViewById(R.id.insta_icon);
        skype = (ImageButton) view.findViewById(R.id.skype_icon);
        submit = (Button) view.findViewById(R.id.submitbutton);
        link = (TextView) view.findViewById(R.id.link);
        link.setOnClickListener(this);
        mapwatch.setOnClickListener(this);
        submit.setOnClickListener(this);
        fb.setOnClickListener(this);
        share.setOnClickListener(this);
        vk.setOnClickListener(this);
        yotube.setOnClickListener(this);
        ok.setOnClickListener(this);
        insta.setOnClickListener(this);
        skype.setOnClickListener(this);

        bottominit();
        mapinit();


        return view;
    }


    @Override
    public void onClick(View v) {
        Intent intent;
        int id = v.getId();

        switch (id) {
            case R.id.map_watch:
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                submit.setVisibility(View.GONE);

                break;
            case R.id.submitbutton:

                break;
            case R.id.link:
                String email = "mailto:" + getActivity().getResources().getString(R.string.info_prokat_am);
                intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse(email));
                startActivity(intent);
                break;

            case R.id.fb_icon:
                try {
                    intent = new Intent(Intent.ACTION_VIEW);
                    String facebookUrl = getFacebookPageURL(getContext());
                    intent.setData(Uri.parse(facebookUrl));
                    startActivity(intent);
                } catch (Exception e) {
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/Prakatam"));
                    startActivity(intent);

                }

                break;
            case R.id.vk_icon:
                urlIntent("https://vk.com/id250024962");
                break;
            case R.id.youtube_icon:
                urlIntent("https://www.youtube.com/channel/UCXUA6v5FfPSFo596ReOqqRw");
                break;
            case R.id.ok_icon:
                urlIntent("https://ok.ru/profile/562361186775");

                break;
            case R.id.insta_icon:
                urlIntent("https://www.instagram.com/prokat.am/");

                break;
            case R.id.skype_icon:
                urlIntent("https://www.skype.com");
                break;
            case R.id.share:
                paneLayout.openPane();
                break;

            case R.id.feed_layout:
                if (paneLayout.isOpen()) {
                    paneLayout.closePane();
                }


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
                    submit.setVisibility(View.VISIBLE);
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
        getView().setFocusableInTouchMode(true);
        getView().requestFocus();
        getView().setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK){

                    if(paneLayout.isOpen())
                    {
                        paneLayout.closePane();

                    }
                    else if(bottomSheetBehavior.getState() != BottomSheetBehavior.STATE_HIDDEN){

                       submit.setVisibility(View.VISIBLE);

                    }


                    else if(!paneLayout.isOpen()&&bottomSheetBehavior.getPeekHeight()==0){
                        Intent intent=new Intent(getContext(), MainActivity.class);
                        startActivity(intent);
                    }

                    return true;

                }

                return false;
            }
        });
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

    private String getFacebookPageURL(Context context) {
        String url = "https://www.facebook.com/Prakatam";
        PackageManager packageManager = context.getPackageManager();
        try {
            int versionCode = packageManager.getPackageInfo("com.facebook.katana", 0).versionCode;
            if (versionCode >= 3002850) {
                return "fb://facewebmodal/f?href=" + url;
            } else {
                return "fb://page/" + "Prakat.am";
            }
        } catch (PackageManager.NameNotFoundException e) {
            return url;
        }
    }

    private void urlIntent(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }



}