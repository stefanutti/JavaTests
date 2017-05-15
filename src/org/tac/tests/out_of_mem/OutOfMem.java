package org.tac.tests.out_of_mem;

import java.util.ArrayList;

public class OutOfMem
{
    public static void main(String[] args)
    {
        ArrayList stringList = new ArrayList();
        
        while (true) {
            String memoryLeak = "memory leak";
            
            stringList.add(memoryLeak);
        }
    }
}
