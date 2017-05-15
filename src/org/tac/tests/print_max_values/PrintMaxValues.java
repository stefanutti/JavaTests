package org.tac.tests.print_max_values;

import java.math.BigInteger;

public class PrintMaxValues
{
    public static void main(String[] args)
    {
        // Integers
        //
        byte bLargestByte = Byte.MAX_VALUE;
        short sLargestShort = Short.MAX_VALUE;
        int iLargestInteger = Integer.MAX_VALUE;
        long lLargestLong = Long.MAX_VALUE;

        // Real numbers
        //
        float fLargestFloat = Float.MAX_VALUE;
        double dLargestDouble = Double.MAX_VALUE;

        // Big numbers
        //
        BigInteger bigInteger = new BigInteger("111111111111111111111111111111111111111111111111111111111222222222222222222222222222");

        // display them all
        //
        System.out.println("The largest byte value is: " + bLargestByte);
        System.out.println("The largest short value is: " + sLargestShort);
        System.out.println("The largest integer value is: " + iLargestInteger);
        System.out.println("The largest long value is: " + lLargestLong);

        System.out.println("The largest float value is: " + fLargestFloat);
        System.out.println("The largest double value is: " + dLargestDouble);
        
        System.out.println("The bigInteger value is: " + bigInteger.toString());
    }
}
