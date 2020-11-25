package com.example.personalmanagement.ui.fragment.notes;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.example.personalmanagement.R;
import com.example.personalmanagement.adapter.notes.NotesAdapter;
import com.example.personalmanagement.methodclass.CurrentDateTime;
import com.example.personalmanagement.methodclass.Initialize;
import com.example.personalmanagement.model.Note;
import com.example.personalmanagement.ui.fragment.plans.DetailPlansFragment;

import java.util.ArrayList;
import java.util.List;


public class ImportantNotesFragment extends Fragment implements Initialize, View.OnClickListener, AdapterView.OnItemClickListener {
    public static final int idFrag = 2;
    final String keyName = "idFrag";

    final String keyNoteTitle = "title";
    final String keyDate = "date";
    final String keyTime = "time";
    final String keyContent = "content";
    int id = idFrag;
    TextView tvBack, tvCount;
    ImageView icAdd;
    Bundle bundle;
    List<Note> noteList;
    ListView lvNotes;

    public ImportantNotesFragment() {
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
        View view = inflater.inflate(R.layout.fragment_important_notes, container, false);
        initializeViews(view);
        tvBack.setOnClickListener(this);
        icAdd.setOnClickListener(this);
        lvNotes.setOnItemClickListener(this);
        for (int i = 0; i < 10; i++) {
            Note note = new Note();
            note.setTitle("Ghi chú " + (i + 1));
            note.setTime(CurrentDateTime.getCurrentTime());
            note.setDate(CurrentDateTime.getCurrentDate());
            note.setContent(" tvCount =  view.findViewById(R.id.tvNoteCount);\n" +
                    "        lvNotes = view.findViewById(R.id.lvNotes);\n" +
                    "        noteList = new ArrayList<>();\n" +
                    "        tvBack = view.findViewById(R.id.tvBack);\n" +
                    "        icAddNote = view.findViewById(R.id.icAddNote);");
            note.setFolderID(id);
            noteList.add(note);
        }
        tvCount.setText("Có " + noteList.size() + " ghi chú");
        NotesAdapter adapter = new NotesAdapter(getContext(), noteList);
        lvNotes.setAdapter(adapter);
        return view;
    }

    @Override
    public void onClick(View v) {
        if (tvBack.equals(v)) {
            getActivity().getSupportFragmentManager().beginTransaction().
                    replace(R.id.fragment_notes_root, new NoteFoldersFragment()).commit();

        } else if (icAdd.equals(v)) {
            bundle = new Bundle();
            bundle.putInt(keyName, id);
            AddNoteFragment addNoteFragment = new AddNoteFragment();
            addNoteFragment.setArguments(bundle);
            getActivity().getSupportFragmentManager().beginTransaction().
                    replace(R.id.fragment_notes_root, addNoteFragment).commit();
        }
    }

    @Override
    public void initializeViews(View view) {
        noteList = new ArrayList<>();
        lvNotes = view.findViewById(R.id.lvImportantNotes);
        tvCount = view.findViewById(R.id.tvNoteCount);
        tvBack = view.findViewById(R.id.tvBack);
        icAdd = view.findViewById(R.id.icAddNote);
    }

    @Override
    public void initializeDatabase() {

    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        DetailNoteFragment detailNoteFragment = new DetailNoteFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(keyName, idFrag);
        Note note = noteList.get(i);
        bundle.putString(keyNoteTitle, note.getTitle());
        bundle.putString(keyContent, note.getContent());
        bundle.putString(keyDate, note.getDate());
        bundle.putString(keyTime, note.getTime());
        detailNoteFragment.setArguments(bundle);
        getActivity().getSupportFragmentManager().beginTransaction().
                replace(R.id.fragment_notes_root, detailNoteFragment).commit();

    }


}