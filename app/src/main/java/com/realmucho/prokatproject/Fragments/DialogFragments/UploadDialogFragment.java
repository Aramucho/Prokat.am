package com.realmucho.prokatproject.Fragments.DialogFragments;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.DialogFragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.realmucho.prokatproject.R;

import java.io.ByteArrayOutputStream;

import static android.app.Activity.RESULT_OK;

/**
 * Created by Free User on 6/9/2017.
 */

public class UploadDialogFragment extends DialogFragment implements View.OnClickListener {

    private ImageView camera_image,gallery_image;
    private Button upload_cancel,upload_ok;
    private int chacked_status=-1;
    private Bitmap bitmap;
    private int reqCode;
    private final int CAMERA_ON=888;

    public static UploadDialogFragment newInstance(int code){
        UploadDialogFragment dialogFragment=new UploadDialogFragment();
        Bundle arg=new Bundle();
        arg.putInt("code",code);
        dialogFragment.setArguments(arg);
        return dialogFragment;

    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.image_upload_dialog,container,false);
        reqCode=getArguments().getInt("num");
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
                camera_image.setImageResource(R.drawable.upload_camera_checked);
                gallery_image.setImageResource(R.drawable.upload_gallery_unchecked);
                break;
            case R.id.gallery_image:
                chacked_status=2;
                camera_image.setImageResource(R.drawable.upload_camera_unchecked);
                gallery_image.setImageResource(R.drawable.upload_gallery_checked);
                break;
            case R.id.upload_dialog_cancel_button:
                getDialog().dismiss();
                break;
            case R.id.upload_dialog_ok_button:
                if(chacked_status==-1){
                    Toast.makeText(getContext(),R.string.upload_type,Toast.LENGTH_SHORT).show();
                }
                else if(chacked_status==1){
                    if(ContextCompat.checkSelfPermission(getActivity(),
                            Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED){
                        if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                                Manifest.permission.CAMERA)) {
                            ActivityCompat.requestPermissions(getActivity(),
                                    new String[]{Manifest.permission.CAMERA},
                                    CAMERA_ON);
                    }
                    else{
                            Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                            startActivityForResult(intent,chacked_status);
                    }
                    }

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
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){

            case CAMERA_ON:{
                if(grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent,chacked_status);

                }
                else {
                    Toast.makeText(getContext(),"I have no permission for opening your camera(((",Toast.LENGTH_SHORT).show();
                }

                return;
            }
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==1&&resultCode==RESULT_OK){
            bitmap=(Bitmap)data.getExtras().get("data");
            ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG,100,outputStream);
            byte[] byteArray=outputStream.toByteArray();
            Bundle bundle=new Bundle();
            bundle.putByteArray("bitmap",byteArray);
            Intent intent=new Intent()
                    .putExtra("bitmap",bundle);
            getTargetFragment().onActivityResult(getTargetRequestCode(), RESULT_OK, intent);
            dismiss();
            }
        else if(requestCode==2&&resultCode==RESULT_OK){
            Uri pickedImage = data.getData();

            String[] filePath = { MediaStore.Images.Media.DATA };
            Cursor cursor = getContext().getContentResolver().query(pickedImage, filePath, null, null, null);
            cursor.moveToFirst();
            String imagePath = cursor.getString(cursor.getColumnIndex(filePath[0]));

            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            Bitmap bitmap = BitmapFactory.decodeFile(imagePath, options);
            cursor.close();//karoxa petq lini verjum pakel
            ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG,100,outputStream);
            byte[] byteArray=outputStream.toByteArray();
            Bundle bundle=new Bundle();
            bundle.putByteArray("bitmap",byteArray);
            Intent intent=new Intent()
                    .putExtra("bitmap",bundle);
            getTargetFragment().onActivityResult(getTargetRequestCode(), RESULT_OK, intent);
            dismiss();

        }
        }
    }

