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
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.personalmanagement.R;
import com.example.personalmanagement.methodclass.Initialize;


public class DetailFitnessFragment extends Fragment implements Initialize, View.OnClickListener, AdapterView.OnItemClickListener {

    final String keyName = "idFrag";
    TextView tvBack, tvDate, tvCountItem, tvDelete;
    ListView lvExercises;


    public DetailFitnessFragment() {
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
        View view = inflater.inflate(R.layout.fragment_detail_fitness, container, false);
        initializeDatabase();
        initializeViews(view);
        tvBack.setOnClickListener(this);
        lvExercises.setOnItemClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {

        if (getArguments().getInt(keyName) == FitnessFragment.idFrag) {
            if (tvBack.equals(v)) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_health_root, new FitnessFragment()).commit();
            } else if (tvDelete.equals(v)) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setMessage("Bạn muốn xóa hay sửa?");
                builder.setPositiveButton("Xóa", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getActivity(), "Xóa thành công!", Toast.LENGTH_LONG).show();
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_health_root, new FitnessFragment()).commit();
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
        } else if (getArguments().getInt(keyName) == ExercisesTodayFragment.idFrag) {

            if (tvBack.equals(v)) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_health_root, new ExercisesTodayFragment()).commit();
            } else if (tvDelete.equals(v)) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setMessage("Bạn muốn xóa hay sửa?");
                builder.setPositiveButton("Xóa", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getActivity(), "Xóa thành công!", Toast.LENGTH_LONG).show();
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_health_root, new ExercisesTodayFragment()).commit();
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
        }


    }

    @Override
    public void initializeViews(View view) {
        tvBack = view.findViewById(R.id.tvBack);
        tvCountItem = view.findViewById(R.id.tvCountItem);
        lvExercises = view.findViewById(R.id.lvExercises);
        tvDate = view.findViewById(R.id.tvDateFitness);
        tvDelete = view.findViewById(R.id.tvDelete);
    }

    @Override
    public void initializeDatabase() {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}