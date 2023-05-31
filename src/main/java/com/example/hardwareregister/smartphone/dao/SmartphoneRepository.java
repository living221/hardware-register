package com.example.hardwareregister.smartphone.dao;

import com.example.hardwareregister.smartphone.model.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SmartphoneRepository extends JpaRepository<Smartphone, Long> {
}
