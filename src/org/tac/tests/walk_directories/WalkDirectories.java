package org.tac.tests.walk_directories;

import java.io.*;

public class WalkDirectories
{
    public static void visit(File f)
    {
        System.out.println(f);
    }

    public static void walk(File f)
    {
        visit(f);

        if (f.isDirectory()) {
            String[] list = f.list();

            for (int i = 0; i < list.length; i++) {
                walk(new File(f, list[i]));
            }
        }
    }

    public static void main(String[] args)
    {
        File[] list = File.listRoots();

        for (int i = 0; i < list.length; i++) {
            if (list[i].exists()) {
                walk(list[i]);
            }
            else {
                System.err.println("not accessible:" + list[i]);
            }
        }
    }
}
