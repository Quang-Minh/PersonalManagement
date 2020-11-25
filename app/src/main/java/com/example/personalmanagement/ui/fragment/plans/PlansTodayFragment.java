package com.example.personalmanagement.ui.fragment.plans;

import android.os.Bundle;

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


public class PlansTodayFragment extends Fragment implements Initialize, View.OnClickListener , AdapterView.OnItemClickListener {

    public static final int idFrag=1;
    final String keyName = "idFrag";
    TextView tvDateToday, tvDone;
    ListView lvPlansToday;
    ImageView icAdd;
    public PlansTodayFragment() {
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
        View view = inflater.inflate(R.layout.fragment_plans_today, container, false);
        initializeViews(view);
        tvDateToday.setText(CurrentDateTime.getCurrentDate());
        tvDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_plans_root,new PlansFragment()).commit();
            }
        });
        lvPlansToday.setOnItemClickListener(this);
        icAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_plans_root,new AddWorkFragment()).commit();
            }
        });




        return view;
    }

    @Override
    public void initializeViews(View view) {
        tvDateToday = view.findViewById(R.id.tvDateToday);
        tvDone = view.findViewById(R.id.tvDone);

        lvPlansToday = view.findViewById(R.id.lvPlansToday);
        icAdd = view.findViewById(R.id.icAdd);
    }

    @Override
    public void initializeDatabase() {

    }

    @Override
    public void onClick(View view) {
       if (tvDone.equals(view)){
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_plans_root,new PlansFragment()).commit();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        DetailPlansFragment detailPlansFragment = new DetailPlansFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(keyName,idFrag);
        detailPlansFragment.setArguments(bundle);
        getActivity().getSupportFragmentManager().beginTransaction().
                replace(R.id.fragment_plans_root, detailPlansFragment).commit();
    }
}