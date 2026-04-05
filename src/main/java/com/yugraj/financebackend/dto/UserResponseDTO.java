package com.yugraj.financebackend.dto;

import com.yugraj.financebackend.model.Status;
import lombok.Data;

@Data
public class UserResponseDTO {

    private Long id;
    private String name;
    private String email;
    private String role;
    private Status status;
}