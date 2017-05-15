package org.tac.tests.encoding;

public class EncodingTest
{
    public static void main(String[] args)
    {
        /**
         * Voglio ottenere lettere accentate in cp windows, con getBytes(), LANG
         * è impostata diversa dal cp di windows.
         */
        try {
            String lettereAccentate = "\u00e8";
            byte[] lettereAccentateCPWin = lettereAccentate.getBytes("ISO-8859-1");

            String test = new String(lettereAccentateCPWin, "UTF-8");
            byte[] bytesLettereAccentateCPWin = test.getBytes("UTF-8");

            String a1 = new String(lettereAccentateCPWin, "UTF-8");
            String a2 = new String(bytesLettereAccentateCPWin, "UTF-8");

            if (a1.equals(a2)) {
                System.out.println("OK. Len = " + a1.length() + " Val = " + lettereAccentate);
            }
        }
        catch (Exception exc) {
            System.out.println("Exception caught");
        }
    }
}
