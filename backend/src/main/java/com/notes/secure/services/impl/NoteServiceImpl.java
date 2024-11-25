package com.notes.secure.services.impl;

import com.notes.secure.exceptions.NoteNotFoundException;
import com.notes.secure.models.Note;
import com.notes.secure.reporistories.NoteRepository;
import com.notes.secure.services.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Anil
 * @version 1.0
 * @since 11/23/2024
 */

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;


    @Override
    public Note createNoteForUser(String username, String content){
        Note note = new Note();
        note.setContent(content);
        note.setOwnerUsername(username);
        return noteRepository.save(note);
    }

    @Override
    public Note updateNoteForUser(String username, String content, Long noteId){
        Note note = noteRepository.findById(noteId).orElseThrow(() -> new RuntimeException("Unable to find the note"));
        if(!note.getOwnerUsername().equalsIgnoreCase(username)){
            throw new RuntimeException("we can't perform update of others request");
        }
        note.setContent(content);
        return noteRepository.save(note);
    }

    @Override
    public void deleteNoteForUser(String username, Long noteId){
        Note fetchNote = noteRepository.findById(noteId).orElseThrow(() -> new RuntimeException("note not found"));
        if(fetchNote.getOwnerUsername().equalsIgnoreCase(username)) {
            noteRepository.deleteById(noteId);
            return;
        }
        throw new NoteNotFoundException("Unable to find the note for requested user: " + username);
    }

    @Override
    public List<Note> getNotesForUser(String username){
        return noteRepository.findByOwnerUsername(username).orElseThrow(
                () -> new RuntimeException("Notes are not available for user: " + username)
        );
    }
}
