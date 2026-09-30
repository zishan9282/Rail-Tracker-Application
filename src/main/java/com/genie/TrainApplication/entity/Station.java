package com.genie.TrainApplication.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

@Schema(
        name = "Station",
        description = "It holds the Station information"
)
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Station {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stationId;

    @Column(nullable = false)
    private String stationName;

    @Column(nullable = false, unique = true)
    private String stationCode;
}
