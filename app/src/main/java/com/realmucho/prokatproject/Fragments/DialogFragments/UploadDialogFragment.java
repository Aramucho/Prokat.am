package com.realmucho.prokatproject.Fragments.DialogFragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.realmucho.prokatproject.R;

/**
 * Created by Free User on 6/9/2017.
 */

public class UploadDialogFragment extends DialogFragment implements View.OnClickListener {

    private ImageView camera_image,gallery_image;
    private Button upload_cancel,upload_ok;
    private boolean camera_chacked,gallery_chacked;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.iamge_upload_dialog,container,false);
        getDialog().setTitle(R.string.upload_type);
        camera_image=(ImageView) view.findViewById(R.id.camera_image);
        gallery_image=(ImageView)view.findViewById(R.id.gallery_image);
        upload_cancel=(Button) view.findViewById(R.id.upload_dialog_cancel_button);
        upload_ok=(Button) view.findViewById(R.id.upload_dialog_ok_button);
        camera_image.setOnClickListener(this);
        gallery_image.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch (id){
            case R.id.camera_image:
                if(camera_chacked){
                    camera_chacked=false;
                    camera_image.setImageResource(R.drawable.camera_icon);
                }
                else if(!camera_chacked){
                    camera_chacked=true;
                    camera_image.setImageResource(R.drawable.camera_chacked_icon);
                }
                break;
            case R.id.gallery_image:
                break;
            case R.id.upload_dialog_cancel_button:
                break;
            case R.id.upload_dialog_ok_button:
                break;
        }
    }
}
