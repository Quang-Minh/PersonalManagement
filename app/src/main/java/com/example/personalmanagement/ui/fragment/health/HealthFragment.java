package com.example.personalmanagement.ui.fragment.health;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.personalmanagement.R;
import com.example.personalmanagement.methodclass.Initialize;
import com.example.personalmanagement.ui.fragment.health.eating.EatingFragment;
import com.example.personalmanagement.ui.fragment.health.eating.MealsTodayFragment;
import com.example.personalmanagement.ui.fragment.health.eating.NewEatingFragment;
import com.example.personalmanagement.ui.fragment.health.fitness.ExercisesFragment;
import com.example.personalmanagement.ui.fragment.health.fitness.ExercisesTodayFragment;
import com.example.personalmanagement.ui.fragment.health.fitness.FitnessFragment;
import com.example.personalmanagement.ui.fragment.money.MoneyFragment;


public class HealthFragment extends Fragment implements Initialize, View.OnClickListener {


    CardView cardToEating, cardEatingToday, cardAddMeal, cardTofitness, cardExercisesToday, cardExercisesList, cardMealList, cardFitnessList;


    public HealthFragment() {
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
        View view = inflater.inflate(R.layout.fragment_health, container, false);
        initializeDatabase();
        initializeViews(view);
        cardTofitness.setOnClickListener(this);
        cardToEating.setOnClickListener(this);
        cardEatingToday.setOnClickListener(this);
        cardAddMeal.setOnClickListener(this);
        cardExercisesToday.setOnClickListener(this);
        cardExercisesList.setOnClickListener(this);
        cardFitnessList.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {

        if (cardToEating.equals(v)) {
            getActivity().getSupportFragmentManager().beginTransaction().
                    replace(R.id.fragment_health_root, new EatingFragment()).commit();
        } else if (cardTofitness.equals(v)) {
            getActivity().getSupportFragmentManager().beginTransaction().
                    replace(R.id.fragment_health_root, new FitnessFragment()).commit();
        } else if (cardAddMeal.equals(v)) {
            getActivity().getSupportFragmentManager().beginTransaction().
                    replace(R.id.fragment_health_root, new NewEatingFragment()).commit();
        } else if (cardEatingToday.equals(v)) {
            getActivity().getSupportFragmentManager().beginTransaction().
                    replace(R.id.fragment_health_root, new MealsTodayFragment()).commit();
        } else if (cardExercisesToday.equals(v)) {
            getActivity().getSupportFragmentManager().beginTransaction().
                    replace(R.id.fragment_health_root, new ExercisesTodayFragment()).commit();
        } else if (cardExercisesList.equals(v)) {
            getActivity().getSupportFragmentManager().beginTransaction().
                    replace(R.id.fragment_health_root, new ExercisesFragment()).commit();
        } else if (cardFitnessList.equals(v)) {
            getActivity().getSupportFragmentManager().beginTransaction().
                    replace(R.id.fragment_health_root, new FitnessFragment()).commit();
        }

    }

    @Override
    public void initializeViews(View view) {
        cardToEating = view.findViewById(R.id.cardToEating);
        cardTofitness = view.findViewById(R.id.cardToFitness);
        cardEatingToday = view.findViewById(R.id.cardMealMenuToday);
        cardAddMeal = view.findViewById(R.id.cardAddMeal);
        cardExercisesToday = view.findViewById(R.id.cardExercisesToday);
        cardExercisesList = view.findViewById(R.id.cardExercisesList);

        cardFitnessList = view.findViewById(R.id.cardFitnessList);
    }

    @Override
    public void initializeDatabase() {

    }
}