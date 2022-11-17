package com.magacho.camp_gladiator_test.trainer.service;

import com.magacho.camp_gladiator_test.exception.runtime.BadRequestException;
import com.magacho.camp_gladiator_test.trainer.model.Trainer;
import com.magacho.camp_gladiator_test.trainer.model.dto.TrainerDTO;
import com.magacho.camp_gladiator_test.trainer.model.mapper.TrainerMapper;
import com.magacho.camp_gladiator_test.trainer.repository.TrainerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.magacho.camp_gladiator_test.trainer.model.mapper.TrainerMapper.*;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TrainerService {

    @Autowired private final TrainerRepository repository;

    public TrainerDTO createTrainer(TrainerDTO trainerDTO){
        if(trainerDTO.getId() == null){
            trainerDTO.setId("trainer-id-" + repository.findAll().size() + 1);
        }
        return fromEntityToDto(repository.save(fromDtoToEntity(trainerDTO)));
    }

    public TrainerDTO getTrainerDetailsById(String trainerId){
        Optional<Trainer> optional = repository.findById(trainerId);
        return optional.map(TrainerMapper::fromEntityToDto).orElseThrow(() -> new BadRequestException("Trainer not found!"));
    }
}
