package com.notes.secure.exceptions;

/**
 * @author Anil
 * @version 1.0
 * @since 11/23/2024
 */
public class NoteNotFoundException extends RuntimeException {
    public NoteNotFoundException(String message) {
        super(message);
    }
}
