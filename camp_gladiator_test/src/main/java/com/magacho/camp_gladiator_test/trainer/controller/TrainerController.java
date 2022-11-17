package com.magacho.camp_gladiator_test.trainer.controller;

import com.magacho.camp_gladiator_test.trainer.model.dto.TrainerDTO;
import com.magacho.camp_gladiator_test.trainer.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/camp_gladiator/trainer")
public class TrainerController {

    @Autowired private TrainerService trainerService;

    @PostMapping
    public ResponseEntity<TrainerDTO> createTrainer(@RequestBody TrainerDTO trainerDTO) {
        return ResponseEntity.ok(trainerService.createTrainer(trainerDTO));
    }

    @GetMapping("/{trainerId}")
    public ResponseEntity<TrainerDTO> getTrainerById(@PathVariable("trainerId") String trainerId){
        return ResponseEntity.ok(trainerService.getTrainerDetailsById(trainerId));
    }
}
