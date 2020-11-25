package com.example.personalmanagement.ui.fragment.notes;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.personalmanagement.R;
import com.example.personalmanagement.adapter.notes.NotesAdapter;
import com.example.personalmanagement.methodclass.CurrentDateTime;
import com.example.personalmanagement.methodclass.Initialize;
import com.example.personalmanagement.model.Note;

import java.util.ArrayList;
import java.util.List;


public class NotesDeletedFragment extends Fragment implements Initialize, View.OnClickListener, AdapterView.OnItemClickListener {
    public  static final  int idFrag =3;
    final String keyName ="idFrag";
    final String keyNoteTitle ="title";
    final String keyDate ="date";
    final String keyTime ="time";
    final String keyContent ="content";
    ImageView icAddNote;
    TextView tvBack, tvCount;
    int id = idFrag;
    List<Note> noteList;
    ListView lvNotes;

    public NotesDeletedFragment() {
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
        View view = inflater.inflate(R.layout.fragment_notes_deleted, container, false);
        initializeViews(view);
        tvBack.setOnClickListener(this);

        for (int i=0; i<10;i++){
            Note note = new Note();
            note.setTitle("Ghi chú "+(i+1));
            note.setTime(CurrentDateTime.getCurrentTime());
            note.setDate(CurrentDateTime.getCurrentDate());
            note.setContent(" tvCount =  view.findViewById(R.id.tvNoteCount);\n" +
                    "        lvNotes = view.findViewById(R.id.lvNotes);\n" +
                    "        noteList = new ArrayList<>();\n" +
                    "        tvBack = view.findViewById(R.id.tvBack);\n" +
                    "        icAddNote = view.findViewById(R.id.icAddNote);");
            note.setFolderID(1);
            noteList.add(note);
        }

        tvCount.setText("Có " + noteList.size() + " ghi chú");
        NotesAdapter adapter = new NotesAdapter(getContext(), noteList);
        lvNotes.setAdapter(adapter);
        lvNotes.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if (tvBack.equals(v)) {
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_notes_root, new NoteFoldersFragment()).commit();

        }
    }

    @Override
    public void initializeViews(View view) {
        tvCount = view.findViewById(R.id.tvNoteCount);
        lvNotes = view.findViewById(R.id.lvNotesDeleted);
        noteList = new ArrayList<>();
        tvBack = view.findViewById(R.id.tvBack);

    }

    @Override
    public void initializeDatabase() {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        DetailNoteFragment detailNoteFragment = new DetailNoteFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(keyName,idFrag);
        Note note = noteList.get(position);
        bundle.putString(keyNoteTitle,note.getTitle());
        bundle.putString(keyContent,note.getContent());
        bundle.putString(keyDate,note.getDate());
        bundle.putString(keyTime,note.getTime());
        detailNoteFragment.setArguments(bundle);
        getActivity().getSupportFragmentManager().beginTransaction().
                replace(R.id.fragment_notes_root, detailNoteFragment).commit();
    }
}