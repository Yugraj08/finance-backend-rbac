package com.yugraj.financebackend.model.spec;

import com.yugraj.financebackend.model.Record;
import com.yugraj.financebackend.model.RecordType;

import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class RecordSpecification {

    public static Specification<Record> hasType(RecordType type) {
        return (root, query, cb) ->
                type == null ? null : cb.equal(root.get("type"), type);
    }

    public static Specification<Record> hasCategory(String category) {
        return (root, query, cb) ->
                category == null ? null : cb.equal(root.get("category"), category);
    }

    public static Specification<Record> dateBetween(LocalDate start, LocalDate end) {
        return (root, query, cb) -> {
            if (start == null || end == null) return null;
            return cb.between(root.get("date"), start, end);
        };
    }
}