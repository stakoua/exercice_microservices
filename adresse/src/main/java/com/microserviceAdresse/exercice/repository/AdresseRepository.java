package com.microserviceAdresse.exercice.repository;

import com.microserviceAdresse.exercice.model.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdresseRepository extends JpaRepository<Adresse,Integer> {
    @Query(value = "SELECT a FROM Adresse a WHERE a.ville =?1 and  a.rue =?2 and a.codePostale=?3")
    Optional<Adresse> findAdresseByVille(String ville,String rue, int codePostale);

}
