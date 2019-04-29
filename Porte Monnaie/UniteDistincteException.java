/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */

public class UniteDistincteException extends Exception 
{
    private SommeArgent somme1, somme2;
    public UniteDistincteException(SommeArgent sa1, SommeArgent sa2)
    {
        somme1 = sa1;
        somme2 = sa2;
    }
    public String toString() {
    return "unité distincte : " + somme1.getUnite() + " != " +
    somme2.getUnite();
    }
}