package com.example.personalmanagement.ui.fragment.health.eating;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.personalmanagement.R;
import com.example.personalmanagement.methodclass.CurrentDateTime;
import com.example.personalmanagement.methodclass.Initialize;
import com.example.personalmanagement.ui.fragment.health.HealthFragment;


public class MealsTodayFragment extends Fragment implements Initialize, View.OnClickListener, AdapterView.OnItemClickListener {

    public static final int idFrag = 2;
    TextView tvBack, tvCurrentDate, tvCount;
    EditText edtSearch;
    ListView lvMeal;
    ImageView icAdd;

    public MealsTodayFragment() {
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
        View view = inflater.inflate(R.layout.fragment_meals_today, container, false);
        initializeDatabase();
        initializeViews(view);
        tvCurrentDate.setText("Hôm nay, "+ CurrentDateTime.getCurrentDate());
        tvBack.setOnClickListener(this);
        lvMeal.setOnItemClickListener(this);
        icAdd.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if (tvBack.equals(v)){
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_health_root,new EatingFragment()).commit();
        }else if (icAdd.equals(v)){
            AddMealFragment addMealFragment = new AddMealFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("idFrag", idFrag);
            addMealFragment.setArguments(bundle);
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_health_root, addMealFragment).commit();

        }
    }

    @Override
    public void initializeViews(View view) {
        edtSearch=view.findViewById(R.id.edtSearch);
        tvBack = view.findViewById(R.id.tvBack);
        tvCount = view.findViewById(R.id.tvCountItem);
        lvMeal = view.findViewById(R.id.lvMeal);
        tvCurrentDate = view.findViewById(R.id.tvCurrentDate);
        icAdd = view.findViewById(R.id.icAdd);
    }

    @Override
    public void initializeDatabase() {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        DetailMealFragment detailMealFragment = new DetailMealFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("idFrag", idFrag);
        detailMealFragment.setArguments(bundle);
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_health_root, detailMealFragment).commit();
    }
}