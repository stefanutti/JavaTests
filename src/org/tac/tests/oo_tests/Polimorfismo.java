package org.tac.tests.oo_tests;

public class Polimorfismo
{
    public static void main(String[] args) {
        Base base = new Derived();
        
        base.debug("test");
    }
}
