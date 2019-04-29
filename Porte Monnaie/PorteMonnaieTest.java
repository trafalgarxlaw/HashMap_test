import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PorteMonnaieTest {
    private static PorteMonnaie MonPorteMonnais;
    private static PorteMonnaie PorteMonnaisExpected;
    private static SommeArgent  Somme1;
    private static SommeArgent  Somme2;
    private static SommeArgent  Somme3;
    private static SommeArgent  Somme4;
    private static SommeArgent  Somme5;
    private static SommeArgent  Somme6;



    @BeforeEach
    void setUp() {
        Somme1=new SommeArgent(5,"EUR");
        Somme2=new SommeArgent(10,"EUR");
        Somme3=new SommeArgent(1000,"USD");
        Somme4=new SommeArgent(1005,"EUR");
        Somme5=new SommeArgent(4500,"CHF");
        Somme6=new SommeArgent(9000,"CHF");

        MonPorteMonnais= new PorteMonnaie();
        MonPorteMonnais.ajouteSomme(Somme1);// il y a 5euros dans le porte monnais




    }

    @AfterEach
    void tearDown() {
    }

    //Cas normaux
    @Test
    void ajouteSomme() {
        PorteMonnaisExpected= new PorteMonnaie();
        PorteMonnaisExpected.ajouteSomme(Somme2);

        //Euros
        MonPorteMonnais.ajouteSomme(Somme1);// On ajoute 5 euros dans mon porte monnais
        assertEquals(PorteMonnaisExpected.getContenu(),MonPorteMonnais.getContenu());
        //USD
        PorteMonnaisExpected.ajouteSomme(Somme3);
        MonPorteMonnais.ajouteSomme(Somme3);// On ajoute 1000 USD dans mon porte monnais
        assertEquals(PorteMonnaisExpected.getContenu(),MonPorteMonnais.getContenu());

        //CHF
        PorteMonnaisExpected.ajouteSomme(Somme6);
        MonPorteMonnais.ajouteSomme(Somme5);
        MonPorteMonnais.ajouteSomme(Somme5);
        assertEquals(PorteMonnaisExpected.getContenu(),MonPorteMonnais.getContenu());



    }
    //Cas anormaux
    @Test
    public void whenExceptionThrown_thenAssertionSucceeds() {

        PorteMonnaisExpected= new PorteMonnaie();
        PorteMonnaisExpected.ajouteSomme(Somme4);

        assertThrows(org.opentest4j.AssertionFailedError.class, () -> {
            MonPorteMonnais.ajouteSomme(Somme3);
            assertEquals(PorteMonnaisExpected.getContenu(),MonPorteMonnais.getContenu());
            //est supposer donner une erreur car on ajoute 1000$ USD a 5 Euros.
            // Ce qui ne donne pas 1005 Euros (somme4).
        });
    }
}