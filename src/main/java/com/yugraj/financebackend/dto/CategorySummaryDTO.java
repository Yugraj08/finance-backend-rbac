package com.yugraj.financebackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CategorySummaryDTO {
    private String category ;
    private double total ;
}
