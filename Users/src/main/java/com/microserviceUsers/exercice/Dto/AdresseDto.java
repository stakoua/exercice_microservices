package com.microserviceUsers.exercice.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AdresseDto {

    private String rue;
    private int codePostale;
    private String ville;
}
