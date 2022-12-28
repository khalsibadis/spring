package com.esprit.examen.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.springframework.boot.test.context.SpringBootTest;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import com.esprit.examen.entities.Facture;
import com.esprit.examen.repositories.FactureRepository;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@ExtendWith(MockitoExtension.class)

@MockitoSettings(strictness = Strictness.LENIENT)
class FactureServiceImplTest {

      @Mock
    FactureRepository factureRepository;

    @InjectMocks
    FactureServiceImpl factureService;

      @Test
    public void testRetrieveFacture() {

        Facture facture = new Facture(1L, 100, 500, null, null, null, null, null, null);

        facture.setIdFacture(1L);

        when(factureRepository.findById(1L)).thenReturn(Optional.of(facture));
        factureService.retrieveFacture(1L);
        Assertions.assertNotNull(facture);

        System.out.println(facture);
        System.out.println(" Retrieve is working correctly...!!");

    }


    @Test
    public void createFacturekTest()
    {
        Facture facture2 = new Facture(2L, 100, 500, null, null, null, null, null, null);
        facture2.setIdFacture(2L);

        factureService.addFacture(facture2);
        verify(factureRepository, times(1)).save(facture2);
        System.out.println(facture2);
        System.out.println(" Create is working correctly...!!");
    }


    @Test
    public void getAllFactureTest()
    {
        List<Facture> Facturelist = new ArrayList<Facture>() {

            {
                add(new Facture(3L, 100, 700, null, null, null, null, null, null));
                add(new Facture(4L, 200, 800, null, null, null, null, null, null));
                add(new Facture(5L, 300, 900, null, null, null, null, null, null));
            }};


        when(factureService.retrieveAllFactures()).thenReturn(Facturelist);
        //test
        List<Facture> factureList = factureService.retrieveAllFactures();
        assertEquals(3, factureList.size());
        System.out.println(" Retrieve all is working correctly...!!");
    }
    



};