package com.notes.secure.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Anil
 * @version 1.0
 * @since 11/26/2024
 */

@RestController
public class CsrfController {


    @GetMapping("/api/csrf-token")
    public CsrfToken generateCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute(CsrfToken.class.getName());
    }
}
