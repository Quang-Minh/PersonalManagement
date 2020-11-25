package com.example.personalmanagement.ui.fragment.money;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.personalmanagement.R;
import com.example.personalmanagement.methodclass.CurrentDateTime;
import com.example.personalmanagement.methodclass.Initialize;


public class StatisticalFragment extends Fragment implements Initialize, View.OnClickListener {

    TextView tvBack, tvTotalExpenses, tvTotalIncomes, tvCurrentDate, tvStartDate, tvEndDate;
    Button btnSearch;


    public StatisticalFragment() {
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
        View view = inflater.inflate(R.layout.fragment_statistical2, container, false);
        initializeDatabase();
        initializeViews(view);
        tvCurrentDate.setText("Hôm nay, " + CurrentDateTime.getCurrentDate());
        tvBack.setOnClickListener(this);
        btnSearch.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View view) {
        if (tvBack.equals(view)) {
            getActivity().getSupportFragmentManager().beginTransaction().
                    replace(R.id.fragment_money_root, new MoneyFragment()).commit();
        } else if (btnSearch.equals(view)) {
            search();
        } else if (tvStartDate.equals(view)) {
            chooseDate();
        } else if (tvEndDate.equals(view)) {
            chooseDate();
        }
    }

    private void chooseDate() {

    }

    private void search() {
    }

    @Override
    public void initializeViews(View view) {
        tvStartDate = view.findViewById(R.id.tvStartDate);
        tvEndDate = view.findViewById(R.id.tvEndDate);
        btnSearch = view.findViewById(R.id.btnStatisticSearch);
        tvCurrentDate = view.findViewById(R.id.tvCurrentDate);
        tvBack = view.findViewById(R.id.tvBack);
        tvTotalExpenses = view.findViewById(R.id.tvStatisticalTotalExpenses);
        tvTotalIncomes = view.findViewById(R.id.tvStatisticalTotalIncomes);

    }

    @Override
    public void initializeDatabase() {

    }
}