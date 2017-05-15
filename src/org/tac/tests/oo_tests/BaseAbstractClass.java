package org.tac.tests.oo_tests;

public abstract class BaseAbstractClass
{
    private String className = "";

    public BaseAbstractClass() {
        className = this.getClass().getCanonicalName();
    }

    public void publicMethod(String hook) {
        System.out.println("Debug for " + className + ": " + hook);
    }
}
