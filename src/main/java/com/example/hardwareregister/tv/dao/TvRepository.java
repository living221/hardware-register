package com.example.hardwareregister.tv.dao;

import com.example.hardwareregister.tv.model.Tv;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TvRepository extends JpaRepository<Tv, Long> {
}
