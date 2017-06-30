package com.realmucho.prokatproject.fragments.drawer_fragments;


import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
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
import com.realmucho.prokatproject.activities.MainActivity;
import com.realmucho.prokatproject.R;


public class FeedBackFragment extends Fragment implements View.OnClickListener {

    private BottomSheetBehavior bottomSheetBehavior;
    private Button submit;
    private ImageButton mapwatch, fb, vk, ok, yotube, insta, skype, share;
    private MapView mMapView;
    private GoogleMap googleMap;
    private TextView link;
    private SlidingPaneLayout paneLayout;
    private RelativeLayout feedlayout,messageLayout;

    private NestedScrollView bottomsheet;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.feedback_fragment, container, false);
        init(view);
        setupClicks();
        bottomSheetBehavior = BottomSheetBehavior.from(bottomsheet);
        mMapView.onCreate(savedInstanceState != null ? savedInstanceState.getBundle("map") : savedInstanceState);
        bottomInit();
        mapInit();
        return view;
    }

    private void init(View view) {

        bottomsheet = (NestedScrollView) view.findViewById(R.id.bottom_sheet);
        mMapView = (MapView) view.findViewById(R.id.map_view);
        paneLayout = (SlidingPaneLayout) view.findViewById(R.id.feed_sliding_pane);
        feedlayout = (RelativeLayout) view.findViewById(R.id.feed_layout);
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
        messageLayout=(RelativeLayout)view.findViewById(R.id.map_permission_layout);

    }

    private void setupClicks() {
        feedlayout.setOnClickListener(this);
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
                getInstagramPageUrl("https://www.instagram.com/prokat.am/");
                break;
            case R.id.skype_icon:
                getSkypePageUrl(getContext(), "www.skype.com");
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

    private void mapInit() {


        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }
        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mMap) {
                if (ContextCompat.checkSelfPermission(getContext(),
                        Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    googleMap = mMap;

                    mMap.setMyLocationEnabled(true);

                    LatLng location = new LatLng(40.18659663201023, 44.5089211251659);

                    googleMap.addMarker(new MarkerOptions().position(location));

                    CameraPosition cameraPosition = new CameraPosition.Builder().target(location).zoom(17).build();

                    googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                }
                else{
                    mMapView.setVisibility(View.GONE);
                    messageLayout.setVisibility(View.VISIBLE);


                }



            }
        });
    }

    private void bottomInit() {
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

                if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK) {

                    if (paneLayout.isOpen()) {
                        paneLayout.closePane();

                    } else if (!bottomSheetBehavior.isHideable()) {
                        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                        submit.setVisibility(View.VISIBLE);

                    }

                    if (!paneLayout.isOpen() && bottomSheetBehavior.getState() == BottomSheetBehavior.STATE_COLLAPSED) {
                        Intent intent = new Intent(getContext(), MainActivity.class);
                        startActivity(intent);
                    }


                }

                return true;
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

    @Override
    public void onSaveInstanceState(Bundle outState) {
        Bundle mapViewstate = new Bundle(outState);
        mMapView.onSaveInstanceState(mapViewstate);
        outState.putBundle("map", mapViewstate);
        super.onSaveInstanceState(outState);
    }

    private void urlIntent(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

    private void getSkypePageUrl(Context myContext, String url) {

        if (isSkypeClientInstalled(myContext)) {
            Uri skypeUri = Uri.parse(url);
            Intent intent = new Intent(Intent.ACTION_VIEW, skypeUri);

            intent.setComponent(new ComponentName("com.skype.raider", "com.skype.raider.Main"));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);


            myContext.startActivity(intent);
        } else

            urlIntent("https://play.google.com/store/apps/details?id=com.skype.raider&hl=ru");

    }


    private boolean isSkypeClientInstalled(Context myContext) {
        PackageManager myPackageMgr = myContext.getPackageManager();
        try {
            myPackageMgr.getPackageInfo("com.skype.raider", PackageManager.GET_ACTIVITIES);
        } catch (PackageManager.NameNotFoundException e) {
            return (false);
        }
        return (true);
    }


    private void getInstagramPageUrl(String url) {


        Intent intent = getContext().getPackageManager().getLaunchIntentForPackage("com.instagram.android");
        intent.setData(Uri.parse(url));
        if (intent != null) {
            try {
                startActivity(intent);
            } catch (ActivityNotFoundException ex) {
                urlIntent("https://www.instagram.com/prokat.am/");
                ex.printStackTrace();
            }
        }

    }


}