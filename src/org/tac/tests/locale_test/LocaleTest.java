package org.tac.tests.locale_test;

class LocaleTest
{
    public static void main(String[] args)
    {
        String testo = "lettera è";

        System.out.println("file.encoding = ISO-8859-1");
        System.setProperty("file.encoding", "ISO-8859-1");

        byte[] testo1Bytes = testo.getBytes();

        for (int iLoop = 0; iLoop < testo1Bytes.length; iLoop++) {
            int b = ((int) testo1Bytes[iLoop]) & 0xFF;
            System.out.println("Byte [" + iLoop + "] = " + b);
        }

        System.out.println("file.encoding = UTF-8");
        System.setProperty("file.encoding", "UTF-8");

        byte[] testo2Bytes = testo.getBytes();

        for (int iLoop = 0; iLoop < testo2Bytes.length; iLoop++) {
            int b = ((int) testo2Bytes[iLoop]) & 0xFF;
            System.out.println("Byte [" + iLoop + "] = " + b);
        }
    }
}
