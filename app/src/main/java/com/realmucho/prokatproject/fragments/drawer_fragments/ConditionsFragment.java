package com.realmucho.prokatproject.fragments.drawer_fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.realmucho.prokatproject.activities.MainActivity;
import com.realmucho.prokatproject.R;


public class ConditionsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.conditions_fragment,container,false);
    }
    @Override
    public void onResume() {
        super.onResume();

        /**OnBackPressed functions*/

        getView().setFocusableInTouchMode(true);
        getView().requestFocus();
        getView().setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK) {

                    Intent intent = new Intent(getContext(), MainActivity.class);
                    startActivity(intent);

                }

                return true;
            }
        });
    }
}
