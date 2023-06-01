package com.example.hardwareregister.hw.dao;

import com.example.hardwareregister.hw.model.Hw;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HwRepository extends JpaRepository<Hw, Long> {
}
