package com.magacho.camp_gladiator_test.trainer.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TrainerDTO {

    private String id;
    private String email;
    private String phone;
    private String first_name;
    private String last_name;
}
