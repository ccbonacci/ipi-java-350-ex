package com.ipiecoles.java.java350.model;

import java.time.LocalDate;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


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
        //Given : initialisation des données d'entrée
        Employe employe = new Employe();
        employe.setDateEmbauche(null);
        //When : Execution de la méthode à tester
        Integer nbAnneeAnciennete = employe.getNombreAnneeAnciennete();
        //Then : Vérifications de ce qu'à fait la méthode
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
    @Test
    public void testPrimeAnnuelleManagerDateEmbaucheNow(){
        //Given
        Employe employe = new Employe("Doe", "John", "T12345",
                LocalDate.now(), 1500d, 0, 1.0);
        //When
        Double salaire = employe.getSalaire();
        //Then
        Assertions.assertThat(salaire).isEqualTo(1500);
    }


    @Test
    public void testPrimeAnnuelleManagerAnneeEmbaucheMinusOne(){
        // Given
        Employe employe = new Employe("Doe", "John", "T12345",
                LocalDate.now(), 1500d, 0, 1.0);
        // When
        Double salaire = employe.getSalaire();
        // Then
        Assertions.assertThat(salaire).isEqualTo(1500);
    }


    // TEST GET PRIME ANNUELLE
    @Test void testGetPrimeAnnuelle(){
        // Given
        Integer performance = 1;
        String matricule = "T12345";
        Double tauxActivite = 1.0;
        Long nbAnneeAnciennete = 0L ;

        Employe employe = new Employe("Doe", "John", matricule,
                LocalDate.now().minusYears(nbAnneeAnciennete), 1500d, performance, tauxActivite);

        // When
        Double prime = employe.getPrimeAnnuelle();

        // Then
        Double primeAttendue = 1000.0;
        Assertions.assertThat(prime).isEqualTo(primeAttendue);
    }

    // un sénario test paramétré GET PRIME ANNUELLE
    @ParameterizedTest(name = "Perf {0}, matricule {1}, txActivite {2}, anciennete {3} => prime {4}")
    @CsvSource({
            "1, 'T12345', 1.0, 0, 1000.0",
            "1, 'T12345', 0.5, 0, 500.0",
            "2, 'T12345', 1.0, 0, 2300.0",
            "1, 'T12345', 1.0, 2, 1200.0",
            "2, 'T12345', 1.0, 1, 2400.0",
            "1, 'M12345', 1.0, 0, 1700.0",
            "1, 'M12345', 1.0, 3, 2000.0"
    })
    public void testGetPrimeAnnuelle(Integer performance, String matricule, Double tauxActivite, Long nbAnneeAnciennete, Double primeAttendue){
        // Given

        Employe employe = new Employe("Doe", "John", matricule,
                LocalDate.now().minusYears(nbAnneeAnciennete), 1500d, performance, tauxActivite);

        // When
        Double prime = employe.getPrimeAnnuelle();

        // Then
        Assertions.assertThat(prime).isEqualTo(primeAttendue);
    }


    // Test de CAS LIMITE en test simple
    @Test
    public void testGetPrimeAnnuelleMatriculeNull(){
        // Given
        Employe employe = new Employe("Doe", "John", null,
                LocalDate.now(), 1500d, 1, 1.0);

        // When
        Double prime = employe.getPrimeAnnuelle();

        // Then
        Assertions.assertThat(prime).isEqualTo(1000);
    }

    /**
    * Test augmenter le Salaire
    */
    // pourcentage à 20%
    @Test
    public void testAugmenterSalairePourcentage20(){
        // Given
        Employe employe = new Employe("Doe", "John", null, LocalDate.now(), 1500d, 1, 1.0);
        Double pourcentage = 0.2;

        // When
        Double salaire = employe.augmenterSalaire(pourcentage);

        // Then
        Assertions.assertThat(salaire).isEqualTo(1800);
    }
    // Si le pourcentage = 0
    @Test
    public void testAugmentationSalairePourcentage0(){
        // Given
        Employe employe = new Employe("Doe", "John", null, LocalDate.now(), 1500d, 1, 1.0);
        Double pourcentage = 0.0;

        // When
        Double salaire = employe.augmenterSalaire(pourcentage);

        // Then
        Assertions.assertThat(salaire).isEqualTo(1500);
    }
    // CAS LIMITES
    // Si le pourcentage = null
    // Si le pourcentage is NaN


    // un sénario Test Paramétrés Get Nombres Rtt
    // l'année de référence, si elle est bissextile et a débuter

    @ParameterizedTest(name = "dateReference {0} est bissextile : {1}, premierJourAnnée {2}, nbJoursFeries {3} pendant un week-end : {4}, nbRtt {5}")
    @CsvSource({
            "2019-01-01, false, 'tuesday', 10, false, 8",
            "2021-12-03, false, 'wednesday', 7, false, 10",
            "2022-04-09, false, 'saturday', 7, false, 10",
            "2032-01-31, true, 'thursday', 7, false, 11"
    })
    public void testGetNbRtt(LocalDate dateReference, Boolean result, String premierJourAnnée, int nbJoursFeries, Boolean result2, int nbRtt ){
        // Given
        Employe employe = new Employe("Doe", "John", null, LocalDate.now(), 1500d, 1, 1.0);
        // When
        int nombreRtt = employe.getNbRtt(dateReference);

        // Then Assertions.assertThat(prime).isEqualTo(primeAttendue);
        Assertions.assertThat(nombreRtt).isEqualTo(nbRtt);

    }







}
