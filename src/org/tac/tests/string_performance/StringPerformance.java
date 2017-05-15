package org.tac.tests.string_performance;

import java.util.*;

public class StringPerformance
{
    private static final int NUMBER_OF_STRINGS_TO_CREATE = 1000;

    // length of ArrayList objects
    static final int MAXLISTLEN = 10000;

    // maximum value in Integer object
    static final int MAXNUM     = 99;

    // cache of formatted strings for small integers
    static String[]  cache      = new String[MAXNUM + 1];

    // fill cache at program startup
    static {
        for (int i = 0; i <= MAXNUM; i++) {
            cache[i] = Integer.toString(i);
        }
    }

    // local version of toString, that uses the cache
    static String localtoString(List list)
    {
        StringBuffer sb = new StringBuffer();
        sb.append("[");

        int size = list.size();

        for (int i = 0; i < size; i++) {
            Integer iobj = (Integer) list.get(i);
            sb.append(cache[iobj.intValue()]);

            if ((i + 1) < size) {
                sb.append(", ");
            }
        }

        sb.append("]");

        return sb.toString();
    }

    public static void main(String[] args)
    {
        Random random = new Random(0);

        List list = new ArrayList();

        // fill list with random Integer values 0-99
        for (int i = 1; i <= MAXLISTLEN; i++) {
            int r = random.nextInt(MAXNUM + 1);
            list.add(new Integer(r));
        }

        String s1 = null;
        String s2 = null;

        // do timing of standard approach
        long currtime = System.currentTimeMillis();

        for (int i = 1; i <= NUMBER_OF_STRINGS_TO_CREATE; i++) {
            s1 = list.toString();
        }

        long elapsed = System.currentTimeMillis() - currtime;
        System.out.println("standard toString time = " + elapsed);

        // do timing of custom approach
        currtime = System.currentTimeMillis();

        for (int i = 1; i <= NUMBER_OF_STRINGS_TO_CREATE; i++) {
            s2 = localtoString(list);
        }

        elapsed = System.currentTimeMillis() - currtime;
        System.out.println("local toString time = " + elapsed);

        // check to make sure same strings are produced
        if (!s1.equals(s2)) {
            System.out.println("error");
        }

        System.out.println("END");
    }
}
