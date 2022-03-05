package com.example.Material.management.repository;

import com.example.Material.management.entity.Export;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExportRepository {
    List<Export> findExportById(Integer id);

    List<Export> findExportByName(String tern) ;
}
