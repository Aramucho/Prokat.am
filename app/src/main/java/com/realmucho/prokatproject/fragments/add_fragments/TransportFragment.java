package com.realmucho.prokatproject.fragments.add_fragments;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.realmucho.prokatproject.fragments.dialog_fragments.UploadDialogFragment;
import com.realmucho.prokatproject.R;

import static android.app.Activity.RESULT_OK;


public class TransportFragment extends Fragment implements View.OnClickListener {

    private Spinner mTransportSectionSpinner, mFuelTypeSpinner, mBoxSpinner;
    private ArrayAdapter mTranportSectionAdapter, mFuelTypeAdapter, mBoxAdapter;
    private TextView mImageText1, mImageText2, mImageText3, mImageText4, mImageText5;
    private FloatingActionButton mFab1, mFab2, mFab3, mFab4, mFab5;
    private Bitmap mBm1, mBm2, mBm3, mBm4, mBm5;
    private final int REQ_CODE1 = 1, REQ_CODE2 = 2, REQ_CODE3 = 3, REQ_CODE4 = 4, REQ_CODE5 = 5, TRANSPORT_DIALOG = 40;
    private EditText transport_name, transport_model, transport_engine_volume, transport_year, transport_discript, transport_price, transport_contacts_name, transport_contacts_email, transport_contacts_phone, transport_notes;
    private boolean boolmageText1, boolmageText2, boolmageText3, boolmageText4, boolmageText5;
    private String[] bundlesstates = {"key1", "key2", "key3", "key4", "key5"};
    private Button addButton;
    byte[] byteArray1, byteArray2, byteArray3, byteArray4, byteArray5;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.transport_fragment, container, false);
        init(view);
        setupClicks();
        spinInit();
        savedState(savedInstanceState);
        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        if (boolmageText1) {
            outState.putString("key1", mImageText1.getText().toString());
            outState.putString("keyState1", bundlesstates[0]);
            outState.putByteArray("byte1", byteArray1);


        }
        if (boolmageText2) {
            outState.putString("key2", mImageText2.getText().toString());
            outState.putString("keyState2", bundlesstates[1]);
            outState.putByteArray("byte2", byteArray2);


        }
        if (boolmageText3) {
            outState.putString("key3", mImageText3.getText().toString());
            outState.putString("keyState3", bundlesstates[2]);
            outState.putByteArray("byte3", byteArray3);


        }
        if (boolmageText4) {
            outState.putString("key4", mImageText4.getText().toString());
            outState.putString("keyState4", bundlesstates[3]);
            outState.putByteArray("byte4", byteArray4);


        }
        if (boolmageText5) {
            outState.putString("key5", mImageText5.getText().toString());
            outState.putString("keyState5", bundlesstates[4]);
            outState.putByteArray("byte5", byteArray5);


        }


    }

    private void init(View view) {
        mTransportSectionSpinner = (Spinner) view.findViewById(R.id.transport_section_spinner);
        mFuelTypeSpinner = (Spinner) view.findViewById(R.id.transport_fuel_type_spinner);
        mBoxSpinner = (Spinner) view.findViewById(R.id.transport_box_spinner);
        mFab1 = (FloatingActionButton) view.findViewById(R.id.transport_choose_button_1);
        mFab2 = (FloatingActionButton) view.findViewById(R.id.transport_choose_button_2);
        mFab3 = (FloatingActionButton) view.findViewById(R.id.transport_choose_button_3);
        mFab4 = (FloatingActionButton) view.findViewById(R.id.transport_choose_button_4);
        mFab5 = (FloatingActionButton) view.findViewById(R.id.transport_choose_button_5);
        addButton = (Button) view.findViewById(R.id.transport_add_button);
        mImageText1 = (TextView) view.findViewById(R.id.transport_choose_photos_name_1);
        mImageText2 = (TextView) view.findViewById(R.id.transport_choose_photos_name_2);
        mImageText3 = (TextView) view.findViewById(R.id.transport_choose_photos_name_3);
        mImageText4 = (TextView) view.findViewById(R.id.transport_choose_photos_name_4);
        mImageText5 = (TextView) view.findViewById(R.id.transport_choose_photos_name_5);
        transport_name = (EditText) view.findViewById(R.id.transport_mark_edit);
        transport_model = (EditText) view.findViewById(R.id.transport_model_edit);
        transport_engine_volume = (EditText) view.findViewById(R.id.transport_engine_volume_edit);
        transport_year = (EditText) view.findViewById(R.id.transport_year_edit);
        transport_contacts_name = (EditText) view.findViewById(R.id.transport_contacts_name);
        transport_contacts_email = (EditText) view.findViewById(R.id.transport_contacts_email);
        transport_contacts_phone = (EditText) view.findViewById(R.id.transport_contacts_phone);
        transport_notes = (EditText) view.findViewById(R.id.transport_contacts_notes);

    }

    private void setupClicks() {
        mFab1.setOnClickListener(this);
        mFab2.setOnClickListener(this);
        mFab3.setOnClickListener(this);
        mFab4.setOnClickListener(this);
        mFab5.setOnClickListener(this);
        addButton.setOnClickListener(this);

    }

    private void spinInit() {
        mTranportSectionAdapter = ArrayAdapter.createFromResource(getContext(), R.array.transport_titles, R.layout.drop_down_spinner_item);
        mTransportSectionSpinner.setAdapter(mTranportSectionAdapter);
        mFuelTypeAdapter = ArrayAdapter.createFromResource(getContext(), R.array.fuel_types, R.layout.drop_down_spinner_item);
        mFuelTypeSpinner.setAdapter(mFuelTypeAdapter);
        mBoxAdapter = ArrayAdapter.createFromResource(getContext(), R.array.box_types, R.layout.drop_down_spinner_item);
        mBoxSpinner.setAdapter(mBoxAdapter);
    }

    private void savedState(Bundle savedInstanceState) {

        if (savedInstanceState != null) {


            if (savedInstanceState.getString("keyState1") != null) {
                if (savedInstanceState.getString("keyState1").equals(bundlesstates[0])) {

                    mImageText1.setText(savedInstanceState.getString("key1"));
                    byteArray1 = savedInstanceState.getByteArray("byte1");
                    mBm1 = BitmapFactory.decodeByteArray(byteArray1, 0, byteArray1.length);
                    boolmageText1 = true;

                }
            }
            if (savedInstanceState.getString("keyState2") != null) {
                if (savedInstanceState.getString("keyState2").equals(bundlesstates[1])) {

                    mImageText2.setText(savedInstanceState.getString("key2"));
                    byteArray2 = savedInstanceState.getByteArray("byte2");
                    mBm2 = BitmapFactory.decodeByteArray(byteArray2, 0, byteArray2.length);
                    boolmageText2 = true;

                }
            }
            if (savedInstanceState.getString("keyState3") != null) {
                if (savedInstanceState.getString("keyState3").equals(bundlesstates[2])) {

                    mImageText3.setText(savedInstanceState.getString("key3"));
                    byteArray3 = savedInstanceState.getByteArray("byte3");
                    mBm3 = BitmapFactory.decodeByteArray(byteArray3, 0, byteArray2.length);
                    boolmageText3 = true;

                }
            }
            if (savedInstanceState.getString("keyState4") != null) {
                if (savedInstanceState.getString("keyState4").equals(bundlesstates[3])) {

                    mImageText4.setText(savedInstanceState.getString("key4"));
                    byteArray4 = savedInstanceState.getByteArray("byte4");
                    mBm4 = BitmapFactory.decodeByteArray(byteArray4, 0, byteArray4.length);
                    boolmageText4 = true;

                }
            }
            if (savedInstanceState.getString("keyState5") != null) {
                if (savedInstanceState.getString("keyState5").equals(bundlesstates[4])) {

                    mImageText5.setText(savedInstanceState.getString("key5"));
                    byteArray5 = savedInstanceState.getByteArray("byte5");
                    mBm5 = BitmapFactory.decodeByteArray(byteArray5, 0, byteArray5.length);
                    boolmageText5 = true;

                }
            }


        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        FragmentManager fragmentManager = getChildFragmentManager();
        UploadDialogFragment dialogFragment;

        switch (id) {
            case R.id.transport_choose_button_1:
                dialogFragment = UploadDialogFragment.newInstance(TRANSPORT_DIALOG);
                dialogFragment.setTargetFragment(this, REQ_CODE1);
                dialogFragment.show(fragmentManager, "Fragment1");
                break;
            case R.id.transport_choose_button_2:
                dialogFragment = UploadDialogFragment.newInstance(TRANSPORT_DIALOG);
                dialogFragment.setTargetFragment(this, REQ_CODE2);
                dialogFragment.show(fragmentManager, "Fragment2");
                break;
            case R.id.transport_choose_button_3:
                dialogFragment = UploadDialogFragment.newInstance(TRANSPORT_DIALOG);
                dialogFragment.setTargetFragment(this, REQ_CODE3);
                dialogFragment.show(fragmentManager, "Fragment3");
                break;
            case R.id.transport_choose_button_4:
                dialogFragment = UploadDialogFragment.newInstance(TRANSPORT_DIALOG);
                dialogFragment.setTargetFragment(this, REQ_CODE4);
                dialogFragment.show(fragmentManager, "Fragment4");
                break;
            case R.id.transport_choose_button_5:
                dialogFragment = UploadDialogFragment.newInstance(TRANSPORT_DIALOG);
                dialogFragment.setTargetFragment(this, REQ_CODE5);
                dialogFragment.show(fragmentManager, "Fragment5");
                break;
            case R.id.transport_add_button:
                break;

        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case REQ_CODE1:
                if (resultCode == RESULT_OK) {
                    byteArray1 = data.getByteArrayExtra("bitmap");
                    mBm1 = BitmapFactory.decodeByteArray(byteArray1, 0, byteArray1.length);
                    mImageText1.setText(R.string.image_uploaded);
                    boolmageText1 = true;
                } else {
                    Toast.makeText(getContext(), "Cancelled", Toast.LENGTH_SHORT).show();
                }
                break;
            case REQ_CODE2:
                if (resultCode == RESULT_OK) {
                    byteArray2 = data.getByteArrayExtra("bitmap");
                    mBm2 = BitmapFactory.decodeByteArray(byteArray2, 0, byteArray2.length);
                    mImageText2.setText(R.string.image_uploaded);
                    boolmageText2 = true;
                } else {
                    Toast.makeText(getContext(), "Cancelled", Toast.LENGTH_SHORT).show();
                }
                break;
            case REQ_CODE3:
                if (resultCode == RESULT_OK) {
                    byteArray3 = data.getByteArrayExtra("bitmap");
                    mBm3 = BitmapFactory.decodeByteArray(byteArray3, 0, byteArray3.length);
                    mImageText3.setText(R.string.image_uploaded);
                    boolmageText3 = true;
                } else {
                    Toast.makeText(getContext(), "Cancelled", Toast.LENGTH_SHORT).show();
                }
                break;
            case REQ_CODE4:
                if (resultCode == RESULT_OK) {
                    byteArray4 = data.getByteArrayExtra("bitmap");
                    mBm4 = BitmapFactory.decodeByteArray(byteArray4, 0, byteArray4.length);
                    mImageText4.setText(R.string.image_uploaded);
                    boolmageText4 = true;
                } else {
                    Toast.makeText(getContext(), "Cancelled", Toast.LENGTH_SHORT).show();
                }
                break;
            case REQ_CODE5:
                if (resultCode == RESULT_OK) {
                    byteArray5 = data.getByteArrayExtra("bitmap");
                    mBm5 = BitmapFactory.decodeByteArray(byteArray5, 0, byteArray5.length);
                    mImageText5.setText(R.string.image_uploaded);
                    boolmageText5 = true;
                } else {
                    Toast.makeText(getContext(), "Cancelled", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
