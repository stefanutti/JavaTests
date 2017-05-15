package org.tac.tests.test_date;

import java.util.Date;

class TestDate
{
    public static void main(String[] s)
    {
        Date data_now = new Date();
        System.out.println(data_now.toString());

        Date data_a = new Date(97, 11, 31);
        Date data_b = new Date(97, 11, 31);

        System.out.println(data_a.toString());
        System.out.println(data_b.toString());

        data_a = data_b;
        data_b.setYear(100);

        System.out.println(data_a.toString());
        System.out.println(data_b.toString());
    }
}
