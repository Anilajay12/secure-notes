package com.notes.secure.reporistories;

import com.notes.secure.models.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Anil
 * @version 1.0
 * @since 11/23/2024
 */

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

    Optional<List<Note>> findByOwnerUsername(String username);
}
