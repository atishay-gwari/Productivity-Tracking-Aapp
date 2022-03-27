package com.example.projectaad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bnv;
    ArrayList<Event> ev = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bnv=findViewById(R.id.nav);
        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id=item.getItemId();
                if(id==R.id.Home){
                    loadfragment(new AFragment(ev));
                }
                else if(id==R.id.add){
                    loadfragment(new BFragment());

                }
                else if(id==R.id.calendar){
                    loadfragment(new CFragment());

                }
                else{
                    loadfragment(new DFragment());
                }
                return true;
            }
        });
        bnv.setSelectedItemId(R.id.Home);
    }
    public void loadfragment(Fragment fragment){
        FragmentManager fm= getSupportFragmentManager();
        FragmentTransaction ft= fm.beginTransaction();
        ft.replace(R.id.container,fragment);
        ft.commit();
    }

    public void receiveData(Event e)
    {
        ev.add(e);
    }

}