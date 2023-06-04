package com.example.hardwareregister.computer.computerModel.dao;

import com.example.hardwareregister.computer.computerModel.model.ComputerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ComputerModelRepository extends JpaRepository<ComputerModel, Long> {
    List<ComputerModel> findAllByComputer_Id(Long computerId);

    @Query(value = "SELECT c FROM ComputerModel c " +
            "WHERE LOWER(c.modelName)  " +
            "LIKE :textQuery AND c.inStock = true")
    List<ComputerModel> findAllByModelName(String textQuery);

    @Query(value = "SELECT c FROM ComputerModel c " +
            "WHERE c.colour like :colour " +
            "AND c.size > :size " +
            "AND c.category like :category " +
            "AND c.processorType like :cpuType")
    List<ComputerModel> findAllByColourAndSizeAndCategoryAndProcessorType(String colour,
                                                                          int size,
                                                                          String category,
                                                                          String cpuType);

    List<ComputerModel> findByOrderByPriceAsc();

    List<ComputerModel> findByOrderByPriceDesc();

    List<ComputerModel> findByOrderByModelNameAsc();

    List<ComputerModel> findByOrderByModelNameDesc();
}
