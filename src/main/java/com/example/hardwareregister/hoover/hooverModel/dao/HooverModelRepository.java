package com.example.hardwareregister.hoover.hooverModel.dao;

import com.example.hardwareregister.hoover.hooverModel.model.HooverModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HooverModelRepository extends JpaRepository<HooverModel, Long> {
    List<HooverModel> findAllByHoover_Id(Long hooverId);

    List<HooverModel> findByOrderByPriceAsc();

    List<HooverModel> findByOrderByPriceDesc();

    List<HooverModel> findByOrderByModelNameAsc();

    List<HooverModel> findByOrderByModelNameDesc();

    @Query(value = "SELECT h FROM HooverModel h " +
            "WHERE LOWER(h.modelName)  " +
            "LIKE :textQuery AND h.inStock = true")
    List<HooverModel> findAllByModelName(String textQuery);

    @Query(value = "SELECT h FROM HooverModel h " +
            "WHERE h.colour like :colour " +
            "AND h.size > :size " +
            "AND h.dustCapacity > :dustCapacity " +
            "AND h.modesCount > :modesCount")
    List<HooverModel> findAllByColourAndSizeAndDustCapacityAndModesCount(String colour,
                                                                         int size,
                                                                         Integer dustCapacity,
                                                                         Integer modesCount);
}
