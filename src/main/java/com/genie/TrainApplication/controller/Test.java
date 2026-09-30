package com.genie.TrainApplication.controller;

import com.genie.TrainApplication.entity.Station;
import com.genie.TrainApplication.entity.Train;
import com.genie.TrainApplication.entity.TrainSchedule;
import com.genie.TrainApplication.repository.StationRepository;
import com.genie.TrainApplication.repository.TrainRepository;
import com.genie.TrainApplication.repository.TrainScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class Test {
    @Autowired
    private StationRepository stationRepository;

    @Autowired
    private TrainRepository trainRepository;

    @Autowired
    private TrainScheduleRepository trainScheduleRepository;

    @GetMapping
    public void test() {
        Station delhi = new Station(null, "New Delhi", "NDLS");
        Station mumbai = new Station(null, "Mumbai Central", "CST");
        Station kolkata = new Station(null, "Kolkata", "KOAA");
        Station chennai = new Station(null, "Chennai Central", "MAS");
        stationRepository.saveAll(List.of(delhi, mumbai, kolkata, chennai));

        Train rajdhani = new Train(null, "Rajdhani Express", "12306", null);
        Train durunto = new Train(null, "Durunto Express", "12206", null);
        Train shatabdi = new Train(null, "Shatabdi Express", "12043", null);
        trainRepository.saveAll(List.of(rajdhani, durunto, shatabdi));

        TrainSchedule sc1 = new TrainSchedule(null, "06:00", "14:00",rajdhani, delhi, mumbai);
        TrainSchedule sc2 = new TrainSchedule(null, "08:00", "21:00",durunto, mumbai, kolkata);
        TrainSchedule sc3 = new TrainSchedule(null, "11:30", "19:00",shatabdi, kolkata, chennai);
        trainScheduleRepository.saveAll(List.of(sc1,sc2,sc3));

        System.out.println("data inserted into database...");
        System.out.println("Checking how to  make pr");
    }
}
