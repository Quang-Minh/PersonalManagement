package com.example.personalmanagement.ui.fragment.money;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.personalmanagement.R;
import com.example.personalmanagement.methodclass.CurrentDateTime;
import com.example.personalmanagement.methodclass.Initialize;


public class IncomeFragment extends Fragment
        implements Initialize, View.OnClickListener {

    TextView tvBack, tvCurrentDate, tvCount, tv;
    ListView lvIncomes;
    ImageView icAdd;

    public IncomeFragment() {
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
        View view=inflater.inflate(R.layout.fragment_income, container, false);
        initializeViews(view);
        tvCurrentDate.setText("Hôm nay,"+ CurrentDateTime.getCurrentDate());
        tvBack.setOnClickListener(this);
        icAdd.setOnClickListener(this);
       tv.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if (tvBack.equals(v)) {
            getActivity().getSupportFragmentManager().beginTransaction().
                    replace(R.id.fragment_money_root, new MoneyFragment()).commit();
        } else if (icAdd.equals(v)) {
            getActivity().getSupportFragmentManager().beginTransaction().
                    replace(R.id.fragment_money_root, new AddIncomesFragment()).commit();
        } else if (tv.equals(v)) {
            getActivity().getSupportFragmentManager().beginTransaction().
                    replace(R.id.fragment_money_root, new DetailIncomeFragment()).commit();
        }


    }

    @Override
    public void initializeViews(View view) {
        tv=view.findViewById(R.id.tv);
        icAdd = view.findViewById(R.id.icAdd);
        tvBack = view.findViewById(R.id.tvBack);
        tvCount = view.findViewById(R.id.tvCountItem);
        lvIncomes = view.findViewById(R.id.lvIncomes);
        tvCurrentDate = view.findViewById(R.id.tvCurrentDate);
    }

    @Override
    public void initializeDatabase() {

    }
}