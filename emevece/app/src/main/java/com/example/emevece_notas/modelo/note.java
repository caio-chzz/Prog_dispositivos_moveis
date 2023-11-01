package com.example.emevece_notas.modelo;

import android.database.Cursor;

import com.example.emevece_notas.NoteDBHelper;

public class note {

        private long id;
        private String title;
        private String content;

        public note() {

        }

        public note(String title, String content) {
            this.title = title;
            this.content = content;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

    public static note cursorToNote(Cursor cursor) {
        note note = new note();
        note.setId(cursor.getLong(cursor.getColumnIndex(NoteDBHelper.COLUMN_ID)));
        note.setTitle(cursor.getString(cursor.getColumnIndex(NoteDBHelper.COLUMN_TITLE)));
        note.setContent(cursor.getString(cursor.getColumnIndex(NoteDBHelper.COLUMN_CONTENT));
        return note;
    }
    }

