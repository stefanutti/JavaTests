package org.tac.tests.clone;

public class A
{
    int value = 0;

    /**
     * @param value
     */
    public A(int value) {
        super();
        this.value = value;
    }

    public String toString() {
        return "" + super.toString() + ": " + this.value;
    }
}
