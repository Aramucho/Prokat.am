package com.realmucho.prokatproject.Fragments.AddFragments;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.realmucho.prokatproject.Fragments.DialogFragments.UploadDialogFragment;
import com.realmucho.prokatproject.R;

import static android.app.Activity.RESULT_OK;


public class GoodsFragment extends Fragment implements View.OnClickListener {

    private TextView section;


    private Spinner sectionspinner, goodssubsectionspinner, goodscitiesspinner;
    private ArrayAdapter sectionadapter, goodsubsectionadapter, goodscitiesadapter;
    private Intent intent;
    private FloatingActionButton fab1,fab2,fab3,fab4,fab5;
    private Bitmap bm1,bm2,bm3,bm4,bm5;
    private final int REQ_CODE1=1,REQ_CODE2=2,REQ_CODE3=3,REQ_CODE4=4,REQ_CODE5=5;
//    private final int REQ_GAL1=21,REQ_GAL2=22,REQ_GAL3=23,REQ_GAL4=24,REQ_GAL5=25;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.gooods_fragment, container, false);
        fab1=(FloatingActionButton)view.findViewById(R.id.goods_choose_button_1);
        fab1.setOnClickListener(this);
        intent=getActivity().getIntent();
        sectionspinner = (Spinner) view.findViewById(R.id.goods_section_spinner);
        goodssubsectionspinner = (Spinner) view.findViewById(R.id.goods_subsection_spinner);
        goodscitiesspinner = (Spinner) view.findViewById(R.id.goods_cities_spinner);

        spinnersinit();


        return view;
    }

    private void spinnersinit() {

        sectionadapter = ArrayAdapter.createFromResource(getContext(), R.array.goods_titles, R.layout.drop_down_spinner_item);
        goodscitiesadapter=ArrayAdapter.createFromResource(getContext(),R.array.cities,R.layout.drop_down_spinner_item);

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
        int id=v.getId();
        FragmentManager fragmentManager=getChildFragmentManager();



        switch (id){
            case R.id.goods_choose_button_1:
                UploadDialogFragment dialogFragment=UploadDialogFragment.newInstance(REQ_CODE1);
                dialogFragment.setTargetFragment(this, 1);
                dialogFragment.show(fragmentManager,"Fragment1");
                break;
            case R.id.goods_choose_button_2:
                break;
            case R.id.goods_choose_button_3:

                break;
            case R.id.goods_choose_button_4:

                break;
            case R.id.goods_choose_button_5:

                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case REQ_CODE1:
                if(resultCode==RESULT_OK){
                    byte[]byteArray=data.getByteArrayExtra("bitmap");
                    Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                    bm1=bitmap;
                }
        }
    }
}
