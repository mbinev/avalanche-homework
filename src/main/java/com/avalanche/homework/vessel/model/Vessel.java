package com.avalanche.homework.vessel.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "vessels")
public class Vessel {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "vessel_class")
    private String vesselClass;

    @Column(name = "captain_name")
    private String captainName;

    @Column(name = "launched_year")
    private String launchedYear;

}
