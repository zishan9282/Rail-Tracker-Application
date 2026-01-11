package com.genie.TrainApplication.service;

import com.genie.TrainApplication.entity.TrainSchedule;
import com.genie.TrainApplication.repository.TrainScheduleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TrainSearchService {

    private TrainScheduleRepository trainScheduleRepository;

    public List<TrainSchedule> findTrainByStationCode(String sourceCode, String destinationCode) {
        return trainScheduleRepository.findTrainByStationCode(sourceCode, destinationCode);
    }

    public List<TrainSchedule> findTrainByStationName(String sourceName, String destinationName) {
        return trainScheduleRepository.findTrainByStationName(sourceName, destinationName);
    }
}
