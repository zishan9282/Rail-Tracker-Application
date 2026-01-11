package com.genie.TrainApplication.repository;

import com.genie.TrainApplication.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationRepository extends JpaRepository<Station, Long> {
}
