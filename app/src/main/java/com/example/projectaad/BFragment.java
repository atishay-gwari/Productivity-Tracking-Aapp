package com.example.projectaad;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
public class BFragment extends Fragment {
    Spinner spinneradd;
    EditText edtdes, edthr;
    Button submitbtn;
    public BFragment() {// Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_b, container, false);

        spinneradd=view.findViewById(R.id.spineradd);
        edtdes=view.findViewById(R.id.edtdes);
        edthr=view.findViewById(R.id.edthr);
        submitbtn=view.findViewById(R.id.submitbtn);
        edtdes.addTextChangedListener(loginTextWatcher);
        edthr.addTextChangedListener(loginTextWatcher);

        Event e = new Event();
        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String category=spinneradd.getSelectedItem().toString();
//                assert !category.equals("Select Category");
                String description=edtdes.getText().toString();
                String duration=edthr.getText().toString();

                e.category=category;
                e.description=description;
                e.duration=duration;
                MainActivity m = (MainActivity) getActivity();
                assert m != null;
                m.receiveData(e);

                Toast.makeText(getContext(),"Task Added Successfully", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
    private TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String desc = edtdes.getText().toString();
            String duration = edthr.getText().toString();
            String category=spinneradd.getSelectedItem().toString();
            submitbtn.setEnabled(!category.equals("Select Category") && !desc.isEmpty() && !duration.isEmpty());
        }
        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}