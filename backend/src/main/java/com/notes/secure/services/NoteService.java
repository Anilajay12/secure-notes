package com.notes.secure.services;

import com.notes.secure.models.Note;

import java.util.List;

/**
 * @author Anil
 * @version 1.0
 * @since 11/23/2024
 */
public interface NoteService {
    Note createNoteForUser(String username, String content);

    Note updateNoteForUser(String username, String content, Long noteId);

    void deleteNoteForUser(String username, Long noteId);

    List<Note> getNotesForUser(String username);
}
