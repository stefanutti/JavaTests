package org.tac.tests.clone;

public class CloneTest
{

    /**
     * @param args
     * @throws CloneNotSupportedException 
     */
    public static void main(String[] args) throws CloneNotSupportedException {
        B b = new B(3);
        
        b.sequence.add(new A(10));
        b.sequence.add(new A(20));
        b.sequence.add(new A(30));
        b.sequence.add(new A(40));

        B bCloned = b.clone();
        
        System.out.println("Debug b: " + b.value);
        System.out.println("Debug b: " + b.sequence);
        System.out.println("Debug b: " + b.c);

        System.out.println("Debug bCloned: " + bCloned.value);
        System.out.println("Debug bCloned: " + bCloned.sequence);
        System.out.println("Debug bCloned: " + bCloned.c);
    }
}
