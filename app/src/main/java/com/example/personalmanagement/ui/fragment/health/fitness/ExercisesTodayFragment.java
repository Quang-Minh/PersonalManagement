package com.example.personalmanagement.ui.fragment.health.fitness;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.personalmanagement.R;
import com.example.personalmanagement.methodclass.CurrentDateTime;
import com.example.personalmanagement.methodclass.Initialize;
import com.example.personalmanagement.ui.fragment.health.eating.AddMealFragment;
import com.example.personalmanagement.ui.fragment.health.eating.EatingFragment;


public class ExercisesTodayFragment extends Fragment
        implements Initialize, View.OnClickListener, AdapterView.OnItemClickListener{

    public static final int idFrag = 2;
    final String keyName ="idFrag";
    TextView tvBack, tvCurrentDate, tvCountItem;
    EditText edtSearch;
    ListView lvExercises;
    ImageView icAdd;
    public ExercisesTodayFragment() {
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
        View view=inflater.inflate(R.layout.fragment_exercises_today, container, false);
        initializeDatabase();
        initializeViews(view);
        tvCurrentDate.setText("Hôm nay, "+ CurrentDateTime.getCurrentDate());
        tvBack.setOnClickListener(this);
        lvExercises.setOnItemClickListener(this);
        icAdd.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if (tvBack.equals(v)){
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_health_root,new FitnessFragment()).commit();
        }else if (icAdd.equals(v)){
           addExercise();

        }
    }

    private void addExercise() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View view = getLayoutInflater().inflate(R.layout.layout_dialog_add_exercise, null);
        builder.setView(view);
        String[] arrExercises={"Chọn bài tập", "Hít đất","Đẩy tạ", "Kéo xà","Chạy bộ"};
        Spinner spinner = view.findViewById(R.id.spnSelectExercise);
        EditText edtAmount= view.findViewById(R.id.edtAmountDoExercise);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_dropdown_item_1line,arrExercises);
        spinner.setAdapter(adapter);
        builder.setPositiveButton("Lưu", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                builder.create().dismiss();
            }
        });
        builder.show();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        DetailFitnessFragment detailFitnessFragment = new DetailFitnessFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(keyName, idFrag);
        detailFitnessFragment.setArguments(bundle);
        getActivity().getSupportFragmentManager().beginTransaction().
                replace(R.id.fragment_health_root, detailFitnessFragment).commit();
    }

    @Override
    public void initializeViews(View view) {
        edtSearch=view.findViewById(R.id.edtSearch);
        tvBack = view.findViewById(R.id.tvBack);
        tvCountItem = view.findViewById(R.id.tvCountItem);
        lvExercises = view.findViewById(R.id.lvExercises);
        tvCurrentDate = view.findViewById(R.id.tvCurrentDate);
        icAdd = view.findViewById(R.id.icAdd);
    }


    @Override
    public void initializeDatabase() {

    }
}