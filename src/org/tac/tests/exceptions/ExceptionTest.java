package org.tac.tests.exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ExceptionTest
{
    /**
     * Creates a new ExceptionTest object.
     */
    public ExceptionTest()
    {
        System.out.println("Constructor");
    }

    public static void main(String[] argv)
    {
        System.out.println("Main");

        try {
            System.out.println("try: begin");

            FileReader oFile = new FileReader("./src/org/tac/tests/exceptions/NotAFile.txt");
            System.out.println("try: end");
        }
        // This catches that no file has been found with reading permissions
        // It means that the program goes into this exception also when the file
        // has no read permission
        //
        catch (FileNotFoundException oFileNotFoundException) {
            System.out.println("catch: FileNotFoundException: " + oFileNotFoundException);
        }
        catch (Exception oException) {
            System.out.println("catch: Exception: " + oException);
        }
    }
}
