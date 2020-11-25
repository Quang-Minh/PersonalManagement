package com.example.personalmanagement.ui.fragment.money;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.personalmanagement.R;
import com.example.personalmanagement.methodclass.CurrentDateTime;
import com.example.personalmanagement.methodclass.Initialize;
import com.example.personalmanagement.ui.fragment.notes.NoteFoldersFragment;


public class ExpenseFragment extends Fragment implements Initialize, View.OnClickListener, AdapterView.OnItemClickListener {
    TextView tvBack, tvCurrentDate, tvCount;
    CardView cardToday;
    ListView lvExpenses;


    public ExpenseFragment() {
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
        View view = inflater.inflate(R.layout.fragment_expense, container, false);
        initializeViews(view);
        cardToday.setOnClickListener(this);
        tvBack.setOnClickListener(this);
        lvExpenses.setOnItemClickListener(this);
        tvCurrentDate.setText(CurrentDateTime.getCurrentDate());
        return view;
    }



    @Override
    public void initializeViews(View view) {
       cardToday= view.findViewById(R.id.cardExpensesToday);
       tvBack= view.findViewById(R.id.tvBack);
       tvCount= view.findViewById(R.id.tvCountItem);
       lvExpenses=view.findViewById(R.id.lvExpenses);
       tvCurrentDate=view.findViewById(R.id.tvCurrentDate);
    }

    @Override
    public void initializeDatabase() {

    }

    @Override
    public void onClick(View v) {
        if (tvBack.equals(v)) {
            getActivity().getSupportFragmentManager().beginTransaction().
                    replace(R.id.fragment_money_root, new MoneyFragment()).commit();
        }else  if (cardToday.equals(v)) {
            getActivity().getSupportFragmentManager().beginTransaction().
                    replace(R.id.fragment_money_root, new ExpensesTodayFragment()).commit();
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}