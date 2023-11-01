package com.example.emevece_notas.modelo;

import static com.example.emevece_notas.modelo.note.cursorToNote;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.emevece_notas.NoteDBHelper;
import com.example.emevece_notas.modelo.note;

import java.util.ArrayList;
import java.util.List;

public class noteDAO {
    private SQLiteDatabase database;
    private NoteDBHelper dbHelper;

    public noteDAO(Context context) {
        dbHelper = new NoteDBHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }


    public long insertNote(note note) {
        ContentValues values = new ContentValues();
        values.put(NoteDBHelper.COLUMN_TITLE, note.getTitle());
        values.put(NoteDBHelper.COLUMN_CONTENT, note.getContent());

        return database.insert(NoteDBHelper.TABLE_NOTES, null, values);
    }


    public int updateNote(note note) {
        ContentValues values = new ContentValues();
        values.put(NoteDBHelper.COLUMN_TITLE, note.getTitle());
        values.put(NoteDBHelper.COLUMN_CONTENT, note.getContent());

        return database.update(NoteDBHelper.TABLE_NOTES, values, NoteDBHelper.COLUMN_ID + " = ?",
                new String[]{String.valueOf(note.getId())});
    }


    public void deleteNote(long noteId) {
        database.delete(NoteDBHelper.TABLE_NOTES, NoteDBHelper.COLUMN_ID + " = " + noteId, null);
    }

    public List<note> getAllNotes() {
        List<note> notes = new ArrayList<>();
        Cursor cursor = database.query(NoteDBHelper.TABLE_NOTES, null, null, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                note note = cursorToNote(cursor);
                notes.add(note);
                cursor.moveToNext();
            }
            cursor.close();
        }

        return notes;
    }


}

