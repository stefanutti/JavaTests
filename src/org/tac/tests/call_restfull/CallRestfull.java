package org.tac.tests.call_restfull;

import java.io.*;
import java.net.*;

public class CallRestfull {

    public static void main(String[] args) throws IOException {
        URL url = new URL("http://3taps.net/search");
        String query = "get";

        // make connection
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxy.reply.it", 8080));
        URLConnection urlc = url.openConnection(proxy);

        // use post mode
        urlc.setDoOutput(true);
        urlc.setAllowUserInteraction(false);

        // send query
        PrintStream ps = new PrintStream(urlc.getOutputStream());
        ps.print(query);
        ps.close();

        // get result
        BufferedReader br = new BufferedReader(new InputStreamReader(urlc.getInputStream()));
        String l = null;
        while ((l = br.readLine()) != null) {
            System.out.println(l);
        }
        br.close();
    }
}