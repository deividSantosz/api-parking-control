package com.api.parkingcontrol.services;

import com.api.parkingcontrol.dtos.ParkingSpotDTO;
import com.api.parkingcontrol.entities.ParkingSpotEntity;
import com.api.parkingcontrol.repositories.ParkingSpotRepository;
import jakarta.transaction.Transactional;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ParkingSpotService {


    @Autowired
    ParkingSpotRepository repository;

    @Transactional
    public ParkingSpotEntity save(ParkingSpotEntity parkingSpotEntity) {
        return repository.save(parkingSpotEntity);
    }

    public boolean existsByLicensePlateCar(String licensePlateCar) {
        return repository.existsByLicensePlateCar(licensePlateCar);
    }

    public boolean existsByParkingSpotNumber(String parkingSpotNumber) {
        return repository.existsByParkingSpotNumber(parkingSpotNumber);
    }

    public boolean existsByApartmentAndBlock(String apartment, String block) {
        return repository.existsByApartmentAndBlock(apartment, block);
    }

    public List<ParkingSpotEntity> findAll () {
        return repository.findAll();
    }

    public Optional<ParkingSpotEntity> findById (UUID id)  {
          return repository.findById(id);
    }
    @Transactional
    public void delete(ParkingSpotEntity parkingSpotEntity) {
         repository.delete(parkingSpotEntity);
    }

    @Transactional
    public ParkingSpotEntity update(UUID id, ParkingSpotDTO obj) {
        ParkingSpotEntity entity = repository.getReferenceById(id);
        updateData(entity, obj);
        return repository.save(entity);
    }
    private void updateData(ParkingSpotEntity entity, ParkingSpotDTO obj) {
        entity.setParkingSpotNumber(obj.getParkingSpotNumber());
        entity.setLicensePlateCar(obj.getLicensePlateCar());
        entity.setApartment(obj.getApartment());
        entity.setBrandCar(obj.getBrandCar());
        entity.setModelCar(obj.getModelCar());
        entity.setResponsibleName(obj.getResponsibleName());
        entity.setBlock(obj.getBlock());
        entity.setColorCar(obj.getColorCar());
    }
}
