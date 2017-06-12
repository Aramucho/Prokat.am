package com.realmucho.prokatproject.Fragments.DialogFragments;


import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.realmucho.prokatproject.R;

/**
 * Created by Free User on 6/9/2017.
 */

public class UploadDialogFragment extends DialogFragment implements View.OnClickListener {

    private ImageView camera_image,gallery_image;
    private Button upload_cancel,upload_ok;
    private int chacked_status=-1;
    private Bitmap bm1,bm2,bm3,bm4,bm5;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.image_upload_dialog,container,false);
        camera_image=(ImageView) view.findViewById(R.id.camera_image);
        gallery_image=(ImageView)view.findViewById(R.id.gallery_image);
        upload_cancel=(Button) view.findViewById(R.id.upload_dialog_cancel_button);
        upload_ok=(Button) view.findViewById(R.id.upload_dialog_ok_button);
        camera_image.setOnClickListener(this);
        gallery_image.setOnClickListener(this);
        upload_cancel.setOnClickListener(this);
        upload_ok.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();

        switch (id){
            case R.id.camera_image:
                chacked_status=1;
                camera_image.setImageResource(R.drawable.camera_chacked_icon);
                gallery_image.setImageResource(R.drawable.gallery);
                break;
            case R.id.gallery_image:
                chacked_status=2;
                camera_image.setImageResource(R.drawable.camera_icon);
                gallery_image.setImageResource(R.drawable.camera_chacked_icon);
                break;
            case R.id.upload_dialog_cancel_button:
                getDialog().dismiss();
                break;
            case R.id.upload_dialog_ok_button:
                if(chacked_status==-1){
                    Toast.makeText(getContext(),R.string.upload_type,Toast.LENGTH_SHORT).show();
                }
                else if(chacked_status==1){
                    Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent,chacked_status);

                }
                else if(chacked_status==2){
                    Intent intent=new Intent(Intent.ACTION_PICK);
                    intent.setType("image/*");
                    startActivityForResult(intent,chacked_status);
                }
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==1){
            bm1=(Bitmap)data.getExtras().get("data");
            }
        else if(requestCode==2){
            Toast.makeText(getContext(),"gallery",Toast.LENGTH_SHORT).show();
        }
        }
    }

