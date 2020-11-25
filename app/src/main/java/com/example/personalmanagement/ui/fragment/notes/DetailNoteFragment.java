package com.example.personalmanagement.ui.fragment.notes;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.personalmanagement.R;
import com.example.personalmanagement.methodclass.Initialize;

public class DetailNoteFragment extends Fragment implements Initialize, View.OnClickListener {
    final String keyName = "idFrag";
    final String keyNoteTitle ="title";
    final String keyDate ="date";
    final String keyTime ="time";
    final String keyContent ="content";
    int isEditing = 0;
    TextView tvEdit, tvBack,tvDateTime;
    EditText edtTitle, edtContent;

    public DetailNoteFragment() {
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
        View view = inflater.inflate(R.layout.fragment_detail_note, container, false);
        initializeViews(view);
        tvEdit.setOnClickListener(this);
        tvBack.setOnClickListener(this);

        if (getArguments().getInt(keyName) == NotesDeletedFragment.idFrag) {
            tvEdit.setText("Xóa");
        }else{ tvEdit.setText("Sửa");}
        tvDateTime.setText("Được thêm vào "+getArguments().getString(keyTime)+", "+getArguments().getString(keyDate));
        edtTitle.setText(getArguments().getString(keyNoteTitle));
        edtContent .setText(" "+getArguments().getString(keyContent));
        return view;
    }

    @Override
    public void onClick(View v) {


        if (getArguments().getInt(keyName) == NotesFragment.idFrag) {
            // id =1 : notes fragment

            if (tvEdit.equals(v)) {
                edit();
            } else if (tvBack.equals(v)) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_notes_root, new NotesFragment()).commit();

            }


        } else if (getArguments().getInt(keyName) == ImportantNotesFragment.idFrag) {
            //id=2:  important notes fragment

            if (tvEdit.equals(v)) {
               edit();
                Toast.makeText(getActivity(), "Sửa thông tin thành công", Toast.LENGTH_SHORT).show();
            } else if (tvBack.equals(v)) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_notes_root, new ImportantNotesFragment()).commit();

            }


        } else if (getArguments().getInt(keyName) == NotesDeletedFragment.idFrag) {
            //id=2:  important notes fragment

            if (tvEdit.equals(v)) {

                final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setMessage("Xóa vĩnh viễn ghi chú này");
                builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        builder.create().dismiss();
                    }
                });

                builder.setPositiveButton("Xóa", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Toast.makeText(getActivity(), "Xóa thông tin thành công", Toast.LENGTH_SHORT).show();
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragment_notes_root, new NotesDeletedFragment()).commit();
                    }
                });

                builder.create().show();
            } else if (tvBack.equals(v)) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_notes_root, new NotesDeletedFragment()).commit();

            }


        }
    }

    @Override
    public void initializeViews(View view) {
        tvEdit = view.findViewById(R.id.tvEdit);
        tvBack = view.findViewById(R.id.tvBack);
        edtTitle = view.findViewById(R.id.edtNoteTitle);
        edtContent = view.findViewById(R.id.edtNoteContent);
        tvDateTime = view.findViewById(R.id.tvDateTime);
    }

    @Override
    public void initializeDatabase() {

    }

    private void edit() {

        if (isEditing == 0) {
            tvEdit.setText("Xong");
            edtTitle.setEnabled(true);
            edtContent.setEnabled(true);
            isEditing = 1;
        } else if (isEditing == 1) {
            tvEdit.setText("Sửa");
            edtTitle.setEnabled(false);
            edtContent.setEnabled(false);
            isEditing = 0;
            Toast.makeText(getActivity(), "Cập nhật thành công!", Toast.LENGTH_LONG).show();
        }

    }
}