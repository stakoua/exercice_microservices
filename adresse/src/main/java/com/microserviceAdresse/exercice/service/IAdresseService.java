package com.microserviceAdresse.exercice.service;

import com.microserviceAdresse.exercice.model.Adresse;

import java.util.List;
import java.util.Optional;


public interface IAdresseService {
    Optional<Adresse> getAdresseById (int id);
    List<Adresse> getAllAdresses ();
    Adresse createAdresse (Adresse adresse);
    Adresse updateAdresse (Adresse adresse,int id);
    void deleteAdresse (int id);

}
