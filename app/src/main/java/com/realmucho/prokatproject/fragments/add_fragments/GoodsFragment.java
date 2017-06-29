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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.realmucho.prokatproject.fragments.dialog_fragments.UploadDialogFragment;
import com.realmucho.prokatproject.R;

import static android.app.Activity.RESULT_OK;


public class GoodsFragment extends Fragment implements View.OnClickListener {

    private TextView section;


    private Spinner sectionspinner, goodssubsectionspinner, goodscitiesspinner;
    private ArrayAdapter sectionadapter, goodsubsectionadapter, goodscitiesadapter;
    private Intent intent;
    private EditText goods_name, goods_discript, goods_price, goods_contacts_name, goods_contacts_email, goods_contacts_phone, goods_notes;
    private FloatingActionButton fab1, fab2, fab3, fab4, fab5;
    private Bitmap bm1, bm2, bm3, bm4, bm5;
    private TextView imageText1, imageText2, imageText3, imageText4, imageText5;
    private final int REQ_CODE1 = 1, REQ_CODE2 = 2, REQ_CODE3 = 3, REQ_CODE4 = 4, REQ_CODE5 = 5, GOODS_DIALOG = 11;
    private boolean boolmageText1, boolmageText2, boolmageText3, boolmageText4, boolmageText5;
    private String[] bundlesstates = {"key1", "key2", "key3", "key4", "key5"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.gooods_fragment, container, false);
        init(view);
        setupClicks();
        intent = getActivity().getIntent();
        spinnersInit();
        if (savedInstanceState != null) {


            if (savedInstanceState.getString("keyState1") != null) {
                if (savedInstanceState.getString("keyState1").equals(bundlesstates[0])) {

                    imageText1.setText(savedInstanceState.getString("key1"));
                    boolmageText1 = true;

                }
            }
            if (savedInstanceState.getString("keyState2") != null) {
                if (savedInstanceState.getString("keyState2").equals(bundlesstates[1])) {

                    imageText2.setText(savedInstanceState.getString("key2"));
                    boolmageText2 = true;

                }
            }
            if (savedInstanceState.getString("keyState3") != null) {
                if (savedInstanceState.getString("keyState3").equals(bundlesstates[2])) {

                    imageText3.setText(savedInstanceState.getString("key3"));
                    boolmageText3 = true;

                }
            }
            if (savedInstanceState.getString("keyState4") != null) {
                if (savedInstanceState.getString("keyState4").equals(bundlesstates[3])) {

                    imageText4.setText(savedInstanceState.getString("key4"));
                    boolmageText4 = true;

                }
            }
            if (savedInstanceState.getString("keyState5") != null) {
                if (savedInstanceState.getString("keyState5").equals(bundlesstates[4])) {

                    imageText5.setText(savedInstanceState.getString("key5"));
                    boolmageText5 = true;

                }
            }


        }
        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        if (boolmageText1) {
            outState.putString("key1", imageText1.getText().toString());
            outState.putString("keyState1", bundlesstates[0]);

        }
        if (boolmageText2) {
            outState.putString("key2", imageText2.getText().toString());
            outState.putString("keyState2", bundlesstates[1]);


        }
        if (boolmageText3) {
            outState.putString("key3", imageText3.getText().toString());
            outState.putString("keyState3", bundlesstates[2]);


        }
        if (boolmageText4) {
            outState.putString("key4", imageText4.getText().toString());
            outState.putString("keyState4", bundlesstates[3]);


        }
        if (boolmageText5) {
            outState.putString("key5", imageText5.getText().toString());
            outState.putString("keyState5", bundlesstates[4]);

        }


    }


    private void init(View view) {
        fab1 = (FloatingActionButton) view.findViewById(R.id.goods_choose_button_1);
        fab2 = (FloatingActionButton) view.findViewById(R.id.goods_choose_button_2);
        fab3 = (FloatingActionButton) view.findViewById(R.id.goods_choose_button_3);
        fab4 = (FloatingActionButton) view.findViewById(R.id.goods_choose_button_4);
        fab5 = (FloatingActionButton) view.findViewById(R.id.goods_choose_button_5);
        imageText1 = (TextView) view.findViewById(R.id.goods_choose_photos_name_1);
        imageText2 = (TextView) view.findViewById(R.id.goods_choose_photos_name_2);
        imageText3 = (TextView) view.findViewById(R.id.goods_choose_photos_name_3);
        imageText4 = (TextView) view.findViewById(R.id.goods_choose_photos_name_4);
        imageText5 = (TextView) view.findViewById(R.id.goods_choose_photos_name_5);
        sectionspinner = (Spinner) view.findViewById(R.id.goods_section_spinner);
        goodssubsectionspinner = (Spinner) view.findViewById(R.id.goods_subsection_spinner);
        goodscitiesspinner = (Spinner) view.findViewById(R.id.goods_cities_spinner);
        goods_name = (EditText) view.findViewById(R.id.goods_name_edit);
        goods_discript = (EditText) view.findViewById(R.id.goods_description_edit);
        goods_price = (EditText) view.findViewById(R.id.goods_price_edit);
        goods_contacts_name = (EditText) view.findViewById(R.id.goods_contacts_name);
        goods_contacts_email = (EditText) view.findViewById(R.id.goods_contacts_email);
        goods_contacts_phone = (EditText) view.findViewById(R.id.goods_contacts_phone);
        goods_notes = (EditText) view.findViewById(R.id.goods_contacts_notes);

    }

    private void setupClicks() {
        fab1.setOnClickListener(this);
        fab2.setOnClickListener(this);
        fab3.setOnClickListener(this);
        fab4.setOnClickListener(this);
        fab5.setOnClickListener(this);

    }

    private void spinnersInit() {

        sectionadapter = ArrayAdapter.createFromResource(getContext(), R.array.goods_titles, R.layout.drop_down_spinner_item);
        goodscitiesadapter = ArrayAdapter.createFromResource(getContext(), R.array.cities, R.layout.drop_down_spinner_item);

        goodsubsectionadapter = ArrayAdapter.createFromResource(getContext(), R.array.bydefualt, R.layout.drop_down_spinner_item);
        sectionspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {


                    case 1:
                        goodsubsectionadapter = ArrayAdapter.createFromResource(getContext(), R.array.comp_equipment, R.layout.drop_down_spinner_item);
                        goodssubsectionspinner.setAdapter(goodsubsectionadapter);
                        break;
                    case 2:
                        goodsubsectionadapter = ArrayAdapter.createFromResource(getContext(), R.array.ever_events, R.layout.drop_down_spinner_item);
                        goodssubsectionspinner.setAdapter(goodsubsectionadapter);
                        break;
                    case 3:
                        goodsubsectionadapter = ArrayAdapter.createFromResource(getContext(), R.array.sound_equipments, R.layout.drop_down_spinner_item);
                        goodssubsectionspinner.setAdapter(goodsubsectionadapter);
                        break;
                    case 4:
                        goodsubsectionadapter = ArrayAdapter.createFromResource(getContext(), R.array.cameras, R.layout.drop_down_spinner_item);
                        goodssubsectionspinner.setAdapter(goodsubsectionadapter);
                        break;
                    case 5:
                        goodsubsectionadapter = ArrayAdapter.createFromResource(getContext(), R.array.tools, R.layout.drop_down_spinner_item);
                        goodssubsectionspinner.setAdapter(goodsubsectionadapter);
                        break;
                    case 6:
                        goodsubsectionadapter = ArrayAdapter.createFromResource(getContext(), R.array.tourism, R.layout.drop_down_spinner_item);
                        goodssubsectionspinner.setAdapter(goodsubsectionadapter);
                        break;
                    case 7:
                        goodsubsectionadapter = ArrayAdapter.createFromResource(getContext(), R.array.clothing, R.layout.drop_down_spinner_item);
                        goodssubsectionspinner.setAdapter(goodsubsectionadapter);
                        break;
                    case 8:
                        goodsubsectionadapter = ArrayAdapter.createFromResource(getContext(), R.array.communications, R.layout.drop_down_spinner_item);
                        goodssubsectionspinner.setAdapter(goodsubsectionadapter);
                        break;
                    case 9:
                        goodsubsectionadapter = ArrayAdapter.createFromResource(getContext(), R.array.entertaiment, R.layout.drop_down_spinner_item);
                        goodssubsectionspinner.setAdapter(goodsubsectionadapter);
                        break;
                    case 10:
                        goodsubsectionadapter = ArrayAdapter.createFromResource(getContext(), R.array.tableware, R.layout.drop_down_spinner_item);
                        goodssubsectionspinner.setAdapter(goodsubsectionadapter);
                        break;
                    case 11:
                        goodsubsectionadapter = ArrayAdapter.createFromResource(getContext(), R.array.other_goods, R.layout.drop_down_spinner_item);
                        goodssubsectionspinner.setAdapter(goodsubsectionadapter);
                        break;


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        sectionspinner.setAdapter(sectionadapter);
        goodssubsectionspinner.setAdapter(goodsubsectionadapter);
        goodscitiesspinner.setAdapter(goodscitiesadapter);


    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        FragmentManager fragmentManager = getChildFragmentManager();
        UploadDialogFragment dialogFragment;

        switch (id) {
            case R.id.goods_choose_button_1:
                dialogFragment = UploadDialogFragment.newInstance(GOODS_DIALOG);
                dialogFragment.setTargetFragment(this, REQ_CODE1);
                dialogFragment.show(fragmentManager, "Fragment1");

                break;
            case R.id.goods_choose_button_2:
                dialogFragment = UploadDialogFragment.newInstance(GOODS_DIALOG);
                dialogFragment.setTargetFragment(this, REQ_CODE2);
                dialogFragment.show(fragmentManager, "Fragment2");
                break;
            case R.id.goods_choose_button_3:
                dialogFragment = UploadDialogFragment.newInstance(GOODS_DIALOG);
                dialogFragment.setTargetFragment(this, REQ_CODE3);
                dialogFragment.show(fragmentManager, "Fragment3");
                break;
            case R.id.goods_choose_button_4:
                dialogFragment = UploadDialogFragment.newInstance(GOODS_DIALOG);
                dialogFragment.setTargetFragment(this, REQ_CODE4);
                dialogFragment.show(fragmentManager, "Fragment4");
                break;
            case R.id.goods_choose_button_5:
                dialogFragment = UploadDialogFragment.newInstance(GOODS_DIALOG);
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
                    boolmageText1 = true;

                } else {
                    Toast.makeText(getContext(), "Cancelled", Toast.LENGTH_SHORT).show();
                }
                break;
            case REQ_CODE2:
                if (resultCode == RESULT_OK) {
                    byte[] byteArray = data.getByteArrayExtra("bitmap");
                    bm2 = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                    imageText2.setText(R.string.image_uploaded);
                    boolmageText2 = true;
                } else {
                    Toast.makeText(getContext(), "Cancelled", Toast.LENGTH_SHORT).show();
                }
                break;
            case REQ_CODE3:
                if (resultCode == RESULT_OK) {
                    byte[] byteArray = data.getByteArrayExtra("bitmap");
                    bm3 = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                    imageText3.setText(R.string.image_uploaded);
                    boolmageText3 = true;
                } else {
                    Toast.makeText(getContext(), "Cancelled", Toast.LENGTH_SHORT).show();
                }
                break;
            case REQ_CODE4:
                if (resultCode == RESULT_OK) {
                    byte[] byteArray = data.getByteArrayExtra("bitmap");
                    bm4 = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                    imageText4.setText(R.string.image_uploaded);
                    boolmageText4 = true;
                } else {
                    Toast.makeText(getContext(), "Cancelled", Toast.LENGTH_SHORT).show();
                }
                break;
            case REQ_CODE5:
                if (resultCode == RESULT_OK) {
                    byte[] byteArray = data.getByteArrayExtra("bitmap");
                    bm5 = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                    imageText5.setText(R.string.image_uploaded);
                    boolmageText5 = true;
                } else {
                    Toast.makeText(getContext(), "Cancelled", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
