package com.yugraj.financebackend.dto;

import com.yugraj.financebackend.model.Role;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateRoleRequestDTO {

    @NotNull(message = "Role is required")
    private Role role;
}