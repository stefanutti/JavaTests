package org.tac.tests.file_test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Mario Test to read files
 */
/**
 * @author mario
 *
 * <code>$Id$</code>
 */
class FileTest
{
    private static final int HEX_MAX = 16;

    public static void main(String[] args)
    {
        System.out.println("Starting FileTest ...");
        System.out.println("");

        try {
        	String fileName = "./src/org/tac/tests/file_test/Test.txt";
            FileOutputStream file = new FileOutputStream(fileName, true);

            System.out.println("--------------------------------");
            System.out.println("Get methods of FileOutputStream:");
            System.out.println("--------------------------------");
            System.out.println("toString() = " + file.toString());
            System.out.println("getFD() = " + file.getFD());
            System.out.println("getChannel() = " + file.getChannel().toString());
            System.out.println("getClass() = " + file.getClass().toString());

            System.out.println("------");
            System.out.println("Writes");
            System.out.println("------");
            file.write("Test di scrittura\n".getBytes());
            file.write("Test di scrittura\n".getBytes());

            System.out.println("--------");
            System.out.println("dumpHex:");
            System.out.println("--------");
            dumpHex(fileName);
        }
        catch (FileNotFoundException exc) {
            System.out.println("FileNotFoundException cought");
            exc.printStackTrace();
        }
        catch (Exception exc) {
            System.out.println("Exception cought");
            exc.printStackTrace();
        }

        System.out.println("");
        System.out.println("Ending FileTest ...");
    }

    /**
     * @param filename
     */
    public static void dumpHex(String filename)
    {
        FileInputStream fin = null;
        byte[] buffer = new byte[24];
        boolean end = false;
        int bytesRead;

        try {
            fin = new FileInputStream(filename);

            while (!end) {
                bytesRead = 0;

                while (bytesRead < buffer.length) {
                    int r = fin.read(buffer, bytesRead, buffer.length - bytesRead);

                    if (r == -1) {
                        end = true;

                        break;
                    }

                    bytesRead += r;
                }

                printArray(buffer, bytesRead);

                System.out.println();
            }
        }
        catch (IOException e) {
            System.err.println(e);
        }
        catch (Exception e) {
            System.err.println(e);
        }
        finally {
            try {
                if (fin != null) {
                    fin.close();
                }
            }
            catch (IOException e) {
            }
        }
    }

    private static void printArray(byte[] buffer, int bytesRead)
    {
        for (int i = 0; i < bytesRead; i++) {
            int sHex = buffer[i];

            if (sHex < 0) {
                sHex = 256 + sHex;
            }

            if (sHex >= HEX_MAX) {
                System.out.print(Integer.toHexString(sHex) + " ");
            }
            else {
                System.out.print("0" + Integer.toHexString(sHex) + " ");
            }
        }
    }

    /**
     * DOCUMENT ME!
     * 
     * @param filename
     *        DOCUMENT ME!
     */
    public static void newDumpHex(String filename)
    {
    }
}
