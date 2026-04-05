package com.yugraj.financebackend.service;

import com.yugraj.financebackend.dto.UserRequestDTO;
import com.yugraj.financebackend.dto.UserResponseDTO;
import com.yugraj.financebackend.model.Status;

import java.util.List;

public interface UserService {

    UserResponseDTO register(UserRequestDTO request);

    List<UserResponseDTO> getAllUsers();

    void updateUserRole(Long userId, String role);

    void updateUserStatus(Long userId, Status status);
}