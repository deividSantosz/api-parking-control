package com.api.parkingcontrol.services;

import com.api.parkingcontrol.entities.ParkingSpotEntity;
import com.api.parkingcontrol.repositories.ParkingSpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkingSpotService {
    @Autowired
    ParkingSpotRepository repository;

    public ParkingSpotEntity save(ParkingSpotEntity obj) {
        return repository.save(obj);

    }

}
