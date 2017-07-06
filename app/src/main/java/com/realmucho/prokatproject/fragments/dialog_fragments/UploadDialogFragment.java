package com.realmucho.prokatproject.fragments.dialog_fragments;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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
import java.io.IOException;

import static android.app.Activity.RESULT_OK;


public class UploadDialogFragment extends DialogFragment implements View.OnClickListener {

    private ImageView mCameraImage, mGalleryImage;
    private Button mUploadCancel, mUploadOk;
    private int mChackedStatus = -1;
    private Bitmap mBitmap;
    private int mReqCode;
    private final static int CAMERA_ON = 888, GALLERY_ON = 999;
    private boolean mBoolDismiss = false;

    public static UploadDialogFragment newInstance(int code) {
        UploadDialogFragment dialogFragment = new UploadDialogFragment();
        Bundle arg = new Bundle();
        arg.putInt("code", code);
        dialogFragment.setArguments(arg);
        return dialogFragment;

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.image_upload_dialog, container, false);
        init(view);
        setupClicks();
        return view;
    }

    private void init(View view) {
        mReqCode = getArguments().getInt("num");
        mCameraImage = (ImageView) view.findViewById(R.id.camera_image);
        mGalleryImage = (ImageView) view.findViewById(R.id.gallery_image);
        mUploadCancel = (Button) view.findViewById(R.id.upload_dialog_cancel_button);
        mUploadOk = (Button) view.findViewById(R.id.upload_dialog_ok_button);
    }

    private void setupClicks() {
        mCameraImage.setOnClickListener(this);
        mGalleryImage.setOnClickListener(this);
        mUploadCancel.setOnClickListener(this);
        mUploadOk.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.camera_image:
                mChackedStatus = 1;
                mCameraImage.setImageResource(R.drawable.upload_camera_checked);
                mGalleryImage.setImageResource(R.drawable.upload_gallery_unchecked);
                break;
            case R.id.gallery_image:
                mChackedStatus = 2;
                mCameraImage.setImageResource(R.drawable.upload_camera_unchecked);
                mGalleryImage.setImageResource(R.drawable.upload_gallery_checked);
                break;
            case R.id.upload_dialog_cancel_button:
                getDialog().dismiss();
                break;
            case R.id.upload_dialog_ok_button:
                if (mChackedStatus == -1) {
                    Toast.makeText(getContext(), R.string.upload_type, Toast.LENGTH_SHORT).show();
                } else if (mChackedStatus == 1) {
                    if (ContextCompat.checkSelfPermission(getActivity(),
                            Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                        requestPermissions(new String[]{Manifest.permission.CAMERA}, CAMERA_ON);
                    } else {
                        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(intent, mChackedStatus);
                    }

                } else if (mChackedStatus == 2) {
                    if (ContextCompat.checkSelfPermission(getActivity(),
                            Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                        requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, GALLERY_ON);
                    } else {
                        Intent intent = new Intent(Intent.ACTION_PICK);
                        intent.setType("image/*");
                        startActivityForResult(intent, mChackedStatus);
                    }
                }
                break;
        }
    }


    @Override
    public void onResume() {
        super.onResume();
        /**Illegal statement error solution(cant dismiss while dialogFragment is in onCreate)*/
        if (mBoolDismiss) {
            mBoolDismiss = false;
            dismiss();
        }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1 && resultCode == RESULT_OK) {
            mBitmap = (Bitmap) data.getExtras().get("data");
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            mBitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
            byte[] byteArray = outputStream.toByteArray();
            Intent intent = new Intent()
                    .putExtra("bitmap", byteArray);
            getTargetFragment().onActivityResult(getTargetRequestCode(), RESULT_OK, intent);
            mBoolDismiss = true;
        } else if (requestCode == 2 && resultCode == RESULT_OK) {
            Uri pickedImage = data.getData();
            Bitmap bitmap = null;
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContext().getContentResolver(), pickedImage);
            } catch (IOException e) {
                e.printStackTrace();
            }

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
            byte[] byteArray = outputStream.toByteArray();
            Intent intent = new Intent().putExtra("bitmap", byteArray);
            getTargetFragment().onActivityResult(getTargetRequestCode(), RESULT_OK, intent);
            mBoolDismiss = true;


        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {

            case CAMERA_ON: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent, mChackedStatus);

                } else {
                    Toast.makeText(getContext(), R.string.camera_permission_deny, Toast.LENGTH_SHORT).show();
                }

                return;
            }


            case GALLERY_ON: {

                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Intent intent = new Intent(Intent.ACTION_PICK);
                    intent.setType("image/*");
                    startActivityForResult(intent, mChackedStatus);

                } else {
                    Toast.makeText(getContext(), R.string.gallery_permission_deny, Toast.LENGTH_SHORT).show();
                }
                return;


            }

        }
    }
}

