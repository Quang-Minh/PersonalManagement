package com.example.personalmanagement.ui.fragment.health.fitness;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.personalmanagement.R;
import com.example.personalmanagement.methodclass.CurrentDateTime;
import com.example.personalmanagement.methodclass.Initialize;
import com.example.personalmanagement.ui.fragment.health.HealthFragment;
import com.example.personalmanagement.ui.fragment.health.eating.DetailMealFragment;
import com.example.personalmanagement.ui.fragment.health.eating.MealsTodayFragment;
import com.example.personalmanagement.ui.fragment.money.ExpensesTodayFragment;


public class FitnessFragment extends Fragment implements Initialize, View.OnClickListener, AdapterView.OnItemClickListener {

    public static final int idFrag = 1;
    final String keyName = "idFrag";
    TextView tvBack, tvCurrentDate, tvCountItem;
    CardView cardToday, cardExercisesList;
    ListView lvFitness;
    ImageView icAdd;

    public FitnessFragment() {
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
        View view = inflater.inflate(R.layout.fragment_fitness, container, false);
        initializeDatabase();
        initializeViews(view);

        tvCurrentDate.setText("Hôm nay, " + CurrentDateTime.getCurrentDate());
        tvBack.setOnClickListener(this);
        lvFitness.setOnItemClickListener(this);
        cardToday.setOnClickListener(this);
        cardExercisesList.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if (tvBack.equals(v)) {
            getActivity().getSupportFragmentManager().beginTransaction().
                    replace(R.id.fragment_health_root, new HealthFragment()).commit();
        } else if (cardToday.equals(v)) {
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_health_root, new ExercisesTodayFragment()).commit();
        } else if (cardExercisesList.equals(v)) {
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_health_root, new ExercisesFragment()).commit();
        }
    }

    @Override
    public void initializeViews(View view) {
        cardToday = view.findViewById(R.id.cardExercisesToday);
        cardExercisesList = view.findViewById(R.id.cardExercisesList);
        tvBack = view.findViewById(R.id.tvBack);
        tvCountItem = view.findViewById(R.id.tvCountItem);
        lvFitness = view.findViewById(R.id.lvFitness);
        tvCurrentDate = view.findViewById(R.id.tvCurrentDate);

    }

    @Override
    public void initializeDatabase() {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        DetailFitnessFragment detailFitnessFragment = new DetailFitnessFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(keyName, idFrag);
        detailFitnessFragment.setArguments(bundle);
        getActivity().getSupportFragmentManager().beginTransaction().
                replace(R.id.fragment_health_root, detailFitnessFragment).commit();
    }
}