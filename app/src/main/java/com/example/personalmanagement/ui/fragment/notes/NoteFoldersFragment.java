package com.example.personalmanagement.ui.fragment.notes;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;

import com.example.personalmanagement.R;
import com.example.personalmanagement.methodclass.Initialize;

import java.util.ArrayList;
import java.util.List;


public class NoteFoldersFragment extends Fragment implements Initialize, View.OnClickListener {

    ListView lvFolder;
    EditText edtSearch;
    List<String> listString = new ArrayList<>();
    CardView cardNotes, cardNotesImportant, cardDeleted;

    public NoteFoldersFragment() {
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
        View view = inflater.inflate(R.layout.fragment_note_folders, container, false);
        initializeViews(view);
        for (int i = 0; i < 50; i++) {
            listString.add("Thư mục " + (i + 1));
        }

//        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, listString);
//        lvFolder.setAdapter(adapter);
        cardNotesImportant.setOnClickListener(this);
        cardNotes.setOnClickListener(this);
        cardDeleted.setOnClickListener(this);


        return view;
    }

    @Override
    public void initializeViews(View view) {
        //   lvFolder = view.findViewById(R.id.lvFolder);
        edtSearch = view.findViewById(R.id.edtSearch);
        cardNotes = view.findViewById(R.id.card_note);
        cardNotesImportant = view.findViewById(R.id.card_note_important);
        cardDeleted = view.findViewById(R.id.card_deleted);

    }

    @Override
    public void initializeDatabase() {

    }

    @Override
    public void onClick(View v) {
        if (cardNotes.equals(v)) {
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_notes_root, new NotesFragment()).commit();
        } else if (cardNotesImportant.equals(v)) {
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_notes_root, new ImportantNotesFragment()).commit();
        } else if (cardDeleted.equals(v)) {
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_notes_root, new NotesDeletedFragment()).commit();
        }
    }
}