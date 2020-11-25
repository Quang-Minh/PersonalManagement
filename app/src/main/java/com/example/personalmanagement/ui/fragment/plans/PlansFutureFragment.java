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
import com.example.personalmanagement.methodclass.Initialize;


public class PlansFutureFragment extends Fragment implements Initialize,View.OnClickListener, AdapterView.OnItemClickListener {

    public static final int idFrag=3;
    final String keyName = "idFrag";
    TextView tvBack, tvDone;
    ImageView icAdd;
    ListView lvPlans;

    public PlansFutureFragment() {
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
        View view = inflater.inflate(R.layout.fragment_plans_future, container, false);
        initializeViews(view);
        tvBack.setOnClickListener(this);
        tvDone.setOnClickListener(this);
        icAdd.setOnClickListener(this);
        lvPlans.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        if (tvBack.equals(view)){
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_plans_root,new PlansFragment()).commit();
        }else if (tvDone.equals(view)){
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_plans_root,new PlansFragment()).commit();
        }
        else if (icAdd.equals(view)){
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_plans_root,new AddPlansFragment()).commit();
        }
    }

    @Override
    public void initializeViews(View view) {
     tvDone = view.findViewById(R.id.tvDone);
     tvBack= view.findViewById(R.id.tvBack);
     icAdd= view.findViewById(R.id.icAdd);
     lvPlans=view.findViewById(R.id.lvPlans);
    }

    @Override
    public void initializeDatabase() {

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