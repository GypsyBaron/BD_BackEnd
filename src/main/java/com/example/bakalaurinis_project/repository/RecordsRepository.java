package com.example.bakalaurinis_project.repository;

import com.example.bakalaurinis_project.model.Records;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface RecordsRepository extends JpaRepository<Records, Integer> {
    List<Records> findRecordsByDateAndUserid(Date date, Integer userid);
}
