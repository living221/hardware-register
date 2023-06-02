package com.example.hardwareregister.refrigerator.refrigeratorModel.dao;

import com.example.hardwareregister.refrigerator.refrigeratorModel.model.RefrigeratorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RefrigeratorModelRepository extends JpaRepository<RefrigeratorModel, Long> {
    List<RefrigeratorModel> findAllByRefrigerator_Id(Long refrigeratorId);

    List<RefrigeratorModel> findByOrderByPriceAsc();

    List<RefrigeratorModel> findByOrderByPriceDesc();

    List<RefrigeratorModel> findByOrderByModelNameAsc();

    List<RefrigeratorModel> findByOrderByModelNameDesc();

    @Query(value = "SELECT r FROM RefrigeratorModel r " +
            "WHERE LOWER(r.modelName)  " +
            "LIKE :textQuery AND r.inStock = true")
    List<RefrigeratorModel> findAllByModelName(String textQuery);

    @Query(value = "SELECT r FROM RefrigeratorModel r " +
            "WHERE r.colour like :colour " +
            "AND r.size > :size " +
            "AND r.doorsCount = :doorsCount " +
            "AND r.compressorType like :compressor")
    List<RefrigeratorModel> findAllByColourAndSizeAndDoorsCountAndCompressorType(String colour,
                                                                                 int size,
                                                                                 Integer doorsCount,
                                                                                 String compressor);
}
