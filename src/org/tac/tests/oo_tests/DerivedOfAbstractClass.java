package org.tac.tests.oo_tests;

public class DerivedOfAbstractClass extends BaseAbstractClass
{
    public String classPublicName = "";
    private String classPrivateName = "";

    public DerivedOfAbstractClass() {
        super();
        classPrivateName = this.getClass().getCanonicalName() + "-Private";
        classPublicName = this.getClass().getCanonicalName() + "-Public";
    }

    public void publicMethod(String hook) {
        System.out.println("Debug for " + classPrivateName + ": " + hook);
    }
}
