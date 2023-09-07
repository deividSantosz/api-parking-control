package com.api.parkingcontrol.controllers;

import com.api.parkingcontrol.dtos.ParkingSpotDTO;
import com.api.parkingcontrol.entities.ParkingSpotEntity;
import com.api.parkingcontrol.services.ParkingSpotService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/ParkingSpots")
public class ParkingSpotController {

    @Autowired
    ParkingSpotService service;

    @PostMapping
    public ResponseEntity<Object> saveParkingSpot(@RequestBody @Valid ParkingSpotDTO parkingSpotDTO) {
        var parkingSpotEntity = new ParkingSpotEntity();
        BeanUtils.copyProperties(parkingSpotDTO, parkingSpotEntity);
        parkingSpotEntity.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(ParkingSpotService.save(parkingSpotEntity));
    }
}
