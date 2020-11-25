package com.example.personalmanagement.ui.fragment.money;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.TextView;

import com.example.personalmanagement.R;
import com.example.personalmanagement.methodclass.Initialize;


public class AddExpenseFragment extends Fragment
        implements Initialize, AdapterView.OnItemClickListener, View.OnClickListener {
    TextView tvBack, tvDone, tvDate;
    EditText edtTitle, edtAmount, edtDescribe;


    public AddExpenseFragment() {
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
        View view = inflater.inflate(R.layout.fragment_add_expense, container, false);
        initializeDatabase();
        initializeViews(view);
         tvDone.setOnClickListener(this);
         tvBack.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if (tvBack.equals(v)) {
            getActivity().getSupportFragmentManager().beginTransaction().
                    replace(R.id.fragment_money_root, new ExpensesTodayFragment()).commit();
        } else if (tvDone.equals(v)) {
            getActivity().getSupportFragmentManager().beginTransaction().
                    replace(R.id.fragment_money_root, new ExpensesTodayFragment()).commit();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void initializeViews(View view) {
        tvBack = view.findViewById(R.id.tvBack);
        tvDone = view.findViewById(R.id.tvDone);
        tvDate = view.findViewById(R.id.tvCurrentDate);
        edtTitle = view.findViewById(R.id.edtExpenseTitle);
        edtAmount = view.findViewById(R.id.edtAmount);
        edtDescribe = view.findViewById(R.id.edtDescribe);


    }

    @Override
    public void initializeDatabase() {

    }
}