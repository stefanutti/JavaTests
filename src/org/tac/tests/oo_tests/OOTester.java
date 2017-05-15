package org.tac.tests.oo_tests;

public class OOTester
{
    public static void main(String[] args) {
        // BaseAbstractClass baseAbstractClass = new BaseAbstractClass(); // Cannot instantiate the type BaseAbstractClass
        //
        BasePublicClass basePublicClass = new BasePublicClass();
        ImplementingInterfaceClass implementingInterfaceClass = new ImplementingInterfaceClass();
        DerivedOfPublicClass derivedOfPublicClass = new DerivedOfPublicClass();

        basePublicClass.publicMethod("uno");
        implementingInterfaceClass.publicMethod("due");
        derivedOfPublicClass.publicMethod("tre");
    }
}
