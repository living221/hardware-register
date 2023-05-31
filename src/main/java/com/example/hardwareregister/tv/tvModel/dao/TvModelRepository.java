package com.example.hardwareregister.tv.tvModel.dao;

import com.example.hardwareregister.tv.tvModel.model.TvModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TvModelRepository extends JpaRepository<TvModel, Long> {
    List<TvModel> findAllByTv_Id(Long tvId);
}
