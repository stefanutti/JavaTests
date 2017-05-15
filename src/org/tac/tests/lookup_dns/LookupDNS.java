package org.tac.tests.lookup_dns;

import java.net.InetAddress;

class LookupDNS
{
    public static void main(String[] args) throws Exception
    {
        System.out.println("Starting LookupDNS...");

        InetAddress[] inets = InetAddress.getAllByName("fesid.ve.tim.it");

        for (int i = 0; i < inets.length; i++) {
            System.out.println(inets[i].toString());
        }
    }
}
