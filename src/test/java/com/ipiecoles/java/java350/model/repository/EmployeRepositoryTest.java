package com.ipiecoles.java.java350.model.repository;

import com.ipiecoles.java.java350.model.model.Employe;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;


//@ExtendWith(SpringExtension.class)  //Junit 5 et spring de base sans utiliser SpringBoot
//@ContextConfiguration(classes = {Java350Application.class})

// @DataJpaTest  ou...
@SpringBootTest
class EmployeRepositoryTest {


    @Autowired
    EmployeRepository employeRepository;


    @Test
    public void testFindLastMatricule1Employe() {
        // Given créer et sauvegarder en bdd un employé
        // Inserer des données en bdd
        employeRepository.save(new Employe("Doe", "John", "T12345", LocalDate.now(), 1500d, 1, 1.0));
        // When
        // Executer des requêtes en bdd

        String matricule = employeRepository.findLastMatricule();

        // Then
        Assertions.assertThat(matricule).isEqualTo("12345");
    }


    @Test
    public void testFindLastMatricule0Employe() {
        // Given on ne crée pas et ni ne sauvegarde en bdd un employé
        // Pas d'insersion des données en bdd

        // When
        // Executer des requêtes en bdd

        String lastMatricule = employeRepository.findLastMatricule();

        // Then
        Assertions.assertThat(lastMatricule).isNull();
    }


    //
    @Test
    public void testFindLastMatriculeNEmploye() {
        // Given on crée plusieurs et sauvegarde en bdd les employés
        // Insersion des données en bdd
        employeRepository.save(new Employe("Doe", "John", "T12345", LocalDate.now(), 1500d, 1, 1.0));
        employeRepository.save(new Employe("Doe", "John", "M23456", LocalDate.now(), 1500d, 1, 1.0));
        employeRepository.save(new Employe("Doe", "John", "C00027", LocalDate.now(), 1500d, 1, 1.0));

        // When
        // Executer des requêtes en bdd

        String lastMatricule = employeRepository.findLastMatricule();

        // Then
        Assertions.assertThat(lastMatricule).isEqualTo("23456");
    }

    @BeforeEach
    @AfterEach
    public void cleanBdd(){ // setup dans la correction
        employeRepository.deleteAll();
    }


//    @Test
//    public void testAvgPerformanceWhereMatriculeStartsWith() {
//        // Given
//        // When
//        // Then
//    }
}