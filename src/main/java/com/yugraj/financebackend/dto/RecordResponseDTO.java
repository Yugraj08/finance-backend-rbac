package com.yugraj.financebackend.dto;

import com.yugraj.financebackend.model.RecordType;
import lombok.Data;
import java.time.LocalDate;

@Data
public class RecordResponseDTO {

    private Long id;
    private Double amount;
    private RecordType type;
    private String category;
    private LocalDate date;
    private String note;
    private Long userId;
}