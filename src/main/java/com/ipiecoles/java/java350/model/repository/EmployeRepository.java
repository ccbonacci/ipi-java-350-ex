package com.ipiecoles.java.java350.model.repository;

import com.ipiecoles.java.java350.model.model.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeRepository extends JpaRepository<Employe, Long> {

    // Interface à tester le matricule le plus haut
    @Query("select max(substring(matricule,2)) from Employe")
    String findLastMatricule();

    Employe findByMatricule(String matricule); // Cette méthode n'est pas à tester car springdata la génère automatiquement. la requête est correcte

    // Interface à tester
    @Query("select avg(performance) from Employe where SUBSTRING(matricule,0,1) = ?1 ")
    Double avgPerformanceWhereMatriculeStartsWith(String premiereLettreMatricule);
}
