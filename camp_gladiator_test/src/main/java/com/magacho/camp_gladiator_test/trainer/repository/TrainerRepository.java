package com.magacho.camp_gladiator_test.trainer.repository;

import com.magacho.camp_gladiator_test.trainer.model.Trainer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainerRepository extends MongoRepository<Trainer, String> {
}
