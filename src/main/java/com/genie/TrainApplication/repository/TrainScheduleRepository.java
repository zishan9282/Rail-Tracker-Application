package com.genie.TrainApplication.repository;

import com.genie.TrainApplication.entity.TrainSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TrainScheduleRepository extends JpaRepository<TrainSchedule, Long> {

    @Query("SELECT ts FROM TrainSchedule ts " +
            "WHERE ts.source.stationCode = :sourceCode " +
            "AND ts.destination.stationCode = :destinationCode")
    List<TrainSchedule> findTrainByStationCode(@Param("sourceCode") String sourceCode,
                                               @Param("destinationCode") String destinationCode);

    @Query("SELECT ts FROM TrainSchedule ts " +
            "WHERE ts.source.stationName = :sourceName " +
            "AND ts.destination.stationName = :destinationName")
    List<TrainSchedule> findTrainByStationName(@Param("sourceName") String sourceName,
                                               @Param("destinationName") String destinationName);

}
