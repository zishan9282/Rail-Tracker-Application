package com.genie.TrainApplication.controller;

import com.genie.TrainApplication.entity.TrainSchedule;
import com.genie.TrainApplication.service.TrainSearchService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(
        name = "Train Search APIs",
        description = "Perform READ operation on Train"
)
@RestController
@RequestMapping("/search")
@AllArgsConstructor
public class TrainSearchController {

    private TrainSearchService trainSearchService;

    @Operation(
            summary = "Fetch Train by Code",
            description = "We can search train by Station Code from Station Source Code to Station Destination Code"
    )
    @GetMapping("/by-code")
    public List<TrainSchedule> findTrainByStationCode(@RequestParam String sourceCode,
                                                      @RequestParam String destinationCode){
        return trainSearchService.findTrainByStationCode(sourceCode.toUpperCase(), destinationCode.toUpperCase());
    }

    @Operation(
            summary = "Fetch Train by Name",
            description = "We can search train by Station Name from Station Source Name to Station Destination Name"
    )
    @GetMapping("/by-name")
    public List<TrainSchedule> findTrainByStationName(@RequestParam String sourceName,
                                                      @RequestParam String destinationName){
        return trainSearchService.findTrainByStationName(sourceName, destinationName);
    }
}
