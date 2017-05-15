package org.tac.tests.number_theory;

import java.math.BigInteger;

public class PrintNumbers
{
    public static void main(String[] args)
    {
        String oStringNumber = new String(args[0]);
        int iBases = Integer.parseInt(args[1]);
        int iBaseLoop = 2;

        if (iBases > 36) {
            System.out.println("Errore la base passata e' maggiore di 36");
        }
        else {
            BigInteger oBigInteger = new BigInteger(oStringNumber);

            for (iBaseLoop = 2; iBaseLoop <= iBases; iBaseLoop++) {
                System.out.println("base " + iBaseLoop + " " + oBigInteger.toString(iBaseLoop));
            }
        }
    }
}
