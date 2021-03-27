package com.example.dz1tp;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

public class NumbersVH extends RecyclerView.ViewHolder implements View.OnClickListener {
    int[] mColors = new int[]{
            Color.RED,
            Color.BLUE
    };
    public TextView num;

    public NumbersVH(@NonNull View itemView) {
        super(itemView);
        num = itemView.findViewById(R.id.ButtonNum);
        num.setOnClickListener((View.OnClickListener) this);
    }

    public void bind(ModelNumber M) {
        num.setText(M.Num);
        num.setTextColor(mColors[M.mColor]);
        num.setBackgroundColor(Color.WHITE);
    }
    public int position;

    @Override
    public void onClick(View v) {
        position =getAdapterPosition();
        if (position != RecyclerView.NO_POSITION) {
            FragmentTransaction fragmentTransaction;
            FragmentItem fragment2 = new FragmentItem();
            AppCompatActivity activity = (AppCompatActivity) v.getContext();
            fragmentTransaction = activity.getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.container, fragment2);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            Bundle bundle = new Bundle();
            bundle.putInt("Number", position+1);
            if((position+1)%2==1)
                bundle.putInt("Color", Color.BLUE);
            else
                bundle.putInt("Color", Color.RED);
            fragment2.setArguments(bundle);
        }

    }
}