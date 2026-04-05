package com.yugraj.financebackend.controller;

import com.yugraj.financebackend.dto.UpdateRoleRequestDTO;
import com.yugraj.financebackend.dto.UserRequestDTO;
import com.yugraj.financebackend.dto.UserResponseDTO;
import com.yugraj.financebackend.exception.ResourceNotFoundException;
import com.yugraj.financebackend.model.Status;
import com.yugraj.financebackend.model.User;
import com.yugraj.financebackend.repository.UserRepository;
import com.yugraj.financebackend.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    //Register
    @PostMapping("/register")
    public UserResponseDTO register(@Valid @RequestBody UserRequestDTO request) {
        return userService.register(request);
    }

    //Get all users (Admin later)
    @GetMapping
    public List<UserResponseDTO> getAllUsers() {
        return userService.getAllUsers();
    }



    //Update status
    @PatchMapping("/{id}/status")
    public String updateStatus(@PathVariable Long id, @RequestParam Status status) {
        userService.updateUserStatus(id, status);
        return "Status updated successfully";
    }

    @PutMapping("/{id}/role")
    @PreAuthorize("hasRole('ADMIN')")
    public String updateUserRole(
            @PathVariable Long id,
            @Valid @RequestBody UpdateRoleRequestDTO request) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        user.setRole(request.getRole());
        userRepository.save(user);

        return "User role updated successfully";
    }
}