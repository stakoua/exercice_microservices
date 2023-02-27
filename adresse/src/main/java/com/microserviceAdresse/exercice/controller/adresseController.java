package com.microserviceAdresse.exercice.controller;

import com.microserviceAdresse.exercice.model.Adresse;
import com.microserviceAdresse.exercice.repository.AdresseRepository;
import com.microserviceAdresse.exercice.service.AdresseServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/adresse")
//open for all ports
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class adresseController {
    private final AdresseServiceImpl adresseServiceImpl;
    private final AdresseRepository adresseRepository;
    @GetMapping("/")
    public List<Adresse> getAllAdresse(){
        return adresseServiceImpl.getAllAdresses();
    }
    @PostMapping("/")
    public ResponseEntity<Adresse> createAdresse(@RequestBody  Adresse adresse){
        Optional<Adresse> adresseFound= adresseRepository.findAdresseByVille(adresse.getVille(), adresse.getRue(), adresse.getCodePostale());

        if(adresseFound.isEmpty() ){
            Adresse adresseCreated =adresseServiceImpl.createAdresse(adresse);
            return  ResponseEntity.status(201).body(adresseCreated);
        }else{return ResponseEntity.status(204).body(null); }

    }
}
