package com.example.personalmanagement.adapter.notes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.example.personalmanagement.R;
import com.example.personalmanagement.model.Note;
import com.example.personalmanagement.ui.fragment.notes.NotesFragment;

import java.util.List;

public class NotesAdapter extends BaseAdapter {
    Context context;
    List<Note> noteList;



    public NotesAdapter(Context context, List<Note> noteList) {
        this.context = context;
        this.noteList = noteList;
    }

    @Override
    public int getCount() {
        return noteList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_note, parent, false);
            viewHolder.tvTitle = convertView.findViewById(R.id.tvNoteTitle);
            viewHolder.tvDateTime = convertView.findViewById(R.id.tvDateTime);
            viewHolder.tvFolderName = convertView.findViewById(R.id.tvFolderName);
            viewHolder.icInfo = convertView.findViewById(R.id.icInfo);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Note note = noteList.get(position);
        String folderName = "";
        if (note.getFolderID() == 1) {
            folderName = "Ghi chú";
        } else if (note.getFolderID() == 2) {
            folderName = "Ghi chú quan trọng";
        }
        viewHolder.tvTitle.setText(note.getTitle());
        viewHolder.tvDateTime.setText(note.getTime() + ", " + note.getDate());
        viewHolder.tvFolderName.setText(folderName);
        viewHolder.icInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                showPopupMenu(v);
            }
        });
        return convertView;
    }

    public class ViewHolder {
        TextView tvTitle, tvDateTime, tvFolderName;
        ImageView icInfo;

    }
    public void showPopupMenu(View view){
        PopupMenu popupMenu = new PopupMenu(context,view);
        popupMenu.inflate(R.menu.menu_item_note);
        popupMenu.show();
    }




}
