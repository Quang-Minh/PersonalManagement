package com.example.personalmanagement.ui.fragment.money;

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


public class ExpensesTodayFragment extends Fragment
        implements Initialize, View.OnClickListener, AdapterView.OnItemClickListener {

    TextView tvBack, tvCurrentDate, tvCount;
    ListView lvExpenses;
    ImageView icAdd;

    public ExpensesTodayFragment() {
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
        View view = inflater.inflate(R.layout.fragment_expenses_today, container, false);
        initializeViews(view);
        initializeDatabase();
        tvCurrentDate.setText(CurrentDateTime.getCurrentDate());
        tvBack.setOnClickListener(this);
        lvExpenses.setOnItemClickListener(this);
        icAdd.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View v) {
        if (tvBack.equals(v)) {
            getActivity().getSupportFragmentManager().beginTransaction().
                    replace(R.id.fragment_money_root, new ExpenseFragment()).commit();
        } else if (icAdd.equals(v)) {
            getActivity().getSupportFragmentManager().beginTransaction().
                    replace(R.id.fragment_money_root, new AddExpenseFragment()).commit();
        }


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void initializeViews(View view) {
        icAdd = view.findViewById(R.id.icAdd);
        tvBack = view.findViewById(R.id.tvBack);
        tvCount = view.findViewById(R.id.tvCountItem);
        lvExpenses = view.findViewById(R.id.lvExpenses);
        tvCurrentDate = view.findViewById(R.id.tvCurrentDate);
    }

    @Override
    public void initializeDatabase() {

    }
}