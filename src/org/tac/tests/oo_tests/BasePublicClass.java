package org.tac.tests.oo_tests;

public class BasePublicClass
{
    public String classPublicName = "";
    private String classPrivateName = "";

    public BasePublicClass() {
        classPrivateName = this.getClass().getCanonicalName() + "-Private";
        classPublicName = this.getClass().getCanonicalName() + "-Public";
    }

    public void publicMethod(String hook) {
        System.out.println("Debug for " + classPrivateName + ": " + hook);
    }
}
