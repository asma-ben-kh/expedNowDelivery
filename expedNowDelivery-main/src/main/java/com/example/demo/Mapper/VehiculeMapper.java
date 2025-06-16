package com.example.demo.Mapper;


import org.springframework.stereotype.Component;

import com.example.demo.ModelDTO.VehiculeDTO;
import com.example.demo.ModelDomain.Vehicule;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")

public interface VehiculeMapper {

    VehiculeMapper INSTANCE = Mappers.getMapper(VehiculeMapper.class);

    VehiculeDTO toDto(Vehicule vehicule);

    Vehicule toEntity(VehiculeDTO vehiculeDTO);

    void updateVehiculeFromDTO(VehiculeDTO vehiculeDTO,@MappingTarget VehiculeDTO vehiculeDTOUpdated );
}