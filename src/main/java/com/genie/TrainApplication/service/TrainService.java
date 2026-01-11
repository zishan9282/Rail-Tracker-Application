package com.genie.TrainApplication.service;

import com.genie.TrainApplication.entity.Train;
import com.genie.TrainApplication.exception.TrainAlreadyExistsException;
import com.genie.TrainApplication.repository.TrainRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TrainService {

    private TrainRepository trainRepository;

    public List<Train> getAllTrains() {
        return trainRepository.findAll();
    }

    public Train addTrain(Train train) {
        Optional<Train> byTrainNumber = trainRepository.findByTrainNumber(train.getTrainNumber());
        if (byTrainNumber.isPresent()){
            throw new TrainAlreadyExistsException("Train Already Exists");
        }
        return trainRepository.save(train);
    }
}
