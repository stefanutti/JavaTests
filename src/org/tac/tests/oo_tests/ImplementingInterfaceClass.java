package org.tac.tests.oo_tests;

public class ImplementingInterfaceClass implements InterfaceClass
{
    private String className = "";

    public ImplementingInterfaceClass() {
        className = this.getClass().getCanonicalName();
    }

    public void publicMethod(String hook) {
        // interfaceMember = ""; The final field InterfaceClass.interfaceMember cannot be assigned
        //
        System.out.println("Debug for " + className + ": " + hook);
        System.out.println("Debug for " + className + ": " + interfaceMember);
    }
}
