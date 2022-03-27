package com.example.projectaad;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
public class AFragment extends Fragment {
    ArrayList<Event> ev = new ArrayList<>();
//    LinearLayout layout;
    RecyclerView recycler;
//    Button refresh;

    public AFragment(ArrayList<Event> a) {
        // Required empty public constructor
        ev=a;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_a, container, false);
//        layout=view.findViewById(R.id.linlay);
        recycler=view.findViewById(R.id.recycler);


        recycler.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        RecyclerView.Adapter adapter = new MainAdapter(ev);
        recycler.setLayoutManager(layoutManager);
        recycler.setAdapter(adapter);

        return view;
    }



//    public void addCard(Event event)
//    {
//        View view=getLayoutInflater().inflate(R.layout.card_view, null);
//
//        TextView categ=view.findViewById(R.id.categ);
//        TextView desc=view.findViewById(R.id.desc);
//        TextView dur=view.findViewById(R.id.dur);
//
//        categ.setText("Category: "+event.category);
//        desc.setText("Description: "+event.description);
//        dur.setText("Duration: "+event.duration+" hr");
//
//        layout.addView(view);
//
//    }

}