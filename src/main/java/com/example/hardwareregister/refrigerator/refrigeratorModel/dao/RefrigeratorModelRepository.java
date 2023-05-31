package com.example.hardwareregister.refrigerator.refrigeratorModel.dao;

import com.example.hardwareregister.refrigerator.refrigeratorModel.model.RefrigeratorModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RefrigeratorModelRepository extends JpaRepository<RefrigeratorModel, Long> {
    List<RefrigeratorModel> findAllByRefrigerator_Id(Long refrigeratorId);
}
