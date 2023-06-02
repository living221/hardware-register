package com.example.hardwareregister.tv.tvModel.dao;

import com.example.hardwareregister.tv.tvModel.model.TvModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TvModelRepository extends JpaRepository<TvModel, Long> {
    List<TvModel> findAllByTv_Id(Long tvId);

    @Query(value = "SELECT t FROM TvModel t " +
            "WHERE t.colour like :colour " +
            "AND t.size > :size " +
            "AND t.category like :category " +
            "AND t.technology like :tech")
    List<TvModel> findAllByColourAndSizeAndCategoryAndTechnology(String colour,
                                                                 Integer size,
                                                                 String category,
                                                                 String tech);

    @Query(value = "SELECT t FROM TvModel t " +
            "WHERE LOWER(t.modelName)  " +
            "LIKE :text AND t.inStock = true")
    List<TvModel> findAllByModelName(String text);

    List<TvModel> findByOrderByPriceAsc();

    List<TvModel> findByOrderByPriceDesc();

    List<TvModel> findByOrderByModelNameAsc();

    List<TvModel> findByOrderByModelNameDesc();
}
