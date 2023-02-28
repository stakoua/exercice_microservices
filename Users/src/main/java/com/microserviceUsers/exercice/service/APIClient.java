package com.microserviceUsers.exercice.service;

import com.microserviceUsers.exercice.Dto.AdresseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(value = "ADRESSE-SERVICE", url = "http://localhost:8083")
public interface APIClient {
    @GetMapping(value = "/api/adresse/{id}")
    AdresseDto getAdresseById(@PathVariable("id") int adresseId);

}
