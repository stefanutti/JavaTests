package org.tac.tests.oo_tests;

public interface InterfaceClass
{
    final public String interfaceMember = "Una classe derivata può utilizzare un interfaceMember"; // Non va in errore. Ma a che serve? R: guarda il valore del metono

    // protected void publicMethod(String hook); Illegal modifier for the interface method InterfaceClass.publicMethod1(); only public & abstract are permitted
    public void publicMethod(String hook);
}
