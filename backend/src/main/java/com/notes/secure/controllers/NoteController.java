package com.notes.secure.controllers;

import com.notes.secure.models.Note;
import com.notes.secure.services.NoteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Anil
 * @version 1.0
 * @since 11/23/2024
 */

@RestController
@RequestMapping("/api/notes")
@RequiredArgsConstructor
@Slf4j
public class NoteController {

    private final NoteService noteService;

    @PostMapping
    public Note createNoteForUser(@RequestBody String content, @AuthenticationPrincipal UserDetails userDetails){
        String username = userDetails.getUsername();
        log.info("note creation request from: {} has been received", username);
        return noteService.createNoteForUser(username, content);
    }

    @PutMapping("/{noteId}")
    public Note updateNoteForUser(@RequestBody String content, @PathVariable Long noteId, @AuthenticationPrincipal UserDetails userDetails){
        String username = userDetails.getUsername();
        log.info("note update request from: {} has been received", username);
        return noteService.updateNoteForUser(username, content, noteId);
    }

    @DeleteMapping("/{noteId}")
    public void deleteNoteForUser(@PathVariable Long noteId, @AuthenticationPrincipal UserDetails userDetails){
        String username = userDetails.getUsername();
        log.info("note delete request from: {} has been received, for the note: {}", username, noteId);
        noteService.deleteNoteForUser(username, noteId);
    }

    @GetMapping
    public List<Note> getAllNotesForUser(@AuthenticationPrincipal UserDetails userDetails){
        String username = userDetails.getUsername();
        log.info("Fetching all the notes for user: {}", username);
        return noteService.getNotesForUser(username);
    }

}
