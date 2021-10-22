package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.myapplication.databinding.FragmentWelcomeBinding;


public class WelcomeFragment extends Fragment {

    private FragmentWelcomeBinding binding;
    public static final String NAME_KEY_PARAM = "name";
    




    public WelcomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        
        initBinding(inflater,container);
        setupOnClickListener();
        return binding.getRoot();
    }

    private void initBinding(LayoutInflater inflater, ViewGroup container) {
        binding = FragmentWelcomeBinding.inflate(inflater,container,false);
    }

    private void setupOnClickListener() {
        binding.btnComenzar.setOnClickListener(view -> {

            if(binding.etIngresarNombre.getText().toString().isEmpty()){
                Toast.makeText(getContext(),"Ingrese nombre",Toast.LENGTH_LONG).show();
                binding.etIngresarNombre.setError("Complete el campo");
                binding.etIngresarNombre.setFocusable(true);
            }else {
                goToTriviaFragment();
            }

        });

    }

    private void goToTriviaFragment() {
        Navigation.findNavController(binding.getRoot())
                .navigate(R.id.action_welcomeFragment_to_triviaFragment,getNameForTriviaParam());

    }

    private Bundle getNameForTriviaParam() {
        Bundle bundle = new Bundle();
        String name = binding.etIngresarNombre.getText().toString();
        bundle.putString(TriviaFragment.NAME_KEY_PARAM,name);
        return bundle;
    }
}