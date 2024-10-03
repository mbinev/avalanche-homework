package com.avalanche.homework.starship.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "starships")
public class Starship {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "starship_class")
    private String starshipClass;

    @Column(name = "captain")
    private String captain;

    @Column(name = "launched_year")
    private String launchedYear;

}
