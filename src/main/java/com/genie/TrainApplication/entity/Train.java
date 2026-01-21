package com.genie.TrainApplication.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Schema(
        name = "Train",
        description = "It holds train information"
)
@Entity
@Data
public class Train {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String trainName;

    @Column(nullable = false, unique = true)
    private String trainNumber;

    @OneToMany(mappedBy = "train", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<TrainSchedule> trainSchedules;
}
