package org.tac.tests.math;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class SwapsTest {
    public static void main(String[] args) {
        
        // A string compacted representation of a graph
        //
        // NOTE:
        // - The vertexes of a graph can be arranged on a grid
        // - The rows of the grid (10x5) can be joined together in a single row (50)
        //
        //   "R W" --\
        //   " GB" ---> "R W GBRWG" 
        //   "RWG" --/
        //
        String base = " R  WGGRBRBW  R RW";
        List<String> swaps = new LinkedList<String>();

        // R --> GBW
        // G --> BW
        // B --> W
        //
        swapAllColors(base, swaps);

        // Loop for many cycles: as many as you like
        //
        for (int a = 0; a < 100; a++) {
            int currentSize = swaps.size();
            for (int i = 0; i < currentSize; i++) {
                swapAllColors(swaps.get(i), swaps);
            }

            // Removes duplicates: copy to HashSet and copy back to List
            //
            HashSet<String> hashSetTemp = new HashSet<String>(swaps);
            swaps = new LinkedList<String>(hashSetTemp);
        }

        // Print the base string and all replaced strings (sorted and with duplicates removed)
        // RESULT MUST BE: 24 = 4! = 4 colors * 3 colors * 2 colors
        //
        System.out.println("ORIG: " + base);
        for (int i = 0; i < swaps.size(); i++) {
            System.out.println("SWAP: " + (i + 1) + " " + swaps.get(i));
        }
    }

    private static void swapAllColors(String toSwap, List<String> swaps) {

        // R --> GBW
        // G --> BW
        // B --> W
        //
        swaps.add(swapChars(toSwap, 'R', 'G'));
        swaps.add(swapChars(toSwap, 'R', 'B'));
        swaps.add(swapChars(toSwap, 'R', 'W'));
        swaps.add(swapChars(toSwap, 'G', 'B'));
        swaps.add(swapChars(toSwap, 'G', 'W'));
        swaps.add(swapChars(toSwap, 'B', 'W'));
    }

    private static String swapChars(String toSwap, char a, char b) {
        return toSwap.replace(a, 'X').replace(b, a).replace('X', b);
    }
}
