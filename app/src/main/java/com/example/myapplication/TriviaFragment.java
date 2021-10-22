package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.databinding.FragmentTriviaBinding;


public class TriviaFragment extends Fragment {

    private FragmentTriviaBinding binding;


    public static final String NAME_KEY_PARAM = "name";

    public TriviaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        initBinding(inflater,container);
        obtainNameParam();
        return binding.getRoot();
    }

    private void initBinding(LayoutInflater inflater, ViewGroup container) {
        binding = FragmentTriviaBinding.inflate(inflater,container,false);
    }

    private void obtainNameParam() {
        String name = getArguments().getString(NAME_KEY_PARAM);
        binding.tvTriviaUserName.setText("Bienvenido "+name+" responda la siguiente pregunta");


    }
}