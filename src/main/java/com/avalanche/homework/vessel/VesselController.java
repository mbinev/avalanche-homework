package com.avalanche.homework.vessel;

import com.avalanche.homework.vessel.model.Vessel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/vessels")
public class VesselController {

    private final VesselRepository repository;

    @GetMapping("/all")
    public ResponseEntity<List<Vessel>> getAllVessels() {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(repository.findAll());
    }

}
