package com.notes.secure.models;

import jakarta.persistence.*;
import lombok.Data;

/**
 * @author Anil
 * @version 1.0
 * @since 11/22/2024
 */

@Entity
@Data
public class Note {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String content;
    private String ownerUsername;
}
