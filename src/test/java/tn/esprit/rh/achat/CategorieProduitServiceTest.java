package tn.esprit.rh.achat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.rh.achat.entities.CategorieProduit;
import tn.esprit.rh.achat.services.CategorieProduitServiceImpl;
import tn.esprit.rh.achat.services.ICategorieProduitService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class CategorieProduitServiceTest {

    @Mock
    private ICategorieProduitService categorieProduitService;

    @InjectMocks
    private CategorieProduitServiceImpl categorieProduitServiceImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void initTest() {
        Assertions.assertNotNull(categorieProduitService);
        Assertions.assertNotNull(categorieProduitServiceImpl);
    }
}
