package com.realmucho.prokatproject.fragments.dialog_fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.realmucho.prokatproject.R;


public class OrderDialogFragment extends android.support.v4.app.DialogFragment {

    EditText mOrderName, mOrderEmail, mOrderPhone, mOrderNotes;
    Button mOrder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.order_dialog, container, false);
        init(view);
        return view;
    }

    private void init(View view) {
        mOrderName = (EditText) view.findViewById(R.id.order_name);
        mOrderEmail = (EditText) view.findViewById(R.id.order_email);
        mOrderPhone = (EditText) view.findViewById(R.id.order_phone);
        mOrderNotes = (EditText) view.findViewById(R.id.order_notes);
        mOrder = (Button) view.findViewById(R.id.dialog_order);
    }
}
