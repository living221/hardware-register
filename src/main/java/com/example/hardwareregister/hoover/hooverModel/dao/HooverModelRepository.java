package com.example.hardwareregister.hoover.hooverModel.dao;

import com.example.hardwareregister.hoover.hooverModel.model.HooverModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HooverModelRepository extends JpaRepository<HooverModel, Long> {
    List<HooverModel> findAllByHoover_Id(Long hooverId);
}
