package com.example.hardwareregister.refrigerator.dao;

import com.example.hardwareregister.refrigerator.model.Refrigerator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefrigeratorRepository extends JpaRepository<Refrigerator, Long> {
}
