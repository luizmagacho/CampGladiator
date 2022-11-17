package com.magacho.camp_gladiator_test.trainer.model.mapper;

import com.magacho.camp_gladiator_test.trainer.model.Trainer;
import com.magacho.camp_gladiator_test.trainer.model.dto.TrainerDTO;

import java.util.UUID;

public class TrainerMapper {

    public static Trainer fromDtoToEntity(TrainerDTO dto){
        return Trainer.builder()
                .id(dto.getId())
                .email(dto.getEmail())
                .first_name(dto.getFirst_name())
                .last_name(dto.getLast_name())
                .phone(dto.getPhone()).build();
    }

    public static TrainerDTO fromEntityToDto(Trainer entity){
        return TrainerDTO.builder()
                .id(entity.getId())
                .email(entity.getEmail())
                .first_name(entity.getFirst_name())
                .last_name(entity.getLast_name())
                .phone(entity.getPhone())
                .build();
    }
}
