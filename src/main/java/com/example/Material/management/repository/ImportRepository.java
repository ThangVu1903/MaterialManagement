package com.example.Material.management.repository;

import com.example.Material.management.entity.Import;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImportRepository extends CrudRepository<Import,Integer>{
    List<Import> findImportById(Integer id);
    List<Import> findImportByName(String tern) ;
}
