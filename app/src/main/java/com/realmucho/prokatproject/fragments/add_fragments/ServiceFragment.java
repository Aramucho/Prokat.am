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
    private TextView imageText1,imageText2,imageText3,imageText4,imageText5;
    private final int REQ_CODE1 = 1, REQ_CODE2 = 2, REQ_CODE3 = 3, REQ_CODE4 = 4, REQ_CODE5 = 5, SERVICE_DIALOG=30;
    private Spinner servicesectionspinner;
    private ArrayAdapter servicespinneradapter;
    private Bitmap bm1, bm2, bm3, bm4, bm5;
    private FloatingActionButton fab1, fab2, fab3, fab4, fab5;
    private EditText service_name, service_discript, service_price, service_contacts_name, service_contacts_email, service_contacts_phone, service_notes;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.service_fragment, container, false);
        init(view);
        setupClicks();
        spinnerInit();
        return view;
    }

    private void init(View view){
        servicesectionspinner = (Spinner) view.findViewById(R.id.service_section_spinner);
        service_name=(EditText)view.findViewById(R.id.service_name_edit);
        service_discript=(EditText)view.findViewById(R.id.service_description_edit);
        service_price=(EditText)view.findViewById(R.id.service_price_edit);
        service_contacts_name=(EditText)view.findViewById(R.id.service_contacts_name);
        service_contacts_email=(EditText)view.findViewById(R.id.service_contacts_email);
        service_contacts_phone=(EditText)view.findViewById(R.id.service_contacts_phone);
        service_notes=(EditText)view.findViewById(R.id.service_contacts_notes);
        fab1 = (FloatingActionButton) view.findViewById(R.id.service_choose_button_1);
        fab2 = (FloatingActionButton) view.findViewById(R.id.service_choose_button_2);
        fab3 = (FloatingActionButton) view.findViewById(R.id.service_choose_button_3);
        fab4 = (FloatingActionButton) view.findViewById(R.id.service_choose_button_4);
        fab5 = (FloatingActionButton) view.findViewById(R.id.service_choose_button_5);
        imageText1=(TextView)view.findViewById(R.id.service_choose_photos_name_1);
        imageText2=(TextView)view.findViewById(R.id.service_choose_photos_name_2);
        imageText3=(TextView)view.findViewById(R.id.service_choose_photos_name_3);
        imageText4=(TextView)view.findViewById(R.id.service_choose_photos_name_4);
        imageText5=(TextView)view.findViewById(R.id.service_choose_photos_name_5);

    }

    private void setupClicks(){
        fab1.setOnClickListener(this);
        fab2.setOnClickListener(this);
        fab3.setOnClickListener(this);
        fab4.setOnClickListener(this);
        fab5.setOnClickListener(this);

    }
    private void spinnerInit() {

        servicespinneradapter = ArrayAdapter.createFromResource(getContext(), R.array.service_items, R.layout.drop_down_spinner_item);
        servicesectionspinner.setAdapter(servicespinneradapter);

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
                    byte[] byteArray = data.getByteArrayExtra("bitmap");
                    bm1 = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                    imageText1.setText(R.string.image_uploaded);
                }
                else{
                    Toast.makeText(getContext(),"Cancelled",Toast.LENGTH_SHORT).show();
                }
                break;
            case REQ_CODE2:
                if (resultCode == RESULT_OK) {
                    byte[] byteArray = data.getByteArrayExtra("bitmap");
                    bm2 = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                    imageText2.setText(R.string.image_uploaded);
                }
                else{
                    Toast.makeText(getContext(),"Cancelled",Toast.LENGTH_SHORT).show();
                }
                break;
            case REQ_CODE3:
                if (resultCode == RESULT_OK) {
                    byte[] byteArray = data.getByteArrayExtra("bitmap");
                    bm3 = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                    imageText3.setText(R.string.image_uploaded);
                }
                else{
                    Toast.makeText(getContext(),"Cancelled",Toast.LENGTH_SHORT).show();
                }
                break;
            case REQ_CODE4:
                if (resultCode == RESULT_OK) {
                    byte[] byteArray = data.getByteArrayExtra("bitmap");
                    bm4 = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                    imageText4.setText(R.string.image_uploaded);
                }
                else{
                    Toast.makeText(getContext(),"Cancelled",Toast.LENGTH_SHORT).show();
                }
                break;
            case REQ_CODE5:
                if (resultCode == RESULT_OK) {
                    byte[] byteArray = data.getByteArrayExtra("bitmap");
                    bm5 = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                    imageText5.setText(R.string.image_uploaded);
                }
                else{
                    Toast.makeText(getContext(),"Cancelled",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
