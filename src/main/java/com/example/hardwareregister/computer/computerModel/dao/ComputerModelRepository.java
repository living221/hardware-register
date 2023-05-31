package com.example.hardwareregister.computer.computerModel.dao;

import com.example.hardwareregister.computer.computerModel.model.ComputerModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComputerModelRepository extends JpaRepository<ComputerModel, Long> {
    List<ComputerModel> findAllByComputer_Id(Long computerId);
}
