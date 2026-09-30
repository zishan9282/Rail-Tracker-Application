package com.genie.TrainApplication.repository;

import com.genie.TrainApplication.entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TrainRepository extends JpaRepository<Train, Long> {
    Optional<Train> findByTrainNumber(String trainNumber);
}
