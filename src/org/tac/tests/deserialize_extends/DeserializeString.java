package org.tac.tests.deserialize_extends;

import java.io.*;

class DeserializeString
{
    public static void main(String[] args) throws Exception
    {
        String stringToWrite = new String("Prova di serializzazione stringa = è");

        try {
            writeSerializedObject(stringToWrite);
        }
        catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
        catch (IOException ioException) {
            ioException.printStackTrace();
        }

        String stringRead = null;

        try {
            stringRead = readSerializedObject();
        }
        catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
        catch (IOException ioException) {
            ioException.printStackTrace();
        }
        catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }

        // Dump the IBData received
        //
        System.out.println("String read = " + stringRead);
    }

    private static String readSerializedObject() throws FileNotFoundException, IOException, ClassNotFoundException
    {
        // Reconstruct the IBData from the message arrived
        //
        InputStream inputStream = new FileInputStream("./src/org/tac/tests/deserialize_extends/string.serialized");
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        String inputIBData = (String)objectInputStream.readObject();
        inputStream.close();

        return inputIBData;
    }

    private static void writeSerializedObject(String ibData) throws FileNotFoundException, IOException
    {
        OutputStream outputStream = new FileOutputStream("./src/org/tac/tests/deserialize_extends/string.serialized");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        objectOutputStream.writeObject(ibData);
        objectOutputStream.flush();
        outputStream.close();
    }
}
