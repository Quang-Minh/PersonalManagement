package com.example.personalmanagement.ui.fragment.health.eating;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.personalmanagement.R;
import com.example.personalmanagement.methodclass.CurrentDateTime;
import com.example.personalmanagement.methodclass.Initialize;


public class AddMealFragment extends Fragment implements Initialize, View.OnClickListener {

    final String key = "idFrag";
    TextView tvBack, tvCurrentDate, tvDone;
    EditText edtTitle, edtTime, edtDate;
    ListView lvMeal;


    public AddMealFragment() {
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
        View view = inflater.inflate(R.layout.fragment_add_meal, container, false);
        initializeDatabase();
        initializeViews(view);
        tvCurrentDate.setText("Hôm nay, " + CurrentDateTime.getCurrentDate());
        tvDone.setOnClickListener(this);
        tvBack.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {

        if (getArguments().getInt(key) == NewEatingFragment.idFrag) {
            if (tvBack.equals(v)) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_health_root, new NewEatingFragment()).commit();
            } else if (tvDone.equals(v)) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_health_root, new NewEatingFragment()).commit();
            }
        } else if (getArguments().getInt(key) == MealsTodayFragment.idFrag) {
            if (tvBack.equals(v)) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_health_root, new MealsTodayFragment()).commit();
            } else if (tvDone.equals(v)) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_health_root, new MealsTodayFragment()).commit();
            }
        } else if (getArguments().getInt(key) == MealsFragment.idFrag) {
            if (tvBack.equals(v)) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_health_root, new MealsFragment()).commit();
            } else if (tvDone.equals(v)) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_health_root, new MealsFragment()).commit();
            }
        }


    }

    @Override
    public void initializeViews(View view) {
        tvBack = view.findViewById(R.id.tvBack);
        tvDone = view.findViewById(R.id.tvDone);
        tvCurrentDate = view.findViewById(R.id.tvCurrentDate);
    }

    @Override
    public void initializeDatabase() {

    }
}