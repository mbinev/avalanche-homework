package com.avalanche.homework.migrator.processors;


import com.avalanche.homework.starship.model.Starship;
import com.avalanche.homework.vessel.model.Vessel;
import org.springframework.batch.item.ItemProcessor;


public class StarshipVesselProcessor implements ItemProcessor<Starship, Vessel> {

    @Override
    public Vessel process(Starship starship) {
        return new Vessel(
                starship.getId(),
                starship.getName(),
                starship.getStarshipClass(),
                starship.getCaptain(),
                starship.getLaunchedYear()
        );
    }

}
