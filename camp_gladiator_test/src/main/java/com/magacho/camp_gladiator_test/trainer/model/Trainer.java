package com.magacho.camp_gladiator_test.trainer.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@Builder
public class Trainer {

    @Id
    private String id;
    private String email;
    private String phone;
    private String first_name;
    private String last_name;
}
