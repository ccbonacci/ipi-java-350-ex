package com.ipiecoles.java.java350.model;

import java.time.LocalDate;
import com.ipiecoles.java.java350.model.model.Employe;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;



public class EmployeTest {


    // Méthode Fabrice
    @Test
    public void testGetAnneeAncienneteDateEmbauche(){

        // Given : initialisation des données d'entrée
        Employe employe = new Employe("Doe", "John", "T12345",
                LocalDate.now().minusYears(6), 1500d, 1, 1.0);

        // When : Execution de la méthode à tester
        Integer anneeAnciennete = employe.getNombreAnneeAnciennete();

        // Then : Vérifications de ce qu'à fait la méthode
        Assertions.assertThat(anneeAnciennete).isEqualTo(6);
    }

    @Test
    public void testGetNbAnneeAncienneteDateEmbaucheSupNow(){

        // Given : initialisation des données d'entrée
        Employe employe = new Employe("Doe", "John", "T12345",
                LocalDate.now().minusYears(6), 1500d, 1, 1.0);

        // When : Execution de la méthode à tester
        Integer anneeAnciennete = employe.getNombreAnneeAnciennete();

        // Then : Vérifications de ce qu'à fait la méthode
        Assertions.assertThat(anneeAnciennete).isGreaterThanOrEqualTo(6);
    }

    @Test
    public void testGetNbAnneeAncienneteDateEmbaucheNull() {
        //Given
        Employe employe = new Employe();
        employe.setDateEmbauche(null);
        //When
        Integer nbAnneeAnciennete = employe.getNombreAnneeAnciennete();
        //Then
        Assertions.assertThat(nbAnneeAnciennete).isNull();
    }

    @Test
    public void testGetNbAnneeAncienneteDateEmbaucheNow(){
        //Given
        Employe employe = new Employe("Doe", "John", "T12345",
                LocalDate.now(), 1500d, 1, 1.0);
        //When
        Integer anneeAnciennete = employe.getNombreAnneeAnciennete();
        //Then
        Assertions.assertThat(anneeAnciennete).isEqualTo(0);
    }

    // Tests primeAnnuelle
//    @Test
//    public void testPrimeAnnuelleManagerDateEmbaucheNow(){
//        //Given
//        Employe employe = new Employe("Doe", "John", "T12345",
//                LocalDate.now(), 1500d, 0, 1.0);
//        //When
//        Double salaire = employe.getSalaire();
//        //Then
//        Assertions.assertThat(salaire).isEqualTo(1500);
//    }
//
//    @Test
//    public void testPrimeAnnuelleManagerAnneeEmbaucheMinusOne(){
//        // Given
//        Employe employe = new Employe("Doe", "John", "T12345",
//                LocalDate.now(), 1500d, 0, 1.0);
//
//        // When
//        Double salaire = employe.getSalaire();
//
//        // Then
//        Assertions.assertThat(salaire).isEqualTo(1500);
//    }


}
