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
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.realmucho.prokatproject.fragments.dialog_fragments.UploadDialogFragment;
import com.realmucho.prokatproject.R;

import static android.app.Activity.RESULT_OK;


public class ServiceFragment extends Fragment implements View.OnClickListener {
    private TextView mImageText1, mImageText2, mImageText3, mImageText4, mImageText5;
    private final static int REQ_CODE1 = 1, REQ_CODE2 = 2, REQ_CODE3 = 3, REQ_CODE4 = 4, REQ_CODE5 = 5, SERVICE_DIALOG = 30;
    private Spinner mServiceSectionSpinner;
    private ArrayAdapter mServiceSpinnerAdapter;
    private Bitmap mBm1, mBm2, mBm3, mBm4, mBm5;
    private FloatingActionButton mFab1, mFab2, mFab3, mFab4, mFab5;
    private EditText mServiceName, mServiceDescript, mServicePrice, mServiceContactsName, mServiceContactsEmail, mServiceContactsPhone, mServiceNotes;
    private boolean mBoolImageText1, mBoolImageText2, mBoolImageText3, mBoolImageText4, mBoolImageText5;
    private String[] mBundlesstates = {"key1", "key2", "key3", "key4", "key5"};
    private byte[] mByteArray1, mByteArray2, mByteArray3, mByteArray4, mByteArray5;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.service_fragment, container, false);
        init(view);
        setupClicks();
        spinnersFunctions();
        savedState(savedInstanceState);
        return view;
    }


    private void init(View view) {
        mServiceSectionSpinner = (Spinner) view.findViewById(R.id.service_section_spinner);
        mServiceName = (EditText) view.findViewById(R.id.service_name_edit);
        mServiceDescript = (EditText) view.findViewById(R.id.service_description_edit);
        mServicePrice = (EditText) view.findViewById(R.id.service_price_edit);
        mServiceContactsName = (EditText) view.findViewById(R.id.service_contacts_name);
        mServiceContactsEmail = (EditText) view.findViewById(R.id.service_contacts_email);
        mServiceContactsPhone = (EditText) view.findViewById(R.id.service_contacts_phone);
        mServiceNotes = (EditText) view.findViewById(R.id.service_contacts_notes);
        mFab1 = (FloatingActionButton) view.findViewById(R.id.service_choose_button_1);
        mFab2 = (FloatingActionButton) view.findViewById(R.id.service_choose_button_2);
        mFab3 = (FloatingActionButton) view.findViewById(R.id.service_choose_button_3);
        mFab4 = (FloatingActionButton) view.findViewById(R.id.service_choose_button_4);
        mFab5 = (FloatingActionButton) view.findViewById(R.id.service_choose_button_5);
        mImageText1 = (TextView) view.findViewById(R.id.service_choose_photos_name_1);
        mImageText2 = (TextView) view.findViewById(R.id.service_choose_photos_name_2);
        mImageText3 = (TextView) view.findViewById(R.id.service_choose_photos_name_3);
        mImageText4 = (TextView) view.findViewById(R.id.service_choose_photos_name_4);
        mImageText5 = (TextView) view.findViewById(R.id.service_choose_photos_name_5);

    }

    private void setupClicks() {
        mFab1.setOnClickListener(this);
        mFab2.setOnClickListener(this);
        mFab3.setOnClickListener(this);
        mFab4.setOnClickListener(this);
        mFab5.setOnClickListener(this);

    }

    /**Initializing and organizing spinners functions*/
    private void spinnersFunctions() {

        mServiceSpinnerAdapter = ArrayAdapter.createFromResource(getContext(), R.array.service_items, R.layout.drop_down_spinner_item);
        mServiceSectionSpinner.setAdapter(mServiceSpinnerAdapter);

    }

    private void savedState(Bundle savedInstanceState) {

        if (savedInstanceState != null) {


            if (savedInstanceState.getString("keyState1") != null) {
                if (savedInstanceState.getString("keyState1").equals(mBundlesstates[0])) {

                    mImageText1.setText(savedInstanceState.getString("key1"));
                    mByteArray1 = savedInstanceState.getByteArray("byte1");
                    mBm1 = BitmapFactory.decodeByteArray(mByteArray1, 0, mByteArray1.length);
                    mBoolImageText1 = true;

                }
            }
            if (savedInstanceState.getString("keyState2") != null) {
                if (savedInstanceState.getString("keyState2").equals(mBundlesstates[1])) {

                    mImageText2.setText(savedInstanceState.getString("key2"));
                    mByteArray2 = savedInstanceState.getByteArray("byte2");
                    mBm2 = BitmapFactory.decodeByteArray(mByteArray2, 0, mByteArray2.length);
                    mBoolImageText2 = true;

                }
            }
            if (savedInstanceState.getString("keyState3") != null) {
                if (savedInstanceState.getString("keyState3").equals(mBundlesstates[2])) {

                    mImageText3.setText(savedInstanceState.getString("key3"));
                    mByteArray3 = savedInstanceState.getByteArray("byte3");
                    mBm3 = BitmapFactory.decodeByteArray(mByteArray3, 0, mByteArray2.length);
                    mBoolImageText3 = true;

                }
            }
            if (savedInstanceState.getString("keyState4") != null) {
                if (savedInstanceState.getString("keyState4").equals(mBundlesstates[3])) {

                    mImageText4.setText(savedInstanceState.getString("key4"));
                    mByteArray4 = savedInstanceState.getByteArray("byte4");
                    mBm4 = BitmapFactory.decodeByteArray(mByteArray4, 0, mByteArray4.length);
                    mBoolImageText4 = true;

                }
            }
            if (savedInstanceState.getString("keyState5") != null) {
                if (savedInstanceState.getString("keyState5").equals(mBundlesstates[4])) {

                    mImageText5.setText(savedInstanceState.getString("key5"));
                    mByteArray5 = savedInstanceState.getByteArray("byte5");
                    mBm5 = BitmapFactory.decodeByteArray(mByteArray5, 0, mByteArray5.length);
                    mBoolImageText5 = true;

                }
            }


        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        if (mBoolImageText1) {
            outState.putString("key1", mImageText1.getText().toString());
            outState.putString("keyState1", mBundlesstates[0]);
            outState.putByteArray("byte1", mByteArray1);


        }
        if (mBoolImageText2) {
            outState.putString("key2", mImageText2.getText().toString());
            outState.putString("keyState2", mBundlesstates[1]);
            outState.putByteArray("byte2", mByteArray2);


        }
        if (mBoolImageText3) {
            outState.putString("key3", mImageText3.getText().toString());
            outState.putString("keyState3", mBundlesstates[2]);
            outState.putByteArray("byte3", mByteArray3);


        }
        if (mBoolImageText4) {
            outState.putString("key4", mImageText4.getText().toString());
            outState.putString("keyState4", mBundlesstates[3]);
            outState.putByteArray("byte4", mByteArray4);


        }
        if (mBoolImageText5) {
            outState.putString("key5", mImageText5.getText().toString());
            outState.putString("keyState5", mBundlesstates[4]);
            outState.putByteArray("byte5", mByteArray5);


        }


    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        FragmentManager fragmentManager = getChildFragmentManager();
        UploadDialogFragment dialogFragment;

        switch (id) {
            case R.id.service_choose_button_1:
                dialogFragment = UploadDialogFragment.newInstance(SERVICE_DIALOG);
                dialogFragment.setTargetFragment(this, REQ_CODE1);
                dialogFragment.show(fragmentManager, "Fragment1");
                break;
            case R.id.service_choose_button_2:
                dialogFragment = UploadDialogFragment.newInstance(SERVICE_DIALOG);
                dialogFragment.setTargetFragment(this, REQ_CODE2);
                dialogFragment.show(fragmentManager, "Fragment2");
                break;
            case R.id.service_choose_button_3:
                dialogFragment = UploadDialogFragment.newInstance(SERVICE_DIALOG);
                dialogFragment.setTargetFragment(this, REQ_CODE3);
                dialogFragment.show(fragmentManager, "Fragment3");
                break;
            case R.id.service_choose_button_4:
                dialogFragment = UploadDialogFragment.newInstance(SERVICE_DIALOG);
                dialogFragment.setTargetFragment(this, REQ_CODE4);
                dialogFragment.show(fragmentManager, "Fragment4");
                break;
            case R.id.service_choose_button_5:
                dialogFragment = UploadDialogFragment.newInstance(SERVICE_DIALOG);
                dialogFragment.setTargetFragment(this, REQ_CODE5);
                dialogFragment.show(fragmentManager, "Fragment5");
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case REQ_CODE1:
                if (resultCode == RESULT_OK) {
                    mByteArray1 = data.getByteArrayExtra("bitmap");
                    mBm1 = BitmapFactory.decodeByteArray(mByteArray1, 0, mByteArray1.length);
                    mImageText1.setText(R.string.image_uploaded);
                    mBoolImageText1 = true;
                } else {
                    Toast.makeText(getContext(), R.string.image_uploaded, Toast.LENGTH_SHORT).show();
                }
                break;
            case REQ_CODE2:
                if (resultCode == RESULT_OK) {
                    mByteArray2 = data.getByteArrayExtra("bitmap");
                    mBm2 = BitmapFactory.decodeByteArray(mByteArray2, 0, mByteArray2.length);
                    mImageText2.setText(R.string.image_uploaded);
                    mBoolImageText2 = true;
                } else {
                    Toast.makeText(getContext(), R.string.image_uploaded, Toast.LENGTH_SHORT).show();
                }
                break;
            case REQ_CODE3:
                if (resultCode == RESULT_OK) {
                    mByteArray3 = data.getByteArrayExtra("bitmap");
                    mBm3 = BitmapFactory.decodeByteArray(mByteArray3, 0, mByteArray3.length);
                    mImageText3.setText(R.string.image_uploaded);
                    mBoolImageText3 = true;
                } else {
                    Toast.makeText(getContext(), R.string.image_uploaded, Toast.LENGTH_SHORT).show();
                }
                break;
            case REQ_CODE4:
                if (resultCode == RESULT_OK) {
                    mByteArray4 = data.getByteArrayExtra("bitmap");
                    mBm4 = BitmapFactory.decodeByteArray(mByteArray4, 0, mByteArray4.length);
                    mImageText4.setText(R.string.image_uploaded);
                    mBoolImageText4 = true;
                } else {
                    Toast.makeText(getContext(), R.string.image_uploaded, Toast.LENGTH_SHORT).show();
                }
                break;
            case REQ_CODE5:
                if (resultCode == RESULT_OK) {
                    mByteArray5 = data.getByteArrayExtra("bitmap");
                    mBm5 = BitmapFactory.decodeByteArray(mByteArray5, 0, mByteArray5.length);
                    mImageText5.setText(R.string.image_uploaded);
                    mBoolImageText5 = true;
                } else {
                    Toast.makeText(getContext(), R.string.image_uploaded, Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
