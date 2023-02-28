package com.microserviceAdresse.exercice.service;

import com.microserviceAdresse.exercice.model.Adresse;
import com.microserviceAdresse.exercice.repository.AdresseRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AdresseServiceImpl implements IAdresseService {
    @Autowired
     AdresseRepository adresseRepository;
    @Override
    public Optional<Adresse> getAdresseById(int id) {
        return adresseRepository.findById(id);
    }

    @Override
    public List<Adresse> getAllAdresses() {
        return adresseRepository.findAll();
    }

    @Override
    public Adresse createAdresse(Adresse adresse) {
        return adresseRepository.save(adresse);
    }

    @Override
    public Adresse updateAdresse(Adresse adresse, int id) {
        Optional<Adresse> adresseFound = adresseRepository.findById(id);
        if(adresseFound.isEmpty())  {return null;}

        else {
           adresseFound.get().setCodePostale(adresse.getCodePostale());
            adresseFound.get().setRue(adresse.getRue());
            adresseFound.get().setVille(adresse.getVille());
           return  adresseFound.get();
        }

    }

    @Override
    public void deleteAdresse(int id) {
        adresseRepository.deleteById(id);
    }
}
