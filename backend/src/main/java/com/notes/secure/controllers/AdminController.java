package com.notes.secure.controllers;

import com.notes.secure.models.AppUser;
import com.notes.secure.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Anil
 * @version 1.0
 * @since 11/25/2024
 */

@RequestMapping("/api/admin")
@RequiredArgsConstructor
@RestController
public class AdminController {

    private final UserService userService;

    @GetMapping("/getUsers")
    public ResponseEntity<List<AppUser>> users(){
        return ResponseEntity.ok(userService.fetchAllUsers());
    }

    @PutMapping("/update-role")
    public String updateUserRole(@RequestParam Long userId, @RequestParam String userName){
        boolean updateUserRole = userService.updateUserRoleById(userId, userName);
        return updateUserRole ? "Role Updated Successfully" : "Unable to update at this moment";
    }

    @GetMapping("/user/{id}")
    public AppUser findUserDetailsById(@PathVariable Long id){
        return userService.fetchUserDetailsById(id);
    }
}
