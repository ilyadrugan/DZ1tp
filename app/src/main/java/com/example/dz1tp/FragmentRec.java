package com.example.dz1tp;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragmentRec extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.rec_fragment, container, false);
        setRetainInstance(true);
        RecyclerView rec = view.findViewById(R.id.recycler);
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
            rec.setLayoutManager(new GridLayoutManager(getActivity(), 3, RecyclerView.VERTICAL, false));
        else if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
            rec.setLayoutManager(new GridLayoutManager(getActivity(), 4, RecyclerView.VERTICAL, false));
        NumbersAdapter adapter = new NumbersAdapter();
        rec.setAdapter(adapter);

        ModelNumber M = new ModelNumber();
        Button ButtonAdd = view.findViewById(R.id.b1);
        ButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int k = adapter.getItemCount();
                int C;
                if ((k + 1) % 2 == 0) {
                    C = 0;
                } else {
                    C = 1;
                }
                ModelNumber M = new ModelNumber();
                M.mColor = C;
                M.Num = Integer.toString(k + 1);
                adapter.data.add(M);
                adapter.notifyItemInserted(k + 1);
                Toast.makeText(getActivity(), "added!", Toast.LENGTH_LONG).show();
            }
        });
              return view;
    }
}
