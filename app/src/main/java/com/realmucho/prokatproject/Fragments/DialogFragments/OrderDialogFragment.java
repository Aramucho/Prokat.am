package com.realmucho.prokatproject.Fragments.DialogFragments;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.realmucho.prokatproject.R;

/**
 * Created by Free User on 6/8/2017.
 */

public class OrderDialogFragment extends android.support.v4.app.DialogFragment {

    EditText orderName,orderEmail,orderPhone,orderNotes;
    Button order;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.order_dialog,container,false);
        orderName=(EditText) view.findViewById(R.id.order_name);
        orderEmail=(EditText) view.findViewById(R.id.order_email);
        orderPhone=(EditText) view.findViewById(R.id.order_phone);
        orderNotes=(EditText) view.findViewById(R.id.order_notes);
        order=(Button) view.findViewById(R.id.dialog_order);
        return view;
    }
}
