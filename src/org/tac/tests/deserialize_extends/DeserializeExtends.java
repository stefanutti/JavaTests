package org.tac.tests.deserialize_extends;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.HashMap;

class DeserializeExtends
{
    public static void main(final String[] args) throws Exception
    {
        Map mapToWrite = new HashMap();

        try {
            // Prepare the map
            //
            mapToWrite.put("key_01","key_01_value");
            mapToWrite.put("key_02","key_02_value");
            mapToWrite.put("key_03", "abc".getBytes());

            writeSerializedObject(mapToWrite);
        }
        catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
        catch (IOException ioException) {
            ioException.printStackTrace();
        }

        Map mapReadFromDisk = null;

        try {
            mapReadFromDisk = readSerializedObject();

            // Dump the map
            //
            System.out.println("Debug: key_01 = " + mapReadFromDisk.get("key_01"));
            System.out.println("Debug: key_02 = " + mapReadFromDisk.get("key_02"));
            System.out.println("Debug: key_03 = " + mapReadFromDisk.get("key_03"));

            byte[] bytesToRead = (byte[]) mapReadFromDisk.get("key_03");
            for (int i = 0; i < bytesToRead.length; i++) {
                System.out.println("key_03[" + i + "]" + " = " + bytesToRead[i]);
            }
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
    }

    private static Map readSerializedObject() throws FileNotFoundException, IOException, ClassNotFoundException
    {
        // Reconstruct the IBData from the message arrived
        //
        InputStream inputStream = new FileInputStream("./src/org/tac/tests/deserialize_extends/map.serialized");
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        Map mapToReturn = (Map) objectInputStream.readObject();
        inputStream.close();

        return mapToReturn;
    }

    private static void writeSerializedObject(final Map mapToWrite) throws FileNotFoundException, IOException
    {
        OutputStream outputStream = new FileOutputStream("./src/org/tac/tests/deserialize_extends/map.serialized");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        objectOutputStream.writeObject(mapToWrite);
        objectOutputStream.flush();
        outputStream.close();
    }
}
