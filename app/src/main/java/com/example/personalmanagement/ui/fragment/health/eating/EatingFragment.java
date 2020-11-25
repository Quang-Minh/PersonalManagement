package com.example.personalmanagement.ui.fragment.health.eating;

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


public class EatingFragment extends Fragment implements Initialize, View.OnClickListener, AdapterView.OnItemClickListener {
    TextView tvBack, tvCurrentDate, tvCount;
    CardView cardToday;
    ListView lvEating;
    ImageView icAdd;

    public EatingFragment() {
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
        View view = inflater.inflate(R.layout.fragment_eating, container, false);
        initializeDatabase();
        initializeViews(view);
        tvCurrentDate.setText("Hôm nay, "+ CurrentDateTime.getCurrentDate());
        tvBack.setOnClickListener(this);
        lvEating.setOnItemClickListener(this);
        cardToday.setOnClickListener(this);
        icAdd.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if (tvBack.equals(v)){
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_health_root,new HealthFragment()).commit();
        }else if (cardToday.equals(v)){
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_health_root,new MealsTodayFragment()).commit();
        }else if (icAdd.equals(v)){
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_health_root,new NewEatingFragment()).commit();
        }

    }

    @Override
    public void initializeViews(View view) {
        cardToday=view.findViewById(R.id.cardEatingToday);
        tvBack=view.findViewById(R.id.tvBack);
        tvCount=view.findViewById(R.id.tvCountItem);
        lvEating=view.findViewById(R.id.lvEating);
        tvCurrentDate=view.findViewById(R.id.tvCurrentDate);
        icAdd=view.findViewById(R.id.icAdd);
    }

    @Override
    public void initializeDatabase() {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_health_root,new MealsFragment()).commit();
    }
}