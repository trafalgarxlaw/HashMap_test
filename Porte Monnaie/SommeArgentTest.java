import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
//(JUnit5)



class SommeArgentTest {


    private SommeArgent somme1;
    private SommeArgent somme2;
    private SommeArgent somme3;
    private SommeArgent somme4;
    private SommeArgent somme5;
    private SommeArgent somme6;
    private SommeArgent somme7;
    private SommeArgent somme8;
    private SommeArgent somme9;
    private SommeArgent somme10;
    private SommeArgent somme11;
    private SommeArgent somme12;
    private SommeArgent somme13;
    private SommeArgent somme14;
    private SommeArgent somme15;
    private SommeArgent somme16;

    private static  int Passage = 1;





    @BeforeEach
     void setup() {   //initialisation
        if (Passage>1){
            System.out.println(Passage+"ieme passage avant exécution d'une méthode de test");

        }else {
            System.out.println(Passage + "er passage avant exécution d'une méthode de test");
        }

        //initialisation
        somme1=new SommeArgent(10,"EUR");
        somme2=new SommeArgent(15,"EUR");

        somme3=new SommeArgent(-100,"USD");
        somme4=new SommeArgent(50,"USD");

        somme5=new SommeArgent(-1000,"CHF");
        somme6=new SommeArgent(-4000,"CHF");

        somme7=new SommeArgent(0,"EUR");
        somme8=new SommeArgent(0,"USD");

        somme9=new SommeArgent(-1,"USD");
        somme10=new SommeArgent(1,"CHF");

        somme11=new SommeArgent(1,"CHF");
        somme12=new SommeArgent(1,"EUR");

        somme13=new SommeArgent(1,"USD");
        somme14=new SommeArgent(1,"EUR");

        somme15=new SommeArgent(1,"USD");
        somme16=new SommeArgent(1,"CHF");


    }


    @AfterEach
    void tearDown() {
        if (Passage > 1){
            System.out.println(Passage+"ieme passage APRES exécution d'une méthode de test");
         Passage++;
        }else {
            System.out.println(Passage + "er passage APRES exécution d'une méthode de test");
            Passage++;
        }


    }



    @Test
    public void add() throws UniteDistincteException {
        //Passing tests


        //TEST CAS NORMAUX
        somme1=somme1.add(somme2);
        assertEquals(25,somme1.getQuantite());

        somme3=somme3.add(somme4);
        assertEquals(-50,somme3.getQuantite());

        somme5=somme5.add(somme6);
        assertEquals(-5000,somme5.getQuantite());


    }

    //Exceptions expected
    @Test
    public void whenExceptionThrown_thenAssertionSucceeds() {

        //cas anormaux (devise différente)
        assertThrows(UniteDistincteException.class, () -> {
            somme7=somme7.add(somme8);
            assertEquals(0,somme7.getQuantite());
        });
        assertThrows(UniteDistincteException.class, () -> {

            somme9=somme9.add(somme10);
            assertEquals(0,somme9.getQuantite());
        });
        assertThrows(UniteDistincteException.class, () -> {

            somme11=somme11.add(somme12);
            assertEquals(2,somme11.getQuantite());
        });


    }



    @Test
    void equals(){

        assertFalse(somme11.equals(somme12));// 1 CHF != 1 EUR.


        assertFalse(somme13.equals(somme14));// 1 USD != 1 EUR.


        assertFalse(somme15.equals(somme16));// 1 USD != 1 CHF.
    }


}