package com.example.emevece_notas.controle;

import android.content.Context;

import com.example.emevece_notas.modelo.note;
import com.example.emevece_notas.modelo.noteDAO;

import java.util.List;

public class NoteController {
    private com.example.emevece_notas.modelo.noteDAO noteDAO;

    public NoteController(Context context) {
        noteDAO = new noteDAO(context);
    }

    public void open() {
        noteDAO.open();
    }

    public void close() {
        noteDAO.close();
    }

    public long addNote(String title, String content) {
        note note = new note();
        note.setTitle(title);
        note.setContent(content);
        return noteDAO.insertNote(note);
    }

    public int updateNote(long noteId, String title, String content) {
        note note = new note();
        note.setId(noteId);
        note.setTitle(title);
        note.setContent(content);
        return noteDAO.updateNote(note);
    }

    public void deleteNote(long noteId) {
        noteDAO.deleteNote(noteId);
    }

    public List<note> getAllNotes() {
        return noteDAO.getAllNotes();
    }


}

