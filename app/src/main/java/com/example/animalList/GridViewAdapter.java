package com.example.animalList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Toast;

public class GridViewAdapter extends BaseAdapter {

    private Context mContext;
    private static final int[] mImages = {
            R.drawable.ic_angel_face, R.drawable.ic_evil_face, R.drawable.ic_inspired_face,
            R.drawable.ic_kiss_face, R.drawable.ic_heart_eyes, R.drawable.ic_money_face,
            R.drawable.ic_kiss_face, R.drawable.ic_sad_face, R.drawable.ic_vomit_face
    };

    public GridViewAdapter(Context context) {
        mContext = context;
    }

    @Override
    public int getCount() {
        return mImages.length;
    }

    @Override
    public Object getItem(int position) {
        return mImages[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View gridViewItem;
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            gridViewItem = inflater.inflate(R.layout.grid_item, parent, false);
        } else {
            gridViewItem = convertView;
        }

        ImageView imageView = gridViewItem.findViewById(R.id.iv_emoji_placeholder);
        imageView.setImageResource(mImages[position]);

        gridViewItem.setOnClickListener(v -> {
            showCustomToast(mImages[position]);
        });

        return gridViewItem;
    }

    private void showCustomToast(int imageResource) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View toastView = inflater.inflate(R.layout.custom_toast, null);

        ImageView imageView = toastView.findViewById(R.id.iv_toast);
        imageView.setImageResource(imageResource);

        Toast toast = new Toast(mContext);
        toast.setView(toastView);
        toast.show();
    }
}
