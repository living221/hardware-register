package com.example.hardwareregister.smartphone.smartphoneModel.dao;

import com.example.hardwareregister.smartphone.smartphoneModel.model.SmartphoneModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SmartphoneModelRepository extends JpaRepository<SmartphoneModel, Long> {
    List<SmartphoneModel> findAllBySmartphone_Id(Long smartphoneById);

    List<SmartphoneModel> findByOrderByPriceAsc();

    List<SmartphoneModel> findByOrderByPriceDesc();

    List<SmartphoneModel> findByOrderByModelNameAsc();

    List<SmartphoneModel> findByOrderByModelNameDesc();

    @Query(value = "SELECT s FROM SmartphoneModel s " +
            "WHERE LOWER(s.modelName)  " +
            "LIKE :textQuery AND s.inStock = true")
    List<SmartphoneModel> findAllByModelName(String textQuery);

    @Query(value = "SELECT s FROM SmartphoneModel s " +
            "WHERE s.colour like :colour " +
            "AND s.size > :size " +
            "AND s.camerasCount > :cameraCount " +
            "AND s.memory like :memory")
    List<SmartphoneModel> findAllByColourAndSizeAndCamerasCountAndMemory(String colour,
                                                                         int size,
                                                                         Integer cameraCount,
                                                                         String memory);
}
