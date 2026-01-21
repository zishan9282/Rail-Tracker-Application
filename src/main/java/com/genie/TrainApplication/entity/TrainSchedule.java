package com.genie.TrainApplication.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

@Schema(
        name = "Train Schedule",
        description = "It holds Train arrival and departure time  along with Train information and Source-Destination Station information"
)
@Entity
@Data
public class TrainSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String arrivalTime;

    @Column(nullable = false)
    private String departureTime;

    @ManyToOne
    @JoinColumn(name = "train_id", nullable = false)
    @JsonBackReference
    private Train train;

    @ManyToOne
    @JoinColumn(name = "source_id", nullable = false)
    private Station source;

    @ManyToOne
    @JoinColumn(name = "destination_id", nullable = false)
    private Station destination;
}
