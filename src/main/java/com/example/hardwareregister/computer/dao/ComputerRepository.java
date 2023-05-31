package com.example.hardwareregister.computer.dao;

import com.example.hardwareregister.computer.model.Computer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComputerRepository extends JpaRepository<Computer, Long> {
}
