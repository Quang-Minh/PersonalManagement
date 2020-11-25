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
import android.widget.Toast;

import com.example.personalmanagement.R;
import com.example.personalmanagement.methodclass.CurrentDateTime;
import com.example.personalmanagement.methodclass.Initialize;
import com.example.personalmanagement.model.Exercise;
import com.example.personalmanagement.ui.fragment.health.eating.AddMealFragment;

import java.util.List;


public class ExercisesFragment extends Fragment
        implements Initialize, View.OnClickListener, AdapterView.OnItemClickListener {


    final String keyName = "idFrag";
    TextView tvBack, tvCurrentDate, tvCountItem;
    EditText edtSearch;
    ListView lvExercises;
    ImageView icAdd;
    List<Exercise> exerciseList;

    public ExercisesFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_exercises, container, false);
        initializeDatabase();
        initializeViews(view);
        //tvCurrentDate.setText("Hôm nay, "+ CurrentDateTime.getCurrentDate());
        tvBack.setOnClickListener(this);
        lvExercises.setOnItemClickListener(this);
        icAdd.setOnClickListener(this);
        String[] arrExercises = {"Tập bụng", "Hít đất", "Đẩy tạ", "Kéo xà", "Chạy bộ"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, arrExercises);
        lvExercises.setAdapter(adapter);
        return view;

    }

    @Override
    public void onClick(View v) {
        if (tvBack.equals(v)) {
            getActivity().getSupportFragmentManager().beginTransaction().
                    replace(R.id.fragment_health_root, new FitnessFragment()).commit();
        } else if (icAdd.equals(v)) {
            addExercise();
        }
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Bạn muốn sửa hay xóa");
        builder.setNegativeButton("Xóa", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(), "Xóa thành công!", Toast.LENGTH_LONG).show();
            }
        });
        builder.setPositiveButton("Sửa", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                updateExercise();
            }
        });
        builder.create().show();
    }


    @Override
    public void initializeViews(View view) {
        edtSearch = view.findViewById(R.id.edtSearch);
        tvBack = view.findViewById(R.id.tvBack);
        tvCountItem = view.findViewById(R.id.tvCountItem);
        lvExercises = view.findViewById(R.id.lvExercises);
        //  tvCurrentDate = view.findViewById(R.id.tvCurrentDate);
        icAdd = view.findViewById(R.id.icAdd);
    }

    @Override
    public void initializeDatabase() {

    }

    private void updateExercise() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View view = getLayoutInflater().inflate(R.layout.layout_dialog_update_exercise, null);
        builder.setView(view);
        EditText edtExerciseName = view.findViewById(R.id.edtNewExerciseName);
        builder.setPositiveButton("Lưu", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(), "Sửa thành công!", Toast.LENGTH_LONG).show();
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

    private void addExercise() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View view = getLayoutInflater().inflate(R.layout.layout_dialog_add_new_exercise, null);
        builder.setView(view);
        EditText edtAddNewExerciseName = view.findViewById(R.id.edtAddNewExercise);

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
}