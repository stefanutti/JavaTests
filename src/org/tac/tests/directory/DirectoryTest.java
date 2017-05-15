package org.tac.tests.directory;

import java.io.File;

public class DirectoryTest
{
    public static void main(String[] argv)
    {
        File objFile = new File(new String("."));
        File[] aobjFiles = null;

        System.out.println(objFile.getAbsolutePath() + " contains:");
        System.out.println("canWrite?: " + objFile.canWrite());

        aobjFiles = objFile.listFiles();

        for (int iFiles = 0; iFiles < aobjFiles.length; iFiles++) {
            System.out.println("- " + aobjFiles[iFiles].getName());
        }
    }
}
