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
import android.widget.Toast;

import com.example.personalmanagement.R;
import com.example.personalmanagement.methodclass.CurrentDateTime;
import com.example.personalmanagement.methodclass.Initialize;
import com.example.personalmanagement.ui.fragment.health.HealthFragment;


public class DetailMealFragment extends Fragment implements Initialize, View.OnClickListener {

    TextView tvBack, tvEdit, tvCurrentDate, tvTime, tvDate, tvDelete;
    EditText edtMealTitle, edtMenu;
    int isEditing = 0;
    final String keyName="idFrag";


    public DetailMealFragment() {
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
        View view = inflater.inflate(R.layout.fragment_detail_meal, container, false);
        initializeDatabase();
        initializeViews(view);
        tvCurrentDate.setText("Hôm nay, " + CurrentDateTime.getCurrentDate());
        tvBack.setOnClickListener(this);
        tvDate.setOnClickListener(this);
        tvTime.setOnClickListener(this);
        tvDelete.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if (tvBack.equals(v)) {
            if (getArguments().getInt(keyName)==MealsFragment.idFrag){
                getActivity().getSupportFragmentManager().beginTransaction().
                        replace(R.id.fragment_health_root, new MealsFragment()).commit();
            }else if (getArguments().getInt(keyName)==NewEatingFragment.idFrag){
                getActivity().getSupportFragmentManager().beginTransaction().
                        replace(R.id.fragment_health_root, new NewEatingFragment()).commit();
            }else if (getArguments().getInt(keyName)==MealsTodayFragment.idFrag){
                getActivity().getSupportFragmentManager().beginTransaction().
                        replace(R.id.fragment_health_root, new MealsTodayFragment()).commit();
            }

        } else if (tvEdit.equals(v)) {
            edit();
        } else if (tvTime.equals(v)) {
            chooseTime();
        } else if (tvDate.equals(v)) {
            chooseDate();
        }


    }

    private void chooseTime() {
    }

    private void chooseDate() {
    }

    @Override
    public void initializeViews(View view) {
        tvDate = view.findViewById(R.id.tvDelete);
        tvBack = view.findViewById(R.id.tvBack);
        tvEdit = view.findViewById(R.id.tvEdit);
        tvDate = view.findViewById(R.id.tvChooseDate);
        tvTime = view.findViewById(R.id.tvChooseTime);
        tvCurrentDate = view.findViewById(R.id.tvCurrentDate);
        edtMealTitle = view.findViewById(R.id.edtMealTitle);
        edtMenu = view.findViewById(R.id.edtDescribe);


    }

    @Override
    public void initializeDatabase() {

    }

    private void edit() {
        if (isEditing == 0) {
            tvEdit.setText("Xong");
            edtMealTitle.setEnabled(true);
            tvDate.setEnabled(true);
            tvTime.setEnabled(true);
            edtMenu.setEnabled(true);
            isEditing = 1;
        } else if (isEditing == 1) {
            tvEdit.setText("Sửa");
            edtMealTitle.setEnabled(false);
            tvDate.setEnabled(false);
            tvTime.setEnabled(false);
            edtMenu.setEnabled(false);
            isEditing = 0;
            Toast.makeText(getActivity(), "Cập nhật thành công!", Toast.LENGTH_LONG).show();
        }

    }
}