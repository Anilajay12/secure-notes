package com.notes.secure.security.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * @author Anil
 * @version 1.0
 * @since 11/26/2024
 */

@Component
public class RequestValidationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String  header = request.getHeader("X-Valid-Request");
        if(header == null || !header.equals("true")) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST,"invalid request");
            return;
        }
        filterChain.doFilter(request, response);

    }
}