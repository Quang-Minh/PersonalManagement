package com.example.personalmanagement.ui.fragment.money;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.personalmanagement.R;
import com.example.personalmanagement.methodclass.Initialize;


public class DetailExpenseFragment extends Fragment
        implements Initialize, AdapterView.OnItemClickListener, View.OnClickListener {


    TextView tvBack, tvEdit, tvDateTime, tvDelete;
    EditText edtTitle, edtAmount, edtDescribe;
    int isEditing = 0;

    public DetailExpenseFragment() {
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
        View view = inflater.inflate(R.layout.fragment_detail_expense, container, false);
        initializeDatabase();
        initializeViews(view);

        tvEdit.setOnClickListener(this);
        tvBack.setOnClickListener(this);
        tvDelete.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if (tvBack.equals(v)) {
            getActivity().getSupportFragmentManager().beginTransaction().
                    replace(R.id.fragment_money_root, new ExpenseFragment()).commit();
        } else if (tvEdit.equals(v)) {
            edit();
        }else if (tvDelete.equals(v)) {
            Toast.makeText(getActivity(),"Xóa thành công!",Toast.LENGTH_LONG).show();
            getActivity().getSupportFragmentManager().beginTransaction().
                    replace(R.id.fragment_money_root, new ExpenseFragment()).commit();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void initializeViews(View view) {
        tvDelete = view.findViewById(R.id.tvDelete);
        tvBack = view.findViewById(R.id.tvBack);
        tvEdit = view.findViewById(R.id.tvEdit);
        tvDateTime = view.findViewById(R.id.tvDateTime);
        edtTitle = view.findViewById(R.id.edtExpenseTitle);
        edtAmount = view.findViewById(R.id.edtAmount);
        edtDescribe = view.findViewById(R.id.edtDescribe);
    }

    @Override
    public void initializeDatabase() {

    }

    private void edit() {
        if (isEditing == 0) {
            tvEdit.setText("Xong");
            edtTitle.setEnabled(true);
            edtAmount.setEnabled(true);
            edtDescribe.setEnabled(true);
            isEditing = 1;
        } else if (isEditing == 1) {
            tvEdit.setText("Sửa");
            edtTitle.setEnabled(false);
            edtAmount.setEnabled(false);
            edtDescribe.setEnabled(false);
            isEditing = 0;
            Toast.makeText(getActivity(),"Cập nhật thành công!",Toast.LENGTH_LONG).show();
        }

    }
}