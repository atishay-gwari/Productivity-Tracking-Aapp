package com.example.projectaad;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
public class DFragment extends Fragment {
    Spinner spinnermood;
    Button rsc;
    Button music;
    public DFragment() {
        // Required empty public constructor

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_d, container, false);

        spinnermood=view.findViewById(R.id.spinnermood);
        rsc=view.findViewById(R.id.rsc);
        music=view.findViewById(R.id.music);

        Intent sendUrl=new Intent(getActivity(), wv.class);
        rsc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mood=spinnermood.getSelectedItem().toString();

                switch(mood)
                {
                    case "Downhearted": {
                        sendUrl.putExtra("URL", "https://www.mentalhealth.gov/");
                        startActivity(sendUrl);
                        break;
                    }

                    case "Rejected?": {
                        sendUrl.putExtra("URL", "https://www.youtube.com/watch?v=BBJa32lCaaY");
                        startActivity(sendUrl);
                        break;
                    }

                    case "Workout": {
                        sendUrl.putExtra("URL", "https://youtu.be/sYZHBc8ItSs?list=PLX8QIwhN83ZXRbmrql6WqHTrVXSmsdVhd");
                        startActivity(sendUrl);
                        break;
                    }

                    case "Joyful":{
                        Toast.makeText(getContext(),"Enjoy Your Day!!", Toast.LENGTH_SHORT).show();
                        break;}

                    default:{
                        Toast.makeText(getContext(),"Please Choose A Category!!", Toast.LENGTH_SHORT).show();
                        break;}


                }

//                startActivity(sendUrl);
            }
        });
        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mood=spinnermood.getSelectedItem().toString();

                switch(mood) {
                    case "Downhearted":{
                        sendUrl.putExtra("URL", "https://open.spotify.com/playlist/37i9dQZF1DX3rxVfibe1L0?si=bc78ecff7e094093");
                        startActivity(sendUrl);
                        break;}

                    case "Rejected?":{
                        sendUrl.putExtra("URL", "https://www.youtube.com/watch?v=BBJa32lCaaY");
                        startActivity(sendUrl);
                        break;}

                    case "Workout":{
                        sendUrl.putExtra("URL", "https://open.spotify.com/playlist/37i9dQZF1DX76Wlfdnj7AP?si=456ad746e4d845c3");
                        startActivity(sendUrl);
                        break;}

                    case "Joyful": {
                        sendUrl.putExtra("URL", "https://open.spotify.com/playlist/37i9dQZF1DX9XIFQuFvzM4?si=fa2c094ad3134f10");
                        startActivity(sendUrl);
                        break;
                    }

                    default:{
                        Toast.makeText(getContext(), "Please Choose A Category!!", Toast.LENGTH_SHORT).show();

                        break;
                }
                }

//                startActivity(sendUrl);
            }
        });
        return view;
    }
}