package com.yugraj.financebackend.service;

import com.yugraj.financebackend.dto.UserRequestDTO;
import com.yugraj.financebackend.dto.UserResponseDTO;
import com.yugraj.financebackend.model.Role;
import com.yugraj.financebackend.model.Status;
import com.yugraj.financebackend.model.User;
import com.yugraj.financebackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponseDTO register(UserRequestDTO request) {

        User user = new User();
                user.setName(request.getName());
                user.setEmail(request.getEmail());
                user.setPassword(request.getPassword());

        //Email duplicate check
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }
        user.setRole(Role.VIEWER);
        user.setStatus(Status.ACTIVE);

        userRepository.save(user);

        return mapToDTO(user);
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    @Override
    public void updateUserRole(Long userId, String role) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        user.setRole(Role.valueOf(role));
        userRepository.save(user);
    }

    @Override
    public void updateUserStatus(Long userId, Status status) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setStatus(status);
        userRepository.save(user);
    }

    private UserResponseDTO mapToDTO(User user) {
        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setRole(user.getRole().name());
        dto.setStatus(user.getStatus());
        return dto;
    }
}