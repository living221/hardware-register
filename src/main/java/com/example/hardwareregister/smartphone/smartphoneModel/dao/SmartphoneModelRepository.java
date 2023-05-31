package com.example.hardwareregister.smartphone.smartphoneModel.dao;

import com.example.hardwareregister.smartphone.model.Smartphone;
import com.example.hardwareregister.smartphone.smartphoneModel.model.SmartphoneModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface SmartphoneModelRepository extends JpaRepository<SmartphoneModel, Long> {
    List<SmartphoneModel> findAllBySmartphone_Id(Long smartphoneById);
}
