package com.yugraj.financebackend.service;

import com.yugraj.financebackend.dto.DashboardResponseDTO;
import com.yugraj.financebackend.dto.RecordRequestDTO;
import com.yugraj.financebackend.dto.RecordResponseDTO;

import java.util.List;

public interface RecordService {

    RecordResponseDTO createRecord(Long userId, RecordRequestDTO request);

    List<RecordResponseDTO> getAllRecords();

    void deleteRecord(Long recordId);

    RecordResponseDTO updateRecord(Long recordId, RecordRequestDTO request);

    List<RecordResponseDTO> getAllRecords(
            int page,
            int size,
            String type,
            String category,
            String startDate,
            String endDate
    );

    DashboardResponseDTO getDashboard(Long userId);
}