package com.genie.TrainApplication.controller;

import com.genie.TrainApplication.entity.Train;
import com.genie.TrainApplication.service.TrainService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "Train APIs",
        description = "Perform CREATE and READ operations on Train"
)
@RestController
@RequestMapping("/trains")
@AllArgsConstructor
public class TrainController {

    private TrainService trainService;

    @Operation(
            summary = "Fetch All Trains",
            description = "A REST API operation to fetch all the Trains"
    )
    @GetMapping
    public List<Train> getAllTrains(){
        return trainService.getAllTrains();
    }

    @Operation(
            summary = "Add New Train",
            description = "A REST API operation to create/add new Train"
    )
    @PostMapping
    public Train addTrain(@RequestBody Train train){
        return trainService.addTrain(train);
    }

}
