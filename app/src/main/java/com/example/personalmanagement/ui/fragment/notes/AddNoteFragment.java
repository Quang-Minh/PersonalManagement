package com.example.personalmanagement.ui.fragment.notes;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.personalmanagement.R;
import com.example.personalmanagement.methodclass.CurrentDateTime;
import com.example.personalmanagement.methodclass.Initialize;

public class AddNoteFragment extends Fragment implements Initialize, View.OnClickListener {

    final String keyName ="idFrag";
    TextView tvBack, tvDone, tvDate;
    Bundle bundle;

    public AddNoteFragment() {
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
        View view = inflater.inflate(R.layout.fragment_add_note, container, false);
        bundle = getArguments();
        initializeViews(view);
        tvDate.setText(CurrentDateTime.getCurrentDate());
        tvDone.setOnClickListener(this);
        tvBack.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {

        if (bundle.getInt(keyName) == NotesFragment.idFrag) {
            // id =1 : notes fragment

            if (tvBack.equals(v)) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_notes_root, new NotesFragment()).commit();
            } else if (tvDone.equals(v)) {

                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_notes_root, new NotesFragment()).commit();
                Toast.makeText(getActivity(), "Lưu thông tin thành công", Toast.LENGTH_SHORT).show();
            }



        } else if (bundle.getInt(keyName) ==ImportantNotesFragment.idFrag) {
            //id=2:  important notes fragment

            if (tvBack.equals(v)) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_notes_root, new ImportantNotesFragment()).commit();
            } else if (tvDone.equals(v)) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_notes_root, new ImportantNotesFragment()).commit();
                Toast.makeText(getActivity(), "Lưu thông tin thành công", Toast.LENGTH_SHORT).show();
            }


        }


    }

    @Override
    public void initializeViews(View view) {
        tvBack = view.findViewById(R.id.tvBack);
        tvDone = view.findViewById(R.id.tvDone);
        tvDate = view.findViewById(R.id.tvCurrentDate);
    }

    @Override
    public void initializeDatabase() {

    }

    private void addNote(){

    }
}