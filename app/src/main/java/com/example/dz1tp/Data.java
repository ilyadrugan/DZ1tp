package com.example.dz1tp;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.List;

public class Data {
    public List<ModelNumber> mData;
    private static Data sInstance;
    public Data(){
        mData=new ArrayList<>();
        int i;
        int C;
        for(i=1;i<101;i++){
            ModelNumber M=new ModelNumber();
            M.Num=Integer.toString(i);
            if (i%2==0){
                C= 0;
            }
            else{
                C= 1;
            }
            M.mColor=C;
            mData.add(M);
        }
    }

    public List<ModelNumber> get(){
        return mData;
    }
    public synchronized static Data getInstance(){
        if (sInstance==null){
            sInstance=new Data();
        }
        return sInstance;
    }
}
