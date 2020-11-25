package com.example.personalmanagement.ui.fragment.health.eating;

import android.os.Bundle;

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
import com.example.personalmanagement.methodclass.Initialize;
import com.example.personalmanagement.ui.fragment.money.ExpenseFragment;

public class MealsFragment extends Fragment implements Initialize, View.OnClickListener, AdapterView.OnItemClickListener {

    public static final int idFrag = 3;
    final String key = "idFrag";

    TextView tvBack, tvEdit, tvDate, tvDelete;
    ListView lvMeal;
    ImageView icAdd;
    int isEditing = 0;


    public MealsFragment() {
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
        View view = inflater.inflate(R.layout.fragment_meals, container, false);
        initializeDatabase();
        initializeViews(view);

        tvEdit.setOnClickListener(this);
        tvBack.setOnClickListener(this);
        tvDelete.setOnClickListener(this);
        icAdd.setOnClickListener(this);
        lvMeal.setOnItemClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if (tvBack.equals(v)) {
            getActivity().getSupportFragmentManager().beginTransaction().
                    replace(R.id.fragment_health_root, new EatingFragment()).commit();
        } else if (tvEdit.equals(v)) {
            edit();
        } else if (tvDelete.equals(v)) {
            Toast.makeText(getActivity(), "Xóa thành công!", Toast.LENGTH_LONG).show();
            getActivity().getSupportFragmentManager().beginTransaction().
                    replace(R.id.fragment_health_root, new EatingFragment()).commit();
        } else if (icAdd.equals(v)) {
            AddMealFragment addMealFragment = new AddMealFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("idFrag", idFrag);
            addMealFragment.setArguments(bundle);
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_health_root, addMealFragment).commit();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        DetailMealFragment detailMealFragment = new DetailMealFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("idFrag", idFrag);
        detailMealFragment.setArguments(bundle);
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_health_root, detailMealFragment).commit();
    }

    @Override
    public void initializeViews(View view) {
        tvDelete = view.findViewById(R.id.tvDelete);
        tvBack = view.findViewById(R.id.tvBack);
        tvEdit = view.findViewById(R.id.tvEdit);
        tvDate = view.findViewById(R.id.tvChooseDate);
        lvMeal = view.findViewById(R.id.lvMeal);

    }

    @Override
    public void initializeDatabase() {

    }

    private void edit() {
        if (isEditing == 0) {
            tvEdit.setText("Xong");
            tvDate.setEnabled(true);
            isEditing = 1;
        } else if (isEditing == 1) {
            tvEdit.setText("Sửa");
            tvDate.setEnabled(false);
            isEditing = 0;
            Toast.makeText(getActivity(), "Cập nhật thành công!", Toast.LENGTH_LONG).show();
        }

    }
}